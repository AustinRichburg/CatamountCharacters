package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that will present the info screen when the info button is pressed
 */

public class Info extends Activity {

    /**
     * Sets the layout to be the info screen
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }
}
