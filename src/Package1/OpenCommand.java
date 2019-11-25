package Package1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class OpenCommand implements Command {
    String filename;
    public OpenCommand(String bookFileName){
        this.filename = bookFileName;
    }
    @Override
    public void execute() {
        Builder jsonBuilder = new JSONBuilder(filename);
        jsonBuilder.build();
        Element myBook = jsonBuilder.getResult();
        DocumentManager.getInstance().setBook(myBook);
    }
}
