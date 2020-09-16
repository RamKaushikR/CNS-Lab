import java.util.*;

public class VigenereCipher {

  public VigenereCipher() {
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("1. Encrypt\n2. Decrypt\n3. Print table\n4. Exit\nEnter your choice: ");
      choice = sc.nextInt();

      if(choice == 1) {
        System.out.print("Enter the plain text: ");
        String plainText = sc.next();
        System.out.print("Enter the key: ");
        String key = sc.next();
        String encrypted = encryption(plainText, generateKey(plainText, key));
        System.out.println("Encrypted message is: " + encrypted);
      }

      else if(choice == 2) {
        System.out.print("Enter the encrypted text: ");
        String encryptedText = sc.next();
        System.out.print("Enter the key: ");
        String key = sc.next();
        String decrypted = decryption(encryptedText, generateKey(encryptedText, key));
        System.out.println("Encrypted message is: " + decrypted);
      }

      else if(choice == 3) printTable(generateTable());

      else return;

    } while(choice != 4);
  }

  private char[][] generateTable() {
    char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[][] table = new char[26][26];

    for (int i = 0;i < 26;i++)
      for (int j = 0;j < 26;j++)
        table[i][j] = alphabets[(i + j) % 26];
    return table;
  }

  private void printTable(char table[][]) {
    for(int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++)
        System.out.print(table[i][j] + " ");
      System.out.println("");
    }
  }

  private String generateKey(String plainText, String key) {
    char[] keyArray = key.toCharArray();
    StringBuilder cipherKey = new StringBuilder();
    
    for(int i = 0; i < plainText.length(); i++)
      cipherKey.append(Character.toString(keyArray[i % key.length()]));   
    return cipherKey.toString(); 
  }

  private String encryption(String plainText, String cipherKey) {
    char[][] table = generateTable();
    char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();   
    StringBuilder alphaIndex = new StringBuilder();
    
    for(char c : alphabets)
      alphaIndex.append(Character.toString(c));
    
    char[] plainTextArray = plainText.toCharArray();
    char[] cipherKeyArray = cipherKey.toCharArray();   
    StringBuilder encryptionText = new StringBuilder();
    
    for(int i = 0; i < plainText.length(); i++) {
      int i1 = alphaIndex.indexOf(Character.toString(plainTextArray[i]));
      int i2 = alphaIndex.indexOf(Character.toString(cipherKeyArray[i]));
      encryptionText.append(Character.toString(table[i1][i2]));
    }
    return encryptionText.toString(); 
  }

  private char returnTableIndex(char[][] table, Integer a, char b) {
    int index = 0;
    for(int i = 0; i < 26; i++) {
      if (table[a][i] == b) {       
        index = i;
        break;     
      }   
    }
    return table[0][index]; 
  }

  private String decryption(String plainText, String cipherKey) {
    char[][] table = generateTable();
    char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();   
    StringBuilder alphaIndex = new StringBuilder();
    
    for(char c : alphabets)
      alphaIndex.append(Character.toString(c));
    
    char[] plainTextArray = plainText.toCharArray();
    char[] cipherKeyArray = cipherKey.toCharArray();   
    StringBuilder decryptionText = new StringBuilder();
    
    for (int i = 0; i < plainText.length(); i++) {
      int i1 = alphaIndex.indexOf(Character.toString(cipherKeyArray[i]));
      char i2 = plainTextArray[i];
      decryptionText.append(Character.toString(returnTableIndex(table, i1, i2)));
    }
    return decryptionText.toString(); 
  }
}
