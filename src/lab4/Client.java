/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Maslov_16562
 */
public class Client extends Thread {

    public static String input;
    public static Scanner scanner = null;
    public static PrintWriter writer;
    public static Scanner out = new Scanner(System.in);
    public static Socket socket = null;

    public static void main(String[] args) throws Exception {
       // file();

        socket = new Socket("localhost", 8899);
        writer = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(socket.getInputStream());

        while (true) {
            writer.println(out.nextInt());
            writer.println(out.nextInt());
            writer.flush();
            System.out.println(scanner.nextLine());
        }

    }

    public void go() {
        while (true) {
            //input = scanner.nextLine();
            System.out.println(scanner.nextLine());
        }
    }

    public static void file() throws IOException {
        System.out.println("file name");
        String fileName = out.nextLine();
        socket = new Socket("192.168.1.55", 80);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        byte[] byteArray = new byte[15000];
        int in;
        while ((in = bis.read(byteArray)) != -1) {
            bos.write(byteArray,0,in);
        }
        bis.close();
        bos.close();
    }
}
