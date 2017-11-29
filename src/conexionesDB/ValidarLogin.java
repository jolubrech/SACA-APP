package conexionesDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import formularios.Login;

public class ValidarLogin {
	int resultado = 0;

	Pool metodospool = new Pool();

	private String nivel_acceso;

	public int validar_ingreso() {
 
		String usuario = Login.txtUsuario.getText();
		String clave = String.valueOf(Login.txtPassword.getPassword());

		

		String SSQL = "SELECT * FROM usuarios WHERE usuario='" + usuario
				+ "' AND clave=('" + clave + "')";

		Connection conect = null;
 
		try {

			conect = metodospool.dataSource.getConnection();
			Statement st = conect.createStatement();
			ResultSet rs = st.executeQuery(SSQL);

			if (rs.next()) {

				resultado = 1;
				nivel_acceso = rs.getString("nivel_acceso");
				
				

			}

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex, "Error de conexión",
					JOptionPane.ERROR_MESSAGE);

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
	
	public int crear_usuarios(String usuario, String clave, Object nivelAcceso) {
 
		String SSQL = "INSERT INTO usuarios (usuario, clave, nivel_acceso) "
				+ "VALUES (?, ?, ?)";


		Connection conect = null;
 
		try {
			conect = metodospool.dataSource.getConnection();

		PreparedStatement psql = conect.prepareStatement(SSQL);
		psql.setString(1, usuario);
		psql.setString(2, clave);
		psql.setString(3, (String) nivelAcceso);
		resultado = psql.executeUpdate();

		psql.close();

	} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex, "Error de conexión",
					JOptionPane.ERROR_MESSAGE);

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

	public String getNivel_acceso() {
		return nivel_acceso;
	}
	
	

}
