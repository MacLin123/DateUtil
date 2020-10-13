package ru.ncedu.kurakin.dateutil;


public class Main {
    public static void main(String[] args) {
        int year = 2000;
        int month = 5;
        int day = 10;
        IDateUtil idt = new DateUtil();
        System.out.println("10.05.2020:");
        System.out.println("Is leap year? -" + idt.isLeapYear(year));
        System.out.println("Is valid date? -" + idt.isValidDate(year, month, day));

        System.out.println("What day of the week - " +
                DateUtil.DayOfWeek.values()[idt.getDayOfWeek(year, month, day)].getName());
        System.out.println("Date in nice form: " + idt.toString(year, month, day));
        System.out.println("number of days from date to today: " + idt.countDays(year, month, day));
        System.out.println("****************************POJO*************************");
        year = 2001;
        month = 12;
        day = 15;
        MyDate myDate = new MyDate(year, month, day);
        System.out.println("15.12.2001:");
        System.out.println("Is leap year? - " + myDate.isLeapYear());
        System.out.println("Is valid date? - " + myDate.isValidDate());
        System.out.println("What day of the week - " +
                DateUtil.DayOfWeek.values()[myDate.getDayOfWeek()].getName());
        System.out.println("Date in nice form: " + myDate.toString());
        System.out.println("number of days from date to today: " + myDate.countDays());

    }
}
