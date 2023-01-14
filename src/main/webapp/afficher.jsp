<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Boukhllad
  Date: 1/14/2023
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        /* Add some custom styles for the table */
        table {
            margin: 30px auto; /* Center the table on the page */
            width: 90%; /* Set the table width */
        }
        /* Add some custom styles for the table head */
        th {
            font-size: 18px; /* Increase the font size of the table head */
        }
        /* Add some custom styles for the table body */
        td {
            font-size: 16px; /* Increase the font size of the table body */
        }
        /* Add some custom styles for the action links */
        .btn {
            margin: 5px; /* Add some margin to the action links */
        }
        /* Center the table header text */
        th {
            text-align: center;
        }
        /* Add some padding and border to the table cells */
        td, th {
            padding: 10px;
            border: 1px solid #ddd;
        }
        /* Add hover effect to the table rows */
        tr:hover {
            background-color: #f5f5f5;
        }
        /* Add some custom font styles for the table */
        h1, th, td {
            font-family: 'Open Sans', sans-serif;
        }
        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f5f5f5;
        }

    </style>
</head>

<h1>LISTE DES ÉLÈVES</h1>
<table class="table table-striped table-hover">
    <thead class="thead-dark">
    <tr>
        <th>CNE</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Moyenne</th>
        <th colspan="2">ACTION</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="eleves">
        <tr>
            <td><s:property value="cne"/></td>
            <td><s:property value="nom"/></td>
            <td><s:property value="prenom"/></td>
            <td><s:property value="moyenne"/></td>
            <td><a href="editEleve?cne=<s:property value='cne'/>" class="btn btn-info">Modifier</a></td>
            <td><a href="deleteEleve?cne=<s:property value='cne'/>" class="btn btn-danger">Supprimer</a></td>
        </tr>
    </s:iterator>
    </tbody>
</table>

</body>
</html>
