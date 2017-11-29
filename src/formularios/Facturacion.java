package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

import conexionesDB.Pool;
import conexionesDB.ValidarControlFactura;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Facturacion {

	public JFrame frmGeneracinDeFacturas;
	private JTextField txtNombApellido;
	private JTextField txtTelef;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtLugar;
	private JTextField txtMonto;
	private JTextField txtDescripcion;
	private JTextField txtTelefonoSeguro;
	private JTextField txtRazonSocial;
	private JTextField txtRif;
	private JTextField txtDominioFiscal;
	private JTextField txtLugarSeguro;
	private JTextField txtMontoSeguro;
	private JTextField txtDescripcionSeguro;
	private JTextField txtTelefonoEntidad;
	private JTextField txtRazonSocialEntidad;
	private JTextField txtRifEntidad;
	private JTextField txtDominioFiscalEntidad;
	private JTextField txtLugarEntidad;
	private JTextField txtMontoEntidad;
	private JTextField txtDescripcionEntidad;
	private JTextField txtNumCheque;
	private JTextField txtNumChequeSeguro;
	private JTextField txtCodSeguro;
	private JTextField txtNumChequeEntidad;
	private JTextField txtCodEntidad;
	private JTextField txtDescripcion2;
	private JTextField txtMonto2;
	private JTextField txtDescripcionEntidad2;
	private JTextField txtMontoEntidad2;
	private JTextField txtDescripcionSeguro2;
	private JTextField txtMontoSeguro2;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturacion window = new Facturacion();
					window.frmGeneracinDeFacturas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Facturacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmGeneracinDeFacturas = new JFrame();
		frmGeneracinDeFacturas.setResizable(false);
		frmGeneracinDeFacturas.setTitle("Generaci\u00F3n de Facturas");
		frmGeneracinDeFacturas.setBounds(100, 100, 612, 482);
		frmGeneracinDeFacturas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneracinDeFacturas.getContentPane().setLayout(null);
		frmGeneracinDeFacturas.setLocationRelativeTo(null);


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 602, 453);
		frmGeneracinDeFacturas.getContentPane().add(tabbedPane);
		Date fechaPaci = new Date();
		SimpleDateFormat format3 = new SimpleDateFormat( "dd/MM/yyyy" );
		format3.format(fechaPaci);

		JPanel panelPaciente = new JPanel();
		tabbedPane.addTab("Paciente", null, panelPaciente, null);
		panelPaciente.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(26, 63, 46, 14);
		panelPaciente.add(label);

		JPanel panelCampos = new JPanel();
		panelCampos.setBorder(new TitledBorder(null, "* Campos obligatorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCampos.setBounds(88, 52, 499, 262);
		panelPaciente.add(panelCampos);
		panelCampos.setLayout(null);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setBounds(24, 88, 78, 14);
		panelCampos.add(lblTelfono);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido: ");
		lblNombreYApellido.setBounds(24, 44, 136, 14);
		panelCampos.add(lblNombreYApellido);

		txtTelef = new JTextField();
		txtTelef.setBounds(24, 107, 112, 20);
		panelCampos.add(txtTelef);
		txtTelef.setColumns(10);

		txtNombApellido = new JTextField();
		txtNombApellido.setBounds(24, 63, 160, 20);
		panelCampos.add(txtNombApellido);
		txtNombApellido.setColumns(10);

		JLabel lblCi = new JLabel("C.I:");
		lblCi.setBounds(206, 44, 46, 14);
		panelCampos.add(lblCi);

		txtCedula = new JTextField();
		txtCedula.setBounds(206, 63, 92, 20);
		panelCampos.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n: ");
		lblDireccin.setBounds(168, 88, 301, 14);
		panelCampos.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(168, 107, 301, 20);
		panelCampos.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblLugarDeEmisin = new JLabel("Lugar de emisi\u00F3n: ");
		lblLugarDeEmisin.setBounds(24, 215, 150, 14);
		panelCampos.add(lblLugarDeEmisin);

		txtLugar = new JTextField();
		txtLugar.setBounds(24, 231, 179, 20);
		panelCampos.add(txtLugar);
		txtLugar.setColumns(10);

		JXDatePicker datePickerFecha = new JXDatePicker();
		datePickerFecha.setBounds(308, 62, 150, 22);
		panelCampos.add(datePickerFecha);
		datePickerFecha.setDate(fechaPaci);

		JLabel lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n: ");
		lblFechaDeEmisin.setBounds(308, 44, 117, 14);
		panelCampos.add(lblFechaDeEmisin);

		JLabel lblMonto = new JLabel("Monto: ");
		lblMonto.setBounds(321, 133, 46, 14);
		panelCampos.add(lblMonto);

		txtMonto = new JTextField();
		txtMonto.setBounds(321, 148, 104, 20);
		panelCampos.add(txtMonto);
		txtMonto.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n 1: ");
		lblDescripcin.setBounds(24, 133, 92, 14);
		panelCampos.add(lblDescripcin);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(24, 148, 267, 20);
		panelCampos.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JLabel lblFormaDePago = new JLabel("Forma de pago: ");
		lblFormaDePago.setBounds(220, 215, 93, 14);
		panelCampos.add(lblFormaDePago);

		JComboBox cmbPaciente = new JComboBox();
		cmbPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbPaciente.getSelectedIndex()==1){

					txtNumCheque.setEnabled(true);

				}
				if(cmbPaciente.getSelectedIndex()==0){

					txtNumCheque.setText(null);
					txtNumCheque.setEnabled(false);
				}

			}
		});
		cmbPaciente.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Cheque"}));
		cmbPaciente.setBounds(220, 231, 78, 20);
		panelCampos.add(cmbPaciente);

		txtNumCheque = new JTextField();
		txtNumCheque.setBounds(316, 231, 109, 20);
		panelCampos.add(txtNumCheque);
		txtNumCheque.setEnabled(false);
		txtNumCheque.setColumns(10);

		JLabel lblNCheque = new JLabel("N\u00B0 Cheque: ");
		lblNCheque.setBounds(316, 215, 86, 14);
		panelCampos.add(lblNCheque);

		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n 2: ");
		lblDescripcin_1.setBounds(24, 172, 92, 14);
		panelCampos.add(lblDescripcin_1);

		txtDescripcion2 = new JTextField();
		txtDescripcion2.setColumns(10);
		txtDescripcion2.setBounds(24, 193, 267, 20);
		panelCampos.add(txtDescripcion2);

		JLabel label_20 = new JLabel("Monto: ");
		label_20.setBounds(321, 172, 46, 14);
		panelCampos.add(label_20);

		txtMonto2 = new JTextField();
		txtMonto2.setColumns(10);
		txtMonto2.setBounds(321, 193, 104, 20);
		panelCampos.add(txtMonto2);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(185, 11, 224, 37);
		panelPaciente.add(panel);

		JLabel lblCreacinDeFactura = new JLabel("Creaci\u00F3n de Factura");
		lblCreacinDeFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCreacinDeFactura);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtNombApellido.setText(null);
				txtCedula.setText(null);
				txtTelef.setText(null);
				txtDireccion.setText(null);
				txtDescripcion.setText(null);
				txtMonto.setText(null);
				txtLugar.setText(null);
				txtNumCheque.setText(null);
				cmbPaciente.setSelectedIndex(0);
				txtDescripcion2.setText("");
				txtMonto2.setText("");
				Date fecha = new Date();
				SimpleDateFormat format2 = new SimpleDateFormat( "dd/MM/yyyy" );
				format2.format(fecha);
				datePickerFecha.setDate(fecha);
				
			}


		}
				);
		btnLimpiar.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Gnome-Edit-Clear-48.png")));
		btnLimpiar.setBounds(127, 325, 157, 56);
		panelPaciente.add(btnLimpiar);

		JButton btnImprimir = new JButton("Imprimir Factura");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(esStringAlfa(txtCedula.getText())==false){
					JOptionPane.showMessageDialog(null, "El campo cédula es sólo numérico y no puede ser nulo", 
							"Error en búsqueda", JOptionPane.ERROR_MESSAGE);

				}else{
					HashMap parametros = new HashMap<>();
					parametros.put("fechaEmision", format3.format(datePickerFecha.getDate()));
					parametros.put("nombreRazon", txtNombApellido.getText());
					parametros.put("direccion", txtDireccion.getText());
					parametros.put("cedulaRif", txtCedula.getText());
					parametros.put("telefono", txtTelef.getText());
					parametros.put("descripcion", txtDescripcion.getText());
					parametros.put("descripcion2", txtDescripcion2.getText());
					parametros.put("monto", Double.parseDouble(txtMonto.getText()));
					parametros.put("monto2", Double.parseDouble(txtMonto2.getText()));
					parametros.put("numCheque", txtNumCheque.getText());
					if(cmbPaciente.getSelectedItem().toString().matches("Efectivo")){

						parametros.put("efectivo", "X");
					}else{
						parametros.put("efectivo", "");
					}
					Connection conect = null;


					//Parametros 


					try {
						Pool Bd = new Pool();
						String direccion = System.getProperty("user.dir")+ "/reportes/factura.jasper";
						JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
						JasperViewer.viewReport(informe, false);

					} catch (JRException | SQLException i) {
						
						i.printStackTrace();
					}finally{

						if(conect!=null){

							try {

								conect.close();

							} catch (SQLException ex) {

								JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

							}

						}

					}
				}




			}
		});
		btnImprimir.setIcon(new ImageIcon(Facturacion.class.getResource("/images/print-icon.png")));
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImprimir.setBounds(294, 325, 196, 56);
		panelPaciente.add(btnImprimir);

		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGeneracinDeFacturas.dispose();

			}
		});
		btnRegresar.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Volver a la pantalla Principal");
		btnRegresar.setBounds(7, 11, 71, 57);
		panelPaciente.add(btnRegresar);

		JPanel panelSeguro = new JPanel();
		tabbedPane.addTab("Seguro", null, panelSeguro, null);
		panelSeguro.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(185, 11, 224, 37);
		panelSeguro.add(panel_1);

		JLabel label_1 = new JLabel("Creaci\u00F3n de Factura");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "* Campos obligatorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(88, 52, 499, 295);
		panelSeguro.add(panel_3);

		JLabel label_2 = new JLabel("Tel\u00E9fono: ");
		label_2.setBounds(25, 111, 78, 14);
		panel_3.add(label_2);

		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social:");
		lblRaznSocial.setBounds(25, 67, 92, 14);
		panel_3.add(lblRaznSocial);

		txtTelefonoSeguro = new JTextField();
		txtTelefonoSeguro.setColumns(10);
		txtTelefonoSeguro.setBounds(25, 130, 112, 20);
		panel_3.add(txtTelefonoSeguro);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(25, 86, 160, 20);
		panel_3.add(txtRazonSocial);

		JLabel lblRif = new JLabel("R.I.F:");
		lblRif.setBounds(210, 67, 46, 14);
		panel_3.add(lblRif);

		txtRif = new JTextField();
		txtRif.setColumns(10);
		txtRif.setBounds(207, 86, 92, 20);
		panel_3.add(txtRif);

		JLabel lblDominiFiscal = new JLabel("Domicilo Fiscal: ");
		lblDominiFiscal.setBounds(169, 111, 301, 14);
		panel_3.add(lblDominiFiscal);

		txtDominioFiscal = new JTextField();
		txtDominioFiscal.setColumns(10);
		txtDominioFiscal.setBounds(169, 130, 301, 20);
		panel_3.add(txtDominioFiscal);

		JLabel label_6 = new JLabel("Lugar de emisi\u00F3n: ");
		label_6.setBounds(25, 248, 179, 14);
		panel_3.add(label_6);

		txtLugarSeguro = new JTextField();
		txtLugarSeguro.setColumns(10);
		txtLugarSeguro.setBounds(25, 264, 179, 20);
		panel_3.add(txtLugarSeguro);

		JXDatePicker datePickerFechaSeguro = new JXDatePicker();
		datePickerFechaSeguro.setBounds(309, 85, 150, 22);
		panel_3.add(datePickerFechaSeguro);
		Date fechaSeg = new Date();
		SimpleDateFormat format2 = new SimpleDateFormat( "dd/MM/yyyy" );
		format2.format(fechaSeg);
		datePickerFechaSeguro.setDate(fechaSeg);

		JLabel label_7 = new JLabel("Fecha de emisi\u00F3n: ");
		label_7.setBounds(307, 67, 104, 14);
		panel_3.add(label_7);

		JLabel label_8 = new JLabel("Monto: ");
		label_8.setBounds(309, 156, 46, 14);
		panel_3.add(label_8);

		txtMontoSeguro = new JTextField();
		txtMontoSeguro.setColumns(10);
		txtMontoSeguro.setBounds(309, 171, 104, 20);
		panel_3.add(txtMontoSeguro);

		JLabel lblDescripcin_4 = new JLabel("Descripci\u00F3n 1: ");
		lblDescripcin_4.setBounds(25, 156, 92, 14);
		panel_3.add(lblDescripcin_4);

		txtDescripcionSeguro = new JTextField();
		txtDescripcionSeguro.setColumns(10);
		txtDescripcionSeguro.setBounds(25, 171, 267, 20);
		panel_3.add(txtDescripcionSeguro);

		JLabel label_10 = new JLabel("Forma de pago: ");
		label_10.setBounds(221, 248, 93, 14);
		panel_3.add(label_10);

		JComboBox cmbSeguro = new JComboBox();
		cmbSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cmbSeguro.getSelectedIndex()==1){

					txtNumChequeSeguro.setEnabled(true);

				}
				if(cmbSeguro.getSelectedIndex()==0){

					txtNumChequeSeguro.setText(null);
					txtNumChequeSeguro.setEnabled(false);
				}

			}
		});
		cmbSeguro.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Cheque"}));
		cmbSeguro.setBounds(221, 264, 78, 20);
		panel_3.add(cmbSeguro);

		JLabel label_18 = new JLabel("N\u00B0 Cheque: ");
		label_18.setBounds(319, 248, 86, 14);
		panel_3.add(label_18);

		txtNumChequeSeguro = new JTextField();
		txtNumChequeSeguro.setEnabled(false);
		txtNumChequeSeguro.setColumns(10);
		txtNumChequeSeguro.setBounds(317, 264, 109, 20);
		panel_3.add(txtNumChequeSeguro);

		JLabel lblCdigoDeSeguro = new JLabel("C\u00F3digo:");
		lblCdigoDeSeguro.setBounds(26, 22, 46, 14);
		panel_3.add(lblCdigoDeSeguro);

		txtCodSeguro = new JTextField();
		txtCodSeguro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){


					if(txtCodSeguro.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Campo código vacío", null, JOptionPane.ERROR_MESSAGE);
					}else{

						// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

						ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
						if(metodosFacturacion.validar_codig_seg(txtCodSeguro.getText())==1){

							txtRazonSocial.setText(metodosFacturacion.getNombSeg());
							txtDescripcionSeguro.setText(metodosFacturacion.getNombreSeguro());
							txtDominioFiscal.setText(metodosFacturacion.getDirecSeg());
							txtRif.setText(metodosFacturacion.getRifSeg());
							txtTelefonoSeguro.setText(metodosFacturacion.getTelfSeg());

						}else{
							if(JOptionPane.showConfirmDialog(null,"Código de Seguro no registrado\n ¿Desea registrarlo primero?",
									"No existe seguro",
									JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
								//Opcion afirmativa
								Facturacion gui = new Facturacion();
								gui.frmGeneracinDeFacturas.dispose();
								DatosSeguros gui2 = new DatosSeguros();
								gui2.main();
							}
						}

					}







				}}
		});
		txtCodSeguro.setBounds(25, 36, 46, 20);
		panel_3.add(txtCodSeguro);
		txtCodSeguro.setColumns(10);

		JButton btnBuscarCodigo = new JButton("");
		btnBuscarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txtCodSeguro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campo código vacío", null, JOptionPane.ERROR_MESSAGE);
				}else{

					// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if(metodosFacturacion.validar_codig_seg(txtCodSeguro.getText())==1){

						txtRazonSocial.setText(metodosFacturacion.getNombSeg());
						txtDescripcionSeguro.setText(metodosFacturacion.getNombreSeguro());
						txtDominioFiscal.setText(metodosFacturacion.getDirecSeg());
						txtRif.setText(metodosFacturacion.getRifSeg());
						txtTelefonoSeguro.setText(metodosFacturacion.getTelfSeg());

					}else{
						if(JOptionPane.showConfirmDialog(null,"Código de Seguro no registrado\n ¿Desea registrarlo primero?",
								"No existe seguro",
								JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
							//Opcion afirmativa
							Facturacion gui = new Facturacion();
							gui.frmGeneracinDeFacturas.dispose();
							DatosSeguros gui2 = new DatosSeguros();
							gui2.main();
						}
					}

				}






			}
		});
		btnBuscarCodigo.setIcon(new ImageIcon(Facturacion.class.getResource("/images/toolbar_find.png")));
		btnBuscarCodigo.setBounds(91, 22, 46, 34);
		panel_3.add(btnBuscarCodigo);

		JLabel lblDescripcin_5 = new JLabel("Descripci\u00F3n 2: ");
		lblDescripcin_5.setBounds(23, 202, 92, 14);
		panel_3.add(lblDescripcin_5);

		txtDescripcionSeguro2 = new JTextField();
		txtDescripcionSeguro2.setColumns(10);
		txtDescripcionSeguro2.setBounds(23, 217, 267, 20);
		panel_3.add(txtDescripcionSeguro2);

		JLabel label_21 = new JLabel("Monto: ");
		label_21.setBounds(307, 202, 46, 14);
		panel_3.add(label_21);

		txtMontoSeguro2 = new JTextField();
		txtMontoSeguro2.setColumns(10);
		txtMontoSeguro2.setBounds(307, 217, 104, 20);
		panel_3.add(txtMontoSeguro2);

		JButton btnLimpiarSeguro = new JButton("Limpiar");
		btnLimpiarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtCodSeguro.setText("");
				txtRazonSocial.setText("");
				txtRif.setText("");
				txtTelefonoSeguro.setText("");
				txtDominioFiscal.setText("");
				txtDescripcionSeguro.setText("");
				txtDescripcionSeguro2.setText("");
				txtMontoSeguro.setText("");
				txtMontoSeguro2.setText("");
				cmbSeguro.setSelectedIndex(0);
				txtNumChequeSeguro.setText("");
				Date fechaSeg = new Date();
				SimpleDateFormat format2 = new SimpleDateFormat( "dd/MM/yyyy" );
				format2.format(fechaSeg);
				datePickerFechaSeguro.setDate(fechaSeg);
				txtLugarSeguro.setText("");
				
				//
			}
		});
		btnLimpiarSeguro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiarSeguro.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Gnome-Edit-Clear-48.png")));
		btnLimpiarSeguro.setBounds(126, 358, 157, 56);
		panelSeguro.add(btnLimpiarSeguro);

		JButton btnImprimirSeguro = new JButton("Imprimir Factura");
		btnImprimirSeguro.setIcon(new ImageIcon(Facturacion.class.getResource("/images/print-icon.png")));
		btnImprimirSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txtRif.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Imposible generar factura sin RIF\n"
							, "Error en el Registro", 
							JOptionPane.ERROR_MESSAGE);
				}else{
					HashMap parametros = new HashMap<>();
					parametros.put("fechaEmision", format3.format(datePickerFechaSeguro.getDate()));
					parametros.put("nombreRazon", txtRazonSocial.getText());
					parametros.put("direccion", txtDominioFiscal.getText());
					parametros.put("cedulaRif", txtRif.getText());
					parametros.put("telefono", txtTelefonoSeguro.getText());
					parametros.put("descripcion", txtDescripcionSeguro.getText());
					parametros.put("descripcion2", txtDescripcionSeguro2.getText());
					parametros.put("monto", Double.parseDouble(txtMontoSeguro.getText()));
					parametros.put("monto2", Double.parseDouble(txtMontoSeguro2.getText()));
					parametros.put("numCheque", txtNumChequeSeguro.getText());
					if(cmbSeguro.getSelectedItem().toString().matches("Efectivo")){

						parametros.put("efectivo", "X");
					}else{
						parametros.put("efectivo", "");
					}
					Connection conect = null;


					//Parametros 


					try {
						Pool Bd = new Pool();
						String direccion = System.getProperty("user.dir")+ "/reportes/factura.jasper";
						JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
						JasperViewer.viewReport(informe, false);

					} catch (JRException | SQLException i) {
						
						i.printStackTrace();
					}finally{

						if(conect!=null){

							try {

								conect.close();

							} catch (SQLException ex) {

								JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

							}

						}

					}
				}




			}
		});
		btnImprimirSeguro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImprimirSeguro.setBounds(293, 358, 196, 56);
		panelSeguro.add(btnImprimirSeguro);

		JButton btnRegresarSeguro = new JButton("");
		btnRegresarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmGeneracinDeFacturas.dispose();

			}
		});
		btnRegresarSeguro.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Button Previous_48.png")));
		btnRegresarSeguro.setToolTipText("Volver a la pantalla Principal");
		btnRegresarSeguro.setBounds(7, 11, 71, 57);
		panelSeguro.add(btnRegresarSeguro);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Entidad", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(185, 11, 224, 37);
		panel_2.add(panel_4);

		JLabel label_3 = new JLabel("Creaci\u00F3n de Factura");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(label_3);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "* Campos obligatorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(88, 52, 499, 295);
		panel_2.add(panel_5);

		JLabel label_4 = new JLabel("Tel\u00E9fono: ");
		label_4.setBounds(27, 111, 78, 14);
		panel_5.add(label_4);

		JLabel label_5 = new JLabel("Raz\u00F3n Social:");
		label_5.setBounds(27, 67, 92, 14);
		panel_5.add(label_5);

		txtTelefonoEntidad = new JTextField();
		txtTelefonoEntidad.setColumns(10);
		txtTelefonoEntidad.setBounds(27, 130, 112, 20);
		panel_5.add(txtTelefonoEntidad);

		txtRazonSocialEntidad = new JTextField();
		txtRazonSocialEntidad.setColumns(10);
		txtRazonSocialEntidad.setBounds(27, 86, 160, 20);
		panel_5.add(txtRazonSocialEntidad);

		JLabel label_11 = new JLabel("R.I.F:");
		label_11.setBounds(212, 67, 46, 14);
		panel_5.add(label_11);

		txtRifEntidad = new JTextField();
		txtRifEntidad.setColumns(10);
		txtRifEntidad.setBounds(209, 86, 92, 20);
		panel_5.add(txtRifEntidad);

		JLabel lblDomicilioFiscal = new JLabel("Domicilio Fiscal: ");
		lblDomicilioFiscal.setBounds(171, 111, 301, 14);
		panel_5.add(lblDomicilioFiscal);

		txtDominioFiscalEntidad = new JTextField();
		txtDominioFiscalEntidad.setColumns(10);
		txtDominioFiscalEntidad.setBounds(171, 130, 301, 20);
		panel_5.add(txtDominioFiscalEntidad);

		JLabel label_13 = new JLabel("Lugar de emisi\u00F3n: ");
		label_13.setBounds(27, 248, 179, 14);
		panel_5.add(label_13);

		txtLugarEntidad = new JTextField();
		txtLugarEntidad.setColumns(10);
		txtLugarEntidad.setBounds(27, 264, 179, 20);
		panel_5.add(txtLugarEntidad);

		JXDatePicker datePickerFechaEntidad = new JXDatePicker();
		datePickerFechaEntidad.setBounds(311, 85, 150, 22);
		panel_5.add(datePickerFechaEntidad);
		Date fechaEnti = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
		format.format(fechaEnti);
		datePickerFechaEntidad.setDate(fechaEnti);

		JLabel label_14 = new JLabel("Fecha de emisi\u00F3n: ");
		label_14.setBounds(309, 67, 104, 14);
		panel_5.add(label_14);

		JLabel label_15 = new JLabel("Monto: ");
		label_15.setBounds(311, 156, 46, 14);
		panel_5.add(label_15);

		txtMontoEntidad = new JTextField();
		txtMontoEntidad.setColumns(10);
		txtMontoEntidad.setBounds(309, 171, 104, 20);
		panel_5.add(txtMontoEntidad);

		JLabel lblDescripcin_2 = new JLabel("Descripci\u00F3n 1: ");
		lblDescripcin_2.setBounds(27, 156, 92, 14);
		panel_5.add(lblDescripcin_2);

		txtDescripcionEntidad = new JTextField();
		txtDescripcionEntidad.setColumns(10);
		txtDescripcionEntidad.setBounds(27, 171, 267, 20);
		panel_5.add(txtDescripcionEntidad);

		JLabel label_17 = new JLabel("Forma de pago: ");
		label_17.setBounds(223, 248, 86, 14);
		panel_5.add(label_17);

		JComboBox cmbEntidad = new JComboBox();
		cmbEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(cmbEntidad.getSelectedIndex()==1){

					txtNumChequeEntidad.setEnabled(true);

				}
				if(cmbEntidad.getSelectedIndex()==0){

					txtNumChequeEntidad.setText(null);
					txtNumChequeEntidad.setEnabled(false);
				}

			}
		});
		cmbEntidad.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Cheque"}));
		cmbEntidad.setBounds(223, 264, 78, 20);
		panel_5.add(cmbEntidad);

		txtNumChequeEntidad = new JTextField();
		txtNumChequeEntidad.setEnabled(false);
		txtNumChequeEntidad.setColumns(10);
		txtNumChequeEntidad.setBounds(317, 264, 109, 20);
		panel_5.add(txtNumChequeEntidad);

		JLabel label_19 = new JLabel("N\u00B0 Cheque: ");
		label_19.setBounds(319, 248, 86, 14);
		panel_5.add(label_19);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(27, 21, 54, 14);
		panel_5.add(lblCdigo);

		txtCodEntidad = new JTextField();
		txtCodEntidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){


					if(txtCodEntidad.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Campo código vacío", null, JOptionPane.ERROR_MESSAGE);
					}else{

						// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

						ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
						if(metodosFacturacion.validar_codig_entid(txtCodEntidad.getText())==1){

							txtRazonSocialEntidad.setText(metodosFacturacion.getNombEnti());
							txtDominioFiscalEntidad.setText(metodosFacturacion.getDirecEnti());
							txtRifEntidad.setText(metodosFacturacion.getRifEnti());
							txtTelefonoEntidad.setText(metodosFacturacion.getTelfEnti());

						}else{
							if(JOptionPane.showConfirmDialog(null,"Código de entidad no registrado\n ¿Desea registrarlo primero?",
									"No existe seguro",
									JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
								//Opcion afirmativa
								frmGeneracinDeFacturas.dispose();
								DatosEntidades gui2 = new DatosEntidades();
								gui2.main();
							}
						}

					}






				}
			}
		});
		txtCodEntidad.setBounds(27, 36, 46, 20);
		panel_5.add(txtCodEntidad);
		txtCodEntidad.setColumns(10);

		JButton btnBuscarEntidad = new JButton("");
		btnBuscarEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(txtCodEntidad.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campo código vacío", null, JOptionPane.ERROR_MESSAGE);
				}else{

					// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if(metodosFacturacion.validar_codig_entid(txtCodEntidad.getText())==1){

						txtRazonSocialEntidad.setText(metodosFacturacion.getNombEnti());
						txtDominioFiscalEntidad.setText(metodosFacturacion.getDirecEnti());
						txtRifEntidad.setText(metodosFacturacion.getRifEnti());
						txtTelefonoEntidad.setText(metodosFacturacion.getTelfEnti());

					}else{
						if(JOptionPane.showConfirmDialog(null,"Código de entidad no registrado\n ¿Desea registrarlo primero?",
								"No existe seguro",
								JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
							//Opcion afirmativa
							frmGeneracinDeFacturas.dispose();
							DatosEntidades gui2 = new DatosEntidades();
							gui2.main();
						}
					}

				}





			}
		});
		btnBuscarEntidad.setIcon(new ImageIcon(Facturacion.class.getResource("/images/toolbar_find.png")));
		btnBuscarEntidad.setBounds(91, 22, 48, 34);
		panel_5.add(btnBuscarEntidad);

		JLabel lblDescripcin_3 = new JLabel("Descripci\u00F3n 2: ");
		lblDescripcin_3.setBounds(27, 202, 92, 14);
		panel_5.add(lblDescripcin_3);

		txtDescripcionEntidad2 = new JTextField();
		txtDescripcionEntidad2.setColumns(10);
		txtDescripcionEntidad2.setBounds(27, 217, 267, 20);
		panel_5.add(txtDescripcionEntidad2);

		JLabel label_22 = new JLabel("Monto: ");
		label_22.setBounds(311, 202, 46, 14);
		panel_5.add(label_22);

		txtMontoEntidad2 = new JTextField();
		txtMontoEntidad2.setColumns(10);
		txtMontoEntidad2.setBounds(309, 217, 104, 20);
		panel_5.add(txtMontoEntidad2);

		JButton btnLimpiarEntidad = new JButton("Limpiar");
		btnLimpiarEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodEntidad.setText("");
				txtRazonSocialEntidad.setText("");
				txtRifEntidad.setText("");
				txtTelefonoEntidad.setText("");
				txtDominioFiscalEntidad.setText("");
				txtDescripcionEntidad.setText("");
				txtDescripcionEntidad2.setText("");
				txtMontoEntidad.setText("");
				txtMontoEntidad2.setText("");
				cmbEntidad.setSelectedIndex(0);
				txtNumChequeEntidad.setText("");
				Date fechaEnt = new Date();
				SimpleDateFormat format2 = new SimpleDateFormat( "dd/MM/yyyy" );
				format2.format(fechaEnt);
				datePickerFechaEntidad.setDate(fechaEnt);
				txtLugarEntidad.setText("");
				
				//
			}
		});
		btnLimpiarEntidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiarEntidad.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Gnome-Edit-Clear-48.png")));
		btnLimpiarEntidad.setBounds(126, 358, 157, 56);
		panel_2.add(btnLimpiarEntidad);

		JButton btnImprimirEntidad = new JButton("Imprimir Factura");
		btnImprimirEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(txtRifEntidad.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Imposible generar factura sin RIF"
							, "Error en el Registro", 
							JOptionPane.ERROR_MESSAGE);
				}else{
					HashMap parametros = new HashMap<>();
					parametros.put("fechaEmision", format3.format(datePickerFechaSeguro.getDate()));
					parametros.put("nombreRazon", txtRazonSocialEntidad.getText());
					parametros.put("direccion", txtDominioFiscalEntidad.getText());
					parametros.put("cedulaRif", txtRifEntidad.getText());
					parametros.put("telefono", txtTelefonoEntidad.getText());
					parametros.put("descripcion", txtDescripcionEntidad.getText());
					parametros.put("descripcion2", txtDescripcionEntidad2.getText());
					parametros.put("monto", Double.parseDouble(txtMontoEntidad.getText()));
					parametros.put("monto2", Double.parseDouble(txtMontoEntidad2.getText()));
					parametros.put("numCheque", txtNumChequeEntidad.getText());
					if(cmbEntidad.getSelectedItem().toString().matches("Efectivo")){

						parametros.put("efectivo", "X");
					}else{
						parametros.put("efectivo", "");
					}
					Connection conect = null;


					//Parametros 


					try {
						Pool Bd = new Pool();
						String direccion = System.getProperty("user.dir")+ "/reportes/factura.jasper";
						JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
						JasperViewer.viewReport(informe, false);

					} catch (JRException | SQLException i) {
						
						i.printStackTrace();
					}finally{

						if(conect!=null){

							try {

								conect.close();

							} catch (SQLException ex) {

								JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

							}

						}

					}
				}





			}
		});
		btnImprimirEntidad.setIcon(new ImageIcon(Facturacion.class.getResource("/images/print-icon.png")));
		btnImprimirEntidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImprimirEntidad.setBounds(293, 358, 196, 56);
		panel_2.add(btnImprimirEntidad);

		JButton btnRegresarEntidad = new JButton("");
		btnRegresarEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmGeneracinDeFacturas.dispose();


			}
		});
		btnRegresarEntidad.setIcon(new ImageIcon(Facturacion.class.getResource("/images/Button Previous_48.png")));
		btnRegresarEntidad.setToolTipText("Volver a la pantalla Principal");
		btnRegresarEntidad.setBounds(7, 11, 71, 57);
		panel_2.add(btnRegresarEntidad);
	}
	
	public boolean esStringAlfa(String name) {

		if(name.length()==0){
			return false;
		}
			
			char[] chars = name.toCharArray();

			for (char c : chars) {
				if(!Character.isLetter(c)) {

					return true;
				}
			}
		



		return false;

	}

}
