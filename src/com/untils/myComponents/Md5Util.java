package com.untils.myComponents;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName Md5Util
 * @Description MD5进行加密
 * @Author 王群勇
 * @Date 2021/9/13 16:32
 * @Version 1.0
 */
public class Md5Util {
    /**
     * MD5加密后生成32位长度字符串并转换成大写
     *
     * @param plainText 明文
     * @return 32位密文
     */
    public static String encrypte(String plainText) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5.toUpperCase();
    }
}
