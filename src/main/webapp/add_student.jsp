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
    </style>
</head>
<body>
<h1 style="text-align: center;">Enter Eleve Information</h1>
<form action="eleveAction" method="post">
    <label for="cne">CNE:</label>
    <input type="text" id="cne" name="eleve.cne" required>
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="eleve.nom" required>
    <label for="prenom">Prenom:</label>
    <input type="text" id="prenom" name="eleve.prenom" required>
    <label for="moyenne">Moyenne:</label>
    <input type="number" id="moyenne" name="eleve.moyenne" required>
    <input type="submit" value="Save">
</form>
</body>
</html>
