package behavior_patterns.COR.impl;

import behavior_patterns.COR.ICorExec;
import behavior_patterns.COR.ICorWorker;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * Реализация цепочки (chain), которая исполняет свои вложенные цепочки и рабочие
 */
public class CorChain<T> extends ICorWorker<T> {
    private final List<ICorExec<T>> execs;
    private final Predicate<T> blockOn = (t) -> true;
    private final BiConsumer<T, Throwable> blockExcept = (t, e) -> {};

    public CorChain(List<ICorExec<T>> execs, String title, String description) {
        super(title, description);
        this.execs = execs;
    }

    public CorChain(String title, List<ICorExec<T>> execs) {
        super(title);
        this.execs = execs;
    }

    @Override
    protected boolean on(T context) {
        return blockOn.test(context);
    }

    @Override
    protected void handle(T context) {
        execs.forEach(it -> it.exec(context));
    }

    @Override
    protected void except(T context, Throwable e) {
        blockExcept.accept(context, e);
    }
}
