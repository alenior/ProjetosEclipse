package model;

public class JavaBeans {
	private String matricula;
	private String nome;
	private String media;
	private String frequencia;
	
	public JavaBeans(String matricula, String nome, String media, String frequencia) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.media = media;
		this.frequencia = frequencia;
	}
	public JavaBeans() {
		super();
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	
}
