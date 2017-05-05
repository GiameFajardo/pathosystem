/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import com.sun.corba.se.impl.oa.poa.AOMEntry;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.DTO.ResultadoDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author Giame
 */
public class ResultadoService implements IResultadoAppService{
    
    private Contexto contexto;
    private final EntityManager entityManager ;
    private Resultado resultado;  
    ModelMapper modelMapper ;
    EntityTransaction entityTransaction;
    java.lang.reflect.Type listResultadoType;
    
    public ResultadoService(){
        contexto = new Contexto();
        entityManager =  contexto.getEntityManager(PersistenceUnits.getLocalContext()); 
        modelMapper = new ModelMapper();
        listResultadoType = new TypeToken<List<ResultadoDTO>>() {}.getType();
    }

    @Override
    public Resultado InsertarResultado(Resultado _resultado) {
        resultado = _resultado;
         
        entityTransaction = entityManager.getTransaction();
        
        try{
            entityTransaction.begin();
                
            entityManager.persist(resultado);
            
            
             
        int idCaso=0;
        Collection<Caso> casos = resultado.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
        for (Caso caso : casos) {
            if(caso.getIdfragmento()==resultado.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                idCaso = caso.getIdcaso();
            }
        }
            
        Caso caso;
        caso = entityManager.find(Caso.class, idCaso);
        
            caso.setEstado("PENDIENTE A ENTREGA");
            entityManager.persist(caso);
        
            
            
            
            
            entityTransaction.commit(); 
            
            }catch(Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
        
        return resultado;
    }

    @Override
    public Resultado ActualizarResultado(Resultado _resultado) {
        //BUSQUEDA DE LA ENTIDAD
        resultado = _resultado;
                
        //INICIO DE LA TRANSACCION
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            //VALIDACION Y ASIGNACION DE VALORES
            if (resultado!=null) {
                
                entityManager.merge(resultado);
                entityManager.flush();
                entityTransaction.commit();
                
                entityTransaction = entityManager.getTransaction();
                  
            }else{
                throw new NullPointerException("El resultado no puede ser null");
            }
            
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }
        return resultado;
    }

    @Override
    public int GuardarResultado(Resultado _resultado) {
        if(_resultado.getIdresultado()>0){
            resultado = ActualizarResultado(_resultado);
        }else{
            resultado = InsertarResultado(_resultado);
        }
        return _resultado.getIdresultado();
    }

    @Override
    public boolean BorrarResultado(Resultado _resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BorrarResultado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarResultado(Resultado _resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarResultado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarResultado(Resultado _resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DesactivarResultado(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado GetResultadoPorId(int _id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resultado> GetTodosResultados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resultado> GetTodasResultadosPorNombre(String _nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
