package com.test.java.sogou.aes;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

/**
 * 请求参数AES解密
 */
public class TestAES {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            decode(s);
        }
    }

    public static void decode(String data) {
        try {
            byte[] content = new BASE64Decoder().decodeBuffer(data);

            String result = decrypt(content, "uAOP0xKTQel8fdiL");

            System.out.println(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(byte[] cryptedText, String password) {

        try {
            byte[] raw = password.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("0000000000000000".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, getIV());
            byte[] original = cipher.doFinal(cryptedText);
            return new String(original, "UTF-8");
        } catch (Exception e) {
            System.out.println(String.format("AES decryption operation has exception,content:{},password:{}", cryptedText, password, e));
        }
        return null;
    }

    public static IvParameterSpec getIV() {
        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        IvParameterSpec ivParameterSpec;
        ivParameterSpec = new IvParameterSpec(iv);
        return ivParameterSpec;
    }
}
