
package fr.jsf.Beans;

import fr.jsf.Assets.SessionAssets;
import fr.jsf.Dao.LoginDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */

@ManagedBean
@SessionScoped

public class Login implements Serializable  {
    private static final long serialVersionUID = 1L;

	private String Usuario;
	private String Password;
	private String msg;

    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
	// VALIDAR LA CONEXION
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.ValidarLogin(Usuario, Password);
		if (valid) {
			HttpSession session = SessionAssets.getSession();
			session.setAttribute("username", Usuario);
			return "success.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nombre de usuario y contraseña incorrectos ", "Introduzca Su Nombre de Usuario y Contraseña OBLIGATORIO"));
			return "login";
		}
	}

	//DESCONECTAR LOGIN INICIADO
	public String logout() {
		HttpSession session = SessionAssets.getSession();
		session.invalidate();
		return "login?faces-redirect=true";
	}    
}
