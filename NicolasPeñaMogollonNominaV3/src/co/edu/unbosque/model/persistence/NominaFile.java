package co.edu.unbosque.model.persistence;

import java.io.*;

public class NominaFile {

	public NominaFile() {
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

	public void generarNomina(String[] data, String[] rutas) {

		for (int i = 0; i < data.length; i++) {

			File f = new File(rutas[i]);
			try {
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(data[i]);
				fw.close();
			} catch (IOException e) {

			}
		}

	}

}
