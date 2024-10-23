<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>
    <h1>Agregar Artista</h1>
    <form:form method="post" modelAttribute="artista" action="/artistas/procesa/agregar">
        <form:input path="nombre" placeholder="Nombre" required="true"/>
        <form:input path="apellido" placeholder="Apellido" required="true"/>
        <form:input path="biografia" placeholder="Biografía" required="true"/>

        <button type="submit">Agregar Artista</button>
    </form:form>
    <a href="/artistas">Volver a la lista de artistas</a>
</body>
</html>
