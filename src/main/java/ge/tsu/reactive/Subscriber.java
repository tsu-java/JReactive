package ge.tsu.reactive;

public class Subscriber<T> implements Observer<T> {

    private final Observer<T> observer;

    private boolean completed = false;

    public Subscriber(Observer<T> observer) {
        this.observer = observer;
    }

    @Override
    public void next(T o) {
        validateCompletion();
        observer.next(o);
    }

    @Override
    public void error(Error e) {
        completed = true;
        observer.error(e);
    }

    @Override
    public void complete() {
        validateCompletion();
        completed = true;
        observer.complete();
    }

    private void validateCompletion() {
        if (completed) {
            throw new IllegalStateException("Observer completed");
        }
    }
}
