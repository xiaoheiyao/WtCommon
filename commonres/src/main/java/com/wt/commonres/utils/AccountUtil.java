package com.wt.commonres.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountUtil {

    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0)
            return false;
        return Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(email).matches();
    }

    public static boolean isPhone(String phone) {
        if (!TextUtils.isEmpty(phone)){
            Pattern pattern = Pattern.compile("^1[0-9]{10}");
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;

        }
    }

    public static boolean regexPassword(String pwd){
        /**
         * 正则表达式:验证密码(不包含特殊字符)
         * ^[a-zA-Z0-9,<\.>\/\?;:'"\[\{\]\}\\\|`\~!@#$%\^&*\(\)\-_\+\=]{8,24}$
         *
         */
        final String REGEX_PASSWORD = "^[a-zA-Z0-9,<\\.>\\/\\?;:'\"\\[\\{\\]\\}\\\\\\|`\\~!@#$%\\^&*\\(\\)\\-_\\+\\=]{8,24}$";
        return Pattern.matches(REGEX_PASSWORD, pwd);
    }

    public static boolean isNum(String num){
        /**
         * 正则表达式:验证密码(不包含特殊字符)
         * ^[a-zA-Z0-9,<\.>\/\?;:'"\[\{\]\}\\\|`\~!@#$%\^&*\(\)\-_\+\=]{8,24}$
         *
         */
        final String REGEX_NUM = "^[0-9]{6}$";
        return Pattern.matches(REGEX_NUM, num);
    }

}
