import bean.Hero;
import com.alibaba.fastjson.JSONObject;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.toInstant());
        System.out.println();

        //LocalDate 只获取年月日
        LocalDate localDate1 =LocalDate.now();
        //自定义年月日
        LocalDate localDate2 =LocalDate.of(1998, Month.DECEMBER,17);
        System.out.println(localDate1.toString());
        System.out.println(localDate2.toString());
        System.out.println();

        //LocalTime 只获取时分秒
        LocalTime localTime1 =LocalTime.now();
        //自定义时分秒
        LocalTime localTime2=LocalTime.of(0,0,0);
        System.out.println(localTime1.toString());
        System.out.println(localTime2.toString());
        System.out.println();

        // LocalDateTime 获取 年月日时分秒 相当于LocalDate + LocalTime
        LocalDateTime localDateTime1=LocalDateTime.now();
        LocalDateTime localDateTime2=LocalDateTime.of(2020,Month.MAY,20,20,20,20);
        LocalDateTime localDateTime3=LocalDateTime.of(localDate2,localTime2);
        System.out.println(localDateTime1.toString());
        System.out.println(localDateTime2.toString());
        System.out.println(localDateTime3.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
