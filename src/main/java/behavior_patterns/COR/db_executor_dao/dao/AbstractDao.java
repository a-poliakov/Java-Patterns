package behavior_patterns.COR.db_executor_dao.dao;

import java.sql.SQLException;

public interface AbstractDao<T> {
    public T get(long id) throws SQLException;

    public long getId(String title) throws SQLException;

    public void insert(T obj) throws SQLException;

    public void createTable() throws SQLException;

    public void dropTable() throws SQLException;
}
