package behavior_patterns.COR.db_executor_dao;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Менеджер соединений с БД
 * позволяет получить соединения к различным БД и хранит в себе созданные соединения
 */
public class DBConnectionStore {
    private static DBConnectionStore ourInstance = new DBConnectionStore();
    private final Connection connection;

    private DBConnectionStore() {
        this.connection = getPostgresConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Получить соединение с БД Postgres
     * @return соединение
     */
    public static Connection getPostgresConnection()
    {
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());
            String url = "jdbc:postgresql://localhost/test";
            Properties props = new Properties();
            props.setProperty("user", "fred");
            props.setProperty("password", "secret");
            props.setProperty("ssl", "true");
            Connection connection = DriverManager.getConnection(url, props);
            return connection;
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.append("jdbc:mysql://")        //db type
                .append("localhost:")          //host name
                .append("3306/")               //port
                .append("db_example?")         //db name
                .append("user=tully&")         //login
                .append("password=tully");     //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getH2Connection() {
        try {
            String url = "jdbc:h2:./h2db";
            String name = "tully";
            String pass = "tully";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printConnectInfo()
    {
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnectionStore getInstance() {
        return ourInstance;
    }
}
