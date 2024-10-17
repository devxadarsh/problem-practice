package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Find the length of a string without using the toCharArray(),
// the length() method of the String class, or any input/output(IO) operations?
public class LengthOfString {
    public static void main(String[] args) {
        String str = "Testing";
        System.out.println(str.toCharArray().length);

        System.out.println(str.lastIndexOf(""));

        Matcher matcher = Pattern.compile("$").matcher(str);
        matcher.find();
        int len = matcher.end();
        System.out.println(len);

        System.out.println(str.split("").length);

        System.out.println(getLength(str));

        int l1 = 0;
        try{
            l1 = str.getBytes("UTF-16BE").length/2;
        } catch (Exception e) {

        }
        System.out.println(l1);


    }

    public static int getLength(String str) {

        int i = 0;
        try {
            while (true) {
                str.charAt(i);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            return i;
        }
    }
}
