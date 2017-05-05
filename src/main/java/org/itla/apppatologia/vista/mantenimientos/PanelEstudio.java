/*
 * To change this license header, choose License Headers in Pr            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }           @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }ject Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.mantenimientos;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.itla.apppatologia.DTO.EstudioDTO;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Observacion;
import org.itla.apppatologia.Repository.Patologo;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.Repository.TipoEstudio;
import org.itla.apppatologia.appservices.EstudioService;
import org.itla.apppatologia.appservices.IEstudioAppService;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.MyListRendeder;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.viewers.IViewerObservable;

/**
 *
 * @author Giame
 */
public class PanelEstudio extends javax.swing.JPanel implements IMantenimiento{

    EntityManager entityManager;
    Contexto context;
    private List<Estudio> estudios;
    private List<Patologo> patologos;
    private List<Observacion> observaciones;
    private List<PanelObservacion> pnObservaciones;
    private PanelObservacion pnObservacion;
    private List<TipoEstudio> tiposEstudios;
    private List<Fragmento> fragmentos;
    Caso caso;
    private EstudioDTO estudio;
    IEstudioAppService estudioService;
    IPanelCentralObservador padre;
    IViewerObservable viewerAsociado;
    String nombre ;
    boolean isPinned = false;
    /**
     * Creates new form PanelFragmento
     */
    public PanelEstudio() {
        initComponents();
        estudioService = new EstudioService();
        nombre="estudio";
        
        
         context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        estudios = entityManager.createNamedQuery("Estudio.findAll").getResultList();
        tiposEstudios = entityManager.createNamedQuery("TipoEstudio.findAll").getResultList();
        patologos = entityManager.createNamedQuery("Patologo.findAll").getResultList();
        observaciones = new ArrayList<Observacion>();
//        observaciones = entityManager.createNamedQuery("Observacion.findAll").getResultList();
        fragmentos = entityManager.createNamedQuery("Fragmento.findAll").getResultList();

                

        cboxTipoEstudio.setRenderer(new MyListRendeder());
        cboxPatologo2.setRenderer(new MyListRendeder());
        cboxFragmento2.setRenderer(new MyListRendeder());
         
        
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoEstudio.addItem(itemBlank);
        cboxPatologo2.addItem(itemBlank);
        cboxFragmento2.addItem(itemBlank);
        
        for (TipoEstudio tipoEstudio : tiposEstudios) {
            Object[] itemData = new Object[]{tipoEstudio.getIdtipoEstudio(),tipoEstudio.getNombre()};
            cboxTipoEstudio.addItem(itemData);
        }
        for (Patologo patologo : patologos) {
            Object[] itemData = new Object[]{patologo.getIdpatologo(),patologo.getNombre()};
            cboxPatologo2.addItem(itemData);
        }
        for (Fragmento fragmento : fragmentos) {
            Object[] itemData = new Object[]{fragmento.getIdfragmento(),fragmento.getIdfragmento().toString()};
            cboxFragmento2.addItem(itemData);
        }
        
    }

