import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.*;

public class RSA {

  public void generateKey() {
    BigInteger p, q, N, phi, e, d;
    int bitlength = 1024;
    Random r;

    r = new Random();
    p = BigInteger.probablePrime(bitlength, r);
    q = BigInteger.probablePrime(bitlength, r);
    N = p.multiply(q);
    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    e = BigInteger.probablePrime(bitlength / 2, r);

    while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
      e.add(BigInteger.ONE);

    d = e.modInverse(phi);

    System.out.println("Public key\ne: " + e + "\nN: " + N);
    System.out.println("Private key\nd: " + d + "\nN: " + N);
  }

  public BigInteger encryption(String message, BigInteger e, BigInteger N) {
    return (new BigInteger(message)).modPow(e, N);
  }

  public String decryption(BigInteger message, BigInteger d, BigInteger N) {
    return message.modPow(d, N).toString();
  }
}
