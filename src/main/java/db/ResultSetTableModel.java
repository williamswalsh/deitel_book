package db;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numRows;
    private boolean connected;

    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
        connected = false;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        connected = true;
        setQuery(query);
    }

    public void setQuery(String query) throws SQLException {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        resultSet = statement.executeQuery(query);
        metaData = resultSet.getMetaData();

        resultSet.last();
        numRows = resultSet.getRow();

//        Method inherited from AbstractTableModel
        fireTableStructureChanged();
    }

    public void disconnectFromDB(){
        if(connected){
            try{
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connected = false;
            }
        }
    }

    public Class getColumnClass(int column) {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        try {
            String className = metaData.getColumnClassName(column);
            return Class.forName(className);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Object.class;
    }

    @Override
    public int getColumnCount() {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        try{
            return metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getColumnName(int column) {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        try{
            return metaData.getColumnName(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        return numRows;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (!connected)
            throw new IllegalStateException("Not connected to database.");

        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
