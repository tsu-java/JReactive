package ge.tsu.reactive;

public interface ISubscriber<T> {

    void next(T o);

    void error(Error e);

    void complete();
}
