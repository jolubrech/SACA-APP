package generacion;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import formularios.RespaldarRestaurar;

public class ReemplazoVariable {

	public void generacionConstancia() throws URISyntaxException{
		

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		//NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		
		 //Create file object
		
		        File file = new File(jarDir+ "\\documentos\\Constancia.docx");
		
		        try {
		
		            //Open the file using Desktop class
		
		            Desktop.getDesktop().open(file);
		
		        }catch (IOException exception){
		
		            exception.printStackTrace();
		
		        }




		 
		/*
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		String direccion = System.getProperty("user.dir")+ "\\documentos\\Constancia.doc";

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		String direccionSalida = System.getProperty("user.dir")+ "\\documentos\\generados\\Constancia-"+dateFormat.format(date)+".doc";
		// 
		POIFSFileSystem fs = null;        
		try {            
			fs = new POIFSFileSystem(new FileInputStream(direccion));    
			HWPFDocument doc = new HWPFDocument(fs);
			doc = replaceText(doc, "nombrePaciente", "Jorge Luis");
			doc = replaceText(doc, "edadPaciente", "24");
			doc = replaceText(doc, "cedulaPaciente", "21.295.064");
			//NUEVO FORMATEO FECHA
			Locale espanol = new Locale("es","ES");
			DateFormat dateFormatConstancia = new SimpleDateFormat("d MMMM yyyy", espanol);
			Date dateConstancia = new Date();

			doc = replaceText(doc, "fecha", dateFormatConstancia.format(dateConstancia));
			doc = replaceText(doc, "textoDiagnostico", "Fractura de guevo grado III con apertura de escroto y VPH");

			saveWord(direccionSalida, doc);

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	*/}

	public void generacionReposo() throws URISyntaxException{


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		//NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		
		 //Create file object
		
		        File file = new File(jarDir + "\\documentos\\Reposo.docx");
		
		        try {
		
		            //Open the file using Desktop class
		
		            Desktop.getDesktop().open(file);
		
		        }catch (IOException exception){
		
		            exception.printStackTrace();
		
		        }




		 
		
		/*

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		String direccion = System.getProperty("user.dir")+ "\\documentos\\Reposo.doc";

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		String direccionSalida = System.getProperty("user.dir")+ "\\documentos\\generados\\Reposo-"+dateFormat.format(date)+".doc";
		// 
		POIFSFileSystem fs = null;        
		try {            
			fs = new POIFSFileSystem(new FileInputStream(direccion));    
			HWPFDocument doc = new HWPFDocument(fs);
			doc = replaceText(doc, "nombrePaciente", "Jorge Luis");
			saveWord(direccionSalida, doc);

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	*/}

	public void generacionRecipe() throws URISyntaxException{


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		//NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		
		 //Create file object
		
		        File file = new File(jarDir+ "\\documentos\\Recipe.docx");
		
		        try {
		
		            //Open the file using Desktop class
		
		            Desktop.getDesktop().open(file);
		
		        }catch (IOException exception){
		
		            exception.printStackTrace();
		
		        }




		 
		/*


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		String direccion = System.getProperty("user.dir")+ "\\documentos\\Recipe.doc";

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		String direccionSalida = System.getProperty("user.dir")+ "\\documentos\\generados\\Recipe-"+dateFormat.format(date)+".doc";
		// 
		POIFSFileSystem fs = null;        
		try {            
			fs = new POIFSFileSystem(new FileInputStream(direccion));    
			HWPFDocument doc = new HWPFDocument(fs);
			doc = replaceText(doc, "nombrePaciente", "Jorge Luis");
			saveWord(direccionSalida, doc);

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}


	*/}

	public void generacionInforme() throws URISyntaxException, FileNotFoundException, InvalidFormatException{

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados";

		//NOTE: Creating Folder if it does not exist
		File f1 = new File(folderPath);
		f1.mkdir();

		
		 //Create file object
		
		        File file = new File(jarDir+ "\\documentos\\Informe.docx");
		
		        try {
		
		            //Open the file using Desktop class
		
		            Desktop.getDesktop().open(file);
		
		        }catch (IOException exception){
		
		            exception.printStackTrace();
		
		        }




		 }

