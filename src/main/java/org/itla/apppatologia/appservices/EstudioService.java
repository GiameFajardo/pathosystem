/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.EstudioDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Patologo;
import org.itla.apppatologia.Repository.TipoEstudio;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class EstudioService implements IEstudioAppService{

    private Contexto contexto;
    private EntityManager entityManager ;
    private Estudio estudio;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listEstudiosType;
    
    public EstudioService(){
        contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listEstudiosType = new TypeToken<List<EstudioDTO>>() {}.getType();
    }
    @Override
    public EstudioDTO InsertarEstudio(EstudioDTO _estudio) {
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        estudio = new Estudio();
        try {
           
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (estudio!=null) {
                estudio.setFecha(_estudio.getFecha());
                estudio.setIdfragmentoFragmento(entityManager.find(Fragmento.class, _estudio.getIdfragmentoFragmento()));
                estudio.setIdpatologoPatologo(entityManager.find(Patologo.class, _estudio.getIdpatologoPatologo()));
                estudio.setIdtipoEstudioTipoEstudio(entityManager.find(TipoEstudio.class, _estudio.getIdtipoEstudioTipoEstudio()));
                estudio.setNumReclamacion(_estudio.getNumReclamacion());
                entityManager.persist(estudio);
                entityManager.flush();
                //estudio = entityManager.merge(estudio);
                //entityManager.refresh(estudio);
                
            }else{
                throw new NullPointerException("El estudio no puede ser nulo");
            }
            entityTransaction.commit();
//            entityManager.close();
//            entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
//        
//            entityTransaction = entityManager.getTransaction();
//            try {
//                entityTransaction.begin();
//                
//                entityManager.merge(estudio);
//                int idCaso=0;
//                Collection<Caso> casos = estudio.getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
//                for (Caso caso : casos) {
//                    if(caso.getIdfragmento()==estudio.getIdfragmentoFragmento().getIdfragmento()){
//                        idCaso = caso.getIdcaso();
//                    }
//                }
//                
//                Caso caso;
//                caso = entityManager.find(Caso.class, idCaso);
//                if(!estudio.getObservacionCollection().isEmpty()){
//                    caso.setEstado("OBSERVACION");
//                    entityManager.persist(caso);
//                }else{
//                    caso.setEstado("ASIGNADO");
//                    entityManager.persist(caso);
//                }
//                
//                entityTransaction.commit();
//            } catch (Exception e) {
//                if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//            }
           // entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        _estudio.setIdestudio(estudio.getIdestudio());
        return _estudio;
    }

    @Override
    public EstudioDTO ActualizarEstudio(EstudioDTO _estudio) {
        //Busqueda del caso
        estudio = entityManager.find(Estudio.class, _estudio.getIdestudio());
        
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
           
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (estudio!=null) {
                estudio.setFecha(_estudio.getFecha());
                estudio.setIdfragmentoFragmento(entityManager.find(Fragmento.class, _estudio.getIdfragmentoFragmento()));
                estudio.setIdpatologoPatologo(entityManager.find(Patologo.class, _estudio.getIdpatologoPatologo()));
                estudio.setIdtipoEstudioTipoEstudio(entityManager.find(TipoEstudio.class, _estudio.getIdtipoEstudioTipoEstudio()));
                estudio.setNumReclamacion(_estudio.getNumReclamacion());
                
                entityManager.refresh(estudio);
                
//                int idCaso=0;
//                Collection<Caso> casos = estudio.getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
//                for (Caso caso : casos) {
//                    if(caso.getIdfragmento()==estudio.getIdfragmentoFragmento().getIdfragmento()){
//                        idCaso = caso.getIdcaso();
//                    }
//                }
//                
//                
//                entityManager.persist(estudio);
//                
//                
//                entityManager.flush();
//                Caso caso;
//                caso = entityManager.find(Caso.class, idCaso);
//                if(idCaso>0)
//                if(!estudio.getObservacionCollection().isEmpty()){
//                    caso.setEstado("OBSERVACION");
//                    entityManager.persist(caso);
//                }else{
//                    caso.setEstado("ASIGNADO");
//                    entityManager.persist(caso);
//                }
                
            }else{
                throw new NullPointerException("El estudio no puede ser nulo");
            }
            entityTransaction.commit();
           // entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        _estudio.setIdestudio(estudio.getIdestudio());
        return _estudio;
    }

    @Override
    public int GuardarEstudio(EstudioDTO _estudio) {
        EstudioDTO estudio;
        if(_estudio.getIdestudio()>0){
            estudio = ActualizarEstudio(_estudio);
        }else{
            estudio = InsertarEstudio(_estudio);
        }
        return estudio.getIdestudio();
    }

    @Override
    public boolean BorrarEstudio(EstudioDTO _estudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarEstudio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarEstudio(EstudioDTO _estudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarEstudio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarEstudio(EstudioDTO _estudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarEstudio(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstudioDTO GetPorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstudioDTO> GetTodosEstudios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstudioDTO> GetTodasEstudioPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
