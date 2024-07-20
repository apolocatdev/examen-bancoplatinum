package platinum.ctacorriente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rutEjecutivo = request.getParameter("rutEjecutivo");
        String nombre = request.getParameter("nombre");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cuentas_clientes", "root", "password")) {
            String sql = "SELECT * FROM ejecutivo WHERE rutEjecutivo = ? AND nombre = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, rutEjecutivo);
                stmt.setString(2, nombre);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    request.getSession().setAttribute("ejecutivo", nombre);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=1");
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
