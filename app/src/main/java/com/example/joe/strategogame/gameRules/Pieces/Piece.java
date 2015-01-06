package com.example.joe.strategogame.gameRules.Pieces;

public class Piece {
    protected int rank;
    protected int teamID;
    protected int pieceID;
    protected int position;
    protected int range;

    public Piece(int rank, int team, int pieceID, int position)
    {
        this.rank = rank;
        this.teamID = team;
        this.pieceID = pieceID;
        this.position = position;
        this.range = 1;
    }
    public Piece()
    {
    }

    public int getRank()
    {
        return rank;
    }

    public int getPosition()
    {
        return position;
    }

    public int getPieceID()
    {
        return pieceID;
    }

    public int getTeamID()
    {
        return teamID;
    }

    public void setPosition(int destination)
    {
        position = destination;
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