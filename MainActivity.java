package com.example.tipcalculator4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
        implements TextWatcher, SeekBar.OnSeekBarChangeListener {

    private TextView textViewBillAmount;

    //declare the variables for the calculations
    private double billAmount = 0.0;
    private double percent = .15;

    //set the number formats to be used for the $ amounts , and % amounts
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private final NumberFormat percentFormat = NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add Listeners to Widgets
        //declare your variables for the widgets
        EditText editTextBillAmount = (EditText) findViewById(R.id.editText_BillAmount);
 /*  Note: each View that will be retrieved using findViewById needs to map to a View with the matching id
Example: editTextBillAmount
Needs to map to a View with the following: android:id="@+id/editText_BillAmount
*/
        editTextBillAmount.addTextChangedListener((TextWatcher) this);

        textViewBillAmount = (TextView) findViewById(R.id.textView_BillAmount);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    /*
    Note:   int i, int i1, and int i2
            represent start, before, count respectively
            The charSequence is converted to a String and parsed to a double for you
     */
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("MainActivity", "inside onTextChanged method: charSequence= " + charSequence);
        //surround risky calculations with try catch (what if billAmount is 0 ?
        //charSequence is converted to a String and parsed to a double for you
        billAmount = Double.parseDouble(charSequence.toString()) / 100;
        Log.d("MainActivity", "Bill Amount = " + billAmount);
        //setText on the textView
        textViewBillAmount.setText(currencyFormat.format(billAmount));
        //perform tip and total calculation and update UI by calling calculate
        calculate();//uncomment this line
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        percent = progress / 100; //calculate percent based on seeker value
        calculate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    // calculate and display tip and total amounts
    private void calculate() {
        Log.d("MainActivity", "inside calculate method");
        //uncomment below

        // format percent and display in percentTextView
        BreakIterator textViewPercent = null;
        assert false;
        textViewPercent.setText(percentFormat.format(percent));

        // calculate the tip and total
        double tip = billAmount * percent;
        //use the tip example to do the same for the Total

        // display tip and total formatted as currency
        //user currencyFormat instead of percentFormat to set the textViewTip
        BreakIterator tipTextView = null;
        if (true) {
            throw new AssertionError();
        }
        tipTextView.setText(currencyFormat.format(tip));
        //use the tip example to do the same for the Total
        double totalAmount = 0;
        totalAmount = tip + billAmount;
        textViewBillAmount.setText((int) totalAmount);
    }

    public void noCalculate(View view){
        // calculate the tip and total
        double tip = billAmount * percent;
        //use the tip example to do the same for the Total

        // display tip and total formatted as currency
        //user currencyFormat instead of percentFormat to set the textViewTip
        BreakIterator tipTextView = null;
        if (true) {
            throw new AssertionError();
        }
        tipTextView.setText(currencyFormat.format(tip));
        //use the tip example to do the same for the Total
        double totalAmount = 0;
        totalAmount = tip + billAmount;
        textViewBillAmount.setText((int) totalAmount);
    }

    public void tipCalculate(View view) {
        // rounds up tip before the total is calculated
        double newTotal = 0;
        double tip = 0;
        tip = billAmount * percent;
        newTotal = Math.round(tip) + billAmount;
        textViewBillAmount.setText((int) newTotal);
    }

    public void totalCalculate(View view) {
        // tip and bill is exact. total is rounded up.
        double tip;
        tip = billAmount * percent;
        double newTotal = tip + billAmount;
        double newTotalRounded = Math.round(newTotal);
        textViewBillAmount.setText((int) newTotalRounded);
    }
}
