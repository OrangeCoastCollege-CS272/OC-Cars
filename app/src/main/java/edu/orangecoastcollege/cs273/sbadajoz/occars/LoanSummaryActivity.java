package edu.orangecoastcollege.cs273.sbadajoz.occars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class LoanSummaryActivity extends AppCompatActivity {
    private EditText mCarPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearsRadioButton;
    private RadioButton mFourYearsRadioButton;
    private RadioButton mFiveYearsRadioButton;

    private CarLoan mCarLoan = new CarLoan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);

        mCarPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        mFourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        mFiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
    }

    private void collectCarLoanData() {
        mCarLoan.setPrice(Double.parseDouble(mCarPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));
        if(mThreeYearsRadioButton.isChecked()) mCarLoan.setTerm(3);
        else if(mFourYearsRadioButton.isChecked()) mCarLoan.setTerm(4);
        else mCarLoan.setTerm(5);
    }
}
