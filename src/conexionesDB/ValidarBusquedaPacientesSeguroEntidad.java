package conexionesDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ValidarBusquedaPacientesSeguroEntidad {

	Pool metodospool = new Pool();
	DefaultTableModel ModeloTabla;

	public void Buscar(String valor, String filtro, JTable tablacontactos){

		String [] columnas={"N°Factura","Nombre y Apellido","Código de Entidad","Forma de Pago","Monto", "Tipo de Atención","Descripción", "Estado de Cuenta", "Nombre de la Entidad","Fecha de Facturación","Fecha de Cancelación","Código de Seguro"};
		String [] registro=new String[12];
		ModeloTabla=new DefaultTableModel(null,columnas);      
		String SSQL = "";
		Connection conect = null;

		if(filtro.equals("Nombre/Apellido")){

			SSQL= "SELECT factura, nombre, codigo_entidad, f_pago, monto, t_atencion, descripcion, est_c, nom_ent, fecha_f, fecha_c, cod_s "
					+ "FROM pacientes WHERE nombre LIKE '%"+valor+"%'";

		}else if(filtro.equals("N° Factura")){

			SSQL= "SELECT factura, nombre, codigo_entidad, f_pago, monto, t_atencion, descripcion, est_c, nom_ent, fecha_f, fecha_c, cod_s "
					+ "FROM pacientes WHERE factura LIKE '%"+valor+"%'";

		}


		try {

			conect = metodospool.dataSource.getConnection();
			PreparedStatement st = conect.prepareStatement(SSQL);
			ResultSet rs = st.executeQuery();

			while (rs.next()){

				registro[0]=rs.getString("factura");
				registro[1]=rs.getString("nombre");
				registro[2]=rs.getString("codigo_entidad");
				registro[3]=rs.getString("f_pago");
				registro[4]=rs.getString("monto");
				registro[5]=rs.getString("t_atencion");
				registro[6]=rs.getString("descripcion");
				registro[7]=rs.getString("est_c");
				registro[8]=rs.getString("nom_ent");
				registro[9]=rs.getString("fecha_f");
				registro[10]=rs.getString("fecha_c");
				registro[11]=rs.getString("cod_s");



				ModeloTabla.addRow(registro);

			}

			tablacontactos.setModel(ModeloTabla);

		} catch (SQLException e) {


			JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);


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


	public void Buscar_Seguros(String valor, String filtro, JTable tablacontactos){




		String [] columnas={"Código","Nombre","Dirección","Rif","Telef","Tipo"};
		String [] registro=new String[6];
		ModeloTabla=new DefaultTableModel(null,columnas);      
		String SSQL = "";
		Connection conect = null;

		if(filtro.equals("Nombre")){


			SSQL= "SELECT cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg, tip_seg "
					+ "FROM seguros WHERE nomb_seg LIKE '%"+valor+"%'";



		}else if(filtro.equals("Código")){

			SSQL= "SELECT cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg, tip_seg "
					+ "FROM seguros WHERE cod_seg LIKE '%"+valor+"%'";

		}else if(filtro.equals("Tipo")){

			SSQL= "SELECT cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg, tip_seg " 
					+ "FROM seguros WHERE tip_seg LIKE '%"+valor+"%'";


		}else if(filtro.equals("RIF")){

			SSQL= "SELECT cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg, tip_seg "
					+ "FROM seguros WHERE rif_seg LIKE '%"+valor+"%'";

		}else if(filtro.equals("Dirección")){


			SSQL= "SELECT cod_seg, nomb_seg, direc_seg, rif_seg, telf_seg, tip_seg "
					+ "FROM seguros WHERE direc_seg LIKE '%"+valor+"%'";



		}


		try {

			conect = metodospool.dataSource.getConnection();
			PreparedStatement st = conect.prepareStatement(SSQL);
			ResultSet rs = st.executeQuery();

			while (rs.next()){

				registro[0]=rs.getString("cod_seg");
				registro[1]=rs.getString("nomb_seg");
				registro[2]=rs.getString("direc_seg");
				registro[3]=rs.getString("rif_seg");
				registro[4]=rs.getString("telf_seg");
				registro[5]=rs.getString("tip_seg");

				ModeloTabla.addRow(registro);

			}

			tablacontactos.setModel(ModeloTabla);

		} catch (SQLException e) {


			JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);


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

	public void Buscar_Entidad(String valor, String filtro, JTable tablacontactos){





		String [] columnas={"Código","Nombre","Dirección","Rif","Telef","Tipo"};
		String [] registro=new String[6];
		ModeloTabla=new DefaultTableModel(null,columnas);      
		String SSQL = "";
		Connection conect = null;

		if(filtro.equals("Nombre")){


			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE nomb_enti LIKE '%"+valor+"%'";

		}else if(filtro.equals("Código")){

			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE cod_enti LIKE '%"+valor+"%'";

		}else if(filtro.equals("Tipo")){

			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE tipo_enti LIKE '%"+valor+"%'";


		}else if(filtro.equals("RIF")){

			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE rif_enti LIKE '%"+valor+"%'";

		}else if(filtro.equals("Dirección")){


			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE direc_enti LIKE '%"+valor+"%'";

		}else if(filtro.equals("Telef")){


			SSQL= "SELECT cod_enti, nomb_enti, direc_enti, rif_enti, telef_enti, tipo_enti "
					+ "FROM entidades WHERE telef_enti LIKE '%"+valor+"%'";

		}


		try {

			conect = metodospool.dataSource.getConnection();
			PreparedStatement st = conect.prepareStatement(SSQL);
			ResultSet rs = st.executeQuery();

			while (rs.next()){

				registro[0]=rs.getString("cod_enti");
				registro[1]=rs.getString("nomb_enti");
				registro[2]=rs.getString("direc_enti");
				registro[3]=rs.getString("rif_enti");
				registro[4]=rs.getString("telef_enti");
				registro[5]=rs.getString("tipo_enti");

				ModeloTabla.addRow(registro);

			}

			tablacontactos.setModel(ModeloTabla);

		} catch (SQLException e) {


			JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);


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
