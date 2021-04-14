
package View;

import Controller.Ventas_controller;
import Model.Ventas;
import static View.pnlClientes.clientes;
import java.awt.Color;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Kevin
 */
public class pnlReportes extends javax.swing.JPanel {
    public static DefaultTableModel modelo = new DefaultTableModel();
    
    String patron = "#,###.00";
    DecimalFormat objDF = new DecimalFormat (patron);
    String t = objDF.format(Ventas_controller.getTotalVentaDia());
    
    public pnlReportes() {
        initComponents();
        lblVentasDia.setText(t);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelReportes = new javax.swing.JPanel();
        PanelTOPC = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        PanelMenuC = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        pnlBody = new javax.swing.JPanel();
        pnlBody1 = new javax.swing.JPanel();
        pnlReporteDia = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnVentasDel_Dia = new lib.RSButtonMetro();
        lblVentasDia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlReporteFactura = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar_factura = new lib.RSButtonMetro();
        pnlReportePeriodos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar_rangosFecha = new lib.RSButtonMetro();
        pnlReporteVendedor = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnBuscarPorUsuario = new lib.RSButtonMetro();
        pnlReporteEstadistico = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnEstadistico = new lib.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelReportes.setBackground(new java.awt.Color(255, 255, 255));
        PanelReportes.setPreferredSize(new java.awt.Dimension(1078, 540));

        PanelTOPC.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 204));
        jLabel22.setText("Reportes");

        javax.swing.GroupLayout PanelTOPCLayout = new javax.swing.GroupLayout(PanelTOPC);
        PanelTOPC.setLayout(PanelTOPCLayout);
        PanelTOPCLayout.setHorizontalGroup(
            PanelTOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTOPCLayout.setVerticalGroup(
            PanelTOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTOPCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        PanelMenuC.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenuC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelMenuC.setMaximumSize(new java.awt.Dimension(386, 338));

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inicio.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFocusPainted(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuCLayout = new javax.swing.GroupLayout(PanelMenuC);
        PanelMenuC.setLayout(PanelMenuCLayout);
        PanelMenuCLayout.setHorizontalGroup(
            PanelMenuCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuCLayout.createSequentialGroup()
                .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelMenuCLayout.setVerticalGroup(
            PanelMenuCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuCLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setMinimumSize(new java.awt.Dimension(400, 360));
        pnlBody.setLayout(new java.awt.CardLayout());

        pnlBody1.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBody1.setMinimumSize(new java.awt.Dimension(654, 485));
        pnlBody1.setPreferredSize(new java.awt.Dimension(751, 485));

        pnlReporteDia.setBackground(new java.awt.Color(255, 255, 255));
        pnlReporteDia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlReporteDia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlReporteDia.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel9.setBackground(new java.awt.Color(52, 152, 219));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ventas del día");
        jLabel9.setOpaque(true);

        btnVentasDel_Dia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ventas.png"))); // NOI18N
        btnVentasDel_Dia.setText("Ver detalles");
        btnVentasDel_Dia.setColorHover(new java.awt.Color(52, 152, 219));
        btnVentasDel_Dia.setColorNormal(new java.awt.Color(255, 255, 255));
        btnVentasDel_Dia.setColorPressed(new java.awt.Color(255, 255, 255));
        btnVentasDel_Dia.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnVentasDel_Dia.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnVentasDel_Dia.setFocusPainted(false);
        btnVentasDel_Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasDel_DiaActionPerformed(evt);
            }
        });

        lblVentasDia.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblVentasDia.setText("0.00");
        lblVentasDia.setFocusable(false);
        lblVentasDia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("₡");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlReporteDiaLayout = new javax.swing.GroupLayout(pnlReporteDia);
        pnlReporteDia.setLayout(pnlReporteDiaLayout);
        pnlReporteDiaLayout.setHorizontalGroup(
            pnlReporteDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentasDel_Dia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteDiaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblVentasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlReporteDiaLayout.setVerticalGroup(
            pnlReporteDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteDiaLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnVentasDel_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReporteDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVentasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlReporteFactura.setBackground(new java.awt.Color(255, 255, 255));
        pnlReporteFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlReporteFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlReporteFactura.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel10.setBackground(new java.awt.Color(52, 152, 219));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Buscar factura");
        jLabel10.setOpaque(true);

        btnBuscar_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/factura.png"))); // NOI18N
        btnBuscar_factura.setText("Número de factura");
        btnBuscar_factura.setColorHover(new java.awt.Color(52, 152, 219));
        btnBuscar_factura.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBuscar_factura.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBuscar_factura.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBuscar_factura.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBuscar_factura.setFocusPainted(false);
        btnBuscar_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_facturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteFacturaLayout = new javax.swing.GroupLayout(pnlReporteFactura);
        pnlReporteFactura.setLayout(pnlReporteFacturaLayout);
        pnlReporteFacturaLayout.setHorizontalGroup(
            pnlReporteFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscar_factura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlReporteFacturaLayout.setVerticalGroup(
            pnlReporteFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteFacturaLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnBuscar_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlReportePeriodos.setBackground(new java.awt.Color(255, 255, 255));
        pnlReportePeriodos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlReportePeriodos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlReportePeriodos.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel11.setBackground(new java.awt.Color(52, 152, 219));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reporte entre periodos");
        jLabel11.setOpaque(true);

        btnBuscar_rangosFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calendario.png"))); // NOI18N
        btnBuscar_rangosFecha.setText("rangos entre fechas");
        btnBuscar_rangosFecha.setColorHover(new java.awt.Color(52, 152, 219));
        btnBuscar_rangosFecha.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBuscar_rangosFecha.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBuscar_rangosFecha.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBuscar_rangosFecha.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBuscar_rangosFecha.setFocusPainted(false);
        btnBuscar_rangosFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_rangosFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReportePeriodosLayout = new javax.swing.GroupLayout(pnlReportePeriodos);
        pnlReportePeriodos.setLayout(pnlReportePeriodosLayout);
        pnlReportePeriodosLayout.setHorizontalGroup(
            pnlReportePeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscar_rangosFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlReportePeriodosLayout.setVerticalGroup(
            pnlReportePeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportePeriodosLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnBuscar_rangosFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlReporteVendedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlReporteVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlReporteVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlReporteVendedor.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel12.setBackground(new java.awt.Color(52, 152, 219));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ventas por usuario");
        jLabel12.setOpaque(true);

        btnBuscarPorUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuario.png"))); // NOI18N
        btnBuscarPorUsuario.setColorHover(new java.awt.Color(52, 152, 219));
        btnBuscarPorUsuario.setColorNormal(new java.awt.Color(255, 255, 255));
        btnBuscarPorUsuario.setColorPressed(new java.awt.Color(255, 255, 255));
        btnBuscarPorUsuario.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnBuscarPorUsuario.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnBuscarPorUsuario.setFocusPainted(false);
        btnBuscarPorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteVendedorLayout = new javax.swing.GroupLayout(pnlReporteVendedor);
        pnlReporteVendedor.setLayout(pnlReporteVendedorLayout);
        pnlReporteVendedorLayout.setHorizontalGroup(
            pnlReporteVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscarPorUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlReporteVendedorLayout.setVerticalGroup(
            pnlReporteVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteVendedorLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnBuscarPorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlReporteEstadistico.setBackground(new java.awt.Color(255, 255, 255));
        pnlReporteEstadistico.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlReporteEstadistico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlReporteEstadistico.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel13.setBackground(new java.awt.Color(52, 152, 219));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Estadísticos");
        jLabel13.setOpaque(true);

        btnEstadistico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/estadistico.png"))); // NOI18N
        btnEstadistico.setColorHover(new java.awt.Color(52, 152, 219));
        btnEstadistico.setColorNormal(new java.awt.Color(255, 255, 255));
        btnEstadistico.setColorPressed(new java.awt.Color(255, 255, 255));
        btnEstadistico.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnEstadistico.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnEstadistico.setFocusPainted(false);
        btnEstadistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteEstadisticoLayout = new javax.swing.GroupLayout(pnlReporteEstadistico);
        pnlReporteEstadistico.setLayout(pnlReporteEstadisticoLayout);
        pnlReporteEstadisticoLayout.setHorizontalGroup(
            pnlReporteEstadisticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEstadistico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlReporteEstadisticoLayout.setVerticalGroup(
            pnlReporteEstadisticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteEstadisticoLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnEstadistico, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBody1Layout = new javax.swing.GroupLayout(pnlBody1);
        pnlBody1.setLayout(pnlBody1Layout);
        pnlBody1Layout.setHorizontalGroup(
            pnlBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBody1Layout.createSequentialGroup()
                .addGroup(pnlBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBody1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlReporteDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pnlReporteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBody1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlReporteVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlReporteEstadistico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(pnlReportePeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlBody1Layout.setVerticalGroup(
            pnlBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBody1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlReporteDia, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(pnlReporteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(pnlReportePeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlReporteVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(pnlReporteEstadistico, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pnlBody.add(pnlBody1, "card2");

        javax.swing.GroupLayout PanelReportesLayout = new javax.swing.GroupLayout(PanelReportes);
        PanelReportes.setLayout(PanelReportesLayout);
        PanelReportesLayout.setHorizontalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTOPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelReportesLayout.createSequentialGroup()
                        .addComponent(PanelMenuC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelReportesLayout.setVerticalGroup(
            PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PanelTOPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelReportesLayout.createSequentialGroup()
                        .addComponent(PanelMenuC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelReportesLayout.createSequentialGroup()
                        .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private JPanel container;
    private JPanel content;
    public void CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }
   

    
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed

        CambiaPanel(pnlBody, pnlBody1);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnVentasDel_DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasDel_DiaActionPerformed
        

//
        //        new NewJInternalFrame().setVisible(true);
        //CambiaPanel(pnlMenu, new pnlUsuarios());
        //this.dispose();
        //new pnlVentas().setVisible(maximized);
        //new pnlVentas().setVisible(true);
        CambiaPanel(pnlBody, new pnlReportesDia());
    }//GEN-LAST:event_btnVentasDel_DiaActionPerformed

    private void btnBuscar_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_facturaActionPerformed
        pnlBuscarFactura factura;
        CambiaPanel(pnlBody, factura = new pnlBuscarFactura());
        factura.transferFocus();
    }//GEN-LAST:event_btnBuscar_facturaActionPerformed

    private void btnBuscar_rangosFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_rangosFechaActionPerformed
        pnlReportePeriodos periodos;
        CambiaPanel(pnlBody, periodos = new pnlReportePeriodos());
        periodos.transferFocus();       
    }//GEN-LAST:event_btnBuscar_rangosFechaActionPerformed

    private void btnBuscarPorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorUsuarioActionPerformed
        CambiaPanel(pnlBody, new pnlReporteVendedor());
    }//GEN-LAST:event_btnBuscarPorUsuarioActionPerformed

    private void btnEstadisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticoActionPerformed
        pnlReporteEstadistico estadistico;
        CambiaPanel(pnlBody, estadistico = new pnlReporteEstadistico());
        estadistico.transferFocus();
    }//GEN-LAST:event_btnEstadisticoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenuC;
    private javax.swing.JPanel PanelReportes;
    private javax.swing.JPanel PanelTOPC;
    private lib.RSButtonMetro btnBuscarPorUsuario;
    private lib.RSButtonMetro btnBuscar_factura;
    private lib.RSButtonMetro btnBuscar_rangosFecha;
    private lib.RSButtonMetro btnEstadistico;
    private javax.swing.JButton btnInicio;
    private lib.RSButtonMetro btnVentasDel_Dia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblVentasDia;
    public static javax.swing.JPanel pnlBody;
    public javax.swing.JPanel pnlBody1;
    private javax.swing.JPanel pnlReporteDia;
    private javax.swing.JPanel pnlReporteEstadistico;
    private javax.swing.JPanel pnlReporteFactura;
    private javax.swing.JPanel pnlReportePeriodos;
    private javax.swing.JPanel pnlReporteVendedor;
    // End of variables declaration//GEN-END:variables
}
