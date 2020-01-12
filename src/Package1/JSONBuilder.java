package Package1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class JSONBuilder implements Builder{
    Element document;
    String filename;
    public JSONBuilder(String filename){
        this.filename = filename;
    }

    public Element processMap(HashMap<String, Object> map) {
        if(((String)map.get("class")).equalsIgnoreCase("Section")){
            return buildSection(map);
        }
        if(((String)map.get("class")).equalsIgnoreCase("Table")){
            return buildTable(map);
        }
        if(((String)map.get("class")).equalsIgnoreCase("Paragraph")){
            return buildParagraph(map);
        }
        if(((String)map.get("class")).equalsIgnoreCase("ImageProxy")){
            return buildImageProxy(map);
        }
        if(((String)map.get("class")).equalsIgnoreCase("Image")){
            return buildImage(map);
        }
        return null;
    }

    public Element buildSection(HashMap<String, Object> map) {
        Section section = new Section((String)map.get("title"));
        Collection<HashMap<String, Object>> children = (Collection)map.get("children");
        children.forEach((childMap) -> {

            Element e = this.processMap(childMap);
            if (e != null) {
                try {
                    section.AddElement(e);
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        });
        return section;
    }
    public Element buildTable(HashMap<String, Object> map) {
        Table table = new Table((String)map.get("text"));
        return table;
    }
    public Element buildImage(HashMap<String, Object> map) {
        Image image = new Image((String)map.get("url"));
        return image;
    }
    public Element buildParagraph(HashMap<String, Object> map) {
        Paragraph para = new Paragraph((String)map.get("text"));
        return para;
    }
    public Element buildImageProxy(HashMap<String, Object> map) {
        ImageProxy imageProxy = new ImageProxy((String)map.get("url"));
        return imageProxy;
    }

    public Element getResult() {
        return document;
    }
    public void build() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> map = mapper.readValue(new File(filename),
                    HashMap.class);
            document = processMap(map);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
