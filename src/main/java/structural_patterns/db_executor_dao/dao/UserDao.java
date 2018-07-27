package structural_patterns.db_executor_dao.dao;

import structural_patterns.db_executor_dao.entity.User;
import structural_patterns.db_executor_dao.executor.TExecutor;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao implements AbstractDao<User> {
    private TExecutor executor;

    public UserDao(Connection connection) {
        this.executor = new TExecutor(connection);
    }

    public User get(long id) throws SQLException {
        return executor.executeQuery("select * from users where id=" + id, result -> {
            result.next();
            return new User(result.getLong(1), result.getString(2));
        });
    }

    @Override
    public long getId(String title) throws SQLException {
        return executor.executeQuery("select * from users where user_name='" + title + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    @Override
    public void insert(User obj) throws SQLException {
        executor.execUpdate("insert into users (user_name) values ('" + obj.getName() + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
