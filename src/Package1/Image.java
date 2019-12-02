package Package1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Observable {
    private String _imageName;
    private String _oldImageName;
    public ArrayList<Observer> observers = new ArrayList<>();

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image(String imageName){
        _imageName = imageName;

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void setNewValue(String newValue) {
        this._oldImageName = this._imageName;
        this._imageName = newValue;
        notifyObservers();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    public void notifyObservers(){
        for(Observer obs : observers){
            obs.update(this._oldImageName, this._imageName);
        }
    }


    @Override
    public void print() {
        System.out.println("Image name: "+get_imageName());
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
}
