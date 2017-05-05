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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.itla.apppatologia.DTO.ArsDTO;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.Repository.Empleado;
import org.itla.apppatologia.Repository.EstadoFragmento;
import org.itla.apppatologia.Repository.Medico;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.TipoFragmento;
import org.itla.apppatologia.Repository.TipoPaciente;
import org.itla.apppatologia.appservices.FragmentoService;
import org.itla.apppatologia.appservices.IFragmentoAppService;
import org.itla.apppatologia.appservices.IPacienteAppService;
import org.itla.apppatologia.appservices.PacienteService;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.MyListRendeder;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.viewers.IViewerObservable;

/**
 *
 * @author Giame
 */
public class PanelPaciente extends javax.swing.JPanel implements IMantenimiento{

    EntityManager entityManager;
    Contexto context;
    private List<TipoPaciente> tiposPacientes;
    
    private List<Paciente> pacientes;
    private PacienteDTO paciente;
    IPacienteAppService pacienteService;
    IPanelCentralObservador padre;
    IViewerObservable viewerAsociado;
    String nombre ;
    boolean isPinned = false;
    /**
     * Creates new form PanelFragmento
     */
    public PanelPaciente() {
        initComponents();
        pacienteService = new PacienteService();
        nombre="paciente";
        
        
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        tiposPacientes = entityManager.createNamedQuery("TipoPaciente.findAll").getResultList();
        
        pacientes = entityManager.createNamedQuery("Paciente.findAll").getResultList();
        
        cboxTipoPaciente2.setRenderer(new MyListRendeder());
         
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoPaciente2.addItem(itemBlank);
//        cboxSexo.addItem(itemBlank);
        
        for (TipoPaciente tipoPaciente : tiposPacientes) {
            Object[] itemData = new Object[]{tipoPaciente.getIdtipoPaciente(),tipoPaciente.getNombre()};
            cboxTipoPaciente2.addItem(itemData);
        }
        CanModify(false);
        
    }

