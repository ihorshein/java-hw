package org.ihorshein.lesson4.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
  public static String toSha1(String input) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      byte[] result = messageDigest.digest(input.getBytes());
      StringBuilder hexString = new StringBuilder();
      for (byte b : result) {
        hexString.append(String.format("%02x", b));
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Hash algorithm not found.");
    }
  }
}
