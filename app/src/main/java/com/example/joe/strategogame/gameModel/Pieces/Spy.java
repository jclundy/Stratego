package com.example.joe.strategogame.gameModel.Pieces;

public class Spy extends Piece
{
    public Spy(int rank, int team, int pieceID, int position)
    {
        super(rank, team, pieceID, position);
    }

    public boolean killsDefendingPiece(int otherPieceRank)
    {
        return rank == RankConstants.MARSHALL || otherPieceRank == rank;
    }

    public boolean isKilledByDefendingPiece(int otherPieceRank)
    {
        return rank <= otherPieceRank && otherPieceRank != RankConstants.MARSHALL;
    }
}
