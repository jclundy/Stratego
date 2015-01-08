package com.example.joe.stratego.gameModel;

import com.example.joe.stratego.gameModel.Pieces.Piece;

import java.util.ArrayList;

public class GameModel
{
    private Board board;
    private Army redArmy;
    private Army blueArmy;
    private int turnCount;

    public GameModel(Board board)
    {
       this.board = board;
       redArmy = new Army(Constants.RED);
       blueArmy = new Army(Constants.BLUE);
       turnCount = 0;
    }

    public GameModel()
    {
        board = new Board();
        redArmy = new Army(Constants.RED);
        blueArmy = new Army(Constants.BLUE);
        turnCount = 0;
    }

    public void updateArmyPositions(int army, ArrayList<Piece> pieceList)
    {

    }

    public boolean movePiece(int fromSquare, int toSquare)
    {
        if(!isMoveValid())
            return false;
        if(willMoveResultInBattle())
            resolveBattle();
        else
            updatePiecePosition(fromSquare, toSquare);
        return true;
    }

    private boolean isMoveValid()
    {
        return false;
    }

    private void resolveBattle()
    {

    }

    private void updatePiecePosition(int from, int to)
    {

    }

    private boolean willMoveResultInBattle()
    {
        return false;
    }
}