    public void Enlazar(){
        nombre="paciente";
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
        txtNombre2 = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxSexo = new javax.swing.JComboBox<>();
        cboxTipoPaciente2 = new javax.swing.JComboBox();

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
            .addGap(0, 36, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
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

        txtNombre.setText("Nombre");

        lblTelefono.setText("Telefono");

        lblDireccion.setText("Dirección");

        jLabel1.setText("Fecha de nacimiento");

        jDateChooser1.setDateFormatString("d-MM-yyyy");

        jLabel2.setText("Tipo de paciente");

        jLabel3.setText("Sexo");

        cboxSexo.setBackground(new java.awt.Color(245, 245, 244));
        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cboxSexo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cboxTipoPaciente2.setBackground(new java.awt.Color(245, 245, 244));
        cboxTipoPaciente2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxTipoPaciente2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblValorCodigo)
                                .addGap(149, 149, 149))
                            .addComponent(txtNombre2))))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorCodigo)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre)
                    .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxTipoPaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tbPinned, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPinnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPinnedActionPerformed
        isPinned = tbPinned.isSelected();
        padre.IsPinned(isPinned);

    }//GEN-LAST:event_tbPinnedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxSexo;
    private javax.swing.JComboBox cboxTipoPaciente2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblValorCodigo;
    private javax.swing.JToggleButton tbPinned;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bind(IViewerObservable v, IPanelCentralObservador p) {
        viewerAsociado = v;
        padre = p;
    }

    @Override
    public Paciente Save() {
        int idPac = 0;
        paciente = new PacienteDTO();
        if(Validar(jPanel3)){
        paciente.setIdpaciente(Integer.parseInt(lblValorCodigo.getText()));
        paciente.setDireccion(txtDireccion.getText());
        paciente.setFechaNacimiento(jDateChooser1.getDate());
        paciente.setNombre(txtNombre2.getText());
        paciente.setSexo(cboxSexo.getSelectedItem().toString());
        paciente.setTelefono(txtTelefono.getText());
        int id;
        Object[] ob; 
        
        ob = (Object[]) cboxTipoPaciente2.getSelectedItem();
        id = (int) ob[0];
        paciente.setIdtipoPacienteTipoPaciente(id);
        paciente.setIdtipoPaciente(id);
        idPac = pacienteService.GuardarPaciente(paciente);
        }else{
            JOptionPane.showMessageDialog(null, "No ses puede guardar");
        }
    return entityManager.find(Paciente.class, idPac);
    }

    @Override
    public boolean Clean() {
        lblValorCodigo.setText("0");
        txtNombre2.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        jDateChooser1.setDate(new Date());
        cboxTipoPaciente2.removeAllItems();
        Object[] itemBlank = new Object[]{0,""};
        cboxTipoPaciente2.addItem(itemBlank);        
        for (TipoPaciente tipoPaciente : tiposPacientes) {
            Object[] itemData = new Object[]{tipoPaciente.getIdtipoPaciente(),tipoPaciente.getNombre()};
            cboxTipoPaciente2.addItem(itemData);
        }
        cboxTipoPaciente2.addItem(itemBlank);
        cboxTipoPaciente2.setSelectedItem(0);
        cboxSexo.setSelectedItem(null);
        jDateChooser1.setDate(null);
        return true;
    }

    @Override
    public boolean CanModify(boolean b) {
        txtNombre2.setEnabled(b);
        txtDireccion.setEnabled(b);
        txtTelefono.setEnabled(b);
        cboxSexo.setEnabled(b);
        cboxTipoPaciente2.setEnabled(b);
        jDateChooser1.setEnabled(b);
        return !b;
    }

    @Override
    public void Show(Object o) {
            paciente = (PacienteDTO) o;
            lblValorCodigo.setText(Integer.toString(paciente.getIdpaciente()));
            txtNombre2.setText(paciente.getNombre());
            jDateChooser1.setDate(paciente.getFechaNacimiento());
            txtTelefono.setText(paciente.getTelefono());
            txtDireccion.setText(paciente.getDireccion());
            
            
            if(paciente.getSexo().equals("Masculino")){
                cboxSexo.setSelectedIndex(0);
            }else{
                cboxSexo.setSelectedIndex(1);
            }
            
            int id = 0;
            for (int i = 0;i<cboxTipoPaciente2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxTipoPaciente2.getItemAt(i);
                id= (int)ob[0];
                if(id==paciente.getIdtipoPaciente()){
                    cboxTipoPaciente2.setSelectedIndex(i);
                }
            }
           
    }

    @Override
    public boolean IsPinned() {
        return isPinned;
    }

    @Override
    public boolean Borrar() {
        boolean b = false;
        if(paciente!=null){
            Paciente pa = entityManager.find(Paciente.class, paciente.getIdpaciente());
            
            if(pa.getCasoCollection().isEmpty()){
                b = pacienteService.BorrarPaciente(pa.getIdpaciente());
            }else{
                JOptionPane.showMessageDialog(null, "No Puede eliminar el paciente, tiene caso registrado.");
            }
            
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
    
    private boolean Validar(){
        boolean b = true;
        for (Component component : jPanel3.getComponents()) {
            if(component instanceof JTextField){
                if (((JTextField)component).getText().isEmpty()) {
                    b = false;
                }
            }
            if(component instanceof JDateChooser){
                if (((JDateChooser)component).getDate()==null) {
                    b = false;
                }
            }
            if(component instanceof JComboBox){  
                int id = 0;
                Object[] ob= null; Object ob2=null;
                JComboBox jcb = (JComboBox)component;
                if(jcb.getItemCount()!=2){
                    ob = (Object[])jcb.getSelectedItem();
                    if(ob==null){
                        b = false;//SI EL COMPONENTE NO ES EL DE SEXO Y NO TIENE SELECCIONADO
                    }else{
                        id = (int) ob[0];
                        if (id ==0) {
                            b = false;//SI COMPONENTE TIENE SELECCIONADO AL ELEMENTO 0       
                        }
                    }
                }else{
                    ob2 = (Object)jcb.getSelectedItem();
                    if(ob2==null){
                        b = false;//SI EL COMPONENTE ES EL DE SEXO Y NO TIENE SELECCIONADO
                    }
                }
                
                
            }
        }
        return b;
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
                    ((JDateChooser)component).requestFocus();
                    break;
                }
            }
            if(component instanceof JComboBox){  
                int id = 0;
                Object[] ob= null; Object ob2=null;
                JComboBox jcb = (JComboBox)component;
                if(jcb.getItemCount()!=2){
                    ob = (Object[])jcb.getSelectedItem();
                    if(ob==null){
                        b = false;//SI EL COMPONENTE NO ES EL DE SEXO Y NO TIENE SELECCIONADO
                        ((JComboBox)component).requestFocus();
                        break;
                    }else{
                        id = (int) ob[0];
                        if (id ==0) {
                            b = false;//SI COMPONENTE TIENE SELECCIONADO AL ELEMENTO 0       
                            ((JComboBox)component).requestFocus();
                            break;
                        }
                    }
                }else{
                    ob2 = (Object)jcb.getSelectedItem();
                    if(ob2==null){
                        b = false;//SI EL COMPONENTE ES EL DE SEXO Y NO TIENE SELECCIONADO
                        ((JComboBox)component).requestFocus();
                        break;
                    }
                }
                
                
            }
        }
        return b;
    }
}