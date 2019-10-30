package br.com.curso.entidades;

public class Usuario extends Cargo{
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private Integer idCargo;
	private Cargo cargo;
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Integer getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
