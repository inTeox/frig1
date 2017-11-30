package filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fg1.bean.Proprietaire;
import dao.InscriptionDao;
import dao.DAOFactory;

public class PrechargementFilter implements Filter {
    public static final String CONF_DAO_FACTORY      = "daofactory";
    public static final String ATT_SESSION_PROPRIETAIRES   = "proprietaires";
    

    private InscriptionDao          inscriptionDao;
    

    public void init( FilterConfig config ) throws ServletException {
        /* R�cup�ration d'une instance de nos DAO Client et Commande */
        this.inscriptionDao = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getInscriptionDao();
               
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast de l'objet request */
        HttpServletRequest request = (HttpServletRequest) req;

        /* R�cup�ration de la session depuis la requ�te */
        HttpSession session = request.getSession();

        /*
         * Si la map des clients n'existe pas en session, alors l'utilisateur se
         * connecte pour la premi�re fois et nous devons pr�charger en session
         * les infos contenues dans la BDD.
         */
        if ( session.getAttribute( ATT_SESSION_PROPRIETAIRES ) == null ) {
            /*
             * R�cup�ration de la liste des clients existants, et enregistrement
             * en session
             */
            List<Proprietaire> listeProprietaires = inscriptionDao.lister();
            Map<Long, Proprietaire> mapProprietaires = new HashMap<Long, Proprietaire>();
            for ( Proprietaire proprietaire : listeProprietaires ) {
                mapProprietaires.put( proprietaire.getId(), proprietaire );
            }
            session.setAttribute( ATT_SESSION_PROPRIETAIRES, mapProprietaires );
        }

        /* Pour terminer, poursuite de la requ�te en cours */
        chain.doFilter( request, res );
    }

    public void destroy() {
    }
}