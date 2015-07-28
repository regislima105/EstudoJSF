package br.com.jsf.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
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
	
	@NotNull(message = "Campo obrigatório")
	private String estado;
	
	@NotNull(message = "Campo obrigatório")
	private String cidade;
	
	@NotNull(message = "Campo Obrigatório")
	@Size(min = 4)
	private String telefone;
	
	@NotNull(message = "Campo Obrigatório")
	private String status;
	
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> cidades = new ArrayList<SelectItem>();
	
	@PostConstruct
	public void iniciar() {
		estados.add(new SelectItem("ES", "Espirito Santo"));
		estados.add(new SelectItem("RJ", "Rio de Janeiro"));
		estados.add(new SelectItem("SP", "São Paulo"));
	}
	
	public void montarListaCidades(ValueChangeEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String valor = (String) event.getNewValue();
		
		if(valor.equals("ES")) {
			cidades.add(new SelectItem(new Integer(1), "Vitória"));
			cidades.add(new SelectItem(new Integer(2), "Vila Velha"));
			cidades.add(new SelectItem(new Integer(3), "Serra"));
		}
		
		if(valor.equals("RJ")) {
			cidades.add(new SelectItem(new Integer(4), "Rio de Janeiro"));
			cidades.add(new SelectItem(new Integer(5), "Niterói"));
			cidades.add(new SelectItem(new Integer(6), "Petropolis"));
		}
		
		if(valor.equals("SP")) {
			cidades.add(new SelectItem(new Integer(7), "São Paulo"));
			cidades.add(new SelectItem(new Integer(8), "Santos"));
			cidades.add(new SelectItem(new Integer(9), "Campinas"));
		}
		
		context.renderResponse();
	}
	
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public List<SelectItem> getCidades() {
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}

}
