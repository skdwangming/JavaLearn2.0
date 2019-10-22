package MyIO;

import org.junit.jupiter.api.Test;

import java.io.*;

public class MyIO {

    @Test
    public void test1() throws IOException {

        byte[] bytes = {1, 2, 2, 3, 22, 42};
        FileOutputStream test1 = new FileOutputStream("readFile.txt");
        for (int i = 0; i < bytes.length; i++) {
            test1.write(bytes[i]);
        }
        test1.close();

        FileInputStream fileInputStream = new FileInputStream("readFile.txt");
        int size = fileInputStream.available();
        for (int i = 0; i < size; i++) {
            System.out.println(fileInputStream.read());
        }
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("readFile.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes))!=-1){

            System.out.println(new String(bytes,0,len));
        }
        fileInputStream.close();

    }

    @Test
    public void writeFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("writeFile.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write("我是王铭".getBytes());
        bufferedOutputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void readFileByChar() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("readFile.txt"));
        char[] chars = new char[1024];
        int len ;
        while ((len = inputStreamReader.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
    }

    @Test
    public void readFileByChar2() throws IOException {
        FileReader fileReader = new FileReader("readFile.txt");
        char[] bytes = new char[1024];
        int len;
        while ((len = fileReader.read(bytes) )!= -1){
            System.out.println(new String(bytes,0,len));
        }
        fileReader.close();
    }

    @Test
    public void readFileByChar3() throws IOException{
        FileReader fileReader = new FileReader("readFile.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine())!= null){
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }

    @Test
    public void writeFileByChar() throws IOException{
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("writeFile.txt"));
        outputStreamWriter.write("ig牛逼");
        outputStreamWriter.close();
    }
}
