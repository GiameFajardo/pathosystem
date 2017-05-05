/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.viewers;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.itla.apppatologia.DTO.ResultadoDTO;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Entrega;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.appservices.ResultadoService;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.utilidades.GenerarReporte;
import org.itla.apppatologia.vista.mantenimientos.IMantenimiento;
import org.itla.apppatologia.vista.mantenimientos.PanelEstudio;
import org.itla.apppatologia.vista.mantenimientos.PanelPaciente;

/**
 *
 * @author Giame
 */
public class ViewerResultado extends javax.swing.JPanel implements IViewerObservable{

    EntityManager entityManager;
    Contexto context;
    private List<Resultado> resultados;
    private ResultadoDTO resultado;
    private Resultado resultadoJPA;
    private Resultado resultadoSelected;
    //private JList<Aseguradora> lista = new JList<Aseguradora>();
    /**
     * Creates new form ViewerARS
     */
    IMantenimiento mantenimientoAsociado;
    public ViewerResultado() {
        initComponents();
        
        
        
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
        
        
        tablaResultado.setModel(getModel(resultados));
        
        RedisenarTabla();
        
        String txtCantidadPacientes = "<html>El"+"% de los pacientes están afiliados a esta aseguradora. Con un total de"+" pacienetes.</html>";
        String txtFechaPrimerPacientes = "<html>El primer paciente con esta aseguradora fue registrado el día</html>";
        String txtFechaUltimoPacientes = "<html>El ultimo paciente con esta aseguradora fue registrado el día</html>";
//        jLabel9.setText(txtFechaPrimerPacientes);
//        jLabel10.setText(txtFechaUltimoPacientes);
//        jLabel6.setText(txtCantidadPacientes);
    }
    public ViewerResultado(EntityManager em) {
        initComponents();
        
        
        entityManager=em;
//        context = new  Contexto();
//        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
        
        
        tablaResultado.setModel(getModel(resultados));
        RedisenarTabla();
        
        
        
        String txtCantidadPacientes = "<html>El"+"% de los pacientes están afiliados a esta aseguradora. Con un total de"+" pacienetes.</html>";
        String txtFechaPrimerPacientes = "<html>El primer paciente con esta aseguradora fue registrado el día</html>";
        String txtFechaUltimoPacientes = "<html>El ultimo paciente con esta aseguradora fue registrado el día</html>";
//        jLabel9.setText(txtFechaPrimerPacientes);
//        jLabel10.setText(txtFechaUltimoPacientes);
//        jLabel6.setText(txtCantidadPacientes);
        
        
//        tablaResultado.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//        @Override
//        public Component getTableCellRendererComponent(JTable table,
//                Object value, boolean isSelected, boolean hasFocus, int row, int col) {
//
//            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
//
//            boolean status = (boolean)table.getModel().getValueAt(row, 10);
//            java.util.Date fecha = (Date)table.getModel().getValueAt(row, 1);
//                if (status) {
//                        setBackground(new Color(64,209,253));
//                        setForeground(Color.WHITE);
//
//    //                    System.out.println(fecha.compareTo(new Date()));
//
//                } else {
//                    setBackground(table.getBackground());
//                    setForeground(table.getForeground());
//                }       
//                return this;
//            }   
//        });
        tablaResultado.getSelectionModel().addSelectionInterval(0,0);
        Buscar();
        EnableButtoms(false,null);
    }

