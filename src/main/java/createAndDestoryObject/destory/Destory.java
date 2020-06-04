package createAndDestoryObject.destory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Destory {
    static String FirstLin(String path) throws IOException {
//        try(BufferedReader br = new BufferedReader(new FileReader(path))){
//            return br.readLine();
//        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        }catch (IOException i){
            i.printStackTrace();
        }
        return br.readLine();
    }
}
