package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	public void ImprimirDatos(String[] documento, String[] nombre, double[] salario) {

		String salida = "Documento  ---  " + "Nombre  --------------------------  " + "Salario\n";
		for (int i = 0; i < salario.length; i++) {
			salida += documento[i] + " -- " + nombre[i] + " -- " + salario[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, salida, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
}
