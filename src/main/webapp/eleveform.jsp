<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Eleve Form</title>
</head>
<body>
<h1>Enter Eleve Information</h1>
<s:form action="eleveAction" method="post">
    <s:textfield name="eleve.cne" label="CNE" />
    <s:textfield name="eleve.nom" label="Nom" />
    <s:textfield name="eleve.prenom" label="Prenom" />
    <s:textfield name="eleve.moyenne" label="Moyenne" />
    <s:submit value="Save"/>
</s:form>
</body>
</html>
