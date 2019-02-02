package ee.taltech.iti0202.idcode;

public class IDCode {

    private static final int MIN_GENDER_NUMBER = 1;
    private static final int MAX_GENDER_NUMBER = 6;
    private static final int MIN_YEAR_NUMBER = 0;
    private static final int MAX_YEAR_NUMBER = 99;
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 12;
    private static final int MIN_DAY_NUMBER = 1;
    private static final int FEBRUARY_MAX_DAY_NUMBER = 29;
    private static final int MIN_QUEUE_NUMBER = 1;
    private static final int MAX_QUEUE_NUMBER = 999;
    private static final int MIN_MAX_DAY_NUMBER = 28;
    private static final int YEAR_1800 = 1800;
    private static final int YEAR_1900 = 1900;
    private static final int YEAR_2000 = 2000;
    private static final int MALE_YEAR_1 = 1;
    private static final int FEMALE_YEAR_1 = 2;
    private static final int MALE_YEAR_2 = 3;
    private static final int FEMALE_YEAR_2 = 4;
    private static final int MALE_YEAR_3 = 5;
    private static final int FEMALE_YEAR_3 = 6;

    private static int fullYear;
    private static Gender gender;

    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        return isYearNumberCorrect(idCode) && isMonthNumberCorrect(idCode) && isGenderNumberCorrect(idCode)
                && isDayNumberCorrect(idCode) && isQueueNumberCorrect(idCode) && isControlNumberCorrect(idCode);
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        return Integer.parseInt(String.valueOf(idCode.charAt(0))) >= MIN_GENDER_NUMBER
                && Integer.parseInt(String.valueOf(idCode.charAt(0))) <= MAX_GENDER_NUMBER;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(1, 3)) >= MIN_YEAR_NUMBER
                && Integer.parseInt(idCode.substring(1, 3)) <= MAX_YEAR_NUMBER;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(3, 5)) >= MIN_MONTH_NUMBER
                && Integer.parseInt(idCode.substring(3, 5)) <= MAX_MONTH_NUMBER;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        double maxDays;
        int dayNumber = Integer.parseInt(idCode.substring(5, 7));
        int monthNumber = Integer.parseInt(idCode.substring(3, 5));
        int year = getFullYear(idCode);
        maxDays = MIN_MAX_DAY_NUMBER + (monthNumber + Math.floor(monthNumber / 8)) % 2 + 2 % monthNumber
                + 2 * Math.floor(1 / monthNumber);
        if (!isLeapYear(year)) {
            return (dayNumber >= MIN_DAY_NUMBER) && (dayNumber <= maxDays);
        }
        if (isLeapYear(year)) {
            if (monthNumber == 2) {
                return (dayNumber >= MIN_DAY_NUMBER) && (dayNumber <= FEBRUARY_MAX_DAY_NUMBER);
            }
        } else {
            return (dayNumber >= MIN_DAY_NUMBER) && (dayNumber <= maxDays);
        }
        return false;
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(7, 10)) > MIN_QUEUE_NUMBER
                && Integer.parseInt(idCode.substring(7, 10)) <= MAX_QUEUE_NUMBER;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        int[] multipliers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] multipliers2 = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};

        String[] parts = idCode.split("");


        int[] idCodeArray = new int[parts.length ];


        for (int n = 0; n < parts.length; n++) {
            idCodeArray[n] = Integer.parseInt(parts[n]);
        }

        long value;
        long sum = 0;

        for (int i = 0; i < multipliers1.length; i++) {
            value = multipliers1[i] * idCodeArray[i];
            sum = sum + value;
        }

        long checkNumber = sum % 11;

        if ((checkNumber >= 0) && (checkNumber < 10) && (checkNumber == idCode.charAt(10))) {
            return true;
        } else if (checkNumber == 10) {
            for (int i = 0; i < multipliers2.length; i++) {
                value = multipliers2[i] * idCodeArray[i];
                sum = sum + value;
                long checkNumber2 = sum % 11;

                if ((checkNumber2 >= 0) && (checkNumber2 < 10) && (checkNumber == idCode.charAt(10))) {
                    return true;
                } else if (checkNumber2 == 10) {
                    checkNumber2 = 0;
                    return checkNumber2 == idCode.charAt(10);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isLeapYear(int fullYear) {
        return ((fullYear % 400 == 0) || ((fullYear % 4 == 0) && (fullYear % 100 != 0)));
    }

    public static String getInformationFromIDCode(String idCode) {
        String dayOfBirth = idCode.substring(5, 7);
        String monthOfBirth = idCode.substring(3, 5);
        String yearOfBirth = String.valueOf(getFullYear(idCode));
        String dateOfBirth = dayOfBirth + "." + monthOfBirth + "." + yearOfBirth;

        if (isIDCodeCorrect(idCode)) {
            return "This is a " + getGender(idCode) + " born on " + dateOfBirth;
        } else {
            return "Given invalid ID code!";
        }
    }

    public static Gender getGender(String idCode) {
        char genderDigit = idCode.charAt(0);
        gender = genderDigit % 2 == 0 ? Gender.FEMALE : Gender.MALE;
        return gender;
    }

    public static int getFullYear(String idCode) {
        if (Integer.parseInt(String.valueOf(idCode.charAt(0))) == MALE_YEAR_1
                || Integer.parseInt(String.valueOf(idCode.charAt(0))) == FEMALE_YEAR_1) {
            fullYear = YEAR_1800 + Integer.parseInt(idCode.substring(1, 3));
        } else if (Integer.parseInt(String.valueOf(idCode.charAt(0))) == MALE_YEAR_2
                || Integer.parseInt(String.valueOf(idCode.charAt(0))) == FEMALE_YEAR_2) {
            fullYear = YEAR_1900 + Integer.parseInt(idCode.substring(1, 3));
        } else if (Integer.parseInt(String.valueOf(idCode.charAt(0))) == MALE_YEAR_3
                || Integer.parseInt(String.valueOf(idCode.charAt(0))) == FEMALE_YEAR_3) {
            fullYear = YEAR_2000 + Integer.parseInt(idCode.substring(1, 3));
        }
        return fullYear;
    }

    public static void main(String[] args) {
        // static method we can call directly from static method (main)
        System.out.println(isControlNumberCorrect("48802232723"));
        System.out.println(getInformationFromIDCode("48802232723"));
    }
}
