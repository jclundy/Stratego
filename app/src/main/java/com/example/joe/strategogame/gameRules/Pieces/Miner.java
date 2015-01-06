package com.example.joe.strategogame.gameRules.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Miner extends Piece{
    public boolean killsDefendingPiece(int otherPieceRank)
    {
        return rank >= otherPieceRank || otherPieceRank == RankConstants.BOMB;
    }

    public boolean isKilledByDefendingPiece(int otherPieceRank)
    {
        return rank <= otherPieceRank && otherPieceRank != RankConstants.BOMB;
    }
}
