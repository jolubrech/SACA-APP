package conexionesDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import formularios.DatosEntidades;

public class ValidarEntidades {
	
	
	String CmbTipoEntidad="";
	
	Pool metodospool = new Pool();

	private String txtNombEnti;

	public int registrarEntidad(String txtCodigo, String txtNombreEnti, String txtDireccion, String txtRif, 
			String txtTelef, String tipoEntidad){
	int resultado = 0;

	Connection con = null;

	String SSQL = "INSERT INTO entidades (cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti"
			+ ", tipo_enti) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";


	try {

		con = metodospool.dataSource.getConnection();

		PreparedStatement psql = con.prepareStatement(SSQL);
		psql.setString(1, txtCodigo);
		psql.setString(2, txtNombreEnti);
		psql.setString(3, txtDireccion);
		psql.setString(4, txtRif);
		psql.setString(5, txtTelef);
		psql.setString(6, tipoEntidad);
		resultado = psql.executeUpdate();

		psql.close();

	} catch (SQLException e) {
		resultado = 0;

		JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información de la Entidad:\n"
				+"Código duplicado", "Error en la operación", JOptionPane.ERROR_MESSAGE);

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

	public int eliminarEntidad(String codigo){

		
		int resultado = 0;
		String SSQL = "DELETE from entidades WHERE cod_enti='" + codigo + "'";


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
	
	public int modificarEntidad(String codEnti, String nombInstitu, String direccion, String rif, String telef, String tipoEnti){


		int resultado = 0;

		Connection con = null;




		
		
		
		String SSQL = "UPDATE entidades SET cod_enti = ?, nomb_enti = ?, direc_enti = ?, rif_enti = ?, telef_enti = ?, tipo_enti = ? WHERE cod_enti = ? ";
		
		
		
		try {

			con = metodospool.dataSource.getConnection();

			PreparedStatement psql = con.prepareStatement(SSQL);

			
			psql.setString(1, codEnti);
			psql.setString(2, nombInstitu);
			psql.setString(3, direccion);
			psql.setString(4, rif);
			psql.setString(5, telef);
			psql.setString(6, tipoEnti);
			psql.setString(7, codEnti);

			resultado = psql.executeUpdate();

			psql.close();

		} catch (SQLException e) {


			JOptionPane.showMessageDialog(null, "Error al intentar modificar la información del Paciente:\n"
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
	
	
	public int validar_seleccion_entidad(String codigo){

		int resultado = 0;
		String SSQL = "SELECT * FROM entidades WHERE cod_enti='" + codigo + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				DatosEntidades.txtCodEnt.setText(rs.getString("cod_enti"));
				DatosEntidades.txtNombInstitu.setText(rs.getString("nomb_enti"));
				DatosEntidades.txtDireccion.setText(rs.getString("direc_enti"));
				DatosEntidades.txtRif.setText(rs.getString("rif_enti"));
				DatosEntidades.txtTelef.setText(rs.getString("telef_enti"));
				CmbTipoEntidad = rs.getString("tipo_enti");
				txtNombEnti = rs.getString("nomb_enti");
				
				
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
	public Pool getMetodospool() {
		return metodospool;
	}

	

	public String getCmbTipoEntidad() {
		return CmbTipoEntidad;
	}

	public String getTxtNombEnti() {
		return txtNombEnti;
	}
	
	

	
}
