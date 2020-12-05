package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean operate = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (operate) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    //noinspection CheckStyle
                    while (!(str = in.readLine()).isEmpty()) {
                            System.out.println(str);
                            if (str.contains("Bye")) {
                                operate = false;
                            }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}