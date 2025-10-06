package ca.bcit.comp2522.lab4;

/**
 * Represents a calendar date with year, month, and day.
 *
 * @author Hailey Kim, Luis Saberon
 * @version 1.0
 */
public class Date implements Printable
{

    private static final int MIN_YEAR = 1800;
    private static final int CURRENT_YEAR = 2025;
    private static final int CENTURY_21ST = 2000;
    private static final int CENTURY_20TH = 1900;


    private static final int BASE_ADJUSTMENT = 0;
    private static final int ALLOWED_REMAINDER = 0;

    private static final int LONG_MONTH = 31;
    private static final int MED_MONTH = 30;
    private static final int SHORT_MONTH = 28;
    private static final int LEAP_YEAR_MONTH = 29;

    private static final int LEAP_YEAR_CHECK_1 = 4;
    private static final int LEAP_YEAR_CHECK_2 = 100;

    private static final int DAY_OF_WEEK_CHECK_1 = 12;
    private static final int DAY_OF_WEEK_CHECK_2 = 4;
    private static final int DAY_OF_WEEK_CHECK_3 = 7;
    private static final int GET_TENS_VALUE = 100;

    private static final int FIRST_DAY = 1;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int ADJUSTMENT_1 = 2;
    private static final int ADJUSTMENT_2 = 6;

    //    144025036146
    private static final int JAN_VALUE = 1;
    private static final int FEB_VALUE = 4;
    private static final int MAR_VALUE = 4;
    private static final int APR_VALUE = 0;
    private static final int MAY_VALUE = 2;
    private static final int JUNE_VALUE = 5;
    private static final int JULY_VALUE = 0;
    private static final int AUG_VALUE = 3;
    private static final int SEPT_VALUE = 6;
    private static final int OCT_VALUE = 1;
    private static final int NOV_VALUE = 4;
    private static final int DEC_VALUE = 6;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructors.
     * Validation is performed.
     *
     * @param year the year
     * @param month the month
     * @param day the day of the month
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validate(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the month
     *
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the day
     *
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Validates the given year, month, and day.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @throws IllegalArgumentException if the date is invalid
     */
    private void validate(final int year,
                          final int month,
                          final int day)
    {
        if (year < MIN_YEAR || year > CURRENT_YEAR) {
            throw new IllegalArgumentException("Year must be between " + MIN_YEAR + " and " + CURRENT_YEAR);
        }

        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException("Month must be between January and December.");
        }

        if (day < FIRST_DAY || day > daysInMonth(year, month)) {
            throw new IllegalArgumentException("Invalid day for month " + month + " in year " + year);
        }
    }

    /**
     * Returns the number of days in a given month for a specific year.
     *
     * @param year  the year
     * @param month the month
     * @return number of days in the month
     */
    private int daysInMonth(final int year,
                            final int month)
    {

        if (month == JANUARY || month == MARCH || month == MAY || month == JULY ||
                month == AUGUST || month == OCTOBER || month == DECEMBER)
        {
            return LONG_MONTH;
        }
        else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
        {
            return MED_MONTH;
        }
        else
        {
            if(month == FEBRUARY) {
                if(isLeapYear(year)) {
                    return LEAP_YEAR_MONTH;
                }
                else {
                    return SHORT_MONTH;
                }
            }

            else {
                throw new IllegalArgumentException("Month is not a valid month");
            }
        }


    }

    /**
     * Determines if a given year is a leap year.
     *
     * @param year the year
     * @return ture if the year is a leap year, otherwise false
     */
    private boolean isLeapYear(final int year)
    {
        return (year % LEAP_YEAR_CHECK_1 == ALLOWED_REMAINDER && year % LEAP_YEAR_CHECK_2 != ALLOWED_REMAINDER) ||
                (year % LEAP_YEAR_CHECK_2 * LEAP_YEAR_CHECK_1 == ALLOWED_REMAINDER);
    }

