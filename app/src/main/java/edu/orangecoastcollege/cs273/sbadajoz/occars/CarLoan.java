package edu.orangecoastcollege.cs273.sbadajoz.occars;

/**
 * CarLoan reprents the data involved in a loan for buying a car
 * Holds all variables necessary for calculations
 * also has methods for calculations
 */
public class CarLoan {
    private static final double STATE_TAX = 0.08;

    private double mPrice;
    private double mDownPayment;
    private int mTerm;

    /**
     * Calculates the total price of the car including tax
     *
     * @return total price
     */
    public double totalAmount() {
        return mPrice + taxAmount();
    }

    /**
     * Calculates the amount the user owes after making down payment
     *
     * @return borrowed amount
     */
    public double borrowedAmount() {
        return mPrice - mDownPayment;
    }

    /**
     * Calculates the tax on the car purchase
     * @return tax amount
     */
    public double taxAmount() {
        return mPrice * STATE_TAX;
    }

    /**
     * Returns th amount of interest on the car loan
     * @return amount of interest
     */
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

    /**
     * Calculates the amount to pay each month
     * @return monthly payment
     */
    public double monthlyPayment() {
        return borrowedAmount() * interestAmount() / (mTerm * 12.0);
    }

    /**
     * Returns the price the car
     * @return car price
     */
    public double getPrice() {
        return mPrice;
    }

    /**
     * Resets the price of the car
     * @param price new car price
     */
    public void setPrice(double price) {
        mPrice = price;
    }

    /**
     * Return the down payment on the car
     * @return car down payment
     */
    public double getDownPayment() {
        return mDownPayment;
    }

    /**
     * Resets the down payment on the car
     * @param downPayment new car down payment
     */
    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    /**
     * Returns the term which the car will be paid off
     * @return Term duration
     */
    public int getTerm() {
        return mTerm;
    }

    /**
     * Resets the term amount to specified amount
     * @param term New term
     */
    public void setTerm(int term) {
        mTerm = term;
    }
}
