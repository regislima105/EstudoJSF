package br.com.jsf.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "empregadoBean")
@RequestScoped
public class EmpregadoBean implements Serializable {

	private static final long serialVersionUID = 5899926333333940845L;
	
	@NotNull(message = "Campo Obrigatório")
	@Size(min = 1, max = 10)
	private String nome;
	
	@NotNull(message = "Campo obrigatório")
	private String email;
	
	@NotNull(message = "Campo Obrigatório")
	@Size(min = 4)
	private String telefone;
	
	@NotNull(message = "Campo Obrigatório")
	private String status;
	
	public void cadastrar() {
		System.out.println("Empregado cadastrado...");
	}
	
	public String cancelar() {
		nome = null;
		email = null;
		telefone = null;
		status = null;
		
		return "empregadoCancelar";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
