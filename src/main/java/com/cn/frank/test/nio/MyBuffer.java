package com.cn.frank.test.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Author: frank_du
 * Time : 2018/5/11 上午10:21
 */
public class MyBuffer {

    public static void main(String[] args) {

        testIntBuffer();
    }

    private static void testIntBuffer() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        intBuffer.put(12);
        intBuffer.put(101);

        System.out.println("write mode: ");
        System.out.println("buffer capacity: " + intBuffer.capacity());
        System.out.println("buffer position: " + intBuffer.position());
        System.out.println("buffer limit : " + intBuffer.limit());

        System.out.println();

        intBuffer.flip();

        System.out.println(intBuffer.get());
        System.out.println("read mode: ");
        System.out.println("buffer capacity: " + intBuffer.capacity());
        System.out.println("buffer position: " + intBuffer.position());
        System.out.println("buffer limit : " + intBuffer.limit());
    }

    private static void testByteBuffer() {
        String str = "String to be write to channel " + System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        byteBuffer.put(str.getBytes());

        byteBuffer.put("end".getBytes());

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.println((char) byteBuffer.get());
        }
    }
}
