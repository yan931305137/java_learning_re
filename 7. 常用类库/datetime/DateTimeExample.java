package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 现代日期时间API示例（Java 8+）
 */
public class DateTimeExample {
    public static void main(String[] args) {
        // 1. 创建日期时间
        System.out.println("=== 创建日期时间 ===");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        
        System.out.println("当前日期: " + date);
        System.out.println("当前时间: " + time);
        System.out.println("当前日期时间: " + dateTime);

        // 2. 日期时间操作
        System.out.println("\n=== 日期时间操作 ===");
        LocalDate tomorrow = date.plusDays(1);
        LocalDate nextMonth = date.plusMonths(1);
        LocalTime twoHoursLater = time.plusHours(2);
        
        System.out.println("明天: " + tomorrow);
        System.out.println("下个月: " + nextMonth);
        System.out.println("两小时后: " + twoHoursLater);

        // 3. 日期时间格式化
        System.out.println("\n=== 格式化 ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = dateTime.format(formatter);
        System.out.println("格式化后: " + formatted);

        // 4. 时间间隔
        System.out.println("\n=== 时间间隔 ===");
        LocalDate birthday = LocalDate.of(2000, 1, 1);
        Period period = Period.between(birthday, date);
        long days = ChronoUnit.DAYS.between(birthday, date);
        
        System.out.println("年龄: " + period.getYears() + "年 " +
                         period.getMonths() + "月 " +
                         period.getDays() + "天");
        System.out.println("总天数: " + days);

        // 5. 时区处理
        System.out.println("\n=== 时区处理 ===");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime newYork = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        
        System.out.println("当前时区: " + zonedDateTime);
        System.out.println("纽约时间: " + newYork);
    }
} 