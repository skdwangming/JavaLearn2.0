package MyThread;

import java.io.*;
import java.net.Socket;

public class Threadclient {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket("localhost", 1234);
        OutputStream outputStream = localhost.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = null;
        while ((line = bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.flush();
        }
    }
}
