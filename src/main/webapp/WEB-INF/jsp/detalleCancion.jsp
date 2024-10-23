<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle Canción</title>
</head>
<body>
<h1>Detalle de la Canción</h1>
<p>Título: ${cancion.titulo}</p>
<p><strong>Artista:</strong> <a href="/artistas/detalle/${cancion.artista.id}">${cancion.artista.nombre} ${cancion.artista.apellido}</a></p>
<p>Álbum: ${cancion.album}</p>
<p>Género: ${cancion.genero}</p>
<p>Idioma: ${cancion.idioma}</p>
<p>Fecha de creación: ${cancion.fechaCreacion}</p>
<p>Fecha de actualización: ${cancion.fechaActualizacion}</p>
<a href="/canciones">Volver a la lista de canciones</a>
<a href="/canciones/formulario/editar/${cancion.id}">Actualizar Canción</a>
<form action="/canciones/eliminar/${cancion.id}" method="post" onsubmit="return confirm('¿Estás seguro de que quieres eliminar esta canción?');">
    <button type="submit">Eliminar Canción</button>
</form>
</body>
</html>
