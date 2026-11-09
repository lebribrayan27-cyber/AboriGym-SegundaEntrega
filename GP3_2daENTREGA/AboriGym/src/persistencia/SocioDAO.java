package persistencia;
import java.sql.*;
import modelo.Socio;
public class SocioDAO {
    public void insertar(Socio socio) throws SQLException {
        String sql = "INSERT INTO Socios(DNI,Nombre,Apellido,Edad,Correo,Telefono,Estado) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,socio.getDni());ps.setString(2,socio.getNombre());ps.setString(3,socio.getApellido());
            ps.setInt(4,socio.getEdad());ps.setString(5,socio.getCorreo());ps.setString(6,socio.getTelefono());ps.setBoolean(7,socio.getEstado());ps.executeUpdate();
        }
    }
    public void listar() throws SQLException {
        try (Connection con=Conexion.conectar(); Statement st=con.createStatement();ResultSet rs=st.executeQuery("SELECT ID_Socio,Nombre,Apellido FROM Socios")) {
            while(rs.next()) System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" "+rs.getString(3));
        }
    }
}
