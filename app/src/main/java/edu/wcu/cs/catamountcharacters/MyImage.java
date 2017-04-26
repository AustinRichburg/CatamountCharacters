package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that will present the various buttons to bring up the different images
 * on the screen when the corresponding button is pressed.
 */

public class MyImage extends Activity {

    /**button for the catamount logo*/
    private Button cat;

    /**button for the clocktower picture*/
    private Button tower;

    /**button for the computer picture*/
    private Button comp;

    /**button for the science picture*/
    private Button sci;

    /**button for the year picture*/
    private Button year;

    /**
     * Sets the layout to the screen with the images buttons and initializes all of the
     * instances of each button
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        cat = (Button)findViewById(R.id.catButton);
        tower = (Button)findViewById(R.id.towerButton);
        comp = (Button)findViewById(R.id.compButton);
        sci = (Button)findViewById(R.id.sciButton);
        year = (Button)findViewById(R.id.yearButton);
    }

    /**
     * When a button is pressed, this method will determine which button was pressed and then
     * present the image that is associated with that button
     * @param v
     */
    public void onClickImage(View v){
        setContentView(R.layout.show_one_letter);
        Drawable d1 = this.getResources().getDrawable(R.drawable.space_bl);
        if(v == cat){
            d1 = this.getResources().getDrawable(R.drawable.cat);
        }
        else if(v == tower){
            d1 = this.getResources().getDrawable(R.drawable.tower);
        }
        else if(v == comp){
            d1 = this.getResources().getDrawable(R.drawable.computer);
        }
        else if(v == sci){
            d1 = this.getResources().getDrawable(R.drawable.science);
        }
        else if(v == year){
            d1 = this.getResources().getDrawable(R.drawable.cs467);
        }
        //gets the id of the image view
        ImageView img = (ImageView)findViewById(R.id.imageView);
        //sets the image view to be the drawable
        img.setImageDrawable(d1);
    }
}
