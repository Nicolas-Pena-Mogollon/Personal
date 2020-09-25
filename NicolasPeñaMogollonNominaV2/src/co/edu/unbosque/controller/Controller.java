package co.edu.unbosque.controller;

import co.edu.unbosque.model.Informacion;
import co.edu.unbosque.view.View;

public class Controller {

	private View gui;
	private Informacion info;

	public Controller() {
		gui = new View();
		info = new Informacion();
		this.coordinar();
	}

	public void coordinar() {

		this.info.ordenarDatos();
		this.info.procesarNomina();

		gui.ImprimirDatos(this.info.getDocumento(), this.info.getNombre(), this.info.getSalario());
	}

}
