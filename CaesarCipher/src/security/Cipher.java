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

        return null;
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

    public String decrypt() {
        System.out.println("Decrypting CAESAR...");
        return "Decrypting CAESAR...";
    }

    public String getCipherText() {
        return cipherText;
    }
}
