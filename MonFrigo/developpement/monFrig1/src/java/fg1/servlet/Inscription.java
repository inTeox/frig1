package fg1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fg1.bean.Proprietaire;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Acceuil", urlPatterns = {"/Inscript"})
public class Inscription extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creerProprietaire.jsp").forward(request, response);
	}
protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( "nomProprietaire" );
        String prenom = request.getParameter( "prenomProprietaire" );
        String adresse = request.getParameter( "adresse1Proprietaire" );
        String adresse2 = request.getParameter( "adresse2Proprietaire" );
        String cp = request.getParameter( "cpProprietaire" );
        String ville = request.getParameter( "villeProprietaire" );
        String pseudo = request.getParameter( "pseudoProprietaire" );
        String mdp = request.getParameter( "motPasseProprietaire" );
        String telephone = request.getParameter( "telephoneProprietaire" );
        String email = request.getParameter( "emailProprietaire" );

        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }
        /*
         * Création du bean Proprietaire et initialisation avec les données récupérées
         */
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setNom( nom );
        proprietaire.setPrenom( prenom );
        proprietaire.setAdresse( adresse );
        proprietaire.setAdresse2( adresse2 );
        proprietaire.setCp( cp );
        proprietaire.setVille( ville );
        proprietaire.setPseudo( pseudo );
        proprietaire.setMdp( mdp );
        proprietaire.setTelephone( telephone );
        proprietaire.setEmail( email );

 
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "proprietaire", proprietaire );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/WEB-INF/afficherClient.jsp" ).forward( request, response );
    }
}