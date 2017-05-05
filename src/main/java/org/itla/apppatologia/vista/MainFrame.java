/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import org.itla.apppatologia.Repository.Empleado;
import org.itla.apppatologia.modelo.Contexto;
import org.itla.apppatologia.modelo.PersistenceUnits;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.componentes.ISubMenuObservable;
import org.itla.apppatologia.vista.componentes.PanelSubMenuLaboratorio;
import org.itla.apppatologia.vista.componentes.PanelSubMenuMedico;
import org.itla.apppatologia.vista.componentes.PanelSubMenuPaciente;
import org.itla.apppatologia.vista.componentes.PanelSubMenuResultado;
import org.itla.apppatologia.vista.mantenimientos.IMantenimiento;
import org.itla.apppatologia.vista.mantenimientos.PanelPatologos;
import org.itla.apppatologia.vista.viewers.IViewerObservable;
import sun.java2d.SunGraphicsEnvironment;

/**
 *
 * @author Chu
 */
public class MainFrame extends javax.swing.JFrame implements IPanelCentralObservador{

    /**
     * Creates new form MainFrame
     */
    CardLayout subMenuCardLayOut;
    CardLayout panelCardLayOut;
    CardLayout viewerCardLayout;
    public EntityManager entityManager ;
    Contexto context;
    //
    public static boolean isPinned = false;
    //Creacion de paneles de SubMenu
    PanelSubMenuPaciente  pnPaciente = new PanelSubMenuPaciente();
    PanelSubMenuResultado  pnResultado = new PanelSubMenuResultado();
    PanelSubMenuLaboratorio pnLaboratorio = new PanelSubMenuLaboratorio();
    PanelSubMenuMedico pnDoctor = new PanelSubMenuMedico();
    
    //Lista de mantenimientos para ejecutar los mettodos internos
    Collection<IMantenimiento> mantenimientos;
    IMantenimiento mantenimientoActivo;
    int x,y;
    
