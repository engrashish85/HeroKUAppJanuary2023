package utility;

public class StringHelper {

    public static boolean isBlankOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
