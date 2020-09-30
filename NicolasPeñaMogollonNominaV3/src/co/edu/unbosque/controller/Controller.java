package co.edu.unbosque.controller;

import co.edu.unbosque.model.Nomina;
import co.edu.unbosque.view.View;

public class Controller {

	private View gui;
	private Nomina nomina;

	public Controller() {
		this.gui = new View();
		this.nomina = new Nomina();
		this.coordinar();
	}

	public void coordinar() {
		
		this.nomina.ordenarDatos();
		this.nomina.gestionarNomina();
		
		gui.ImprimirDatos(this.nomina.getInformacion().getDocumento(), this.nomina.getInformacion().getNombre(),
				this.nomina.getInformacion().getSalario(), this.nomina.getTitulosPanel(),
				this.nomina.getNombreProyecto());
	}

}
