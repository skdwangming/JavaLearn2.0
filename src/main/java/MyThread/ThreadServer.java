package MyThread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
    }
}

