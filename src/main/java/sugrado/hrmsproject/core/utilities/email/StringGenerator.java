package sugrado.hrmsproject.core.utilities.email;

import java.util.Random;

public class StringGenerator {
    public static String generateRandomString(int length) {

        int leftLimit = 65;
        int rightLimit = 90;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}
