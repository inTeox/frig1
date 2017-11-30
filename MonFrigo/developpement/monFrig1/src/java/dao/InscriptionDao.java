package dao;

import java.util.List;

import fg1.bean.Proprietaire;

public interface InscriptionDao {
    void creer( Proprietaire proprietaire ) throws DAOException;

    Proprietaire trouver( long id ) throws DAOException;

    List<Proprietaire> lister() throws DAOException;

    void supprimer( Proprietaire proprietaire ) throws DAOException;
}