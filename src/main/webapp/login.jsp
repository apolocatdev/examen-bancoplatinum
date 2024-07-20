<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <label for="rutEjecutivo">RUT Ejecutivo:</label>
        <input type="text" id="rutEjecutivo" name="rutEjecutivo" required><br>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <input type="submit" value="Login">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Error en el login</p>
    <% } %>
</body>
</html>
