package com.cn.frank.test.util;

import java.io.*;
import java.util.Random;

/**
 * Author: frank_du
 * Time : 2017/7/24 下午2:31
 */
public class CommonUtils {

    public static String getRandomAlphabet (int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            char tmp = (char) (random.nextInt(26) + 65);
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static <T> T deepClone(T src) {
        T result = null;
        try {
            if (src != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(src);
                oos.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos
                        .toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                result = (T) ois.readObject();

                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRandomAlphabet(2));
    }
}
