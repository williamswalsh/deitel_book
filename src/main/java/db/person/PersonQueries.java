package db.person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    private static final String DB_USR = "root";
    private static final String DB_PWD = ""; // toor
    private Connection connection;
    private PreparedStatement selectPeopleBySalaryBracket;
    private PreparedStatement selectAllPeople;

    public PersonQueries() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);

            selectAllPeople = connection.prepareStatement("SELECT * FROM company.employee");

            selectPeopleBySalaryBracket = connection.prepareStatement("SELECT * FROM company.employee where employee.salary > ?");
            selectPeopleBySalaryBracket.setInt(1, 50000);

            ResultSet rs = selectPeopleBySalaryBracket.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (i > 1)
                        System.out.print(",  ");
                    System.out.print(rs.getString(i));
                }
                System.out.println("");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<Person> getAllPeople() {
        ArrayList<Person> personList = new ArrayList<Person>();
        ResultSet rs = null;
        try {
            rs = selectAllPeople.executeQuery();
            while (rs.next()) {
                personList.add(new Person(
                        rs.getInt("addressID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phoneNumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
                closeConnection();
            }

        }


        return null;
    }

    private void closeConnection() {
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new PersonQueries();
    }
}
