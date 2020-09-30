package co.edu.unbosque.model;

public class Informacion {

	private String[] documento;
	private String[] nombre;
	private double[] salario;
	private double[] sueldoNeto;

	public Informacion(int numRegistros) {
		this.documento = new String[numRegistros];
		this.nombre = new String[numRegistros];
		this.salario = new double[numRegistros];
		this.sueldoNeto = new double[numRegistros];
	}

	public String[] procesarNomina(String[] encabezados) {

		String[] data = new String[4];
		double retencion = 0;

		for (int i = 0; i < data.length; i++) {
			data[i] = encabezados[i] + "\n";
		}

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

		return data;
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
