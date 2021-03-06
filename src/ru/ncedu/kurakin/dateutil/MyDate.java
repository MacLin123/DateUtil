package ru.ncedu.kurakin.dateutil;

import java.time.LocalDate;

/**
 * Realisation of pojo date class
 * * Methods don't use methods for working with dates
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);

    }

    public enum DayOfWeek {
        MON(0, "Monday"),
        TUE(1, "Tuesday"),
        WED(2, "Wednesday"),
        THU(3, "Thursday"),
        FRI(4, "Friday"),
        SAT(5, "Saturday"),
        Sun(6, "Sunday");
        private final int val;
        private final String name;

        DayOfWeek(int val, String name) {
            this.val = val;
            this.name = name;
        }

        public int getVal() {
            return val;
        }

        public String getName() {
            return name;
        }
    }

    public enum Months {
        Jan(1),
        Feb(2),
        Mar(3),
        Apr(4),
        May(5),
        Jun(6),
        Jul(7),
        Aug(8),
        Sep(9),
        Oct(10),
        Nov(11),
        Dec(12);
        private final int val;

        Months(int val) {
            this.val = val;
        }

        public static DateUtil.Months of(int month) {
            return DateUtil.Months.values()[month - 1];
        }
    }

    public boolean isLeapYear() {
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }
        return isLeap;
    }

    public boolean isValidDate() {
        if (year < 0 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }

        if (month == 2) {
            if (isLeapYear()) {
                return (day <= 29);
            } else {
                return (day <= 28);
            }
        }
        if (month == 4 || month == 6 ||
                month == 9 || month == 11)
            return (day <= 30);
        return true;
    }

    public int getDayOfWeek() {
        if (!isValidDate()) {
            throw new IllegalArgumentException("Illegal date!");
        }
        int a, y, m;
        int result;
        a = (14 - month) / 12;
        y = year - a;
        m = month + 12 * a - 2;
        result = 7000 + (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12);
        result = result % 7;
        result = ((result - 1) >= 0) ? (result - 1) : (7 - Math.abs(result - 1));
        return result;
    }

    public String toString() {
        String dayOfWeekStr = DateUtil.DayOfWeek.values()[getDayOfWeek()].getName();
        return dayOfWeekStr + " " + day + " " + DateUtil.Months.of(month).toString()
                + " " + year;
    }

    public int countDays() {
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int days = getDaysFromOrigin();
        MyDate curDate = new MyDate(currentYear, currentMonth, currentDay);
        int daysCur = curDate.getDaysFromOrigin();
        return Math.abs(daysCur - days);

    }

    private int getDaysFromOrigin() {
        int[] daysUpToMonth = {0, 31, 59, 90, 120, 151, 181,
                212, 243, 273, 304, 334};
        int[] daysUpToMonthLeapYear = {0, 31, 60, 91, 121, 152,
                182, 213, 244, 274, 305, 335};
        if (isLeapYear()) {
            year--;
            int numOfLeapsYear = year / 4 - year / 100 + year / 400;
            return year * 365 + numOfLeapsYear + daysUpToMonthLeapYear[month - 1] + day - 1;
        } else {
            year--;
            int numOfLeapsYear = year / 4 - year / 100 + year / 400;
            return year * 365 + numOfLeapsYear + daysUpToMonth[month - 1] + day - 1;
        }
    }
}
