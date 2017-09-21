package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Connects the data associated with the summary layout to the view itself
 */
public class LoanSummaryActivity extends Activity {
    private TextView mReportEditText;

    /**
     * Called when activity is first loaded connects the various view objects to the actual view in the layout
     *
     * @param savedInstanceState any data from previous run if applicable
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("report");

        mReportEditText = (TextView) findViewById(R.id.reportEditText);

        mReportEditText.setText(report);
    }

    /**
     * Returns back to the last activity on button press
     * @param v View that called function
     */
    protected void returnToDataEntry(View v) {
        Intent intent = new Intent(this, PurchaseActivity.class);
        startActivity(intent);
    }

}

