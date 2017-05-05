/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.utilidades;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itla.apppatologia.modelo.DB;

/**
 *
 * @author Giame
 */
public class GenerarReporte {
    public void ResultadoByEstudio(Integer idEstudio){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Result.jasper");
            Map parametro = new HashMap();
            parametro.put("id_est", idEstudio);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Resultado");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void ResultadoByEstudio2(Integer idCaso){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Resultado.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", idCaso);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Resultado");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void ResultadoByEstudio3(Integer idCaso){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Resultado_1.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", idCaso);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Resultado");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void AllPaciente(){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Pacientes.jasper");
            Map parametro = new HashMap();
            parametro.put("id_pac", 5);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Resultado");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void TicketeFrascoByCaso(Integer idCaso){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\frasco.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", idCaso);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Ticket de frasco");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void ComprobanteCaso(Integer idCaso){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Caso.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", idCaso);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Caso");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public static void Casos(){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Casos.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", 11);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Casos");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public static void Pacientes(){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Pacientes.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", 11);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Pacientes");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public static void Fragmentos(){
        try {
//            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(System.getProperty("user.dir") +"\\src\\main\\resources\\org\\itla\\apppatologia\\vista\\reportes\\ResultadoFinal.jasper");
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject("C:\\Users\\Chu\\Documents\\NetBeansProjects\\ing.-del-software-2\\appPatologia\\src\\main\\java\\org\\itla\\apppatologia\\vista\\reportes\\Fragmentos.jasper");
            Map parametro = new HashMap();
            parametro.put("id_caso", 11);
            
            DB db = new DB();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, DB.conexion);
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            
            jasperViewer.setTitle("Fragmentos");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
