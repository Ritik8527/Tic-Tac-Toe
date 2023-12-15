package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 1 - O
    // 0 - X
    int activePlayer = 0;
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}; // last image was crashing so added extra 2 don't know why...
    // 1 - O
    // 0 - X
    // 2 - Null
    int winPositions[][] = {{0,1,2} , {3,4,5} , {6,7,8} ,
                        {0,3,6} , {1,4,7} , {2,5,8} ,
                        {0,4,8} , {2,4,6}};
    TextView status;

//    public void reset(View view){
//
//    }
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage] == 2){
             gameState[tappedImage] = activePlayer;
             img.setTranslationY(-100f);
             if(gameState[tappedImage] == 1){
                 img.setImageResource(R.drawable.on);
                 activePlayer = 0;
             }
             else{
                 img.setImageResource(R.drawable.x1);

                 activePlayer = 1;
             }
            img.animate().translationYBy(100f).setDuration(300);
        }
        TextView status = findViewById(R.id.status);
        for(int [] winposition: winPositions){
            if(gameState[winposition[0]] == gameState[winposition[1]]
                    && gameState[winposition[1]] == gameState[winposition[2]]
                    && gameState[winposition[0]]!=2){
                        status.setText(" YOU WON!! ");
            }
        }
        

    }
    public void reset(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}