package conexionesDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import formularios.DatosSeguros;

public class ValidarSeguros {
	
	//VARIABLES GLOBALES
	String cmbTipoSeguro = "";
	
	Pool metodospool = new Pool();

	public int registrarSeguro(String txtCodigo, String txtNombreSeguro, String txtDireccion, String txtRif, 
			String txtTelef, String tipoSeguro){
	int resultado = 0;

	Connection con = null;

	String SSQL = "INSERT INTO seguros (cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg"
			+ ", tip_seg) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";


	try {

		con = metodospool.dataSource.getConnection();

		PreparedStatement psql = con.prepareStatement(SSQL);
		psql.setString(1, txtCodigo);
		psql.setString(2, txtNombreSeguro);
		psql.setString(3, txtDireccion);
		psql.setString(4, txtRif);
		psql.setString(5, txtTelef);
		psql.setString(6, tipoSeguro);
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

	public int eliminarSeguro(String codigo){

		
		int resultado = 0;
		String SSQL = "DELETE from seguros WHERE cod_seg='" + codigo + "'";


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
	
	public int modificarSeguro(String codSeguro, String nombInstitu, String direccion, String rif, String telef, String tipoSeguro){


		int resultado = 0;

		Connection con = null;




		
		
		
		String SSQL = "UPDATE seguros SET cod_seg = ?, nomb_seg = ?, direc_seg = ?, rif_seg = ?, telf_seg = ?, tip_seg = ? WHERE cod_seg = ? ";
		
		
		

		try {

			con = metodospool.dataSource.getConnection();

			PreparedStatement psql = con.prepareStatement(SSQL);

			
			psql.setString(1, codSeguro);
			psql.setString(2, nombInstitu);
			psql.setString(3, direccion);
			psql.setString(4, rif);
			psql.setString(5, telef);
			psql.setString(6, tipoSeguro);
			psql.setString(7, codSeguro);

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
	
	
	public int validar_seleccion_Seguro(String codigo){

		int resultado = 0;
		String SSQL = "SELECT * FROM seguros WHERE cod_seg='" + codigo + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				DatosSeguros.txtCodSeguro.setText(rs.getString("cod_seg"));
				DatosSeguros.txtNombSeguro.setText(rs.getString("nomb_seg"));
				DatosSeguros.txtDireccion.setText(rs.getString("direc_seg"));
				DatosSeguros.txtRif.setText(rs.getString("rif_seg"));
				DatosSeguros.txtTelefono.setText(rs.getString("telf_seg"));
				cmbTipoSeguro = rs.getString("tip_seg"); 
				
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

	public String getCmbTipoSeguro() {
		return cmbTipoSeguro;
	}
	

	
	
}
