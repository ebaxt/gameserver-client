package com.ebaxt.gameserver.client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Client.createClient().connect("localhost", 3333).registerPlayer("Erik", new GameStrategy() {
            public Move firstMove() {
                return Move.PAPER;
            }

            public Move onTie() {
                return Move.PAPER;
            }

            public Move onWin(Move oponentsMove) {
                return Move.PAPER;
            }

            public Move onLoss(Move oponentsMove) {
                return Move.PAPER;
            }
        });
    }
}
