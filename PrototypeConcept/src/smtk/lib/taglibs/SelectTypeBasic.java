package smtk.lib.taglibs;

import smtk.classes.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 03-06-16.
 */
public class SelectTypeBasic extends TagSupport {


    private String message;

    public void setMessage(String msg) {
        this.message = msg;
    }

    private String message2;

    public void setMessage2(String msg) {
        this.message2 = msg;
    }

    @Override
    public int doEndTag() throws JspException {
        BodyContent bd;
        JspWriter out = pageContext.getOut();

        try {

            out.println("<select class=\"form-control\">");
            out.println("<option>Texto</option>");
            out.println("<option>Número entero</option>");
            out.println("<option>Bolean</option>");
            out.println("<option>Decimal</option>");
            out.println("</select>");
        } catch (Exception e) {
            System.out.println("Problemas con el IO");
        }

        return super.doEndTag();
    }
}
