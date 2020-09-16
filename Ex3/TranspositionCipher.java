public class TranspositionCipher {
  private int[] key, decryptKey;
  int keyLength;

  public TranspositionCipher() {}

  public TranspositionCipher(int[] key, int n) {
    this.key = key;
    this.keyLength = n;
    calculateDecryptionKey();
  }

  public void setKey(int[] key, int n) {
    this.key = key;
    this.keyLength = n;
    calculateDecryptionKey();
  }

  private void calculateDecryptionKey() {
    this.decryptKey = new int[this.keyLength];
    for(int i = 0;i < this.keyLength;i++)
      this.decryptKey[this.key[i] - 1] = i + 1;
    System.out.print("Decryption key is: ");
    for(int i = 0;i < this.keyLength;i++){
      if(i != this.keyLength - 1)
        System.out.print(this.decryptKey[i] + " ");
      else
        System.out.println(this.decryptKey[i]);
    }
  }

  public String encryption(String plainText) {
    plainText = plainText.toUpperCase();
    plainText = plainText.replaceAll("\\s", "");
    String encryptedText = "";
    char[][] mat = new char[plainText.length() / this.keyLength + 1][this.keyLength];
    int i = 0, j = 0, index = 0;

    while(index < plainText.length()) {
      mat[i][j] = plainText.charAt(index);
      index++;
      if(j + 1 == this.keyLength) i++;
      j = (j + 1) % this.keyLength;
    }

    while(j != 0) {
      mat[i][j] = 'X';
      j = (j + 1) % this.keyLength;
    }

    int m = i;
    if(plainText.length() % this.keyLength != 0)
      m++;
    for(j = 0;j < this.keyLength;j++) {
      for(i = 0;i < m;i++){
        encryptedText += String.valueOf(mat[i][this.key[j] - 1]);
      }
    }
    return encryptedText;
  }

  public String decryption(String encryptedText){
    encryptedText = encryptedText.toUpperCase();
    encryptedText = encryptedText.replaceAll("\\s", "");
    String decryptedText = "";
    char[][] mat = new char[encryptedText.length() / this.keyLength + 1][this.keyLength];
    int i = 0, j = 0, index = 0;
    int rows = encryptedText.length() / this.keyLength;

    while(index < encryptedText.length()) {
      mat[i][j] = encryptedText.charAt(index);
      index++;
      if(i + 1 == rows) j++;
      i = (i + 1) % rows;
    }

    for(i = 0;i < rows;i++) {
      for(j = 0;j < this.keyLength;j++){
        decryptedText += String.valueOf(mat[i][this.decryptKey[j]-1]);
      }
    }
    return decryptedText;
  }
}
