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
 * This is the screen that will ask the user to enter two characters that will then be converted
 * into drawables. Will only accept alpha-numeric characters, and only one character at a time per
 * EditText box.
 */

public class TwoLetters extends Activity {

    /**Text box where the first character is entered*/
    EditText edit1;

    /**Text box where the second character is entered*/
    EditText edit2;

    /**
     * sets the layout to the two_letters screen
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_letters);
    }

    /**
     * When the go button is clicked, gets the text from the edit text boxes. Checks to make sure
     * that they are valid characters before sending the letters to the Letters class.
     * @param v
     */
    public void onClickTwo(View v){
        Intent two = new Intent(this, Letters.class);
        edit1 = (EditText)findViewById(R.id.editTwo1);
        edit2 = (EditText)findViewById(R.id.editTwo2);
        //converts the letters to lowercase
        String letter1 = edit1.getText().toString().toLowerCase();
        String letter2 = edit2.getText().toString().toLowerCase();
        //determines if it will continue to the next screen or present an error message
        Boolean willContinue = checkValid(letter1, letter2);
        if(willContinue) {      //continues to the next screen
            two.putExtra("Letter", letter1);
            two.putExtra("Letter2", letter2);
            this.startActivity(two);
        }
        else{   //error message
            Toast.makeText(getApplicationContext(), "Please enter a valid character",
                            Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Determines if the characters are alpha-numeric.
     * @param lett1 The first character that is being checked
     * @param lett2 The second character that is being checked
     * @return true if characters are valid, false if they are not
     */
    private Boolean checkValid(String lett1, String lett2){
        Boolean get = true;
        String lettPatern = "[a-zA-Z]";
        String numbPattern = "[0-9]";
        if(!lett1.matches(lettPatern) && !lett1.matches(numbPattern) && !lett1.equals(" ") &&
                !lett1.equals("")){
            get = false;
        }
        else if(!lett2.matches(lettPatern) && !lett2.matches(numbPattern) && !lett2.equals(" ") &&
                !lett2.equals("")){
            get = false;
        }
        return get;
    }

}
