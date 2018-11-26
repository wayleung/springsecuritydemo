package com.way.springsecuritydemo.test;

/**
 * @Auther: Way Liang
 * @Date: 11/26/2018 14:02
 * @Description:
 */
public class StringTest {
    private String a;

    public static int b;


    public static void main(String[] args) {

        //String
        String str = new String("aa");
        System.out.println("hashcode:"+returnHashCode(str));
//        str =  appendStr(str);
        String newStr = appendStr(str);

        System.out.println(str);
//        System.out.println(newStr);

        //StringBuffer
        StringBuffer strBuf = new StringBuffer("aa");
        StringBuffer newStrBuf = appendStrBuf(strBuf);
        System.out.println(strBuf);
        System.out.println(newStrBuf);

        System.out.println("hashcode:"+returnHashCode(str));
        System.out.println("hashcode:"+returnHashCode(newStr));

        System.out.println("hashcode:"+returnHashCode(strBuf));
        System.out.println("hashcode:"+returnHashCode(newStrBuf));
    }

    private static String appendStr(String s){
        s+="bb";
        return s;
    }

    private static StringBuffer appendStrBuf(StringBuffer sb){
        return sb.append("bb");
    }


    private static int returnHashCode(Object object){
        return object.hashCode();
    }
}
