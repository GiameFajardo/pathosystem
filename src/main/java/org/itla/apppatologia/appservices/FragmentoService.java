/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.EstadoFragmento;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Frasco;
import org.itla.apppatologia.Repository.Medico;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.TipoFragmento;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class FragmentoService implements IFragmentoAppService{
    
    private Contexto contexto;
    private final EntityManager entityManager ;
    private Fragmento fragmento;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listFragmentoType;
    
    public FragmentoService(){
         contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listFragmentoType = new TypeToken<List<FragmentoDTO>>() {}.getType();
    }

    @Override
    public FragmentoDTO InsertarFragmento(FragmentoDTO _fragmento) {
        entityTransaction = entityManager.getTransaction();
        Integer idFrasco;
        
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Frasco frasco = new Frasco();

            frasco.setIdfragmento(Short.parseShort(Integer.toString(_fragmento.getId())));
            frasco.setIdpacientePaciente(entityManager.find(Paciente.class, _fragmento.getIdPaciente()));
            frasco.setIsActivo(true);

            entityManager.persist(frasco);
            
            entityTransaction.commit();
            idFrasco = frasco.getIdfrasco();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            System.out.println(e.getMessage());  
            throw e;
        }
        _fragmento.setIdFrasco(idFrasco);
        try{
            entityTransaction.begin();
                
                this.fragmento = new Fragmento();
                fragmento.setDescripcion(_fragmento.getDescripcion());
                fragmento.setColor(_fragmento.getColor());
                fragmento.setDiagnostico(_fragmento.getDiagnostico());
                fragmento.setDimension(_fragmento.getDimencion());
                fragmento.setEstructura(_fragmento.getEstructura());
                fragmento.setFecha(_fragmento.getFecha());
                fragmento.setForma(_fragmento.getForma());
                fragmento.setIdfragmento(_fragmento.getId());
                fragmento.setOrigen(_fragmento.getOrigen());
                fragmento.setPeso(_fragmento.getPero());
                fragmento.setIsActivo(_fragmento.isIsActivo());
                
                fragmento.setIdfrascoFrasco(entityManager.find(Frasco.class, _fragmento.getIdFrasco()));
                fragmento.setIdmedicoMedico(entityManager.find(Medico.class, _fragmento.getIdMedico()));
                fragmento.setIdestadoFragmentoEstadoFragmento(entityManager.find(EstadoFragmento.class, _fragmento.getIdEstado()));
                fragmento.setIdtipoFragmentoTipoFragmento(entityManager.find(TipoFragmento.class, _fragmento.getIdTipo()));
                
               
                entityManager.persist(this.fragmento);
                entityTransaction.commit();
                
                entityTransaction = entityManager.getTransaction();
                try {
                    entityTransaction.begin();
                    Frasco frasco = entityManager.find(Frasco.class, fragmento.getIdfrascoFrasco().getIdfrasco());
                    frasco.setIdfragmento(Short.parseShort(fragmento.getIdfragmento().toString()));
                    entityManager.persist(frasco);
                    entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction.isActive()) {
                    entityTransaction.rollback();
                }
                System.out.println(e.getMessage());  
                throw e;
            }
                
                
                
            
            
            
            
            //entityManager.flush();  
            }catch(Exception e){
            
        }
        
        _fragmento.setId(fragmento.getIdfragmento());
        return _fragmento;
    }

    @Override
    public FragmentoDTO ActualizarFragmento(FragmentoDTO _fragmento) {
        //BUSQUEDA DE LA ENTIDAD
        fragmento = entityManager.find(Fragmento.class, _fragmento.getId());
        //INICIO DE LA TRANSACCION
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //VALIDACION Y ASIGNACION DE VALORES
            if (fragmento!=null) {
                fragmento.setDescripcion(_fragmento.getDescripcion());
                fragmento.setColor(_fragmento.getColor());
                fragmento.setDiagnostico(_fragmento.getDiagnostico());
                fragmento.setDimension(_fragmento.getDimencion());
                fragmento.setEstructura(_fragmento.getEstructura());
                fragmento.setFecha(_fragmento.getFecha());
                fragmento.setForma(_fragmento.getForma());
                fragmento.setIdfragmento(_fragmento.getId());
                fragmento.setOrigen(_fragmento.getOrigen());
                fragmento.setPeso(_fragmento.getPero());
                fragmento.setIsActivo(_fragmento.isIsActivo());
                
                //fragmento.setIdfrascoFrasco(entityManager.find(Frasco.class, _fragmento.getIdFrasco()));
                fragmento.setIdmedicoMedico(entityManager.find(Medico.class, _fragmento.getIdMedico()));
                fragmento.setIdestadoFragmentoEstadoFragmento(entityManager.find(EstadoFragmento.class, _fragmento.getIdEstado()));
                fragmento.setIdtipoFragmentoTipoFragmento(entityManager.find(TipoFragmento.class, _fragmento.getIdTipo()));
                
                entityManager.persist(fragmento);
                
                entityTransaction.commit();
                
                
                
                entityTransaction = entityManager.getTransaction();
                try {
                    entityTransaction.begin();
                    Frasco frasco = entityManager.find(Frasco.class, fragmento.getIdfrascoFrasco().getIdfrasco());
                    frasco.setIdfragmento(Short.parseShort(fragmento.getIdfragmento().toString()));
                    entityManager.persist(frasco);
                    entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction.isActive()) {
                    entityTransaction.rollback();
                }
                System.out.println(e.getMessage());  
                throw e;
            }
                
                
                
                
            }else{
                throw new NullPointerException("El fragmento no puede ser null");
            }
            
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
        _fragmento.setId(fragmento.getIdfragmento());
        return _fragmento;
    }

    @Override
    public int GuardarFragmento(FragmentoDTO _fragmento) {
        FragmentoDTO fragmento;
//        Integer idFrasco;
//        
//        entityTransaction = entityManager.getTransaction();
//        try {
//            entityTransaction.begin();
//            Frasco frasco = new Frasco();
//
//            frasco.setIdfragmento(Short.parseShort(Integer.toString(_fragmento.getId())));
//            frasco.setIdpacientePaciente(entityManager.find(Paciente.class, _fragmento.getIdPaciente()));
//            frasco.setIsActivo(true);
//
//            entityManager.persist(frasco);
//            
//            entityTransaction.commit();
//            idFrasco = frasco.getIdfrasco();
//        } catch (Exception e) {
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//            System.out.println(e.getMessage());  
//            throw e;
//        }
//        _fragmento.setIdFrasco(idFrasco);
        if(_fragmento.getId()>0){
            fragmento = ActualizarFragmento(_fragmento);
        }else{
            fragmento = InsertarFragmento(_fragmento);
        }
        return fragmento.getId();
    }

    @Override
    public boolean BorrarFragmento(FragmentoDTO _fragmento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarFragmento(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarFragmento(FragmentoDTO _fragmento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarFragmento(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarFragmento(FragmentoDTO _fragmento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarFragmento(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FragmentoDTO GetPorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FragmentoDTO> GetTodosFragmentos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FragmentoDTO> GetTodasFragmentosPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
