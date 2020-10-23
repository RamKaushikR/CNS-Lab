import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import javax.swing.*;

class AES {
	byte[] skey = new byte[1000];
	String skeyString;
	byte[] raw;
	String plainText, encryption, decryption;
	
	public AES() {
		try {
			generateSymmetricKey();
			plainText = JOptionPane.showInputDialog(null, "Enter plain text");
			byte[] ptbytes = plainText.getBytes();
			
			byte[] ebytes = encrypt(raw, ptbytes);
			encryption = new String(ebytes);
			JOptionPane.showMessageDialog(null, "Encrypted Text: " + encryption);
			
			byte[] dbytes = decrypt(raw, ebytes);
			String decryption = new String(dbytes);
			JOptionPane.showMessageDialog(null, "Decrypted Text: " + decryption);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void generateSymmetricKey() {
		try {
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(num);
			byte[] knumb = knum.getBytes();
			skey = getRawKey(knumb);
			skeyString = new String(skey);
			JOptionPane.showMessageDialog(null, "AES Symmetric key: " + skeyString);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(128, sr);
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}
	
	private byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}
	
	private byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}
}
