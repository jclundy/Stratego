package com.example.joe.strategogame.gameRules.Pieces;

public class Spy extends Piece
{
    public boolean killsDefendingPiece(int otherPieceRank)
    {
        return rank == RankConstants.MARSHALL || otherPieceRank == rank;
    }

    public boolean isKilledByDefendingPiece(int otherPieceRank)
    {
        return rank <= otherPieceRank && otherPieceRank != RankConstants.MARSHALL;
    }
}
