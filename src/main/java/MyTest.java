import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MyTest {


    @Test
    public void test1() {
        HashMap<String, String> idMap = new HashMap<>();
        idMap.put("name","wm");
        idMap.put("sex","man");
        idMap.put("high","175");

        Map<String, String> map = new HashMap();

        String key;
        String resXml;
        for(Iterator var3 = idMap.keySet().iterator(); var3.hasNext(); map.put(key, resXml)) {
            key = (String)var3.next();
            String val = (String)idMap.get(key);
            resXml = "";

            System.out.println("key==>"+key);
            System.out.println("val==>"+val);
            System.out.println("xml==>"+resXml);
        }
    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {

    }

    @Test
    public void test5() {

    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }
}

