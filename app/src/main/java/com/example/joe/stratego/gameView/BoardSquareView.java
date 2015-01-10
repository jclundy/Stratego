package com.example.joe.stratego.gameView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

public class BoardSquareView extends ImageView {
    int col;
    int row;
    private int xSize;
    private int ySize;
    private Context context;
    private Drawable background;
    private int pieceImageID;
    private int backgroundImageID;

    public BoardSquareView(Context context, int i, int resourceID) {
        super(context);
        this.context = context;
        this.row = i / 10;
        this.col = i % 10;
        xSize = this.getWidth();
        ySize = this.getHeight();
        backgroundImageID = resourceID;
        drawDefaultBackground();
    }

    public void highlightPiece(int color)
    {
       Drawable highlight = new ColorDrawable(color);
       highlight.setAlpha(100);
       drawSelection(highlight);
    }

    public void unhighlightPiece()
    {
        drawBackground();
    }

    public void setPiece(int resourceID)
    {
        pieceImageID = resourceID;
        drawPiece();
    }

    private void drawPiece()
    {
        if(pieceImageID != -1) {
            Drawable[] layers = new Drawable[2];
            layers[0] = getResources().getDrawable(backgroundImageID);
            layers[1] = getResources().getDrawable(pieceImageID);
            LayerDrawable layerDrawable = new LayerDrawable(layers);
            background = layerDrawable;
            setImageDrawable(background);
        }
    }

    private void removePieceImage()
    {
        pieceImageID = -1;
        drawDefaultBackground();
    }

    private void drawDefaultBackground()
    {
        Drawable backgroundImg = getResources().getDrawable(backgroundImageID);
        background = backgroundImg;
        setImageDrawable(background);
    }

    private void drawBackground()
    {
        setImageDrawable(background);
    }

    private void drawSelection(Drawable overlay)
    {
        Drawable[] layers = new Drawable[2];
        layers[0] = background;
        layers[1] = overlay;
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        setImageDrawable(layerDrawable);
    }
}
