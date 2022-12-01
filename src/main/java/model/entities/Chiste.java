package model.entities;

public class Chiste {
	private int id;
	private String adopo;
	private String descripcion;
	private int idcategoria;
	private String titulo;
	private int puntos;
	public Chiste() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chiste(int id, String adopo, String descripcion, int idcategoria, String titulo, int puntos) {
		super();
		this.id = id;
		this.adopo = adopo;
		this.descripcion = descripcion;
		this.idcategoria = idcategoria;
		this.titulo = titulo;
		this.puntos = puntos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdopo() {
		return adopo;
	}
	public void setAdopo(String adopo) {
		this.adopo = adopo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Chiste [id=" + id + ", adopo=" + adopo + ", descripcion=" + descripcion + ", idcategoria=" + idcategoria
				+ ", titulo=" + titulo + ", puntos=" + puntos + "]";
	}
	
}
