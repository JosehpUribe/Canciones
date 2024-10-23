<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Canción</title>
</head>
<body>
<h1>Editar Canción</h1>
<form action="/canciones/procesa/editar/${cancion.id}" method="post">
    <label for="titulo">Título:</label>
    <input type="text" name="titulo" value="${cancion.titulo}" required minlength="5" /><br />
    
    <label for="artista">Artista:</label>
    <input type="text" name="artista" value="${cancion.artista}" required minlength="3" /><br />
    
    <label for="album">Álbum:</label>
    <input type="text" name="album" value="${cancion.album}" required minlength="3" /><br />
    
    <label for="genero">Género:</label>
    <input type="text" name="genero" value="${cancion.genero}" required minlength="3" /><br />
    
    <label for="idioma">Idioma:</label>
    <input type="text" name="idioma" value="${cancion.idioma}" required minlength="3" /><br />
    
    <button type="submit">Actualizar Canción</button>
</form>
<a href="/canciones">Volver a lista de canciones</a>
</body>
</html>