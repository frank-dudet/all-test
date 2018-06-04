package com.cn.frank.test.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * Author: frank_du
 * Time : 2018/5/11 上午10:28
 */
public class MyChannel {

    public static void main(String[] args) throws Exception {
        testFileChannel();
    }

    private static void testFileChannel() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/frank_du/Projects/Dp/practiceProject/src/main/resources/test.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(buffer);

        while (bytesRead != -1) {
            //转换成读模式
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            //转换成写模式,二选一
//            buffer.compact();
            buffer.clear();

            bytesRead = fileChannel.read(buffer);
        }

        fileChannel.close();
    }
}
