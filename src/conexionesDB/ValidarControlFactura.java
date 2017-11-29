package conexionesDB;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;







import javax.swing.JOptionPane;





import formularios.ControlFacturas;

public class ValidarControlFactura {

	String nombApelli = "";
	Pool metodospool = new Pool();
	String codEnti = "";
	String nombEnti = "";
	String codSeg = "";
	String monto = "";;
	String descrip = "";
	String nombSeg = "";
	String formaPago = "";
	String tipoAtencion = "";
	String estadoCuenta = "";
	int resultado = 0;
	Date fechaFactu;
	Date fechaCance;
	String codigoSeg;
	String nombreSeguro;
	String direccionSeguro;
	String rifSeguro;
	String telefonoSeguro;
	String tipoSeguro;
	String nombreEnti;
	String codigoEnti;
	String direccionEnti;
	String rifEnti;
	String telefonoEnti;
	String tipoEnti;
	String cedula;
	private String direcSeg;
	private String telfSeg;
	private String rifSeg;
	private String direcEnti;
	private String telfEnti;

	public int validar_factura() {

		String factura = ControlFacturas.txtFactura.getText();

		String SSQL = "SELECT * FROM pacientes WHERE factura='" + factura + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				nombApelli = rs.getString("nombre");
				codEnti = rs.getString("codigo_entidad");
				nombEnti = rs.getString("nom_ent");
				codSeg = rs.getString("cod_s");
				monto = rs.getString("monto");
				descrip = rs.getString("descripcion");
				formaPago = rs.getString("f_pago");
				tipoAtencion = rs.getString("t_atencion");
				estadoCuenta = rs.getString("est_c");
				fechaFactu = rs.getDate("fecha_f");
				fechaCance = rs.getDate("fecha_c");

				ControlFacturas.txtNombApelli.setText(nombApelli);
				ControlFacturas.txtCodEnti.setText(codEnti);
				ControlFacturas.txtNombEnti.setText(nombEnti);
				ControlFacturas.txtCodSeg.setText(codSeg);
				ControlFacturas.txtMonto.setText(monto);
				ControlFacturas.txtDescrip.setText(descrip);


			}

			String SSQL2 = "SELECT * FROM seguros WHERE cod_seg='" + codSeg
					+ "'";

