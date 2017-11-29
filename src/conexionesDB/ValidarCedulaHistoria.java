package conexionesDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ValidarCedulaHistoria {

	//VARIABLES GLOBALES
	int numHistoria = 0;
	int resultado=0;

	Pool metodospool = new Pool();
	private Object nombrePaciente;
	private int numHistoriaFinal;
	private String cedulaPaciente;

	public int busquedaCedula(String cedula){

		String SSQL = "SELECT * FROM historias WHERE cedula='" + cedula + "'";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;

				numHistoria = rs.getInt("num_historia");
				cedulaPaciente = rs.getString("cedula");
				if(numHistoria==0){
					resultado=0;
				}

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
	
	public int registrarHistoria(String cedula, String historia){

		int resultado = 0;

		Connection con = null;

		String SSQL = "INSERT INTO historias (cedula, num_historia) "
				+ "VALUES (?, ?)";

		
		
		try {

			con = metodospool.dataSource.getConnection();

			PreparedStatement psql = con.prepareStatement(SSQL);
			psql.setString(1, cedula);
			psql.setString(2, historia);
			resultado = psql.executeUpdate();

			psql.close();

		} catch (SQLException e) {
			resultado = 0;

			//JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información del Paciente:\n"
				//	+ e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

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
	
	public int eliminarHistoria(String cedula){

		

		String SSQL = "DELETE from historias WHERE cedula='" + cedula + "'";


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

	public void numHistoriaFinal(){

		String SSQL = "select max(num_historia) as max_historia from historias";

		Connection conect = null;

		try {

			conect = metodospool.dataSource.getConnection();

			Statement st = conect.createStatement();

			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {
				resultado = 1;
			
				numHistoriaFinal = rs.getInt("max_historia");
				numHistoriaFinal = numHistoriaFinal+1;
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



	}

	public int getNumHistoria() {
		return numHistoria;
	}

	public Object getNombrePaciente() {
		return nombrePaciente;
	}

	public int getNumHistoriaFinal() {
		return numHistoriaFinal;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public boolean esStringAlfa(String name) {

		if(name.length()==0){
			return false;
		}
			
			char[] chars = name.toCharArray();

			for (char c : chars) {
				if(!Character.isLetter(c)) {

					return true;
				}
			}
		



		return false;

	}



}
