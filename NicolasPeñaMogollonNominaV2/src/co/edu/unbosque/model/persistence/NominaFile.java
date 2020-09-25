package co.edu.unbosque.model.persistence;

import java.io.*;

public class NominaFile {

	private final String RUTA_ORIGEN = "./Data/datosprincipales.csv";
	private final String[] RUTAS = new String[4];

	public NominaFile() {
		this.RUTAS[0] = "./Data/Nomina1.txt";
		this.RUTAS[1] = "./Data/Nomina2.txt";
		this.RUTAS[2] = "./Data/Nomina3.txt";
		this.RUTAS[3] = "./Data/Maestro.txt";
	}

	public String leerDatos(String ruta) {

		String linea = "";
		String data = "";
		File f = new File(ruta);

		try {

			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			linea = br.readLine();

			while (linea != null) {

				String[] separadorDatos = linea.split(";");
				String nombre = separadorDatos[1].replace("Â", "").replace("Ã‘", "Ñ").replace((char) 160, (char) 0)
						.trim().replace((char) 194, (char) 0);

				if (nombre.contains("Ã"))
					nombre = (nombre.substring(0, nombre.lastIndexOf("Ã")) + "Á"
							+ nombre.substring(nombre.lastIndexOf("Ã") + 2));

				data += separadorDatos[0].replace((char) 160, (char) 0).replace("Â", "").trim() + "~" + nombre.trim()
						+ "~" + Double.parseDouble(separadorDatos[2].trim()) + "\n";

				linea = br.readLine();
			}
			br.close();

		} catch (IOException e) {
			return "";
		}

		return data;
	}

	public void generarNomina(String[] data) {

		for (int i = 0; i < data.length; i++) {

			File f = new File(this.RUTAS[i]);
			try {
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(data[i]);
				fw.close();
			} catch (IOException e) {

			}
		}

	}

	public String getRUTA_ORIGEN() {
		return RUTA_ORIGEN;
	}

	public String[] getRUTAS() {
		return RUTAS;
	}

}
