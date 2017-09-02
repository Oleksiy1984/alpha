package ua.nure.orlovskyi.SummaryTask4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Connection pool holds created connections, because creating a network connection to a database server is expensive.
 */
public class DBConnectionPool {


    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("db");
    private final static Logger LOGGER = LoggerFactory.getLogger(DBConnectionPool.class);
    private static final String URL = BUNDLE.getString("url");
    private static final String USERNAME = BUNDLE.getString("username");
    private static final String PASSWORD = BUNDLE.getString("password");
    private static final BlockingQueue<Connection> QUEUE = new ArrayBlockingQueue<>(Integer.parseInt(BUNDLE.getString("CONNECTION_LIMIT")));
    private Connection connection;

    /**
     * prohibits creating instance of class outside the package
     */
    private DBConnectionPool() {
    }


    /**
     * returns an existing connection if it's not closed.
     * If connection is closed method gets connection by driver manager, and puts it to queue.
     * Then method invokes itself.
     *
     * @return
     * @throws ConnectionPoolException
     */
    public synchronized Connection getConnection() throws ConnectionPoolException {
        try {
            if (!QUEUE.isEmpty()) {
                while (!QUEUE.isEmpty()) {
                    connection = QUEUE.peek();
                    if (connection.isValid(500)) {
                        return connection;
                    }

                }
            } else {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                freeConnection(connection);
                return getConnection();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionPoolException("Cannot get connection");
        }
        return connection;
    }

    public synchronized void freeConnection(Connection connection) throws ConnectionPoolException {
        try {
            if (!connection.isClosed()) {
                QUEUE.add(connection);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("cannot add free connection");
        }
    }

    /**
     * closes connection and removes from queue
     *
     * @throws ConnectionPoolException
     */
    public void closeConnection() throws ConnectionPoolException {
        try {
            if (QUEUE.peek() != null) {
                QUEUE.poll().close();
                LOGGER.info("Connection closed and removed from queue");
            }
        } catch (SQLException e) {
            LOGGER.error("cannot close connection");
            throw new ConnectionPoolException("cannot close connection");
        }
    }

    public void shutdown() {
        try {
            closeConnection();
        } catch (ConnectionPoolException connectionPoolException) {
            LOGGER.error("cannot close connection");
            connectionPoolException.printStackTrace();
        }
    }

    private static class PoolInstanceHolder {
        private static final DBConnectionPool INSTANCE = new DBConnectionPool();

    }

    public static DBConnectionPool getInstance() {
        return PoolInstanceHolder.INSTANCE;
    }
}
