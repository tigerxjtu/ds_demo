package cn.dataguru.dianshang.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class EncryptionUtil {
    final static Base64 base64 = new Base64();
    /**         * Escape编码
     *  * @param src 待加盐字符串
     *  * @return 加盐字符串
     *  */
    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)|| Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }
    /**
     * * Escape解码
     *  * @param src 加盐字符串
     *  * @return 明文
     *  */
    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;                    }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    public static  String enbase64(String srouce){
        String result = "";
        try {
            final byte[] textByte = srouce.getBytes("UTF-8");
            result = base64.encodeToString(textByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String unbase64(String source){
        String reuslt = "";
        try {
            reuslt = new String(base64.decode(source),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return reuslt;
    }

    public static String myenAlgorithm(String source){
        String r1 = source.substring(0,1);
        String r2 = source.substring(1);
        String r1ent = enbase64(r1);
        String r2ent = escape(r2);
        return r1ent+"test"+r2ent;
    }

    public static String myunAlgorithm(String source){
        String [] entrys = source.split("test");
        String r1ent = entrys[0];
        String r2ent = entrys[1];
        String r1 = unbase64(r1ent);
        String r2 = unescape(r2ent);
        return  r1+r2;
    }

    public static void main(String[] args) {
//        String result= escape("友凡");
//        System.out.println(result);
//        System.out.println(unescape(result));
//        result=  enbase64("友凡");
//        System.out.println(result);
//        System.out.println(unbase64(result));

        String result= myenAlgorithm("友凡23.9");
        System.out.println(result);
        System.out.println(myunAlgorithm(result));

    }
}
