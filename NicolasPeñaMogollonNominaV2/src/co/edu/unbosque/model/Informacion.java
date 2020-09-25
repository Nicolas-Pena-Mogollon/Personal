package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.NominaFile;

public class Informacion {

	private NominaFile archivo;
	private String[] documento;
	private String[] nombre;
	private double[] salario;
	private double[] sueldoNeto;

	public Informacion() {
		this.archivo = new NominaFile();
		this.documento = new String[26];
		this.nombre = new String[26];
		this.salario = new double[26];
		this.sueldoNeto = new double[26];
	}

	public void ordenarDatos() {
		String[] filas = this.archivo.leerDatos(this.archivo.getRUTA_ORIGEN()).split("\n");

		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split("~");
			this.documento[i] = columnas[0];
			this.nombre[i] = columnas[1];
			this.salario[i] = Double.parseDouble(columnas[2]);
		}

	}

	public void procesarNomina() {

		String[] data = new String[4];
		data[0] = "Nomina retencion 10%\n";
		data[1] = "Nomina retencion 15%\n";
		data[2] = "Nomina retencion 20%\n";
		data[3] = "Documento\t|-|\tNombre\n";
		double retencion = 0;

		for (int i = 0; i < salario.length; i++) {

			if (salario[i] <= 2000) {
				retencion = salario[i] * .1;
				data[0] += documento[i].trim() + "~" + (salario[i] - retencion) + "\n";
			}

			if (salario[i] > 2000 && salario[i] <= 5000) {
				retencion = salario[i] * .15;
				data[1] += documento[i].trim() + "~" + (salario[i] - retencion) + "\n";
			}

			if (salario[i] > 5000) {
				retencion = salario[i] * .2;
				data[2] += documento[i].trim() + "~" + (salario[i] - retencion) + "\n";
			}

			data[3] += documento[i] + "~" + nombre[i] + "\n";
			sueldoNeto[i] = salario[i] - retencion;
		}

		this.archivo.generarNomina(data);
	}

	public NominaFile getArchivo() {
		return archivo;
	}

	public void setArchivo(NominaFile archivo) {
		this.archivo = archivo;
	}

	public String[] getDocumento() {
		return documento;
	}

	public void setDocumento(String[] documento) {
		this.documento = documento;
	}

	public String[] getNombre() {
		return nombre;
	}

	public void setNombre(String[] nombre) {
		this.nombre = nombre;
	}

	public double[] getSalario() {
		return salario;
	}

	public void setSalario(double[] salario) {
		this.salario = salario;
	}

	public double[] getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(double[] sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

}
