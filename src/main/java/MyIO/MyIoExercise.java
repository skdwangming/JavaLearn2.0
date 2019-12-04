package MyIO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class MyIoExercise {

    /**
     * 在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建
     *
     * 一个目录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文件
     */
    @Test
    public void test1(){
        File file = new File("/Users/wm/Desktop/HelloWorld.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.exists()){
            if(file.isDirectory()){
                System.out.println(file.getPath()+"是路径");
            }else {
                System.out.println(file.getPath()+"是文件");
            }
        }else {
            System.out.println(file.getPath()+"不存在");
        }

        File dir = new File("/Users/wm/Desktop/IOTest");
        dir.mkdir();
        File destFile = new File(dir.getPath()+"/"+file.getName());
        if(file.renameTo(destFile)){
            System.out.println("移动成功");
        }

        File[] files = dir.listFiles();
        for (File f : files){
            System.out.println("路径："+f.getPath());
        }
    }
}
