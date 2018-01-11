package fg1.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fg1.bean.Proprietaire;
import fg1.form.CreationProprietaireForm;

public class CreationProprietaire extends HttpServlet {
    public static final String CHEMIN          = "chemin";
    public static final String ATT_CLIENT      = "proprietaire";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_CLIENTS = "proprietaires";

    public static final String VUE_SUCCES      = "/WEB-INF/afficherProprietaire.jsp";
    public static final String VUE_FORM        = "/WEB-INF/creerProprietaire.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* � la r�ception d'une requ�te GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Lecture du param�tre 'chemin' pass� � la servlet via la d�claration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );
        System.out.println("maroute:" + chemin); 

        /* Pr�paration de l'objet formulaire */
        CreationProprietaireForm form = new CreationProprietaireForm();

        /* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
        Proprietaire proprietaire = form.creerProprietaire( request, chemin );

        /* Ajout du bean et de l'objet m�tier � l'objet requ�te */
        request.setAttribute( ATT_CLIENT, proprietaire );
        request.setAttribute( ATT_FORM, form );

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors r�cup�ration de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Proprietaire> proprietaires = (HashMap<String, Proprietaire>) session.getAttribute( SESSION_CLIENTS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( proprietaires == null ) {
                proprietaires = new HashMap<String, Proprietaire>();
            }
            /* Puis ajout du client courant dans la map */
            proprietaires.put( proprietaire.getNom(), proprietaire );
            /* Et enfin (r�)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, proprietaires );

            /* Affichage de la fiche r�capitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, r�-affichage du formulaire de cr�ation avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}