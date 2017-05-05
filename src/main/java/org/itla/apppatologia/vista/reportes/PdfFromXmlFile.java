/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.reportes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
/**
 *
 * @author Giame
 */
public class PdfFromXmlFile {
    public static void main(String[] args) throws JRException, IOException {
 
        // Compile jrxml file.
       JasperReport jasperReport = JasperCompileManager
               .compileReport("C:/Users/Chu/Documents/NetBeansProjects/ing.-del-software-2/appPatologia/src/main/java/org/itla/apppatologia/vista/reportes/resultado5.jrxml");
 
       // Parameters for report
       Map<String, Object> parameters = new HashMap<String, Object>();
 
       // DataSource
       // This is simple example, no database.
       // then using empty datasource.
       JRDataSource dataSource = new JREmptyDataSource();
 
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
               parameters, dataSource);
 
    
       // Make sure the output directory exists.
       File outDir = new File("C:/Users/Chu/Documents/");
       outDir.mkdirs();
 
       // Export to PDF.
       JasperExportManager.exportReportToPdfFile(jasperPrint,
               "C:/Users/Chu/Documents/Resultado.pdf");
        
       System.out.println("Done!");
   }
}
