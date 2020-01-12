package Package1;

import java.util.Stack;

public class DocumentManager {
    private static DocumentManager instance;
    private Element book;
    private FirstObserver observer1 = new FirstObserver();
    private SecondObserver observer2 = new SecondObserver();
    private Stack<Command> undoCommands = new Stack();
    private Stack<Command> redoCommands = new Stack();

    private DocumentManager() {
    }

    public static DocumentManager getInstance() {
        if (instance == null) {
            instance = new DocumentManager();
        }

        return instance;
    }

    public Element getBook() {
        return this.book;
    }

    public void setBook(Element book) {
        this.book = book;
    }

    public FirstObserver getObserver1() {
        return this.observer1;
    }

    public void setObserver1(FirstObserver observer1) {
        this.observer1 = observer1;
    }

    public SecondObserver getObserver2() {
        return this.observer2;
    }

    public void setObserver2(SecondObserver observer2) {
        this.observer2 = observer2;
    }

    public void addCommand(Command newCommand) {
        this.undoCommands.push(newCommand);
    }

    public Command getLastCommand() {
        return (Command)this.undoCommands.pop();
    }

    public void addRCommand(Command newCommand) {
        this.redoCommands.push(newCommand);
    }

    public Command getLastRCommand() {
        return (Command)this.redoCommands.pop();
    }
}
