//package database;
//
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import static java.sql.DriverManager.getConnection;
//
//public class DBConnection {
//
//    private static final Logger logger = Logger.getLogger (DbConnectFunction.class);
//    private Connection connection;
//
//    /**
//     To connect to a oracle database using thin client
//     * @param server name/ip of database server
//     * @paran port db port
//    e
//     * @param serviceName name of the database service
//     * @param user database user name
//     * @param password database password
//     */
//    public DbConnectFunction(String server, String port, String serviceName, String user, String password) {
//        String driver = "jdbc:oracle:thin:@//";
//        try {
//            Class.forName("oracle.jdbc.oracleDriver");
//            connection = DriverManager.getConnection(driver + server + ":" + port + "/" + serviceName, user, password);
//        } catch (ClassNotFoundException cnfe) {
//            logger.error("Class not found " + cnfe.getCause());
////            Reporter.addStepLog("08 Error: Class not found: \n Please check Logs!!");
//            closeConnection(connection);
//        } catch (SQLException sqlException) {
//            logger.error("Unable to connect to" + driver + server + ":" + port + "/" + serviceName);
//            closeConnection(connection);
//            DBUtils.closeQuitely(connection);
//        }
//        return connection;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public void closeConnection (Connection conn) {
//        try {
//            conn.close();
//        } catch (SQLException sqlException) {
//            // TODO Auto-generated catch block
//            logger.error("Unable to close connection ", sqlException.getCause());
//        }
//    }
//
//}
