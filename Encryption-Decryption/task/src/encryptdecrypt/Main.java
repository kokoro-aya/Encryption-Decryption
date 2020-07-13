package encryptdecrypt;

import java.util.Scanner;

public class Main {

    static String convert(String src, int key) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        int key = sc.nextInt();
        System.out.println(convert(src, key));
    }
}
