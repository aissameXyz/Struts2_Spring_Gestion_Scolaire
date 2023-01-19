<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
  <title>Update Eleve</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
  <!-- Add some styling for the page -->
  <style>
    /* Add some custom styles for the form */
    form {
      margin: 30px auto;
      width: 50%;
      padding: 30px;
      border: 1px solid #ccc;
      border-radius: 10px;
      background-color: #f5f5f5;
    }

    /* Add some custom styles for the input fields */
    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
      background-color: #f8f8f8;
      font-size: 16px;
    }

    /* Add some custom styles for the submit button */
    input[type="submit"] {
      width: 100%;
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }

    /* Add some hover effect to the submit button */
    input[type="submit"]:hover {
      background-color: #45a049;
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
<h1 class="text-center">Filiere Eleve</h1>
<s:form action="updateFiliere" method="post">
  <s:hidden name="filiere.code_fil" value="%{filiere.code_fil}"/>
  <s:textfield name="filiere.nom_fil" label="Nom" value="%{filiere.nom_fil}"/>
  <s:submit value="Save" cssClass="btn btn-primary"/>
</s:form>
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
