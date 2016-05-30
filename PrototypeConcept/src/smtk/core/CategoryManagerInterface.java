package smtk.core;

import smtk.classes.AttributeCategory;

import java.util.ArrayList;

/**
 * Created by stk-des01 on 27-05-16.
 */
public interface CategoryManagerInterface {

    public ArrayList<AttributeCategory> findDescriptionByIDConcept(int id);

}
