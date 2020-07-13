package encryptdecrypt;

public class Main {

    static String convert(String src) {
        String dst = "";
        for (char c: src.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                dst += (char)('a' + ('z' - c));
            }
            else {
                dst += c;
            }
        }
        return dst;
    }

    public static void main(String[] args) {
        String src = "we found a treasure!";
        System.out.println(convert(src));
    }
}
