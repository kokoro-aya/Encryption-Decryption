package encryptdecrypt;

public class Shift implements Algorithms {
    @Override
    public String encode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (c + key <= 'z') {
                    dst += (char) (c + key);
                } else {
                    dst += (char) ('a' + c + key - 'z' - 1);
                }
            }
            else {
                dst += c;
            }
        }
        return dst;
    }

    @Override
    public String decode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (c - key >= 'a') {
                    dst += (char) (c - key);
                } else {
                    dst += (char) ('z' - ('a' - (c - key)) + 1);
                }
            }
            else {
                dst += c;
            }
        }
        return dst;
    }
}
