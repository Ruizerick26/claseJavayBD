import java.sql.*;
public class bdjava {
    static final String db_URL="jdbc:mysql://localhost/POO1";
    static final String usser="root";
    static final String pass="root_bas3";
    static final String query="SELECT * from estudiantes";
    public static void main(String[] args) {
    try(
            Connection conn = DriverManager.getConnection(db_URL,usser,pass);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            ){
        while (rs.next()) {

            System.out.println("id:" + rs.getString("IDest"));
            System.out.println("Nombre:" + rs.getString("Nombreest"));


        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
