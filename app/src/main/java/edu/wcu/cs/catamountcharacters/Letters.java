package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that will present the drawable of the letter, or letters, that are entered
 * by the user on the one_letter or two_letters screens.
 */

public class Letters extends Activity {

    /**
     * Looks at the bundle sent by either the one character or two characters screen and determines
     * which layout it will use (one or two characters). Sends the character from the bundle to the
     * getLetter method to retrieve the drawable. Assigns the drawable to the imageview to be
     * presented to the user.
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String value1, value2;      //strings to hold the letters
        Drawable d1, d2;            //drawables to hold the letter pictures
        ImageView iv1, iv2, iv3;    //imageviews to hold the drawables
        Bundle extras = getIntent().getExtras();    //gets the data sent from the other screens
        if(extras != null){
            setContentView(R.layout.show_one_letter);   //initially sets content view for just one character
            value1 = extras.getString("Letter");
            iv1 = (ImageView)findViewById(R.id.imageView);
            d1 = getLetter(value1);     //gets the drawable
            iv1.setImageDrawable(d1);
            if(extras.getString("Letter2") != null){    //if a second letter was sent
                setContentView(R.layout.show_two_letters);  //change the layout for two letters
                value2 = extras.getString("Letter2");
                iv2 = (ImageView)findViewById(R.id.letter2);
                iv3 = (ImageView)findViewById(R.id.letter3);
                d2 = getLetter(value2);
                iv2.setImageDrawable(d1);
                iv3.setImageDrawable(d2);
            }
        }
    }

    /**
     * Gets the drawable for the character that was sent to it
     * @param letter the character
     * @return the drawable for the character
     */
    protected Drawable getLetter(String letter){
        Drawable d1 = this.getResources().getDrawable(R.drawable.space_bl); //initially blank
        String get;     //holds the name of the drawable
        String lettPatern = "[a-zA-Z]";     //regex for any letter
        String numbPattern = "[0-9]";       //regex for any number
        if(letter == " "){      //if the character is a space
            d1 = this.getResources().getDrawable(R.drawable.space_bl);
        }
        else if(letter.matches(lettPatern)){    //if the character is a letter
            get = letter + "_bl";   //name of the drawable
            int resId = getResources().getIdentifier(get, "drawable", getPackageName());
            d1 = getResources().getDrawable(resId);
        }
        else if(letter.matches(numbPattern)){   //if the character is a number
            get = "n" + letter + "_bl"; //name of the drawable
            int resId = getResources().getIdentifier(get, "drawable", getPackageName());
            d1 = getResources().getDrawable(resId);
        }
        return d1;
    }

}
