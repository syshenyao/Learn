package com.yss.ams.nio.c000;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) {
		client();
	}

	private static void client() {
		ByteBuffer byteBuffer= ByteBuffer.allocate(1024);
		try(SocketChannel socketChannel = SocketChannel.open()){
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("192.168.31.102", 8080));
			if(socketChannel.finishConnect()){
				int i = 0;
				while (true) {
					TimeUnit.SECONDS.sleep(1);
					String info = "I am "+i+++"-th information from client"; 
					byteBuffer.clear();
					byteBuffer.put(info.getBytes());
					byteBuffer.flip();
					while (byteBuffer.hasRemaining()) {
						System.out.println(byteBuffer);
						socketChannel.write(byteBuffer);
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
