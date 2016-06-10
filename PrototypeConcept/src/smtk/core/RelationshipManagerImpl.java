package smtk.core;


import javax.ejb.Stateless;
import java.sql.*;

/**
 * Created by stk-des01 on 07-06-16.
 */
@Stateless
public class RelationshipManagerImpl implements RelationshipManagerInterface {

    String driver = "org.postgresql.Driver";
    String ruta = "jdbc:postgresql://192.168.0.221:5432/postgres";
    String user = "postgres";
    String password = "1q2w3e";

    @Override
    public void addRelationshipToConcept(int idRelationType, String idConceptOrigin, int idConceptDestination, int idAttribute, String value, int order) {
        //System.out.println("addRelationshipToConcept: "+idRelationType+" "+idConceptOrigin+" "+idConceptDestination+" "+value+" "+order);

        try {
            Class.forName(driver);
            Connection conne = (Connection) DriverManager.getConnection(ruta, user, password);
            CallableStatement call = conne.prepareCall("{call add_relacion_concepto(?,?,?,?,?,?)}");

            call.setInt(1,idRelationType);
            call.setInt(2,Integer.parseInt(idConceptOrigin));
            if(idConceptDestination!=0) {
                call.setInt(3, idConceptDestination);
            }else{
                call.setNull(3,Types.INTEGER);}
            call.setInt(4,idAttribute);
            if(value!=null) {
                call.setString(5, value);
            }else{
                call.setNull(5, Types.VARCHAR);}
            if(order!=0) {
                call.setInt(6, order);
            }else{
                call.setNull(6,Types.INTEGER);}

            call.execute();

            conne.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
            System.out.println(e.getLocalizedMessage());
        }


    }

    @Override
    public int getIDAttribute(int idCategory, int idRelationType) {
        int idAttribute=0;
        try {
            Class.forName(driver);
            Connection conne = (Connection) DriverManager.getConnection(ruta, user, password);
            CallableStatement call = conne.prepareCall("{call get_attribute_by_idcategoria_idrelationtype(?,?)}");

            call.setInt(1,idCategory);
            call.setInt(2,idRelationType);
            call.execute();

            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                idAttribute = Integer.parseInt(rs.getString(1));
            }
            conne.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return idAttribute;
    }
}
