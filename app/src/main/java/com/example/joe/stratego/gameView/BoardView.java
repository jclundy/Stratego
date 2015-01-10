package com.example.joe.stratego.gameView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.joe.stratego.R;

public class BoardView extends ViewGroup {
    private Context context;
    private int parentWidth;
    private int parentHeight;
    private int squareSize;
    private int numRow;
    private int numCol;

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

    public void createSquares(int squareSize)
    {
        this.squareSize = squareSize;
        numRow = 10;
        numCol = 10;
        for (int col = 0; col < 10; col ++) {
            for (int row = 0; row < 10; row++){
                BoardSquareView square = new BoardSquareView(getContext(), col, row, R.drawable.terrain_tile);
                this.addView(square);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth  = MeasureSpec.getSize(widthMeasureSpec) ;
        parentHeight = MeasureSpec.getSize(heightMeasureSpec) ;

        this.setMeasuredDimension(parentWidth, parentHeight);
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
}
