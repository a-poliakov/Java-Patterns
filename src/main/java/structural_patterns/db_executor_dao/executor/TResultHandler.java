package structural_patterns.db_executor_dao.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Обработчик результата запроса к БД
 * @param <T> тип возвращаемое (смэппенного) объекта
 */
public interface TResultHandler <T> {
    /**
     * Обработать resultSet
     * @param resultSet набор данных из БД
     * @return POJO
     * @throws SQLException
     */
    T handle(ResultSet resultSet) throws SQLException;
}
