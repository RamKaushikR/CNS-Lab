public class TranspositionCipher {
  private int[] key;
  int keyLength;

  public TranspositionCipher() {}

  public TranspositionCipher(int[] key, int n) {
    this.key = key;
    this.keyLength = n;
  }

  public void setKey(int[] key, int n) {
    this.key = key;
    this.keyLength = n;
  }

  public int find(int[] key, int val, int n){
    int t = -1;
    for(int i=0;i<n;i++){
      if(key[i] == val)
        t = i;
    }
    return t;
  }
  public int[] sort(int[] arr, int n) {    
    int temp = 0;  
    for(int i=0; i < n; i++){  
      for(int j=1; j < (n-i); j++){  
        if(arr[j-1] > arr[j]){  
          temp = arr[j-1];  
          arr[j-1] = arr[j];  
          arr[j] = temp;  
        }               
      }  
    }
    return arr;
  }  

  public String encryption(String plainText) {
    plainText = plainText.toUpperCase();
    plainText = plainText.replaceAll("\\s", "");
    String encryptedText = "";
    char[][] mat = new char[plainText.length() / this.keyLength + 1][this.keyLength];
    int i = 0, j = 0, index = 0;
    int []arr = new int[10];
    for(int k=0;k<this.keyLength;k++)
      arr[k] = this.key[k];
    // System.out.print("Decryption key: ");
    // for(int k=0;k<this.keyLength;k++)
    //   System.out.print(arr[k] + " ");
    // System.out.println();
    arr = sort(arr, this.keyLength);
    // for(int k=0;k<this.keyLength;k++)
    //   System.out.println(arr[k]);
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
        int v = find(this.key, arr[j],this.keyLength);
        encryptedText += String.valueOf(mat[i][v]);
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
        decryptedText += String.valueOf(mat[i][this.key[j]-1]);
      }
    }
    return decryptedText;
  }
}
