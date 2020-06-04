import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;


public class MyTest {


    @Test
    public void test1() {
        HashMap<String, String> idMap = new HashMap<>();
        idMap.put("name", "wm");
        idMap.put("sex", "man");
        idMap.put("high", "175");

        Map<String, String> map = new HashMap();

        String key;
        String resXml;
        for (Iterator var3 = idMap.keySet().iterator(); var3.hasNext(); map.put(key, resXml)) {
            key = (String) var3.next();
            String val = (String) idMap.get(key);
            resXml = "";

            System.out.println("key==>" + key);
            System.out.println("val==>" + val);
            System.out.println("xml==>" + resXml);
        }
    }

    @Test
    public void test2() {
        String s = "21233dsfsd";
        String substring = s.substring(0, 4);
        System.out.println(substring);


    }

    @Test
    public void test3() {
        Date date = new Date();
        

        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String value = ymdhmsFormat.format(date);
        if (value.length() > 10 && checkValidDateDetail(value)) {    // 年月日时分秒
            System.out.println(formatDateDetail(value));
        } else {    // 年月日
            System.out.println(formatDate(value));
        }
    }
    public static String formatDate(String date) {
        date=date.substring(0,10);   // update by baoyx on 201310-28  防止超长的日期字符串出现
        String dateFormat = null;
        if (date != null && !date.equals("")) {
            dateFormat = "to_date('" + date + "','YYYY-MM-DD')";
        }
        return dateFormat;
    }

    public static String formatDateDetail(String date) {

//		logger.info("进入方法formatDateDetail");
//		logger.info("待处理的日期：" + date);
        String dateFormat = null;
        if (date != null && !date.equals("")) {
            dateFormat = "to_date('" + date + "','YYYY-MM-DD HH24:MI:SS')";
        }
//		logger.info("处理后的格式：" + dateFormat);
//		logger.info("离开方法formatDateDetail");
        return dateFormat;
    }

    public static boolean checkValidDateDetail(String pDateObj) {
        boolean ret = true;
        // if(pDateObj==null||pDateObj.length()!=19){
        // ret = false;
        // }
        try {
            int year = new Integer(pDateObj.substring(0, 4)).intValue();
            if(pDateObj.length()>18&&year<2030){

                int month = new Integer(pDateObj.substring(5, 7)).intValue();
                int day = new Integer(pDateObj.substring(8, 10)).intValue();
                int hour = new Integer(pDateObj.substring(11, 13)).intValue();
                int minute = new Integer(pDateObj.substring(14, 16)).intValue();
                int second = new Integer(pDateObj.substring(17, 19)).intValue();
                Calendar cal = Calendar.getInstance();
                cal.setLenient(false); // 允许严格检查日期格式
                cal.set(year, month - 1, day, hour, minute, second);
                cal.getTime();// 该方法调用就会抛出异常
            }else{
                ret=false;
            }

        } catch (Exception e) {
            ret = false;
        }
        return ret;
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

