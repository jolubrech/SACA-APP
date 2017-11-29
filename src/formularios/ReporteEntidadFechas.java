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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReporteEntidadFechas {

	private JFrame frmReporteFechas;
	private JTextField txtCodigoEntidad;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEntidadFechas window = new ReporteEntidadFechas();
					window.frmReporteFechas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReporteEntidadFechas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmReporteFechas = new JFrame();
		frmReporteFechas.setTitle("Reporte Facturaci\u00F3n por Fechas");
		frmReporteFechas.setBounds(100, 100, 433, 302);
		frmReporteFechas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReporteFechas.getContentPane().setLayout(null);
		frmReporteFechas.setLocationRelativeTo(null);
		
		JLabel lblCdigoDeLa = new JLabel("Seleccione las fechas:");
		lblCdigoDeLa.setBounds(265, 29, 125, 20);
		frmReporteFechas.getContentPane().add(lblCdigoDeLa);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReporteFechas.dispose();
			}
		});
		btnRegresar.setIcon(new ImageIcon(ReporteEntidadFechas.class.getResource("/images/Button Previous_48.png")));
		btnRegresar.setToolTipText("Regresar a la pantalla Principal");
		btnRegresar.setBounds(10, 4, 54, 57);
		frmReporteFechas.getContentPane().add(btnRegresar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(245, 60, 162, 139);
		frmReporteFechas.getContentPane().add(panel);
		
		JXDatePicker datePicker_Cancelación = new JXDatePicker();
		datePicker_Cancelación.setBounds(10, 94, 142, 22);
		panel.add(datePicker_Cancelación);
		
		JXDatePicker datePicker_Facturacion = new JXDatePicker();
		datePicker_Facturacion.setBounds(10, 36, 142, 22);
		panel.add(datePicker_Facturacion);
		
		JLabel label_1 = new JLabel("Fecha de Facturaci\u00F3n: ");
		label_1.setBounds(22, 11, 130, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Fecha de Cancelaci\u00F3n: ");
		label_2.setBounds(22, 69, 130, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Estado de Cuenta:");
		label_3.setBounds(48, 72, 105, 14);
		frmReporteFechas.getContentPane().add(label_3);
		
		JComboBox cmbEdoCuenta = new JComboBox();
		cmbEdoCuenta.setModel(new DefaultComboBoxModel(new String[] {"Cancelada", "Pendiente"}));
		cmbEdoCuenta.setSelectedIndex(0);
		cmbEdoCuenta.setBounds(48, 97, 105, 20);
		frmReporteFechas.getContentPane().add(cmbEdoCuenta);
		
		JLabel label_4 = new JLabel("C\u00F3digo de la Entidad: ");
		label_4.setBounds(48, 128, 105, 14);
		frmReporteFechas.getContentPane().add(label_4);
		
		txtCodigoEntidad = new JTextField();
		txtCodigoEntidad.setText("");
		txtCodigoEntidad.setColumns(10);
		txtCodigoEntidad.setBounds(48, 153, 105, 20);
		frmReporteFechas.getContentPane().add(txtCodigoEntidad);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setIcon(new ImageIcon(ReporteEntidadFechas.class.getResource("/images/Generate-tables.png")));
		btnGenerar.addActionListener(new ActionListener() {
			@SuppressWarnings({ })
			public void actionPerformed(ActionEvent arg0) {
				


				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				HashMap parametros = new HashMap<>();
				parametros.put("cod", txtCodigoEntidad.getText());
				parametros.put("estado", cmbEdoCuenta.getSelectedItem());
				parametros.put("facturacion", formater.format(datePicker_Facturacion.getDate()));
				parametros.put("cancelacion", formater.format(datePicker_Cancelación.getDate()));
				Connection conect = null;
				
				
				//Parametros 
				
				
				try {
					Pool Bd = new Pool();
					
					
					String direccion = System.getProperty("user.dir")+ "/reportes/reporteGeneralFechas.jasper";
					JasperPrint informe = JasperFillManager.fillReport(direccion, parametros, Bd.dataSource.getConnection());
					frmReporteFechas.dispose();
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
		btnGenerar.setBounds(48, 184, 147, 68);
		frmReporteFechas.getContentPane().add(btnGenerar);
		
		
	}
}
