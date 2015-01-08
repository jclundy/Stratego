package com.example.joe.strategogame.gameModel.Pieces;

/**
 * Created by joe on 2015-01-06.
 */
public class Bomb extends Piece {
    public Bomb(int position, int team, int pieceID)
    {
        this.rank = RankConstants.BOMB;
        this.range = 0;
        this.teamID = team;
        this.pieceID = pieceID;
    }
}
