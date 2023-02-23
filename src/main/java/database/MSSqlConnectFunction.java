package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSqlConnectFunction {
    private static final Logger logger = Logger.getLogger(MSSqlConnectFunction.class);
    private Connection connection;

    /**
     * . To connect to a oracle database using thin client
     * Boaran server name/ip of database server
     * paran port db port
     * Oparan servicelione name of the database service
     * Opacan user database user name
     * Bparan password database password
     */
    public MSSqlConnectFunction(String server, String port, String user, String password) {
        try {
            if (connection == null) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUrl = "jdbc:sqlserver://server+" + ":" + port + ";user=" + user + ";password=" + password + "";
                connection = DriverManager.getConnection(dbUrl);
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.info(e.getCause());
            logger.info(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
