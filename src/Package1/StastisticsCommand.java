package Package1;

public class StastisticsCommand implements Command{
    public void execute(){
        BookStatistics stats = new BookStatistics();
        DocumentManager.getInstance().getBook().Accept(stats);
        stats.PrintStatistics();
    }
}