	public void generacionHistoria(String cedula, String apellidos, 
			String nombres, String sexo, String fecha, String edad, 
			String lugarNaci, String nacionalidad, String direcPacien,
			String telef, String correo, String edoCivil, 
			String instruccion, String ocupacion, String referido, 
			String ICE, String parentesco, String historia, String evolucion, String paraclinicos, Object numHistoria) throws URISyntaxException{

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		dateFormat.format(date);
		String direccion = System.getProperty("user.dir")+ "\\documentos\\Historia.doc";

		//ABOSLUTE PATH
		CodeSource codeSource = RespaldarRestaurar.class.getProtectionDomain().getCodeSource();
		File jarFile;
		jarFile = new File(codeSource.getLocation().toURI().getPath());
		String jarDir = jarFile.getParentFile().getPath();
		String folderPath = jarDir + "\\documentos\\generados\\Historias";

		/*NOTE: Creating Folder if it does not exist*/
		File f1 = new File(folderPath);
		f1.mkdir();

		String direccionSalida = jarDir + "\\documentos\\generados\\Historias\\Historia-"+numHistoria+".doc";

		POIFSFileSystem fs = null;        
		try {            
			fs = new POIFSFileSystem(new FileInputStream(direccion));    
			HWPFDocument doc = new HWPFDocument(fs);

			doc = replaceText(doc, "numero", (String) numHistoria);
			doc = replaceText(doc, "cedulaPaciente", cedula);
			doc = replaceText(doc, "apellidosPaciente", apellidos);
			doc = replaceText(doc, "nombresPaciente", nombres);
			doc = replaceText(doc, "sexoPaciente", sexo);

			//NUEVO FORMATEO FECHA


			doc = replaceText(doc, "nacimiento", fecha);

			doc = replaceText(doc, "edadPaciente", edad);
			doc = replaceText(doc, "lugarNacimiento", lugarNaci);
			doc = replaceText(doc, "nacionalidadPaciente", nacionalidad);
			doc = replaceText(doc, "direccion", direcPacien);
			doc = replaceText(doc, "telefonos", telef);
			doc = replaceText(doc, "correoPaciente", correo);
			doc = replaceText(doc, "edoCivil", edoCivil);
			doc = replaceText(doc, "gradoInstruccion", instruccion);
			doc = replaceText(doc, "ocupacionPaciente", ocupacion);
			doc = replaceText(doc, "referenciaPaciente", referido);
			doc = replaceText(doc, "ICE", ICE);
			doc = replaceText(doc, "nexoFamiliar", parentesco);
			doc = replaceText(doc, "historiaMedica", historia);
			doc = replaceText(doc, "evolucionPaciente", evolucion);
			doc = replaceText(doc, "paraclinicosPaciente", paraclinicos);
			saveWord(direccionSalida, doc);

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	private static HWPFDocument replaceText(HWPFDocument doc, String findText, String replaceText){
		Range r1 = doc.getRange(); 

		for (int i = 0; i < r1.numSections(); ++i ) { 
			Section s = r1.getSection(i); 
			for (int x = 0; x < s.numParagraphs(); x++) { 
				Paragraph p = s.getParagraph(x); 
				for (int z = 0; z < p.numCharacterRuns(); z++) { 
					CharacterRun run = p.getCharacterRun(z); 
					String text = run.text();
					if(text.contains(findText)) {
						run.replaceText(findText, replaceText);
					} 
				}
			}
		} 
		return doc;
	}

	private static void saveWord(String direccionSalida, HWPFDocument doc) throws FileNotFoundException, IOException{
		FileOutputStream out = null;
		try{
			out = new FileOutputStream(direccionSalida);
			doc.write(out);
			JOptionPane.showMessageDialog(null, "Archivo generado exitosamente");
			try {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(new File(direccionSalida));
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		finally{
			out.close();
		}
	}
}