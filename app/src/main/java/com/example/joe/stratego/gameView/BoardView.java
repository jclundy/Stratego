package com.example.joe.stratego.gameView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import com.example.joe.stratego.R;
import com.example.joe.stratego.Util;

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
        for (int i= 0; i < 100; i ++) {
            int resourceID = getResourceID(i);
            BoardSquareView square = new BoardSquareView(getContext(), i, resourceID);
            this.addView(square);
        }
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
