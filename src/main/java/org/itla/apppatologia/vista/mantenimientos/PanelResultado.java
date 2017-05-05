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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.itla.apppatologia.DTO.ArsDTO;
import org.itla.apppatologia.DTO.CasoDTO;
import org.itla.apppatologia.DTO.EmpleadoDTO;
import org.itla.apppatologia.DTO.EstudioDTO;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.DTO.ResultadoDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Empleado;
import org.itla.apppatologia.Repository.EstadoFragmento;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Frasco;
import org.itla.apppatologia.Repository.Medico;
import org.itla.apppatologia.Repository.Observacion;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.Registro;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.Repository.TipoFragmento;
import org.itla.apppatologia.appservices.CasoService;
import org.itla.apppatologia.appservices.FragmentoService;
import org.itla.apppatologia.appservices.ICasoAppService;
import org.itla.apppatologia.appservices.IFragmentoAppService;
import org.itla.apppatologia.appservices.IResultadoAppService;
import org.itla.apppatologia.appservices.ResultadoService;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.MyListRendeder;
import org.itla.apppatologia.vista.MainFrame;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.viewers.IViewerObservable;

/**
 *
 * @author Giame
 */
public class PanelResultado extends javax.swing.JPanel implements IMantenimiento{

    EntityManager entityManager;
    Contexto context;
    
    private ResultadoDTO resultado;
    private Resultado resultadoJPA;
    private EstudioDTO estudio;
    private Estudio estudioJPA;
    private EmpleadoDTO empleado;
    
    IResultadoAppService resultadoService;
    
    IPanelCentralObservador padre;
    IViewerObservable viewerAsociado;
    String nombre ;
    boolean isPinned = false;
    /**
     * Creates new form PanelFragmento
     */
    public PanelResultado() {
        initComponents();
        resultadoService = new ResultadoService();
        
        nombre="resultado";
        
        
         context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        CargarCombos();
        jDateChooser1.setDate(new Date());
        CanModify(false);
    }
    public PanelResultado(EstudioDTO estudio) {
        initComponents();
        resultadoService = new ResultadoService();
        nombre="resultado";
        this.estudio = estudio;
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        estudioJPA = entityManager.find(Estudio.class, estudio.getIdestudio());
        jDateChooser1.setDate(new Date());
        CanModify(false);
    }

