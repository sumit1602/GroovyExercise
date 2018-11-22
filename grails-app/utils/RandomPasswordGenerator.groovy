import org.apache.commons.lang.RandomStringUtils

public class RandomPasswordGenerator {
//    def static getRandomPassword(int len) {
//        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
//        String numbers = "0123456789";
//        String symbols = "!@#^&*+-/.?<>)";
//
//
//        String values = Capital_chars + Small_chars +
//                numbers + symbols;
//
//
//        Random rndm_method = new Random();
//
//        char[] password = new char[len];
//
//        for (int i = 0; i < len; i++) {
//            // Use of charAt() method : to get character value
//            // Use of nextInt() as it is scanning the value as int
//            password[i] = values.charAt(rndm_method.nextInt(values.length()));
//
//        }
//        return password;
//    }
    def static getRandomPassword() {
        String charset = (('A'..'Z') + ('0'..'9')).join()
        Integer length = 6
        String randomString = RandomStringUtils.random(length, charset.toCharArray())
        return randomString
    }
}