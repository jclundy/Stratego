package com.example.joe.stratego.gameView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import com.example.joe.stratego.R;
import com.example.joe.stratego.Util;

public class BoardView extends ViewGroup {
    private final int numRow = 10;
    private final int numCol = 10;

    private Context context;
    private int parentWidth;
    private int parentHeight;
    private int squareSize;
    private int firstHighlightedSquare;
    private int secondHighlightedSquare;

    public BoardView(Context context)
    {
        super(context);
        this.context = context;
    }

    public BoardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public BoardView(Context context, AttributeSet attsr) {
        super(context, attsr);
        this.context = context;
    }

    public void createSquares()
    {
        int width = this.getResources().getDisplayMetrics().widthPixels;
        int height = this.getResources().getDisplayMetrics().heightPixels;

        int finalDimension = Math.min(width, height);

        this.squareSize = finalDimension / 10;
        for (int i= 0; i < 100; i ++) {
            int resourceID = getResourceID(i);
            BoardSquareView square = new BoardSquareView(getContext(), i, resourceID);
            this.addView(square);
        }

        firstHighlightedSquare = -1;
        secondHighlightedSquare = -1;
    }

    private int getResourceID(int number)
    {
        if(Util.equals(number, 52, 56) )
            return R.drawable.lake_bottom_left;
        if(Util.equals(number, 53, 57))
            return R.drawable.lake_bottom_right;
        if(Util.equals(number, 42, 46))
            return R.drawable.lake_top_left;
        if(Util.equals(number, 43, 47))
            return R.drawable.lake_top_right;

        return R.drawable.terrain_tile;
    }

    public void selectSquare(int number)
    {
        if(firstHighlightedSquare == -1) {
            firstHighlightedSquare = number;
            highlightSquare(number, Color.BLUE);
        } else if (secondHighlightedSquare == -1 && number != firstHighlightedSquare){
            secondHighlightedSquare = number;
            highlightSquare(number, Color.RED);
        } else {
            unhighlightSquare(firstHighlightedSquare);
            unhighlightSquare(secondHighlightedSquare);
            firstHighlightedSquare = -1;
            secondHighlightedSquare = -1;
        }
    }

    private void highlightSquare(int number, int color)
    {
        BoardSquareView squareImage = (BoardSquareView) getChildAt(number);
        squareImage.highlightPiece(color);
    }

    private void unhighlightSquare(int number)
    {
        if(number >= 0 && number < 99) {
            BoardSquareView squareImage = (BoardSquareView) getChildAt(number);
            squareImage.unhighlightPiece();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = this.getResources().getDisplayMetrics().widthPixels;
        int height = this.getResources().getDisplayMetrics().heightPixels;

        int finalDimension = Math.min(width, height);
        this.setMeasuredDimension(finalDimension, finalDimension);
    }

    @Override
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        int childCount = getChildCount();

        for(int i = 0; i < childCount; i++) {
            BoardSquareView squareImage = (BoardSquareView) getChildAt(i);
            int left = squareImage.col * squareSize;
            int top = squareImage.row * squareSize;
            int right = left + squareSize;
            int bottom = top + squareSize;
            squareImage.layout(left, top, right, bottom);
        }
    }

    public int getRow(int y) {
        return (int) Math.ceil(y / squareSize);
    }

    public int getColumn(int x) {
        return (int) Math.ceil( x / squareSize);
    }

    public int getPosition(int x, int y)
    {
        int row = getRow(y);
        int col = getColumn(x);
        return  col + row * numCol;
    }
}
