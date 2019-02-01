package ee.taltech.iti0202.idcode;

public class IDCode {

    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        return false;
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        return idCode.charAt(0) >= 1 || idCode.charAt(0) <= 6;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(1,3)) >= 0 || Integer.parseInt(idCode.substring(1,3)) <= 99;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(3,5)) > 0 || Integer.parseInt(idCode.substring(3,5)) <= 12;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(5,7)) > 0 || Integer.parseInt(idCode.substring(5,7)) <= 31;
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
