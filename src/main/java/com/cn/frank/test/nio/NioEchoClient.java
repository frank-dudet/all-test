package com.cn.frank.test.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_READ;
import static java.nio.channels.SelectionKey.OP_WRITE;

/**
 * Author: frank_du
 * Time : 2018/1/31 上午10:02
 */
public class NioEchoClient {

    private static final int BUF_SIZE = 256;
    private static final int TIMEOUT = 3000;

    public static final Charset charset = Charset.forName("GBK");

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        System.out.println("与服务器建立连接成功！");

        ByteBuffer writeBuffer = ByteBuffer.allocate(BUF_SIZE);
        writeBuffer.put(encode("Hello Server" + "\r\n"));
        socketChannel.write(writeBuffer);

        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, writeBuffer);


        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();


            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if(key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    buffer.compact();
                    long bytesRead = clientChannel.read(buffer);
                    if(bytesRead == -1) {
                        clientChannel.close();
                    } else if(bytesRead > 0) {
                        String receivedString = decode(buffer);
                        // 控制台打印出来
                        System.out.println("接收到来自服务器" + clientChannel.socket().getRemoteSocketAddress() + "的信息:" + receivedString);

                        // 为下一次读取作准备
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
                if (key.isWritable()) {

                }

                keyIterator.remove();

            }
        }
    }

    public static String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public static ByteBuffer encode(String str) {
        return charset.encode(str);
    }
}
