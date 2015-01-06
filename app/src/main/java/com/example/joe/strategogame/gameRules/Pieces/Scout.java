package com.example.joe.strategogame.gameRules.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Scout extends Piece
{
    public Scout(int rank, int team, int pieceID, int position)
    {
        this.rank = rank;
        this.teamID = team;
        this.pieceID = pieceID;
        this.position = position;
        this.range = 10;
    }
}
