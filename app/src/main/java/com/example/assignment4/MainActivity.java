package com.example.assignment4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView textView;
        EditText check;
        EditText party;
        TextView tip15percent;
        TextView tip20percent;
        TextView tip25percent;
        TextView total15percent;
        TextView total20percent;
        TextView total25percent;


        int checkAmountValue;
        int partySizeValue;
        int buttonCompute;
        int fifteenPercentTipValue;
        int twentyPercentTipValue;
        int twentyfivePercentTipValue;
        int fifteenPercentTotalValue;
        int twentyPercentTotalValue;
        int twentyfivePercentTotalValue;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = (TextView) findViewById(R.id.textView);
            check = (EditText) findViewById(R.id.checkAmountValue);
            party = (EditText) findViewById(R.id.partySizeValue);
            tip15percent = (TextView) findViewById(R.id.fifteenPercentTipValue);
            tip20percent = (TextView) findViewById(R.id.twentyPercentTipValue);
            tip25percent = (TextView) findViewById(R.id.twentyfivePercentTipValue);

            total15percent = (TextView) findViewById(R.id.fifteenPercentTotalValue);
            total20percent = (TextView) findViewById(R.id.twentyPercentTotalValue);
            total25percent = (TextView) findViewById(R.id.twentyfivePercentTotalValue);
        }

        public void updateText(View view) {

            checkAmountValue = Integer.parseInt(check.getText().toString());
            partySizeValue = Integer.parseInt(party.getText().toString());


            if (partySizeValue > 0) {

                fifteenPercentTipValue = checkAmountValue / partySizeValue;
                Double fifteendouble = fifteenPercentTipValue * .15;
                fifteenPercentTipValue = (int) Math.round(fifteendouble);
                String a = Integer.toString(fifteenPercentTipValue);
                tip15percent.setText(a);

                twentyPercentTipValue = checkAmountValue / partySizeValue;
                Double twentydouble = twentyPercentTipValue * .20;
                twentyPercentTipValue = (int) Math.round(twentydouble);
                String b = Integer.toString(twentyPercentTipValue);
                tip20percent.setText(b);

                twentyfivePercentTipValue = checkAmountValue / partySizeValue;
                Double twentyfivedouble = twentyfivePercentTipValue * .25;
                twentyfivePercentTipValue = (int) Math.round(twentyfivedouble);
                String c = Integer.toString(twentyfivePercentTipValue);
                tip25percent.setText(c);


                fifteenPercentTotalValue = (checkAmountValue / partySizeValue) + fifteenPercentTipValue;
                String d = Integer.toString(fifteenPercentTotalValue);
                total15percent.setText(d);

                twentyPercentTotalValue = (checkAmountValue / partySizeValue) + twentyPercentTipValue;
                String e = Integer.toString(twentyPercentTotalValue);
                total20percent.setText(e);

                twentyfivePercentTotalValue = (checkAmountValue / partySizeValue) + twentyfivePercentTipValue;
                String f = Integer.toString(twentyfivePercentTotalValue);
                total25percent.setText(f);
            } else {
                openDialog();

            }
        }

        private void openDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert");
            builder.setMessage("Please enter a party size greater than 0");

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }


    }
