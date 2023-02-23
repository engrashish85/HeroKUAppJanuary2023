package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbQASConnectFunction {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(MSSqlConnectFunction.class);
    private Connection connection;

    /**
     * . To connect to a oracle database using thin client
     * Boaran server name/ip of database server
     * paran port db port
     * Oparan servicelione name of the database service
     * Opacan user database user name
     * Bparan password database password
     */
    public DbQASConnectFunction(String server, String port, String serviceName, String schemaName, String user, String password) {
        String driver = "jdbc:postgresql://";
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                String dbUrl = driver + port + server + ":" + port + "/" + serviceName + "?currentSchema=" + schemaName;
                connection = DriverManager.getConnection(dbUrl, user, password);
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
