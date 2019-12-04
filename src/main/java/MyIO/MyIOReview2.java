package MyIO;

import com.sun.corba.se.impl.encoding.ByteBufferWithInfo;
import org.junit.jupiter.api.Test;

import java.io.*;


/**
 * inputstream
 * outputstream
 * --fileoutputstream(file)
 * --filteroutputstream
 * ----bufferedoutputstream(outputstream)
 * <p>
 * <p>
 * <p>
 * reader
 * writer
 * --outputstreamwriter(outputstream)连接器
 * ----filewriter(file)其实只是帮助我们做了outputstreamwriter该做的事情
 * bufferedwriter(writer)
 *
 */
public class MyIOReview2 {


    @Test
    public void test1() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("out.txt"));
//            fos = new FileOutputStream("out.txt");
            fos.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test2() {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("out.txt")));
            bos.write("test2".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("out.txt"));
            fw.write("test3");
        } catch (IOException e) {

        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test4() {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(new File("out.txt")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(new File("out.txt")))));
//            bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write("test6");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test6() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write("dfsdfsd");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            bw.close();
        }

    }

    @Test
    public void test7() {

    }
}

