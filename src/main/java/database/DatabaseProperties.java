package database;

import files.util.Globals;
import files.util.PropertyFileReader;

import java.io.IOException;
import java.util.Map;

public class DatabaseProperties {
    private static Map<String, String> config;
    private static String dbServer = null;
    private static String dbPort = null;
    private static String dbServiceName = null;
    private static String dbUser = null;
    private static String dbPassword = null;
    private static String instinctDbServer = null;
    private static String instinctobPort = null;
    private static String instinctobUser = null;
    private static String instinctDbPassword = null;
    private static String qasDbServer = null;
    private static String qasDbPort = null;
    private static String qasDbServiceName = null;
    private static String qasDbSchemaName = null;
    private static String qasDbUser = null;
    private static String qasDbPassword = null;

    /**
     * Constructor accessible by subclasses.
     *
     * @param config file path for config file
     */
    public DatabaseProperties() {
        try {
            DatabaseProperties.config = PropertyFileReader.readProperties(Globals.CONFIG_LOCATION.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        DatabaseProperties.dbServer = DatabaseProperties.config.get("db.server");
        DatabaseProperties.dbPort = DatabaseProperties.config.get("db.port");
        DatabaseProperties.dbServiceName = DatabaseProperties.config.get("db.serviceName");
        DatabaseProperties.dbUser = DatabaseProperties.config.get("db.user");
        DatabaseProperties.dbPassword = DatabaseProperties.config.get("db.password");
        DatabaseProperties.instinctDbServer = DatabaseProperties.config.get("instinct.db.server");
        DatabaseProperties.instinctobPort = DatabaseProperties.config.get("instinct.db.port");
        DatabaseProperties.instinctobUser = DatabaseProperties.config.get("instinct.db.user");
        DatabaseProperties.instinctDbPassword = DatabaseProperties.config.get("instinct.db.password");
        qasDbServer = DatabaseProperties.config.get("qas.db.server");
        qasDbPort = DatabaseProperties.config.get("qas.db.port");
        qasDbServiceName = DatabaseProperties.config.get("qas.db.serviceName");
        qasDbSchemaName = DatabaseProperties.config.get("qas.db.schenaName");
        qasDbUser = DatabaseProperties.config.get("qas.db.user");
        qasDbPassword = DatabaseProperties.config.get("qas.db.password");
    }

    public String getDbServer() {
        return DatabaseProperties.dbServer;
    }

    /**
     * • Gets the 'dbPort' variable value from config file
     * return 'dbPort' if present in the config file
     */
    public String getDbPort() {
        return DatabaseProperties.dbPort;
    }

    // Add all the others too like this
}