<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Artistas</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .no-artistas {
            color: red;
        }
    </style>
</head>
<body>
<h1>Artistas</h1>
<c:if test="${empty artistas}">
    <p class="no-artistas">No hay artistas disponibles.</p>
</c:if>
<c:if test="${not empty artistas}">
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Detalles</th>
        </tr>
        <c:forEach var="artista" items="${artistas}">
            <tr>
                <td>${artista.nombre}</td>
                <td>${artista.apellido}</td>
                <td><a href="/artistas/detalle/${artista.id}">Detalles</a></td>
                
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/canciones">Ir a canciones</a>
<a href="/artistas/formulario/agregar">Agregar Artista</a>
</body>
</html>
