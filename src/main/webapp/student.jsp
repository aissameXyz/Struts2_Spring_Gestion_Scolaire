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


    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Toggle button -->
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- Navbar brand -->
            <a class="navbar-brand mt-2 mt-lg-0" href="home.jsp">
                <img
                        src="https://www.guide-metiers.ma/wp-content/uploads/2019/02/ensatanger.couleur-1200x900-cropped.png"
                        alt="ensat manager"
                        height="45"
                        loading="eager"
                />
            </a>
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-dark" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-dark" href="student.jsp">Elèves</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-dark" href="filieres.jsp">Filieres</a>
                </li>
            </ul>
            <!-- Left links -->
        </div>
        <!-- Collapsible wrapper -->

        <!-- Right elements -->
        <div class="d-flex align-items-center">
            <!-- Icon -->

            <!-- Notifications -->

            <!-- Avatar -->
            <div class="dropdown">
                <a
                        class="dropdown-toggle d-flex align-items-center hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuAvatar"
                        role="button"
                        data-mdb-toggle="dropdown"
                        aria-expanded="false"
                >
                    <img
                            src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
                            class="rounded-circle"
                            height="25"
                            alt="Black and White Portrait of a Man"
                            loading="lazy"
                    />
                </a>
                <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuAvatar"
                >
                    <li>
                        <a class="dropdown-item" href="#">My profile</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Settings</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Right elements -->
    </div>
    <!-- Container wrapper -->
</nav>
<div class="container">
    <h1>Gestion des Étudiants</h1>
    <a href="all" class="btn btn-primary">
        <i class="fas fa-list"></i>
        Liste des Étudiants
    </a>
    <a href="add_view" class="btn btn-success">
        <i class="fas fa-plus"></i>
        Ajouter un Étudiant
    </a>
    <a href="home.jsp" class="btn btn-danger">
        <i class="fas fa-home"></i>
        Retour à l'Accueil
    </a>
</div>
<!-- Footer -->

<footer class="page-footer font-small fixed-bottom" style="background-color: rgba(0, 0, 0, 0.2);">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2023 Copyright: Gestion Scolaire AISSAME BOUKHALLAD
        <a href="/"> Aissame.xyz</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->

</body>

</html>
