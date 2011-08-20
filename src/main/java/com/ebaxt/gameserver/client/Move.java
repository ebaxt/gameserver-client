package com.ebaxt.gameserver.client;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public String print() {
        return this.toString().toLowerCase();
    }
}
