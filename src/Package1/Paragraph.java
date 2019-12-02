package Package1;

import java.util.ArrayList;

public class Paragraph implements Element, Observable {
    private String _paragraphName;
    private String _oldParagraphName;
    private AlignStrategy _strategy;
    public ArrayList<Observer> observers = new ArrayList<>();

    public String get_paragraphName() {
        return _paragraphName;
    }

    public void set_paragraphName(String _paragraphName) {
        this._paragraphName = _paragraphName;
    }

    public Paragraph(String paragraphName){
        _paragraphName = paragraphName;
    }

    @Override
    public void print() {
        System.out.println("Paragraph name: "+get_paragraphName());
        if(_strategy == null){
            System.out.println(_paragraphName);
        }else{
            _strategy.Print(_paragraphName);
        }
    }

    public void setNewValue(String newValue) {
        this._oldParagraphName = this._paragraphName;
        this._paragraphName = newValue;
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
            obs.update(this._oldParagraphName, this._paragraphName);
        }
    }


    public void SetStrategy(AlignStrategy Strategy){
        _strategy = Strategy;
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
}
