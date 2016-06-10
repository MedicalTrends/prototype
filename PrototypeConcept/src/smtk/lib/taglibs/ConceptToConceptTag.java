package smtk.lib.taglibs;

import smtk.classes.AttributeCategory;
import smtk.core.CategoryManagerImpl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 02-06-16.
 */
public class ConceptToConceptTag extends TagSupport {


    public int IdCategoria;

    @Override
    public int doStartTag() throws JspException {
        IdCategoria = Integer.parseInt(pageContext.getRequest().getParameter("categoria"));
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {

        JspWriter out = pageContext.getOut();

        CategoryManagerImpl categoryManager = new CategoryManagerImpl();

        ArrayList<AttributeCategory> AC;

        AC = categoryManager.findDescriptionByIDConcept(IdCategoria);
        int contador=1;
        try {
            for (int i = 0; i < AC.size(); i++) {

                if (AC.get(i).getDescription().equals("8001")) {
                    out.println("<input class=\"hidden\" name=\"relacion"+i+"\" value=\""+AC.get(i).getDescription()+"\"/>");
                    out.println("<input class=\"hidden\" name=\"idA"+i+"\" value=\""+AC.get(i).getId()+"\"/>");
                    out.println("<input class=\"hidden\" name=\"multiplicidad"+i+"\" value=\""+AC.get(i).getMultiplicity()+"\"/>");
                    if (AC.get(i).getMultiplicity()!=0) {


                        out.println("<div class=\"panel panel-default\">");
                        out.println("<div class=\"panel-heading\">" + AC.get(i).getName() + "</div>");
                        out.println("<div class=\"panel-body\">");
                        out.println("<div class=\"input-group\">");
                        out.println("<input class=\"hidden\" name=\"idcategoria\" value=\""+IdCategoria+"\"/>");
                        out.println("<input class=\"hidden\" id=\"idDescription"+i+"\"  name=\"idDescription"+i+"\" value=\"\"/>");
                        out.println("<input class=\"form-control\" id=\"pattern" + i + "\" onkeyup=\"findConcept('mySelect" + i + "','pattern" + i + "')\" type='text' required/> ");
                        out.println("<span class=\"input-group-addon\" ><span class=\"glyphicon glyphicon-search\" ></span></span>");
                        out.println("</div>");
                        out.println("<select style=\"visibility:hidden; width=71.7%; position:absolute;\" class=\"form-control\" onchange=\"selectConcept('mySelect" + i + "','pattern" + i + "','idDescription"+i+"')\" id=\"mySelect" + i + "\" size=0 ></select><br/>");
                        out.println("</div>");
                        out.println("</div>");
                    }else{

                        out.println("<div class=\"panel panel-default\">");
                        out.println("<div class=\"panel-heading\">" + AC.get(i).getName() + "</div>");
                        out.println("<div class=\"panel-body\">");

                        out.println("<div class= \"container col-sm-12\">");

                        out.println("<div class=\"col-sm-4\">");
                        out.println("<div class=\"input-group\">");
                        out.println("<input class=\"form-control\" id=\"pattern" + i + "\" onkeyup=\"findConcept('mySelect" + i + "','pattern" + i + "')\" type='text' /> ");
                        out.println("<span class=\"input-group-addon\" ><span class=\"glyphicon glyphicon-search\" ></span></span>");
                        out.println("</div>");
                        out.println("<select style=\"visibility:hidden; width=71.7%; position:absolute;\" class=\"form-control\" onchange=\"selectConcept('mySelect" + i + "','pattern" + i + "','idDescription"+i+"')\" id=\"mySelect" + i + "\" size=0 ></select><br/>");

                        out.println("</div>");

                        out.println("<div class=\"col-sm-2\">");
                        out.println("<input id=\"orden"+i+"\" placeholder=\"Orden (*)\" class=\"form-control\"/>");
                        out.println("</div>");

                        out.println("<div class=\"col-sm-3\">");
                        out.println("<label class=\"radio-inline\">\n" +
                                "                        <input type=\"radio\" name=\"nombreAuto"+i+"\"  value=\"Vigente\"> Vigente\n" +
                                "                    </label>\n" +
                                "                    <label class=\"radio-inline\">\n" +
                                "                        <input type=\"radio\" name=\"nombreAuto"+i+"\"  value=\"No Vigente\"> No vigente\n" +
                                "                    </label>");
                        out.println("</div>");

                        out.println("<div class=\"col-sm-1\">");
                        out.println("<input class=\"btn btn-default\" onclick=\"addRelation('relacion"+i+"','pattern"+i+"','orden"+i+"','nombreAuto"+i+"','tabla["+contador+"]','idDescription"+i+"')\" value=\"Agregar\"/>");
                        out.println("<input class=\"hidden\" id=\"idDescription"+i+"\"  name=\"idDescription"+i+"\" value=\"\"/>");
                        out.println("</div>");

                        out.println("</div>");

                        out.println("<div class= \"container col-sm-12\">");
                        out.println("<div class= \"table-responsive\">");
                        out.println("<table id=\"relacion"+i+"\" class=\"table table-bordered table-condensed\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>Concepto</td>");
                        out.println("<td>Orden</td>");
                        out.println("<td>Estado</td>");
                        out.println("<td>Acción</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tr>");
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</div>");
                        out.println("</div>");


                        out.println("</div>");
                        out.println("</div>");
                        contador++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Problemas con el IO");
        }
        return super.doEndTag();
    }
}
