package MyIO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        while ((len = bufferedInputStream.read(bytes)) != -1) {

            System.out.println(new String(bytes, 0, len));
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
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("writeFile.txt"));
        char[] chars = new char[1024];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
    }

    @Test
    public void readFileByChar2() throws IOException {
        FileReader fileReader = new FileReader("writeFile.txt");
        char[] bytes = new char[1024];
        int len;
        while ((len = fileReader.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileReader.close();
    }

    @Test
    public void readFileByChar3() throws IOException {
        FileReader fileReader = new FileReader("readFile.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }

    @Test
    public void writeFileByChar() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("writeFile.txt"));
        outputStreamWriter.write("ig牛逼");
        outputStreamWriter.close();
    }

    /**
     * 更改文件修改时间
     */
    @Test
    public void test3() {
        File file = new File("src.txt");
        long l = file.lastModified();
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        boolean b = file.setLastModified(System.currentTimeMillis());
        System.out.println(b);


    }

    /**
     * 获取文件大小
     */
    @Test
    public void test4() {
        File file = new File("src.txt");
        System.out.println(file.exists());
        long length = file.length();
        System.out.println(length);

        boolean b = file.renameTo(new File("sss.txt"));
        System.out.println(b);


    }

    @Test
    public void test5() throws IOException {
        File file = new File("sss.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
    }

    @Test
    public void test6() {
        String path = "/Users/wm/1/2/3";
        File file = new File(path);
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);


    }

    @Test
    public void test7() {
        String path = "/Users/wm/1";
        File file = new File(path);
        if (file.isDirectory()){
            boolean delete = file.delete();
            System.out.println(delete);
        }

    }

    /**
     * 删除目录下所有文件、文件夹
     */
    @Test
    public boolean deletePathAll(File file) throws IOException {
        if (file.isDirectory()){
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File delFile = new File(file, files[i]);
                boolean b = deletePathAll(delFile);
                if (!b){
                    return false;
                }

            }
        }
        if (file.delete()){
            System.out.println("删除成功---"+file.getPath());
            return true;
        }else {
            System.out.println("删除失败");
            return false;

        }

    }


    @Test
    public void test8() throws IOException {
        String path = "/Users/wm/1";
        deletePathAll(new File(path));
    }

    public void test9(){

    }

    public void test10(){

    }

    public void test11(){

    }

    public void test12(){

    }

}
