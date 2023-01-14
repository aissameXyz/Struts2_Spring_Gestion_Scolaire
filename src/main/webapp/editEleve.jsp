<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Eleve</title>
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
    </style>
</head>
<body>
<h1>Update Eleve</h1>
<s:form action="updateEleve" method="post">
    <s:hidden name="eleve.cne" value="%{eleve.cne}"/>
    <s:textfield name="eleve.nom" label="Nom" value="%{eleve.nom}"/>
    <s:textfield name="eleve.prenom" label="Prenom" value="%{eleve.prenom}"/>
    <s:textfield name="eleve.moyenne" label="Moyenne" value="%{eleve.moyenne}"/>
    <s:submit value="Save" cssClass="btn btn-primary"/>
</s:form>
</body>
</html>
