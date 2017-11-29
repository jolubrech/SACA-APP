package formularios;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import conexionesDB.ValidarCedulaHistoria;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BusquedaHistoria {

	private JFrame frmBusqHistoriaCedula;
	public JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaHistoria window = new BusquedaHistoria();
					window.frmBusqHistoriaCedula.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BusquedaHistoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ })
	private void initialize() {


		frmBusqHistoriaCedula = new JFrame();
		frmBusqHistoriaCedula.setTitle("Generaci\u00F3n historias m\u00E9dicas");
		frmBusqHistoriaCedula.setBounds(100, 100, 305, 241);
		frmBusqHistoriaCedula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBusqHistoriaCedula.getContentPane().setLayout(null);
		frmBusqHistoriaCedula.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(96, 62, 142, 129);
		frmBusqHistoriaCedula.getContentPane().add(panel);

		txtCedula = new JTextField();
		txtCedula.setBounds(29, 42, 86, 20);
		txtCedula.requestFocus();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ValidarCedulaHistoria validacion = new ValidarCedulaHistoria();
					if(validacion.esStringAlfa(txtCedula.getText())==false){
						JOptionPane.showMessageDialog(null, "El campo cédula es sólo numérico y no puede ser nulo", 
								"Error en búsqueda", JOptionPane.ERROR_MESSAGE);

					}else{
						
						if(validacion.busquedaCedula(txtCedula.getText())==1){
							//ABOSLUTE PATH
							CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
							File jarFile = null;
							
								try {
									jarFile = new File(codeSource.getLocation().toURI().getPath());
								} catch (URISyntaxException e2) {

									e2.printStackTrace();
								}
							
							String jarDir = jarFile.getParentFile().getPath();
							String folderPath = jarDir + "\\documentos\\generados\\Historias";
							//	*NOTE: Creating Folder if it does not exist*/
								File f1 = new File(folderPath);
								f1.mkdir();


							if (JOptionPane.showConfirmDialog(null,"La cédula: "+validacion.getCedulaPaciente()+" tiene la historia: "
							+validacion.getNumHistoria()+"\n ¿Desea abrirla?") == JOptionPane.YES_OPTION) {
								//OPCION AFIRMATIVA
								String direccion = folderPath + "/Historia-000"+validacion.getNumHistoria()+".doc";
								if (Desktop.isDesktopSupported()) {

									try {
										
										if((new File(direccion).exists())){
											Desktop.getDesktop().open(new File(direccion));
											frmBusqHistoriaCedula.dispose();
										}else{
											if(JOptionPane.showConfirmDialog(null, "No existe la Historia\n El archivo fue eliminado\n ¿Deseas generar una Historia nueva?") == JOptionPane.YES_OPTION){
												//OPCION AFIRMATIVA
												ValidarCedulaHistoria validar = new ValidarCedulaHistoria();
												validar.eliminarHistoria(txtCedula.getText());
												ParametrosHistoria gui = new ParametrosHistoria(txtCedula.getText());
												gui.main();
												frmBusqHistoriaCedula.dispose();
											}else{
												//OPCION NEGATIVA
												
											}
											
										}


									} catch (IOException e1) {
										
										JOptionPane.showInputDialog(null, "El archivo no fue encontrado, posiblemente eliminado",e1);
										//														e1.printStackTrace();
									}




								}
							}else{
								//OPCION NEGATIVA

							}



						}else{


							if (JOptionPane.showConfirmDialog(null,"El paciente no tiene historia\n ¿Desea generar una?","Generación historia", 0 ) == JOptionPane.YES_OPTION) {
								//OPCION AFIRMATIVA
								frmBusqHistoriaCedula.dispose();
								ParametrosHistoria gui = new ParametrosHistoria(txtCedula.getText());
								gui.main();

							}else{
								//OPCION NEGATIVA

							}

						}


					}


				}
}
		});
		panel.setLayout(null);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBusqHistoriaCedula.dispose();
			}
		});
		btnRegresar.setIcon(new ImageIcon(BusquedaHistoria.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Regresar a la pantalla Principal");
		btnRegresar.setBounds(10, 4, 54, 57);
		frmBusqHistoriaCedula.getContentPane().add(btnRegresar);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(52, 21, 52, 14);
		panel.add(lblCdula);

		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(39, 77, 65, 41);
		btnBuscar.setIcon(new ImageIcon(BusquedaHistoria.class.getResource("/images/toolbar_find.png")));
		panel.add(btnBuscar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(96, 21, 142, 30);
		frmBusqHistoriaCedula.getContentPane().add(panel_1);

		JLabel lblHistoriasMdicas = new JLabel("Historias M\u00E9dicas");
		panel_1.add(lblHistoriasMdicas);
		lblHistoriasMdicas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarCedulaHistoria validacion = new ValidarCedulaHistoria();
				if(validacion.esStringAlfa(txtCedula.getText())==false){
					JOptionPane.showMessageDialog(null, "El campo cédula es únicamente numérico y no puede ser nulo", 
							"Error en búsqueda", JOptionPane.ERROR_MESSAGE);

				}else{
					
					if(validacion.busquedaCedula(txtCedula.getText())==1){

						if (JOptionPane.showConfirmDialog(null,"La cédula: "+validacion.getCedulaPaciente()+" tiene la historia: "+validacion.getNumHistoria()+"\n ¿Desea abrirla?") == JOptionPane.YES_OPTION) {
							//OPCION AFIRMATIVA
							String direccion = System.getProperty("user.dir")+ "/documentos/generados/Historias/Historia-000"+validacion.getNumHistoria()+".doc";
							if (Desktop.isDesktopSupported()) {

								try {
									
									if((new File(direccion).exists())){
										Desktop.getDesktop().open(new File(direccion));
										frmBusqHistoriaCedula.dispose();
									}else{
										if(JOptionPane.showConfirmDialog(null, "No existe la Historia\n El archivo fue eliminado\n ¿Deseas generar una Historia nueva?") == JOptionPane.YES_OPTION){
											//OPCION AFIRMATIVA
											ValidarCedulaHistoria validar = new ValidarCedulaHistoria();
											validar.eliminarHistoria(txtCedula.getText());
											ParametrosHistoria gui = new ParametrosHistoria(txtCedula.getText());
											gui.main();
											frmBusqHistoriaCedula.dispose();
										}else{
											//OPCION NEGATIVA
											
										}
										
									}


								} catch (IOException e1) {

									JOptionPane.showInputDialog(null, "El archivo no fue encontrado, posiblemente eliminado",e1);
									//														e1.printStackTrace();
								}




							}
						}else{
							//OPCION NEGATIVA

						}



					}else{


						if (JOptionPane.showConfirmDialog(null,"El paciente no tiene historia\n ¿Desea generar una?","Generación historia", 0 ) == JOptionPane.YES_OPTION) {
							//OPCION AFIRMATIVA
							frmBusqHistoriaCedula.dispose();
							ParametrosHistoria gui = new ParametrosHistoria(txtCedula.getText());
							gui.main();

						}else{
							//OPCION NEGATIVA

						}

					}


				}


			}
		});





	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}
	
	
}
