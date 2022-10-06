package ge.tsu.reactive;

public class Main {
    
    public static void main(String[] args) {
        // Observer patter usage (behavioural)
        var observable = new Observable<Integer>(subscriber -> {
            subscriber.next(1);
            subscriber.next(2);
            subscriber.next(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            subscriber.next(4);
            subscriber.error(new Error("Something bad happened!"));
            subscriber.complete();
        });

        System.out.println("just before subscribe");
        observable.subscribe(
                next -> {
                    System.out.println("Do some stuff with variable: " + next);
                },
                error -> {
                    System.out.println(error.getMessage());
                },
                () -> {
                    System.out.println("Completed stuff");
                });
        System.out.println("just after subscribe");
    }
}