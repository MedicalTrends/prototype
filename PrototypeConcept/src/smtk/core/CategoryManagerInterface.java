package smtk.core;

import smtk.classes.AttributeCategory;
import smtk.classes.Category;

import javax.ejb.Local;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 27-05-16.
 */
@Local
public interface CategoryManagerInterface {

    public ArrayList<AttributeCategory> findDescriptionByIDConcept(int id);

    public ArrayList<AttributeCategory> getAllDescription();

    public ArrayList<Category> getAllCategory();

    public int addCategory(Category category);

    public void addAttribute(AttributeCategory attributeCategory, int idCategory);

    public int addTypeRelationship(String name, int typeRelation, int idCategoryDes, int multiplicity);



}
