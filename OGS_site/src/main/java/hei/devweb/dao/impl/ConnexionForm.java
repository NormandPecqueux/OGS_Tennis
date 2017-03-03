package hei.devweb.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import hei.devweb.model.Joueur;

public final class ConnexionForm {
    private static  String login  = "login";
    private static  String pswd  = "pswd";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Joueur connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String login = getValeurChamp( request, login );
        String pswd = getValeurChamp( request, pswd );

        Joueur joueur = new Joueur();

        /* Validation du champ email. */
        try {
            validationlogin( login );
        } catch ( Exception e ) {
            setErreur( login, e.getMessage() );
        }
        joueur.setLogin( login );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( pswd );
        } catch ( Exception e ) {
            setErreur( pswd, e.getMessage() );
        }
        joueur.setPswd( pswd );

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationlogin( String login ) throws Exception {
        if ( login != null && !login.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir un login valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null) {
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}