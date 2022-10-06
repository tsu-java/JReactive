package ge.tsu.reactive;

public class Main {

    public static void main(String[] args) {
        // Observable
        var observable = new Observable<Integer>(subscriber -> {
            subscriber.next(1);
            subscriber.next(2);
            subscriber.next(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            subscriber.next(4);
            subscriber.error(new Error("Something bad happened!"));
            subscriber.complete();
        });

        // Observer
        Observer<Integer> observer = o -> System.out.println("DOING SOMETHING WITH: " + o);

        // Subscribe method creates Subscription thread object and executes code
        Subscription<Integer> subscription = observable.subscribe(observer);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
        }
        subscription.unsubscribe();
        System.out.println("just after subscribe");
    }
}