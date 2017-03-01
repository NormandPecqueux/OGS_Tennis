package hei.devweb.dao;

public interface Joueur_dao {
	
	public void getJoueur(long id, String nom, String prenom, String nom_equipe);
	
	public void getJoueur(long id);
	
	public void getJoueurByNom(String nom);
	
	public void getJoueurByPrenom(String prenom);
	
	public void getJoueurByNomEquipe(String nom);
	
	public void getJoueurByNom(long id, String nom);
	
	public void getJoueurByPrenom(long id, String prenom);
	
	public void getJoueurByNomEquipe(long id, String nom_equipe);
	
	public void getJoueurByNomPrenom( String nom, String prenom);
	
	public void getJoueurByNomNomEquipe( String nom, String nom_equipe);
	
	public void getJoueurByPrenomNomEquipe ( String prenom, String nom_equipe);
	
	public void getJoueurByIdNomPrenom(long id, String nom, String prenom);
	
	public void getJoueurByidPrenomNomEquipe(long id, String prenom, String nom_equipe);
	
	public void getJoueurByIdNomNomEquipe(long id, String nom, String nom_equipe);
	
	public void getJoueurByNomPrenomNomEquipe( Sting nom, String prenom, String nom_equipe );
	
	
	
	
}
