/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.PatologoDTO;
import org.itla.apppatologia.Repository.Patologo;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;


/**
 * <p>Clase que distribuye los servicios locales de la entidad Patolgo</p>
 * @author Giame Fajardo
 * @since 24/03/2016
 * 
 */
public class PatologoLocalService implements IPatologoAppService {
    private Contexto contexto;
    private final EntityManager entityManager ;
    private Patologo patologo;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listPatologoType;
     
    /**
     *Instancia nuevo objeto PatologoLocalService con su contexto y modelMapper
     */
    public PatologoLocalService() {
            contexto = new Contexto();
            entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
            modelMapper = new ModelMapper();
            listPatologoType = new TypeToken<List<PatologoDTO>>() {}.getType();
    }
       
    /**
     *<p>Inserta un nuevo patólogo</p>
     * @param _patologo PatologoDTO con los datos que se desean insertar.
     * @return PatologoDTO ya insertado.
     */
    @Override
    public PatologoDTO InsertarPatologo(PatologoDTO _patologo){
        entityTransaction = entityManager.getTransaction();
        
        try{
            entityTransaction.begin();
                
                this.patologo = new Patologo();
                
                this.patologo.setNombre(_patologo.getNombre());
                this.patologo.setApellido(_patologo.getApellido());
                this.patologo.setIsActivo(true);
                this.patologo.setIsBorrado(false);
               
                entityManager.persist(this.patologo);
            
            entityTransaction.commit();
            
            //entityManager.flush();  
        }catch(Exception e){
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());  
            throw e;
        }
        
        return modelMapper.map(this.patologo, PatologoDTO.class);
    }
    
    /**
     * <p>Actualiza datos de un patologo.</p>
     * @param _patologo PatologoDTO con los datos que se desean actualizar
     * @return PatologoDTO ya actualizado
     * @throws NullPointerException en el caso de que no encuentre el patologo en la base de datos
     */
    @Override
    public PatologoDTO ActualizarPatologo(PatologoDTO _patologo) throws NullPointerException{
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, _patologo.getIdpatologo());
        
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (patologo!=null) {
                patologo.setNombre(_patologo.getNombre());
                patologo.setApellido(_patologo.getApellido());
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
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
        return modelMapper.map(patologo, PatologoDTO.class);                                                    
    }
    
    /**
     *<p>Guarda, inserta o actualiza, un patologo.</p>
     * @param _patologo PatologoDTO que sera evaluado para ser insertado o actualizado
     * @return 1: si se actualiza. 0: si se inserta.
     */
    @Override
    public int GuardarPatologo(PatologoDTO _patologo) {
        int existe = 0;
        
        PatologoDTO patologoDTO = new PatologoDTO();
        try {
            
            existe = entityManager.createNamedQuery("Patologo.findByIdpatologo", Patologo.class).
                    setParameter("idpatologo",_patologo.getIdpatologo()).
                    getResultList().size();
            
            if(existe==1){
                patologoDTO = ActualizarPatologo(_patologo);
            }else{
                patologoDTO = InsertarPatologo(_patologo);
                
            }
        } catch (Exception e) {
            
        }
        
        return existe;
        
    }
    
    @Override
    public boolean BorrarPatologo(PatologoDTO _patologo) {
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, _patologo.getIdpatologo());

        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (patologo!=null) {
                patologo.setIsBorrado(true);
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            entityTransaction.commit();
            entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return patologo.getIsBorrado();
            
    }
    
    @Override
    public boolean BorrarPatologo(int id) {
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, id);
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (patologo!=null) {
                patologo.setIsBorrado(true);
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            
            //entityManager.flush();
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return patologo.getIsBorrado();
    }
    
    /**
     *
     * @param _patologo PatologoDTO con los datos del Patologo que se quiere eliminar
     * @return boolean true: si el patologo se eliminó exitosamente. false: si no se eliminó
     */
    @Override
    public boolean EliminarPatologo(PatologoDTO _patologo) {
        boolean confirmacion = false;
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, _patologo.getIdpatologo());
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y Eliminacion de entidad
            if (patologo!=null) {
                entityManager.remove(patologo);
                confirmacion = true;
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            entityTransaction.commit();
            entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return confirmacion;
    }
    
    @Override
    public boolean EliminarPatologo(int id) {
        boolean confirmacion = false;
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, id);
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y Eliminacion de entidad
            if (patologo!=null) {
                entityManager.remove(patologo);
                confirmacion = true;
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            entityTransaction.commit();
            entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return confirmacion;
    }
    
    @Override
    public boolean DesactivarPatologo(PatologoDTO _patologo) {
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, _patologo.getIdpatologo());
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y asignacion de valores
            if (patologo!=null) {
                patologo.setIsActivo(!patologo.getIsActivo());
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            entityTransaction.commit();
            entityManager.flush();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return patologo.getIsBorrado();
    }
    
    @Override
    public boolean DesactivarPatologo(int _id) {
        //Busqueda del patologo
        patologo = entityManager.find(Patologo.class, _id);
        //Se inicia la transaccion
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //Validacion y asignacion de valor
            if (patologo!=null) {
                patologo.setIsActivo(!patologo.getIsActivo());
            }else{
                throw new NullPointerException("El Patologo no puede ser nulo");
            }
            //entityManager.flush();
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
        return patologo.getIsActivo();
    }
    
    @Override
    public PatologoDTO GetPorId(int _id) {
        patologo = entityManager.find(Patologo.class, _id);
        
        return modelMapper.map(patologo, PatologoDTO.class);
    }
    
    @Override
    public List<PatologoDTO> GetTodosPatologos() {
        List<Patologo> patologos;
        patologos = entityManager.createNamedQuery("Patologo.findAll",Patologo.class).getResultList();
        
        return  modelMapper.map(patologos,listPatologoType);
    }
    
    @Override
    public List<PatologoDTO> GetTodosPatologosPorNombre(String _nombre) {
        List<Patologo> patologos;
        patologos = entityManager.createNamedQuery("Patologo.findIlikeNombre",Patologo.class).
                                                setParameter("nombre", "%"+_nombre+"%").getResultList();
        
        return  modelMapper.map(patologos,listPatologoType);
    }
    
    @Override
    public List<PatologoDTO> GetPatologosPorNombreOAperllido(String _nombre, String _apellido) {
        List<Patologo> patologos;
        patologos = entityManager.createNamedQuery("Patologo.findIlikeNombreApellido",Patologo.class).
                          setParameter("nombre", "%"+_nombre+"%").setParameter("apellido", "%"+_apellido+"%").
                          getResultList();
        
        return  modelMapper.map(patologos,listPatologoType);
    }
    
}
