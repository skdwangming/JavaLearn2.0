package createAndDestoryObject.createObject2;

public class Create {
    private static long sum(){
        long l = 0;
        //Long l = 0L; 会非常慢
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            l+=i;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(sum());
    }
}
