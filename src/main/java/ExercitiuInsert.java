import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExercitiuInsert {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();

        String query = "INSERT INTO oameni VALUES (null, 'delia', 15)";

        boolean execute = statement.execute(query);
    }
}
