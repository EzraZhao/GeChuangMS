package com.gechuangms.util;

/**
 * Created by Ezra on 2017/5/29.
 */

public class StringUtils {
    //账号匹配，格式为20**20****
    private static final String USER_NAME_REGEX = "^20[1-9]{2}20[0-9]{4}$";
    //密码匹配，格式为至少6个字符
    private static final String PASSWORD_REGEX = "^.{6,20}$";


    public static boolean checkUserName(String userName) {
        return userName.matches(USER_NAME_REGEX);
    }

    public static boolean checkPassword(String pwd) {
        return pwd.matches(PASSWORD_REGEX);
    }
}
