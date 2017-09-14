package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class LoanSummaryActivity extends AppCompatActivity {private EditText mCarPriceEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("report");
        
    }
}

