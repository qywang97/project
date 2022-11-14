package com.untils.myComponents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description
 * @Author 王群勇
 * @Date 2021/9/13 16:32
 * @Version 1.0
 */
public class DateUtils {

    private static String RULE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取当前时间
     * @param date
     * @return
     */
    public static String getCurTime(Date date){
        SimpleDateFormat df = new SimpleDateFormat(RULE);
        return df.format(date);
    }
    /**
     * 通过格式获取时间
     * @param rule
     * @return
     */
    public static String getCurTime(String rule){
        SimpleDateFormat df = new SimpleDateFormat(rule);
        return df.format(System.currentTimeMillis());
    }
    /**
     * 去掉时分秒
     * @param date
     * @return
     */
    public static Date peelTimeOff(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取传入日期所在月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 取传入日期所在月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();

    }

    /**
     * 获取传入日期上个月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfLastMonth(final Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,1);
        return cal.getTime();
    }

    /**
     * 获取传入日期上个月的第一天
     * @param date
     * @return
     */
    public static Date getLastDayOfLastMonth(final Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH,last);
        return cal.getTime();
    }

    /**
     * 根据出生日期获取年龄
     * @param birthDay
     * @return
     */
    public static int getAge(Date birthDay) {
        if (new Date().equals(birthDay)){
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        //出生日期晚于当前时间，无法计算
        if (cal.before(birthDay)) {
            return -1;
        }
        //当前年份
        int yearNow = cal.get(Calendar.YEAR);
        //当前月份
        int monthNow = cal.get(Calendar.MONTH);
        //当前日期
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //计算整岁数
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //当前日期在生日之前，年龄减一
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            }else{
                //当前月份在生日之前，年龄减一
                age--;
            }
        }
        return age;
    }

    /**
     * 根据身份编号获取年龄
     * @param idCard 身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int age = -1;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        age = iCurrYear - Integer.parseInt(year);
        return age;
    }

}
