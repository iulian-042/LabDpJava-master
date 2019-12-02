package Package1;

public class FirstObserver implements Observer {
    private String foName;
    FirstObserver(String foName){
        this.foName = foName;
    }
    public void update(String oldValue, String newValue){
        System.out.println("Old value: " + oldValue + ", new value: " + newValue + " Observer name: " + this.foName);
    }
}
