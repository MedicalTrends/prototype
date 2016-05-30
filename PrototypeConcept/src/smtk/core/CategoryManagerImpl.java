package smtk.core;

import smtk.classes.AttributeCategory;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by stk-des01 on 27-05-16.
 */
public class CategoryManagerImpl implements CategoryManagerInterface {
    @Override
    public ArrayList<AttributeCategory> findDescriptionByIDConcept(int id) {


        String driver = "org.postgresql.Driver";
        String ruta = "jdbc:postgresql://192.168.0.221:5432/postgres";
        String user = "postgres";
        String password = "1q2w3e";

        ArrayList <AttributeCategory> Attributes= new ArrayList<AttributeCategory>();


        try {
            Class.forName(driver);
            Connection conne = (Connection) DriverManager.getConnection(ruta, user, password);
            CallableStatement call = conne.prepareCall("{call get_conf_rel(?)}");

            call.setInt(1,id);
            call.execute();

            ResultSet rs=call.getResultSet();

            int idA;
            String name;
            int multiplicity;
            String description;
            boolean required;


            while(rs.next()){
                idA=Integer.parseInt(rs.getString("reltype"));
                name=rs.getString("name");
                multiplicity=Integer.parseInt(rs.getString("multiplicidad"));
                description=rs.getString("idLugar");
                required=true;

                Attributes.add(new AttributeCategory(idA,name,multiplicity,description,required));

            }



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        return Attributes;
    }
}
