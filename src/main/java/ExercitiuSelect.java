import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExercitiuSelect {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM oameni "; // WHERE nume = 'delia'";
        ResultSet result = statement.executeQuery(query);
        // result.next()   1) muta iteratorul
        //                 2) returneaza true daca linia exista
        while(result.next()){
            int id = result.getInt("id");
            String nume = result.getString("nume");
            int varsta = result.getInt("varsta");
            System.out.println("id = " + id+ "  nume  = " + nume+"  varsta =  "+varsta );


        }

    }
}