    public PanelEstudio(FragmentoDTO frag){
        initComponents();
        estudioService = new EstudioService();
        nombre="estudio";
        
        
         context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        estudios = entityManager.createNamedQuery("Estudio.findAll").getResultList();
        tiposEstudios = entityManager.createNamedQuery("TipoEstudio.findAll").getResultList();
        patologos = entityManager.createNamedQuery("Patologo.findAll").getResultList();
        observaciones = new ArrayList<Observacion>();
//        observaciones = entityManager.createNamedQuery("Observacion.findAll").getResultList();
        fragmentos = entityManager.createNamedQuery("Fragmento.findAll").getResultList();

                

        cboxTipoEstudio.setRenderer(new MyListRendeder());
        cboxPatologo2.setRenderer(new MyListRendeder());
        cboxFragmento2.setRenderer(new MyListRendeder());
         
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoEstudio.addItem(itemBlank);
        cboxPatologo2.addItem(itemBlank);
        cboxFragmento2.addItem(itemBlank);
        
        for (TipoEstudio tipoEstudio : tiposEstudios) {
            Object[] itemData = new Object[]{tipoEstudio.getIdtipoEstudio(),tipoEstudio.getNombre()};
            cboxTipoEstudio.addItem(itemData);
        }
        for (Patologo patologo : patologos) {
            Object[] itemData = new Object[]{patologo.getIdpatologo(),patologo.getNombre()};
            cboxPatologo2.addItem(itemData);
        }
        for (Fragmento fragmento : fragmentos) {
            Object[] itemData = new Object[]{fragmento.getIdfragmento(),fragmento.getIdfragmento().toString()};
            cboxFragmento2.addItem(itemData);
        }
        
        
        
        int id = 0;
            for (int i = 0;i<cboxFragmento2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxFragmento2.getItemAt(i);
                id= (int)ob[0];
                if(id==frag.getId()){
                    cboxFragmento2.setSelectedIndex(i);
                }
            }
        Fragmento fragmentoJPA = entityManager.find(Fragmento.class, frag.getId());
        caso = entityManager.createNamedQuery("Caso.findByIdFragmento",Caso.class).
                setParameter("idfragmento", frag.getId()).getResultList().get(0);
        txtNoReclamacion.setText(caso.getNumeroReclamacion());
        
    }
    public void Enlazar(){
        nombre="estudio";
    }
    
