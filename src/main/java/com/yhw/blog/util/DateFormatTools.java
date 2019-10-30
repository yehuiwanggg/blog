package com.yhw.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateFormatTools {
	public static final String FMT_DATE_SECONDS = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FMT_DATE_SECONDS_ALI = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATE_HOURS = "yyyy-MM-dd HH";
	public static final String FMT_DATE_DAYS = "yyyy-MM-dd";
	public static final String FMT_DATE_MONTH = "yyyy-MM";
	public static final String FMT_DATE_YEAR = "yyyy";

	public static final Date funcGetUtilDate(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
//			throw new DateFormatException(String.format("date format error"));
			return null;
		}
	}

	public static final String funcGetDateWithFormat(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static final Date funcGetDateWithFormat(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 几天前/后的时间戳
	 *
	 * @param activateDate 开始时间
	 * @param days 天数
	 * @param opt 操作，前：-；后：+
	 * @return 返回天数的时间戳
	 */
	public static final Date getDate(Date activateDate, int days, String opt) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(activateDate);
		switch (opt) {
			case "-":
				calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - days);
				break;
			case "+":
				calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
				break;
			default:
				break;
		}

		return calendar.getTime();
	}
	/**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * 
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author 
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
