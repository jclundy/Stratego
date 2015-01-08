package com.example.joe.strategogame.gameModel;

/**
 * Created by joe on 2015-01-05.
 */
public class Board {
    protected Square [] squares;

    public Board()
    {
        squares = new Square[100];
        for(int i = 0; i < 100; i++)
            squares[i] = new Square();
    }
}
