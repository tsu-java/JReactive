package ge.tsu.reactive;

import java.util.function.Consumer;

public class Subscription<T> {

    private Thread th;

    public Subscription(Consumer<Observer<T>> next, Subscriber<T> subscriber) {
        th = new Thread(() -> next.accept(subscriber));
        th.start();
    }

    public void unsubscribe() {
        th.interrupt();
    }
}
