package com.example.joe.stratego.gameModel.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Miner extends Piece{

    public Miner(int rank, int team, int pieceID, int position)
    {
        super(rank, team, pieceID, position);
    }

    public boolean killsDefendingPiece(int otherPieceRank)
    {
        return rank >= otherPieceRank || otherPieceRank == RankConstants.BOMB;
    }

    public boolean isKilledByDefendingPiece(int otherPieceRank)
    {
        return rank <= otherPieceRank && otherPieceRank != RankConstants.BOMB;
    }
}
