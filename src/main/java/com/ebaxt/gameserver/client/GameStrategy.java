package com.ebaxt.gameserver.client;

public interface GameStrategy {

    public Move firstMove();

    public Move onTie();

    public Move onWin(Move oponentsMove);

    public Move onLoss(Move oponentsMove);
}
