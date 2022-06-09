package com.chaosrs.marketabuse;

import java.io.IOException;

public class MarketAbuseTCPClient extends TCPClient {

    MarketAbuseTCPClient() throws IOException {
        super(MARKETABUSE_IP, MARKETABUSE_PORT);
    }
       
    private static final String MARKETABUSE_IP = "127.0.0.1";
    private static final int MARKETABUSE_PORT = 61337;
}
