package converter.textParser;

import java.util.List;

public interface Parsable <T>{

    List<T> doParse(String text);

}
