/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Chu
 */
public class Contexto {
    
    private  static  EntityManagerFactory emf; 
    private  static  String persistenceUnit;
    private static EntityManager em;
    
    public Contexto(){
        
    }
   
    public EntityManager getEntityManager(String _persistedUnit){
        try  { 
            if  ( emf.isOpen ()  &&  this.persistenceUnit . equals (_persistedUnit ))  { 
                return emf.createEntityManager (); 
            }  else  { 
                this.persistenceUnit=_persistedUnit;
                emf = Persistence.createEntityManagerFactory(_persistedUnit ); 
                return emf.createEntityManager();
            } 
        }  catch  ( NullPointerException e )  { 
            persistenceUnit = _persistedUnit; 
            emf =  Persistence.createEntityManagerFactory( persistenceUnit ); 
            return emf . createEntityManager (); 
        } 
    }
}
