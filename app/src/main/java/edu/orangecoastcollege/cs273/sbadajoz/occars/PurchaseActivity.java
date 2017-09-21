package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DecimalFormat;

public class PurchaseActivity extends Activity {
    private EditText mCarPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearsRadioButton;
    private RadioButton mFourYearsRadioButton;
    private RadioButton mFiveYearsRadioButton;
    private Button mLoanReportButton;

    private DecimalFormat mDecimalFormat = new DecimalFormat("0.00");

    private CarLoan mCarLoan = new CarLoan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        mCarPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        mFourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        mFiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
        mLoanReportButton = (Button) findViewById(R.id.loanReportButton);
    }

    private void collectCarLoanData() {
        mCarLoan.setPrice(Double.parseDouble(mCarPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));
        if(mThreeYearsRadioButton.isChecked()) mCarLoan.setTerm(3);
        else if(mFourYearsRadioButton.isChecked()) mCarLoan.setTerm(4);
        else mCarLoan.setTerm(5);
    }

    protected void reportSummary(View v) {
        collectCarLoanData();

        StringBuilder report = new StringBuilder();

        report.append(getResources().getString(R.string.report_line1)).append(mDecimalFormat.format(mCarLoan.monthlyPayment())).append("\n");
        report.append(getResources().getString(R.string.report_line2)).append(mDecimalFormat.format(mCarLoan.getPrice()));
        report.append(getResources().getString(R.string.report_line3)).append(mDecimalFormat.format(mCarLoan.getDownPayment()));
        report.append(getResources().getString(R.string.report_line5)).append(mDecimalFormat.format(mCarLoan.taxAmount()));
        report.append(getResources().getString(R.string.report_line6)).append(mDecimalFormat.format(mCarLoan.totalAmount()));
        report.append(getResources().getString(R.string.report_line7)).append(mDecimalFormat.format(mCarLoan.borrowedAmount()));
        report.append(getResources().getString(R.string.report_line8)).append(mDecimalFormat.format(mCarLoan.interestAmount())).append("\n");
        report.append(getResources().getString(R.string.report_line4)).append(" ").append(mCarLoan.getTerm()).append(" years.").append("\n");
        report.append(getResources().getString(R.string.report_line9));
        report.append(getResources().getString(R.string.report_line10));
        report.append(getResources().getString(R.string.report_line11));
        report.append(getResources().getString(R.string.report_line12));

        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        launchLoanSummary.putExtra("report", report.toString());
        startActivity(launchLoanSummary);
    }


}

