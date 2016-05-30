package smtk.lib.taglibs;

/**
 * Created by stk-des01 on 27-05-16.
 */

import smtk.classes.AttributeCategory;
import smtk.core.CategoryManagerImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

public class TypeBasicTag extends TagSupport {

    public int IdCategoria;

    @Override
    public int doStartTag() throws JspException {

        IdCategoria = Integer.parseInt(pageContext.getRequest().getParameter("categoria"));
        return EVAL_BODY_INCLUDE;


    }

    @Override
    public int doEndTag() throws JspException {

        JspWriter out = pageContext.getOut();

        String name="Numero categoría";

        CategoryManagerImpl categoryManager= new CategoryManagerImpl();

        ArrayList<AttributeCategory> AC = new ArrayList<AttributeCategory>();
        AC =categoryManager.findDescriptionByIDConcept(IdCategoria);
        BodyContent bc;
        try {

            for (int i = 0; i < AC.size(); i++) {
                if(AC.get(i).getDescription().equals("8005"))
                    if(AC.get(i).isRequired())
                        out.println(AC.get(i).getName()+" : <input required/><br/><br/>");
                    else
                        out.println(AC.get(i).getName()+" : <input /><br/><br/>");
            }
        }catch (Exception e){
            System.out.println("Problemas con el IO");
        }

        return super.doEndTag();
    }
}
