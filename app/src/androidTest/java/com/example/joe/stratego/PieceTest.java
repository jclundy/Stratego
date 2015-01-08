package com.example.joe.stratego;
import com.example.joe.stratego.gameModel.Pieces.*;
import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by joe on 2015-01-06.
 */
public class PieceTest extends ApplicationTestCase<Application>
{
    public PieceTest()
    {
        super(Application.class);
    }

    public void testPiece()
    {
        Piece captain = new Piece(RankConstants.CAPTAIN, 1, 2);
        assertTrue(captain.killsDefendingPiece(RankConstants.CAPTAIN));
        assertTrue(captain.isKilledByDefendingPiece(RankConstants.CAPTAIN));
        assertTrue(captain.isKilledByDefendingPiece(RankConstants.MARSHALL));
        assertTrue(captain.killsDefendingPiece(RankConstants.LIEUTENANT));
        assertTrue(captain.killsDefendingPiece(RankConstants.BOMB));
        assertTrue(captain.isKilledByDefendingPiece(RankConstants.BOMB));
    }

    public void testMiner()
    {
    }
}
