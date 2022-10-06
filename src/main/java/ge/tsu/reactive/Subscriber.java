package ge.tsu.reactive;

import java.util.function.Consumer;

public class Subscriber<T> implements ISubscriber<T> {

    protected boolean isCompleted = false;

    private ISubscriber<T> subscriber;

    public Subscriber(Consumer<T> next) {
        this(next, null, null);
    }

    public Subscriber(Consumer<T> next, Consumer<Error> error) {
        this(next, error, null);
    }

    public Subscriber(Consumer<T> next, Consumer<Error> error, Runnable complete) {
        this.subscriber = new ISubscriber<T>() {
            @Override
            public void next(T o) {
                if (next != null) {
                    next.accept(o);
                }
            }

            @Override
            public void error(Error e) {
                if (error != null) {
                    error.accept(e);
                }
            }

            @Override
            public void complete() {
                if (complete != null) {
                    complete.run();
                }
            }
        };
    }

    public Subscriber(ISubscriber<T> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void next(T o) {
        validateCompletion();
        subscriber.next(o);
    }

    @Override
    public void error(Error e) {
        isCompleted = true;
        subscriber.error(e);
    }

    @Override
    public void complete() {
        validateCompletion();
        isCompleted = true;
        subscriber.complete();
    }

    void validateCompletion() {
        if (isCompleted) {
            throw new IllegalStateException("Subscriber completed");
        }
    }
}
