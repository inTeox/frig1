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
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>