package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	public void ImprimirDatos(String[] documento, String[] nombre, double[] salario, String titulos,
			String tituloProyecto) {

		String[] listaTitulos = titulos.split("~");
		String salida = listaTitulos[0] + "  ---  " + listaTitulos[1] + "  --------------------------  "
				+ listaTitulos[2] + "\n";

		for (int i = 0; i < salario.length; i++) {
			salida += documento[i] + " -- " + nombre[i] + " -- " + salario[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, salida, tituloProyecto, 1);
	}
}
