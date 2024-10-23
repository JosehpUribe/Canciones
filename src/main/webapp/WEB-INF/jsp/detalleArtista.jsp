<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle del Artista</title>
    <style>
        body { font-family: Arial, sans-serif; }
        h1, h2 { color: #333; }
        ul { list-style-type: none; }
        a { text-decoration: none; color: blue; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>Detalles del Artista</h1>
    <p><strong>Nombre:</strong> ${artista.nombre}</p>
    <p><strong>Apellido:</strong> ${artista.apellido}</p>
    <p><strong>Biografía:</strong> ${artista.biografia}</p>
    <p><strong>Fecha de Creación:</strong> ${artista.fechaCreacion}</p>
    <p><strong>Fecha de Actualización:</strong> ${artista.fechaActualizacion}</p>

    <h2>Canciones del Artista</h2>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li>
                <a href="/canciones/detalle/${cancion.id}">${cancion.titulo}</a>
            </li>
        </c:forEach>
    </ul>

    <a href="/artistas">Volver a la lista de artistas</a>
</body>
</html>
