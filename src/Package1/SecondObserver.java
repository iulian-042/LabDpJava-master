package Package1;

public class SecondObserver implements Observer {
    public SecondObserver() {
    }

    public void update(String oldValue, String newValue) {
        System.out.println("From SecondObserver " + oldValue + "   " + newValue);
    }
}
