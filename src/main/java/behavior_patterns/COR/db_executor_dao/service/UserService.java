package behavior_patterns.COR.db_executor_dao.service;

import behavior_patterns.COR.db_executor_dao.DBConnectionStore;
import behavior_patterns.COR.db_executor_dao.DBException;
import behavior_patterns.COR.db_executor_dao.dao.UserDao;
import behavior_patterns.COR.db_executor_dao.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private Connection connection;

    public UserService() {
        this.connection = DBConnectionStore.getInstance().getConnection();
    }

    public User getUser(long id) throws DBException {
        try {
            return (new UserDao(DBConnectionStore.getInstance().getConnection()).get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long addUser(String name) throws DBException {
        try {
            connection.setAutoCommit(false);
            UserDao dao = new UserDao(DBConnectionStore.getInstance().getConnection());
            dao.createTable();
            dao.insert(new User(name));
            connection.commit();
            return dao.getId(name);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public void cleanUp() throws DBException {
        UserDao dao = new UserDao(connection);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
