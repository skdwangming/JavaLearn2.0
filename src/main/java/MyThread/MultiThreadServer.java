package MyThread;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable{
    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket accept = serverSocket.accept();

        PrintStream printStream = new PrintStream(accept.getOutputStream());
        printStream.print(accept.getPort());
    }

    @Test
    public void test1() throws IOException {
        Socket socket = new Socket("localhost",1234);
    }
}
