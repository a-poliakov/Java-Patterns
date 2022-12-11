package behavior_patterns.COR;

public abstract class ICorWorker<T> implements  ICorExec<T>  {
    protected String title;
    protected String description;

    public ICorWorker(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ICorWorker(String title) {
        this.title = title;
    }

    protected abstract boolean on(T context);
    protected abstract void handle(T context);
    protected abstract void except(T context, Throwable e);

    public void exec(T context) {
        if (on(context)) {
            try {
                handle(context);
            } catch (Throwable e) {
                except(context, e);
            }
        }
    }
}
