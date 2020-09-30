package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class NominaProperties {

	private Properties prop;
	private String archivoprop = "./Data/archivo.properties";

	public NominaProperties() {
		prop = new Properties();
	}

	public int escribirPropiedades() {

		try {
			prop.setProperty("nombreProyecto", "NicolásPeñaMogollónNominaV3");
			prop.setProperty("maxRegistros", "26");
			prop.setProperty("archivoOrigen", "./Data/datosprincipales.csv");
			prop.setProperty("archivoRet10", "./Data/Nomina1.txt");
			prop.setProperty("archivoRet15", "./Data/Nomina2.txt");
			prop.setProperty("archivoRet20", "./Data/Nomina3.txt");
			prop.setProperty("archivoMaestro", "./Data/Maestro.txt");
			prop.setProperty("titulosPanel", "Documento: ~Nombre: ~Salario: ");
			prop.setProperty("encabezadoArchivos",
					"Nómina retención 10%#Nómina retención 15%#Nómina retención 20%#Documento~Nombre");

			prop.store(new FileOutputStream(archivoprop), null);
		} catch (IOException ex) {
			return -1;
		}
		return 0;
	}

	public String leerPropiedades() {
		String linea = "";
		try {
			// leer el archivo de propiedades
			prop.load(new FileInputStream(archivoprop));
			// Reading each property value
			linea += prop.getProperty("nombreProyecto") + "\n";
			linea += prop.getProperty("maxRegistros") + "\n";
			linea += prop.getProperty("archivoOrigen") + "\n";
			linea += prop.getProperty("archivoRet10") + "\n";
			linea += prop.getProperty("archivoRet15") + "\n";
			linea += prop.getProperty("archivoRet20") + "\n";
			linea += prop.getProperty("archivoMaestro") + "\n";
			linea += prop.getProperty("titulosPanel") + "\n";
			linea += prop.getProperty("encabezadoArchivos") + "\n";

		} catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
