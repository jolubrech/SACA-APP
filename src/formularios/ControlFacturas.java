package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.border.EtchedBorder;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXLabel;

import conexionesDB.ValidarBusquedaPacientesSeguroEntidad;
import conexionesDB.ValidarControlFactura;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import org.jdesktop.swingx.JXLabel.TextAlignment;


public class ControlFacturas {

	public static JFrame frmControlDeFacturas;
	public static JPanel facturacion;
	public static JPanel listaPacientes;
	public static JPanel listaSeguros;
	public static JPanel listaEntidades;


	public static JTextField txtFactura;
	public static JTextField txtNombApelli;
	public static JTextField txtCodEnti;
	public static JTextField txtNombEnti;
	public static JTextField txtCodSeg;
	public static JTextField txtMonto;
	public static JTextField txtDescrip;
	public static JTextField txtNombSeg;
	public static JXDatePicker dateFactura;
	public static JXDatePicker dateCancela;
	public static JTextField txtBuscaPacien;
	public static JTable tablaPacientes;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbEstadoCuenta;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbFormPago;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbTipoAten;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbBuscaEntidades;
	public static JTextField txtBuscaSeguros;
	public static JTextField txtBuscaEntidades;
	public static JTable tablaEntidades;
	private JTable tablaSeguros;




	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					ControlFacturas window = new ControlFacturas();
					window.frmControlDeFacturas.setVisible(true);
					txtFactura.requestFocus();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public ControlFacturas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial", "deprecation" })
	private void initialize() {

		frmControlDeFacturas = new JFrame();
		frmControlDeFacturas.setTitle("Control de Facturas");
		frmControlDeFacturas.setResizable(false);
		frmControlDeFacturas.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmControlDeFacturas.setBounds(100, 100, 930, 612);
		frmControlDeFacturas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmControlDeFacturas.getContentPane().setLayout(new CardLayout(0, 0));
		frmControlDeFacturas.setLocationRelativeTo(null);

		JPanel controlFacturas = new JPanel();
		controlFacturas.setToolTipText("");
		frmControlDeFacturas.getContentPane().add(controlFacturas, "name_323591674229838");
		controlFacturas.setLayout(null);

		JPanel listaPacientes = new JPanel();
		frmControlDeFacturas.getContentPane().add(listaPacientes, "name_323484122166216");
		listaPacientes.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "*Campos obligatorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(52, 115, 612, 377);
		controlFacturas.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(406, 195, 162, 171);
		panel_6.add(panel_1);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Fechas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		//FORMATEO DATE PICKERS
		SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
		final Date startDate = new Date( 0 );
		format.set2DigitYearStart( startDate );	

		JXDatePicker dateCancela = new JXDatePicker();
		dateCancela.setBounds(10, 94, 142, 22);
		panel_1.add(dateCancela);
		dateCancela.hide();

		JComboBox cmbTipoAten = new JComboBox();
		cmbTipoAten.setBounds(32, 232, 105, 20);
		panel_6.add(cmbTipoAten);
		cmbTipoAten.setModel(new DefaultComboBoxModel(new String[] {"Valoracion", "Cirug\u00EDa", "Otros..."}));
		cmbTipoAten.setSelectedIndex(0);

		JXDatePicker dateFactura = new JXDatePicker();
		dateFactura.setBounds(10, 46, 142, 22);
		panel_1.add(dateFactura);
		dateCancela.setFormats( format );
		dateFactura.setFormats(format);

		JLabel lblFechaDeFacturacin = new JLabel("Fecha de Facturaci\u00F3n: ");
		lblFechaDeFacturacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeFacturacin.setBounds(22, 29, 130, 14);
		panel_1.add(lblFechaDeFacturacin);

		JLabel lblFechaDeCancelacin = new JLabel("Fecha de Cancelaci\u00F3n: ");
		lblFechaDeCancelacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeCancelacin.setBounds(22, 77, 130, 14);
		panel_1.add(lblFechaDeCancelacin);
		Date currentDate = new Date();
		dateCancela.setDate(currentDate);
		dateFactura.setDate(currentDate);

		JLabel lblBuscarPacientePor = new JLabel("Buscar Paciente por: ");
		lblBuscarPacientePor.setBounds(175, 76, 128, 14);
		listaPacientes.add(lblBuscarPacientePor);

		JXLabel lblfacturaNoCancelada = new JXLabel();
		lblfacturaNoCancelada.setTextAlignment(TextAlignment.CENTER);
		lblfacturaNoCancelada.setBounds(20, 127, 123, 35);
		lblfacturaNoCancelada.setText("       \u00A1No cancelada!  ");
		lblfacturaNoCancelada.setForeground(Color.WHITE);
		lblfacturaNoCancelada.setBackground(Color.red);
		lblfacturaNoCancelada.setOpaque(true);
		panel_1.add(lblfacturaNoCancelada);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(288, 79, 184, 27);
		controlFacturas.add(panel);

		JButton btnBuscarSeguro = new JButton("");
		btnBuscarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
				if(StringUtils.isNumeric(txtCodSeg.getText())!=true ||StringUtils.isEmpty(txtCodSeg.getText())==true){
					JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
				}else{

					// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

					
					if(metodosFacturacion.validar_codig_seg(txtCodSeg.getText())==1){

						txtNombSeg.setText(metodosFacturacion.getNombSeg());

					}else{
						if(JOptionPane.showConfirmDialog(null,"Código de Seguro no registrado\n ¿Desea registrarlo primero?",
								"No existe Seguro",
								JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
							//Opcion afirmativa

							DatosSeguros gui2 = new DatosSeguros();
							gui2.main();


						}
					}

				}






			}
		});
		btnBuscarSeguro.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/toolbar_find.png")));
		btnBuscarSeguro.setBounds(234, 157, 38, 34);
		panel_6.add(btnBuscarSeguro);


		JLabel lblFacturacin = new JLabel("CONTROL DE FACTURAS");
		lblFacturacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturacin.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		panel.add(lblFacturacin);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFacturacin}));

		JComboBox cmbEstadoCuenta = new JComboBox();
		cmbEstadoCuenta.setBounds(168, 232, 105, 20);
		panel_6.add(cmbEstadoCuenta);
		cmbEstadoCuenta.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Cancelada"}));
		cmbEstadoCuenta.setSelectedIndex(0);
		cmbEstadoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbEstadoCuenta.getSelectedItem().toString()
						.equalsIgnoreCase("pendiente")) {

					dateCancela.hide();
					dateCancela.setDate(null);
					lblfacturaNoCancelada.setText("   \u00A1 No cancelada!");
					lblfacturaNoCancelada.setForeground(Color.WHITE);
					lblfacturaNoCancelada.setBackground(Color.red);
					lblfacturaNoCancelada.setOpaque(true);


				} else {
					dateCancela.show();
					lblfacturaNoCancelada.setText("   \u00A1 Cancelada!");
					lblfacturaNoCancelada.setForeground(Color.WHITE);
					lblfacturaNoCancelada.setBackground(Color.green);
					lblfacturaNoCancelada.setOpaque(true);


				}}
		});

		JComboBox cmbFormPago = new JComboBox();
		cmbFormPago.setBounds(32, 164, 105, 20);
		panel_6.add(cmbFormPago);
		cmbFormPago.setModel(new DefaultComboBoxModel(new String[] {"Seguro", "Efectivo", "Cheque", "Otros..."}));
		cmbFormPago.setSelectedIndex(0);
		cmbFormPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbFormPago.getSelectedIndex()==0){
					txtCodSeg.setEditable(true);
					txtNombSeg.setEditable(true);
					btnBuscarSeguro.setEnabled(true);
				}else{
					txtCodSeg.setEditable(false);
					txtNombSeg.setEditable(false);
					txtCodSeg.setText("");
					txtNombSeg.setText("");
					btnBuscarSeguro.setEnabled(false);
				}
			}
		});



		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");



				if (JOptionPane.showConfirmDialog(null,"Desea modificar los datos del paciente: "+txtNombApelli.getText().toString()+"?", 
						"Modificar datos", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

					// CASO AFIRMATIVO
					if(txtFactura.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Imposible modificar paciente sin N° de factura\n"
								, "Error en el Registro", 
								JOptionPane.ERROR_MESSAGE);
					}else{
						//VALIDACION

						if (metodosFacturacion.modificarFactura(txtFactura.getText(),
								txtNombApelli.getText(), txtCodEnti.getText(),
								txtNombEnti.getText(), cmbFormPago.getSelectedItem()
								.toString(), txtCodSeg.getText(), cmbTipoAten
								.getSelectedItem().toString(), cmbEstadoCuenta
								.getSelectedItem().toString(), txtMonto
								.getText(), txtDescrip.getText(), formater
								.format(dateFactura.getDate()), formater
								.format(dateCancela.getDate())) == 1) {
							JOptionPane.showMessageDialog(null,
									"Los datos se han modificado correctamente",
									"Éxito en la operación",
									JOptionPane.INFORMATION_MESSAGE);

						}else {
							// no option

							JOptionPane.showMessageDialog(null,
									"Los datos no se pudieron modificar",
									"Operación cancelada",
									JOptionPane.WARNING_MESSAGE);
						}
					}



				}





			}
		});
		btnModificar.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/edit.png")));
		btnModificar.setBounds(268, 498, 154, 57);
		controlFacturas.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarControlFactura metodosFacturacion = new ValidarControlFactura();



				if (JOptionPane.showConfirmDialog(null,"Desea eliminar los datos del paciente: "
						+txtNombApelli.getText().toString()+"?", "Eliminar datos",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

					// CASO AFIRMATIVO

					//VALIDACION

					if(txtFactura.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Imposible eliminar paciente \n"
								, "Campo N° de factura nula o no existe", 
								JOptionPane.ERROR_MESSAGE);
					}else{
						if (metodosFacturacion.eliminarFactura() == 1) {
							JOptionPane.showMessageDialog(null,
									"Paciente Eliminado correctamente!",
									"Actualizando Base de Datos",
									JOptionPane.INFORMATION_MESSAGE);
							txtFactura.requestFocus();
							txtFactura.setText(null);
							txtNombApelli.setText("");
							txtCodEnti.setText("");
							txtNombEnti.setText("");
							txtCodSeg.setText("");
							txtMonto.setText("0.0");
							txtDescrip.setText("");
							txtNombSeg.setText("");



							Date currentDate = new Date();
							dateCancela.setDate(currentDate);
							dateFactura.setDate(currentDate);
							cmbEstadoCuenta.setSelectedIndex(0);
							cmbFormPago.setSelectedIndex(0);
							cmbTipoAten.setSelectedIndex(0);
							txtFactura.setEditable(true);

						}
					}


				}
				else {
					// no option

					JOptionPane.showMessageDialog(null,
							"Operación cancelada\n"
									+ "El paciente no pudo ser eliminado",
									"Error en la operación", JOptionPane.WARNING_MESSAGE);
				}




			}
		});
		btnEliminar.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/delete_dustbin-48.png")));
		btnEliminar.setBounds(432, 498, 154, 57);
		controlFacturas.add(btnEliminar);




		JComboBox cmbBuscaPacien = new JComboBox();
		cmbBuscaPacien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscaPacien.requestFocus();
			}
		});
		cmbBuscaPacien.setBounds(324, 73, 128, 20);
		cmbBuscaPacien.setModel(new DefaultComboBoxModel(new String[] {"Nombre/Apellido", "N\u00B0 Factura"}));
		listaPacientes.add(cmbBuscaPacien);

		txtBuscaPacien = new JTextField();
		txtBuscaPacien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();

					metodosbd.Buscar(txtBuscaPacien.getText(), cmbBuscaPacien.getSelectedItem().toString(), tablaPacientes);



				}
			}
		}
				);
		txtBuscaPacien.setBounds(462, 73, 232, 20);
		listaPacientes.add(txtBuscaPacien);
		txtBuscaPacien.setColumns(10);

		JButton btnBuscaPacien = new JButton("Buscar");
		btnBuscaPacien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar(txtBuscaPacien.getText(), cmbBuscaPacien.getSelectedItem().toString(), tablaPacientes);

			}
		});
		btnBuscaPacien.setBounds(704, 58, 146, 50);
		btnBuscaPacien.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search.png")));
		listaPacientes.add(btnBuscaPacien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 138, 854, 412);
		listaPacientes.add(scrollPane);

		tablaPacientes = new JTable();
		tablaPacientes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"N\u00B0 Factura", "Nombre/Apellido", "Codigo Entidad", "Forma Pago", "Monto", "Tipo Atencion", "Descripci\u00F3n", "Estado Cuenta", "Nombre Entidad", "Fecha Facturaci\u00F3n", "Fecha Cancelaci\u00F3n", "C\u00F3digo Seguro"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaPacientes.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablaPacientes.getColumnModel().getColumn(1).setPreferredWidth(110);
		tablaPacientes.getColumnModel().getColumn(2).setPreferredWidth(112);
		tablaPacientes.getColumnModel().getColumn(3).setPreferredWidth(94);
		tablaPacientes.getColumnModel().getColumn(4).setPreferredWidth(66);
		tablaPacientes.getColumnModel().getColumn(5).setPreferredWidth(102);
		tablaPacientes.getColumnModel().getColumn(6).setPreferredWidth(130);
		tablaPacientes.getColumnModel().getColumn(7).setPreferredWidth(110);
		tablaPacientes.getColumnModel().getColumn(8).setPreferredWidth(122);
		tablaPacientes.getColumnModel().getColumn(9).setPreferredWidth(134);
		tablaPacientes.getColumnModel().getColumn(10).setPreferredWidth(130);
		tablaPacientes.getColumnModel().getColumn(11).setPreferredWidth(97);
		scrollPane.setViewportView(tablaPacientes);
		tablaPacientes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if (metodosFacturacion.validar_seleccion_paciente(tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0).toString()) == 1) {
						listaPacientes.setVisible(false);
						controlFacturas.setVisible(true);


						txtFactura.setText(tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0).toString());
						txtNombApelli.setText(metodosFacturacion.getNombApelli());
						txtCodEnti.setText(metodosFacturacion.getCodEnti());
						txtNombEnti.setText(metodosFacturacion.getNombEnti());
						if(metodosFacturacion.getCodSeg().equalsIgnoreCase("")){
							txtCodSeg.setText(metodosFacturacion.getCodSeg());
							txtCodSeg.setEditable(false);	
						}else{
							txtCodSeg.setText(metodosFacturacion.getCodSeg());
							txtCodSeg.setEditable(true);	
						}

						txtMonto.setText(metodosFacturacion.getMonto());
						txtDescrip.setText(metodosFacturacion.getDescrip());
						//FORMATTED TEXT FIELD NOMB SEGURO//
						//JTextField txtNombSeg2 = new JTextField();
						//txtNombSeg2.setEditable(false);
						//txtNombSeg2.setBounds(443, 265, 190, 20);
						txtNombSeg.setText(metodosFacturacion.getNombSeg());
						txtNombSeg.setToolTipText(metodosFacturacion.getNombSeg());
						//facturacion.add(txtNombSeg2);


						//COMBO BOX FORMA DE PAGO

						cmbFormPago.setSelectedItem(metodosFacturacion
								.getFormaPago());
						cmbEstadoCuenta.setSelectedItem(metodosFacturacion
								.getEstadoCuenta());
						cmbTipoAten.setSelectedItem(metodosFacturacion
								.getTipoAtencion());
						//DATE PICKER FECHA CANCELACION
						//JXDatePicker dateCancela = new JXDatePicker();
						//dateCancela.setBounds(24, 94, 112, 22);
						//panel_1.add(dateCancela);
						dateCancela.setDate(metodosFacturacion.getFechaCance());
						//DATE PICKER FECHA FACTURACION
						//JXDatePicker dateFactura = new JXDatePicker();
						//dateFactura.setBounds(10, 36, 142, 22);
						//panel_1.add(dateFactura);
						dateFactura.setDate(metodosFacturacion.getFechaFactu());
						//FECHAS FORMATEADAS
						SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );
						final Date startDate = new Date( 0 );//01.01.1970
						format.set2DigitYearStart( startDate );	
						dateCancela.setFormats( format );
						dateFactura.setFormats(format);
						txtFactura.setEditable(false);
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);


					}
				}
			}
		});


		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaPacientes.hide();
			}
		});
		button.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/Button Previous_48.png")));
		button.setToolTipText("Volver a la pantalla Facturaci\u00F3n");
		button.setBounds(33, 21, 71, 57);
		listaPacientes.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(295, 21, 248, 27);
		listaPacientes.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblListaDePacientes = new JLabel("B\u00DASQUEDA DE PACIENTES");
		lblListaDePacientes.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		panel_2.add(lblListaDePacientes);



		JPanel listaSeguros = new JPanel();
		frmControlDeFacturas.getContentPane().add(listaSeguros, "name_323487420091710");
		listaSeguros.setLayout(null);

		JLabel lblBuscarEntidadPor = new JLabel("Buscar Seguro por: ");
		lblBuscarEntidadPor.setBounds(164, 77, 102, 14);
		listaSeguros.add(lblBuscarEntidadPor);

		JComboBox cmbBuscaSeguros = new JComboBox();
		cmbBuscaSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscaSeguros.requestFocus();
			}
		});
		cmbBuscaSeguros.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "C\u00F3digo", "Tipo", "RIF"}));
		cmbBuscaSeguros.setBounds(297, 74, 80, 20);
		listaSeguros.add(cmbBuscaSeguros);

		txtBuscaSeguros = new JTextField();
		txtBuscaSeguros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();

					metodosbd.Buscar_Seguros(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);



				}
			}
		});
		txtBuscaSeguros.setBounds(387, 74, 217, 20);
		txtBuscaSeguros.setColumns(10);
		listaSeguros.add(txtBuscaSeguros);

		JButton btnBuscaEntidad = new JButton("Buscar");
		btnBuscaEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Seguros(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);
			}
		});
		btnBuscaEntidad.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search.png")));
		btnBuscaEntidad.setBounds(689, 59, 131, 51);
		listaSeguros.add(btnBuscaEntidad);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaSeguros.hide();
			}
		});
		button_2.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/Button Previous_48.png")));
		button_2.setBounds(31, 27, 65, 57);
		button_2.setToolTipText("Volver a la pantalla Facturaci\u00F3n");
		listaSeguros.add(button_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(342, 25, 202, 27);
		listaSeguros.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblListaDeSeguros = new JLabel("B\u00DASQUEDA DE SEGUROS");
		lblListaDeSeguros.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		panel_3.add(lblListaDeSeguros);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(66, 128, 666, 348);
		listaSeguros.add(scrollPane_1);

		tablaSeguros = new JTable();
		tablaSeguros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER){

					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if (metodosFacturacion.validar_seleccion_seguro(tablaSeguros.getValueAt(tablaSeguros.getSelectedRow(), 0).toString()) == 1) {
						listaSeguros.setVisible(false);
						controlFacturas.setVisible(true);

						txtNombSeg.setText(metodosFacturacion.getNombreSeguro());
						txtNombSeg.setToolTipText(metodosFacturacion.getNombreSeguro());
						txtCodSeg.setText(metodosFacturacion.getCodigoSeg());



					}

				}



			}
		});
		tablaSeguros.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
						"C\u00F3digo", "Nombre", "Direcci\u00F3n", "Rif", "Tel\u00E9fono", "Tipo"
				}
				));
		tablaSeguros.getColumnModel().getColumn(0).setPreferredWidth(85);
		tablaSeguros.getColumnModel().getColumn(1).setPreferredWidth(88);
		tablaSeguros.getColumnModel().getColumn(2).setPreferredWidth(97);
		tablaSeguros.getColumnModel().getColumn(3).setPreferredWidth(83);
		tablaSeguros.getColumnModel().getColumn(4).setPreferredWidth(91);
		scrollPane_1.setViewportView(tablaSeguros);

		JPanel listaEntidades = new JPanel();
		frmControlDeFacturas.getContentPane().add(listaEntidades, "name_323489391804440");
		listaEntidades.setLayout(null);

		JLabel label = new JLabel("Buscar Entidad por: ");
		label.setBounds(100, 112, 131, 14);
		listaEntidades.add(label);

		JComboBox cmbBuscaEntidades = new JComboBox();
		cmbBuscaEntidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscaEntidades.requestFocus();
			}
		});
		cmbBuscaEntidades.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nombre", "Direcci\u00F3n", "Rif", "Telef", "Tipo"}));
		cmbBuscaEntidades.setBounds(241, 107, 111, 20);
		listaEntidades.add(cmbBuscaEntidades);

		txtBuscaEntidades = new JTextField();
		txtBuscaEntidades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();

					metodosbd.Buscar_Entidad(txtBuscaEntidades.getText(), cmbBuscaEntidades.getSelectedItem().toString(), tablaEntidades);



				}
			}
		});
		txtBuscaEntidades.setColumns(10);
		txtBuscaEntidades.setBounds(362, 108, 267, 20);
		listaEntidades.add(txtBuscaEntidades);

		JButton btnBuscarEnti = new JButton("Buscar");
		btnBuscarEnti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Entidad(txtBuscaEntidades.getText(), cmbBuscaEntidades.getSelectedItem().toString(), tablaEntidades);

			}
		});
		btnBuscarEnti.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search-47.png")));
		btnBuscarEnti.setBounds(657, 92, 131, 51);
		listaEntidades.add(btnBuscarEnti);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				listaEntidades.hide();

			}
		});
		button_3.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/Button Previous_48.png")));
		button_3.setToolTipText("Volver a la pantalla Facturaci\u00F3n");
		button_3.setBounds(38, 22, 65, 57);
		listaEntidades.add(button_3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(125, 163, 612, 208);
		listaEntidades.add(scrollPane_2);

		tablaEntidades = new JTable();
		tablaEntidades.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo", "Nombre", "Direcci\u00F3n", "Rif", "Telef", "Tipo"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaEntidades.getColumnModel().getColumn(0).setPreferredWidth(52);
		tablaEntidades.getColumnModel().getColumn(1).setPreferredWidth(71);
		tablaEntidades.getColumnModel().getColumn(2).setPreferredWidth(140);
		tablaEntidades.getColumnModel().getColumn(3).setPreferredWidth(90);
		tablaEntidades.getColumnModel().getColumn(4).setPreferredWidth(92);
		tablaEntidades.getColumnModel().getColumn(5).setPreferredWidth(76);
		scrollPane_2.setViewportView(tablaEntidades);
		tablaEntidades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){

					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if (metodosFacturacion.validar_seleccion_entidad(tablaEntidades.getValueAt(tablaEntidades.getSelectedRow(), 0).toString()) == 1) {
						listaEntidades.setVisible(false);
						controlFacturas.setVisible(true);

						txtNombEnti.setText(metodosFacturacion.getNombreEnti());
						txtNombEnti.setToolTipText(metodosFacturacion.getNombreEnti());
						txtCodEnti.setText(metodosFacturacion.getCodigoEnti());



					}

				}


			}
		});


		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(343, 38, 219, 27);
		listaEntidades.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblListaDeEntidades = new JLabel("B\u00DASQUEDA DE ENTIDADES");
		lblListaDeEntidades.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		panel_4.add(lblListaDeEntidades);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(735, 14, 40, 14);
		controlFacturas.add(lblFecha);


		//FECHA//
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");// you can use
		// any
		// format
		// that you
		// want, for
		// example:("yyyy/MM/dd")
		String s = SDF.format(date);
		JFormattedTextField ftfFecha = new JFormattedTextField(s);
		ftfFecha.setEditable(false);
		ftfFecha.setBounds(783, 11, 71, 20);
		controlFacturas.add(ftfFecha);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,"¿Quieres registrar al paciente?","Registro paciente",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					// CASO AFIRMATIVO

					if(txtFactura.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Imposible registrar un paciente sin N° de factura\n"
								, "Error en el Registro", 
								JOptionPane.ERROR_MESSAGE);
					}else {
						//VALIDACION

						ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
						SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

						if (metodosFacturacion.registrarPaciente(txtFactura.getText(),
								txtNombApelli.getText(), txtCodEnti.getText(),
								txtNombEnti.getText(), cmbFormPago.getSelectedItem()
								.toString(), txtCodSeg.getText(), cmbTipoAten
								.getSelectedItem().toString(), cmbEstadoCuenta
								.getSelectedItem().toString(), txtMonto
								.getText(), txtDescrip.getText(), formater.format(dateFactura.getDate()),
								formater.format(dateCancela.getDate())) == 1) {

							JOptionPane.showMessageDialog(null, "¡Los datos del paciente fueron registrados!");

							txtFactura.setText("");
							txtFactura.requestFocus();
							txtNombApelli.setText(null);
							txtCodEnti.setText("");
							txtNombEnti.setText("");
							txtCodSeg.setText("");
							txtCodSeg.setEditable(true);
							txtMonto.setText("0.0");
							txtDescrip.setText("");
							txtNombSeg.setText(""); 
							Date currentDate = new Date();
							dateCancela.setDate(currentDate);
							dateFactura.setDate(currentDate);
							cmbEstadoCuenta.setSelectedIndex(0);
							cmbFormPago.setSelectedIndex(0);
							cmbTipoAten.setSelectedIndex(0);
							txtFactura.setEditable(true);
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);

						}else {
							// no option

							JOptionPane.showMessageDialog(null,
									"Los datos no se pudieron registrar",
									"Operación cancelada",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}
			}

		});
		btnRegistrar.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/media_floppy_green.png")));
		btnRegistrar.setBounds(103, 498, 154, 57);
		controlFacturas.add(btnRegistrar);





		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFactura.setText("");
				txtFactura.requestFocus();
				txtNombApelli.setText(null);
				txtCodEnti.setText("");
				txtNombEnti.setText("");
				txtCodSeg.setText("");
				txtCodSeg.setToolTipText(null);
				txtCodSeg.setEditable(true);
				txtMonto.setText("0.0");
				txtDescrip.setText("");
				txtNombSeg.setText(""); 
				Date currentDate = new Date();
				dateCancela.setDate(currentDate);
				dateFactura.setDate(currentDate);
				cmbEstadoCuenta.setSelectedIndex(0);
				cmbFormPago.setSelectedIndex(0);
				cmbTipoAten.setSelectedIndex(0);

				txtFactura.setEditable(true);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);



			}
		});
		btnLimpiar.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/Gnome-Edit-Clear-48.png")));
		btnLimpiar.setBounds(596, 498, 154, 57);
		controlFacturas.add(btnLimpiar);

		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmControlDeFacturas.dispose();

			}
		});
		btnRegresar.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Volver a la pantalla Principal");
		btnRegresar.setBounds(50, 25, 71, 57);
		controlFacturas.add(btnRegresar);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "B\u00FAsquedas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(680, 187, 213, 236);
		controlFacturas.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNumFactura = new JLabel("N\u00B0 Factura:");
		lblNumFactura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumFactura.setBounds(32, 35, 105, 14);
		panel_6.add(lblNumFactura);


		txtFactura = new JTextField();
		txtFactura.setBounds(32, 52, 92, 20);
		panel_6.add(txtFactura);
		txtFactura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if(StringUtils.isNumeric(txtFactura.getText())!=true ||StringUtils.isEmpty(txtFactura.getText())==true){
						JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
					}else{
						//
						if (metodosFacturacion.validar_factura() == 1) {

							txtNombSeg.setText(metodosFacturacion.getNombSeg());


							cmbFormPago.setSelectedItem(metodosFacturacion
									.getFormaPago());
							cmbEstadoCuenta.setSelectedItem(metodosFacturacion
									.getEstadoCuenta());
							cmbTipoAten.setSelectedItem(metodosFacturacion
									.getTipoAtencion());

							//DATE PICKER FECHA CANCELACION
							dateCancela.setDate(metodosFacturacion.getFechaCance());
							//DATE PICKER FECHA FACTURACION
							dateFactura.setDate(metodosFacturacion.getFechaFactu());
							//FECHAS FORMATEADAS

							SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );
							final Date startDate = new Date( 0 );//01.01.1970
							format.set2DigitYearStart( startDate );

							dateCancela.setFormats( format );
							dateFactura.setFormats(format);
							txtFactura.setEditable(false);





						} else {
							JOptionPane.showMessageDialog(null,
									"No existe la factura!");
							txtNombApelli.setText("");
							txtCodEnti.setText("");
							txtNombEnti.setText("");
							txtCodSeg.setText("");
							txtMonto.setText("0.0");
							txtDescrip.setText("");
							txtNombSeg.setText("");
							Date currentDate = new Date();
							dateCancela.setDate(currentDate);
							dateFactura.setDate(currentDate);
							txtNombApelli.requestFocus();
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);


						}


					}
				}

			}
		});
		txtFactura.setColumns(10);

		txtFactura.setText("");

		JLabel lblCodigoEntidad = new JLabel("Cod. Entidad: ");
		lblCodigoEntidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoEntidad.setBounds(32, 83, 126, 14);
		panel_6.add(lblCodigoEntidad);

		txtCodEnti = new JTextField();
		txtCodEnti.setBounds(32, 108, 56, 20);
		panel_6.add(txtCodEnti);
		txtCodEnti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					
					if(StringUtils.isNumeric(txtCodEnti.getText())!=true ||StringUtils.isEmpty(txtCodEnti.getText())==true){
						JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
					}else{

						// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

						
						if(metodosFacturacion.validar_codig_entid(txtCodEnti.getText())==1){

							txtNombEnti.setText(metodosFacturacion.getNombEnti());

						}else{
							if(JOptionPane.showConfirmDialog(null,"Código de Entidad no registrado\n ¿Desea registrarlo primero?",
									"No existe Entidad",
									JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
								//Opcion afirmativa

								DatosEntidades gui2 = new DatosEntidades();
								gui2.main();


							}
						}

					}






				}



			}
		});
		txtCodEnti.setColumns(10);
		txtCodEnti.setText("");

		JLabel lblFormaDePago = new JLabel("Forma de Pago:");
		lblFormaDePago.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFormaDePago.setBounds(32, 139, 105, 14);
		panel_6.add(lblFormaDePago);

		JLabel lblTipoDeAtencin = new JLabel("Tipo de Atenci\u00F3n: ");
		lblTipoDeAtencin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeAtencin.setBounds(32, 207, 105, 14);
		panel_6.add(lblTipoDeAtencin);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n: ");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setBounds(32, 263, 114, 14);
		panel_6.add(lblDescripcin);

		txtDescrip = new JTextField();
		txtDescrip.setBounds(32, 288, 281, 20);
		panel_6.add(txtDescrip);
		txtDescrip.setColumns(10);
		txtDescrip.setText("");

		JLabel lblNombApelli = new JLabel("Nombre y Apellido:");
		lblNombApelli.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombApelli.setBounds(195, 35, 114, 14);
		panel_6.add(lblNombApelli);

		txtNombApelli = new JTextField();
		txtNombApelli.setBounds(195, 52, 220, 20);
		panel_6.add(txtNombApelli);
		txtNombApelli.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					txtCodEnti.requestFocus();
				}




			}
		});
		txtNombApelli.setColumns(10);
		txtNombApelli.setText(null);

		JLabel lblNombreDeLa = new JLabel("Nombre de la Entidad");
		lblNombreDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDeLa.setBounds(195, 83, 126, 14);
		panel_6.add(lblNombreDeLa);

		txtNombEnti = new JTextField();
		txtNombEnti.setBounds(195, 108, 220, 20);
		panel_6.add(txtNombEnti);
		txtNombEnti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtCodSeg.requestFocus();
				}

			}
		});
		txtNombEnti.setColumns(10);
		txtNombEnti.setText("");

		JLabel lblCodSeguro = new JLabel("Cod. Seguro:");
		lblCodSeguro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodSeguro.setBounds(168, 139, 105, 14);
		panel_6.add(lblCodSeguro);

		JLabel lblNewLabel = new JLabel("Nombre Seguro: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(294, 139, 130, 14);
		panel_6.add(lblNewLabel);

		txtNombSeg = new JTextField();
		txtNombSeg.setBounds(294, 164, 220, 20);
		panel_6.add(txtNombSeg);
		txtNombSeg.setEditable(false);
		txtNombSeg.setColumns(10);
		txtNombSeg.setText(""); 

		txtCodSeg = new JTextField();
		txtCodSeg.setBounds(168, 164, 56, 20);
		panel_6.add(txtCodSeg);
		txtCodSeg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
					if(StringUtils.isNumeric(txtCodSeg.getText())!=true ||StringUtils.isEmpty(txtCodSeg.getText())==true){
						JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
					}else{

						// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

						
						if(metodosFacturacion.validar_codig_seg(txtCodSeg.getText())==1){

							txtNombSeg.setText(metodosFacturacion.getNombSeg());

						}else{
							if(JOptionPane.showConfirmDialog(null,"Código de Seguro no registrado\n ¿Desea registrarlo primero?",
									"No existe Seguro",
									JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
								//Opcion afirmativa

								DatosSeguros gui2 = new DatosSeguros();
								gui2.main();


							}
						}

					}






				}
			}
		});
		txtCodSeg.setColumns(10);
		txtCodSeg.setText("");

		JLabel lblEstadoDeCuenta = new JLabel("Estado de Cuenta:");
		lblEstadoDeCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstadoDeCuenta.setBounds(168, 207, 114, 14);
		panel_6.add(lblEstadoDeCuenta);

		JLabel lblMonto = new JLabel("Monto: ");
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMonto.setBounds(294, 207, 56, 14);
		panel_6.add(lblMonto);




		txtMonto = new JTextField();
		txtMonto.setBounds(294, 232, 86, 20);
		panel_6.add(txtMonto);
		txtMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					txtDescrip.requestFocus();

				}
			}
		});
		txtMonto.setColumns(10);
		txtMonto.setText("0.0");

		JButton btnBuscarFactura = new JButton("");
		btnBuscarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
				if(StringUtils.isNumeric(txtFactura.getText())!=true ||StringUtils.isEmpty(txtFactura.getText())==true){
					JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
				}else{
					//
					if (metodosFacturacion.validar_factura() == 1) {

						txtNombSeg.setText(metodosFacturacion.getNombSeg());


						cmbFormPago.setSelectedItem(metodosFacturacion
								.getFormaPago());
						cmbEstadoCuenta.setSelectedItem(metodosFacturacion
								.getEstadoCuenta());
						cmbTipoAten.setSelectedItem(metodosFacturacion
								.getTipoAtencion());

						//DATE PICKER FECHA CANCELACION
						dateCancela.setDate(metodosFacturacion.getFechaCance());
						//DATE PICKER FECHA FACTURACION
						dateFactura.setDate(metodosFacturacion.getFechaFactu());
						//FECHAS FORMATEADAS

						SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );
						final Date startDate = new Date( 0 );//01.01.1970
						format.set2DigitYearStart( startDate );

						dateCancela.setFormats( format );
						dateFactura.setFormats(format);
						txtFactura.setEditable(false);





					} else {
						JOptionPane.showMessageDialog(null,
								"No existe la factura!");
						txtNombApelli.setText("");
						txtCodEnti.setText("");
						txtNombEnti.setText("");
						txtCodSeg.setText("");
						txtMonto.setText("0.0");
						txtDescrip.setText("");
						txtNombSeg.setText("");
						Date currentDate = new Date();
						dateCancela.setDate(currentDate);
						dateFactura.setDate(currentDate);
						txtNombApelli.requestFocus();
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);


					}


				}
			}
		});
		btnBuscarFactura.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/toolbar_find.png")));
		btnBuscarFactura.setBounds(134, 49, 38, 34);
		panel_6.add(btnBuscarFactura);

		JButton btnBuscarEntidad = new JButton("");
		btnBuscarEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarControlFactura metodosFacturacion = new ValidarControlFactura();
				
				if(StringUtils.isNumeric(txtCodEnti.getText())!=true ||StringUtils.isEmpty(txtCodEnti.getText())==true){
					JOptionPane.showMessageDialog(null,"Campo es sólo numérico y no nulo",null, JOptionPane.ERROR_MESSAGE);
				}else{

					// AQUI SE LEE Y MODIFICA NOMBRE SEGURO

					
					if(metodosFacturacion.validar_codig_entid(txtCodEnti.getText())==1){

						txtNombEnti.setText(metodosFacturacion.getNombEnti());

					}else{
						if(JOptionPane.showConfirmDialog(null,"Código de Entidad no registrado\n ¿Desea registrarlo primero?",
								"No existe Entidad",
								JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
							//Opcion afirmativa

							DatosEntidades gui2 = new DatosEntidades();
							gui2.main();


						}
					}

				}






			}
		});
		btnBuscarEntidad.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/toolbar_find.png")));
		btnBuscarEntidad.setBounds(108, 105, 38, 34);
		panel_6.add(btnBuscarEntidad);

		JButton btnListaDeSeguros = new JButton("Seguros");
		btnListaDeSeguros.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListaDeSeguros.setBounds(23, 157, 166, 59);
		panel_5.add(btnListaDeSeguros);
		btnListaDeSeguros.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search-47.png")));
		btnListaDeSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaSeguros.setVisible(true);
				controlFacturas.setVisible(false);
				txtBuscaSeguros.setText("");
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Seguros(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);
				txtBuscaSeguros.requestFocus();
			}
		});

		JButton btnListaDeEntidades = new JButton("Entidades");
		btnListaDeEntidades.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListaDeEntidades.setBounds(23, 92, 166, 57);
		panel_5.add(btnListaDeEntidades);
		btnListaDeEntidades.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search-47.png")));
		btnListaDeEntidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listaEntidades.setVisible(true);
				controlFacturas.setVisible(false);
				txtBuscaEntidades.setText("");
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Entidad(txtBuscaEntidades.getText(), cmbBuscaEntidades.getSelectedItem().toString(), tablaEntidades);
				txtBuscaEntidades.requestFocus();
			}
		});

		JButton btnListaDePacientes = new JButton("Pacientes");
		btnListaDePacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListaDePacientes.setBounds(23, 22, 166, 59);
		panel_5.add(btnListaDePacientes);
		btnListaDePacientes.setIcon(new ImageIcon(ControlFacturas.class.getResource("/images/search-47.png")));
		btnListaDePacientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				listaPacientes.setVisible(true);
				controlFacturas.setVisible(false);
				txtBuscaPacien.setText("");
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar(txtBuscaPacien.getText(), cmbBuscaPacien.getSelectedItem().toString(), tablaPacientes);

				tablaPacientes.setAutoCreateRowSorter(true);

				txtBuscaPacien.requestFocus();


			}
		});






	}
}
