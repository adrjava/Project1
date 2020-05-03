import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExempluUpdate {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();

        String query = "UPDATE oameni SET nume = 'viorel' , varsta = 14 WHERE nume = 'adrian'";

        int nrLiniiModificate = statement.executeUpdate(query);
        System.out.println(nrLiniiModificate);
    }
}
