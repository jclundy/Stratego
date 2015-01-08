package com.example.joe.stratego.gameModel;

import com.example.joe.stratego.gameModel.Pieces.Piece;

/**
 * Created by joe on 2015-01-05.
 */
public class Board {
    protected Square [] squares;

    public Board()
    {
        squares = new Square[100];
        for(int i = 0; i < 100; i++)
            squares[i] = new Square(i);
        createObstacleSquares();
    }

    private void createObstacleSquares()
    {
        for (int i = 0; i < Constants.lakeSquares.length; i++)
            squares[Constants.lakeSquares[i]].passable = false;
    }

    public boolean placePiece(Piece piece, int squareNumber)
    {
        if(!isSquareValid(squareNumber) || isSquareOccupied(squareNumber))
            return false;
        squares[squareNumber].occupier = piece;
        return true;
    }

    public boolean movePiece(int from, int to)
    {
        if(!isSquareOccupied(from) || !isSquareValid(from) || !isSquareValid(to))
            return false;
        squares[to].occupier = squares[from].occupier;
        squares[from].occupier = null;
        return true;
    }

    public void removePiece(int squareNum)
    {
        squares[squareNum].occupier = null;
    }

    private boolean isSquareValid(int squareNum)
    {
        return squareNum < 100 && squareNum >= 0 && squares[squareNum].passable;
    }

    private boolean isSquareOccupied(int squareNum)
    {
        return squares[squareNum].occupier != null;
    }
}
