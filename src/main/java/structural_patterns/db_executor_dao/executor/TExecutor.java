package structural_patterns.db_executor_dao.executor;

import java.sql.*;
import java.util.Map;

/**
 * Абстрактный исполнитель запросов к БД
 */
public class TExecutor{
    private final Connection connection;

    public TExecutor(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param update
     * @throws SQLException
     */
    public void execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
    }

    /**
     * Пример использования транзакций
     * @param sql
     * @param values
     * @return
     */
    public int executeUpdate(String sql, Map<Integer, String> values)
    {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            for (Integer key : values.keySet()) {
                statement.setString(key, values.get(key));
                statement.executeUpdate();
            }
            statement.close();
            connection.commit();
        } catch (SQLException e)
        {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * Выполнить запрос SELECT к БД
     * @param query запрос для выполнения
     * @param handler обработчик результата запроса
     * @param <T> тип возвращаемого объекта
     * @return полученный из запроса набор объектов
     * @throws SQLException
     */
    public <T> T executeQuery(String query, TResultHandler<T> handler) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();
        T result = handler.handle(resultSet);
        resultSet.close();
        statement.close();
        return result;
    }
}
