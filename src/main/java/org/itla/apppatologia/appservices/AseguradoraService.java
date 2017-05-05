/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.ArsDTO;
import org.itla.apppatologia.DTO.PatologoDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class AseguradoraService implements IAseguradoraAppService{

    private Contexto contexto;
    private final EntityManager entityManager ;
    private Aseguradora aseguradora;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listAseguradorasType;
    
    public AseguradoraService(){
        contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listAseguradorasType = new TypeToken<List<PatologoDTO>>() {}.getType();
    }
    @Override
    public ArsDTO InsertarAseguradora(ArsDTO _ars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArsDTO ActualizarAseguradora(ArsDTO _ars) {
        //BUSQUEDA DE LA ENTIDAD
        aseguradora = entityManager.find(Aseguradora.class, _ars.getId());
        //INICIO DE LA TRANSACCION
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //VALIDACION Y ASIGNACION DE VALORES
            if (aseguradora!=null) {
                aseguradora.setNombre(_ars.getNombre());
                aseguradora.setTelefono(_ars.getTelefono());
                aseguradora.setDireccion(_ars.getDirecion());
                
                entityManager.persist(aseguradora);
                
                entityTransaction.commit();
            }else{
                throw new NullPointerException("La aseguradora no puede ser null");
            }
            
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
        return modelMapper.map(aseguradora, ArsDTO.class);
    }

    @Override
    public int GuardarAseguradora(ArsDTO _ars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarAseguradora(ArsDTO _ars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarAseguradora(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarAseguradora(ArsDTO _ars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarAseguradora(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarAseguradora(ArsDTO _ars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarAseguradora(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArsDTO GetPorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ArsDTO> GetTodasAseguradoras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ArsDTO> GetTodasAseguradorasPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
