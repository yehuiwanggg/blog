package com.yhw.blog.util;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: czt
 * Date: 19-8-20
 * Time: 上午11:00
 * Description:
 */
public class StringUtil {

    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static String getUUIDStr() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    /**
     * 转换obj成字符串，null转为空字符串“”
     *
     * @param obj
     * @return
     */
    public static String convertToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * 判断字符串是空或空字符串
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }
}
