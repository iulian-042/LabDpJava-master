package Package1;

public class UndoCommand implements Command {
    public UndoCommand() {
    }

    public void execute() {
        DocumentManager.getInstance().setBook(((DeleteCommand)DocumentManager.getInstance().getLastCommand()).getMemento().getState());
    }

    public void unexecute() {
    }
}
