package com.cn.frank.test.nio.netty;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Author: frank_du
 * Time : 2018/1/30 下午7:22
 */
public class TestNIOMain {

    public static void main(String[] args) throws Exception {
        testIntBuffer();
    }

    private static void testIntBuffer() {
            IntBuffer intBuffer = IntBuffer.allocate(10);
            intBuffer.put(10);
            intBuffer.put(101);
            System.err.println("Write mode: ");
            System.err.println("\tCapacity: " + intBuffer.capacity());
            System.err.println("\tPosition: " + intBuffer.position());
            System.err.println("\tLimit: " + intBuffer.limit());

            intBuffer.flip();
            System.err.println("Read mode: ");
            System.err.println("\tCapacity: " + intBuffer.capacity());
            System.err.println("\tPosition: " + intBuffer.position());
            System.err.println("\tLimit: " + intBuffer.limit());
    }

    private static void testFileChannel() throws Exception {

        RandomAccessFile file = new RandomAccessFile("/Users/frank_du/local/apache-maven-3.3.9/conf/settings.xml", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = fileChannel.read(buffer);

        while (bytesRead != -1) {
            buffer.flip();  //buffer转换为读模式
            //Buffer.clear() 或 Buffer.compact() //将buffer转化为写模式
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }
        fileChannel.close();
    }
}
