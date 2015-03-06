package br.com.athenas.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario {
	@NotNull
	@GeneratedValue
	@Id
	private Long id;
	private String nome;
	private String sobrenome;
	private String cargo;
	
	public Funcionario(){
		
	}
	public Funcionario(String nome , String sobrenome , String cargo){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
