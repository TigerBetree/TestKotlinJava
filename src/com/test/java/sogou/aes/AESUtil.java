package com.test.java.sogou.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密工具类
 */
public class AESUtil {
    private static String ivStr = "0102030405060708";//default value

    public static void main(String[] args) {
        String KEY = "vc8v7vghw7v278vn2v8239vh29vh890s";
        String IV = "aqkeezgxijvlm2or";
        try {
            //  oaid : 6128f304a6016c4f, encryptedOaid : k4caVcf5+XOYjlVw0QGt6ayOnpHfzNUxMvkXKOWr/OU=

            String oaid = "6128f304a6016c4f";
            System.out.println("encryptedOaid : " + AESUtil.encryptDES(oaid, KEY, IV));

            String encryptedOaid = "k4caVcf5+XOYjlVw0QGt6ayOnpHfzNUxMvkXKOWr/OU=";
            System.out.println("decryptedOaid : " + AESUtil.decryptAES(encryptedOaid, KEY, IV));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        return encryptDES(encryptString, encryptKey, ivStr);
    }

    public static String encryptDES(String encryptString, String encryptKey, String ivStr) throws Exception {
        // IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
        IvParameterSpec zeroIv = new IvParameterSpec(ivStr.getBytes());
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return new String(Base64Util.encode(encryptedData));
    }

    public static String decryptAES(String decryptString, String decryptKey) throws Exception {
        return decryptAES(decryptString, decryptKey, ivStr);
    }

    public static String decryptAES(String decryptString, String decryptKey, String ivStr) throws Exception {
        byte[] byteMi = Base64Util.decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(ivStr.getBytes());
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);
    }
}
