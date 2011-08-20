package com.ebaxt.gameserver.client;

import org.junit.Test;

import java.io.IOException;

public class ClientTest {

    @Test
    public void api() throws IOException {
        Client client = Client.createClient().connect("localhost", 3333).registerPlayer("Test", new GameStrategy() {
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
