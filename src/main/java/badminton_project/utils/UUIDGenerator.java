package badminton_project.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDGenerator {
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static String getRandomNumber(int len) {
        Random rnd = new Random();
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String getRandomNumber(int len, Long capacityAssessmentPeriodId) {
        Random rnd = new Random();
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder(len);
//        sb.append(capacityAssessmentPeriodId);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
