/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.mantenimientos;

import java.util.List;
import javax.persistence.EntityManager;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Observacion;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.Repository.TipoObservacion;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.MyListRendeder;

/**
 *
 * @author Giame
 */
public class PanelObservacion extends javax.swing.JPanel {

    PanelEstudio padre;
    EntityManager entityManager;
    Contexto context;
    private Observacion observacion;
    private List<Observacion> observaciones;
    private List<TipoObservacion> tiposObservaciones;
    /**
     * Creates new form PanelObservacion
     */
    public PanelObservacion() {
        initComponents();
        observacion = new Observacion();
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoObservacion2.addItem(itemBlank);
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
       
    }
    public PanelObservacion(PanelEstudio padre) {
        initComponents();
        this.padre=padre;
        observacion = new Observacion();
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoObservacion2.addItem(itemBlank);
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
       
    }
    public PanelObservacion(Estudio estudio) {
        initComponents();
        observacion = new Observacion();
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        observacion.setIdestudioEstudio(entityManager.find(Estudio.class, estudio.getIdestudio()));
        
//        context = new  Contexto();
//        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoObservacion2.addItem(itemBlank);
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
       
    }
    public PanelObservacion(Estudio estudio, PanelEstudio padre) {
        initComponents();
        this.padre=padre;
        observacion = new Observacion();
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        observacion.setIdestudioEstudio(entityManager.find(Estudio.class, estudio.getIdestudio()));
        
//        context = new  Contexto();
//        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoObservacion2.addItem(itemBlank);
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
       
    }
    public PanelObservacion(Observacion observacion){
        initComponents();
        this.observacion = observacion;
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
        showInFields(this.observacion);
    }

    public PanelObservacion(Observacion observacion, PanelEstudio padre){
        initComponents();
        this.padre = padre;
        this.observacion = observacion;
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposObservaciones = entityManager.createNamedQuery("TipoObservacion.findAll").getResultList();
        cboxTipoObservacion2.setRenderer(new MyListRendeder());
        for (TipoObservacion tipoObservacion : tiposObservaciones) {
            Object[] itemData = new Object[]{tipoObservacion.getIdtipoObservacion(),tipoObservacion.getNombre()};
            cboxTipoObservacion2.addItem(itemData);
        }
        showInFields(this.observacion);
    }
    public Observacion getObservacion(){
        Resultado res = null;
        try{
            res = entityManager.createNamedQuery("Resultado.findByIdestudio", Resultado.class).
                setParameter("idestudio", observacion.getIdestudioEstudio()).getSingleResult();
        }catch(Exception ex){
            
        }
        
        
        observacion.setDescripcion(txtDescripcion.getText());
        observacion.setIdobservacion(Integer.parseInt(lblValorCodigo.getText()));
        
        if(res!=null)
            observacion.setIdresultadoResultado(res);
        
        int id;
        Object[] ob; 
        ob = (Object[]) cboxTipoObservacion2.getSelectedItem();
        id = (int) ob[0];
        observacion.setIdtipoObservacionTipoObservacion(entityManager.find(TipoObservacion.class, id));
        //tipo
        return observacion;
    }
    public void showInFields(Observacion obs){
        lblValorCodigo.setText(obs.getIdobservacion().toString());
        txtDescripcion.setText(obs.getDescripcion());
        int id = 0;
            for (int i = 0;i<cboxTipoObservacion2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxTipoObservacion2.getItemAt(i);
                id= (int)ob[0];
                if(id==obs.getIdtipoObservacionTipoObservacion().getIdtipoObservacion()){
                    cboxTipoObservacion2.setSelectedIndex(i);
                }
            }
    }
    public void setIdEstudioToObservacion(Integer idEstudio){
        observacion.setIdestudioEstudio(entityManager.find(Estudio.class, idEstudio));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblValorCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cboxTipoObservacion2 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));

        jLabel1.setText("Código Observación");

        lblValorCodigo.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        lblValorCodigo.setForeground(new java.awt.Color(204, 0, 0));
        lblValorCodigo.setText("0");

        jLabel2.setText("Tipo");

        jLabel3.setText("Descripcion");

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        cboxTipoObservacion2.setBackground(new java.awt.Color(245, 245, 244));
        cboxTipoObservacion2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/cloase.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/close2.png"))); // NOI18N
        jButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/clase2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxTipoObservacion2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblValorCodigo))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxTipoObservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        padre.removeObseervacion(this);
        padre.revalidate();
        padre.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboxTipoObservacion2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValorCodigo;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
