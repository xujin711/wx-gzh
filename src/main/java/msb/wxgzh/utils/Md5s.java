package msb.wxgzh.utils;

import java.security.MessageDigest;

public class Md5s {


    //sign=hash_hmac("sha256",stringSignTemp,key).toUpperCase()="6A9AE1657590FD6257D693A078E1C3E4BB6BA4DC30B23E0EE2496E54170DACD6" //注：HMAC-SHA256签名方式


    public static void main(String[] args) throws Exception {

        String stringA="appid=wxe32d77f767465935&body=test&device_info=1000&mch_id=1495306952&nonce_str=ibuaiVcKdpRxkhJA";


        //String appid="wxe32d77f767465935";
        String stringSignTemp=stringA+"&key=67b764519dbf910ac943d9ad7c77856f";  //注：key为商户平台设置的密钥keys
        String  sign=MD5(stringSignTemp);//注：MD5签名方式.toUpperCase()="9A0A8659F005D6984697E2CA0A9CF3B7";

        System.out.println(sign.toUpperCase());


    }


    public static String MD5(String str) throws Exception {
        /** 创建MD5加密对象 */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        /** 进行加密 */
        md5.update(str.getBytes());
        /** 获取加密后的字节数组 */
        byte[] md5Bytes = md5.digest();
        String res = "";
        for (int i = 0; i < md5Bytes.length; i++) {
            int temp = md5Bytes[i] & 0xFF;
            if (temp <= 0XF) { // 转化成十六进制不够两位，前面加零
                res += "0";
            }
            res += Integer.toHexString(temp);
        }
        return res;




/*

    public static String MD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return getHashString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }
*/
    }

}
