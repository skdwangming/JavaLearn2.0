import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaNet {
//    public static void main(String[] args) {
//        String urlStr = "https://www.baidu.com";
//        StringBuffer sb = null;
//        URL url = null;
//        InputStream inputStream = null;
//        BufferedReader bufferedReader = null;
//        InputStreamReader inputStreamReader = null;
//        try {
//            sb = new StringBuffer();
//            url = new URL(urlStr);
//            inputStream = url.openStream();
//            inputStreamReader = new InputStreamReader(inputStream, "Utf-8");
//            bufferedReader = new BufferedReader(inputStreamReader);
//            String s = null;
//            while ((s = bufferedReader.readLine()) != null) {
//                sb.append(s);
//            }
//            System.out.println(sb);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if ((bufferedReader != null)) {
//                    bufferedReader.close();
//                }
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public static void main(String[] args) {
        /** 网络的url地址 */
        URL url = null;
        /** http连接 */
        HttpURLConnection httpConn = null;
        /**//** 输入流 */
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL("http://www.baidu.com");
            in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }

    @Test
    public void test1(){
        String urlStr = "https://www.runoob.com/java/net-url-header.html";
        URL url = null;
        URLConnection urlConnection = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            urlConnection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        Set<String> strings = headerFields.keySet();
        for(String s : strings){
            String headerField = urlConnection.getHeaderField(s);
            System.out.println(s+"  ==>>  "+headerField);

        }
    }

    @Test
    public void test2() throws Exception{
        String urlStr = "https://www.runoob.com/java/net-url.html";
        URL url = new URL(urlStr);
        System.out.println(url.getPort());
    }
}