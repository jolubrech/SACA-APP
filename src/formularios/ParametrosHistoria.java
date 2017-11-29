package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;

import conexionesDB.ValidarCedulaHistoria;
import generacion.ReemplazoVariable;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

public class ParametrosHistoria {

	private JFrame frmHistoriaMedica;
	private JTextField txtCedula;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	private JTextField txtEdad;
	private JTextField txtLugarNacimiento;
	private JTextField txtNacionalidad;
	private JTextField txtDireccion;
	private JTextField txtTelefonos;
	private JTextField txtCorreoElectronico;
	private JTextField txtGradoInstruccion;
	private JTextField txtOcupacion;
	private JTextField txtReferido;
	private JTextField txtICE;
	public String Numcedula = null;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ParametrosHistoria window = new ParametrosHistoria(Numcedula);
					window.frmHistoriaMedica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param cedula 
	 */
	public ParametrosHistoria(String cedula) {
		Numcedula = cedula;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {

		//Obtenci�n de ultimo numero de historia m�dica

		ValidarCedulaHistoria validar = new ValidarCedulaHistoria();
		validar.numHistoriaFinal();

		//Fin obtencion

		frmHistoriaMedica = new JFrame();
		frmHistoriaMedica.setTitle("Historia Medica");
		frmHistoriaMedica.setResizable(false);
		frmHistoriaMedica.setBounds(100, 100, 827, 681);
		frmHistoriaMedica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmHistoriaMedica.getContentPane().setLayout(null);
		frmHistoriaMedica.setLocationRelativeTo(null);
		Date fecha = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		formater.format(fecha);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 821, 652);
		frmHistoriaMedica.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Datos Personales", null, panel_1, null);
		panel_1.setLayout(null);

		JButton btnRegresar = new JButton("");
		btnRegresar.setBounds(25, 11, 71, 57);
		panel_1.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriaMedica.dispose();
			}
		});
		btnRegresar.setIcon(new ImageIcon(ParametrosHistoria.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Volver a la pantalla Principal");

		JPanel panel = new JPanel();
		panel.setBounds(213, 31, 351, 37);
		panel_1.add(panel);
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));

		JLabel lblParmetrosParaGeneracin = new JLabel("Par\u00E1metros para generaci\u00F3n de Historia M\u00E9dica");
		lblParmetrosParaGeneracin.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblParmetrosParaGeneracin);

		JLabel lblNhistoria = new JLabel("N\u00B0Historia:");
		lblNhistoria.setBounds(610, 14, 74, 14);
		panel_1.add(lblNhistoria);

		JFormattedTextField txtNumHistoria = new JFormattedTextField();
		txtNumHistoria.setBounds(680, 11, 73, 20);
		panel_1.add(txtNumHistoria);
		txtNumHistoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumHistoria.setValue("000"+validar.getNumHistoriaFinal());
		txtNumHistoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNumHistoria.setEditable(false);

		JPanel campos = new JPanel();
		campos.setBounds(25, 84, 499, 445);
		panel_1.add(campos);
		campos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "* Campos obligatorios.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		campos.setLayout(null);

		txtCedula = new JTextField();
		txtCedula.setBounds(23, 58, 86, 20);
		campos.add(txtCedula);
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setText(Numcedula);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(119, 58, 110, 20);
		campos.add(txtApellidos);
		txtApellidos.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setBounds(254, 58, 119, 20);
		campos.add(txtNombres);
		txtNombres.setColumns(10);

		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setBounds(390, 58, 99, 20);
		campos.add(cmbSexo);
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(319, 97, 86, 14);
		campos.add(lblNacionalidad);

		txtTelefonos = new JTextField();
		txtTelefonos.setBounds(28, 239, 154, 20);
		campos.add(txtTelefonos);
		txtTelefonos.setColumns(10);

		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBounds(212, 239, 161, 20);
		campos.add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);

		txtReferido = new JTextField();
		txtReferido.setBounds(23, 351, 396, 20);
		campos.add(txtReferido);
		txtReferido.setColumns(10);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(23, 33, 46, 14);
		campos.add(lblCdula);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(119, 33, 65, 14);
		campos.add(lblApellidos);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(256, 33, 73, 14);
		campos.add(lblNombres);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(390, 33, 46, 14);
		campos.add(lblSexo);

		JXDatePicker datePickerFecha = new JXDatePicker();
		datePickerFecha.setBounds(10, 120, 86, 22);
		campos.add(datePickerFecha);
		datePickerFecha.setDate(fecha);


		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 97, 46, 14);
		campos.add(lblFecha);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(118, 97, 46, 14);
		campos.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(119, 121, 59, 20);
		campos.add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblLugarDeNacimiento = new JLabel("Lugar de nacimiento:");
		lblLugarDeNacimiento.setBounds(192, 97, 131, 14);
		campos.add(lblLugarDeNacimiento);

		txtLugarNacimiento = new JTextField();
		txtLugarNacimiento.setBounds(185, 121, 119, 20);
		campos.add(txtLugarNacimiento);
		txtLugarNacimiento.setColumns(10);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(319, 122, 110, 20);
		campos.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(23, 164, 80, 14);
		campos.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(23, 189, 446, 20);
		campos.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelfonos = new JLabel("Tel\u00E9fonos:");
		lblTelfonos.setBounds(29, 220, 80, 14);
		campos.add(lblTelfonos);

		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setBounds(208, 220, 131, 14);
		campos.add(lblCorreoElectronico);

		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(29, 278, 80, 14);
		campos.add(lblEstadoCivil);

		JLabel lblGradoDeInstruccin = new JLabel("Grado de instrucci\u00F3n:");
		lblGradoDeInstruccin.setBounds(119, 278, 130, 14);
		campos.add(lblGradoDeInstruccin);

		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setBounds(283, 278, 110, 14);
		campos.add(lblOcupacin);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Diagnostico", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel Textos = new JPanel();
		Textos.setBounds(33, 59, 773, 397);
		panel_2.add(Textos);
		Textos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Textos.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 44, 713, 86);
		Textos.add(scrollPane);

		JTextArea txtHistoriaMedica = new JTextArea();
		txtHistoriaMedica.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtHistoriaMedica);

		JComboBox cmbEdoCivil = new JComboBox();
		cmbEdoCivil.setBounds(20, 303, 89, 20);
		campos.add(cmbEdoCivil);
		cmbEdoCivil.setModel(new DefaultComboBoxModel(new String[] {"Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)"}));

		txtGradoInstruccion = new JTextField();
		txtGradoInstruccion.setBounds(119, 303, 154, 20);
		campos.add(txtGradoInstruccion);
		txtGradoInstruccion.setColumns(10);

		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(283, 303, 131, 20);
		campos.add(txtOcupacion);
		txtOcupacion.setColumns(10);
		
		JLabel lblParaclnicos = new JLabel("Paracl\u00EDnicos:");
		lblParaclnicos.setBounds(26, 256, 83, 14);
		Textos.add(lblParaclnicos);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(38, 270, 706, 86);
		Textos.add(scrollPane_2);

		JTextArea txtParaclinicos = new JTextArea();
		scrollPane_2.setViewportView(txtParaclinicos);

		JLabel lblHistoriaMdica = new JLabel("Motivo de consulta:");
		lblHistoriaMdica.setBounds(26, 26, 108, 14);
		Textos.add(lblHistoriaMdica);

		JLabel lblEvolucin = new JLabel("Evoluci\u00F3n:");
		lblEvolucin.setBounds(26, 141, 95, 14);
		Textos.add(lblEvolucin);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 160, 708, 86);
		Textos.add(scrollPane_1);

		JTextArea txtEvolucion = new JTextArea();
		scrollPane_1.setViewportView(txtEvolucion);

		JLabel lblReferidoPor = new JLabel("Referido por:");
		lblReferidoPor.setBounds(21, 334, 88, 14);
		campos.add(lblReferidoPor);

		JLabel lblAvisarEnCaso = new JLabel("Avisar en caso de Emergencia:");
		lblAvisarEnCaso.setBounds(23, 387, 197, 14);
		campos.add(lblAvisarEnCaso);

		txtICE = new JTextField();
		txtICE.setBounds(23, 412, 238, 20);
		campos.add(txtICE);
		txtICE.setColumns(10);

		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setBounds(283, 387, 99, 14);
		campos.add(lblParentesco);

		JComboBox cmbParentesco = new JComboBox();
		cmbParentesco.setBounds(283, 412, 99, 20);
		campos.add(cmbParentesco);
		cmbParentesco.setModel(new DefaultComboBoxModel(new String[] {"Familiar", "C\u00F3nyuge", "Otro.."}));

		JButton btnGenerarHistoria = new JButton("Generar Historia");
		btnGenerarHistoria.setBounds(569, 497, 209, 78);
		panel_1.add(btnGenerarHistoria);
		btnGenerarHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ReemplazoVariable geneararHistorias = new ReemplazoVariable();
				try {

					if(txtCedula.getText().isEmpty()||
							txtCedula.getText().isEmpty()||
							txtApellidos.getText().isEmpty()||
							txtNombres.getText().isEmpty()||
							cmbSexo.getSelectedItem().toString().isEmpty()||
							txtEdad.getText().isEmpty()||
							txtLugarNacimiento.getText().isEmpty()||
							txtNacionalidad.getText().isEmpty()||
							txtDireccion.getText().isEmpty()||
							txtTelefonos.getText().isEmpty()||
							txtCorreoElectronico.getText().isEmpty()||
							cmbEdoCivil.getSelectedObjects().toString().isEmpty()||
							txtGradoInstruccion.getText().isEmpty()||
							txtOcupacion.getText().isEmpty()||
							txtReferido.getText().isEmpty()||
							txtICE.getText().isEmpty()||
							cmbParentesco.getSelectedObjects().toString().isEmpty()||
							txtHistoriaMedica.getText().isEmpty()||
							txtEvolucion.getText().isEmpty()||
							txtParaclinicos.getText().isEmpty()){

						JOptionPane.showMessageDialog(null, "Imposible generar Historia con campos vac�os"
								, "Error en el Registro", 
								JOptionPane.ERROR_MESSAGE);

					}else{
						SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
						geneararHistorias.generacionHistoria(txtCedula.getText(), txtApellidos.getText(),
								txtNombres.getText(), cmbSexo.getSelectedItem().toString(), 
								formater.format(datePickerFecha.getDate()),txtEdad.getText(), txtLugarNacimiento.getText(),
								txtNacionalidad.getText(), txtDireccion.getText(), txtTelefonos.getText(), 
								txtCorreoElectronico.getText(), cmbEdoCivil.getSelectedItem().toString(),
								txtGradoInstruccion.getText(), txtOcupacion.getText(), txtReferido.getText(), 
								txtICE.getText(), cmbParentesco.getSelectedItem().toString(), txtHistoriaMedica.getText(),
								txtEvolucion.getText(), txtParaclinicos.getText(), txtNumHistoria.getValue());
						ValidarCedulaHistoria validar = new ValidarCedulaHistoria();
						if(validar.registrarHistoria(txtCedula.getText(), txtNumHistoria.getText())==1){

						}
						frmHistoriaMedica.dispose();
					}





				} catch (URISyntaxException e) {

					e.printStackTrace();
				}
			}
		});
		btnGenerarHistoria.setIcon(new ImageIcon(ParametrosHistoria.class.getResource("/images/Generate-tables.png")));

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(238, 540, 154, 57);
		panel_1.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtCedula.setText(null);
				txtCedula.requestFocus(true);
				txtApellidos.setText(null);
				txtNombres.setText(null);
				cmbSexo.setSelectedIndex(0);
				Date fecha = new Date();
				datePickerFecha.setDate(fecha);
				txtEdad.setText(null);
				txtLugarNacimiento.setText(null);
				txtNacionalidad.setText(null);
				txtDireccion.setText(null);
				txtTelefonos.setText(null);
				txtCorreoElectronico.setText(null);
				cmbEdoCivil.setSelectedIndex(0);
				txtGradoInstruccion.setText(null);
				txtOcupacion.setText(null);
				txtReferido.setText(null);
				txtICE.setText(null);
				cmbParentesco.setSelectedIndex(0);
				txtHistoriaMedica.setText(null);
				txtEvolucion.setText(null);
				txtParaclinicos.setText(null);

			}
		});
		btnLimpiar.setIcon(new ImageIcon(ParametrosHistoria.class.getResource("/images/Gnome-Edit-Clear-48.png")));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_3.setBounds(248, 11, 351, 37);
		panel_2.add(panel_3);

		JLabel label = new JLabel("Par\u00E1metros para generaci\u00F3n de Historia M\u00E9dica");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(label);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Estudios", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_5.setBounds(214, 11, 351, 37);
		panel_4.add(panel_5);

		JLabel lblImagenes = new JLabel("Imagenes");
		lblImagenes.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblImagenes);

	}
}