    @Override
    public String getName(){
        return "resultado";
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pnListaPadre = new javax.swing.JPanel();
        pnBusqueda = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JToggleButton();
        btnBorrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        pnLista = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        pnViewPadre = new javax.swing.JPanel();
        pnView = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNombreARS = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnPaciente = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnMedico = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnPatologo = new javax.swing.JButton();
        btnEstudio = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnBotones = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        pnMenuSuperior = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnEntregarResultado = new javax.swing.JButton();
        btnGenerarResultado = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jPopupMenu1.setBackground(new java.awt.Color(225, 212, 212));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/analitica_2.png"))); // NOI18N
        jMenuItem1.setText("Entregar resultado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/lapiz.png"))); // NOI18N
        jMenuItem3.setText("Editar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/goma-de-borrar.png"))); // NOI18N
        jMenuItem2.setText("Borrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jSeparator5);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/copia.png"))); // NOI18N
        jMenu1.setText("Copiar");

        jMenuItem4.setText("Nombre");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Paciente");
        jMenu1.add(jMenuItem5);

        jPopupMenu1.add(jMenu1);
        jPopupMenu1.add(jSeparator2);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/circulos/reportar.png"))); // NOI18N
        jMenu2.setText("Reporte");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/circulos/reportar.png"))); // NOI18N
        jMenuItem6.setMnemonic(' ');
        jMenuItem6.setText("Resultado");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jPopupMenu1.add(jMenu2);

        jMenu3.setText("jMenu3");

        setBackground(new java.awt.Color(255, 102, 255));
        setMinimumSize(new java.awt.Dimension(300, 660));
        setLayout(new java.awt.BorderLayout());

        pnListaPadre.setPreferredSize(new java.awt.Dimension(294, 370));
        pnListaPadre.setLayout(new javax.swing.BoxLayout(pnListaPadre, javax.swing.BoxLayout.Y_AXIS));

        pnBusqueda.setPreferredSize(new java.awt.Dimension(110, 80));
        pnBusqueda.setLayout(new java.awt.GridLayout(2, 0));

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        btnNuevo.setBackground(new java.awt.Color(255, 230, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/anadir (1).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear nuevo resultrado.");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setPreferredSize(new java.awt.Dimension(91, 44));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo);

        btnEditar.setBackground(new java.awt.Color(255, 230, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/lapiz.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar resultado seleccionado.");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditar);

        btnBorrar.setBackground(new java.awt.Color(255, 230, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/goma-de-borrar.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borra resultado seleccionado.");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBorrar);

        pnBusqueda.add(jPanel5);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        txtBuscar.setPreferredSize(new java.awt.Dimension(50, 28));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel4.add(txtBuscar);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/busqueda.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar resultado en la lista.");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/flechas-actualizar.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualizar lista de resultrados.");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar);

        pnBusqueda.add(jPanel4);

        pnListaPadre.add(pnBusqueda);

        pnLista.setLayout(new java.awt.BorderLayout());

        tablaResultado.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaResultado.setRowHeight(30);
        tablaResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaResultadoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaResultadoMouseReleased(evt);
            }
        });
        tablaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaResultadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaResultadoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tablaResultado);

        pnLista.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnListaPadre.add(pnLista);

        add(pnListaPadre, java.awt.BorderLayout.LINE_START);

        pnViewPadre.setBackground(new java.awt.Color(255, 255, 255));
        pnViewPadre.setBorder(null);
        pnViewPadre.setLayout(new java.awt.BorderLayout());

        pnView.setBackground(new java.awt.Color(255, 255, 255));
        pnView.setBorder(null);
        pnView.setForeground(new java.awt.Color(255, 255, 255));
        pnView.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 600));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 241, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(430, 660));

        lblNombreARS.setFont(new java.awt.Font("sansserif", 2, 26)); // NOI18N
        lblNombreARS.setText("nombre ARS");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel13.setText("Resultrado");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/principales/analitica (1).png"))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 251, 251));

        jPanel3.setBackground(new java.awt.Color(255, 251, 251));

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel18.setText("Paciente:");

        btnPaciente.setBackground(new java.awt.Color(255, 230, 255));
        btnPaciente.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/bata-de-paciente (1).png"))); // NOI18N
        btnPaciente.setText("Ver");
        btnPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPaciente.setPreferredSize(new java.awt.Dimension(91, 44));
        btnPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPacienteMouseClicked(evt);
            }
        });
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel19.setText("Médico:");

        btnMedico.setBackground(new java.awt.Color(255, 230, 255));
        btnMedico.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        btnMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/doctor.png"))); // NOI18N
        btnMedico.setText("Ver");
        btnMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMedico.setPreferredSize(new java.awt.Dimension(91, 44));
        btnMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMedicoMouseClicked(evt);
            }
        });
        btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel20.setText("Patólogo:");

        btnPatologo.setBackground(new java.awt.Color(255, 230, 255));
        btnPatologo.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        btnPatologo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/cientifico.png"))); // NOI18N
        btnPatologo.setText("Ver");
        btnPatologo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPatologo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPatologo.setPreferredSize(new java.awt.Dimension(91, 44));
        btnPatologo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPatologoMouseClicked(evt);
            }
        });
        btnPatologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatologoActionPerformed(evt);
            }
        });

        btnEstudio.setBackground(new java.awt.Color(255, 230, 255));
        btnEstudio.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        btnEstudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/biologia (3).png"))); // NOI18N
        btnEstudio.setText("Ver");
        btnEstudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstudio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstudio.setPreferredSize(new java.awt.Dimension(91, 44));
        btnEstudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstudioMouseClicked(evt);
            }
        });
        btnEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudioActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel21.setText("Estudio:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPatologo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(btnMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPatologo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreARS)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreARS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator3, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/graficos/grafico-de-barras (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel12)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(jPanel2);

        pnView.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pnViewPadre.add(pnView, java.awt.BorderLayout.CENTER);

        pnBotones.setLayout(new java.awt.BorderLayout());

        PanelMenu.setBackground(new java.awt.Color(255, 252, 236));
        PanelMenu.setBorder(null);
        PanelMenu.setPreferredSize(new java.awt.Dimension(85, 356));
        PanelMenu.setLayout(new java.awt.GridLayout(0, 1));

        pnMenuSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnMenuSuperior.setPreferredSize(new java.awt.Dimension(70, 170));
        pnMenuSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnMenuSuperiorMouseDragged(evt);
            }
        });
        pnMenuSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenuSuperiorMousePressed(evt);
            }
        });
        pnMenuSuperior.setLayout(new java.awt.GridLayout(2, 0));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/comprobado.png"))); // NOI18N
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnMenuSuperior.add(btnAceptar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/desenfrenado.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnMenuSuperior.add(btnCancelar);

        PanelMenu.add(pnMenuSuperior);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        PanelMenu.add(jPanel8);

        btnEntregarResultado.setBackground(new java.awt.Color(255, 235, 255));
        btnEntregarResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/biologia (2).png"))); // NOI18N
        btnEntregarResultado.setText("<html><p align=\"center\">Entregar Resultado</p></html>");
        btnEntregarResultado.setToolTipText("Entregar el resultado al paciente en forma escrita.");
        btnEntregarResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntregarResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntregarResultado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEntregarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarResultadoActionPerformed(evt);
            }
        });
        PanelMenu.add(btnEntregarResultado);

        btnGenerarResultado.setBackground(new java.awt.Color(255, 235, 255));
        btnGenerarResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/circulos/reportar (1).png"))); // NOI18N
        btnGenerarResultado.setText("<html><p ALIGN=center>Resultado</p></html>");
        btnGenerarResultado.setToolTipText("Generar el resultado.");
        btnGenerarResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarResultado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarResultadoActionPerformed(evt);
            }
        });
        PanelMenu.add(btnGenerarResultado);

        jButton8.setBackground(new java.awt.Color(255, 235, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/cancelar (3).png"))); // NOI18N
        jButton8.setText("<html><p ALIGN=center>sin implementar</p></html>");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PanelMenu.add(jButton8);

        jButton9.setBackground(new java.awt.Color(255, 235, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/botones/cancelar (3).png"))); // NOI18N
        jButton9.setText("<html><p ALIGN=center>sin implementar</p></html>");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PanelMenu.add(jButton9);

        pnBotones.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        pnViewPadre.add(pnBotones, java.awt.BorderLayout.LINE_END);

        add(pnViewPadre, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void pnMenuSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuSuperiorMouseDragged
//        Point point = MouseInfo.getPointerInfo().getLocation();
//
//        this.setLocation(point.x-x,point.y-y);
    }//GEN-LAST:event_pnMenuSuperiorMouseDragged

    private void pnMenuSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuSuperiorMousePressed
//        x = evt.getX();
//        y = evt.getY();
    }//GEN-LAST:event_pnMenuSuperiorMousePressed

    private void tablaResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadoMousePressed
        
        tablaResultado.setSelectionBackground(Color.PINK);
        tablaResultado.setSelectionForeground(Color.white);
        
        Buscar();
        PasarACampos();
        this.revalidate();
    }//GEN-LAST:event_tablaResultadoMousePressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Resultado res = ((Resultado)mantenimientoAsociado.Save());
        try {
            
            entityManager.refresh(resultadoSelected);
            entityManager.refresh(resultadoSelected.getIdestudioEstudio().
                getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection());
        } catch (java.lang.IllegalArgumentException e) {
        }
//        if (ars.getId()>0) {
//            tablaResultado.getModel().setValueAt(ars.getNombre(), tablaResultado.getSelectedRow(), 1);
//        }
        resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
        tablaResultado.setModel(getModel(resultados));
        RedisenarTabla();
//        tablaResultado.getModel().setValueAt(, WIDTH, WIDTH);getValueAt(tablaResultado.getSelectedRow(), 1);
//        List<Aseguradora> newAseguradoras;
//        newAseguradoras = entityManager.createNamedQuery("Aseguradora.findAll").getResultList();
//        tablaResultado.setModel(getModel(newAseguradoras));
//        RedisenarTabla();
        EnableButtoms(false,null);
        setResultadoSelected(res);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
        
        tablaResultado.setModel(getModel(resultados));
        
        RedisenarTabla();
        Filtar();
        tablaResultado.getSelectionModel().addSelectionInterval(0,0);
        Buscar();
        PasarACampos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEntregarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarResultadoActionPerformed
        if(resultadoJPA.getEntrega()==null){
            Entrega entrega = new Entrega();
            resultadoJPA.setIsActivo(false);
            ResultadoService service = new ResultadoService();
            service.GuardarResultado(resultadoJPA);
            EntityTransaction et = entityManager.getTransaction();
            try {
                et.begin();
                int idCaso=0;
            Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
            for (Caso caso : casos) {
                if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                    idCaso = caso.getIdcaso();
                }
            }

            Caso caso;
            caso = entityManager.find(Caso.class, idCaso);

                caso.setEstado("ENTREGADO");
                entityManager.persist(caso);
                entityManager.find(Entrega.class, Short.parseShort(resultadoJPA.getIdresultado().toString()));
                if(entrega!=null){
                    entrega.setIs_pago(true);
                    entrega.setIdresultadoResultado(resultadoJPA);
                    entrega.setIdentrega(Short.parseShort(resultadoJPA.getIdresultado().toString()));
                    entityManager.persist(entrega);
                }




                et.commit(); 
            } catch (Exception e) {
                if(et.isActive()){
                    et.rollback();
                }
            }
            int idCaso = 0;
            tablaResultado.setModel(getModel(resultados));
            RedisenarTabla();
            int opt = JOptionPane.showConfirmDialog(null, "¿Desea imprimir el resultado?", 
                    "Impresión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opt==0){
                GenerarReporte gr = new GenerarReporte();
    //            gr.ResultadoByEstudio(resultadoJPA.getIdestudioEstudio().getIdestudio());
            Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
            for (Caso caso : casos) {
                if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                    idCaso = caso.getIdcaso();
                }
            }

                gr.ResultadoByEstudio3(idCaso);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El resultado ya ha sido entregado.", "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEntregarResultadoActionPerformed

    private void tablaResultadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaResultadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaResultadoKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        
//        
//        Object[] registro = new Object[12];
//        
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (model.getValueAt(i, 1).toString().contains(jTextField1.getText())) {
//                registro[0] = model.getValueAt(i, 0);
//                registro[1] = model.getValueAt(i, 1);
//                registro[2] = model.getValueAt(i, 2);
//                registro[3] = model.getValueAt(i, 3);
//                
//                registro[4] = model.getValueAt(i, 4);
//                registro[5] = model.getValueAt(i, 5);
//                registro[6] = model.getValueAt(i, 6);
//                registro[7] = model.getValueAt(i, 7);
//                registro[8] = model.getValueAt(i, 8);
//                registro[9] = model.getValueAt(i, 9);
//                registro[10] = model.getValueAt(i, 10);
//                registro[11] = model.getValueAt(i, 11);
//                
//                newModel.addRow(registro);
//            }
//            
//        }
//        tablaResultado.setModel(newModel);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tablaResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaResultadoKeyReleased
        if(evt.getKeyCode()==40||evt.getKeyCode()==38){
            tablaResultado.setSelectionBackground(Color.PINK);
            tablaResultado.setSelectionForeground(Color.white);
        
            Buscar();
            PasarACampos();  
        }else{
            if(evt.getKeyCode()==127){
                if(mantenimientoAsociado.Borrar()){
            
                    resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
                    tablaResultado.setModel(getModel(resultados));
                    RedisenarTabla();
                    tablaResultado.getSelectionModel().addSelectionInterval(0,0);
                    Buscar();
                    PasarACampos();
                }
            }
        }
    }//GEN-LAST:event_tablaResultadoKeyReleased

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Filtar();
        if(evt.getKeyCode()==40){
            tablaResultado.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Filtar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if(resultadoJPA!=null){
//            int idCaso=0;
//                Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
//                for (Caso caso : casos) {
//                    if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
//                        idCaso = caso.getIdcaso();
//                    }
//                }
//
//                Caso caso;
//                caso = entityManager.find(Caso.class, idCaso);
//            if(caso.getEstado()=="ENTREGADO"){
            if(!resultadoJPA.getIsActivo()){
                JOptionPane.showMessageDialog(null, "Resultado no se puede modificar. Resultado entregado.");
                mantenimientoAsociado.CanModify(false);
            }else{
                if(btnEditar.isSelected()){
                    mantenimientoAsociado.CanModify(true);
                    mantenimientoAsociado.MandarSizePadre(1148);
                }else{
                    mantenimientoAsociado.CanModify(false);
                    mantenimientoAsociado.MandarSizePadre(0);
                }
                
        EnableButtoms(btnEditar.isSelected(),btnEditar);
            }
        }
        
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(mantenimientoAsociado.Borrar()){
            
            resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
            tablaResultado.setModel(getModel(resultados));
            RedisenarTabla();
            tablaResultado.getSelectionModel().addSelectionInterval(0,0);
            Buscar();
            PasarACampos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGenerarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarResultadoActionPerformed
        GenerarReporte gr = new GenerarReporte();
        int idCaso = 0;
         Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
        for (Caso caso : casos) {
            if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                idCaso = caso.getIdcaso();
            }
        }
        
            gr.ResultadoByEstudio3(idCaso);
        
//        gr.ResultadoByEstudio(resultadoJPA.getIdestudioEstudio().getIdestudio());
    }//GEN-LAST:event_btnGenerarResultadoActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        EnableButtoms(true, btnNuevo);
        mantenimientoAsociado.CanModify(true);
        mantenimientoAsociado.MandarSizePadre(1148);
        mantenimientoAsociado.Clean();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPacienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPacienteMouseClicked

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        JPanel pnFrm = new PanelPaciente();
        JPanel pnView = new ViewerPaciente(entityManager);
        mantenimientoAsociado.CargarMantenimiento(pnView, pnFrm, true);
        mantenimientoAsociado.MandarSizePadre(0);  
        Paciente pac = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().
                getIdfrascoFrasco().getIdpacientePaciente();
        
        ((ViewerPaciente)pnView).setPacienteSelected(pac);
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void btnMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMedicoMouseClicked

    private void btnMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMedicoActionPerformed

    private void btnPatologoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPatologoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPatologoMouseClicked

    private void btnPatologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPatologoActionPerformed

    private void btnEstudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstudioMouseClicked

    private void btnEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudioActionPerformed
        JPanel pnFrm = new PanelEstudio();
        JPanel pnView = new ViewerEstudio(entityManager);
        mantenimientoAsociado.CargarMantenimiento(pnView, pnFrm, true);
        mantenimientoAsociado.MandarSizePadre(0);   
        
        ((ViewerEstudio)pnView).setEstudioSelected(resultadoJPA.getIdestudioEstudio());
        
    }//GEN-LAST:event_btnEstudioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Entrega entrega = new Entrega();
        resultadoJPA.setIsActivo(false);
        ResultadoService service = new ResultadoService();
        service.GuardarResultado(resultadoJPA);
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            int idCaso=0;
        Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
        for (Caso caso : casos) {
            if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                idCaso = caso.getIdcaso();
            }
        }
            
        Caso caso;
        caso = entityManager.find(Caso.class, idCaso);
        
            caso.setEstado("ENTREGADO");
            entityManager.persist(caso);
            entityManager.find(Entrega.class, Short.parseShort(resultadoJPA.getIdresultado().toString()));
            if(entrega!=null){
                entrega.setIs_pago(true);
                entrega.setIdresultadoResultado(resultadoJPA);
                entrega.setIdentrega(Short.parseShort(resultadoJPA.getIdresultado().toString()));
                entityManager.persist(entrega);
            }
            
           
            
            
            et.commit(); 
        } catch (Exception e) {
            if(et.isActive()){
                et.rollback();
            }
        }
        int idCaso = 0;
        tablaResultado.setModel(getModel(resultados));
        RedisenarTabla();
        int opt = JOptionPane.showConfirmDialog(null, "¿Desea imprimir el resultado?", 
                "Impresión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opt==0){
            GenerarReporte gr = new GenerarReporte();
//            gr.ResultadoByEstudio(resultadoJPA.getIdestudioEstudio().getIdestudio());
        Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
        for (Caso caso : casos) {
            if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                idCaso = caso.getIdcaso();
            }
        }
        
            gr.ResultadoByEstudio2(idCaso);
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public boolean EnableButtoms(boolean b, Component c){
        btnGenerarResultado.setEnabled(!b);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(b);
        btnNuevo.setEnabled(!b);
        btnEditar.setEnabled(!b);
        btnBorrar.setEnabled(!b);
        btnBuscar.setEnabled(!b);
        btnActualizar.setEnabled(!b);
        txtBuscar.setEnabled(!b);
        jButton8.setEnabled(!b);
        jButton8.setEnabled(!b);
        jButton9.setEnabled(!b);
        btnEntregarResultado.setEnabled(!b);
        
        try {
            c.setEnabled(true);
        } catch (Exception e) {
        }
        
        return b;
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        if(resultadoJPA!=null){
//            int idCaso=0;
//                Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
//                for (Caso caso : casos) {
//                    if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
//                        idCaso = caso.getIdcaso();
//                    }
//                }
//
//                Caso caso;
//                caso = entityManager.find(Caso.class, idCaso);
//            if(caso.getEstado()=="ENTREGADO"){
            if(!resultadoJPA.getIsActivo()){
                JOptionPane.showMessageDialog(null, "Resultado no se puede modificar. Resultado entregado.");
                mantenimientoAsociado.CanModify(false);
            }else{
                btnEditar.setSelected(!btnEditar.isSelected());
                if(btnEditar.isSelected()){
                    mantenimientoAsociado.CanModify(true);
                    mantenimientoAsociado.MandarSizePadre(1148);
                }else{
                    mantenimientoAsociado.CanModify(false);
                    mantenimientoAsociado.MandarSizePadre(0);
                }
                
        EnableButtoms(btnEditar.isSelected(),btnEditar);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       if(mantenimientoAsociado.Borrar()){
            
            resultados = entityManager.createNamedQuery("Resultado.findAll").getResultList();
            tablaResultado.setModel(getModel(resultados));
            RedisenarTabla();
            tablaResultado.getSelectionModel().addSelectionInterval(0,0);
            Buscar();
            PasarACampos();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        EnableButtoms(false,null);
        btnEditar.setSelected(false);
        mantenimientoAsociado.CanModify(false);
        mantenimientoAsociado.MandarSizePadre(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadoMouseReleased
        int row = tablaResultado.rowAtPoint(evt.getPoint());
        tablaResultado.getSelectionModel().clearSelection();
        tablaResultado.getSelectionModel().setSelectionInterval(row, row);
        Buscar();
        PasarACampos();        
        if(evt.isPopupTrigger()){
            
            jPopupMenu1.show(this.tablaResultado,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_tablaResultadoMouseReleased

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        GenerarReporte gr = new GenerarReporte();
        int idCaso = 0;
         Collection<Caso> casos = resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getCasoCollection();
        for (Caso caso : casos) {
            if(caso.getIdfragmento()==resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfragmento()){
                idCaso = caso.getIdcaso();
            }
        }
        
            gr.ResultadoByEstudio3(idCaso);
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    @Override
    public void bind(IMantenimiento m) {
         mantenimientoAsociado = m;
         //PasarACampos();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JButton btnEntregarResultado;
    private javax.swing.JButton btnEstudio;
    private javax.swing.JButton btnGenerarResultado;
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnPatologo;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblNombreARS;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JPanel pnBusqueda;
    private javax.swing.JPanel pnLista;
    private javax.swing.JPanel pnListaPadre;
    private javax.swing.JPanel pnMenuSuperior;
    private javax.swing.JPanel pnView;
    private javax.swing.JPanel pnViewPadre;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    @Override//metodo de la interface que manda al panel formulario
    public void mandar(String txt) {
       // jLabel1.setText(txt);
    }
    public DefaultTableModel getModel(List<Resultado> lista){
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
      }
        };
        
        modelo.addColumn("Resultado");        
        modelo.addColumn("Fecha");       
        modelo.addColumn("IdEmpleado");     
        modelo.addColumn("IdEstudio");
        modelo.addColumn("Etiologia");
        modelo.addColumn("Patogenia");
        modelo.addColumn("CambiosMorfologicos");
        modelo.addColumn("ManifestacionClinica");
        modelo.addColumn("Recomendacion");
        modelo.addColumn("Aviso");
        modelo.addColumn("IsActivo");
        modelo.addColumn("Estudio");
        
        Object[] registro = new Object[12];
        
        Collections.reverse(lista);
        for(Resultado resultado: lista){
                    entityManager.refresh(resultado);
                    registro[0] = resultado.getIdresultado();
                    registro[1] = resultado.getFecha();
                    registro[2] = resultado.getIdempleado();
                    registro[3] = resultado.getIdestudioEstudio();
                    registro[4] = resultado.getEtiologia();
                    registro[5] = resultado.getPatogenia();
                    registro[6] = resultado.getCambioMorfologico();
                    registro[7] = resultado.getManifestacionClinica();
                    registro[8] = resultado.getRecomendacion();
                    registro[9] = resultado.getAviso();
                    registro[10] = resultado.getIsActivo();
                    registro[11] = resultado.getIdestudioEstudio().getIdestudio();
                modelo.addRow(registro);
               
            } 
        
        
        return modelo;
        
    }
    
    public void RedisenarTabla(){
//        tablaResultado.setTableHeader(null);
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(1));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(2));
        tablaResultado.removeColumn(tablaResultado.getColumnModel().getColumn(1));
    }

    @Override
    public void Buscar() {
        
        tablaResultado.setSelectionBackground(Color.PINK);
        tablaResultado.setSelectionForeground(Color.white);
        resultado = new ResultadoDTO();
        if(tablaResultado.getRowSorter()==null){
            resultado.setIdresultado((Integer)tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 0));
            resultado.setFecha((java.util.Date) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 1));
            resultado.setIdempleado(Short.toUnsignedInt((Short)tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 2)));
            resultado.setIdestudio(((Estudio) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 3)).getIdestudio());
            resultado.setEtiologia((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 4));
            resultado.setPatogenia((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 5));
            resultado.setCambioMorfologico((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 6));
            resultado.setManifestacionClinica((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 7));
            resultado.setRecomendacion((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 8));
            resultado.setAviso((String) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 9));
            resultado.setIsActivo((boolean) tablaResultado.getModel().getValueAt(tablaResultado.getSelectedRow(), 10));
        }else{
            int valor = tablaResultado.convertRowIndexToModel(tablaResultado.getSelectedRow());
            resultado.setIdresultado((Integer)tablaResultado.getRowSorter().getModel().getValueAt(valor, 0));
            resultado.setFecha((java.util.Date) tablaResultado.getRowSorter().getModel().getValueAt(valor, 1));
            resultado.setIdempleado(Short.toUnsignedInt((Short)tablaResultado.getRowSorter().getModel().getValueAt(valor, 2)));
            resultado.setIdestudio(((Estudio) tablaResultado.getRowSorter().getModel().getValueAt(valor, 3)).getIdestudio());
            resultado.setEtiologia((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 4));
            resultado.setPatogenia((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 5));
            resultado.setCambioMorfologico((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 6));
            resultado.setManifestacionClinica((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 7));
            resultado.setRecomendacion((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 8));
            resultado.setAviso((String) tablaResultado.getRowSorter().getModel().getValueAt(valor, 9));
            resultado.setIsActivo((boolean) tablaResultado.getRowSorter().getModel().getValueAt(valor, 10));
        }
        //PasarACampos();
    }

    private void Filtar() {
        DefaultTableModel model = (DefaultTableModel) tablaResultado.getModel();
//      DefaultTableModel tmodel =  (DefaultTableModel) tablaResultado.getColumnModel();
        DefaultTableModel newModel = new DefaultTableModel();
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        tablaResultado.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel,Object> filter = RowFilter.regexFilter(txtBuscar.getText(), 0);
        sorter.setRowFilter(filter);
        
        
        tablaResultado.getSelectionModel().addSelectionInterval(0,0);
        Buscar();
        PasarACampos();
    }
    @Override
    public void PasarACampos() {
        boolean b = false;
        String entregado = "";
        
        resultadoJPA = entityManager.find(Resultado.class, resultado.getIdresultado());
        
        try{
            if(resultadoJPA.getEntrega()!=null){
                b=true;
                entregado = "(ENTREGADO)";
            }
        }catch(NullPointerException e){
            
        }
        
        
        lblNombreARS.setText("#"+Integer.toString(resultadoJPA.getIdresultado())+entregado);
        
        mantenimientoAsociado.Show((Object)resultadoJPA);
        
        String nombrePatologo;
        btnPaciente.setText(resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdfrascoFrasco().getIdpacientePaciente().getNombre());
        btnMedico.setText(resultadoJPA.getIdestudioEstudio().getIdfragmentoFragmento().getIdmedicoMedico().getNombre());
        btnEstudio.setText(resultadoJPA.getIdestudioEstudio().getIdestudio()+" "+resultadoJPA.getIdestudioEstudio().getIdtipoEstudioTipoEstudio().getNombre());
        try{
            nombrePatologo = resultadoJPA.getIdestudioEstudio().getIdpatologoPatologo().getNombre();
            btnPatologo.setEnabled(true);
        }catch(NullPointerException e){
            nombrePatologo = "PATOLOGO NO ASIGNADO";
            btnPatologo.setEnabled(false);
        }
        btnPatologo.setText(nombrePatologo);
        if(resultadoJPA.getIsActivo()){
            mantenimientoAsociado.CanModify(true);
        }else{
            mantenimientoAsociado.CanModify(false);
        }
    }

    /**
     * @return the resultadoSelected
     */
    public Resultado getResultadoSelected() {
        return resultadoSelected;
    }

    /**
     * @param resultadoSelected the resultadoSelected to set
     */
    public void setResultadoSelected(Resultado resultadoSelected) {
        
        TableModel dtm = tablaResultado.getModel();
        this.resultadoSelected = resultadoSelected;
        for (int i=0; i<dtm.getRowCount(); i++) {
            int id = (int) dtm.getValueAt(i, 0);
            if(id == resultadoSelected.getIdresultado()){
                this.resultadoSelected = resultadoSelected;
                tablaResultado.getSelectionModel().clearSelection();
                tablaResultado.getSelectionModel().addSelectionInterval(i,i);
                Buscar();
                PasarACampos();
            }
        }
    }
    
}
