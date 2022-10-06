package ge.tsu.reactive;

public interface Observer<T> {

    void next(T o);

    default void error(Error e) {
    }

    default void complete() {
    }
}
