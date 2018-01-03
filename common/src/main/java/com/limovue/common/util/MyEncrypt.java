package com.limovue.common.util;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加解密
 */
public class MyEncrypt {

    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_MAC = "HmacMD5";

    /**
     * BASE64解密
     */
    public static byte[] decryptBASE64(byte[] dest) {
        if (dest == null) {
            return null;
        }
        return Base64.decodeBase64(dest);
    }

    /**
     * BASE64加密
     */
    public static byte[] encryptBASE64(byte[] origin) {
        if (origin == null) {
            return null;
        }
        return Base64.encodeBase64(origin);
    }

    /**
     * SHA加密
     *
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encryptSHA(byte[] data)
            throws NoSuchAlgorithmException {
        if (data == null) {
            return null;
        }
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);
        return sha.digest();
    }

    /**
     * 初始化HMAC密钥
     *
     */
    public static String initMacKey(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_MAC);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGenerator.generateKey();
        return new String(encryptBASE64(secretKey.getEncoded()));
    }

    /**
     * HMAC加密
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static byte[] encryptHMAC(byte[] data, String key){
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key.getBytes()),
                KEY_MAC);
        Mac mac = null;
        try {
            mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return mac.doFinal(data);
    }

    /*public static void main(String[] args){
        System.out.println(MyEncrypt.initMacKey());

        System.out.println("args = [BOS7AMZ+idWkXRzK7kV8P91utMw/P/icrR42bSOxlgits1tRvW8qUSaJHXOTNOmpey+YTZGkVR4vIMYKJpEfmg==]");
    }*/
}
