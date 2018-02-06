package com.limovue.common.util;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class SignatureUtils {
    public static final String DEFAULT_CHARTSET = "UTF-8";
    public static final String KEYPAIRGENERATOR = "RSA";
    public static final String SIGNATURE = "SHA1WithRSA";
    public static final Integer INITIALIZE = 1024;

    /**
     * 得到产生的私钥/公钥对
     *
     * @return
     */
    public static KeyPair getKeypair() {
        //产生RSA密钥对(myKeyPair)
        KeyPairGenerator myKeyGen = null;
        try {
            myKeyGen = KeyPairGenerator.getInstance(KEYPAIRGENERATOR);
            myKeyGen.initialize(INITIALIZE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair myKeyPair = myKeyGen.generateKeyPair();
        return myKeyPair;
    }

    /**
     * 根据密钥对对信息进行加密，返回公钥值
     *
     * @param mySig
     * @param myKeyPair
     * @param infomation
     * @return
     */
    public static byte[] getpublicByKeypair(Signature mySig, KeyPair myKeyPair, byte[] infomation) {
        byte[] publicInfo = null;
        try {
            mySig.initSign(myKeyPair.getPrivate());  //用私钥初始化签名对象
            mySig.update(infomation);  //将待签名的数据传送给签名对象
            publicInfo = mySig.sign();  //返回签名结果字节数组
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicInfo;
    }

    /**
     * 公钥验证签名
     *
     * @param mySig
     * @param myKeyPair
     * @param infomation
     * @param publicInfo
     * @return
     * @author hym
     */
    public static boolean decryptBypublic(Signature mySig, KeyPair myKeyPair, String infomation, byte[] publicInfo) {
        boolean verify = false;
        try {
            mySig.initVerify(myKeyPair.getPublic());  //使用公钥初始化签名对象,用于验证签名
            mySig.update(infomation.getBytes()); //更新签名内容
            verify = mySig.verify(publicInfo); //得到验证结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verify;
    }


    public static void main(String[] args) {
        String info = "{\"memberId\":\"15000657221\"}";
        try {
            KeyPair keyPair = getKeypair();
            Signature mySig = Signature.getInstance(SIGNATURE);//用指定算法产生签名对象
            byte[] publicinfo = getpublicByKeypair(mySig, keyPair, info.getBytes(DEFAULT_CHARTSET));
            boolean verify = decryptBypublic(mySig, keyPair, info, publicinfo);
            System.out.println("验证签名的结果是：" + verify);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
