<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Canción</title>
</head>
<body>
    <h1>Agregar Canción</h1>
    <form:form method="post" modelAttribute="cancion" action="/canciones/procesa/agregar">
        
        <label for="artista">Artista:</label>
        <form:select path="artista.id" id="artista">
            <form:options items="${artistas}" itemValue="id" itemLabel="nombre" />
        </form:select>
        <form:errors path="artista.id" cssClass="error"/>

        <form:input path="titulo" placeholder="Título"/>
        <form:errors path="titulo" cssClass="error"/>

        <form:input path="album" placeholder="Álbum"/>
        <form:errors path="album" cssClass="error"/>

        <form:input path="genero" placeholder="Género"/>
        <form:errors path="genero" cssClass="error"/>

        <form:input path="idioma" placeholder="Idioma"/>
        <form:errors path="idioma" cssClass="error"/>

        <button type="submit">Agregar Canción</button>
    </form:form>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
