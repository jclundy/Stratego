package com.example.joe.strategogame.gameRules.Pieces;

/**
 * Created by joe on 2015-01-05.
 */
public class Flag extends Piece {
    public Flag(int position, int team, int pieceID)
    {
        this.rank = RankConstants.FLAG;
        this.range = 0;
        this.teamID = team;
        this.pieceID = pieceID;
    }
}