    /**
     * Returns the date formatted as YYYY-MM-DD.
     *
     * @return the formatted date string
     */
    public String getYYYYMMDD()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Calculates and returns the day of the week.
     *
     * @return the name of the day of the week
     */
    public String getDayOfWeek()
    {
        int yy; // Gets the last 2 digits of the year
        int sum;
        int code;


        yy = year % GET_TENS_VALUE;
        sum = getAdjustment(year, month); // Adjusts the value depending on if the year is if the year is in the
        //21st century or before the 20th century, and if the year is a leap year

        sum += yy / DAY_OF_WEEK_CHECK_1;  // Checks how many 12s there are in the last 2 digits
        sum += yy % DAY_OF_WEEK_CHECK_1;  // Finds the remainder of the previous operation
        sum += (yy % DAY_OF_WEEK_CHECK_1) /  DAY_OF_WEEK_CHECK_2;  // Calculate the amount of 4's in the remainder

        sum += getMonthCode(month);  // Adds the month code(for jfmamjjasond it's 144025036146)
        code = sum % DAY_OF_WEEK_CHECK_3; // Remainder of sum / 7 to find the day code.

        // match the numeric code to the actual day name
        if (code == SATURDAY) {
            return "Saturday";
        } else if (code == SUNDAY) {
            return "Sunday";
        } else if (code == MONDAY) {
            return "Monday";
        } else if (code == TUESDAY) {
            return "Tuesday";
        } else if (code == WEDNESDAY) {
            return "Wednesday";
        } else if (code == THURSDAY) {
            return "Thursday";
        } else if (code == FRIDAY) {
            return "Friday";
        } else {
            return "Unknown";
        }

    }

    /**
     * Returns an adjustment factor for dayOfWeek calculation.
     *
     * @param year  the year
     * @param month the month
     * @return adjustment value
     */
    private int getAdjustment(final int year,
                              final int month)
    {
        int adjustment;

        adjustment = BASE_ADJUSTMENT;

        if (year < CENTURY_20TH) {
            adjustment += ADJUSTMENT_1; // pre-1900 correction
        }
        else if (year >= CENTURY_21ST)
        {
            adjustment += ADJUSTMENT_2; // post-2000 correction
        }

        // leap year correction for January and February
        if (isLeapYear(year) && (month == JANUARY || month == FEBRUARY))
        {
            adjustment += ADJUSTMENT_2;
        }

        return adjustment;
    }

    /**
     * Returns a numeric month code used for dayOfWeek calculation.
     *
     * @param monthIndex the month index
     * @return the month code
     */
    private int getMonthCode(final int monthIndex)
    {
        if (monthIndex == JANUARY) {
            return JAN_VALUE;
        } else if (monthIndex == FEBRUARY) {
            return FEB_VALUE;
        } else if (monthIndex == MARCH) {
            return MAR_VALUE;
        } else if (monthIndex == APRIL) {
            return APR_VALUE;
        } else if (monthIndex == MAY) {
            return MAY_VALUE;
        } else if (monthIndex == JUNE) {
            return JUNE_VALUE;
        } else if (monthIndex == JULY) {
            return JULY_VALUE;
        } else if (monthIndex == AUGUST) {
            return AUG_VALUE;
        } else if (monthIndex == SEPTEMBER) {
            return SEPT_VALUE;
        } else if (monthIndex == OCTOBER) {
            return OCT_VALUE;
        } else if (monthIndex == NOVEMBER) {
            return NOV_VALUE;
        } else if (monthIndex == DECEMBER)
        {
            return DEC_VALUE;
        } else {
            throw new IllegalArgumentException("Not real month");
        }

    }

    /**
     * Returns the name of the current month.
     *
     * @return month name
     */
    private String getMonthName()
    {
        if (month == JANUARY) {
            return "January";
        } else if (month == FEBRUARY) {
            return "February";
        } else if (month == MARCH) {
            return "March";
        } else if (month == APRIL) {
            return "April";
        } else if (month == MAY) {
            return "May";
        } else if (month == JUNE) {
            return "June";
        } else if (month == JULY) {
            return "July";
        } else if (month == AUGUST) {
            return "August";
        } else if (month == SEPTEMBER) {
            return "September";
        } else if (month == OCTOBER) {
            return "October";
        } else if (month == NOVEMBER) {
            return "November";
        } else if (month == DECEMBER){
            return "December";
        } else {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    /**
     * Returns the date formatted as "DayOfWeek, MonthName Day, Year".
     *
     * @return the formatted date string
     */
    public String getFormattedDate()
    {
        return String.format("%s, %s %d, %d",
                getDayOfWeek(),
                getMonthName(),
                day,
                year);
    }

    @Override
    public void display()
    {
        System.out.println("Date: " + getFormattedDate() + " (YYYY/MM/DD)");
    }
}