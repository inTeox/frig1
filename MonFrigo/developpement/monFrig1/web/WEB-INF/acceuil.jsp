<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Bienvenu dans le frigo !</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/mycss.css"/>" />
    </head>
    <body>
        <h1>Bienvenu dans le frigo !</h1>
        <form method="post" action="<c:url value="/Acceuil"/>">
        <table>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                                        
                </tr>
                <tr>
                    <td  class="action"><a href="<c:url value="/Connect"/>">Connection</a></td>
                    <td><img src="/monFrig1/images/frigoOuvert.jpg"></td>
                    <td  class="action"><a href="<c:url value="/Inscript"/>">Inscription</a></td>
                </tr>
            </table>  
          </form>      
    </body>
</html>
