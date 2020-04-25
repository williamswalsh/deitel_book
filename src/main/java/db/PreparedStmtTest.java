package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStmtTest {

    private static final String DB_URL = "jdbc:mysql://host:3306/schema";
    private static final String DB_USR = "user";
    private static final String DB_PWD = "pwd";

    public static void main(String[] args) throws SQLException {
//        PreparedStatement preparedStatement = new PreparedStatement();        WRONG
        Connection connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from organisation where external_id=? ");

        preparedStatement.setString(1, "digitary.net"); // 1-based index 1,2,3,4,5


//        preparedStatement.executeQuery();
//     * @return a <code>ResultSet</code> object that contains the data produced by the
//     *         query; never <code>null</code>

//        preparedStatement.executeUpdate();
//  * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
//   *            or (2) 0 for SQL statements that return nothing
    }
}
