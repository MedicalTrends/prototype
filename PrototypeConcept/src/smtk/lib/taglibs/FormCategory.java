package smtk.lib.taglibs;

import smtk.classes.*;
import smtk.core.CategoryManagerImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 06-06-16.
 */
public class FormCategory extends TagSupport{


    @Override
    public int doEndTag() throws JspException {
        CategoryManagerImpl categoryManager = new CategoryManagerImpl();
        ArrayList<smtk.classes.AttributeCategory> AC;
        AC = categoryManager.getAllDescription();

        JspWriter out = pageContext.getOut();


        try {
            out.println("<div class=\"panel panel-default\">" );
            out.println("<div class=\"panel-body\">" );
            out.println("<div class=\"container\">" );
            out.println("<div class=\"col-sm-1\">" );
            out.println("<label>Nombre: </label>" );
            out.println("</div>" );
            out.println("<div class=\"col-sm-4\">" );
            out.println("<input id=\"nameCategory\" name=\"nameCategory\" class=\"form-control\"/>");
            out.println("</div>" );
            out.println("</div>" );
            out.println("<br/>");
            out.println("<h4>Relaciones</h4>" );
            out.println("<div class=\"container\">" );
            out.println("<div class=\"col-sm-3\">");

            out.println("<select id=\"selectRelationship\" class=\"form-control\">");
            for (int i = 0; i < AC.size(); i++) {
                out.println("<option value=\""+AC.get(i).getId()+"\">"+AC.get(i).getName()+"</option>");
            }

            out.println("</select>");
            out.println("</div>");
            out.println("<div class=\"col-sm-2\">" );
            out.println("<input id=\"orden\"placeholder=\"Orden (*)\" class=\"form-control\" />" );
            out.println("</div>"  );
            out.println("<div class=\"col-sm-2\">" );
            out.println("<input onclick=\"addRelationship('dataTableRelationship')\" class=\"btn btn-success btn-sm\" value=\"Agregar\" />" );
            out.println("</div>"  );
            out.println("<div class=\"col-sm-2\">");
            out.println("<input class=\"btn btn-info btn-sm\" id=\"myBtn\" value=\"Nuevo\" />" );
            out.println("</div>" );
            out.println("</div>" );
            out.println("<br/>" );
            out.println("<div class=\"container col-sm-12\">" );
            out.println("<div class=\"table-responsive\">" );
            out.println("<table id=\"dataTableRelationship\" class=\"table table-bordered table-condensed\">" );
            out.println("<thead>" );
            out.println("<tr>" );
            out.println("<td>Nombre</td>" );
            out.println("<td>Tipo relación</td>" );
            out.println("<td>Orden</td>" );
            out.println("<td>Multiplicidad</td>" );
            out.println("</tr>" );
            out.println("</thead>" );
            out.println("<tr>" );
            out.println("</tr>" );
            out.println("</table>" );
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

        } catch (Exception e) {
            System.out.println("Problemas con el IO");
        }

        return super.doEndTag();
    }
}
