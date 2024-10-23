<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Canciones</title>
</head>
<body>
<h1>Canciones</h1>
<table>
    <tr>
        <th>Titulo</th>
        <th>Artista</th>
        <th>Detalle</th>
    </tr>
    <c:forEach var="cancion" items="${canciones}">
        <tr>
            <td>${cancion.titulo}</td>
            <td>${cancion.artista}</td>
            <td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/canciones/formulario/agregar">Agregar Canción</a>
</body>
</html>