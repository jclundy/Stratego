package com.example.joe.stratego.gameModel.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Scout extends Piece
{
    public Scout(int rank, int team, int pieceID, int position)
    {
        super(rank, team, pieceID);
        this.range = 10;
    }
}
