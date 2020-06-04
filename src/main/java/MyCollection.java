import org.junit.jupiter.api.Test;
import org.omg.CosNaming.IstringHelper;

import java.lang.reflect.Array;
import java.util.*;

public class MyCollection {


    @Test
    public void test1() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "wm");
        hm.put("sex", "man");
        Set<Map.Entry<String, String>> entries = hm.entrySet();

//        第一种方式
//        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey());
//            System.out.println(next.getValue());
//        }

//        第二种方式
//        for(Map.Entry<String,String> entry: entries){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

//        第三种方式
//        Set<String> strings = hm.keySet();
//        for(String key : strings){
//            System.out.println(key);
//            System.out.println(hm.get(key));
//        }

//       最优
//        for (Map.Entry<String,String> entry: hm.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }

    @Test
    public void test2() {
        HashSet<String> strings = new HashSet<>();
        strings.add("apple");
        strings.add("orange");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test3() {
        Integer[] ints = {1, 2, 3, 5, 7, 4, 3, 7, 9, 5};
        List<Integer> list = Arrays.asList(ints);
        Collections.shuffle(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test4() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("orange");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test5() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("orange");
        ListIterator<String> stringListIterator = strings.listIterator();
        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

    }

    @Test
    public void test6() {
        String[] strings = {"q", "w", "e"};
        List<String> strings1 = Arrays.asList(strings);
//        ArrayList<String> strings2 = new ArrayList<>(strings1);
        List<String> strings3 = Collections.unmodifiableList(strings1);
        strings3.set(0,"r");


    }

    @Test
    public void test7() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1,"hello");
        map.put(2,"good");
        Set<Integer> integers = map.keySet();
        for(Integer i : integers){
            System.out.println(i);
        }
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(map.keySet());

    }
    @Test
    public void test8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("菜");
        list.add("鸟");
        list.add("教");
        list.add("程");
        list.add("www.runoob.com");
        Object[] objects = list.toArray(new String[0]);
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    /**
     * 循环往右挪动，第二个参数为每个元素挪动的个数
     */
    @Test
    public void test9() {
        String s = "one two three four six";
        String[] array = s.split(" ");
        List<String> list = Arrays.asList(array);
        System.out.println(list);
        Collections.rotate(list,2);
        System.out.println(list);

    }
    @Test
    public void test10() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(1,"name");
        hashtable.put(2,"age");
        Enumeration e = hashtable.keys();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

    }
    @Test
    public void test11() {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> strings = new ArrayList<>();

        HashSet<Object> objects = new HashSet<>();
        TreeSet<Object> objects1 = new TreeSet<>();
        LinkedHashSet<Object> objects2 = new LinkedHashSet<>();

        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
    }
    @Test
    public void test12() {
        List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
        System.out.println(list);
        Collections.replaceAll(list,"one","dododo");
        System.out.println(list);

//        Collections.indexOfSubList()

    }
}

