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
                    String message = "What?";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            operate = false;
                            message = "Good Bye!";
                        }
                        if (str.contains("Hello")) {
                            message = "Hello, dear friend!";
                            break;
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(message.getBytes());
                }
            }
        }
    }
}