package madrimas.channelToChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by madrimas on 03.04.2017.
 */
public class ChannelToChannel {
    public static void main(String[] args) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
