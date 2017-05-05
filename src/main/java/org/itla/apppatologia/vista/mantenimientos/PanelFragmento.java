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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.itla.apppatologia.DTO.CasoDTO;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.DTO.PacienteDTO;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Empleado;
import org.itla.apppatologia.Repository.EstadoFragmento;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Frasco;
import org.itla.apppatologia.Repository.Medico;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.Registro;
import org.itla.apppatologia.Repository.TipoFragmento;
import org.itla.apppatologia.appservices.CasoService;
import org.itla.apppatologia.appservices.FragmentoService;
import org.itla.apppatologia.appservices.ICasoAppService;
import org.itla.apppatologia.appservices.IFragmentoAppService;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.GenerarReporte;
import org.itla.apppatologia.utilidades.MyListRendeder;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.viewers.IViewerObservable;

/**
 *
 * @author Giame
 */
public class PanelFragmento extends javax.swing.JPanel implements IMantenimiento{

    EntityManager entityManager;
    Contexto context;
    private List<TipoFragmento> tiposFragmento;
    private List<EstadoFragmento> estadosFragmentos;
    private List<Empleado> empleados;
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Aseguradora> aseguradoras;
    private FragmentoDTO fragmento;
    private CasoDTO caso;
    private Paciente paciente;
    IFragmentoAppService fragmentoService;
    ICasoAppService casoService;
    IPanelCentralObservador padre;
    IViewerObservable viewerAsociado;
    String nombre ;
    boolean isPinned = false;
    /**
     * Creates new form PanelFragmento
     */
    public PanelFragmento() {
        initComponents();
        
        fragmentoService = new FragmentoService();
        casoService = new CasoService();
        nombre="fragmento";
        
        
         context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        pacientes = entityManager.createNamedQuery("Paciente.findAll").getResultList();
        
        CargarCombos();
        CanModify(false);
    }
    public PanelFragmento(PacienteDTO paciente) {
        initComponents();
        fragmentoService = new FragmentoService();
        nombre="fragmento";
        casoService = new CasoService();
        
         context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        pacientes = entityManager.createNamedQuery("Paciente.findAll").getResultList();
        Clean();
        this.paciente = entityManager.find(Paciente.class, paciente.getIdpaciente());
        
        jTextField1.setText(this.paciente.getNombre());
        CargarCombos();
//        int id = 0;
//            for (int i = 0;i<cboxPaciente2.getItemCount();i++) {
//                
//                Object[] ob = (Object[]) cboxPaciente2.getItemAt(i);
//                id= (int)ob[0];
//                if(id==paciente.getIdpaciente()){
//                    cboxPaciente2.setSelectedIndex(i);
//                }
//            }
        CanModify(true);
    }
    

