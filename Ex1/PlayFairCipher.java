import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class PlayFairCipher {

  private char playFairMatrix[][] = new char[5][5];
  private String key = new String();

  public PlayFairCipher() {}

  public PlayFairCipher(String key) {
    this.key = key;
    getMatrix(key);
  }

  public void setKey(String key) {
    this.key = key;
    getMatrix(key);
  }

  public void getMatrix(String key) {
    int length = key.length();
    int index = 0;
    Set<String> visited = new HashSet<String>();
    int filled = 0, i = 0, j = 0;
    char alphabet = 'A';

    while(filled < 25) {

      if(index < length) {
        char c = key.charAt(index);
        String value = String.valueOf(c);
        if(! visited.contains(value)) {
          visited.add(value);
          this.playFairMatrix[i][j] = c;
          j = (j + 1) % 5;
          if(j == 0)
            i = (i + 1) % 5;
          filled++;
        }
        index++;
      }
      else {
        while((visited.contains(String.valueOf(alphabet)) || alphabet == 'J') && alphabet <= 'Z')
          alphabet = (char) (alphabet + 1);
        
        this.playFairMatrix[i][j] = alphabet;
        visited.add(String.valueOf(alphabet));
        j = (j + 1) % 5;
        if(j == 0)
          i = (i + 1) % 5;
        filled++;
        alphabet = (char) (alphabet + 1);
      }

    }
  }

  public Point getIndex(char k) {
    Point location = new Point();
    for(int i=0; i < 5; i++) {
      for(int j=0; j < 5; j++) {
        if(this.playFairMatrix[i][j] == k || (this.playFairMatrix[i][j] == 'I' && k == 'J')) {
          location.x = i;
          location.y =  j;
          return location;
        }
      }
    }
    return location;
  }

  public char[] getEncryptionPair(char c1, char c2) {
    Point locationC1 = getIndex(c1);
    Point locationC2 = getIndex(c2);

    char encrypt1 = this.playFairMatrix[locationC1.x][locationC2.y];
    char encrypt2 = this.playFairMatrix[locationC2.x][locationC1.y];
    return new char[]{encrypt1, encrypt2};
  }

  public String encrypt(String msg) {
    int n = msg.length();
    String encryptedMessage  = "";

    if(n % 2 == 1) {
      msg = msg + 'x';
      n++;
    }
    for(int i=0; i<n; i+=2) {
      char excryptedPair[] = getEncryptionPair(msg.charAt(i), msg.charAt(i+1));
      encryptedMessage = encryptedMessage + String.valueOf(excryptedPair[0]) + String.valueOf(excryptedPair[1]);
    }
    return encryptedMessage;
  }
  
  public String decrypt(String msg) {
    int n = msg.length();
    String decryptedMessage  = "";

    if (n % 2 == 1) {
      msg = msg + "x";
      n++;
    }
    for(int i=0; i<n; i+=2) {
      char decryptedPair[] = getEncryptionPair(msg.charAt(i), msg.charAt(i+1));
      decryptedMessage = decryptedMessage + String.valueOf(decryptedPair[0]) + String.valueOf(decryptedPair[1]);
    }
    return decryptedMessage;
  }

  public void printPlayFairMatrix() {
    for(int i=0; i<5; i++) {
      for(int j=0; j<5; j++)
        System.out.print(this.playFairMatrix[i][j]);
      System.out.print("\n");
    }
  }
}
