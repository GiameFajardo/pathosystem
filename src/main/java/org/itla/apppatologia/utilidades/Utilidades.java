/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.utilidades;

import com.sun.glass.ui.Size;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.itla.apppatologia.modelo.DB;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;
import javax.swing.JToggleButton;

/**
 *
 * @author sony
 */
public class Utilidades {
    DB db;
    private  static  EntityManagerFactory emf; 
    private  static  String persistenceUnit;
    
    public Utilidades() throws SQLException {
        this.db = new DB();
    }
    
    public  static  EntityManager getSession ( String unidadePersistencia )  { 
        try  { 
            if  ( emf.isOpen ()  &&  Utilidades.persistenceUnit . equals ( unidadePersistencia ))  { 
                return emf.createEntityManager (); 
            }  else  { 
                persistenceUnit = unidadePersistencia ; 
                emf =  Persistence . createEntityManagerFactory ( unidadePersistencia ); 
                return emf . createEntityManager (); 
            } 
        }  catch  ( NullPointerException e )  { 
            persistenceUnit = unidadePersistencia ; 
            emf =  Persistence . createEntityManagerFactory ( persistenceUnit ); 
            return emf . createEntityManager (); 
        } 
    } 
    public DefaultTableModel getModelo(String sql, DB db) throws SQLException{
        
        DefaultTableModel modelo = null;

        ResultSet rs = db.execSelect(sql);
        
          try{
            //Para establecer el modelo al JTable
            modelo = new DefaultTableModel();
            //tabla.setModel(modelo);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
       
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) 
            {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) 
                {
                    fila[i]=rs.getObject(i+1);
                }
             modelo.addRow(fila);
            }
            rs.close();
            db.CerrarConexion();
        }
        catch(Exception ex){
             ex.printStackTrace();
        }
        return modelo;
    }     
    public DefaultComboBoxModel getComboBoxModel(String querty, DB db) throws SQLException{
        
        ResultSet rs;
        
        
        
        DefaultComboBoxModel<Object> dcbm= new DefaultComboBoxModel<>();
        
         PreparedStatement ps;// = new PreparedStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
         ps = DB.conexion.prepareStatement(querty,ResultSet.TYPE_SCROLL_SENSITIVE);
         
         rs = ps.executeQuery();
         
         rs.last();
         
         
         String[] lista = new String[rs.getRow()];
         int i = 0;
         while(rs.next()){
             i++;
//             dcbm.addElement(rs.getString(i));
             dcbm.addElement("hola");
             
             
         }
        return dcbm;
        
    }
    public static Size ReSize(boolean estado,int minWidth, int maxWidth, int height){
        
        Dimension dim = null;
        dim.setSize(maxWidth, height);
        Size size = null;
        if(estado){
            size.height = height;
            size.width = maxWidth;
        }else{
            size.height = height;
            size.width = minWidth;
        //List list = entityManager.createNamedQuery("Patologo.findAll").getResultList();
        }
        
        return size;
        
    }
    public static Dimension ReSize(int cuerpoW, Dimension tabla, Dimension frm, JToggleButton tbtnBuscar){
         int anchoCompleto = cuerpoW+tabla.width;
         if(tbtnBuscar.isSelected()){
             
            return new Dimension(anchoCompleto, frm.height);
        }else{
            return new Dimension(cuerpoW, frm.height);
        }
        
    }
    public static void ocultarColumna(int columna, JTable tabla){
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);
    }
    public static Integer CalcularEdad(Date fechaNacimiento){
       
        Date fechaActual = new Date();
        int difAno = fechaActual.getYear()-fechaNacimiento.getYear();
        int difMes = fechaActual.getMonth()-fechaNacimiento.getMonth();
        int difDia = fechaActual.getDay()-fechaNacimiento.getDay();
        if(difMes<0||(difMes==0&&difDia<0)){
            difAno-=1;
        }
        return difAno;
    }
}
