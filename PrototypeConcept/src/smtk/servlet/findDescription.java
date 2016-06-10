package smtk.servlet;


import smtk.classes.Description;
import smtk.core.ConceptManagerImpl;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 01-06-16.
 */
@WebServlet("findDescription")
public class findDescription extends HttpServlet{


    private ConceptManagerImpl conceptManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pattern = req.getParameter("pattern");
        ArrayList<Description> descriptions;
        conceptManager=new ConceptManagerImpl();
        descriptions=conceptManager.findDescriptionForPattern(pattern);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.append("<ListOptions>");
        for (int i = 0; i < descriptions.size(); i++) {
            writer.append("<options>");
            writer.append("<option>").append(descriptions.get(i).getTermino()).append("</option>");
            writer.append("<value>").append(""+descriptions.get(i).getId()).append("</value>");
            writer.append("</options>");

        }
        writer.append("</ListOptions>");



    }
}
