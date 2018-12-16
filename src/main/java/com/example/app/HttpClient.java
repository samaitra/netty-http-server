package com.example.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class HttpClient {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            URL website = new URL("http://localhost:9000/1.mp4");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream("/Users/mine/1.mp4");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("error msg:\n" + e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("fos close fail:\n" + ioe);
            }

        }
    }
}
