<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <title>Gestion des Filieres</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <style>
    /* Add some custom styles for the page */
    body {
      background-image: url(https://cdn.pixabay.com/photo/2018/02/27/15/40/background-3185765_1280.jpg); /* Add background image */
      background-size: cover; /* Set background size */
    }
    /* Add some custom styles for the container */
    .container {
      padding: 50px; /* Add some padding to the container */
      text-align: center; /* Center the content inside the container */
    }
    /* Add some custom styles for the heading */
    h1 {
      color: white; /* Set the text color to white */
      text-shadow: 2px 2px 4px #333; /* Add a text shadow */
    }
    /* Add some custom styles for the
     /* Add some custom styles for the footer */
    footer {
      background-color: #333; /* Set the background color of the footer */
      color: #fff; /* Set the text color of the footer */
      padding: 20px; /* Add some padding to the footer */
    }
    /* Add some custom styles for the copyright text */
    .copyright {
      font-size: 16px; /* Increase the font size of the copyright text */
    }
     */
</style>
</head>
<body>
<div class="container">
  <h1>Gestion des Filières</h1>
  <a href="allFilieres" class="btn btn-primary">
    <i class="fas fa-list"></i>
    Liste des Filières
  </a>
  <a href="addFiliere.jsp" class="btn btn-success">
    <i class="fas fa-plus"></i>
    Ajouter une Filière
  </a>
  <a href="home.jsp" class="btn btn-danger">
    <i class="fas fa-home"></i>
    Retour à l'Accueil
  </a>
</div>
</body>

</html>