			ResultSet rs2 = st.executeQuery(SSQL2);
			if (rs2.next()) {
				nombSeg = rs2.getString("nomb_seg");


			}

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;

	}

	public int validar_factura_duplicado(){


		String factura = ControlFacturas.txtFactura.getText();

		String SSQL = "SELECT * FROM pacientes WHERE factura='" + factura + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;



			}

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;


	}

	public int validar_codig_seg( String codSeg) {



		String SSQL = "SELECT * FROM seguros WHERE cod_seg='" + codSeg + "'";

		Connection conect = null;

		try {
			conect = metodospool.dataSource.getConnection();
			Statement st = conect.createStatement();
			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado=1;
				nombSeg = rs.getString("nomb_seg");
				direcSeg = rs.getString("direc_seg");
				rifSeg = rs.getString("rif_seg");
				telfSeg = rs.getString("telf_seg");


			}

		} catch (SQLException e) {


		} finally {
			try {
				conect.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return resultado;

	}

	public int validar_codig_entid(String codEnti) {



		String SSQL = "SELECT * FROM entidades WHERE cod_enti='" + codEnti
				+ "'";

		Connection conect = null;

		try {
			conect = metodospool.dataSource.getConnection();
			Statement st = conect.createStatement();
			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado=1;
				nombEnti = rs.getString("nomb_enti");
				direcEnti = rs.getString("direc_enti");
				rifEnti = rs.getString("rif_enti");
				telfEnti = rs.getString("telef_enti");
				
				
			}

		} catch (SQLException e) {
			JOptionPane.showInputDialog(null,
					"Código de Seguro no registrado!",e);
		} finally {
			try {
				conect.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return resultado;

	}

	public int registrarPaciente(String numFactura, String nombApelli, String codEnti, String NombEnti, 
			String formPago, String codSeg, String tipoAten, String estadoCuenta
			, String monto,String descrip, String fechaFactu, String fechaCancel){

		int resultado = 0;

		Connection con = null;

		String SSQL = "INSERT INTO pacientes (factura, nombre, codigo_entidad, nom_ent, f_pago"
				+ ", cod_s, t_atencion, est_c,monto, descripcion, fecha_f, fecha_c) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



		try {

			con = metodospool.dataSource.getConnection();

			PreparedStatement psql = con.prepareStatement(SSQL);
			psql.setString(1, numFactura);
			psql.setString(2, nombApelli);
			psql.setString(3, codEnti);
			psql.setString(4, NombEnti);
			psql.setString(5, formPago);
			psql.setString(6, codSeg);
			psql.setString(7, tipoAten);
			psql.setString(8, estadoCuenta);
			psql.setString(9, monto);
			psql.setString(10, descrip);
			psql.setString(11, fechaFactu);
			psql.setString(12, fechaCancel);
			

			resultado = psql.executeUpdate();

			psql.close();

		} catch (SQLException e) {
			resultado = 0;

		

		}finally{

			try {

				if(con!=null){

					con.close();

				}

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
						+ ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);

			}

		}

		return resultado;

	}    

	public int modificarFactura( String numFactura, String nombApelli, String codEnti, String NombEnti, 
			String formPago, String codSeg, String tipoAten, String estadoCuenta
			, String monto,String descrip, String fechaFactu, String fechaCancel) {

		int resultado = 0;

		Connection con = null;





		String SSQL = "UPDATE pacientes SET nombre = ?, codigo_entidad = ?, nom_ent = ?, "
				+ "f_pago = ?, cod_s = ?, t_atencion = ?, est_c = ?, monto = ?, descripcion = ?,"
				+ " fecha_f = ?, fecha_c  = ? WHERE factura = ? ";



		try {

			con = metodospool.dataSource.getConnection();

			PreparedStatement psql = con.prepareStatement(SSQL);

			
			psql.setString(1, nombApelli);
			psql.setString(2, codEnti);
			psql.setString(3, NombEnti);
			psql.setString(4, formPago);
			psql.setString(5, codSeg);
			psql.setString(6, tipoAten);
			psql.setString(7, estadoCuenta);
			psql.setString(8, monto);
			psql.setString(9, descrip);
			psql.setString(10, fechaFactu);
			psql.setString(11, fechaCancel);
			psql.setString(12, numFactura);
			

			resultado = psql.executeUpdate();

			psql.close();

		} catch (SQLException e) {


			JOptionPane.showMessageDialog(null, "Error al intentar modificar la información del Paciente:\n PRUEBA"
					+ e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

		}finally{

			try {

				if(con!=null){

					con.close();

				}

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
						+ ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);

			}

		}

		return resultado;

	}

	public int eliminarFactura() {

		String factura = ControlFacturas.txtFactura.getText();

		String SSQL = "DELETE from pacientes WHERE factura='" + factura + "'";


		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			int rs = st.executeUpdate(SSQL);

			if (rs==1) {
				resultado = 1;

			}



		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;

	}

	public int validar_seleccion_paciente(String factura) {
		int resultado = 0;
		String SSQL = "SELECT * FROM pacientes WHERE factura='" + factura + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				nombApelli = rs.getString("nombre");
				codEnti = rs.getString("codigo_entidad");
				nombEnti = rs.getString("nom_ent");
				codSeg = rs.getString("cod_s");
				monto = rs.getString("monto");
				descrip = rs.getString("descripcion");
				formaPago = rs.getString("f_pago");
				tipoAtencion = rs.getString("t_atencion");
				estadoCuenta = rs.getString("est_c");
				fechaFactu = rs.getDate("fecha_f");
				fechaCance = rs.getDate("fecha_c");
				








			}

			String SSQL2 = "SELECT * FROM seguros WHERE cod_seg='" + codSeg
					+ "'";

			ResultSet rs2 = st.executeQuery(SSQL2);
			if (rs2.next()) {
				nombSeg = rs2.getString("nomb_seg");

			}

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;

	}

	public int validar_seleccion_seguro(String cod_seg) {
		int resultado = 0;
		String SSQL = "SELECT * FROM seguros WHERE cod_seg='" + cod_seg + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				codigoSeg = rs.getString("cod_seg");
				nombreSeguro = rs.getString("nomb_seg");


			}


		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;

	}

	public int validar_seleccion_entidad(String cod_enti){

		int resultado = 0;
		String SSQL = "SELECT * FROM entidades WHERE cod_enti='" + cod_enti + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				codigoEnti = rs.getString("cod_enti");
				nombreEnti = rs.getString("nomb_enti");
				direccionEnti = rs.getString("direc_enti");
				rifEnti = rs.getString("rif_enti");
				telefonoEnti = rs.getString("telef_enti");
				tipoEnti = rs.getString("tipo_enti");

			}

			/*String SSQL2 = "SELECT * FROM entidades WHERE nomb_enti='" + codSeg
					+ "'";

			ResultSet rs2 = st.executeQuery(SSQL2);
			if (rs2.next()) {
				nombSeg = rs2.getString("nomb_seg");

			}*/

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);

		} finally {

			try {

				conect.close();

			} catch (SQLException ex) {

				JOptionPane.showMessageDialog(null, ex, "Error de desconexión",
						JOptionPane.ERROR_MESSAGE);

			}

		}
		return resultado;


	}

	public String getNombApelli() {

		return nombApelli;

	}

	public Pool getMetodospool() {
		return metodospool;
	}

	public String getCodEnti() {
		return codEnti;
	}

	public String getNombEnti() {
		return nombEnti;
	}

	public String getCodSeg() {
		return codSeg;
	}

	public String getMonto() {
		return monto;
	}

	public String getDescrip() {
		return descrip;
	}

	public String getNombSeg() {
		return nombSeg;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public String getTipoAtencion() {
		return tipoAtencion;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public int getResultado() {
		return resultado;
	}

	public Date getFechaFactu() {
		return fechaFactu;
	}

	public Date getFechaCance() {
		return fechaCance;
	}

	public String getCodigoSeg() {
		return codigoSeg;
	}

	public String getNombreSeguro() {
		return nombreSeguro;
	}

	public String getDireccionSeguro() {
		return direccionSeguro;
	}

	public String getRifSeguro() {
		return rifSeguro;
	}

	public String getTelefonoSeguro() {
		return telefonoSeguro;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public String getNombreEnti() {
		return nombreEnti;
	}

	public String getCodigoEnti() {
		return codigoEnti;
	}

	public String getDireccionEnti() {
		return direccionEnti;
	}

	public String getRifEnti() {
		return rifEnti;
	}

	public String getTelefonoEnti() {
		return telefonoEnti;
	}

	public String getTipoEnti() {
		return tipoEnti;
	}

	public String getDirecSeg() {
		return direcSeg;
	}

	public String getTelfSeg() {
		return telfSeg;
	}

	public String getRifSeg() {
		return rifSeg;
	}

	public String getDirecEnti() {
		return direcEnti;
	}

	public String getTelfEnti() {
		return telfEnti;
	}


	public boolean esStringAlfa(String name) {

		if(name.length()==0){
			return false;
		}
			
			char[] chars = name.toCharArray();

			for (char c : chars) {
				if(!Character.isLetter(c)) {

					return false;
				}
			}
		



		return true;

	}


}
