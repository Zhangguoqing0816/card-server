package com.card.zh.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前日期
     *
     * @return
     */
    public static LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    public static Date getNowDate() {
        LocalDate localDate = getNowLocalDate();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String dateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
