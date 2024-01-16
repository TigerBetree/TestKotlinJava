package com.test.aes;


import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * RSA加密工具类
 * EC和RSA的优缺点：
 * RSA的优点：JDK自己支持。不需要第三方库。同时支持RSA的开发库也很多（最典型的就是OpenSSL）
 * EC的缺点： 需要第三方库，支持的广度比不上RSA
 * EC的优点： 1.在达到相同加密程度下，EC需要的秘钥长度比RSA要短得多
 * 2.bouncycastle实现的EC加密算法，对密文长度的限制比较松。在下面的测试程序中构造了一个长字符串加密，没有报错。
 * RSA的加密则是有限制的，必须分片。
 * 明文长度(bytes) = (加密长度/8 -11)
 * 片数=(明文长度(bytes)/(密钥长度(bytes)-11))的整数部分+1,就是不满一片的按一片算
 * 密文长度=密钥长度*片数
 * <p>
 * 在移动端获取解密的Cipher类时要使用Cipher.getInstance("RSA/ECB/PKCS1Padding");
 * 在后端使用Cipher.getInstance("RSA");来获取
 * <p>
 */
public class RSAUtils {


    /**
     * 生成RSA秘钥
     *
     * @return 秘钥对
     * @throws Exception
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");//加密方式
        keyPairGenerator.initialize(2048);//加密长度
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 获取RSA公钥并转为Base64编码
     *
     * @param keyPair 秘钥对
     * @return RSA公钥
     */
    public static String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return GFBase64.encode(bytes);
    }


    /**
     * 获取RSA私钥并转为Base64编码
     *
     * @param keyPair 秘钥对
     * @return RSA私钥
     */
    public static String getPrivateKey(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return GFBase64.encode(bytes);
    }


    /**
     * 将Base64编码后的公钥转换成PublicKey对象
     *
     * @param
     * @return PublicKey公钥对象
     * @throws Exception
     */
    public static PublicKey string2PublicKey(byte[] keyBytes) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 将Base64编码后的私钥转换成PrivateKey对象
     *
     * @return PrivateKey私钥对象
     * @throws Exception
     */
    public static PrivateKey string2PrivateKey(byte[] keyBytes) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }


    /**
     * 公钥加密
     * 在移动端获取解密的Cipher类时要使用Cipher.getInstance("RSA/ECB/PKCS1Padding");
     * 在后端使用Cipher.getInstance("RSA");来获取
     *
     * @param content   加密的内容
     * @param publicKey PublicKey公钥对象
     * @return 加密后的字节数组
     * @throws Exception
     */
    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }


    /**
     * 私钥去解密
     * 在移动端获取解密的Cipher类时要使用Cipher.getInstance("RSA/ECB/PKCS1Padding");
     * 在后端使用Cipher.getInstance("RSA");来获取
     *
     * @param content    需要解密的内容
     * @param privateKey PrivateKey私钥对象
     * @return 解密后的字节数组
     * @throws Exception
     */
    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    //公钥解密
    public static byte[] decryptByPublicKey(byte[] contentByte) throws Exception {

        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(RSA_PUBLIC_KEY);
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyf.generatePublic(pubKeySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return cipher.doFinal(contentByte);
    }

    public static byte[] decryptByPublicKey(byte[] contentByte, int inputOffset, int inputLen) throws Exception {

        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(RSA_PUBLIC_KEY);
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyf.generatePublic(pubKeySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return cipher.doFinal(contentByte, inputOffset, inputLen);
    }

//    private final static byte[] RSA_PUBLIC_KEY = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZaQSRPkDXIWwifsA0FSbzyYFj" +
//            "N4t/wOcwnQsMpJ75iBiQ9ysh2xmp82iE0/QsozJ7vZzQpTf0NqSfjoLEXOgyCvju" +
//            "kiJQLaFK6PBFiQQUEvH13GKNNaIl8yWNsQydwTgVaNpbkbQgzhCD5AFuNe0tl4IV" +
//            "M12ZTX1fLB2xTHb0QQIDAQAB");

    private final static byte[] RSA_PUBLIC_KEY = GFBase64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3tfwuSEoSr+qpHl6QUAfzTeh8" +
            "3WkR0lXwuVUzyE6H5z/nP+JzX+h6ctmMbrwgAfuk+U6rHCNZTa8rlre5kdeaXE6O" +
            "2fB4mV9CSlL1et93t3p1GZtmZk38PoO3r3rsTt5eGiWn9fboKT6VQZiX0Vu3XJBJ" +
            "JplDKoSlBQ0bx7dXmQIDAQAB");


    static String decode(String src) {
        StringBuilder dst = new StringBuilder();
        int length = null != src ? src.length() : 0;
        for (int i = 0; i < length; i++) {
            char c = src.charAt(i);
            if (c >= '!' && c <= '~') {
                c -= 20;
                if (c < '!') {
                    dst.append((char) (c + '~' - '!'));
                } else {
                    dst.append(c);
                }
            } else {
                dst.append(c);
            }
        }
        return dst.toString();
    }

}
