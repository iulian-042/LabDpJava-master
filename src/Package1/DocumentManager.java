package Package1;

public class DocumentManager {
    private static DocumentManager instance;
    public Element book;
    public static DocumentManager getInstance(){
        if(instance == null)
            instance = new DocumentManager();
        return instance;
    }
    public Element getBook(){
        return this.book;
    }
    public void setBook(Element book){
        this.book = book;
    }
}
