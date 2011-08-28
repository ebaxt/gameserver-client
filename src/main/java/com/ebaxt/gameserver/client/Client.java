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

    public Client registerPlayer(String username, GameStrategy gameStrategy) throws GameserverException, IOException {
        if (readLine().trim().startsWith("Enter player name:")) {
            out.println(username);
            gameLoop(gameStrategy);
        } else {
            throw new GameserverException("Unknown server response!");
        }
        return this;
    }

    private void gameLoop(GameStrategy gameStrategy) {
        String input;
        do {
            input = readLine();
            if (null != input) {
                if (input.startsWith(":select")) {
                    write(gameStrategy.firstMove().print());
                }
                if (input.startsWith("[:winner")) {
                    readLine();
                    write(gameStrategy.onWin(getOponentMove(input)).print());
                }
                if (input.startsWith("[:looser")) {
                    readLine();
                    write(gameStrategy.onLoss(getOponentMove(input)).print());
                }
                if (input.startsWith("[:tie")) {
                    readLine();
                    write(gameStrategy.onTie().print());
                }
            }
        } while (input != null);
    }

    private Move getOponentMove(String input) {
        System.out.println("Oponents move: " + input);
        if (input.contains("rock")) {
            return Move.ROCK;
        }
        if (input.contains("paper")) {
            return Move.PAPER;
        }
        if (input.contains("scissors")) {
            return Move.SCISSORS;
        }
        throw new GameserverException("Unexpected input!");
    }

    private void write(String output) {
        System.out.println(output);
        out.println(output);
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


