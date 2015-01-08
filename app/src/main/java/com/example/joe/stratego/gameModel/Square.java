package com.example.joe.stratego.gameModel;

import com.example.joe.stratego.gameModel.Pieces.Piece;

public class Square
{
    int number;
    Piece occupier;
    boolean passable;
    public Square(int number)
    {
        this.number = number;
        occupier = null;
        passable = true;
    }
}
