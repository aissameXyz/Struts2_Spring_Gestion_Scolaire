<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
<head>
    <title>School Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
    <style>
        /* Add some custom styles for the buttons */
        .btn {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 150px;
            height: 150px;
            margin: 10px;
            background-color: #f5f5f5;
            border-radius: 50%;
            box-shadow: 2px 2px 3px #ccc;
            transition: all 0.2s ease-in-out;
        }
        /* Add hover effect to the buttons */
        .btn:hover {
            transform: scale(1.1);
            box-shadow: 4px 4px 5px #ccc;
        }
        /* Add some custom styles for the icon */
        .btn i {
            font-size: 48px;
            color: #333;
        }
        footer{
            position: absolute;
            bottom: 0;
            width: 100%;
            text-align:center;

        }

    </style>
</head>
<!DOCTYPE html>
<html>
<head>
    <title>School Manager</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <style>
        /* Add some custom styles for the buttons */
        .btn {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 150px;
            height: 150px;
            margin: 10px;
            background-color: #f5f5f5;
            border-radius: 50%;
            box-shadow: 2px 2px 3px #ccc;
            transition: all 0.2s ease-in-out;
            opacity: .9;
        }
        /* Add hover effect to the buttons */
        .btn:hover {
            transform: scale(1.1);
            box-shadow: 4px 4px 5px #ccc;
        }
        /* Add some custom styles for the icon */
        .btn i {
            font-size: 48px;
            color: #333;
            opacity: .9;
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

<body style="background-image: url(https://images.pexels.com/photos/289618/pexels-photo-289618.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2); background-size: cover;">
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light text-default ">
    <!-- Container wrapper -->
    <div class="container-fluid ">
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
                    <a class="nav-link text-white" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="student.jsp">Elèves</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="filieres.jsp">Filieres</a>
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
<div class="title text-default " style=" display: flex; justify-content: center; margin-top: 15vh;">
<h1 style="text-align: center;">Gestion Scolairer Spring & Struts</h1>
</div>
<div class="container" style="display: flex; justify-content: center; align-items: center; height: 50vh;">
    <a href="student.jsp" class="btn">
        <i class="fa fa-users" aria-hidden="true"></i>
    </a>
    <a href="filieres.jsp" class="btn">
        <i class="fa fa-building " aria-hidden="true"></i>
    </a>
</div>
<script>
    // You could add some JavaScript here if needed
</script>
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
