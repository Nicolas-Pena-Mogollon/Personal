package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.NominaFile;
import co.edu.unbosque.model.persistence.NominaProperties;

public class Nomina {

	private Informacion informacion;
	private NominaFile archivo;
	private NominaProperties properties;
	private String nombreProyecto;
	private int numRegistros;
	private String rutaArchivoOrigen;
	private String archivoRet10;
	private String archivoRet15;
	private String archivoRet20;
	private String archivoMaestro;
	private String titulosPanel;
	private String encabezadoArchivos;

	public Nomina() {
		this.archivo = new NominaFile();
		this.properties = new NominaProperties();
		this.gestionarProperties();
		this.informacion = new Informacion(this.numRegistros);
	}

	public void ordenarDatos() {
		String[] filas = this.archivo.leerDatos(this.rutaArchivoOrigen).split("\n");

		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split("~");
			this.informacion.getDocumento()[i] = columnas[0];
			this.informacion.getNombre()[i] = columnas[1];
			this.informacion.getSalario()[i] = Double.parseDouble(columnas[2]);
		}

	}

	public void gestionarProperties() {

		properties.escribirPropiedades();
		String[] listaDePropiedades = properties.leerPropiedades().split("\n");

		this.nombreProyecto = listaDePropiedades[0];
		this.numRegistros = Integer.parseInt(listaDePropiedades[1]);
		this.rutaArchivoOrigen = listaDePropiedades[2];
		this.archivoRet10 = listaDePropiedades[3];
		this.archivoRet15 = listaDePropiedades[4];
		this.archivoRet20 = listaDePropiedades[5];
		this.archivoMaestro = listaDePropiedades[6];
		this.titulosPanel = listaDePropiedades[7];
		this.encabezadoArchivos = listaDePropiedades[8];

	}

	public void gestionarNomina() {

		String[] listaRutas = new String[4];
		listaRutas[0] = this.archivoRet10;
		listaRutas[1] = this.archivoRet15;
		listaRutas[2] = this.archivoRet20;
		listaRutas[3] = this.archivoMaestro;

		this.archivo.generarNomina(this.informacion.procesarNomina(this.encabezadoArchivos.split("#")), listaRutas);
	}

	public Informacion getInformacion() {
		return informacion;
	}

	public void setInformacion(Informacion informacion) {
		this.informacion = informacion;
	}

	public NominaFile getArchivo() {
		return archivo;
	}

	public void setArchivo(NominaFile archivo) {
		this.archivo = archivo;
	}

	public NominaProperties getProperties() {
		return properties;
	}

	public void setProperties(NominaProperties properties) {
		this.properties = properties;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public int getNumRegistros() {
		return numRegistros;
	}

	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}

	public String getRutaArchivoOrigen() {
		return rutaArchivoOrigen;
	}

	public void setRutaArchivoOrigen(String rutaArchivoOrigen) {
		this.rutaArchivoOrigen = rutaArchivoOrigen;
	}

	public String getArchivoRet10() {
		return archivoRet10;
	}

	public void setArchivoRet10(String archivoRet10) {
		this.archivoRet10 = archivoRet10;
	}

	public String getArchivoRet15() {
		return archivoRet15;
	}

	public void setArchivoRet15(String archivoRet15) {
		this.archivoRet15 = archivoRet15;
	}

	public String getArchivoRet20() {
		return archivoRet20;
	}

	public void setArchivoRet20(String archivoRet20) {
		this.archivoRet20 = archivoRet20;
	}

	public String getArchivoMaestro() {
		return archivoMaestro;
	}

	public void setArchivoMaestro(String archivoMaestro) {
		this.archivoMaestro = archivoMaestro;
	}

	public String getTitulosPanel() {
		return titulosPanel;
	}

	public void setTitulosPanel(String titulosPanel) {
		this.titulosPanel = titulosPanel;
	}

	public String getEncabezadoArchivos() {
		return encabezadoArchivos;
	}

	public void setEncabezadoArchivos(String encabezadoArchivos) {
		this.encabezadoArchivos = encabezadoArchivos;
	}

}
