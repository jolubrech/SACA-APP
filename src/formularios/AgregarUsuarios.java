package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import conexionesDB.ValidarLogin;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AgregarUsuarios {

	private JFrame frmCreacinDeUsuarios;
	private JTextField txtUsuario;
	private JPasswordField password;
	private JPasswordField passwordConfirma;

	/**
	 * Launch the application.
	 * @return 
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUsuarios window = new AgregarUsuarios();
					window.frmCreacinDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmCreacinDeUsuarios = new JFrame();
		frmCreacinDeUsuarios.setResizable(false);
		frmCreacinDeUsuarios.setTitle("Creaci\u00F3n de usuarios");
		frmCreacinDeUsuarios.setBounds(100, 100, 435, 336);
		frmCreacinDeUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreacinDeUsuarios.getContentPane().setLayout(null);
		frmCreacinDeUsuarios.setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(77, 93, 56, 14);
		frmCreacinDeUsuarios.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 111, 117, 20);
		frmCreacinDeUsuarios.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(221, 93, 74, 14);
		frmCreacinDeUsuarios.getContentPane().add(lblContrasea);
		
		password = new JPasswordField();
		password.setBounds(221, 111, 117, 20);
		frmCreacinDeUsuarios.getContentPane().add(password);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarContrasea.setBounds(221, 142, 130, 14);
		frmCreacinDeUsuarios.getContentPane().add(lblConfirmarContrasea);
		
		passwordConfirma = new JPasswordField();
		passwordConfirma.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				if(password.getText().equalsIgnoreCase(passwordConfirma.getText())){
					
				}else{
					JOptionPane.showMessageDialog(null, "Las confirmación de contraseña no coincide", null, JOptionPane.ERROR_MESSAGE, null);
					passwordConfirma.setText(null);
				}
			}
		});
		passwordConfirma.setBounds(221, 167, 117, 20);
		frmCreacinDeUsuarios.getContentPane().add(passwordConfirma);
		
		JLabel lblNivelDeAcceso = new JLabel("Nivel de acceso:");
		lblNivelDeAcceso.setBounds(77, 170, 114, 14);
		frmCreacinDeUsuarios.getContentPane().add(lblNivelDeAcceso);
		
		JComboBox cmbNivelAcceso = new JComboBox();
		cmbNivelAcceso.setModel(new DefaultComboBoxModel(new String[] {"M\u00E9dico", "Secretaria", "Administrador", "Prueba"}));
		cmbNivelAcceso.setBounds(77, 187, 90, 20);
		frmCreacinDeUsuarios.getContentPane().add(cmbNivelAcceso);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(110, 26, 213, 31);
		frmCreacinDeUsuarios.getContentPane().add(panel);
		
		JLabel lblCreacinDeUsuarios = new JLabel("Creaci\u00F3n de Usuarios");
		lblCreacinDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCreacinDeUsuarios);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(AgregarUsuarios.class.getResource("/images/add-user-48.png")));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (JOptionPane.showConfirmDialog(null,"¿Quieres registrar al usuario "+txtUsuario.getText()+"?","Registro paciente",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					//OPCION AFIRMATIVA
					ValidarLogin login = new ValidarLogin();
					if(login.crear_usuarios(txtUsuario.getText(),String.valueOf(passwordConfirma.getPassword()), cmbNivelAcceso.getSelectedItem())==1){
						JOptionPane.showMessageDialog(null, "¡Operación exitosa!\n Usuario creado.",null, JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					//OPCION NEGATIVA
					JOptionPane.showMessageDialog(null, "¡Operación cancelada!",null, JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
			}
		});
		btnCrear.setBounds(155, 218, 140, 56);
		frmCreacinDeUsuarios.getContentPane().add(btnCrear);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCreacinDeUsuarios.dispose();
			}
		});
		button.setIcon(new ImageIcon(AgregarUsuarios.class.getResource("/images/Button Previous_48.png")));
		button.setToolTipText("Regresar a la pantalla Principal");
		button.setBounds(10, 11, 54, 57);
		frmCreacinDeUsuarios.getContentPane().add(button);
	}
}
