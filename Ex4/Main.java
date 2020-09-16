import java.util.*;

class Main {
  private static int[] hexToBits(String hexValue) {
    int[] bits = new int[64];
    for(int i=0; i < 16; i++) {
      String s = Integer.toBinaryString(Integer.parseInt(hexValue.charAt(i) + "", 16));

      while(s.length() < 4)
        s = "0" + s;
      
      for(int j=0; j < 4; j++)
        bits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
    }
    return bits;
  }

  private static int[] asciiToBits(String asciiValue) {
    char[] chars = asciiValue.toCharArray();
    StringBuffer hex = new StringBuffer();
    for (int i = 0; i < chars.length; i++)
      hex.append(Integer.toHexString((int) chars[i]));
    
    return hexToBits(hex.toString());
  }

  private static String hexToASCII(String hexValue) {
    StringBuilder output = new StringBuilder("");
    for (int i = 0; i < hexValue.length(); i += 2) {
      String str = hexValue.substring(i, i + 2);
      output.append((char) Integer.parseInt(str, 16));
    }
    return output.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;
    DES des = new DES();

    do {
      System.out.print("1. Encryption\n2. Decryption\n3. Exit\nEnter your choice: ");
      choice = sc.nextInt();
      sc.nextLine();

      if(choice == 1) {        
        System.out.print("Enter plain text: ");
        String plainText = sc.nextLine();
        int[] inputBits = asciiToBits(plainText);

        System.out.print("Enter the key text: ");
        String keyText = sc.nextLine();
        int[] keyBits = asciiToBits(keyText);

        System.out.println("Encrypted Hex Value: " + des.encryption(inputBits, keyBits));
      }

      else if(choice == 2) {
        System.out.print("Enter encrypted hex value: ");
        String encryptedHex = sc.nextLine();
        int[] inputBits = hexToBits(encryptedHex);

        System.out.print("Enter key text: ");
        String keyText = sc.nextLine();
        int[] keyBits = asciiToBits(keyText);

        String decryptedHex = des.decryption(inputBits, keyBits);
        System.out.println("Decrypted Text: " + hexToASCII(decryptedHex));
      }

    } while(choice != 3);
  }
}
