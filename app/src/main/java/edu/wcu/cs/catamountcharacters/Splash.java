package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that come up for 5 seconds before the main menu
 */

public class Splash extends Activity {

    /**how long the screen will be up, in milliseconds*/
    private final int DELAY = 5000;

    /**
     * sets the layout to the splash screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    /**
     * when the screen starts, stay on it for 5 seconds
     */
    @Override
    protected void onStart(){
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(runner, DELAY);
    }

    /**
     * after 5 seconds, continue to the main menu
     */
    private final Runnable runner = new Runnable() {
        @Override
        public void run() {
            nextScreen();
        }
    };

    /**
     * goes to the main menu
     */
    private void nextScreen(){
        Intent i = new Intent(this, MainMenu.class);
        this.startActivity(i);
        finish();
    }
}
