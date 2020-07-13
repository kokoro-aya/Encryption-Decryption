package encryptdecrypt;

import java.util.Scanner;

public class Main {

//    static String convert(String src, int key) {
//        String dst = "";
//        for (char c: src.toCharArray()) {
//            if (Character.isAlphabetic(c)) {
//                if (c + key <= 'z') {
//                    dst += (char) (c + key);
//                } else {
//                    dst += (char) ('a' + c + key - 'z' - 1);
//                }
//            }
//            else {
//                dst += c;
//            }
//        }
//        return dst;
//    }

    static String encode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            dst += (char) (c + key);
        }
        return dst;
    }

    static String decode(String src, int key) {
        String dst = "";
        for (char c: src.toCharArray()) {
            dst += (char) (c - key);
        }
        return dst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String method = sc.nextLine();
        String src = sc.nextLine();
        int key = sc.nextInt();
        if (method.equals("enc")) {
            System.out.println(encode(src, key));
        }
        if (method.equals("dec")) {
            System.out.println(decode(src, key));
        }
    }
}
