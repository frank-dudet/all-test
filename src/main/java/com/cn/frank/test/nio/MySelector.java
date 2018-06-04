package com.cn.frank.test.nio;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: frank_du
 * Time : 2018/5/11 上午11:01
 */
public class MySelector {

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);//非阻塞channel才能注册到selector
//        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);

        Set<SelectionKey> selectionKeys = selector.selectedKeys();

        Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

        while (keyIterator.hasNext()) {
            SelectionKey selectionKey = keyIterator.next();

            if (selectionKey.isConnectable()) {
                // a connection was accepted by a ServerSocketChannel.
            } else if (selectionKey.isConnectable()) {
                // a connection was established with a remote server.
            } else if (selectionKey.isWritable()) {
                // a channel is ready for writing
            } else if (selectionKey.isReadable()) {
                // a channel is ready for reading
            }

            //处理完成这次链接之后，需要移除，所以使用iteratir
            keyIterator.remove();
        }
    }
}
