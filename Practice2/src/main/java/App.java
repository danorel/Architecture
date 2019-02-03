import converter.Converter;

public class App {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println(converter.convert(16, "ff5a", 10));
    }
}
