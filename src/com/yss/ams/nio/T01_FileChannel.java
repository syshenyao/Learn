package com.yss.ams.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class T01_FileChannel {

	public static void main(String[] args) {
		 
		try(RandomAccessFile aFile  = new RandomAccessFile("src/test.txt", "rw")) {
			FileChannel fileChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(16);
			int bytesRead = fileChannel.read(buf);
			while (bytesRead != -1) {
				buf.flip();
				while(buf.hasRemaining()){
					System.out.println((char)buf.get());
				}
				buf.compact();
				bytesRead = fileChannel.read(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
