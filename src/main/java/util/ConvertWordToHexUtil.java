package util;

import java.nio.charset.Charset;

/**
 * Author: frank_du
 * Time : 2017/11/6 下午3:20
 */
public class ConvertWordToHexUtil {

    public static String convertToHex(String s, String chasrSet) {
        try {
            byte[] b = s.getBytes(Charset.forName(chasrSet));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                Integer I = new Integer(b[i]);
                String strTmp = I.toHexString(b[i]);
                if (strTmp.length() > 2)
                    strTmp = strTmp.substring(strTmp.length() - 2);
                sb.append(strTmp).append("\t");
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String hexStringToString(String s, String charSet) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replaceAll("\\s+|\t|\r|\n", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, charSet);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static String convertCharAToCharB(String src, String charSetA, String charSetB) throws Exception {
        return new String(src.getBytes(charSetA), charSetB);
    }


    public static void main(String[] args) throws Exception {
//
//        String result = convertToHex(s, "ISO-8859-1");
//        System.out.println(result);
//
//        String hexStr1 = hexStringToString(result, "gbk");
//        System.out.println(hexStr1);
//
        String hexStr = "6e 00 63 00 61 00 6c 00 72 00 70 00 63 00 3a 00 5b\n" +
                "00 64 00 68 00 63 00 70 00 63 00 73 00 76 00 63 00\n" +
                "36 00 2c 00 53 00 65 00 63 00 75 00 72 00 69 00 74\n" +
                "00 79 00 3d 00 49 00 6d 00 70 00 65 00 72 00 73 00 \n" +
                "6f 00 6e 00 61 00 74 00 69 00 6f 00 6e 00 20 00 44 \n" +
                "00 79 00 6e 00 61 00 6d 00 69 00 63 00 20 00 46 00 61 00 6c 00 73 00 65 00 5d 00 00 00";
        System.out.println(hexStringToString(hexStr, "ISO-8859-1"));

        String s = "²¥·ÅÃ½ÌåÁÐ±í";
        System.out.println(convertCharAToCharB(s, "ISO-8859-1", "GBK"));
    }
}
