package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Austin Richburg
 * @author Doug Key
 * @version v1
 * @date September 25, 2016
 *
 * This is the screen that will ask the user to enter a character that will then be converted
 * into a drawable. Will only accept alpha-numeric characters, and only one character at a time.
 */

public class OneLetter extends Activity{

    /**The text box where the character will be entered*/
    EditText edit1;

    /**
     * Sets the layout to be one_letter screen
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_letter);
    }

    /**
     * When the go button is clicked, get the text from the edit text box. Checks to make sure that
     * it is a valid character before sending the letter to the Letters class.
     * @param v
     */
    public void onClickOne(View v){
        Intent one = new Intent(this, Letters.class);
        edit1 = (EditText)findViewById(R.id.editOne);
        //converts the letter to lowercase
        String letter = edit1.getText().toString().toLowerCase();
        //determines if it will continue to the next screen or present an error message
        Boolean willContinue = checkValid(letter);
        //continues to next screen
        if(willContinue) {
            one.putExtra("Letter", letter);
            this.startActivity(one);
        }
        //error message
        else{
            Toast.makeText(getApplicationContext(), "Please enter a valid character",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Determines if the character is alpha-numeric.
     * @param lett1 The character that is being checked
     * @return true if character is valid, false if it is not
     */
    private Boolean checkValid(String lett1){
        Boolean get = true;
        String lettPatern = "[a-zA-Z]";
        String numbPattern = "[0-9]";
        if(!lett1.matches(lettPatern) && !lett1.matches(numbPattern) && !lett1.equals(" ") &&
                !lett1.equals("")){
            get = false;
        }
        return get;
    }

}
