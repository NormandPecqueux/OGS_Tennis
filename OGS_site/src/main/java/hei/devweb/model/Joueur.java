package hei.devweb.model;

public class Joueur {
	
	private long id;
	
	private String nom;
	
	private String prenom; 
	
	private int numero_adherant; 
	
	private String login ; 
	
	private String pswd ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumero_adherant() {
		return numero_adherant;
	}

	public void setNumero_adherant(int numero_adherant) {
		this.numero_adherant = numero_adherant;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	} 
	
	

}
