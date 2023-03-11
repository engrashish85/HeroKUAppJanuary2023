//package database;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.logging.Logger;
//
//public class DBConnection1 {
//
//    private static final Logger logger = Logger.getLogger(String.valueOf(DBConnection1.class));
//
//    public Connection getConnection () {
//        DatabaseProperties dbCredentials = new DatabaseProperties();
//        Connection connection = new DbConnectFunction (dbCredentials.getDbServer(), dbCredentials.getDbPort(),
//                dbCredentials.getObServiceName(), dbCredentials.getDbUser(), dbCredentials.getDbPassword())
//                .getConnection();
//        if (connection == null) {
//            logger.info("DB Connection failed..");
//        } else {
//            logger.info("DB Connection opened..");
//        }
//        return connection;
//    }
//
//    public Connection getInstinctDBConnection() {
//        DatabaseProperties dbCredentials = new DatabaseProperties();
//        Connection connection = new MSSQLConnectFunction(dbCredentials.getInstinctDbServer(), dbCredentials.getInstinctDbPort(),
//                dbCredentials.getInstinctDbüser(), dbCredentials.getInstinctobPassword()).getConnection();
//        if (connection == null) {
//            logger.info("Instinct Connection failed..");
//        } else {
//            logger.info("Instinct Connection opened..");
//        }
//        return connection;
//    }
//
//    public Connection getQASDbConnection() {
//        Connection connection;
//        DatabaseProperties dbCredentials = new DatabaseProperties();
//        connection = new DbQASConnectFunction(dbCredentials.getQasDbServer(), dbCredentials.getQasDbPort(),
//                dbCredentials.getQasDbServiceName(), dbCredentials.getQasDbSchemaName(), dbCredentials.getQasDbUser(),
//                dbCredentials.getDbPassword()).getConnection();
//        logger.info("QAS Connection opened");
//        return connection;
//    }
//
//    public void closeConnection (Connection dbConnection) {
//        try {
//            if (dbConnection != null) {
//                try {
//                    dbConnection.clearWarnings();
//                    dbConnection.close();
//                    dbConnection = null;
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        } finally {
//            DbUtils.closeQuietly(dbConnection);
//            logger.info("Connection closed.........");
//        }
//    }
//}
