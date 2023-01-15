<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Élèves</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
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
        /* Center the form and add some padding */
        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f5f5f5;
        }
        /* Add some custom styles for the action buttons */
        .action-btn {
            margin: 10px;
            font-size: 20px;
            padding: 10px;
            border-radius: 50%;
            transition: all 0.3s ease;
        }
        /* Add hover effect to the action buttons */
        .action-btn:hover {
            background-color: #f5f5f5;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="d-flex justify-content-between">
    <a href="home.jsp" class="action-btn"><i class="fas fa-home"></i></a>
    <a href="addFiliere.jsp" class="action-btn"><i class="fa fa-plus"></i></a>
    <a href="filieres.jsp" class="action-btn"><i class="fa fa-building"></i></a>
</div>
<h1 class="text-center">Liste des Filieres</h1>
<table class="table table-striped table-hover">
    <thead class="thead-dark">
    <tr>
        <th>Code Filiere</th>
        <th>Nom Filiere</th>
        <th colspan="2">ACTION</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="filieres">
        <tr>
            <td><s:property value="code_fil"/></td>
            <td><s:property value="nom_fil"/></td>
            <td>
                <a href="<s:url action="editFiliere"><s:param name="codeId"><s:property value="code_fil"/></s:param></s:url>" >
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                    </svg>
                </a>
            </td>
            <td>  <a href="<s:url action="deleteFiliere"><s:param name="codeId"><s:property value="code_fil"/></s:param></s:url>"
                     onclick="return confirm('Etes vous sur de la suppression ?')" accesskey="">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                </svg>

            </a> </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>