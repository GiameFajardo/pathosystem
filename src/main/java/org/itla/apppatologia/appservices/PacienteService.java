/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.DTO.PatologoDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.TipoPaciente;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class PacienteService implements IPacienteAppService{
    
    private Contexto contexto;
    private final EntityManager entityManager ;
    private Paciente paciente;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listPacientesType;
    
    public PacienteService(){
        contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listPacientesType = new TypeToken<List<PacienteDTO>>() {}.getType();
    }

    @Override
    public PacienteDTO InsertarPaciente(PacienteDTO _paciente) {
        entityTransaction = entityManager.getTransaction();
        
        try{
            TipoPaciente tp = entityManager.find(TipoPaciente.class, _paciente.getIdtipoPacienteTipoPaciente());
        
            entityTransaction.begin();
                
                this.paciente = new Paciente();
                
                paciente.setNombre(_paciente.getNombre());
                paciente.setApellido(_paciente.getNombre());
                paciente.setDireccion(_paciente.getDireccion());
                paciente.setFechaNacimiento(_paciente.getFechaNacimiento());
                paciente.setSexo(_paciente.getSexo());
                paciente.setTelefono(_paciente.getTelefono());
                paciente.setIdtipoPaciente(Short.parseShort(tp.getIdtipoPaciente().toString()));
                paciente.setIdtipoPacienteTipoPaciente(tp);
                this.paciente.setIsActivo(true);
                this.paciente.setIsBorrado(false);
               
                entityManager.persist(this.paciente);
            
            entityTransaction.commit();
            
            //entityManager.flush();  
            }catch(Exception e){
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());  
            throw e;
        }
        
        return modelMapper.map(this.paciente, PacienteDTO.class);
    }

    @Override
    public PacienteDTO ActualizarPaciente(PacienteDTO _paciente) {
        //Busqueda del patologo
        paciente = entityManager.find(Paciente.class, _paciente.getIdpaciente());
        
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            TipoPaciente tp = entityManager.find(TipoPaciente.class, _paciente.getIdtipoPacienteTipoPaciente());
        
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (paciente!=null) {
                paciente.setNombre(_paciente.getNombre());
                paciente.setApellido(_paciente.getNombre());
                paciente.setDireccion(_paciente.getDireccion());
                paciente.setFechaNacimiento(_paciente.getFechaNacimiento());
                paciente.setSexo(_paciente.getSexo());
                paciente.setIdtipoPaciente(Short.parseShort(tp.getIdtipoPaciente().toString()));
                paciente.setIdtipoPacienteTipoPaciente(tp);
                
            }else{
                throw new NullPointerException("El Paciente no puede ser nulo");
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
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    public int GuardarPaciente(PacienteDTO _paciente) {
        PacienteDTO paciente;
        if(_paciente.getIdpaciente()>0){
            paciente = ActualizarPaciente(_paciente);
        }else{
            paciente = InsertarPaciente(_paciente);
        }
        return paciente.getIdpaciente();
    }

    @Override
    public boolean BorrarPaciente(PacienteDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarPaciente(int id) {
        paciente = entityManager.find(Paciente.class, id);
        try {
            entityManager.getTransaction().begin();
            paciente.setIsBorrado(true);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return paciente.getIsBorrado();
    }

    @Override
    public boolean EliminarPaciente(PacienteDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarPaciente(int id) {
         paciente = entityManager.find(Paciente.class, id);
         entityManager.remove(paciente);
         if(paciente==null){
             return true;
         }else{
             return false;
         }
    }

    @Override
    public boolean DesactivarPaciente(PacienteDTO _paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarPaciente(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PacienteDTO GetPacientePorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PacienteDTO> GetTodosPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PacienteDTO> GetTodasPacientesPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
