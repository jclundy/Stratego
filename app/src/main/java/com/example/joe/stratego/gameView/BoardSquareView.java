package com.example.joe.stratego.gameView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

public class BoardSquareView extends ImageView {
    private int number;
    private int xSize;
    private int ySize;
    private Context context;
    private Drawable background;
    private int pieceImageID;
    private int backgroundImageID;

    public BoardSquareView(Context context, int number, int resourceID) {
        super(context);
        this.context = context;
        this.number = number;
        xSize = this.getWidth();
        ySize = this.getHeight();
        backgroundImageID = resourceID;
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
        background = getResources().getDrawable(backgroundImageID);
        setImageDrawable(background);
    }

    private void drawBackground()
    {
        setImageDrawable(background);
    }

    private void drawSelection(int overlayImageID)
    {
        Drawable[] layers = new Drawable[2];
        layers[0] = background;
        layers[1] = getResources().getDrawable(overlayImageID);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        setImageDrawable(layerDrawable);
    }

}
