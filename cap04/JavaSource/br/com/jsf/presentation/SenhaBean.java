package br.com.jsf.presentation;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "senhaBean")
@RequestScoped
public class SenhaBean {
	
	private String senha;
	private String confirmar;
	
	public void validateSenha(ComponentSystemEvent event) {
		UIComponent components = event.getComponent();
		
		UIInput campoSenha = (UIInput) components.findComponent("senha");
		UIInput campoConfirmar = (UIInput) components.findComponent("confirmar");
		
		String senha = campoSenha.getValue().toString().trim();
		String confirmar = campoConfirmar.getValue().toString().trim();
		
		if(!senha.equals(confirmar)) {
			FacesContext context = FacesContext.getCurrentInstance();
			
			ResourceBundle bundle = ResourceBundle.getBundle("br.com.jsf.resource.ApplicationResource", context.getViewRoot().getLocale());
			String msg = bundle.getString("message.senha.erro");
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			
			context.addMessage(null, mensagem);
			
			context.renderResponse();
		}
	}
	
	public String criarSenha() {
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
	}

}
