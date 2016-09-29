package security;

public class Cipher {
    private String plainText;
    private String cipherText;

    public static final String CAESAR_TECHNIQUE = "Caesar_ASCII";

    public Cipher(String cipherTechnique) {
        switch (cipherTechnique) {
            case CAESAR_TECHNIQUE:
                System.out.println("Using CAESAR_TECHNIQUE");
                break;
            default:
                try {
                    throw new UnsupportedCipherTechnique();
                } catch (UnsupportedCipherTechnique e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private String caesarEncrypt() {
        return null;
    }

    public String encrypt(String cipherText) {
        char[] cipherTextCharArray = cipherText.toCharArray();
        char[] encryptedCharArray = new char[cipherTextCharArray.length];
        for (int i=0; i<cipherTextCharArray.length; i++) {
            encryptedCharArray[i] = encode(cipherTextCharArray[i]);
        }
        String encryptedString = "";
        for(int i=0; i<encryptedCharArray.length; i++) {
            encryptedString += encryptedCharArray[i];
        }

        return encryptedString;
    }

    // shifts given char forward by 3 places
    private char encode(char c) {
        int charValue = ((int) c);
        int transformedChar = charValue + 3;
        return ((char) transformedChar);
    }

    // inverse fn. of encode(c)
    private char decode(char c) {
        int charValue = ((int)c);
        int inverseTransformedValue = charValue - 3;
        return ((char)inverseTransformedValue);
    }

    public String decrypt(String encryptedStr) {
        System.out.println("Decrypting CAESAR...");
        char[] encryptedStrCharArray = encryptedStr.toCharArray();
        char[] decryptedStrCharArray = new char[encryptedStrCharArray.length];

        for(int i=0; i<encryptedStrCharArray.length; i++) {
            decryptedStrCharArray[i] = decode(encryptedStrCharArray[i]);
        }

        String decryptedStr = "";
        for(int i=0; i<decryptedStrCharArray.length; i++) {
            decryptedStr += decryptedStrCharArray[i];
        }
        return decryptedStr;
    }

    public String getCipherText() {
        return cipherText;
    }
}
