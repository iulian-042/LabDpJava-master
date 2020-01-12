package Package1;

public class DeleteCommand implements Command {
    private Memento state = new Memento();

    public DeleteCommand() {
    }

    public void execute() {
        this.state.setState(DocumentManager.getInstance().getBook());
        ((Section)DocumentManager.getInstance().getBook()).removeLast();
        DocumentManager.getInstance().addCommand(this);
    }

    public void unexecute() {
        DocumentManager.getInstance().setBook(this.state.getState());
    }

    public Memento getMemento() {
        return this.state;
    }
}
