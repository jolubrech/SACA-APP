package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import conexionesDB.ValidarBusquedaPacientesSeguroEntidad;
import conexionesDB.ValidarEntidades;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DatosEntidades {

	public static JFrame frame;
	public static JTextField txtCodEnt;
	public static JTextField txtNombInstitu;
	public static JTextField txtDireccion;
	public static JTextField txtRif;
	public static JTextField txtTelef;
	public static JTextField txtBuscaEntidades;
	public static JTable tablaEntidades;
	public static JPanel listaEntidades;
	public static JPanel listaEntidadesFinal;
	public static JPanel principal;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbBuscaEntidades;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbTipoEntidad;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					DatosEntidades window = new DatosEntidades();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatosEntidades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 828, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);

		JPanel principal = new JPanel();
		frame.getContentPane().add(principal, "name_947812926647491");
		principal.setLayout(null);

		JPanel listaEntidades = new JPanel();
		frame.getContentPane().add(listaEntidades, "name_947812936285993");
		listaEntidades.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(288, 30, 228, 27);
		principal.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(290, 27, 219, 27);
		listaEntidades.add(panel_1);

		JLabel lblCdigoDeLa = new JLabel("Cod. Entidad:");
		lblCdigoDeLa.setBounds(178, 85, 119, 14);
		principal.add(lblCdigoDeLa);

		JComboBox cmbTipoEntidad = new JComboBox();
		cmbTipoEntidad.setBounds(398, 276, 110, 20);
		principal.add(cmbTipoEntidad);
		cmbTipoEntidad.setModel(new DefaultComboBoxModel(new String[] {"Privada", "Publica"}));

		txtNombInstitu = new JTextField();
		txtNombInstitu.setBounds(178, 170, 305, 20);
		principal.add(txtNombInstitu);
		txtNombInstitu.setColumns(10);

		txtTelef = new JTextField();
		txtTelef.setBounds(288, 276, 100, 20);
		principal.add(txtTelef);
		txtTelef.setColumns(10);

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
		txtBuscaEntidades.setBounds(312, 105, 267, 20);
		listaEntidades.add(txtBuscaEntidades);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				ValidarEntidades metodosEntidades = new ValidarEntidades();




				if (JOptionPane.showConfirmDialog(null,"Desea modificar los datos de la entidad: "+txtNombInstitu.getText().toString()+"?", 
						"Modificar datos", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

					// CASO AFIRMATIVO

					//VALIDACION

					if (metodosEntidades.modificarEntidad(txtCodEnt.getText(), txtNombInstitu.getText(), 
							txtDireccion.getText(), txtRif.getText(), txtTelef.getText(), 
							cmbTipoEntidad.getSelectedItem().toString()) == 1) {
						JOptionPane.showMessageDialog(null,
								"Los datos se han modificado correctamente",
								"Éxito en la operación",
								JOptionPane.INFORMATION_MESSAGE);
						

					}
				}


				else {
					// no option

					JOptionPane.showMessageDialog(null,
							"Los datos no se pudieron modificar",
							"Operación cancelada",
							JOptionPane.WARNING_MESSAGE);
				}







			}
		});
		btnModificar.setBounds(593, 126, 154, 57);
		principal.add(btnModificar);
		btnModificar.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/edit.png")));
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarEntidades metodosEntidades = new ValidarEntidades();

				if(txtCodEnt.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,
							"El código de entidad no existe (o es nula) en la Base de Datos\n"
									+ "Corrija e intente nuevamente",
									"Error en la operación", JOptionPane.ERROR_MESSAGE);
				}else {


					if (JOptionPane.showConfirmDialog(null,"¿Quieres eliminar la entidad?","Registro entidad",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						//OPCION INFORMATIVA
						if (metodosEntidades.eliminarEntidad(txtCodEnt.getText()) == 1) {
							JOptionPane.showMessageDialog(null,
									"Entidad eliminada correctamente!",
									"Actualizando Base de Datos",
									JOptionPane.INFORMATION_MESSAGE);
							txtCodEnt.requestFocus();
							txtCodEnt.setText("");
							txtDireccion.setText(null);
							txtNombInstitu.setText("");
							txtRif.setText("");
							txtTelef.setText("");
							cmbTipoEntidad.setSelectedIndex(0);
							txtCodEnt.setEditable(true);


						}

					}

				}


			}
		});
		btnEliminar.setBounds(594, 189, 154, 57);
		principal.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/delete_dustbin-48.png")));
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(txtCodEnt.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Los datos de la entidad no se pudieron guardar: \n"
									+ "Código de entidad obligatorio",
									"Error en la operación", JOptionPane.ERROR_MESSAGE);	

				}else{

					if (JOptionPane.showConfirmDialog(null,"¿Desea registrar la entidad? ", "Registar entidad",
							JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

						//Caso Afirmativo
						ValidarEntidades metodosEntidades = new ValidarEntidades();
						if (metodosEntidades.registrarEntidad(txtCodEnt.getText(), txtNombInstitu.getText(), txtDireccion.getText()
								, txtRif.getText(), txtTelef.getText(), cmbTipoEntidad.getSelectedItem().toString() ) == 1) {
							JOptionPane.showMessageDialog(null,
									"Los datos se han guardado correctamente",
									"Éxito en la operación",
									JOptionPane.INFORMATION_MESSAGE);	

							txtCodEnt.requestFocus();
							txtCodEnt.setText(null);
							txtDireccion.setText(null);
							txtNombInstitu.setText("");
							txtRif.setText("");
							txtTelef.setText("");
							cmbTipoEntidad.setSelectedIndex(0);
							btnModificar.setEnabled(true);
							btnEliminar.setEnabled(true);

						}
					}else{
						//Caso negativo

						JOptionPane.showMessageDialog(null,
								"Operación cancelada\n"
										+ "No se realizó el registro",
										"Error en la operación", JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnRegistrar.setBounds(593, 64, 154, 57);
		principal.add(btnRegistrar);
		btnRegistrar.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/media_floppy_green.png")));
		
		

		txtCodEnt = new JTextField();
		txtCodEnt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if(txtCodEnt.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Código de entidad obligatorio: vacío", "Error de Registro",
								JOptionPane.ERROR_MESSAGE);

					}else{
						ValidarEntidades metodosEntidades = new ValidarEntidades();
						if (metodosEntidades.validar_seleccion_entidad(txtCodEnt.getText()) == 1) {
							cmbTipoEntidad.setSelectedItem(metodosEntidades.getCmbTipoEntidad());
							txtCodEnt.setEditable(false);
						}else{

							JOptionPane.showMessageDialog(null,
									"No existe entidad. Agréguela acontinuación:",
									"Busqueda de entidad",
									JOptionPane.INFORMATION_MESSAGE);
							txtCodEnt.requestFocus(true);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
							txtDireccion.setText(null);
							txtNombInstitu.setText(null);
							txtRif.setText(null);
							txtTelef.setText(null);

						}


					}

				}
			}
		});
		txtCodEnt.setBounds(178, 101, 86, 20);
		principal.add(txtCodEnt);
		txtCodEnt.setColumns(10);

		txtRif = new JTextField();
		txtRif.setBounds(178, 276, 100, 20);
		principal.add(txtRif);
		txtRif.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(178, 226, 318, 20);
		principal.add(txtDireccion);
		txtDireccion.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 148, 594, 198);
		listaEntidades.add(scrollPane);

		JComboBox cmbBuscaEntidades = new JComboBox();
		cmbBuscaEntidades.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nombre", "Direcci\u00F3n", "Rif", "Telef", "Tipo"}));
		cmbBuscaEntidades.setBounds(191, 104, 111, 20);
		listaEntidades.add(cmbBuscaEntidades);

		tablaEntidades = new JTable();
		tablaEntidades.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarEntidades metodosEntidades = new ValidarEntidades();
					if (metodosEntidades.validar_seleccion_entidad(tablaEntidades.getValueAt(tablaEntidades.getSelectedRow(), 0).toString()) == 1) {
						listaEntidades.setVisible(false);
						principal.setVisible(true);
						cmbTipoEntidad.setSelectedItem(metodosEntidades.getCmbTipoEntidad());
						txtCodEnt.setEditable(false);

					}
				}

			}
		});
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
		scrollPane.setViewportView(tablaEntidades);

		
		

		

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodEnt.requestFocus();
				txtCodEnt.setText("");
				txtDireccion.setText(null);
				txtNombInstitu.setText("");
				txtRif.setText("");
				txtTelef.setText("");
				cmbTipoEntidad.setSelectedIndex(0);
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
				txtCodEnt.setEditable(true);
			}
		});
		btnLimpiar.setBounds(594, 252, 154, 57);
		principal.add(btnLimpiar);
		btnLimpiar.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/Gnome-Edit-Clear-48.png")));

		JLabel lblNombreDeLa = new JLabel("Nombre de la Instituci\u00F3n");
		lblNombreDeLa.setBounds(178, 145, 143, 14);
		principal.add(lblNombreDeLa);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(178, 201, 60, 14);
		principal.add(lblDireccin);

		JLabel lblRif = new JLabel("Rif");
		lblRif.setBounds(178, 257, 46, 14);
		principal.add(lblRif);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(288, 257, 60, 14);
		principal.add(lblTelfono);

		JLabel lblTipoDeEntidad = new JLabel("Tipo de Entidad");
		lblTipoDeEntidad.setBounds(404, 257, 92, 14);
		principal.add(lblTipoDeEntidad);

		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_4.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/Button Previous_48.png")));
		button_4.setToolTipText("Volver a la pantalla Principal");
		button_4.setBounds(10, 11, 71, 57);
		principal.add(button_4);

		JLabel lblDatosDeEntidades = new JLabel("DATOS DE ENTIDADES");
		lblDatosDeEntidades.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		lblDatosDeEntidades.setBounds(38, 0, 160, 27);
		panel.add(lblDatosDeEntidades);

		JButton btnListaDeEntidades = new JButton("Lista de Entidades");
		btnListaDeEntidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaEntidades.setVisible(true);
				principal.setVisible(false);
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Entidad(txtBuscaEntidades.getText(), cmbBuscaEntidades.getSelectedItem().toString(), tablaEntidades);
				txtBuscaEntidades.requestFocus();

			}
		});
		btnListaDeEntidades.setBounds(345, 85, 198, 40);
		principal.add(btnListaDeEntidades);

		JLabel label = new JLabel("Buscar Entidad por: ");
		label.setBounds(50, 109, 131, 14);
		listaEntidades.add(label);

		JButton button_5 = new JButton("Buscar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Entidad(txtBuscaEntidades.getText(), cmbBuscaEntidades.getSelectedItem().toString(), tablaEntidades);

			}
		});
		button_5.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/search-47.png")));
		button_5.setBounds(604, 81, 131, 51);
		listaEntidades.add(button_5);

		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.setVisible(true);
				listaEntidades.setVisible(false);
			}
		});
		button_6.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/Button Previous_48.png")));
		button_6.setToolTipText("Volver a la pantalla Datos de Entidades");
		button_6.setBounds(10, 11, 65, 57);
		listaEntidades.add(button_6);

		JLabel label_1 = new JLabel("LISTA DE ENTIDADES");
		label_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		label_1.setBounds(38, 0, 153, 27);
		panel_1.add(label_1);

		txtCodEnt.setText("");
		txtNombInstitu.setText("");
		txtDireccion.setText("");
		txtRif.setText("");
		txtTelef.setText("");
		cmbTipoEntidad.setSelectedIndex(0);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(DatosEntidades.class.getResource("/images/toolbar_find.png")));
		button.setBounds(274, 94, 38, 34);
		principal.add(button);
	}
}
