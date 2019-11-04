package Package1;

import java.util.ArrayList;

public class Section implements Element {

    private String _sectionTitle;
    public ArrayList<Element> content;

    public Section(String title){
        this._sectionTitle = title;
        content = new ArrayList<Element>();
    }

    public int AddElement(Element element){
        content.add(element);
        return content.indexOf(element);
    }

    public void RemoveElement(Element element){
        content.remove(element);
    }

    public Element GetElement(int indexOfElement){
        return content.get(indexOfElement);
    }

    public String get_sectionTitle() {
        return _sectionTitle;
    }

    public void set_sectionTitle(String _sectionTitle) {
        this._sectionTitle = _sectionTitle;
    }

    public ArrayList<Element> getContent() {
        return content;
    }

    public void setContent(ArrayList<Element> content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println("Title: "+get_sectionTitle());

        for(var element:content){
            element.print();
        }
    }
}
