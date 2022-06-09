package com.chaosrs.marketabuse;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

import com.chaosrs.marketabuse.org.json.JSONObject;

public class TCPClient {
    TCPClient(String ipAddress, int port) throws IOException {
        tcpSocket = new Socket(ipAddress, port);
        objectOutputStream = new ObjectOutputStream(tcpSocket.getOutputStream());
    }

    public void sendMessage(IMessage message) throws IOException {
        JSONObject object = message.serialize();
        OutputStreamWriter sw = new OutputStreamWriter(objectOutputStream, "UTF-8");

        object.write(sw);
        sw.flush();
    }

    private SocketAddress socketAddress;
    private Socket tcpSocket;
    private ObjectOutputStream objectOutputStream;
}
