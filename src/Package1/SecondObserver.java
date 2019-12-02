package Package1;

public class SecondObserver implements Observer {
    private String soName;
    SecondObserver(String soName){
        this.soName = soName;
    }
    public void update(String oldValue, String newValue){
        System.out.println("Old value: " + oldValue + ", new value: " + newValue + " Observer name: " + this.soName);
    }
}
