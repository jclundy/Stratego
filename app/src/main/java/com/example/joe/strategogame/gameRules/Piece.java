package com.example.joe.strategogame.gameRules;

public class Piece {
    private int rank;
    private int teamID;
    private int pieceID;
    protected int position;

    public Piece(int rank, int team, int pieceID, int position)
    {
        this.rank = rank;
        this.teamID = team;
        this.pieceID = pieceID;
        this.position = position;
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

    public boolean canDefeatPiece(int otherPieceRank)
    {
        return rank > otherPieceRank;
    }

}
