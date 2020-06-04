import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {
    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("启动服务器");
        Socket s = serverSocket.accept();
        InputStream inputStream = s.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();
        System.out.println("接受信息："+line);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("服务端接收到信息："+line+"\n");//     \n的作用是将信息发送过去，不写会一直卡在这里
        bw.flush();

    }

    @Test
    public void client() throws Exception {
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("client向server发送信息\n");//      \n的作用是将信息发送过去，不写会一直卡在这里
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        System.out.println("server返回的数据为："+line);
    }

}
