package com.example.joe.stratego.gameModel.Pieces;

public class Piece {
    protected int rank;
    protected int teamID;
    protected int pieceID;
    protected int range;

    public Piece(int rank, int team, int pieceNumber)
    {
        this.rank = rank;
        this.teamID = team;
        this.pieceID = pieceNumber;
        this.range = 1;
    }

    public Piece()
    {
    }

    public Piece copyPiece(int id)
    {
        return new Piece(rank, teamID, id);
    }

    public int getRank()
    {
        return rank;
    }

    public int getPieceID()
    {
        return pieceID;
    }

    public int getTeamID()
    {
        return teamID;
    }

    public boolean killsDefendingPiece(int otherPieceRank)
    {
        return rank >= otherPieceRank;
    }

    public boolean isKilledByDefendingPiece(int otherPieceRank)
    {
        return rank <= otherPieceRank || otherPieceRank == RankConstants.BOMB;
    }
}