package com.ebaxt.gameserver.client;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.registerPlayer("Erik");
    }
}
