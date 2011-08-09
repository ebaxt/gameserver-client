package com.ebaxt.gameserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public static Client createClient() {
        return new Client();
    }

    public Client registerPlayer(String username, GameStrategy gameStrategy) throws GameserverException {
        connect("localhost", 3333);
        String s = readLine();
        if (s.trim().equals("Enter player name:")) {
            out.write(username);

        } else {
            throw new GameserverException(String.format("Unexpected server response! %s", s.trim()));
        }
        return this;
    }

    private void write(String output) {
        out.write(output);
    }

    private String readLine() {
        String line;
        try {
            line = in.readLine();
        } catch (IOException e) {
            throw new GameserverException(e.getMessage());
        }
        return line;
    }

    public Client connect(String localhost, int port) {
        try {
            socket = new Socket(localhost, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException exception) {
            throw new GameserverException(exception.getMessage());
        }
        return this;
    }
}
