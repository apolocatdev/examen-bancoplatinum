<!DOCTYPE html>
<html>
<head>
    <title>Registro de Cliente</title>
</head>
<body>
    <h1>Registro de Cliente</h1>
    <form action="register" method="post">
        
        <label for="nombreUsuario">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required><br>
        
        
        <h2>Información Personal</h2>
        <label for="rut">RUT:</label>
        <input type="text" id="rut" name="rut" required><br>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required><br>
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br>
        <label for="correo">Correo Electrónico:</label>
        <input type="email" id="correo" name="correo" required><br>
        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" required><br>
        <label for="nombreMascota">Nombre de Mascota:</label>
        <input type="text" id="nombreMascota" name="nombreMascota" required><br>

        <h2>Información de Cuenta Corriente</h2>
        <label for="monto">Monto Inicial:</label>
        <input type="number" id="monto" name="monto" step="0.01" required><br>
        <label for="ejecutivo">RUT Ejecutivo:</label>
        <input type="text" id="ejecutivo" name="ejecutivo" required><br>
        
        <input type="submit" value="Registrar">
    </form>
    <% if (request.getParameter("success") != null) { %>
        <p style="color: green;">Registro exitoso</p>
    <% } %>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Error en el registro</p>
    <% } %>
</body>
</html>
