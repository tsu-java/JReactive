package ge.tsu.reactive;

import java.util.function.Consumer;

public final class Observable<T> {

    private Consumer<Subscriber<T>> subscriber;

    public Observable(Consumer<Subscriber<T>> subscriber) {
        this.subscriber = subscriber;
    }

    public void subscribe(Subscriber<T> s) {
        subscriber.accept(s);
    }

    public void subscribe(Consumer<T> next) {
        subscriber.accept(new Subscriber<T>(next));
    }

    public void subscribe(Consumer<T> next, Consumer<Error> error) {
        subscriber.accept(new Subscriber<T>(next, error));
    }

    public void subscribe(Consumer<T> next, Consumer<Error> error, Runnable complete) {
        subscriber.accept(new Subscriber<T>(next, error, complete));
    }

    public void subscribe(Consumer<T> next, Runnable complete) {
        subscriber.accept(new Subscriber<T>(next, null, complete));
    }
}
