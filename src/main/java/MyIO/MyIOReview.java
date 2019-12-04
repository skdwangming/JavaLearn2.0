package MyIO;

import org.junit.jupiter.api.Test;

import java.io.*;

public class MyIOReview {


    @Test
    public void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("README.md"));
//        FileInputStream fileInputStream = new FileInputStream("README.md");
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes))!=-1){
            String s = new String(bytes, 0, length);
            System.out.println(s);
        }
        fileInputStream.close();
    }

    /**
     * 关流时，缓冲流依赖了输入流，所以应该先关闭缓冲流，再关闭输入流。否则如果先关输入流，缓冲流没有了依赖，会出问题。
     * @throws IOException
     */
    @Test
    public void readFile2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("README.md"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = bufferedInputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,length));
        }
        bufferedInputStream.close();
        fileInputStream.close();
    }

    @Test
    public void readFile3() throws IOException {
        FileReader fileReader = new FileReader("writeFile.txt");
        char[] chars = new char[1024];
        int length;
        while ((length = fileReader.read(chars))!=-1){
            System.out.println(new String(chars,0,length));
        }
        fileReader.close();
    }

    @Test
    public void test4() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("writeFile.txt"));
        char[] chars = new char[1024];
        int length;
        while ((length = inputStreamReader.read(chars))!=-1){
            System.out.println(new String(chars,0,length));
        }
        inputStreamReader.close();

    }

    @Test
    public void copyFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src.txt"));
        bufferedWriter.write("i am iron man");
        bufferedWriter.close();

        FileInputStream fileInputStream = new FileInputStream(new File("src.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("des.txt"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        fileInputStream.close();

        String str;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("des.txt"));
        while ((str = bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }

    @Test
    public void writeFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src.txt", true));
        bufferedWriter.write("\ni am spider man");
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src.txt"));
        String read;
        while ((read = bufferedReader.readLine())!=null){
            System.out.println(read);
        }
    }

    @Test
    public void tempFile() throws IOException {
        File tempFile = File.createTempFile("tempFile", ".txt");
        System.out.println(tempFile.getAbsoluteFile());

    }
}

