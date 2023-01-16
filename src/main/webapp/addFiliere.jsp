<%--
  Created by IntelliJ IDEA.
  User: Boukhllad
  Date: 1/14/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Add some custom styles for the form */
        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f5f5f5;
        }
        /* Add some custom styles for the form fields */
        form label, form input {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }
        form label {
            font-weight: bold;
        }
        form input[type="text"], form input[type="number"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        /* Add some custom styles for the submit button */
        form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        /* Add hover effect to the submit button */
        form input[type="submit"]:hover {
            background-color: #3e8e41;
        }
        .cancel-button {
            color: white;
            background-color: red;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            align-content: center;
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
<h1 style="text-align: center;">Enter Filiere Information</h1>
<form action="addFiliere" method="post">
    <label for="code_fil">Code Filiere:</label>
    <input type="text" id="code_fil" name="filieire.code_fil" required>
    <label for="nom">Nom Filiere:</label>
    <input type="text" id="nom" name="filiere.nom_fil" required>
    <input type="submit" value="Save">
    <a href="filieres.jsp" class="cancel-button">Annuler</a>
</form>
</body>

</html>
