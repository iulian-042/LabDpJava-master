package Package1;

public class Paragraph implements Element {
            private String _paragraphName;
            private AlignStrategy alignStrategy;
            public String get_paragraphName() {
                return _paragraphName;
            }

            public void set_paragraphName(String _paragraphName) {
                this._paragraphName = _paragraphName;
            }

    public Paragraph(String paragraphName){
                _paragraphName = paragraphName;
            }

            public void setAlignStrategy(AlignStrategy alignStrategy){
                this.alignStrategy = alignStrategy;
            }

            @Override
            public void print() {
                if(alignStrategy != null)
                    alignStrategy.print(this._paragraphName);
                else
            System.out.println("Table name: "+get_paragraphName());
    }
}
