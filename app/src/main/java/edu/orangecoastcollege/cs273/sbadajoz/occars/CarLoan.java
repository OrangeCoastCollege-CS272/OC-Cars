package edu.orangecoastcollege.cs273.sbadajoz.occars;

public class CarLoan {
    private static final double STATE_TAX = 0.08;

    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    public CarLoan() {
    }

    public CarLoan(double price, double downPayment, int term) {
        mPrice = price;
        mDownPayment = downPayment;
        mTerm = term;
    }

    public double totalAmount() {
        return mPrice + taxAmount();
    }

    public double borrowedAmount() {
        return mPrice - mDownPayment;
    }

    public double taxAmount() {
        return mPrice * STATE_TAX;
    }


    public double interestAmount() {
        double interestRate;
        switch(mTerm) {
            case 3:
                interestRate = .0462;
                break;
            case 4:
                interestRate = .0419;
                break;
            case 5:
                interestRate = .0416;
                break;
            default:
                interestRate = 0.0;
                break;
        }
        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment() {
        return borrowedAmount() * interestAmount() / (mTerm * 12.0);
    }


    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getTerm() {
        return mTerm;
    }

    public void setTerm(int term) {
        mTerm = term;
    }
}
