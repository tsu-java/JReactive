package ge.tsu.reactive;

import java.util.function.Consumer;

public final class Observable<T> {

    private Consumer<Observer<T>> next;

    public Observable(Consumer<Observer<T>> next) {
        this.next = next;
    }

    public Subscription<T> subscribe(Observer<T> observer) {
        return new Subscription<>(next, new Subscriber<>(observer));
    }
}
