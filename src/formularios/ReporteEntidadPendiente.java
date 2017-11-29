package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import conexionesDB.Pool;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReporteEntidadPendiente {

	private JFrame frmReporteFacturacinPor;
	private JTextField txtCodigoEntidad;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEntidadPendiente window = new ReporteEntidadPendiente();
					window.frmReporteFacturacinPor.setVisible(true);
					txtCodigoEntidad.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReporteEntidadPendiente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmReporteFacturacinPor = new JFrame();
		frmReporteFacturacinPor.setTitle("Reporte Facturaci\u00F3n por Entidad");
		frmReporteFacturacinPor.setBounds(100, 100, 348, 238);
		frmReporteFacturacinPor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReporteFacturacinPor.getContentPane().setLayout(null);
		frmReporteFacturacinPor.setLocationRelativeTo(null);

		JComboBox cmbTipoPago = new JComboBox();
		cmbTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Seguro", "Efectivo"}));
		cmbTipoPago.setBounds(180, 67, 89, 20);
		frmReporteFacturacinPor.getContentPane().add(cmbTipoPago);

		txtCodigoEntidad = new JTextField();
		txtCodigoEntidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if(txtCodigoEntidad.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Código de Endidad vacío", "Error de Búsqueda",
								JOptionPane.ERROR_MESSAGE);

					}else{

						if(cmbTipoPago.getSelectedItem().toString().equalsIgnoreCase("Efectivo")
								||cmbTipoPago.getSelectedItem().toString().equalsIgnoreCase("Seguro")){
							HashMap parametros = new HashMap<>();
							parametros.put("cod", txtCodigoEntidad.getText());
							parametros.put("tipoPago", cmbTipoPago.getSelectedItem().toString());
							Connection conect = null;


							//Parametros 


							try {
								Pool Bd = new Pool();
								String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneralPendienteEfectivoSeguro.jasper";
								JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
								frmReporteFacturacinPor.dispose();
								JasperViewer.viewReport(informe, false);

							} catch (JRException | SQLException a) {

								a.printStackTrace();
							}finally{

								if(conect!=null){

									try {

										conect.close();

									} catch (SQLException ex) {

										JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

									}

								}

							}

						}else{

							HashMap parametros = new HashMap<>();
							parametros.put("cod", txtCodigoEntidad.getText());
							//parametros.put("tipoPago", cmbTipoPago.getSelectedItem().toString());
							Connection conect = null;


							//Parametros 


							try {
								Pool Bd = new Pool();
								String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneralPendiente.jasper";
								JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
								frmReporteFacturacinPor.dispose();
								JasperViewer.viewReport(informe, false);

							} catch (JRException | SQLException f) {

								f.printStackTrace();
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




				}
			}
		});
		txtCodigoEntidad.setBounds(216, 28, 47, 20);
		frmReporteFacturacinPor.getContentPane().add(txtCodigoEntidad);
		txtCodigoEntidad.setColumns(10);
		txtCodigoEntidad.requestFocus();

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setIcon(new ImageIcon(ReporteEntidadPendiente.class.getResource("/images/Generate-tables.png")));
		btnGenerar.addActionListener(new ActionListener() {
			@SuppressWarnings({ })
			public void actionPerformed(ActionEvent arg0) {

				if(txtCodigoEntidad.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Código de Endidad vacío", "Error de Búsqueda",
							JOptionPane.ERROR_MESSAGE);

				}else{

					if(cmbTipoPago.getSelectedItem().toString().equalsIgnoreCase("Efectivo")
							||cmbTipoPago.getSelectedItem().toString().equalsIgnoreCase("Seguro")){
						HashMap parametros = new HashMap<>();
						parametros.put("cod", txtCodigoEntidad.getText());
						parametros.put("tipoPago", cmbTipoPago.getSelectedItem().toString());
						Connection conect = null;


						//Parametros 


						try {
							Pool Bd = new Pool();
							String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneralPendienteEfectivoSeguro.jasper";
							JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
							frmReporteFacturacinPor.dispose();
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

					}else{

						HashMap parametros = new HashMap<>();
						parametros.put("cod", txtCodigoEntidad.getText());
						//parametros.put("tipoPago", cmbTipoPago.getSelectedItem().toString());
						Connection conect = null;


						//Parametros 


						try {
							Pool Bd = new Pool();
							String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneralPendiente.jasper";
							JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
							frmReporteFacturacinPor.dispose();
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



				}




			}
		});
		btnGenerar.setBounds(98, 120, 147, 68);
		frmReporteFacturacinPor.getContentPane().add(btnGenerar);

		JLabel lblCdigoDeLa = new JLabel("C\u00F3digo de la Entidad:");
		lblCdigoDeLa.setBounds(87, 28, 139, 20);
		frmReporteFacturacinPor.getContentPane().add(lblCdigoDeLa);

		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReporteFacturacinPor.dispose();
			}
		});
		btnRegresar.setIcon(new ImageIcon(ReporteEntidadPendiente.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Regresar a la pantalla Principal");
		btnRegresar.setBounds(10, 11, 54, 57);
		frmReporteFacturacinPor.getContentPane().add(btnRegresar);

		JLabel lblTipoPago = new JLabel("Tipo Pago:");
		lblTipoPago.setBounds(87, 67, 139, 20);
		frmReporteFacturacinPor.getContentPane().add(lblTipoPago);		

	}
}
