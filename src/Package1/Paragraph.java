package Package1;

public class Paragraph implements Element {
    private String _paragraphName;
    private AlignStrategy _strategy;

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

    public void SetStrategy(AlignStrategy Strategy){
        _strategy = Strategy;
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
}
