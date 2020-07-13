package encryptdecrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String method = sc.nextLine();
//        String src = sc.nextLine();
//        int key = sc.nextInt();
        String mode = null;
        Integer key = null;
        String data = null;
        String in = null;
        String out = null;
        String algo = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
            if (args[i].equals("-in")) {
                in = args[i + 1];
            }
            if (args[i].equals("-out")) {
                out = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                algo = args[i + 1];
            }
        }
        if (algo == null)
            algo = "shift";
        if (mode == null)
            mode = "enc";
        if (key == null)
            key = 0;
        if (data == null && in == null)
            data = "";
        if (data == null) {
            Path path = Paths.get(in);
            try {
                data = Files.readString(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Algorithms alg = null;
        if (algo.equals("shift")) {
            alg = new Shift();
        } else {
            alg = new Unicode();
        }
        if (mode.equals("enc")) {
            if (out == null) {
                System.out.println(alg.encode(data, key));
            } else {
                try {
                    Files.write(Paths.get(out), alg.encode(data, key).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (mode.equals("dec")) {
            if (out == null) {
                System.out.println(alg.decode(data, key));
            } else {
                try {
                    Files.write(Paths.get(out), alg.decode(data, key).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
