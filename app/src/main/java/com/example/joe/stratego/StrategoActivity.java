package com.example.joe.stratego;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.joe.stratego.gameView.BoardView;

public class StrategoActivity extends ActionBarActivity {

    private BoardView boardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stratego);
        boardView = (BoardView) findViewById(R.id.boardView);
        boardView.createSquares();
        boardView.setOnTouchListener(boardViewListener());
    }

    private View.OnTouchListener boardViewListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                int action = event.getAction();
                if(action == MotionEvent.ACTION_DOWN)
                {
                    int position = boardView.getPosition(x, y);
                    boardView.selectSquare(position);
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stratego, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
