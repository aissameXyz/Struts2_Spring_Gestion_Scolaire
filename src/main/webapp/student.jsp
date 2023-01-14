<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestion des Étudiants</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <style>
        /* Add some custom styles for the page */
        body {
            background-image: url(https://cdn.pixabay.com/photo/2016/10/26/15/20/graphics-1771704_1280.jpg); /* Add background image */
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
        /* Add some custom styles for the buttons */
        .btn {
            margin: 10px; /* Add some margin to the buttons */
            padding: 10px; /* Add some padding to the buttons */
            text-align: center; /* Center the text inside the buttons */
            text-decoration: none; /* Remove the underline from the buttons */
            transition: all 0.2s ease-in-out; /* Add a transition effect */
        }
        /* Add hover effect to the buttons */
        .btn:hover {
            background-color: #f5f5f5; /* Change the background color on hover */
            color: #333; /* Change the text color on hover */
            transform: scale(1.1); /* Scale the button up on hover */
        }
        /* Add some custom styles for the icons */
        .btn i {
            font-size: 24px; /* Increase the size of the icon */
            margin-right: 10px; /* Add some margin to the right of the icon */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Gestion des Étudiants</h1>
    <a href="all" class="btn btn-primary">
        <i class="fas fa-list"></i>
        Liste des Étudiants
    </a>
    <a href="add_student.jsp" class="btn btn-success">
        <i class="fas fa-plus"></i>
        Ajouter un Étudiant
    </a>
    <a href="home.jsp" class="btn btn-danger">
        <i class="fas fa-home"></i>
        Retour à l'Accueil
    </a>
</div>

</body>
</html>
