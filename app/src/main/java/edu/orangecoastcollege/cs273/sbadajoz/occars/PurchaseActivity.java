package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
    }

    protected void reportSummary(View view) {
        String report = "Monthy Payment = ";
    }
}
