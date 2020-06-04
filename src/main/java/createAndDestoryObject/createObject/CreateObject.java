package createAndDestoryObject.createObject;

import java.util.regex.Pattern;

public class CreateObject {
    private static final Pattern pattern = Pattern.compile("123");

    static boolean isTrue(String s){
        return pattern.matcher(s).matches();
    }
}
