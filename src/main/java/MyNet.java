import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;
import java.util.Enumeration;


public class MyNet {


    @Test
    public void test1() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inetAddress.getHostAddress());


    }

    @Test
    public void test2() {
        Socket Skt;
        String host = "localhost";
        for (int i = 8000; i < 8005; i++) {
            try {
                System.out.println("查看 " + i);
                Skt = new Socket(host, i);
                System.out.println("端口 " + i + " 已被使用");
            } catch (UnknownHostException e) {
                System.out.println("Exception occured" + e);
                break;
            } catch (IOException e) {

            }
        }

    }

    @Test
    public void test3() throws IOException {
        String hostName = "localhost";
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostName, 8080);
        Socket socket = new Socket();
        socket.connect(inetSocketAddress, 2000);
        socket.close();


    }

    @Test
    public void test4() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
    }

    @Test
    public void test5() throws SocketException {
        Enumeration<NetworkInterface> e=NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }

    @Test
    public void test6() throws IOException {
        URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        URLConnection urlConnection = url.openConnection();
        Object content = urlConnection.getContent();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);


        File file = new File("a.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes))!= -1){
            bufferedOutputStream.write(bytes,0,len);
        }

        inputStream.close();
        fileOutputStream.close();

        bufferedInputStream.close();


    }

    @Test
    public void test7() throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        FileWriter ss = new FileWriter("ss");



    }
}

