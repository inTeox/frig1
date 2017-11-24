package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.beans.Client;
import com.sdzee.tp.forms.CreationClientForm;

public class CreationClient extends HttpServlet {
    public static final String CHEMIN          = "chemin";
    public static final String ATT_CLIENT      = "client";
    public static final String ATT_FORM        = "form";
    public static final String SESSION_CLIENTS = "clients";

    public static final String VUE_SUCCES      = "/WEB-INF/afficherClient.jsp";
    public static final String VUE_FORM        = "/WEB-INF/creerClient.jsp";

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
        CreationClientForm form = new CreationClientForm();

        /* Traitement de la requ�te et r�cup�ration du bean en r�sultant */
        Client client = form.creerClient( request, chemin );

        /* Ajout du bean et de l'objet m�tier � l'objet requ�te */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_FORM, form );

        /* Si aucune erreur */
        if ( form.getErreurs().isEmpty() ) {
            /* Alors r�cup�ration de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );
            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }
            /* Puis ajout du client courant dans la map */
            clients.put( client.getNom(), client );
            /* Et enfin (r�)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );

            /* Affichage de la fiche r�capitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, r�-affichage du formulaire de cr�ation avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}