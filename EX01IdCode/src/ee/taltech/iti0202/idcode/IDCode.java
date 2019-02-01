package ee.taltech.iti0202.idcode;

public class IDCode {
    private static final int MIN_GENDER_NUMBER = 1;
    private static final int MAX_GENDER_NUMBER = 6;
    private static final int MIN_YEAR_NUMBER = 0;
    private static final int MAX_YEAR_NUMBER = 99;
    private static final int MIN_MONTH_NUMBER = 0;
    private static final int MAX_MONTH_NUMBER = 12;
    private static final int MIN_DAY_NUMBER = 1;
    private static final int MAX_DAY_NUMBER = 31;

    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        return false;
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        return idCode.charAt(0) >= MIN_GENDER_NUMBER && idCode.charAt(0) <= MAX_GENDER_NUMBER;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(1, 3)) >= MIN_YEAR_NUMBER &&
                Integer.parseInt(idCode.substring(1, 3)) <= MAX_YEAR_NUMBER;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(3, 5)) > MIN_MONTH_NUMBER &&
                Integer.parseInt(idCode.substring(3, 5)) <= MAX_MONTH_NUMBER;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(5, 7)) > MIN_DAY_NUMBER &&
                Integer.parseInt(idCode.substring(5, 7)) <= MAX_DAY_NUMBER;
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isLeapYear(int fullYear) {
        return false;
    }

    public static String getInformationFromIDCode(String idCode) {
        return "";
    }

    public static Gender getGender(String idCode) {
        return null;
    }

    public static int getFullYear(String idCode) {
        return 0;
    }
}
