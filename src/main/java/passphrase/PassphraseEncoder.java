package passphrase;

public class PassphraseEncoder {

    static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c += 32;
                sb.append(c);
            }
            else if(Character.isLowerCase(c)){
                c -= 32;
                sb.append(c);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String decode(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c += 32;
                sb.append(c);
            }else if (Character.isLowerCase(c)) {
                c -= 32;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
