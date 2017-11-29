package conexionesDB;

import org.apache.commons.dbcp2.BasicDataSource;

public class Pool {
	
	public BasicDataSource dataSource;
	
	public String db= "db_sac";
	public String url= "jdbc:mysql://localhost/"+db;
	public String user= "root";
	public String pass= "root";
	
	public Pool(){
		
		InicializaDataSource();
	}

	private void InicializaDataSource(){
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(pass);
		basicDataSource.setUrl(url);
		basicDataSource.setMaxTotal(50);
		
		dataSource = basicDataSource;
	}
}
