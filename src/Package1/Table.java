package Package1;

import java.util.ArrayList;

public class Table implements Element, Observable {

    private String _tableName;
    private String _oldTableName;
    public ArrayList<Observer> observers = new ArrayList<>();

    public String get_tableName() {
        return _tableName;
    }

    public void set_tableName(String _tableName) {
        this._tableName = _tableName;
    }

    public Table(String tableName){
        _tableName = tableName;
    }

    public void setNewValue(String newValue) {
        this._oldTableName = this._tableName;
        this._tableName = newValue;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    public void notifyObservers(){
        for(Observer obs : observers){
            obs.update(this._oldTableName, this._tableName);
        }
    }

    @Override
    public void print() {
        System.out.println("Table name: "+get_tableName());
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }

    public Element copy() {
        Table newImage = new Table(this._tableName);
        newImage._oldTableName = this._oldTableName;
        newImage.observers.addAll(this.observers);
        return newImage;
    }
}
