package smtk.servlet;

import smtk.classes.AttributeCategory;
import smtk.classes.Category;
import smtk.core.CategoryManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 09-06-16.
 */

@WebServlet("addcategory")
public class addCategory extends HttpServlet{

    CategoryManagerImpl categoryManager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        categoryManager = new CategoryManagerImpl();

        Category category= new Category();
        category.setName(req.getParameter("nameCategory"));
        category.setValid(true);
        category.setAttributeCategories(new ArrayList<AttributeCategory>());


        String nameAttribute;
        String idAttributeRel;
        int categoryDes;
        String typeAtt;
        String orderAtt;
        int multiplicity;
        int count=1;

        while(req.getParameter("idRel"+count)!=null){
            if(req.getParameter("idRel"+count).length()!=0){
                idAttributeRel=req.getParameter("idRel"+count);
                orderAtt=req.getParameter("orden"+count);
                category.getAttributeCategories().add(new AttributeCategory(idAttributeRel,null, null,0, null, true, 0, orderAtt));
            }else{
                nameAttribute=req.getParameter("name"+count);;
                if(req.getParameter("categoryDes"+count)!=null){
                    categoryDes=Integer.parseInt(req.getParameter("categoryDes"+count));
                }else{
                    categoryDes=0;
                }

                typeAtt=req.getParameter("idTipo"+count);
                orderAtt=req.getParameter("orden"+count);
                multiplicity=Integer.parseInt(req.getParameter("multiplicidad"+count));
                category.getAttributeCategories().add(new AttributeCategory(null,nameAttribute, typeAtt,multiplicity, null, true, categoryDes, orderAtt));
            }
            count++;
        }

        categoryManager.addCategory(category);



    }
}
