package ru.ncedu.kurakin.dateutil;

/**
 * This interface contains functions for working with dates
 * Methods don't use methods for working with dates
 *
 * @author Mikhail Kurakin
 */
public interface IDateUtil {
    /**
     * This method determines whether it is a leap year or not.
     *
     * @param year
     * @return true if year is leap, false otherwise
     */
    boolean isLeapYear(int year);

    /**
     * This method checks the date is valid or not
     *
     * @param year
     * @param month
     * @param day
     * @return true if the date is valid, false otherwise
     */
    boolean isValidDate(int year, int month, int day);

    /**
     * This method return number of weekday
     *
     * @param year
     * @param month
     * @param day
     * @return 0 -Monday,...,6-Sunday
     */
    int getDayOfWeek(int year, int month, int day);

    /**
     * This method formats the date nicely.
     * Example(14,02,2012)-> Tuesday 14 Feb 2012
     *
     * @param year
     * @param month
     * @param day
     * @return String with the date
     */
    String toString(int year, int month, int day);

    /**
     * This method computes how many days have passed, from input date to today
     *
     * @param year
     * @param month
     * @param day
     * @return count of days
     */
    int countDays(int year, int month, int day);
}
