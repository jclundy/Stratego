package com.example.joe.strategogame.gameModel.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Scout extends Piece
{
    public Scout(int rank, int team, int pieceID, int position)
    {
        super(rank, team, pieceID, position);
        this.range = 10;
    }
}