    @Override
    public String getName(){
        return nombre;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tbPinned = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblValorCodigo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtNoReclamacion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxTipoEstudio = new javax.swing.JComboBox();
        cboxFragmento2 = new javax.swing.JComboBox();
        cboxPatologo2 = new javax.swing.JComboBox();
        pnContenedorObservaciones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbPinned.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/pushpin.png"))); // NOI18N
        tbPinned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPinnedActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblValorCodigo.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        lblValorCodigo.setForeground(new java.awt.Color(204, 0, 0));
        lblValorCodigo.setText("0");

        lblCodigo.setText("Código");

        txtNombre.setText("No. reclamacion");

        lblTelefono.setText("Patólogo");

        jLabel1.setText("Fecha");

        jLabel2.setText("Tipo de estudio");

        jLabel3.setText("Fragmento");

        cboxTipoEstudio.setBackground(new java.awt.Color(245, 245, 244));
        cboxTipoEstudio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cboxFragmento2.setBackground(new java.awt.Color(245, 245, 244));
        cboxFragmento2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cboxFragmento2.setEnabled(false);

        cboxPatologo2.setBackground(new java.awt.Color(245, 245, 244));
        cboxPatologo2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(lblValorCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoReclamacion)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(lblTelefono))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxTipoEstudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxPatologo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxFragmento2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValorCodigo)
                        .addComponent(lblCodigo)
                        .addComponent(jLabel1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre)
                    .addComponent(txtNoReclamacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxTipoEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboxFragmento2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(cboxPatologo2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnContenedorObservaciones.setBackground(new java.awt.Color(204, 219, 255));
        pnContenedorObservaciones.setLayout(new javax.swing.BoxLayout(pnContenedorObservaciones, javax.swing.BoxLayout.Y_AXIS));

        jButton1.setBackground(new java.awt.Color(255, 232, 252));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/microscopio.png"))); // NOI18N
        jButton1.setText("<HTML><p align=center>Agregar observación</p></HTML>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tbPinned, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnContenedorObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPinned)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnContenedorObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPinnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPinnedActionPerformed
        isPinned = tbPinned.isSelected();
        padre.IsPinned(isPinned);

    }//GEN-LAST:event_tbPinnedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(estudio==null){
            pnObservacion = new PanelObservacion(this);
        }else{
            pnObservacion = new PanelObservacion(entityManager.find(Estudio.class, estudio.getIdestudio()));
        }
        pnObservacion.setVisible(true);
        pnContenedorObservaciones.add(pnObservacion);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void removeObseervacion(PanelObservacion pn){
        Observacion observacion = pn.getObservacion();
        int opcion = JOptionPane.showConfirmDialog(null, 
                "¿Desea borrar la observación?",
                "Borrar observación", JOptionPane.YES_NO_OPTION);
        if(opcion==0){
            Estudio est = entityManager.find(Estudio.class,estudio.getIdestudio());
        Resultado res;
        try {
            res= est.getResultado();
        } catch (Exception e) {
            res=null;
        }
        
        if(res==null){
            pnContenedorObservaciones.remove(pn);
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(observacion);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
            this.repaint();
        }else{
            JOptionPane.showMessageDialog(null,
             "Este estudio ya tiene resultado. Sus Observaciones no se pueden eliminar.",
             "La observación no se puede eliminar.", JOptionPane.OK_OPTION);
        }
        }else{
            
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboxFragmento2;
    private javax.swing.JComboBox cboxPatologo2;
    private javax.swing.JComboBox cboxTipoEstudio;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblValorCodigo;
    private javax.swing.JPanel pnContenedorObservaciones;
    private javax.swing.JToggleButton tbPinned;
    private javax.swing.JTextField txtNoReclamacion;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bind(IViewerObservable v, IPanelCentralObservador p) {
        viewerAsociado = v;
        padre = p;
    }

    @Override
    public Estudio Save() {
        //CREA ESTUDIO
        estudio = new EstudioDTO();
        Estudio estudioJPA = null;
        //SI LOS CAMPOS ESTAN LLENOS
        if(Validar()){
        
        estudio.setIdestudio(Integer.parseInt(lblValorCodigo.getText()));
        estudio.setFecha(jDateChooser1.getDate());
        estudio.setNumReclamacion(txtNoReclamacion.getText());
        
        int id;
        Object[] ob; 
        
        ob = (Object[]) cboxTipoEstudio.getSelectedItem();
        id = (int) ob[0];
        estudio.setIdtipoEstudioTipoEstudio(id);
        ob = (Object[]) cboxFragmento2.getSelectedItem();
        id = (int) ob[0];
        estudio.setIdfragmentoFragmento(id);
        ob = (Object[]) cboxPatologo2.getSelectedItem();
        id = (int) ob[0];
        estudio.setIdpatologoPatologo(id);
        
        estudio.setIdestudio(estudioService.GuardarEstudio(estudio));
        //SI EL ESTUDIO YA EXISTE (UPDATE)
        if(estudio.getIdestudio()>0){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            estudioJPA = entityManager.find(Estudio.class, estudio.getIdestudio());
            try {
                entityTransaction.begin();
                
                entityManager.merge(estudioJPA);
//                int idCaso=0;
//                idCaso = caso.getIdcaso();
//                Collection<Caso> casos = estudioJPA.getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
//                for (Caso caso : casos) {
//                    if(caso.getIdfragmento()==estudioJPA.getIdfragmentoFragmento().getIdfragmento()){
//                        idCaso = caso.getIdcaso();
//                    }
//                }
//                
//                Caso caso;
//                caso = entityManager.find(Caso.class, idCaso);
                if(!estudioJPA.getObservacionCollection().isEmpty()){
                    caso.setEstado("OBSERVACION");
                    entityManager.persist(caso);
                }else{
                    caso.setEstado("ASIGNADO");
                    entityManager.persist(caso);
                }
                
                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            }
        }
        pnContenedorObservaciones.getComponents();
        //OBTENER LAS OBSERVACIONES
        for(Component c: pnContenedorObservaciones.getComponents()){
            if (c instanceof PanelObservacion) {
                ((PanelObservacion) c).setIdEstudioToObservacion(estudio.getIdestudio());
                PanelObservacion jp = new PanelObservacion(entityManager.find(Estudio.class, estudio.getIdestudio()),this);
                jp = (PanelObservacion)c;
                observaciones.add(jp.getObservacion());
            }
        }
        EntityTransaction et = entityManager.getTransaction();
        //GUARDAR LAS OBSERVACIONES
        try {
            et.begin();
            for (Observacion observacion : observaciones) {
                
                if(observacion.getIdobservacion()==0){
//                    observacion.setIdobservacion(null);

                    entityManager.persist(observacion);
                    entityManager.merge(observacion);
                }else{
                    Observacion obs = entityManager.find(Observacion.class, observacion.getIdobservacion());
                    obs.setIdresultadoResultado(observacion.getIdresultadoResultado());
                    obs.setDescripcion(observacion.getDescripcion());
                    obs.setIdestudioEstudio(observacion.getIdestudioEstudio());
                    obs.setIdtipoObservacionTipoObservacion(observacion.getIdtipoObservacionTipoObservacion());
                    
                    entityManager.persist(obs);
                    entityManager.flush();
                }
                
            estudioJPA = entityManager.find(Estudio.class, estudio.getIdestudio());
                
            int idCaso=0;
                Collection<Caso> casos = estudioJPA.getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
                for (Caso caso : casos) {
                    if(caso.getIdfragmento()==estudioJPA.getIdfragmentoFragmento().getIdfragmento()){
                        idCaso = caso.getIdcaso();
                    }
                }
                
                entityManager.flush();
                estudioJPA = entityManager.merge(estudioJPA);
                Caso caso;
                if(idCaso>0){
                    caso = entityManager.find(Caso.class, idCaso);
                }else{
                    caso = entityManager.createNamedQuery("Caso.findByIdFragmento", Caso.class).
                            setParameter("idfragmento", estudioJPA.getIdfragmentoFragmento().
                                    getIdfragmento()).getSingleResult();
                }
                
                if(!estudioJPA.getObservacionCollection().isEmpty()){
                    caso.setEstado("OBSERVACION");
                    entityManager.persist(caso);
                }else{
                    caso.setEstado("ASIGNADO");
                    entityManager.persist(caso);
                }    
                
            }
             
            
            et.commit(); 
            entityManager.refresh(estudioJPA);
            
            
            
            
//            if (!et.isActive()) {
//                entityManager.close();
//                entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
//            }
            
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }
             
        
    
        }else{
            JOptionPane.showMessageDialog(null, "No se puede guardar");
        }
        return estudioJPA;
    }

    @Override
    public boolean Clean() {
        lblValorCodigo.setText("0");
        txtNoReclamacion.setText("");
        
        jDateChooser1.setDate(new Date());
        cboxTipoEstudio.removeAllItems();
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoEstudio.addItem(itemBlank);        
        for (TipoEstudio tipoEstudio : tiposEstudios) {
            Object[] itemData = new Object[]{tipoEstudio.getIdtipoEstudio(),tipoEstudio.getNombre()};
            cboxTipoEstudio.addItem(itemData);
        }
        cboxFragmento2.removeAllItems();
        cboxFragmento2.addItem(itemBlank);        
        for (Fragmento fragmento : fragmentos) {
            Object[] itemData = new Object[]{fragmento.getIdfragmento(),fragmento.getIdfragmento().toString()};
            cboxFragmento2.addItem(itemData);
        }
        cboxPatologo2.removeAllItems();
        cboxPatologo2.addItem(itemBlank);        
        for (Patologo patologo : patologos) {
            Object[] itemData = new Object[]{patologo.getIdpatologo(),patologo.getNombre()};
            cboxPatologo2.addItem(itemData);
        }
        pnContenedorObservaciones.removeAll();
        this.revalidate();
        this.repaint();
        return true;
    }

    @Override
    public boolean CanModify(boolean b) {
        txtNoReclamacion.setEnabled(b);
        jDateChooser1.setEnabled(b);
        cboxFragmento2.setEnabled(b);
        cboxPatologo2.setEnabled(b);
        cboxTipoEstudio.setEnabled(b);
        jButton1.setEnabled(b);
        for (Component pnOb : pnContenedorObservaciones.getComponents()) {
            if (pnOb instanceof PanelObservacion) {
                for (Component component : ((PanelObservacion) pnOb).getComponents()) {
                    if (component instanceof JTextArea) {
                        ((JTextArea)component).setEnabled(b);
                    }else if(component instanceof JComboBox){
                         ((JComboBox)component).setEnabled(b);
                    }
                }
            }
        }
        return !b;
    }

    @Override
    public void Show(Object o) {
            estudio = (EstudioDTO) o;
            lblValorCodigo.setText(Integer.toString(estudio.getIdestudio()));
            txtNoReclamacion.setText(estudio.getNumReclamacion());
            jDateChooser1.setDate(estudio.getFecha());
            
          
            int id = 0;
            for (int i = 0;i<cboxTipoEstudio.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxTipoEstudio.getItemAt(i);
                id= (int)ob[0];
                if(id==estudio.getIdtipoEstudioTipoEstudio()){
                    cboxTipoEstudio.setSelectedIndex(i);
                }
            }
            for (int i = 0;i<cboxFragmento2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxFragmento2.getItemAt(i);
                id= (int)ob[0];
                if(id==estudio.getIdfragmentoFragmento()){
                    cboxFragmento2.setSelectedIndex(i);
                }
            }
            for (int i = 0;i<cboxPatologo2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxPatologo2.getItemAt(i);
                id= (int)ob[0];
                if(id==estudio.getIdpatologoPatologo()){
                    cboxPatologo2.setSelectedIndex(i);
                }
            }
            Estudio est = entityManager.find(Estudio.class, estudio.getIdestudio());
            entityManager.refresh(est);
            est= entityManager.merge(est);
            
            Collection<Observacion> observadoress = est.getObservacionCollection();
            PanelObservacion pnO;
            
            pnContenedorObservaciones.removeAll();
            
            for (Observacion observadores : observadoress) {
                pnO = new PanelObservacion(observadores,this);
                pnContenedorObservaciones.add(pnO);
                pnO.setVisible(true);
        }
            
        revalidate();
        repaint();
    }

    @Override
    public boolean IsPinned() {
        return isPinned;
    }

    @Override
    public boolean Borrar() {
        boolean b = false;
        Estudio est = entityManager.find(Estudio.class, estudio.getIdestudio());
        if (est.getResultado()==null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(est);
                entityManager.flush();
                entityManager.getTransaction().commit();
                b= true;
                
            } catch (Exception e) {
                if(entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Estudio no puede ser borrado. Tiene el resultado "+est.getResultado().getIdresultado().toString()+" relacionado");
        }
        return b;
    }

    @Override
    public void CargarMantenimiento(JPanel pnvwr, JPanel pnfrm, boolean sobreponer) {
        padre.SetPanel(pnfrm, pnvwr, sobreponer);
        
        IMantenimiento m = (IMantenimiento)pnfrm;
        IViewerObservable v = (IViewerObservable)pnvwr;
        
        m.bind(v, padre);
        v.bind(m);
    }

    @Override
    public void MandarSizePadre(Integer size) {
        padre.SetDividerSize(size);
    }
    private boolean Validar(){
        boolean b = true;
        for (Component component : jPanel3.getComponents()) {
            if(component instanceof JTextField){
                if (((JTextField)component).getText().isEmpty()) {
                    b = false;
                    ((JTextField)component).requestFocus();
                    break;
                }
            }else
            if(component instanceof JComboBox){  
                int id = 0;
                Object[] ob; 
                ob = (Object[])((JComboBox)component).getSelectedItem();
                id = (int) ob[0];
                if (id ==0) {
                    b = false;    
                    ((JComboBox)component).requestFocus();
                    break;
                }
            }
//            if(component instanceof JDateChooser){
//                if (((JDateChooser)component).getDate()!=(new Date())) {
//                    b = false;
//                }
//            }
        }
        return b;
    }
}
