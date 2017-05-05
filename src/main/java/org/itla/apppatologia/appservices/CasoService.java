/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.CasoDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class CasoService implements ICasoAppService{

    private Contexto contexto;
    private final EntityManager entityManager ;
    private Caso caso;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listCasosType;
    
    public CasoService(){
        contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listCasosType = new TypeToken<List<CasoDTO>>() {}.getType();
    }
    @Override
    public CasoDTO InsertarCaso(CasoDTO _caso) {
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        caso = new Caso();
        try {
           
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (caso!=null) {
                caso.setEstado(_caso.getEstado());
                caso.setNumeroPoliza(_caso.getNumero_poliza());
                caso.setNumeroReclamacion(_caso.getNumero_reclamacion());
                caso.setPorciento_cobertura(_caso.getPorciento_cobertura());
                caso.setIdfragmento(_caso.getIdfragmento());
                caso.setIdaseguradoraAseguradora(entityManager.find(Aseguradora.class, _caso.getIdaseguradora()));
                caso.setIdpacientePaciente(entityManager.find(Paciente.class, _caso.getIdpaciente()));
                entityManager.persist(caso);
                entityManager.flush();
            }else{
                throw new NullPointerException("El Caso no puede ser nulo");
            }
            entityTransaction.commit();
            //entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        _caso.setIdcaso(caso.getIdcaso());
        return _caso;
    }

    @Override
    public CasoDTO ActualizarCaso(CasoDTO _caso) {
        //Busqueda del caso
        caso = entityManager.find(Caso.class, _caso.getIdcaso());
        
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
           
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (caso!=null) {
                caso.setEstado(_caso.getEstado());
                caso.setNumeroPoliza(_caso.getNumero_poliza());
                caso.setNumeroReclamacion(_caso.getNumero_reclamacion());
                caso.setPorciento_cobertura(_caso.getPorciento_cobertura());
                caso.setIdfragmento(_caso.getIdfragmento());
                caso.setIdaseguradoraAseguradora(entityManager.find(Aseguradora.class, _caso.getIdaseguradora()));
                
                entityManager.persist(caso);
            }else{
                throw new NullPointerException("El Caso no puede ser nulo");
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
        _caso.setIdcaso(caso.getIdcaso());
        return _caso;
    }

    @Override
    public int GuardarCaso(CasoDTO _caso) {
        CasoDTO caso;
        if(_caso.getIdcaso()>0){
            caso = ActualizarCaso(_caso);
        }else{
            caso = InsertarCaso(_caso);
        }
        return caso.getIdcaso();
    }

    @Override
    public boolean BorrarCaso(CasoDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarCaso(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarCaso(CasoDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarCaso(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarCaso(CasoDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarCaso(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CasoDTO GetCasoPorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CasoDTO> GetTodosCasos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CasoDTO> GetTodosCasosPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
