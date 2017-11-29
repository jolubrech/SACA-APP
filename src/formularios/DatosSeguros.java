package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import conexionesDB.ValidarBusquedaPacientesSeguroEntidad;
import conexionesDB.ValidarSeguros;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DatosSeguros {

	private JFrame frame;
	public static JTextField txtBuscaSeguros;
	public static JTextField txtCodSeguro;
	public static JTextField txtNombSeguro;
	public static JTextField txtDireccion;
	public static JTextField txtRif;
	public static JTextField txtTelefono;
	public static JTable tablaSeguros;
	public static JPanel listaSeguros;
	public static JPanel principal;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbBuscaSeguros;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbTipoSeguro;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosSeguros window = new DatosSeguros();
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
	public DatosSeguros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		JPanel principal = new JPanel();
		frame.getContentPane().add(principal, "name_1044126205706468");
		principal.setLayout(null);
		
		JPanel listaSeguros = new JPanel();
		frame.getContentPane().add(listaSeguros, "name_951351076382314");
		listaSeguros.setLayout(null);
		
		JLabel lblCdigoDelSeguro = new JLabel("Cod. Seguro:");
		lblCdigoDelSeguro.setBounds(210, 114, 77, 14);
		principal.add(lblCdigoDelSeguro);
		
		JComboBox cmbTipoSeguro = new JComboBox();
		cmbTipoSeguro.setModel(new DefaultComboBoxModel(new String[] {"Privada", "Publica"}));
		cmbTipoSeguro.setBounds(430, 305, 110, 20);
		principal.add(cmbTipoSeguro);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
				ValidarSeguros metodosSeguros = new ValidarSeguros();



				if (JOptionPane.showConfirmDialog(null,"Desea modificar los datos de la entidad: "+txtCodSeguro.getText().toString()+"?", 
						"Modificar datos", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

					// CASO AFIRMATIVO

					//VALIDACION

					if (metodosSeguros.modificarSeguro(txtCodSeguro.getText(), txtNombSeguro.getText(), 
							txtDireccion.getText(), txtRif.getText(), txtTelefono.getText(), 
							cmbTipoSeguro.getSelectedItem().toString()) == 1) {
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
		btnModificar.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/edit.png")));
		btnModificar.setBounds(625, 155, 154, 57);
		principal.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarSeguros metodosSeguros = new ValidarSeguros();

				if(txtCodSeguro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,
							"El código de entidad no existe (o es nula) en la Base de Datos\n"
									+ "Corrija e intente nuevamente",
									"Error en la operación", JOptionPane.ERROR_MESSAGE);
				}else {


					if (JOptionPane.showConfirmDialog(null,"¿Quieres eliminar la entidad?","Registro entidad",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						//OPCION INFORMATIVA
						if (metodosSeguros.eliminarSeguro(txtCodSeguro.getText()) == 1) {
							JOptionPane.showMessageDialog(null,
									"Entidad eliminada correctamente!",
									"Actualizando Base de Datos",
									JOptionPane.INFORMATION_MESSAGE);
							txtCodSeguro.requestFocus();
							txtCodSeguro.setText("");
							txtDireccion.setText(null);
							txtNombSeguro.setText("");
							txtRif.setText("");
							txtTelefono.setText("");
							cmbTipoSeguro.setSelectedIndex(0);
							txtCodSeguro.setEditable(true);


						}

					}

				}


			}
		});
		btnEliminar.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/delete_dustbin-48.png")));
		btnEliminar.setBounds(626, 218, 154, 57);
		principal.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtCodSeguro.requestFocus();
				txtCodSeguro.setText("");
				txtDireccion.setText(null);
				txtNombSeguro.setText("");
				txtRif.setText("");
				txtTelefono.setText("");
				cmbTipoSeguro.setSelectedIndex(0);
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
				txtCodSeguro.setEditable(true);
			
			}
		});
		btnLimpiar.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/Gnome-Edit-Clear-48.png")));
		btnLimpiar.setBounds(626, 281, 154, 57);
		principal.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(txtCodSeguro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,
							"Los datos de la entidad no se pudieron guardar: \n"
									+ "Código de entidad obligatorio",
									"Error en la operación", JOptionPane.ERROR_MESSAGE);	

				}else{

					if (JOptionPane.showConfirmDialog(null,"¿Desea registrar la entidad? ", "Registar entidad",
							JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {

						//Caso Afirmativo
						
						ValidarSeguros metodosSeguros = new ValidarSeguros();
						if (metodosSeguros.registrarSeguro(txtCodSeguro.getText(), txtNombSeguro.getText(), txtDireccion.getText()
								, txtRif.getText(), txtTelefono.getText(), cmbTipoSeguro.getSelectedItem().toString() ) == 1) {
							JOptionPane.showMessageDialog(null,
									"Los datos se han guardado correctamente",
									"Éxito en la operación",
									JOptionPane.INFORMATION_MESSAGE);	

							txtCodSeguro.requestFocus();
							txtCodSeguro.setText(null);
							txtDireccion.setText(null);
							txtNombSeguro.setText("");
							txtRif.setText("");
							txtTelefono.setText("");
							cmbTipoSeguro.setSelectedIndex(0);
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
		btnRegistrar.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/media_floppy_green.png")));
		btnRegistrar.setBounds(625, 93, 154, 57);
		principal.add(btnRegistrar);
		
		txtCodSeguro = new JTextField();
		txtCodSeguro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {


					if(txtCodSeguro.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Código de Seguro obligatorio: vacío", "Error de Registro",
								JOptionPane.ERROR_MESSAGE);

					}else{
						ValidarSeguros metodosSeguros = new ValidarSeguros();
						if (metodosSeguros.validar_seleccion_Seguro(txtCodSeguro.getText()) == 1) {
							cmbTipoSeguro.setSelectedItem(metodosSeguros.getCmbTipoSeguro());
							txtCodSeguro.setEditable(false);
						}else{

							JOptionPane.showMessageDialog(null,
									"No existe seguro. Agréguela acontinuación",
									"Busqueda de seguro",
									JOptionPane.INFORMATION_MESSAGE);
							txtCodSeguro.requestFocus(true);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
							txtDireccion.setText(null);
							txtNombSeguro.setText(null);
							txtRif.setText(null);
							txtTelefono.setText(null);

						}


					}

				
				}
				
			}
		});
		txtCodSeguro.setColumns(10);
		txtCodSeguro.setBounds(210, 130, 86, 20);
		principal.add(txtCodSeguro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 113, 667, 215);
		listaSeguros.add(scrollPane);
		
		tablaSeguros = new JTable();
		tablaSeguros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarSeguros metodosSeguros = new ValidarSeguros();
					if (metodosSeguros.validar_seleccion_Seguro(tablaSeguros.getValueAt(tablaSeguros.getSelectedRow(), 0).toString()) == 1) {
						listaSeguros.setVisible(false);
						principal.setVisible(true);
						cmbTipoSeguro.setSelectedItem(metodosSeguros.getCmbTipoSeguro());
						txtCodSeguro.setEditable(false);

					}
				}

			}
		});
		tablaSeguros.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo Entidad", "Nombre", "Direcci\u00F3n", "Rif", "Telf", "Tipo"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tablaSeguros);
		
		JComboBox cmbBuscaSeguros = new JComboBox();
		cmbBuscaSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscaSeguros.requestFocus();
			}
		});
		cmbBuscaSeguros.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "C\u00F3digo", "Telef", "Tipo", "RIF"}));
		cmbBuscaSeguros.setBounds(276, 60, 80, 20);
		listaSeguros.add(cmbBuscaSeguros);
		
		JLabel lblNombreDelSeguro = new JLabel("Nombre del Seguro");
		lblNombreDelSeguro.setBounds(210, 174, 143, 14);
		principal.add(lblNombreDelSeguro);
		
		txtNombSeguro = new JTextField();
		txtNombSeguro.setColumns(10);
		txtNombSeguro.setBounds(210, 199, 305, 20);
		principal.add(txtNombSeguro);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setBounds(210, 230, 60, 14);
		principal.add(label_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(210, 255, 318, 20);
		principal.add(txtDireccion);
		
		JLabel label_5 = new JLabel("Rif");
		label_5.setBounds(210, 286, 46, 14);
		principal.add(label_5);
		
		txtRif = new JTextField();
		txtRif.setColumns(10);
		txtRif.setBounds(210, 305, 100, 20);
		principal.add(txtRif);
		
		JLabel label_6 = new JLabel("Tel\u00E9fono");
		label_6.setBounds(320, 286, 60, 14);
		principal.add(label_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(320, 305, 100, 20);
		principal.add(txtTelefono);
		
		JLabel lblTipoDeSeguro = new JLabel("Tipo de Seguro");
		lblTipoDeSeguro.setBounds(436, 286, 92, 14);
		principal.add(lblTipoDeSeguro);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_6.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/Button Previous_48.png")));
		button_6.setToolTipText("Volver a la pantalla Principal");
		button_6.setBounds(10, 11, 71, 57);
		principal.add(button_6);
		
		JButton btnListaDeSeguros = new JButton("Lista de Seguros");
		btnListaDeSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.setVisible(false);
				listaSeguros.setVisible(true);
				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Seguros(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);
				txtBuscaSeguros.requestFocus();
			}
		});
		btnListaDeSeguros.setBounds(375, 120, 198, 40);
		principal.add(btnListaDeSeguros);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(287, 41, 228, 27);
		principal.add(panel_1);
		
		JLabel lblDatosDeSeguros = new JLabel("DATOS DE SEGUROS");
		lblDatosDeSeguros.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		lblDatosDeSeguros.setBounds(38, 0, 160, 27);
		panel_1.add(lblDatosDeSeguros);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(txtCodSeguro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Código de Seguro obligatorio: vacío", "Error de Registro",
							JOptionPane.ERROR_MESSAGE);

				}else{
					ValidarSeguros metodosSeguros = new ValidarSeguros();
					if (metodosSeguros.validar_seleccion_Seguro(txtCodSeguro.getText()) == 1) {
						cmbTipoSeguro.setSelectedItem(metodosSeguros.getCmbTipoSeguro());
						txtCodSeguro.setEditable(false);
					}else{

						JOptionPane.showMessageDialog(null,
								"No existe seguro. Agréguela acontinuación",
								"Busqueda de seguro",
								JOptionPane.INFORMATION_MESSAGE);
						txtCodSeguro.requestFocus(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						txtDireccion.setText(null);
						txtNombSeguro.setText(null);
						txtRif.setText(null);
						txtTelefono.setText(null);

					}


				}

			
			}
		});
		button_2.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/toolbar_find.png")));
		button_2.setBounds(306, 123, 38, 34);
		principal.add(button_2);
		
		JLabel label = new JLabel("Buscar Seguro por: ");
		label.setBounds(164, 63, 102, 14);
		listaSeguros.add(label);
		
		txtBuscaSeguros = new JTextField();
		txtBuscaSeguros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();

					metodosbd.Buscar_Entidad(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);



				}
			}
		});
		txtBuscaSeguros.setColumns(10);
		txtBuscaSeguros.setBounds(366, 60, 217, 20);
		listaSeguros.add(txtBuscaSeguros);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				ValidarBusquedaPacientesSeguroEntidad metodosbd = new ValidarBusquedaPacientesSeguroEntidad();
				metodosbd.Buscar_Entidad(txtBuscaSeguros.getText(), cmbBuscaSeguros.getSelectedItem().toString(), tablaSeguros);

			}
		});
		button.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/search-47.png")));
		button.setBounds(668, 45, 131, 51);
		listaSeguros.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaSeguros.setVisible(false);
				principal.setVisible(true);
				
			}
		});
		button_1.setIcon(new ImageIcon(DatosSeguros.class.getResource("/images/Button Previous_48.png")));
		button_1.setToolTipText("Volver a la pantalla Datos de Seguros");
		button_1.setBounds(10, 13, 65, 57);
		listaSeguros.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(321, 11, 202, 27);
		listaSeguros.add(panel);
		
		JLabel label_1 = new JLabel("LISTA DE SEGUROS");
		label_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		label_1.setBounds(38, 0, 153, 27);
		panel.add(label_1);
			
	}
}
