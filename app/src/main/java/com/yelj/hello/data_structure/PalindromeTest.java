package com.yelj.hello.data_structure;

import com.yelj.hello.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Author: Alex.ylj
 * 2019-05-07 15:24 Tuesday
 * Description: 回文
 */
public class PalindromeTest {

    public static void main(String[] args) {
//        String time = defaultUtc2Local("2019-05-01T11:38:23.000+0000", "yyyy-MM-dd HH:mm:ss");
//        String time1 = defaultUtc2Local("2019-05-01T11:38:23.000+0800", "yyyy-MM-dd HH:mm:ss");
//        System.out.println(time);
//        System.out.println(time1);

        try {
            Class<?> aClass = Class.forName("com.yelj.hello.Book");
            Constructor<?> constructor = aClass.getConstructor();
            Object instance = constructor.newInstance();
            Book book = (Book) instance;
            System.out.println(book.bookId);
            System.out.println(book.bookName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * UTC时间转本地时间格式
     */
    public static String defaultUtc2Local(String utcTime, String localTimePatten) {
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate;
        try {
            gpsUTCDate = utcFormat.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return utcTime;
        }
        SimpleDateFormat localFormat = new SimpleDateFormat(localTimePatten, Locale.getDefault());
        localFormat.setTimeZone(TimeZone.getDefault());
        return localFormat.format(gpsUTCDate.getTime());
    }

    public static boolean isPalindromePossible(String input) {
        char[] charStr = input.toCharArray();
        int len = input.length(), i;
        int diffCount = 0;
        char[][] diff = new char[2][2];
        for (i = 0; i < len / 2; i++) {
            if (charStr[i] != charStr[len - i - 1]) {
                if (diffCount == 2)
                    return false;
                diff[diffCount][0] = charStr[i];
                diff[diffCount++][1] = charStr[len - i - 1];
            }
        }
        switch (diffCount) {
            case 0:
                return true;
            case 1:
                char midChar = charStr[i];
                if (len % 2 != 0 && (diff[0][0] == midChar
                        || diff[0][1] == midChar))
                    return true;
            case 2:
                if ((diff[0][0] == diff[1][0] && diff[0][1] == diff[1][1])
                        || (diff[0][0] == diff[1][1] && diff[0][1] == diff[1][0]))
                    return true;
        }
        return false;
    }

    private static boolean IsHuiwen(String string) {
        char[] temp = string.toCharArray();
        for (int i = 0; i < temp.length / 2; i++) {
            if (temp[i] != temp[temp.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
