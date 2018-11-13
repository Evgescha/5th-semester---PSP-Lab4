/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Maslov_16562
 */
public class Server {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static Scanner scanner;
    private static String request;
    private static PrintWriter writer;
    private static String response;

    public static void main(String[] args) throws Exception {


        serverSocket = new ServerSocket(8899);
        socket = serverSocket.accept();
        scanner = new Scanner(socket.getInputStream());
        writer = new PrintWriter(socket.getOutputStream());
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Ввели а: " + a+" и b " + b);
            int c = a+b;
            request = "Ответ " + c;
            System.out.println("RES:" + request);
            writer.println(request);
            writer.flush();

        }

    }
}
