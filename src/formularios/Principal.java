package formularios;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXImageView;

import conexionesDB.Pool;
import conexionesDB.ValidarBusquedaPacientesSeguroEntidad;
import conexionesDB.ValidarCedulaHistoria;
import generacion.ReemplazoVariable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.UIManager;
import java.awt.Toolkit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.Window.Type;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


@SuppressWarnings({ "serial", "unused" })
public class Principal extends JFrame{
	public JMenu mnMantenimiento;
	JFrame frame;
	
	

	/**
	 * Launch the application.
	 */
	public void main( String nivel_acceso) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal(nivel_acceso);
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
	public Principal(String nivel_acceso) {
		initialize(nivel_acceso);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nivel_acceso) {
		
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 612, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Principal.class.getResource("/images/131428.jpg")));
		label.setBounds(0, 0, 606, 424);
		frame.getContentPane().add(label);
		frame.requestFocusInWindow();
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(Principal.class.getResource("/images/mainwindow-files-ignored.png")));
		menuBar.add(mnArchivo);
		JMenu mnConsultar = new JMenu("Consultar");
		mnConsultar.setIcon(new ImageIcon(Principal.class.getResource("/images/pdf-icon-winnipeg-insurance.gif")));
		menuBar.add(mnConsultar);
		
		
		JMenu mnDatosEntidades = new JMenu("Datos Entidades");
		mnDatosEntidades.setIcon(new ImageIcon(Principal.class.getResource("/images/plus.jpg")));
		menuBar.add(mnDatosEntidades);
		
		JMenuItem mntmEntidades = new JMenuItem("Entidades");
		mntmEntidades.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmEntidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatosEntidades gui = new DatosEntidades();
				gui.main();
			
			}
		});
		mnDatosEntidades.add(mntmEntidades);
		
		JMenuItem mntmSeguros = new JMenuItem("Seguros");
		mntmSeguros.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmSeguros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatosSeguros gui = new DatosSeguros();
				gui.main();
			}
		});
		mnDatosEntidades.add(mntmSeguros);
		
		JMenuItem mntmReporte = new JMenuItem("Reporte F. General");
		mntmReporte.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmReporte.addActionListener(new ActionListener() {
			

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("rawtypes") 
				HashMap parametros;
				
				Connection conect = null;
				
				
				//Parametros 
				
				
				try {
					Pool Bd = new Pool();
					String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneral.jasper";
					//InputStream direccion = getClass().getResourceAsStream("/reportes/reporteGeneral.jasper");
					parametros = new HashMap<String, Object>();
					JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
					JasperViewer.viewReport(informe, false);
					
				} catch (JRException | SQLException e) {
					
					e.printStackTrace();
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
		});
		mnConsultar.add(mntmReporte);
		
		JMenuItem mntmControlFacturas = new JMenuItem("Control Facturas");
		mntmControlFacturas.setIcon(new ImageIcon(Principal.class.getResource("/images/file.jpg")));
		mntmControlFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				ControlFacturas gui = 	new ControlFacturas();
				gui.main();
			}
		});
		mnArchivo.add(mntmControlFacturas);
		
		JMenuItem mntmReportePorFechas = new JMenuItem("Reporte por Fechas");
		mntmReportePorFechas.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmReportePorFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteEntidadFechas gui = new ReporteEntidadFechas();
				gui.main();
				
			}
		});
		mnConsultar.add(mntmReportePorFechas);
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/images/1084346.gif")));
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmBackup = new JMenuItem("Respaldar/Restaurar");
		mntmBackup.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.png")));
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RespaldarRestaurar gui = new RespaldarRestaurar();
				gui.main();
			}
		});
		mnMantenimiento.add(mntmBackup);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setIcon(new ImageIcon(Principal.class.getResource("/images/1084396.gif")));
		mnMantenimiento.add(mnUsuario);
		
		JMenuItem mntmCrearUsuarios = new JMenuItem("Crear usuarios");
		mntmCrearUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmCrearUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUsuarios gui = new AgregarUsuarios();
				gui.main();
			}
		});
		mnUsuario.add(mntmCrearUsuarios);
		
		
		JMenuItem mntmReporteFGeneral = new JMenuItem("Reporte F. por Entidad Pendiente");
		mntmReporteFGeneral.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmReporteFGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReporteEntidadPendiente gui = new ReporteEntidadPendiente();          
		        gui.main();
		        
				
				
				
			}
		});
		mnConsultar.add(mntmReporteFGeneral);
		
		JMenuItem mntmReporteFEntidad = new JMenuItem("Reporte F. por Entidad Cancelada");
		mntmReporteFEntidad.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmReporteFEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReporteEntidadCancelada gui = new ReporteEntidadCancelada();          
		        gui.main();
		        
				
				
				
			}
		});
		mnConsultar.add(mntmReporteFEntidad);
		
		JMenuItem mntmFacturacin = new JMenuItem("Facturaci\u00F3n");
		mntmFacturacin.setIcon(new ImageIcon(Principal.class.getResource("/images/r_1.gif")));
		mntmFacturacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Facturacion gui = new Facturacion();
				gui.main();
			}
		});
		mnArchivo.add(mntmFacturacin);
		
		
		
		JMenu mnConstancias = new JMenu("Constancias");
		mnConstancias.setIcon(new ImageIcon(Principal.class.getResource("/images/word.png")));
		mnArchivo.add(mnConstancias);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Reposo M\u00E9dico");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReemplazoVariable generacion = new ReemplazoVariable();
				try {
					generacion.generacionReposo();
				} catch (URISyntaxException e) {
					
					e.printStackTrace();
				}
			}
		});
		mnConstancias.add(mntmNewMenuItem_2);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Informe M\u00E9dico");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReemplazoVariable generacion = new ReemplazoVariable();
				try {
					try {
						generacion.generacionInforme();
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (InvalidFormatException e) {
						
						e.printStackTrace();
					}
				} catch (URISyntaxException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		mnConstancias.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Recipes");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReemplazoVariable generacion = new ReemplazoVariable();
				try {
					generacion.generacionRecipe();
				} catch (URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		mnConstancias.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Constancia M\u00E9dica");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				ReemplazoVariable generacion = new ReemplazoVariable();
				try {
					generacion.generacionConstancia();
				} catch (URISyntaxException e) {
					
					e.printStackTrace();
				}
			/*VariableReplace reemplazo = new VariableReplace();
			try {
				reemplazo.generacion();
			} catch (Exception e) {
				
				e.printStackTrace();
			}*/
			
				
			
				
			}
		});
		mnConstancias.add(mntmNewMenuItem_1);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/exit-small-icon.gif")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login gui = new Login();
				gui.main(null);
			}
		});
		mntmCerrarSesin.setIcon(new ImageIcon(Principal.class.getResource("/images/icon-sign-in2 (2).gif")));
		mnArchivo.add(mntmCerrarSesin);
		mnArchivo.add(mntmSalir);
		
		
		
		JMenuItem mntmHistoriaMdica = new JMenuItem("Historia M\u00E9dica");
		mntmHistoriaMdica.setIcon(new ImageIcon(Principal.class.getResource("/images/arrow.gif")));
		mntmHistoriaMdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BusquedaHistoria gui = new BusquedaHistoria();
				gui.main();
				
				
			}
		});
		mnConstancias.add(mntmHistoriaMdica);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), menuBar, mnArchivo, mntmControlFacturas, mnConstancias, mntmNewMenuItem, mntmNewMenuItem_1, mntmNewMenuItem_2, mntmNewMenuItem_3, mntmHistoriaMdica, mntmSalir, mnDatosEntidades, mntmEntidades, mntmSeguros, mnConsultar, mntmReporte, mntmReporteFGeneral, mnMantenimiento, mntmBackup}));
		
		if(nivel_acceso.equalsIgnoreCase("Secretaria")){
			mnMantenimiento.setEnabled(false);
			mnDatosEntidades.setEnabled(false);
		}
	
	}
}
