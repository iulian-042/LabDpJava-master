package Package1;

public class Table implements Element {

    private String _tableName;

    public String get_tableName() {
        return _tableName;
    }

    public void set_tableName(String _tableName) {
        this._tableName = _tableName;
    }

    public Table(String tableName){
        _tableName = tableName;
    }

    @Override
    public void print() {
        System.out.println("Table name: "+get_tableName());
    }
}
