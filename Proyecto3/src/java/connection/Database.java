package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    private java.sql.Connection link;
    private Statement statement;

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

    public Object execute(String query) {

        Object result = null;
        String type = query.toUpperCase().substring(0, 6);

        try {

            this.statement = this.link.createStatement();

            if (type.equals("UPDATE") || type.equals("INSERT") || type.equals("DELETE")) {
                result = this.statement.executeUpdate(query);
            } else if (type.equals("SELECT")) {
                result = this.statement.executeQuery(query);
            }

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
