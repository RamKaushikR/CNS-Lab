public class CaesarCipher {
  
  private int key;

  public CaesarCipher() {
    this.key = 0;
  }
  public CaesarCipher(int k) {
    this.key = k;
  }
  public void setKey(int key) {
    this.key = key;
  }

  public String encrypt(String msg) {
    char [] encryption = new char[msg.length() + 1];
    for(int i=0; i < msg.length(); i++) {

      if(msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z') {
        int c = (int)msg.charAt(i);
        c = 65 + (c + this.key - 65) % 26;
        encryption[i] = (char)c;
      }
      else
        encryption[i] = msg.charAt(i);

    }
    encryption[msg.length()] = '\0';
    return new String(encryption);
  }

  public String decrypt(String msg, int key) {
    char [] decryption = new char[msg.length() + 1];
    for (int i=0; i < msg.length(); i++) {

      if(msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z') {
        int c = (int) msg.charAt(i);
        c = (c - 65 - this.key) % 26;
        c = c < 0 ? c + 26 : c;
        c += 65;
        decryption[i] = (char) c;
      }
      else
        decryption[i] = msg.charAt(i);

    }
    decryption[msg.length()] = '\0';
    return new String(decryption);
  }
}
