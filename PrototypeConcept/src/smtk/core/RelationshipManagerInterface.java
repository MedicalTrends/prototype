package smtk.core;

import javax.ejb.Local;

/**
 * Created by stk-des01 on 07-06-16.
 */

@Local
public interface RelationshipManagerInterface {

    public void addRelationshipToConcept(int idRelationType, String idConceptOrigin,int idConceptDestination, int idAttribute, String value, int order);

    public int getIDAttribute(int idCategory, int idRelationType);

}
