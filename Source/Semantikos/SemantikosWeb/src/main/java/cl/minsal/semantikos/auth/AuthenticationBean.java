package cl.minsal.semantikos.auth;

import cl.minsal.semantikos.Constants;
import cl.minsal.semantikos.config.ConfigurationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Francisco Mendez on 19-05-2016.
 */
@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthenticationBean {

    static public final String AUTH_KEY = "bp.session.user";

    static private final Logger logger = LoggerFactory.getLogger(AuthenticationBean.class);



    @EJB(name = "AuthenticationManagerEJB")
    private AuthenticationManagerBean authenticationManager;

    @EJB
    private ConfigurationBean configuration;

    private String username;
    private String password;

    private User loggedUser;


    public boolean isLoggedIn() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(AUTH_KEY) != null;
    }


    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }


    public void login() {
        try {
            //valida user y pass
            if(!authenticationManager.authenticate(username,password)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos Incorrectos!", "Nombre de usuario y/o contraseña incorrecta."));
                return;
            }

            //quitar password de la memoria
            password=null;


            //poner datos de usuario en sesion
            loggedUser = authenticationManager.getUserDetails(username);
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.getSessionMap().put(AUTH_KEY, username);

            //redirigir a pagina de inicio
            context.redirect(context.getRequestContextPath() + Constants.HOME_PAGE);

            logger.info("Usuario [{}] ha iniciado sesión."+username);


        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error intentando redirigir usuario a página de Inicio.", e.getMessage()));
            logger.error("Error intentando redirigir usuario a página de inicio {}", Constants.HOME_PAGE , e);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Ingresar!", e.getMessage()));
            logger.error("Error trying to login", e);
        }
    }

    private boolean canLogin(User loggedUser) {
        return !(loggedUser == null || loggedUser.getUsername() == null);
    }

    public void logout() {
        logger.info("Usuario: " + username + " ha cerrado su sesión.");

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.getSessionMap().remove(AUTH_KEY);

        username = null;
        password = null;
        loggedUser = null;

        try {
            context.redirect(context.getRequestContextPath() + "/" +Constants.VIEWS_FOLDER+ "/" + Constants.LOGIN_PAGE );
        } catch (IOException e) {
            logger.error("Error en logout", e);
        }

    }

    public void testException() {
        logger.debug("Throwing test exception");
        throw new RuntimeException("This is a test exception");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }



}
