package com.dedu.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8089);
            OutputStream stream = socket.getOutputStream();
            byte[] buff = "Client: Hello World".getBytes("UTF-8");
            stream.write(buff);
            Thread.sleep(1000);
            InputStream inputStream = socket.getInputStream();
            int length = inputStream.available();
            byte[] buffCli = new byte[1024];
            inputStream.read(buffCli);
            System.out.println(new String(buffCli));
            socket.close();
            inputStream.close();
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
