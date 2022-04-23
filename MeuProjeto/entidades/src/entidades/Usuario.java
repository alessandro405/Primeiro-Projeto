package entidades;

public class Usuario {
	
	private String email;
	private String senha;
	
	
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
		
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
