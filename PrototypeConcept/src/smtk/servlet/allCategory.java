package smtk.servlet;

import smtk.classes.Category;
import smtk.core.CategoryManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 06-06-16.
 */
@WebServlet("allCategory")
public class allCategory extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pattern = req.getParameter("pattern");
        ArrayList<Category> categories;
        CategoryManagerImpl categoryManager=new CategoryManagerImpl();
        categories=categoryManager.getAllCategory();
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.append("<categories>");
        for (int i = 0; i < categories.size(); i++) {
            writer.append("<options>");
            writer.append("<option>").append(categories.get(i).getName()).append("</option>");
            writer.append("<value>").append(categories.get(i).getId()+"").append("</value>");
            writer.append("</options>");
        }
        writer.append("</categories>");

    }
}
