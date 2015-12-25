package com.hanyx.hjoyblog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
	
	private DateUtil() {};
	
	// һ��ĺ����� 86400000 = 24*60*60*1000;
	private static final int MILLIS_PER_DAY = 86400000;
	// һСʱ�ĺ�����600000 = 24*60*60*1000;
	private static final int MILLIS_PER_HOUR = 3600000;
	//���ڸ�ʽ
	private static final String DateFormat1="yyyy-MM-dd";
	private static final String DateFormat2="yyyy-MM-dd HH:mm:ss";
/**
 * ��ȡ��ǰ������
 * @return
 */
	public static String getCurrentDay() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat1);
		return sdf.format(nowDate);
	}
/**
 * ��ȡ��ǰʱ��
 * @return
 */
	public static String getNowTime() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat2);
		return sdf.format(nowDate);
	}

	/**
	 * ��ȡʱ���
	 * 
	 * @param choose
	 * @param lastDate
	 * @return
	 */
	public static long getDf(String choose, String lastDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat2);
		try {
			Date ld = sdf.parse(lastDate);
			Date now = sdf.parse(getNowTime());
			long msecond = now.getTime() - ld.getTime();
			if (choose.equals("s")) {
				return msecond / 1000;
			}
			if (choose.equals("m")) {
				return msecond / (1000 * 60);
			}
			if (choose.equals("h")) {
				return msecond / MILLIS_PER_HOUR;
			}
			if (choose.equals("d")) {
				return msecond / MILLIS_PER_DAY;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @��ȡ���µ�����(�������һ��)
	 * @param args
	 */
	public static int getDaysOfMouth() {
		String[] dates = getCurrentDay().split("-");
		int year = Integer.parseInt(dates[0]);
		int mouth = Integer.parseInt(dates[1]);
		int Aday=0;
		String m1 = "1,3,5,7,8,10,12";
		String m2 = "4,6,9,11";
		if (m1.contains(String.valueOf(mouth))) {
			Aday = 31;
		}
		if (m2.contains(String.valueOf(mouth))) {
			Aday = 30;
		}
		if ((0 == year % 400) || (0 == year % 4 && 0 != year % 100)) {
			Aday=29;
		}else{
			Aday=28;
		}
		return Aday;
	}
}
