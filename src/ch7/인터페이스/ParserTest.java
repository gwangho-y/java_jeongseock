package ch7.인터페이스;

interface Parseable {
    // 구문 작업 수행
    public abstract void parse(String fileName);
}

class ParserManager {
    protected static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        }else {
            return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {
    @Override
    public void parse(String fileName) {}
}

class HTMLParser implements Parseable {

    @Override
    public void parse(String fileName) {}
}

class NewXMLParser implements Parseable {

    @Override
    public void parse(String fileName) {

    }
}
public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("XML File");
    }
}
