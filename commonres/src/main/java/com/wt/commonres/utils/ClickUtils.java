package com.wt.commonres.utils;

import android.view.View;

public class ClickUtils {

    private static long lastClickTime = 0;//上次点击的时间
    private static int spaceTime = 1000;//时间间隔
    private static long DIFF = 1000;
    private static int dTime = 350;//时间间隔

    private static int lastButtonId = -1;

    public static boolean isFastClick() {

        long currentTime = System.currentTimeMillis();//当前系统时间
        boolean isAllowClick;//是否允许点击

        if (currentTime - lastClickTime > spaceTime) {
            isAllowClick = false;
        } else {
            isAllowClick = true;
        }
        lastClickTime = currentTime;
        return isAllowClick;
    }


    /**
     * 判断两次点击的间隔，如果小于1000，则认为是多次无效点击
     *
     * @return
     */
    public static boolean isFastDoubleClick(View buttonV) {
        return isFastDoubleClick(buttonV.getId() + buttonV.hashCode(), DIFF);
    }

    /**
     * 防止多次点击，规定时间内只有一次点击生效
     *
     * @param buttonV
     * @return
     */
    public static boolean isNotFastDoubleClick(View buttonV) {
        return !isFastDoubleClick(buttonV.getId() + buttonV.hashCode(), DIFF);
    }

    /**
     * 判断两次点击的间隔，如果小于diff，则认为是多次无效点击
     *
     * @param diff
     * @return
     */
    public static boolean isFastDoubleClick(int buttonId, long diff) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (lastButtonId == buttonId && lastClickTime > 0 && timeD < diff) {
            return true;
        }
        lastClickTime = time;
        lastButtonId = buttonId;
        return false;
    }
}