    public PanelResultado(Resultado resultado) {
        initComponents();
        resultadoService = new ResultadoService();
        nombre="resultado";
        this.resultadoJPA = resultado;
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        Clean();
        estudioJPA = resultadoJPA.getIdestudioEstudio();
        jDateChooser1.setDate(new Date());
        //lblValorCodigo2.setText(resultadoJPA.getIdresultado().toString());
        txtEstudio.setText(estudioJPA.getIdestudio().toString());
        CanModify(true);
    }
    public void CargarCombos(){
        
//        aseguradoras = entityManager.createNamedQuery("Aseguradora.findAll").getResultList();
//        
//        cboxTipoFragmento.setRenderer(new MyListRendeder());
//        
////        
//      
//        for (Aseguradora aseguradora : aseguradoras) {
//            Object[] itemData = new Object[]{aseguradora.getIdaseguradora(),aseguradora.getNombre()};
//            cboxAseguradora2.addItem(itemData);
//        }
    }
    public void Enlazar(){
        nombre="resultado";
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
        pnlCampos2 = new javax.swing.JPanel();
        lblNombre2 = new javax.swing.JLabel();
        lblValorCodigo2 = new javax.swing.JLabel();
        lblFecha2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblOrigen2 = new javax.swing.JLabel();
        txtEstudio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEtiologia = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPatogenia = new javax.swing.JTextArea();
        lblDiagnostico = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtManifestracionesClinicas = new javax.swing.JTextArea();
        lblDiagnostico1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCambiosMorfologicos = new javax.swing.JTextArea();
        lblDescripcion1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAviso = new javax.swing.JTextArea();
        lblDiagnostico2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtRecomendacion = new javax.swing.JTextArea();
        lblDescripcion2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tbPinned = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlCampos2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre2.setText("Código");

        lblValorCodigo2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        lblValorCodigo2.setForeground(new java.awt.Color(204, 0, 0));
        lblValorCodigo2.setText("0");

        lblFecha2.setText("fecha");

        lblOrigen2.setText("Estudio");

        txtEtiologia.setColumns(2);
        txtEtiologia.setLineWrap(true);
        txtEtiologia.setRows(3);
        txtEtiologia.setTabSize(4);
        jScrollPane1.setViewportView(txtEtiologia);

        lblDescripcion.setText("Etiología");

        txtPatogenia.setColumns(2);
        txtPatogenia.setLineWrap(true);
        txtPatogenia.setRows(3);
        txtPatogenia.setTabSize(4);
        jScrollPane2.setViewportView(txtPatogenia);

        lblDiagnostico.setText("Patogenia");

        txtManifestracionesClinicas.setColumns(2);
        txtManifestracionesClinicas.setLineWrap(true);
        txtManifestracionesClinicas.setRows(3);
        txtManifestracionesClinicas.setTabSize(4);
        jScrollPane3.setViewportView(txtManifestracionesClinicas);

        lblDiagnostico1.setText("Manifestaciones clínicas");

        txtCambiosMorfologicos.setColumns(2);
        txtCambiosMorfologicos.setLineWrap(true);
        txtCambiosMorfologicos.setRows(3);
        txtCambiosMorfologicos.setTabSize(4);
        jScrollPane4.setViewportView(txtCambiosMorfologicos);

        lblDescripcion1.setText("Cambios morfológicos");

        txtAviso.setColumns(2);
        txtAviso.setLineWrap(true);
        txtAviso.setRows(3);
        txtAviso.setTabSize(4);
        jScrollPane5.setViewportView(txtAviso);

        lblDiagnostico2.setText("Aviso");

        txtRecomendacion.setColumns(2);
        txtRecomendacion.setLineWrap(true);
        txtRecomendacion.setRows(3);
        txtRecomendacion.setTabSize(4);
        jScrollPane6.setViewportView(txtRecomendacion);

        lblDescripcion2.setText("Recomendación");

        javax.swing.GroupLayout pnlCampos2Layout = new javax.swing.GroupLayout(pnlCampos2);
        pnlCampos2.setLayout(pnlCampos2Layout);
        pnlCampos2Layout.setHorizontalGroup(
            pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCampos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrigen2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre2))
                        .addGap(27, 27, 27)
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCampos2Layout.createSequentialGroup()
                                .addComponent(lblValorCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecha2)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtEstudio)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescripcion)
                    .addComponent(lblDiagnostico)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescripcion1)
                    .addComponent(lblDiagnostico1)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescripcion2)
                    .addComponent(lblDiagnostico2))
                .addContainerGap())
        );
        pnlCampos2Layout.setVerticalGroup(
            pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCampos2Layout.createSequentialGroup()
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre2)
                            .addComponent(lblValorCodigo2)
                            .addComponent(lblFecha2)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigen2)
                    .addComponent(txtEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDiagnostico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDiagnostico1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDiagnostico2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbPinned.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/pushpin.png"))); // NOI18N
        tbPinned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPinnedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(tbPinned, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPinned)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(pnlCampos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPinnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPinnedActionPerformed
        isPinned = tbPinned.isSelected();
        padre.IsPinned(isPinned);
        
    }//GEN-LAST:event_tbPinnedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JLabel lblDescripcion2;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblDiagnostico1;
    private javax.swing.JLabel lblDiagnostico2;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblOrigen2;
    private javax.swing.JLabel lblValorCodigo2;
    private javax.swing.JPanel pnlCampos2;
    private javax.swing.JToggleButton tbPinned;
    private javax.swing.JTextArea txtAviso;
    private javax.swing.JTextArea txtCambiosMorfologicos;
    private javax.swing.JTextField txtEstudio;
    private javax.swing.JTextArea txtEtiologia;
    private javax.swing.JTextArea txtManifestracionesClinicas;
    private javax.swing.JTextArea txtPatogenia;
    private javax.swing.JTextArea txtRecomendacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bind(IViewerObservable v, IPanelCentralObservador p) {
        viewerAsociado = v;
        padre = p;
    }

    @Override
    public Resultado Save() {
        resultadoJPA = new Resultado();
        if(Validar(pnlCampos2)){
            try {
                entityManager.getTransaction().begin();
                
                resultadoJPA.setIdresultado(Integer.parseInt(lblValorCodigo2.getText()));
                resultadoJPA.setAviso(txtAviso.getText());
                resultadoJPA.setCambioMorfologico(txtCambiosMorfologicos.getText());
                resultadoJPA.setEtiologia(txtEtiologia.getText());
                resultadoJPA.setIdempleado(Short.parseShort(((MainFrame)padre).getEmp().getIdempleado().toString()));                                 

                if(estudioJPA!=null){
                    resultadoJPA.setIdestudioEstudio(estudioJPA);
                }else{
                    resultadoJPA.setIdestudioEstudio(entityManager.find(Estudio.class, Integer.parseInt(txtEstudio.getText())));
                }

                resultadoJPA.setFecha(jDateChooser1.getDate());
                resultadoJPA.setManifestacionClinica(txtManifestracionesClinicas.getText());
                resultadoJPA.setPatogenia(txtPatogenia.getText());
                resultadoJPA.setRecomendacion(txtRecomendacion.getText());
                resultadoJPA.setIsActivo(true);

                entityManager.persist(resultadoJPA);

                int idCaso=0;
                Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
                for (Caso caso : casos) {
                    if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                        idCaso = caso.getIdcaso();
                    }
                }

                Caso caso;
                caso = entityManager.find(Caso.class, idCaso);

                caso.setEstado("PENDIENTE A ENTREGA");
                entityManager.persist(caso);
                if(resultadoJPA.getIdresultado()>0)
                    entityManager.refresh(resultadoJPA);
                int idresultado = resultadoService.GuardarResultado(resultadoJPA);
            
                Collection<Observacion> observaciones = null;
                if(estudioJPA!=null){
                    
                    observaciones= estudioJPA.getObservacionCollection();
                }else if(resultadoJPA.getIdestudioEstudio()!=null){
                    observaciones = resultadoJPA.getIdestudioEstudio().getObservacionCollection();
                }
                        //entityManager.
//                        createNamedQuery("Observacion.findByIdestudio",Observacion.class).
//                        setParameter("idestudio", estudioJPA.getIdestudio()).getResultList();
                entityManager.refresh(resultadoJPA);
                for (Observacion observacione : observaciones) {
                    observacione.setIdresultadoResultado(resultadoJPA);
                    entityManager.persist(observacione);
                    //entityManager.merge(observacione);
                }
                entityManager.getTransaction().commit();
                
            } catch (Exception e) {
                if(entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede guardar");
        }
        
        
    return resultadoJPA;
    }

    @Override
    public boolean Clean() {
        lblValorCodigo2.setText("0");
        txtEstudio.setText("");
        txtEtiologia.setText("");
        txtPatogenia.setText("");
        txtCambiosMorfologicos.setText("");
        txtManifestracionesClinicas.setText("");
        txtRecomendacion.setText("");
        txtAviso.setText("");
        jDateChooser1.setDate(new Date());
        return true;
    }

    @Override
    public boolean CanModify(boolean b) {
        jDateChooser1.setEnabled(b);
        txtEstudio.setEnabled(false);
        txtEtiologia.setEnabled(b);
        txtPatogenia.setEnabled(b);
        txtCambiosMorfologicos.setEnabled(b);
        txtManifestracionesClinicas.setEnabled(b);
        txtRecomendacion.setEnabled(b);
        txtAviso.setEnabled(b);
        return !b;
    }

    @Override
    public void Show(Object o) {
            resultadoJPA = (Resultado) o;
            
            lblValorCodigo2.setText(Integer.toString(resultadoJPA.getIdresultado()));
            txtEtiologia.setText(resultadoJPA.getEtiologia());
            jDateChooser1.setDate(resultadoJPA.getFecha());
            txtPatogenia.setText(resultadoJPA.getPatogenia());
            txtCambiosMorfologicos.setText(resultadoJPA.getCambioMorfologico());
            txtManifestracionesClinicas.setText(resultadoJPA.getManifestacionClinica());
            txtRecomendacion.setText(resultadoJPA.getRecomendacion());
            txtAviso.setText(resultadoJPA.getAviso());
            
            txtEstudio.setText(resultadoJPA.getIdestudioEstudio().getIdestudio().toString());
//            entityManager.find(Estudio.class, resultadoJPA.getIdestudio());
//            entityManager.find(Empleado.class, resultadoJPA.getIdempleado());
                       
    }

    @Override
    public boolean IsPinned() {
        return isPinned;
    }

    @Override
    public boolean Borrar() {
        boolean b = false;
        Resultado res = entityManager.find(Resultado.class, resultado.getIdresultado());
        if(res.getEntrega()==null){
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(res);
                entityManager.flush();
                entityManager.getTransaction().commit();
                b= true;
                
            } catch (Exception e) {
                if(entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "El resultado no puede ser borrado. Ya ha sido entregado.");
        }
        return b;
    }

    @Override
    public void CargarMantenimiento(JPanel pnvwr, JPanel pnfrm, boolean sobreponer) {
        padre.SetPanel(pnfrm, pnvwr,sobreponer);
        
        IMantenimiento m = (IMantenimiento)pnfrm;
        IViewerObservable v = (IViewerObservable)pnvwr;
        
        m.bind(v, padre);
        v.bind(m);
    }

    @Override
    public void MandarSizePadre(Integer size) {
        padre.SetDividerSize(size);
    }
    private boolean Validar(JPanel pn){
        boolean b = true;
        JPanel panel = pn;
        for (Component component : panel.getComponents()) {
            if(component instanceof JTextField){
                if (((JTextField)component).getText().isEmpty()) {
                    b = false;
                    ((JTextField)component).requestFocus();
                    break;
                }
            }
            if(component instanceof JDateChooser){
                if (((JDateChooser)component).getDate()==null) {
                    b = false;
                }
            }
            if(component instanceof JTextArea){  
                if (((JTextArea)component).getText().isEmpty()) {
                    b = false;
                    ((JTextArea)component).requestFocus();
                    break;
                }
            }
        }
        return b;
    }
}
