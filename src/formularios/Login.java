package formularios;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import conexionesDB.ValidarLogin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Login {
	public String nivel_acceso;
	private JFrame frmInicioDeSesion;
	public static JPasswordField txtPassword;
	public static JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login window = new Login();
					window.frmInicioDeSesion.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesion = new JFrame();
		frmInicioDeSesion.setResizable(false);
		frmInicioDeSesion.getContentPane().setForeground(Color.GRAY);
		frmInicioDeSesion.setTitle("Inicio de sesion");
		frmInicioDeSesion.setBounds(100, 100, 546, 384);
		frmInicioDeSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesion.getContentPane().setLayout(null);
		frmInicioDeSesion.setLocationRelativeTo(null);
		
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				

				
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					ValidarLogin metodoslogin = new ValidarLogin();

					if(metodoslogin.validar_ingreso()==1){
		                 
				        

		        JOptionPane.showMessageDialog(null, "Bienvenido(a): "+metodoslogin.getNivel_acceso().toString()+" "+txtUsuario.getText()+"\n Has ingresado "
		        + "satisfactoriamente al sistema", "Mensaje de bienvenida",
		        JOptionPane.INFORMATION_MESSAGE);
		        
		        nivel_acceso =  metodoslogin.getNivel_acceso();
		        	Principal gui = new Principal(nivel_acceso);          
			        gui.main(nivel_acceso);
			        
			        frmInicioDeSesion.dispose();
		        

		       

		}else {
					                    
					        JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
					        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
					        JOptionPane.ERROR_MESSAGE);
					            
					}
					
				}
				
			}
		});
		txtPassword.setBounds(316, 164, 134, 31);
		frmInicioDeSesion.getContentPane().add(txtPassword);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(316, 69, 76, 14);
		frmInicioDeSesion.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setBounds(316, 139, 95, 14);
		frmInicioDeSesion.getContentPane().add(lblContrasea);
		
		JButton btnIngresar = new JButton("INGRESAR");
		
		
		btnIngresar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				ValidarLogin metodoslogin = new ValidarLogin();

				if(metodoslogin.validar_ingreso()==1){
				                 
				        

				        JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
				        + "satisfactoriamente al sistema", "Mensaje de bienvenida",
				        JOptionPane.INFORMATION_MESSAGE);
				        
				        nivel_acceso =  metodoslogin.getNivel_acceso();
				        	Principal gui = new Principal(nivel_acceso);          
					        gui.main(nivel_acceso);
					        
					        frmInicioDeSesion.dispose();
				        

				       

				}else {
				                    
				        JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
				        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
				        JOptionPane.ERROR_MESSAGE);
				            
				}
			}
		});
		btnIngresar.setBounds(316, 210, 134, 49);
		frmInicioDeSesion.getContentPane().add(btnIngresar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(316, 94, 134, 31);
		frmInicioDeSesion.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/login-icon.png")));
		label.setBounds(10, 19, 296, 309);
		frmInicioDeSesion.getContentPane().add(label);
		
		
	}

	
}