    private Empleado emp;
    public MainFrame() {
        //setUndecorated(true);
        initComponents();
        //CONEXION
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        PanelSubMenu.setPreferredSize(new Dimension(0, PanelSubMenu.getHeight()));
        SplitFormulario.setDividerLocation(0);
       
        
        subMenuCardLayOut = new CardLayout();
        subMenuCardLayOut = (CardLayout) PanelSubMenuSub.getLayout();
        
        panelCardLayOut = new CardLayout();
        panelCardLayOut = (CardLayout) PanelCargarFormulario.getLayout();
        
        viewerCardLayout = new CardLayout();
        viewerCardLayout = (CardLayout)PanelViewer.getLayout();
        
        setLocationRelativeTo(null);
        
        
        
//        PanelSubMenuSub.add(pnPaciente,"paciente");
//        pnPaciente.Enlazar(this);
        JPanel nada = new JPanel();
        PanelSubMenuSub.add(nada,"nada");
//        JPanel nada2 = new JPanel();
//        PanelCargarFormulario.add(nada2,"nada2");
//        
//        
//        PanelSubMenuSub.add(pnLaboratorio,"laboratorio");
//        pnLaboratorio.Enlazar(this);
//        
//        PanelSubMenuSub.add(pnDoctor,"doctor");
      
        
//        jButton4.setForeground(Color.black);
//        jButton4.setBackground(Color.white);
//        Border line = null;//new LineBorder(Color.white);
//        Border margin = null;//new EmptyBorder(5, 15, 5, 15);
//        Border compound = new CompoundBorder(line, margin);
//        jButton4.setBorder(compound);
    }
    public MainFrame(Empleado empleado) {
//        setUndecorated(true);
        
         GraphicsConfiguration config = getGraphicsConfiguration();
         Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(config.getDevice());
        setMaximizedBounds(usableBounds);
        setExtendedState(MAXIMIZED_BOTH);
        
        
        UIManager.put("ToolTip.background", new Color(255,236,255));
        
//        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        initComponents();
        
        //CONEXION
        context = new  Contexto();
        entityManager = context.getEntityManager(PersistenceUnits.getLocalContext());
        
        PanelSubMenu.setPreferredSize(new Dimension(0, PanelSubMenu.getHeight()));
        SplitFormulario.setDividerLocation(0);
       
        
        subMenuCardLayOut = new CardLayout();
        subMenuCardLayOut = (CardLayout) PanelSubMenuSub.getLayout();
        
        panelCardLayOut = new CardLayout();
        panelCardLayOut = (CardLayout) PanelCargarFormulario.getLayout();
        
        viewerCardLayout = new CardLayout();
        viewerCardLayout = (CardLayout)PanelViewer.getLayout();
        
        setLocationRelativeTo(null);
        
        
        JPanel nada = new JPanel();
        PanelSubMenuSub.add(nada,"nada");
        emp = empleado;
        lblValorNombreUsuario.setText("<HTML><P align=right>Hola, <BR/>"+empleado.getNombre()+" "+empleado.getApellido()+"</P></HTML>");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        pnMenuSuperior = new javax.swing.JPanel();
        tbMenuPaciente = new javax.swing.JToggleButton();
        tbMenuPatologo = new javax.swing.JToggleButton();
        tbMenuMedico = new javax.swing.JToggleButton();
        tbMenuResultado = new javax.swing.JToggleButton();
        pnMenuInferior = new javax.swing.JPanel();
        PanelCentral = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblValorNombreUsuario = new javax.swing.JLabel();
        PanelSubMenu = new javax.swing.JPanel();
        PanelSubMenuSub = new javax.swing.JPanel();
        SplitFormulario = new javax.swing.JSplitPane();
        PanelViewer = new javax.swing.JPanel();
        PanelFormularioBase = new javax.swing.JPanel();
        PanelFormularioBarraIzquierda = new javax.swing.JPanel();
        PanelFormularioBarraDerecha = new javax.swing.JPanel();
        PanelFormulario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelCargarFormulario = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 500));

        PanelMenu.setBackground(new java.awt.Color(37, 41, 53));
        PanelMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelMenu.setPreferredSize(new java.awt.Dimension(70, 356));
        PanelMenu.setLayout(new java.awt.GridLayout(0, 1));

        pnMenuSuperior.setBackground(new java.awt.Color(37, 41, 53));
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

        javax.swing.GroupLayout pnMenuSuperiorLayout = new javax.swing.GroupLayout(pnMenuSuperior);
        pnMenuSuperior.setLayout(pnMenuSuperiorLayout);
        pnMenuSuperiorLayout.setHorizontalGroup(
            pnMenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        pnMenuSuperiorLayout.setVerticalGroup(
            pnMenuSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        PanelMenu.add(pnMenuSuperior);

        tbMenuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/paciente_gris_64.png"))); // NOI18N
        tbMenuPaciente.setToolTipText("Paciente");
        tbMenuPaciente.setContentAreaFilled(false);
        tbMenuPaciente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/paciente_brillante_64.png"))); // NOI18N
        tbMenuPaciente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/paciente_rosa_64.png"))); // NOI18N
        tbMenuPaciente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/paciente_brillante_64.png"))); // NOI18N
        tbMenuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbMenuPacienteActionPerformed(evt);
            }
        });
        PanelMenu.add(tbMenuPaciente);

        tbMenuPatologo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/patologo_gris_64.png"))); // NOI18N
        tbMenuPatologo.setToolTipText("Laboratorio");
        tbMenuPatologo.setContentAreaFilled(false);
        tbMenuPatologo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/patologo_brillante_64.png"))); // NOI18N
        tbMenuPatologo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/patologo_rosa_64.png"))); // NOI18N
        tbMenuPatologo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/patologo_brillante_64.png"))); // NOI18N
        tbMenuPatologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbMenuPatologoActionPerformed(evt);
            }
        });
        PanelMenu.add(tbMenuPatologo);

        tbMenuMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/medico_gris_64.png"))); // NOI18N
        tbMenuMedico.setToolTipText("Médico");
        tbMenuMedico.setContentAreaFilled(false);
        tbMenuMedico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/medico_brillante_64.png"))); // NOI18N
        tbMenuMedico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/medico_rosa_64.png"))); // NOI18N
        tbMenuMedico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/medico_brillante_64.png"))); // NOI18N
        tbMenuMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbMenuMedicoActionPerformed(evt);
            }
        });
        PanelMenu.add(tbMenuMedico);

        tbMenuResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/check_gris_64.png"))); // NOI18N
        tbMenuResultado.setToolTipText("Resultados");
        tbMenuResultado.setContentAreaFilled(false);
        tbMenuResultado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/check_brillante_64.png"))); // NOI18N
        tbMenuResultado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/check_rosa_64.png.png"))); // NOI18N
        tbMenuResultado.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/check_brillante_64.png"))); // NOI18N
        tbMenuResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbMenuResultadoActionPerformed(evt);
            }
        });
        PanelMenu.add(tbMenuResultado);

        pnMenuInferior.setBackground(new java.awt.Color(37, 41, 53));
        pnMenuInferior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnMenuInferiorMouseDragged(evt);
            }
        });
        pnMenuInferior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenuInferiorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuInferiorLayout = new javax.swing.GroupLayout(pnMenuInferior);
        pnMenuInferior.setLayout(pnMenuInferiorLayout);
        pnMenuInferiorLayout.setHorizontalGroup(
            pnMenuInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        pnMenuInferiorLayout.setVerticalGroup(
            pnMenuInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        PanelMenu.add(pnMenuInferior);

        getContentPane().add(PanelMenu, java.awt.BorderLayout.LINE_START);

        PanelCentral.setBackground(new java.awt.Color(255, 255, 255));
        PanelCentral.setLayout(new java.awt.BorderLayout());

        pnTitulo.setBackground(new java.awt.Color(255, 102, 255));
        pnTitulo.setPreferredSize(new java.awt.Dimension(60, 74));
        pnTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnTituloMouseDragged(evt);
            }
        });
        pnTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTituloMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTituloMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 0, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pathosystem");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/principales/usuario (1).png"))); // NOI18N

        lblValorNombreUsuario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblValorNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblValorNombreUsuario.setText("jLabel3");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(lblValorNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21))
        );

        PanelCentral.add(pnTitulo, java.awt.BorderLayout.PAGE_START);

        PanelSubMenu.setBackground(new java.awt.Color(240, 240, 240));
        PanelSubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        PanelSubMenu.setPreferredSize(new java.awt.Dimension(185, 323));

        PanelSubMenuSub.setBackground(new java.awt.Color(240, 240, 240));
        PanelSubMenuSub.setPreferredSize(new java.awt.Dimension(160, 426));
        PanelSubMenuSub.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout PanelSubMenuLayout = new javax.swing.GroupLayout(PanelSubMenu);
        PanelSubMenu.setLayout(PanelSubMenuLayout);
        PanelSubMenuLayout.setHorizontalGroup(
            PanelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSubMenuSub, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );
        PanelSubMenuLayout.setVerticalGroup(
            PanelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSubMenuLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(PanelSubMenuSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        PanelCentral.add(PanelSubMenu, java.awt.BorderLayout.LINE_START);

        SplitFormulario.setDividerLocation(500);
        SplitFormulario.setDividerSize(6);
        SplitFormulario.setOneTouchExpandable(true);
        SplitFormulario.setPreferredSize(new java.awt.Dimension(330, 323));

        PanelViewer.setBackground(new java.awt.Color(255, 255, 255));
        PanelViewer.setPreferredSize(new java.awt.Dimension(330, 0));
        PanelViewer.setLayout(new java.awt.CardLayout());
        SplitFormulario.setRightComponent(PanelViewer);

        PanelFormularioBase.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormularioBase.setMinimumSize(new java.awt.Dimension(0, 100));
        PanelFormularioBase.setPreferredSize(new java.awt.Dimension(800, 321));
        PanelFormularioBase.setLayout(new java.awt.BorderLayout());

        PanelFormularioBarraIzquierda.setBackground(new java.awt.Color(255, 236, 255));
        PanelFormularioBarraIzquierda.setPreferredSize(new java.awt.Dimension(5, 321));

        javax.swing.GroupLayout PanelFormularioBarraIzquierdaLayout = new javax.swing.GroupLayout(PanelFormularioBarraIzquierda);
        PanelFormularioBarraIzquierda.setLayout(PanelFormularioBarraIzquierdaLayout);
        PanelFormularioBarraIzquierdaLayout.setHorizontalGroup(
            PanelFormularioBarraIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        PanelFormularioBarraIzquierdaLayout.setVerticalGroup(
            PanelFormularioBarraIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        PanelFormularioBase.add(PanelFormularioBarraIzquierda, java.awt.BorderLayout.LINE_START);

        PanelFormularioBarraDerecha.setBackground(new java.awt.Color(255, 236, 255));
        PanelFormularioBarraDerecha.setPreferredSize(new java.awt.Dimension(5, 321));

        javax.swing.GroupLayout PanelFormularioBarraDerechaLayout = new javax.swing.GroupLayout(PanelFormularioBarraDerecha);
        PanelFormularioBarraDerecha.setLayout(PanelFormularioBarraDerechaLayout);
        PanelFormularioBarraDerechaLayout.setHorizontalGroup(
            PanelFormularioBarraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        PanelFormularioBarraDerechaLayout.setVerticalGroup(
            PanelFormularioBarraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        PanelFormularioBase.add(PanelFormularioBarraDerecha, java.awt.BorderLayout.LINE_END);

        PanelFormulario.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormulario.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(189, 50));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton2.setBackground(new java.awt.Color(255, 240, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/copia.png"))); // NOI18N
        jButton2.setText("Copiar");
        jPanel1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 240, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/pegar.png"))); // NOI18N
        jButton3.setText("Pegar");
        jPanel1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 240, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/imprimir.png"))); // NOI18N
        jButton4.setText("Imprimir");
        jPanel1.add(jButton4);

        btnNuevo.setBackground(new java.awt.Color(255, 240, 246));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itla/apppatologia/vista/PNG/persistencia/agregar-nuevo-documento.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        jPanel2.add(jPanel1);

        PanelFormulario.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 236, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 236, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(5, 100));
        jPanel9.setPreferredSize(new java.awt.Dimension(5, 5));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(null);

        PanelCargarFormulario.setBackground(new java.awt.Color(255, 255, 255));
        PanelCargarFormulario.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(PanelCargarFormulario);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PanelFormulario.add(jPanel6, java.awt.BorderLayout.CENTER);

        PanelFormularioBase.add(PanelFormulario, java.awt.BorderLayout.CENTER);

        SplitFormulario.setLeftComponent(PanelFormularioBase);

        PanelCentral.add(SplitFormulario, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbMenuPacienteActionPerformed
        this.UnselectAllButton();
        tbMenuPaciente.setSelected(true);
        //subMenuCardLayOut.show(PanelSubMenuSub, "paciente");
        
        for(Component c:PanelSubMenuSub.getComponents()){
            if (c instanceof PanelSubMenuPaciente) {
                subMenuCardLayOut.show(PanelSubMenuSub, "paciente");
                break;
            }else{
                pnPaciente = new PanelSubMenuPaciente();
                PanelSubMenuSub.add(pnPaciente,"paciente");
                subMenuCardLayOut.show(PanelSubMenuSub, "paciente");
                pnPaciente.Enlazar(this);
            }
            pnPaciente.UnSelectAllButton();
        }
        //SplitFormulario.getLeftComponent().setPreferredSize(new Dimension(0, SplitFormulario.getLeftComponent().getHeight()));
        if (!isPinned) {
            
            SplitFormulario.setDividerLocation(0);
            PanelSubMenu.setPreferredSize(new Dimension(170, PanelSubMenu.getHeight()));
        }
        revalidate();
        repaint();
    }//GEN-LAST:event_tbMenuPacienteActionPerformed

    private void tbMenuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbMenuMedicoActionPerformed
        UnselectAllButton();
        tbMenuMedico.setSelected(true);
        
        for(Component c:PanelSubMenuSub.getComponents()){
            if (c instanceof PanelSubMenuMedico) {
                subMenuCardLayOut.show(PanelSubMenuSub, "doctor");
                break;
            }else{
                pnDoctor = new PanelSubMenuMedico();
                PanelSubMenuSub.add(pnDoctor,"doctor");
                subMenuCardLayOut.show(PanelSubMenuSub, "doctor");
//                pnDoctor.Enlazar(this);
            }
        }
        if (!isPinned) {
            
            SplitFormulario.setDividerLocation(0);
            PanelSubMenu.setPreferredSize(new Dimension(170, PanelSubMenu.getHeight()));
        }
       revalidate();
        repaint();
    }//GEN-LAST:event_tbMenuMedicoActionPerformed

    private void tbMenuPatologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbMenuPatologoActionPerformed
        UnselectAllButton();
        tbMenuPatologo.setSelected(true);
        if(PanelSubMenuSub.getComponents().length==0){
            pnLaboratorio = new PanelSubMenuLaboratorio();
            PanelSubMenuSub.add(pnLaboratorio,"laboratorio");
            subMenuCardLayOut.show(PanelSubMenuSub, "laboratorio");
            pnLaboratorio.Enlazar(this);
                    
        }else{
            for(Component c:PanelSubMenuSub.getComponents())
                if (c instanceof PanelPatologos) {
                    subMenuCardLayOut.show(PanelSubMenuSub, "laboratorio");
                    break;
                }else{
                    pnLaboratorio = new PanelSubMenuLaboratorio();
                    PanelSubMenuSub.add(pnLaboratorio,"laboratorio");
                    subMenuCardLayOut.show(PanelSubMenuSub, "laboratorio");
                    pnLaboratorio.Enlazar(this);
                }
                pnLaboratorio.UnSelectAllButton();
        }
            
        if (!isPinned) {
            
            SplitFormulario.setDividerLocation(0);
            PanelSubMenu.setPreferredSize(new Dimension(170, PanelSubMenu.getHeight()));
        }
//            }
//        }else{
//            pnLaboratorio = new PanelLaboratorio();
//            PanelSubMenuSub.add(pnLaboratorio,"laboratorio");
//            subMenuCardLayOut.show(PanelSubMenuSub, "laboratorio");
//            pnLaboratorio.Enlazar(this);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_tbMenuPatologoActionPerformed

    private void pnTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTituloMousePressed
        x = evt.getX()+pnMenuSuperior.getWidth();
        y = evt.getY();
    }//GEN-LAST:event_pnTituloMousePressed

    private void pnTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTituloMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
       
       this.setLocation(point.x-x,point.y-y);
    }//GEN-LAST:event_pnTituloMouseDragged

    private void pnMenuSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuSuperiorMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pnMenuSuperiorMousePressed

    private void pnMenuSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuSuperiorMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
       
       this.setLocation(point.x-x,point.y-y);
    }//GEN-LAST:event_pnMenuSuperiorMouseDragged

    private void pnMenuInferiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuInferiorMousePressed
        x = evt.getX();
        y = evt.getY()+PanelMenu.getHeight()-pnMenuSuperior.getHeight();
    }//GEN-LAST:event_pnMenuInferiorMousePressed

    private void pnMenuInferiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenuInferiorMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
       
       this.setLocation(point.x-x,point.y-y);
    }//GEN-LAST:event_pnMenuInferiorMouseDragged

    private void tbMenuResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbMenuResultadoActionPerformed

        UnselectAllButton();
        tbMenuResultado.setSelected(true);
        
        for(Component c:PanelSubMenuSub.getComponents()){
            if (c instanceof PanelSubMenuResultado) {
                subMenuCardLayOut.show(PanelSubMenuSub, "resultado");
                break;
            }else{
                pnResultado = new PanelSubMenuResultado();
                PanelSubMenuSub.add(pnResultado,"resultado");
                subMenuCardLayOut.show(PanelSubMenuSub, "resultado");
                pnResultado.Enlazar(this);
            }
            pnPaciente.UnSelectAllButton();
        }
        if (!isPinned) {
            
            SplitFormulario.setDividerLocation(0);
            PanelSubMenu.setPreferredSize(new Dimension(170, PanelSubMenu.getHeight()));
        }
        
    }//GEN-LAST:event_tbMenuResultadoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        mantenimientoActivo.Clean();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void pnTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTituloMouseClicked
        if (evt.getClickCount() == 2) {
            GraphicsConfiguration config = getGraphicsConfiguration();
            Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(config.getDevice());
            setMaximizedBounds(usableBounds);
            
            setExtendedState(MAXIMIZED_BOTH);
            System.out.println("double clicked");
            
        }
    }//GEN-LAST:event_pnTituloMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCargarFormulario;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelFormularioBarraDerecha;
    private javax.swing.JPanel PanelFormularioBarraIzquierda;
    private javax.swing.JPanel PanelFormularioBase;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelSubMenu;
    private javax.swing.JPanel PanelSubMenuSub;
    private javax.swing.JPanel PanelViewer;
    private javax.swing.JSplitPane SplitFormulario;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValorNombreUsuario;
    private javax.swing.JPanel pnMenuInferior;
    private javax.swing.JPanel pnMenuSuperior;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JToggleButton tbMenuMedico;
    private javax.swing.JToggleButton tbMenuPaciente;
    private javax.swing.JToggleButton tbMenuPatologo;
    private javax.swing.JToggleButton tbMenuResultado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Update(ISubMenuObservable pn, String pnName) {
        PanelCargarFormulario.add((JPanel)pn,pnName);
        //pn.UnSelectAllButton();
    }

    @Override
    public void SetPanel(JPanel pnfrm, JPanel pnvwr, boolean sobreponer) {
        String s = pnfrm.getName();
        boolean b = false;
       //SI HAY ALGUN COMPONENTE EN LOS PANELES.
        if (PanelCargarFormulario.getComponentCount()>0) {
            //RECORRE TODOS LOS COMPONENTES DEL PANEL DE FORMULARIOS.
           for(Component c: PanelCargarFormulario.getComponents()){
                //SI ALGUNO ES DEL MISMO TIPO QUE EL QUE VIENE EN EL PARAMETRO 
                //LO MUESTA.
               if (c.getName()==pnfrm.getName()&&!sobreponer) {
                   panelCardLayOut.show(PanelCargarFormulario, pnfrm.getName());
                   viewerCardLayout.show(PanelViewer, pnvwr.getName());
                   mantenimientoActivo = (IMantenimiento)c;
                   b = true;
               }
            }
           //ESTA CONDICION NO SE DA SI YA ENTRO EN LA CONDICION ANTERIOR.
           //SI HAY COMPONENTES PERO NO ENCONTRO NINGUNO DEL MISMO TIPO QUE EL 
           //DEL PARAMETRO AGREGA LOS DEL PARAMETRO.
           if (!b){
               //EN EL CASO DE QUE NO HAYA QUE SOBREPONER (QUE NO ES TENGA QUE
               //ELIMINAR EL FORMULARIO YA AGREGADO PARA PONER OTRO)
                if(!sobreponer){
                    PanelCargarFormulario.add(pnfrm,pnfrm.getName());
                    panelCardLayOut.show(PanelCargarFormulario, pnfrm.getName());
                    PanelViewer.add(pnvwr,pnvwr.getName());
                    viewerCardLayout.show(PanelViewer, pnvwr.getName());
                //SI HAY QUE ELIMINAR EL FORMULARIO PARA SUSTITUIRLO POR EL OTRO.    
                }else{
                    for(Component c: PanelCargarFormulario.getComponents()){
                        if (c.getName()==pnfrm.getName()) {
                            PanelCargarFormulario.remove(c);
                        }
                    }
                    PanelCargarFormulario.add(pnfrm,pnfrm.getName());
                    panelCardLayOut.show(PanelCargarFormulario, pnfrm.getName());
                    for(Component c: PanelViewer.getComponents()){
                        if (c.getName()==pnvwr.getName()) {
                            PanelViewer.remove(c);
                            
                        }
                    
                    }
                    PanelViewer.add(pnvwr,pnvwr.getName());
                    viewerCardLayout.show(PanelViewer, pnvwr.getName());
                }
                mantenimientoActivo = (IMantenimiento)pnfrm;
            }
            //panelCardLayOut.show(PanelCargarFormulario, pn.getName());
            
        //SI NO HAY NINGUN COMPONENTE SOLO AGREGAR EL DEL PARAMETRO.
        }else{
            PanelCargarFormulario.add(pnfrm,pnfrm.getName());
            panelCardLayOut.show(PanelCargarFormulario, pnfrm.getName());
            PanelViewer.add(pnvwr,pnvwr.getName());
            viewerCardLayout.show(PanelViewer, pnvwr.getName());
            
            
            
            mantenimientoActivo = (IMantenimiento)pnfrm;
            
        }
        if(!sobreponer){
            ((IViewerObservable)pnvwr).bind(mantenimientoActivo);
            ((IViewerObservable)pnvwr).Buscar();
            ((IViewerObservable)pnvwr).PasarACampos();
        }
        //mantenimientos.add((IMantenimiento)pn);
    }
    public void UnselectAllButton(){
        JToggleButton jtb = new JToggleButton();
        for(Component c: PanelMenu.getComponents()){
            if (c instanceof JToggleButton) {
                jtb = (JToggleButton)c;
                jtb.setSelected(false);
            }
        }
    }

    @Override
    public boolean IsPinned(boolean b) {
        isPinned=b;
        return isPinned;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void OcultarSubMenu() {
            repaint();
            SplitFormulario.setDividerLocation(0);
            PanelSubMenu.setPreferredSize(new Dimension(0, PanelSubMenu.getHeight()));
    }

    @Override
    public void SetDividerSize(Integer size) {
        if (!isPinned) {
            
//            SplitFormulario.setDividerLocation(size);
//            PanelViewer.setPreferredSize(new Dimension(100, PanelViewer.getHeight()));
            //PanelViewer.setPreferredSize(new Dimension(330, PanelSubMenu.getHeight()));
//            SplitFormulario.resetToPreferredSizes();
            SplitFormulario.setDividerLocation(size);
        }
    }

    /**
     * @return the emp
     */
    public Empleado getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
}
