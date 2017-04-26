package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that will present the main menu after the splash screen has finished. There
 * will be four buttons on this screen: one letter, two letters, image, and info. When one of these
 * buttons are pressed, the app will advance to the next screen.
 */

public class MainMenu extends Activity {

    /**button to continue to the one letter screen*/
    private Button oneLetter;

    /**button to continue to the two letters screen*/
    private Button twoLetters;

    /**button to continue to the image screen*/
    private Button image;

    /**button to continue to the info screen*/
    private Button info;

    /**
     * Sets up the main menu screen and initializes each of the buttons on the main menu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        oneLetter = (Button)findViewById(R.id.oneLetter);
        twoLetters = (Button)findViewById(R.id.twoLetters);
        image = (Button)findViewById(R.id.image);
        info = (Button)findViewById(R.id.infoButton);
    }

    /**
     * Determines which of the main menu buttons was pressed and then starts the activity to
     * continue to that screen.
     * @param v
     */
    public void onClick(View v){

        if(v == oneLetter){
            Intent oL = new Intent(v.getContext(), OneLetter.class);
            startActivity(oL);
        }

        else if(v == twoLetters){
            Intent tL = new Intent(v.getContext(), TwoLetters.class);
            startActivity(tL);
        }

        else if(v == image){
           Intent img = new Intent(v.getContext(), MyImage.class);
            startActivity(img);
        }

        else if(v == info){
            Intent info = new Intent(v.getContext(), Info.class);
            startActivity(info);
        }

    }

}
