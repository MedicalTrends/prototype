package smtk.lib.taglibs;

/**
 * Created by stk-des01 on 27-05-16.
 */

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

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

        try {
            out.println(name + ":" +IdCategoria);

        }catch (Exception e){
            System.out.println("Problemas con el IO");
        }

        return super.doEndTag();
    }
}
