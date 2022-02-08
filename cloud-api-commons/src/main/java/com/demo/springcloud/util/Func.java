package com.demo.springcloud.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author lzy
 * @date 2022/2/8 9:47
 */
public class Func {
    public static void main(String[] args) {
        String str = "就“‘’”";
        List<String> list = toStrList(str);
        System.out.println();
    }

    public static List<String> toStrList(String str) {
        return Arrays.asList(toStrArray(str));
    }

    public static String[] toStrArray(String str) {
        return toStrArray(",", str);
    }

    public static String[] toStrArray(String split, String str) {
        return isBlank(str) ? new String[0] : str.split(split);
    }

    private static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }
}
