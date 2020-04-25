package db;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.io.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RowSetTest {
    private static final String DB_URL = "jdbc:mysql://host:3306/schema";
    private static final String DB_USR = "user";
    private static final String DB_PWD = "pwd";

    public RowSetTest() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myFile"));   // Overwrites file

            JdbcRowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USR);
            rowSet.setPassword(DB_PWD);
            rowSet.setCommand("Select * from organisation;");       // SQL statement
            rowSet.execute();

            ResultSetMetaData metaData = rowSet.getMetaData();
            int numColumns = metaData.getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
//                System.out.printf("%-8s\t", metaData.getColumnName(i));
                writer.write(metaData.getColumnName(i) + ",");
            }
//            System.out.println();
            writer.write("\n");

            while (rowSet.next()) {
                for (int i = 1; i <= numColumns; i++) {
//                    System.out.printf("%-8s\t", rowSet.getObject(i));
                    writer.write(rowSet.getObject(i) + ",");
                }
//                System.out.println();
                writer.write("\n");
            }
            rowSet.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new RowSetTest();
    }
}
