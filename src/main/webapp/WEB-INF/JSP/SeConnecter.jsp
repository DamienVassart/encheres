
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Laurane Marie -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="textcharset="UTF-8">
<title>ENI-Enchères</title>
   </head>
   <body>
      <jsp:include page="PageAccueil.jsp"></jsp:include>
   

      <h3>Connexion</h3>
      <p style="color: red;">${errorString}</p>


      <form method="POST" action="encheres/servlet/ServletSeConnecter">
         <table border="0">
            <tr>
               <td>Identifiant :</td>
               <td><input type="text" name="pseudo" value= "${utilisateur.pseudo}" /> </td>
            </tr>
            <tr>
               <td>Mot de passe:</td>
               <td><input type="text" name="motDePasse" value= "${utilisateur.motDePasse}" /> </td>
            </tr>
            <tr>
               <td>Se souvenir de moi</td>
               <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
            </tr>
            <tr>
             <td colspan ="2">
                  <input type="submit" value= "Connexion" />
                  <a href="${pageContext.request.contextPath}/">Annuler</a>
               </td>
            </tr>
         </table>
      </form>

    


   </body>
</html>
 