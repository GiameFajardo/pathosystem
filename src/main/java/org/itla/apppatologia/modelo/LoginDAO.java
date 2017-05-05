/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author sony
 */
public class LoginDAO {
    
    public  DB dbase = null;
    private Connection conexion=null;
    
    public LoginDAO() throws SQLException{
    
        String host = "5433";
        String db = "SGSoft_patosystem";
        String url = "jdbc:postgresql://"+host+"/"+db;
        String user = "postgres";
        String pass = "1234";
        try{
            dbase = new DB(host, db, user, pass);
        }catch(SQLException ex){
            throw ex;
        }
    }  
    
    public LoginDAO(String host,String db,String user,String pass) throws SQLException{
       
        String url = "jdbc:postgresql://"+host+"/"+db;
        
        try {     
            conexion=DriverManager.getConnection(url,user,pass);
        } catch (SQLException exc){
            throw exc;
        }
        
        
    } 
    
    public boolean ValidarEntrada(String nombre, String clave) throws SQLException{
        boolean bol = false;
        
        PreparedStatement validar = null;
        
        String sql="select usuario, clave from patologia.usuario where nombre=? and clave=?;";
        String sql2="select nombre, clave from patologia.usuario;";
        
        dbase.conexion.setAutoCommit(false);
        
        validar = dbase.conexion.prepareStatement(sql);
        
        validar.setString(1, nombre);
        validar.setString(2, clave);
        
        ResultSet rs = validar.executeQuery();
        
        if(rs.next()){
        bol = true;
        }
        dbase.conexion.commit();
        return bol;
        
    }
}
