package encryptdecrypt;

public class Unicode implements Algorithms {
    @Override
    public String encode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            dst += (char) (c + key);
        }
        return dst;
    }

    @Override
    public String decode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            dst += (char) (c - key);
        }
        return dst;
    }
}
