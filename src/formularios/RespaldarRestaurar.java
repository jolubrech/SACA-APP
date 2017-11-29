package formularios;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class RespaldarRestaurar {

	private JFrame frmRespaldarRestaurar;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespaldarRestaurar window = new RespaldarRestaurar();
					window.frmRespaldarRestaurar.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RespaldarRestaurar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	private void initialize() {
		/*NOTE: Getting path to the Jar file being executed*/
		/*NOTE: YourImplementingClass-> replace with the class executing the code*/
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();

		try {
			File jarFile;
			jarFile = new File(codeSource.getLocation().toURI().getPath());
			String jarDir = jarFile.getParentFile().getPath();
			/*NOTE: Creating Path Constraints for folder saving*/
			/*NOTE: Here the backup folder is created for saving inside it*/
			String folderPath = jarDir + "\\backup";


			/*NOTE: Creating Folder if it does not exist*/
			File f1 = new File(folderPath);
			f1.mkdir();
		} catch (URISyntaxException e1) {

			e1.printStackTrace();
		}


		frmRespaldarRestaurar = new JFrame();
		frmRespaldarRestaurar.setTitle("Reporte Facturaci\u00F3n por Fechas");
		frmRespaldarRestaurar.setBounds(100, 100, 433, 302);
		frmRespaldarRestaurar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRespaldarRestaurar.getContentPane().setLayout(null);
		frmRespaldarRestaurar.setLocationRelativeTo(null);

		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRespaldarRestaurar.dispose();
			}
		});
		btnRegresar.setIcon(new ImageIcon(RespaldarRestaurar.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Regresar a la pantalla Principal");
		btnRegresar.setBounds(10, 4, 54, 57);
		frmRespaldarRestaurar.getContentPane().add(btnRegresar);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(20, 124, 387, 114);
		frmRespaldarRestaurar.getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(211, 59, 166, 20);
		panel.add(comboBox);

		JButton btnRespaldar = new JButton("Respaldar");
		btnRespaldar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespaldar.setIcon(new ImageIcon(RespaldarRestaurar.class.getResource("/images/wordpress-backup.png")));
		btnRespaldar.addActionListener(new ActionListener() {
			@SuppressWarnings({ })
			public void actionPerformed(ActionEvent arg0) {


				if (JOptionPane.showConfirmDialog(null,"¿Desea respaldar la base de datos? ", "Eliminar datos",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
					//CASO AFIRMATIVO

					try {

						/*NOTE: Getting path to the Jar file being executed*/
						/*NOTE: YourImplementingClass-> replace with the class executing the code*/
						CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
						File jarFile = new File(codeSource.getLocation().toURI().getPath());
						String jarDir = jarFile.getParentFile().getPath();


						/*NOTE: Creating Database Constraints*/
						String dbName = "db_sac";
						String dbUser = "root";
						String dbPass = "root";
						String localhost = "localhost";

						/*NOTE: Creating Path Constraints for folder saving*/
						/*NOTE: Here the backup folder is created for saving inside it*/
						String folderPath = jarDir + "\\backup";


						/*NOTE: Creating Folder if it does not exist*/
						File f1 = new File(folderPath);
						f1.mkdir();

						/*NOTE: Creating Path Constraints for backup saving*/
						/*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
						//Formateo Fecha
						DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
						Date date = new Date();
						dateFormat.format(date);
						String savePath = "\"" + jarDir + "\\backup\\" + " "+dateFormat.format(date)+".sql\"";


						/*NOTE: Used to create a cmd command*/

						String executeCmd = "C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump -u" + dbUser + " -p" + dbPass + " -h" +localhost +" "+ dbName + " -r " + savePath;


						/*NOTE: Executing the command here*/
						Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
						int processComplete = runtimeProcess.waitFor();

						/*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
						if (processComplete == 0) {
							JOptionPane.showMessageDialog(null, "Respaldo generado satisfactoriamente : "+dateFormat.format(date)+".sql\"");
							File file = new File(System.getProperty("user.dir")+ "/backup/");
							File[] files = file.listFiles();
							for (int i = 0; i < files.length; i++) {

								comboBox.addItem(files[i].getName());

							}


						} else {
							JOptionPane.showMessageDialog(null, "Error en respaldo");
						}

					} catch (URISyntaxException | IOException | InterruptedException ex) {
						JOptionPane.showMessageDialog(null, "Error en Respaldo" + ex.getMessage());
					}


				}else{
					//CASO NEGATIVO
					JOptionPane.showMessageDialog(null,
							"Operación cancelada\n"
									+ "No se realizó el respaldo",
									"Error en la operación", JOptionPane.WARNING_MESSAGE);
				}


			}
		});
		btnRespaldar.setBounds(142, 42, 147, 68);
		frmRespaldarRestaurar.getContentPane().add(btnRespaldar);



		JLabel lblSeleccioneArchivoDe = new JLabel("Seleccione archivo de la Base de  Datos que desea restaurar: ");
		lblSeleccioneArchivoDe.setBounds(44, 11, 333, 20);
		panel.add(lblSeleccioneArchivoDe);

		JButton btnRestaurar = new JButton("Restaurar");
		btnRestaurar.setBounds(54, 35, 147, 68);
		panel.add(btnRestaurar);
		btnRestaurar.setIcon(new ImageIcon(RespaldarRestaurar.class.getResource("/images/icon_restore.png")));


		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = comboBox.getSelectedItem().toString();
				if (JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer restaurar la base de datos?\n "
						+ "La misma será sobreescrita por la versión seleccionada: "+s,"Restauración Base de Datos",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					//OPCION AFIRMATIVA

					try {
						/*NOTE: String s is the mysql file name including the .sql in its name*/
						/*NOTE: Getting path to the Jar file being executed*/
						/*NOTE: YourImplementingClass-> replace with the class executing the code*/
						CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
						File jarFile = new File(codeSource.getLocation().toURI().getPath());
						String jarDir = jarFile.getParentFile().getPath();

						/*NOTE: Creating Database Constraints*/
						String dbName = "db_sac";
						String dbUser = "root";
						String dbPass = "root";


						/*NOTE: Creating Path Constraints for restoring*/
						String restorePath = jarDir + "\\backup" + "\\" + s;

						/*NOTE: Used to create a cmd command*/
						/*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
						String[] executeCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};
						//String executeCmd = "C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump -u" + dbUser + " -p" + dbPass + " -h" +localhost +" "+ dbName + " -r " + savePath;
						/*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
						Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
						int processComplete = runtimeProcess.waitFor();

						/*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
						if (processComplete == 0) {
							JOptionPane.showMessageDialog(null, "Restaurado exitosamente del SQL : " + s);
						} else {
							JOptionPane.showMessageDialog(null, "Error restaurando");
						}


					} catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
						JOptionPane.showMessageDialog(null, "Error restaurando" + ex.getMessage());
					}
				}else{
					//OPCION NEGATIVA

					JOptionPane.showMessageDialog(null,
							"Operación cancelada\n"
									+ "La restauración fue cancelada",
									"Error en la operación", JOptionPane.WARNING_MESSAGE);

				}


			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(108, 11, 233, 28);
		frmRespaldarRestaurar.getContentPane().add(panel_1);

		JLabel lblCdigoDeLa = new JLabel("Seleccione una tarea a realizar:");
		panel_1.add(lblCdigoDeLa);
		File file = new File(System.getProperty("user.dir")+ "/backup/");
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {

			comboBox.addItem(files[i].getName());

		}




	}
}
