package smtk.servlet;

import smtk.core.ConceptManagerImpl;
import smtk.core.DescriptionManagerImpl;
import smtk.core.RelationshipManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stk-des01 on 07-06-16.
 */
@WebServlet("addConcept")
public class addConceptFromForm extends HttpServlet{

    private ConceptManagerImpl conceptManager;
    private DescriptionManagerImpl descriptionManager;
    private RelationshipManagerImpl relationshipManager;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        long time_start, time_end;
        time_start = System.currentTimeMillis();


        conceptManager= new ConceptManagerImpl();
        descriptionManager= new DescriptionManagerImpl();
        relationshipManager = new RelationshipManagerImpl();
        int cont = 1;
        int contT = 1;
        String idConcepto=null,tipo=null, termino=null, terminoFSN=null, terminoPreferido=null, idCategoria=req.getParameter("idcategoria");

        //Agregar concepto

        idConcepto=conceptManager.addConcept(idCategoria,true);

        //Agregar descripciones al concepto

        terminoFSN=req.getParameter("FSN");
        terminoPreferido=req.getParameter("Preferida");

        descriptionManager.addDescriptionToConcept(idConcepto,terminoFSN,descriptionManager.getIdDescription("FSN"));
        descriptionManager.addDescriptionToConcept(idConcepto,terminoPreferido,descriptionManager.getIdDescription("PREFERIDO"));

        while(req.getParameter("termino"+cont)!=null){
            termino=req.getParameter("termino"+cont);
            tipo=descriptionManager.getIdDescription(req.getParameter("tipo"+cont));
            descriptionManager.addDescriptionToConcept(idConcepto,termino,tipo);
            cont++;
        }

        //Agregar datos de las relaciones
        cont=0;
        int cont2=1, cont3=0,idAtt, idConDes=0, idTypeRelation,multiplicity;

        while(req.getParameter("relacion"+cont)!=null){

            //System.out.println("relacion"+cont);

            idAtt=relationshipManager.getIDAttribute(Integer.parseInt(idCategoria),Integer.parseInt(req.getParameter("idA" + cont)));
            idTypeRelation=Integer.parseInt(req.getParameter("relacion"+cont));
            multiplicity=Integer.parseInt(req.getParameter("multiplicidad" + cont));

            //System.out.println("relacion: "+idTypeRelation+" multiplicidad: "+multiplicity+ " IDA "+req.getParameter("idA" + cont)+" contador:"+cont);


            if (idTypeRelation==8005) {
                if (multiplicity != 0) {
                    for (int i = 0; i < multiplicity; i++) {
                        relationshipManager.addRelationshipToConcept(idTypeRelation, idConcepto, 0, idAtt, req.getParameter("tipoBasico" + cont2), 0);
                        cont2++;
                    }
                } else {
                    while (req.getParameter("dataTable" + cont + "dato" + cont3) != null) {
                        relationshipManager.addRelationshipToConcept(idTypeRelation, idConcepto, 0, idAtt, req.getParameter("dataTable" + cont + "dato" + cont3), 0);
                        cont3++;
                    }
                    cont3 = 0;
                }

            }else{
                if(req.getParameter("idDescription" +cont)!="" && req.getParameter("idDescription" +cont)!=null){
                    idConDes=conceptManager.getIDConceptBy(Integer.parseInt(req.getParameter("idDescription" +cont)));
                }

                if(Integer.parseInt(req.getParameter("multiplicidad" + cont)) != 0){
                    relationshipManager.addRelationshipToConcept(idTypeRelation, idConcepto, idConDes, idAtt, null, 0);
                }else{

                    cont3 = 1;
                    //System.out.println("tabla[" + contT + "]dato[" + cont3+"]");
                    while (req.getParameter("tabla[" + contT + "]dato[" + cont3+"]") != null){

                        relationshipManager.addRelationshipToConcept(idTypeRelation, idConcepto, conceptManager.getIDConceptBy(Integer.parseInt( req.getParameter("tabla[" + contT + "]dato[" + cont3+"]"))), idAtt, null, 0);

                        cont3++;
                    }

                    contT++;
                    cont3 = 0;

                }

            }
            cont++;
        }




        time_end = System.currentTimeMillis();
        System.out.println("Diferencia de tiempo conceptos"+ ( time_end - time_start ) +" milliseconds");



    }
}
