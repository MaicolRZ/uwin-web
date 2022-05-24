package pe.edu.universidad.entidades;

public class Curso {

	private int id;
	
	private String nombre;
	
	private int creditos;
	
	private int horasTeoria;
	
	private int horasPractica;
	
	private int horasLaboratorio;

	public Curso() {
		
	}
	
	public Curso(int id2, String nombre2, int creditos2, int horasTeoria2, int horasPractica2, int horasLab) {
		this.id = id2;
		this.nombre = nombre2;
		this.creditos = creditos2;
		this.horasTeoria = horasTeoria2;
		this.horasPractica = horasPractica2;
		this.horasLaboratorio = horasLab;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getHorasTeoria() {
		return horasTeoria;
	}

	public void setHorasTeoria(int horasTeoria) {
		this.horasTeoria = horasTeoria;
	}

	public int getHorasPractica() {
		return horasPractica;
	}

	public void setHorasPractica(int horasPractica) {
		this.horasPractica = horasPractica;
	}

	public int getHorasLaboratorio() {
		return horasLaboratorio;
	}

	public void setHorasLaboratorio(int horasLaboratorio) {
		this.horasLaboratorio = horasLaboratorio;
	}

	
	
}
