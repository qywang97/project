package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class encrypt {
    public static final String VIPARA = "0102030405060708";
    public static final String BM = "UTF-8";

    public static String encrypt(String content, String password) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
        SecretKeySpec key = getKey(password);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(content.getBytes(BM));
        String encryptResultStr = parseByte2HexStr(encryptedData);
        return encryptResultStr; // 加密
    }

    public static String decrypt(String content, String password) throws Exception {
        content = new String(content.getBytes("UTF-8"));
        byte[] decryptFrom = parseHexStr2Byte(content);
        IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
        SecretKeySpec key = getKey(password);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte[] decryptedData = cipher.doFinal(decryptFrom);

        return new String(decryptedData,BM);
    }


    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");

        return skeySpec;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }


    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> req = new HashMap<>();
        Map<String, String> param = new HashMap<>();
        param.put("name", "陈威");
        param.put("idNo", "352225199403202530");
        param.put("phone", "13385060952");
        req.put("encryptType", "AES");
        String appId = "1FKOF50P2000BA58A8C00000D4B7C284";
        String appSecret = "1FKOF5DML000BA58A8C000004E5BAE51";
        String newPassword = encrypt(appSecret, appId);
        System.out.println("newPassword=" + newPassword);
//        String enc = encrypt(JSON.toJSONString(param), newPassword);
//        req.put("encryptData", enc);
//        System.out.println("加密后");
//        System.out.println(enc);
//        req.put("appId", appId);
//        String data = JSON.toJSONString(req);
//        data = URLEncoder.encode(data, "UTF-8");
//        String url = "http://alilive.ylzpay.cn:1400/portal-wx/external/index?data=" + data;
//        System.out.println("访问链接");
//        System.out.println(url);
    }
}
