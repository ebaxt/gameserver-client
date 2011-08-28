package com.ebaxt.gameserver.client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final Client client = Client.createClient();
        final Client client2 = Client.createClient();

        new Thread(new Runnable() {
            public void run() {
                try {
                    client.connect("localhost", 3333).registerPlayer("Erik", new GameStrategy() {
                        public Move firstMove() {
                            return Move.ROCK;
                        }

                        public Move onTie() {
                            return Move.ROCK;
                        }

                        public Move onWin(Move oponentsMove) {
                            return Move.ROCK;
                        }

                        public Move onLoss(Move oponentsMove) {
                            return Move.ROCK;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    client2.connect("localhost", 3333).registerPlayer("Erik2", new GameStrategy() {
                        public Move firstMove() {
                            return Move.ROCK;
                        }

                        public Move onTie() {
                            return Move.ROCK;
                        }

                        public Move onWin(Move oponentsMove) {
                            return Move.ROCK;
                        }

                        public Move onLoss(Move oponentsMove) {
                            return Move.ROCK;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }).start();
    }
}
