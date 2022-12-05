package structural_patterns.COR.impl;

import lombok.Getter;
import lombok.Setter;
import structural_patterns.COR.ICorWorker;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Setter
@Getter
public class CorWorker<T> extends ICorWorker<T> {
    private Predicate<T> blockOn = (t) -> true;
    private final BiConsumer<T, Throwable> blockExcept = (t, e) -> {};
    private Consumer<T> blockHandle = (t) -> {};

    public CorWorker(String title, Predicate<T> blockOn, Consumer<T> blockHandle) {
        super(title);
        this.blockOn = blockOn;
        this.blockHandle = blockHandle;
    }

    public CorWorker(String title, Consumer<T> blockHandle) {
        super(title);
        this.blockHandle = blockHandle;
    }

    public CorWorker(String title, String description, Consumer<T> blockHandle) {
        super(title, description);
        this.blockHandle = blockHandle;
    }

    public CorWorker(String title, String description) {
        super(title, description);
    }

    public CorWorker(String title) {
        super(title);
    }

    @Override
    protected boolean on(T context) {
        return blockOn.test(context);
    }

    @Override
    protected void handle(T context) {
        blockHandle.accept(context);
    }

    @Override
    protected void except(T context, Throwable e) {
        blockExcept.accept(context, e);
    }
}