    public void CargarCombos(){
        
        tiposFragmento = entityManager.createNamedQuery("TipoFragmento.findAll").getResultList();
        empleados = entityManager.createNamedQuery("Empleado.findAll").getResultList();
        estadosFragmentos = entityManager.createNamedQuery("EstadoFragmento.findAll").getResultList();
        medicos = entityManager.createNamedQuery("Medico.findAll").getResultList();
        pacientes = entityManager.createNamedQuery("Paciente.findAll").getResultList();
        aseguradoras = entityManager.createNamedQuery("Aseguradora.findAll").getResultList();
        
        cboxTipoFragmento.setRenderer(new MyListRendeder());
        cboxEstadoFragmento.setRenderer(new MyListRendeder());
        cboxMedico2.setRenderer(new MyListRendeder());
//        cboxPaciente2.setRenderer(new MyListRendeder());
        cboxAseguradora2.setRenderer(new MyListRendeder());
//        

        Object[] itemBlank = new Object[]{0,""};
        cboxTipoFragmento.addItem(itemBlank);
        cboxEstadoFragmento.addItem(itemBlank);
        cboxMedico2.addItem(itemBlank);
//        cboxPaciente2.addItem(itemBlank);
        cboxAseguradora2.addItem(itemBlank);
        
        for (TipoFragmento tipoFragmento : tiposFragmento) {
            Object[] itemData = new Object[]{tipoFragmento.getIdtipoFragmento(),tipoFragmento.getNombre()};
            cboxTipoFragmento.addItem(itemData);
        }
        for (EstadoFragmento estadoFragmento : estadosFragmentos) {
            Object[] itemData = new Object[]{estadoFragmento.getIdestadoFragmento(),estadoFragmento.getNombre()};
            cboxEstadoFragmento.addItem(itemData);
        }
        for (Medico medico : medicos) {
            Object[] itemData = new Object[]{medico.getIdmedico(),medico.getNombre()};
            cboxMedico2.addItem(itemData);
        }
//        for (Paciente paciente : pacientes) {
//            Object[] itemData = new Object[]{paciente.getIdpaciente(),paciente.getNombre()};
//            cboxPaciente2.addItem(itemData);
//        }
        
        for (Aseguradora aseguradora : aseguradoras) {
            Object[] itemData = new Object[]{aseguradora.getIdaseguradora(),aseguradora.getNombre()};
            cboxAseguradora2.addItem(itemData);
        }
    }
    public void Enlazar(){
        nombre="fragmento";
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
        lblTipoFragmento = new javax.swing.JLabel();
        cboxTipoFragmento = new javax.swing.JComboBox();
        lblOrigen2 = new javax.swing.JLabel();
        txtOrigen2 = new javax.swing.JTextField();
        lblEstructura2 = new javax.swing.JLabel();
        txtEstructura2 = new javax.swing.JTextField();
        lblDimencion2 = new javax.swing.JLabel();
        txtDimencion2 = new javax.swing.JTextField();
        cboxEstadoFragmento = new javax.swing.JComboBox();
        lblEstadoFragmento = new javax.swing.JLabel();
        lblForma2 = new javax.swing.JLabel();
        txtForma2 = new javax.swing.JTextField();
        txtPeso2 = new javax.swing.JTextField();
        lblPeso2 = new javax.swing.JLabel();
        lblColor2 = new javax.swing.JLabel();
        txtColor2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        lblDiagnostico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblValorCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNoReclamacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoPoliza = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPorcientoCobertura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboxAseguradora2 = new javax.swing.JComboBox();
        lblPaciente2 = new javax.swing.JLabel();
        cboxMedico2 = new javax.swing.JComboBox();
        lblMedico2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tbPinned = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlCampos2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre2.setText("Código");

        lblValorCodigo2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        lblValorCodigo2.setForeground(new java.awt.Color(204, 0, 0));
        lblValorCodigo2.setText("0");

        lblFecha2.setText("Fecha ingreso de fragmento");

        jDateChooser1.setDateFormatString("d-MM-yyyy");

        lblTipoFragmento.setText("Tipo de fragmento");

        cboxTipoFragmento.setBackground(new java.awt.Color(245, 245, 244));
        cboxTipoFragmento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblOrigen2.setText("Origen");

        lblEstructura2.setText("Estructura");

        lblDimencion2.setText("Dimención");

        cboxEstadoFragmento.setBackground(new java.awt.Color(245, 245, 244));
        cboxEstadoFragmento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblEstadoFragmento.setText("Estado de fragmento");

        lblForma2.setText("Forma");

        lblPeso2.setText("Peso");

        lblColor2.setText("Color");

        javax.swing.GroupLayout pnlCampos2Layout = new javax.swing.GroupLayout(pnlCampos2);
        pnlCampos2.setLayout(pnlCampos2Layout);
        pnlCampos2Layout.setHorizontalGroup(
            pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCampos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDimencion2)
                            .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblOrigen2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEstructura2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTipoFragmento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCampos2Layout.createSequentialGroup()
                                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEstructura2)
                                    .addComponent(txtOrigen2)
                                    .addComponent(txtDimencion2))
                                .addGap(29, 29, 29)
                                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPeso2)
                                    .addComponent(lblForma2)
                                    .addComponent(lblColor2))
                                .addGap(79, 79, 79))
                            .addGroup(pnlCampos2Layout.createSequentialGroup()
                                .addComponent(cboxTipoFragmento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29)
                                .addComponent(lblEstadoFragmento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtForma2)
                            .addComponent(txtPeso2)
                            .addComponent(txtColor2)
                            .addComponent(cboxEstadoFragmento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addComponent(lblNombre2)
                        .addGap(27, 27, 27)
                        .addComponent(lblValorCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(lblFecha2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlCampos2Layout.setVerticalGroup(
            pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCampos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCampos2Layout.createSequentialGroup()
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha2)
                            .addComponent(lblNombre2)
                            .addComponent(lblValorCodigo2))
                        .addGap(18, 18, 18)))
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoFragmento)
                    .addComponent(cboxTipoFragmento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoFragmento)
                    .addComponent(cboxEstadoFragmento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrigen2)
                            .addComponent(txtOrigen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblForma2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstructura2)
                            .addComponent(txtEstructura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeso2))
                        .addGap(16, 16, 16)
                        .addGroup(pnlCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDimencion2)
                            .addComponent(txtDimencion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor2)))
                    .addGroup(pnlCampos2Layout.createSequentialGroup()
                        .addComponent(txtForma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPeso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblDescripcion.setText("Descripción");

        lblDiagnostico.setText("Diagnostico");

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setRows(5);
        jScrollPane2.setViewportView(txtDiagnostico);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblDiagnostico)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(lblDiagnostico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 255)));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabel1.setText("Datos del caso");

        jLabel2.setText("Código");

        lblValorCodigo.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        lblValorCodigo.setForeground(new java.awt.Color(204, 0, 0));
        lblValorCodigo.setText("0");

        jLabel3.setText("No. reclamación");

        jLabel4.setText("No. póliza");

        jLabel5.setText("Aseguradora");

        jLabel6.setText("Porciento cobertura");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/principales/historial-medico.png"))); // NOI18N

        cboxAseguradora2.setBackground(new java.awt.Color(245, 245, 244));
        cboxAseguradora2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcientoCobertura))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoPoliza))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoReclamacion))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblValorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(cboxAseguradora2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblValorCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNoPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNoReclamacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboxAseguradora2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPorcientoCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addGap(32, 32, 32))
        );

        lblPaciente2.setText("Paciente");

        cboxMedico2.setBackground(new java.awt.Color(245, 245, 244));
        cboxMedico2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblMedico2.setText("Médico");

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
                .addContainerGap(36, Short.MAX_VALUE)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(50, 56));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPaciente2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMedico2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxMedico2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente2)
                    .addComponent(lblMedico2)
                    .addComponent(cboxMedico2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCampos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPinnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPinnedActionPerformed
        isPinned = tbPinned.isSelected();
        padre.IsPinned(isPinned);
        
    }//GEN-LAST:event_tbPinnedActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboxAseguradora2;
    private javax.swing.JComboBox cboxEstadoFragmento;
    private javax.swing.JComboBox cboxMedico2;
    private javax.swing.JComboBox cboxTipoFragmento;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblColor2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblDimencion2;
    private javax.swing.JLabel lblEstadoFragmento;
    private javax.swing.JLabel lblEstructura2;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblForma2;
    private javax.swing.JLabel lblMedico2;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblOrigen2;
    private javax.swing.JLabel lblPaciente2;
    private javax.swing.JLabel lblPeso2;
    private javax.swing.JLabel lblTipoFragmento;
    private javax.swing.JLabel lblValorCodigo;
    private javax.swing.JLabel lblValorCodigo2;
    private javax.swing.JPanel pnlCampos2;
    private javax.swing.JToggleButton tbPinned;
    private javax.swing.JTextField txtColor2;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtDimencion2;
    private javax.swing.JTextField txtEstructura2;
    private javax.swing.JTextField txtForma2;
    private javax.swing.JTextField txtNoPoliza;
    private javax.swing.JTextField txtNoReclamacion;
    private javax.swing.JTextField txtOrigen2;
    private javax.swing.JTextField txtPeso2;
    private javax.swing.JTextField txtPorcientoCobertura;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bind(IViewerObservable v, IPanelCentralObservador p) {
        viewerAsociado = v;
        padre = p;
    }

    @Override
    public Fragmento Save() {
        fragmento = new FragmentoDTO();
        int idfragmento = 0;
        if(Validar(jPanel1)&&Validar(jPanel3)&&Validar(pnlCampos2)&&Validar(jPanel6)){
            fragmento.setId(Integer.parseInt(lblValorCodigo2.getText()));
            fragmento.setColor(txtColor2.getText());
            fragmento.setDescripcion(txtDescripcion.getText());
            fragmento.setDiagnostico(txtDiagnostico.getText());
            fragmento.setDimencion(txtDimencion2.getText());
            fragmento.setEstructura(txtEstructura2.getText());
            fragmento.setFecha(jDateChooser1.getDate());
            fragmento.setForma(txtForma2.getText());
            fragmento.setOrigen(txtOrigen2.getText());
            fragmento.setPero(txtPeso2.getText());

            fragmento.setIdPaciente(paciente.getIdpaciente());

            int id;
            Object[] ob; 

            ob = (Object[]) cboxTipoFragmento.getSelectedItem();
            id = (int) ob[0];
            fragmento.setIdTipo(id);

            ob = (Object[]) cboxMedico2.getSelectedItem();
            id = (int) ob[0];
            fragmento.setIdMedico(id);

            ob = (Object[]) cboxEstadoFragmento.getSelectedItem();
            id = (int) ob[0];
            fragmento.setIdEstado(id);

  
            idfragmento = fragmentoService.GuardarFragmento(fragmento);
            
            Fragmento frag = entityManager.find(Fragmento.class, idfragmento);
            
            caso = new CasoDTO();
            
            caso.setIdcaso(Integer.parseInt(lblValorCodigo.getText()));
            caso.setEstado("INICIADO");
            caso.setNumero_poliza(txtNoPoliza.getText());
            caso.setNumero_reclamacion(txtNoReclamacion.getText());
            caso.setIs_active(true);
            caso.setPorciento_cobertura(Float.parseFloat(txtPorcientoCobertura.getText()));
            caso.setIdfragmento(idfragmento);
            int idPaciente = entityManager.find(Frasco.class, frag.getIdfrascoFrasco().getIdfrasco()).getIdpacientePaciente().getIdpaciente();
            caso.setIdpaciente(idPaciente);

            ob = (Object[]) cboxAseguradora2.getSelectedItem();
            id = (int) ob[0];
            caso.setIdaseguradora(id);
            casoService.GuardarCaso(caso);


            Registro registro = new Registro();
            entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
            try {

                entityManager.getTransaction().begin();
                registro.setFecha(new Date());
                registro.setDescripcion("Descripcion "+(new Date()).toString());
                registro.setIdcasoCaso(entityManager.find(Caso.class, caso.getIdcaso()));
                registro.setIdempleadoEmpleado(entityManager.find(Empleado.class, 2));
                registro.setTabla("Tabla");
                entityManager.persist(registro);
                entityManager.getTransaction().commit();


            } catch (Exception e) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                System.out.println(e.getMessage());
                throw e;
            }

            GenerarReporte gr = new GenerarReporte();

            int opt2 = JOptionPane.showConfirmDialog(null, 
                                                  "¿Desea imprimir el ticket del frasco?", 
                                                  "Imprimir",
                                                  JOptionPane.YES_NO_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE);
            if(opt2==0){
                if(idfragmento>0){
                    gr.TicketeFrascoByCaso(caso.getIdcaso());
                }
            }
            int opt = JOptionPane.showConfirmDialog(null, 
                                                  "¿Desea imprimir comprobante?", 
                                                  "Imprimir",
                                                  JOptionPane.YES_NO_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE);
            if(opt==0){
                if(idfragmento>0){
                    gr.ComprobanteCaso(caso.getIdcaso());
                }
        }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede guardar");
        }
        Fragmento frag = entityManager.find(Fragmento.class, fragmento.getId());
    return frag;
    }

    @Override
    public boolean Clean() {
        jTextField1.setText("");
        lblValorCodigo.setText("0");
        lblValorCodigo2.setText("0");
        txtNoPoliza.setText("");
        txtNoReclamacion.setText("");
        //aseguradora
        cboxAseguradora2.removeAllItems();
        Object[] itemBlank = new Object[]{0,""};
        cboxAseguradora2.addItem(itemBlank);   
        if(aseguradoras!=null)
            for (Aseguradora aseguradora : aseguradoras) {
                Object[] itemData = new Object[]{aseguradora.getIdaseguradora(),aseguradora.getNombre()};
                cboxAseguradora2.addItem(itemData);
            }
        txtPorcientoCobertura.setText("");
        jDateChooser1.setDate(null);
        //tipo fragmento
        cboxTipoFragmento.removeAllItems();
        cboxTipoFragmento.addItem(itemBlank); 
        if(tiposFragmento!=null)
            for (TipoFragmento tipoFragmento : tiposFragmento) {
                Object[] itemData = new Object[]{tipoFragmento.getIdtipoFragmento(),tipoFragmento.getNombre()};
                cboxTipoFragmento.addItem(itemData);
            }
        //estado fragmento
        cboxEstadoFragmento.removeAllItems();
        cboxEstadoFragmento.addItem(itemBlank);  
        if(estadosFragmentos!=null)
            for (EstadoFragmento estadoFragmento : estadosFragmentos) {
                Object[] itemData = new Object[]{estadoFragmento.getIdestadoFragmento(),estadoFragmento.getNombre()};
                cboxEstadoFragmento.addItem(itemData);
            }
        txtOrigen2.setText("");
        txtForma2.setText("");
        txtEstructura2.setText("");
        txtPeso2.setText("");
        txtDimencion2.setText("");
        txtColor2.setText("");
        txtDescripcion.setText("");
        txtDiagnostico.setText("");
        
        paciente = null;
        
        
        return true;
    }

    @Override
    public boolean CanModify(boolean b) {
        txtNoPoliza.setEnabled(b);
        txtNoReclamacion.setEnabled(b);
        cboxAseguradora2.setEnabled(b);
        txtPorcientoCobertura.setEnabled(b);
        jDateChooser1.setEnabled(b);
        txtOrigen2.setEnabled(b);
        txtEstructura2.setEnabled(b);
        txtDimencion2.setEnabled(b);
        txtForma2.setEnabled(b);
        txtPeso2.setEnabled(b);
        txtColor2.setEnabled(b);
        cboxMedico2.setEnabled(b);
        cboxTipoFragmento.setEnabled(b);
        cboxEstadoFragmento.setEnabled(b);
        txtDescripcion.setEnabled(b);
        txtDiagnostico.setEnabled(b);
        
        return !b;
    }

    @Override
    public void Show(Object o) {
            fragmento = (FragmentoDTO) o;
            
            Frasco frasc = entityManager.find(Frasco.class,fragmento.getIdFrasco());
            paciente = frasc.getIdpacientePaciente();
            jTextField1.setText(paciente.getNombre());
            jLabel8.setText(paciente.getIdpaciente().toString());
            
            lblValorCodigo2.setText(Integer.toString(fragmento.getId()));
            txtOrigen2.setText(fragmento.getOrigen());
            jDateChooser1.setDate(fragmento.getFecha());
            txtEstructura2.setText(fragmento.getEstructura());
            txtDimencion2.setText(fragmento.getDimencion());
            txtForma2.setText(fragmento.getForma());
            txtPeso2.setText(fragmento.getPero());
            txtColor2.setText(fragmento.getColor());
            txtDimencion2.setText(fragmento.getDimencion());
            txtDescripcion.setText(fragmento.getDescripcion());
            txtDiagnostico.setText(fragmento.getDiagnostico());
            
//            entityManager.find(Frasco.class, fragmento.getIdFrasco()).getIdpacientePa
            
            
            
            int id = 0;
            for (int i = 0;i<cboxTipoFragmento.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxTipoFragmento.getItemAt(i);
                id= (int)ob[0];
                if(id==fragmento.getIdTipo()){
                    cboxTipoFragmento.setSelectedIndex(i);
                }
            }
            for (int i = 0;i<cboxMedico2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxMedico2.getItemAt(i);
                id= (int)ob[0];
                if(id==fragmento.getIdMedico()){
                    cboxMedico2.setSelectedIndex(i);
                }
            }
            for (int i = 0;i<cboxEstadoFragmento.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxEstadoFragmento.getItemAt(i);
                id= (int)ob[0];
                if(id==fragmento.getIdEstado()){
                    cboxEstadoFragmento.setSelectedIndex(i);
                }
            }
           Caso caso = (Caso) entityManager.createNamedQuery("Caso.findByIdFragmento",Caso.class).setParameter("idfragmento", fragmento.getId()).getSingleResult();
           
           lblValorCodigo.setText(caso.getIdcaso().toString());
           txtNoPoliza.setText(caso.getNumeroPoliza());
           txtNoReclamacion.setText(caso.getNumeroReclamacion());
           txtPorcientoCobertura.setText(Float.toString(caso.getPorciento_cobertura()));
           
           for (int i = 0;i<cboxAseguradora2.getItemCount();i++) {
                
                Object[] ob = (Object[]) cboxAseguradora2.getItemAt(i);
                id= (int)ob[0];
                if(id==caso.getIdaseguradoraAseguradora().getIdaseguradora()){
                    cboxAseguradora2.setSelectedIndex(i);
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
        Fragmento frag = entityManager.find(Fragmento.class, fragmento.getId());
        if(frag.getEstudio()==null){
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(frag);
                entityManager.flush();
                entityManager.getTransaction().commit();
                b= true;
                
            } catch (Exception e) {
                if(entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "El fragmento no puede ser borrado. Está siendo estudiado.");
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
            }else
            if(component instanceof JTextArea){
                if (((JTextArea)component).getText().isEmpty()) {
                    b = false;
                    ((JTextArea)component).requestFocus();
                    break;
                }
            }else
            if(component instanceof JDateChooser){
                if (((JDateChooser)component).getDate()==null) {
                    b = false;
                    ((JDateChooser)component).requestFocus();
                    break;
                }
            }else
            if(component instanceof JComboBox){  
                int id = 0;
                Object[] ob= null; Object ob2=null;
                JComboBox jcb = (JComboBox)component;
                
                ob = (Object[])jcb.getSelectedItem();
                if(ob==null){
                    b = false;//SI EL COMPONENTE NO TIENE SELECCIONADO
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
                
            }
        }
        return b;
    }
}
