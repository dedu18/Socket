package com.dedu.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server {

    /**
     * 创建一个HttpServer
     * @param args
     */
    public static void main(String[] args) {
        int port = 8089;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("*****服务器正在监听：" + server.getLocalPort() + "端口*****");
            while (Boolean.TRUE) {
                //使用accept()阻塞等待客户请求，有请求到来则产生一个Socket对象，并继续执行
                final Socket socket = server.accept();
                System.out.println("*****连接已建立，连接地址为：" + socket.getInetAddress() + "，连接端口为：" + socket.getPort() + "*****");
                InputStream inputStream = socket.getInputStream();
                Thread.sleep(500);
                int length = inputStream.available();
                byte[] buff = new byte[length];
                inputStream.read(buff);
                String request = new String(buff);
                System.out.println("*****请求的原生数据为：");
                System.out.println(request);
                System.out.println("*********************");
                Thread.sleep(1000);
                OutputStream outputStream = socket.getOutputStream();
                buff = "Server: Hello World".getBytes("UTF-8");
                outputStream.write(buff);
                socket.close();
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
