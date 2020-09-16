class RailFenceCipher {
  int depth;

  String encryption(String plainText, int depth) {
    int r = depth, len = plainText.length();
    int row = 0, col = 0;
    char mat[][] = new char[r][len];
    boolean dir = false;
    String cipherText = "";

    for(int i = 0;i < r;i++)
      for(int j = 0;j < len;j++)
        mat[i][j] = '\0';

    for(int i = 0;i < len;i++) {
      if(row == 0 || row == depth - 1)
        dir = !dir;
      mat[row][col] = plainText.charAt(i);
      col += 1;

      if(dir) row++;
      else row--;
    }

    for(int i = 0;i < r;i++) {
      for(int j = 0;j < len;j++){
        if(mat[i][j] != '\0') cipherText += mat[i][j];
      }
    }
    return cipherText;
  }

  String decryption(String cipherText, int depth) {
    int r = depth, len = cipherText.length();
    int row = 0, col = 0;
    boolean dir = false;
    char mat[][] = new char[r][len];
    String plainText = "";

    for(int i = 0;i < r;i++)
      for(int j = 0;j < len;j++)
        mat[i][j] = '\0';
  
    for(int i = 0;i < len;i++) {
      if(row == 0) dir = true;
      if(row == depth - 1) dir = false;

      mat[row][col] = '*';
      col++;

      if(dir) row++;
      else row--;
    }
    
    int index = 0;
    for(int i = 0;i < depth;i++) {
      for(int j = 0;j < len;j++) {
        if(mat[i][j] == '*' && index < len) {
          mat[i][j] = cipherText.charAt(index);
          index++;
        }
      }
    }

    row = 0;
    col = 0;
    for(int i = 0;i < len;i++) {
      if(row == 0) dir = true;
      if(row == depth - 1) dir = false;

      if(mat[row][col] != '\0') {
        plainText += mat[row][col];
        col++;
      }
      if(dir) row++;
      else row--;
    }
    return plainText;
  }
}
