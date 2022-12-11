package behavior_patterns.COR;

/**
 * Блок кода, который обрабатывает контекст. Имеет имя и описание
 */
public interface ICorExec<T> {
    void exec(T context);
}
