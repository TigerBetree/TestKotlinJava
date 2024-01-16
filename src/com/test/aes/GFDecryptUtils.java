package com.test.aes;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class GFDecryptUtils {

    /**
     * 采用AES加密算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 字符编码(用哪个都可以，要注意new String()默认使用UTF-8编码 getBytes()默认使用ISO8859-1编码)
     */
    private static final String CHARSET_UTF8 = "utf-8";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String CIPHER_ALGORITHM2 = "AES/CBC/PKCS5Padding";


    private final static int IDX_FILE_BYTE_FROM = 0;
    private final static int IDX_FILE_BYTE_LEN = 4;
    private final static int IDX_FILE_SIZE_KEY_FROM = IDX_FILE_BYTE_FROM + IDX_FILE_BYTE_LEN;
    private final static int IDX_FILE_SIZE_KEY_LEN = 4;
    private final static int IDX_FILE_SIZE_CONTENT_FROM = IDX_FILE_SIZE_KEY_FROM + IDX_FILE_SIZE_KEY_LEN;
    private final static int IDX_FILE_SIZE_CONTENT_LEN = 4;
    private final static int IDX_FILE_BODY_PUB_KEY_FROM = IDX_FILE_SIZE_CONTENT_FROM + IDX_FILE_SIZE_CONTENT_LEN;

    /**
     * AES 加密
     *
     * @param secretKey 加密密码，长度：16 或 32 个字符
     * @param data      待加密内容
     *
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String secretKey, String data) {
        try {
            // 创建AES秘钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(CHARSET_UTF8), KEY_ALGORITHM);
            // 创建密码器
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            // 初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptByte = cipher.doFinal(data.getBytes(CHARSET_UTF8));
            // 将加密以后的数据进行 Base64 编码
            return base64Encode(encryptByte);
        } catch (Exception e) {
            handleException("encrypt", e);
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param secretKey  解密的密钥，长度：16 或 32 个字符
     * @param base64Data 加密的密文 Base64 字符串
     */
    public static String decrypt(String secretKey, String base64Data) {
        try {
            byte[] data = base64Decode(base64Data);
            // 创建AES秘钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(CHARSET_UTF8), KEY_ALGORITHM);
            // 创建密码器
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            // 初始化解密器
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            // 执行解密操作
            byte[] result = cipher.doFinal(data);
            return new String(result, CHARSET_UTF8);
        } catch (Exception e) {
            handleException("decrypt", e);
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param secretKey  解密的密钥，长度：16 或 32 个字符
     * @param base64Data 加密的密文 Base64 字符串
     */
    public static String decrypt(byte[] secretKey, byte[] base64Data, int inputOffset, int inputLen) {
        try {
            // 创建AES秘钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, KEY_ALGORITHM);
            // 创建密码器
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM2);
            IvParameterSpec iv = new IvParameterSpec("3ve63QHlE912Tcup".getBytes(CHARSET_UTF8));
            // 初始化解密器
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

            // 执行解密操作
            byte[] result = cipher.doFinal(base64Data, inputOffset, inputLen);
            return new String(result, CHARSET_UTF8);

        } catch (Exception e) {
            handleException("decrypt", e);
        }
        return "";

    }

    /**
     * AES 解密
     *
     * @param secretKey  解密的密钥，长度：16 或 32 个字符
     * @param base64Data 加密的密文 Base64 字符串
     */
    public static String decrypt(byte[] secretKey, byte[] base64Data) throws Exception {
        // 创建AES秘钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, KEY_ALGORITHM);
        // 创建密码器
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM2);
        IvParameterSpec iv = new IvParameterSpec("3ve63QHlE912Tcup".getBytes(CHARSET_UTF8));
        // 初始化解密器
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

        // 执行解密操作
        byte[] result = cipher.doFinal(base64Data);
        return new String(result, CHARSET_UTF8);
    }

    /**
     * 将 字节数组 转换成 Base64 编码 用Base64.DEFAULT模式会导致加密的text下面多一行（在应用中显示是这样）
     */
    public static String base64Encode(byte[] data) {
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

    /**
     * 将 Base64 字符串 解码成 字节数组
     */
    public static byte[] base64Decode(String data) {
        return Base64.decode(data, Base64.NO_WRAP);
    }

    /**
     * 处理异常
     */
    private static void handleException(String methodName, Exception e) {
        e.printStackTrace();
        logError(e.getMessage());

    }

    public static String getContentBody(String content) throws Exception {
        byte[] decode = base64Decode(content);

        int keyLength = toInt(decode, IDX_FILE_SIZE_KEY_FROM, IDX_FILE_SIZE_KEY_LEN);
        int contentLength = toInt(decode, IDX_FILE_SIZE_CONTENT_FROM, IDX_FILE_SIZE_CONTENT_LEN);
        byte[] pubKeyBytes = RSAUtils.decryptByPublicKey(decode, IDX_FILE_BODY_PUB_KEY_FROM, keyLength);

        int idxContentFrom = IDX_FILE_BODY_PUB_KEY_FROM + keyLength;
        String string = decrypt(pubKeyBytes, decode, idxContentFrom, contentLength);

        int idxCheckFrom = idxContentFrom + contentLength;
        byte[] checkCodeByte = new byte[32];
        System.arraycopy(decode, idxCheckFrom, checkCodeByte, 0, checkCodeByte.length);
        String checkString = new String(checkCodeByte, "utf-8");
        String md5String = Md5Util.encrypt32Lower(string);

        if (checkString.equals(md5String)) {
            return string;
        } else {
            logError("check fail");
            return "jysb";
        }
    }


    private static int toInt(byte[] b) {
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            res += (b[i] & 0xff) << (i * 8);
        }
        return res;
    }

    private static int toInt(byte[] b, int posFrom, int posLength) {
        int res = 0;
        for (int i = posFrom; i < posFrom + posLength; i++) {
            res += (b[i] & 0xff) << (i * 8);
        }
        return res;
    }

    public static void logError(String desc) {
    }

    public static void main(String[] args) {
        String content = "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";
        try {
            String result = GFDecryptUtils.getContentBody(content);
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
