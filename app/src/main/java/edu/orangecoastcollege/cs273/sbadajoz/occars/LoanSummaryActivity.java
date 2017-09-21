package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class LoanSummaryActivity extends Activity {
    private TextView mReportEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("report");

        mReportEditText = (TextView) findViewById(R.id.reportEditText);

        mReportEditText.setText(report);
    }

    protected void returnToDataEntry(View v) {
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }

}

