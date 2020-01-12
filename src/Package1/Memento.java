package Package1;

public class Memento {
    private Element state;

    public Memento() {
    }

    public Element getState() {
        return this.state;
    }

    public void setState(Element state) {
        this.state = state.copy();
    }
}
