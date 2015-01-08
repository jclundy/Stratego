package com.example.joe.stratego.gameModel;

import com.example.joe.stratego.gameModel.Pieces.Piece;
import com.example.joe.stratego.gameModel.Pieces.RankConstants;

import java.util.ArrayList;

/**
 * Created by joe on 2015-01-05.
 */
public class Army {

    private ArrayList<Piece> units;
    private int team;

    public Army(int team)
    {
        units = new ArrayList<Piece>(40);
        this.team = team;
    }

    private void copyXPieces(int number, Piece piece)
    {
        for (int i = 0; i < number; i ++)
        {
            units.add(piece.copyPiece(i));
        }
    }

    private void createSpecialPieces()
    {

    }

    private void createNormalPieces()
    {
        for (int rank = RankConstants.MINER; rank <= RankConstants.MARSHALL; rank++)
        {
            Piece piece = new Piece(rank, team, 1);
        }
    }
}
