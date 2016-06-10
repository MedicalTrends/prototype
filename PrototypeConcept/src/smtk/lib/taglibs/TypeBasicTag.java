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
        String name = "Numero categoría";
        CategoryManagerImpl categoryManager = new CategoryManagerImpl();

        ArrayList<AttributeCategory> AC;
        AC = categoryManager.findDescriptionByIDConcept(IdCategoria);
        try {
            out.println("<input class=\"hidden\" name=\"idcategoria\" value=\""+IdCategoria+"\"/>");
            int cont1, cont2 = 2, cont3=1;
            for (int i = 0; i < AC.size(); i++) {

                if (AC.get(i).getDescription().equals("8005")) {
                    out.println("<input class=\"hidden\" name=\"relacion"+i+"\" value=\""+AC.get(i).getDescription()+"\"/>");
                    out.println("<input class=\"hidden\" name=\"idA"+i+"\" value=\""+AC.get(i).getId()+"\"/>");
                    cont1 = AC.get(i).getMultiplicity();
                    out.println("<input class=\"hidden\" name=\"multiplicidad"+i+"\" value=\""+cont1+"\"/>");

                    if (cont1 != 0) {
                        while (cont1 > 0) {

                            if (cont1 == AC.get(i).getMultiplicity()) {
                                if (AC.get(i).isRequired())
                                    out.println("<div class=\"form-inline\"><label> "+AC.get(i).getName()+"</label>" + " : <input name=\"tipoBasico"+cont3+"\" class=\"form-control\" style=\"margin: 10px;\" required/></div>");
                                else
                                    out.println("<div class=\"form-inline\"><label> "+AC.get(i).getName()+"</label>" + " : <input name=\"tipoBasico"+cont3+"\" class=\"form-control\" style=\"margin: 10px;\" /></div>");
                                cont1--;
                            } else {
                                if (AC.get(i).isRequired())
                                    out.println("<div class=\"form-inline\"><label> "+AC.get(i).getName() + "  " + cont2+"</label>" + ": <input name=\"tipoBasico"+cont3+"\"  class=\"form-control\" style=\"margin: 10px;\" required/></div>");
                                else
                                    out.println("<div class=\"form-inline\"><label> "+AC.get(i).getName() + "  " + cont2 +"</label>"+ ": <input name=\"tipoBasico"+cont3+"\"  class=\"form-control\" style=\"margin: 10px;\" /></div>");
                                cont1--;
                                cont2++;

                            }
                            cont3++;
                        }
                    } else {
                        out.println("<input class=\"hidden\" name=\"largo"+i+"\" value=\"0\"/>");
                        out.println("<div class=\"panel panel-default\">");
                        out.println("<div class=\"panel-heading\">"+AC.get(i).getName()+"</div>");
                        out.println("<div class=\"panel-body\">");
                        out.println("<div class=\"col-sm-2\">");
                        out.println("<input class=\"form-control btn btn-success\" style=\"margin: 10px;\" type='button' value='Agregar' onclick=\"addRow('dataTable" + i + "')\" />");
                        out.println("</div>");
                        out.println("<table class=\"table table-bordered\" id='dataTable" + i + "'>");
                        out.println("<tr>");
                        out.println("</tr>");
                        out.println("</table><br/>");
                        out.println("</div>");
                        out.println("</div>");
                    }

                }
                cont2 = 2;
            }
        } catch (Exception e) {
            System.out.println("Problemas con el IO");
        }

        return super.doEndTag();
    }
}
