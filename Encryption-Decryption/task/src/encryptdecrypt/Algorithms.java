package encryptdecrypt;

public interface Algorithms {
    String encode(String src, int key);
    String decode(String src, int dest);
}
