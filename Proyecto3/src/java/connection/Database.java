package connection;

import java.sql.*;

public class Database {

    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    private java.sql.Connection link;

    private final String host;
    private final String user;
    private final String password;
    private final String database;
    private final String url;

    public Database(String host, String user, String password, String database) {

        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;

        this.url = String.format("jdbc:mysql://%s/%s", this.host, this.database);

    }

    public boolean connect() {

        try {

            Class.forName(CLASS_NAME).newInstance();
            this.link = DriverManager.getConnection(this.url, this.user, this.password);

            return true;

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return false;
    }

    public ResultSet retrieve(String query) {

        Statement statement;

        ResultSet result = null;
        String type = query.toUpperCase().substring(0, 6);

        try {

            statement = this.link.createStatement();

            if (type.equals("SELECT")) {
                result = statement.executeQuery(query);
            }

            return result;

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return result;
    }

    public int execute(String query) {

        Statement statement;

        int result = 0;
        String type = query.toUpperCase().substring(0, 6);

        try {

            statement = this.link.createStatement();

            if (type.equals("UPDATE") || type.equals("INSERT") || type.equals("DELETE")) {
                result = statement.executeUpdate(query);
            }

            return result;

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return result;
    }

    public boolean disconnect() {

        try {
            this.link.close();
            return true;
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return false;
    }

}
