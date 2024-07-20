package platinum.ctacorriente;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombreMascota");
        String monto = request.getParameter("monto");
        String ejecutivo = request.getParameter("ejecutivo");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cuentas_clientes", "root", "password")) {
            conn.setAutoCommit(false);

            String sqlUsuario = "INSERT INTO usuario (nombreUsuario, password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, nombreUsuario);
                stmt.setString(2, password);
                stmt.executeUpdate();
            }

            String sqlPersona = "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlPersona)) {
                stmt.setString(1, rut);
                stmt.setString(2, nombre);
                stmt.setString(3, apellido);
                stmt.setString(4, direccion);
                stmt.setString(5, correo);
                stmt.setString(6, telefono);
                stmt.setString(7, nombreMascota);
                stmt.executeUpdate();
            }

            String sqlCtaCorriente = "INSERT INTO ctaCorriente (rutCliente, monto, ejecutivo) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlCtaCorriente)) {
                stmt.setString(1, rut);
                stmt.setBigDecimal(2, new BigDecimal(monto));
                stmt.setString(3, ejecutivo);
                stmt.executeUpdate();
            }

            conn.commit();
            response.sendRedirect("register.jsp?success=1");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
