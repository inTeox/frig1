<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Votre inscription</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="inscription">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomProprietaire">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomProprietaire" name="nomProprietaire" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomProprietaire">Prénom </label>
                    <input type="text" id="prenomProprietaire" name="prenomProprietaire" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresse1Proprietaire">Adresse<span class="requis">*</span></label>
                    <input type="text" id="adresse1Proprietaire" name="adresse1Proprietaire" value="" size="20" maxlength="20" />
                    <br />
                  
                    <label for="adresse2Proprietaire">Adresse<span class="requis">*</span></label>
                    <input type="text" id="adresse2Proprietaire" name="adresse2Proprietaire" value="" size="20" maxlength="20" />
                    <br />
                    <label for="cpProprietaire">Code postal<span class="requis">*</span></label>
                    <input type="text" id="cpProprietaire" name="cpProprietaire" value="" size="5" maxlength="5" />
                    <br />
                    <label for="villeProprietaire">Ville<span class="requis">*</span></label>
                    <input type="text" id="villeProprietaire" name="villeProprietaire" value="" size="20" maxlength="20" />
                    <br />
                    <label for="pseudoProprietaire">Pseudo <span class="requis">*</span></label>
                    <input type="text" id="pseudoProprietaire" name="pseudoProprietaire" value="" size="20" maxlength="20" />
                    <br />
                    <label for="motPasseProprietaire">Mot de passe <span class="requis">*</span></label>
                    <input type="text" id="motPasseProprietaire" name="motPasseProprietaire" value="" size="20" maxlength="20" />
                    <br />
                    <label for="emailProprietaire">Adresse email</label>
                    <input type="email" id="emailProprietaire" name="emailProprietaire" value="" size="20" maxlength="60" />
                    <br />
                    <br />
                    <label for="telephoneProprietaire">Adresse email</label>
                    <input type="email" id="telephoneProprietaire" name="telephoneProprietaire" value="" size="10" maxlength="10" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>