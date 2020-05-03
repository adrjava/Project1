import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExercitiuDelete {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();

        String query = "DELETE FROM oameni WHERE nume ='delia'";

        int nrLiniiModificate = statement.executeUpdate(query);
        System.out.println(nrLiniiModificate);
    }
}
