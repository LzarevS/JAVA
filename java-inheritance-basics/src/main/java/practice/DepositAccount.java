package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    LocalDate lastIncome;
    LocalDate withdrawal;

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        withdrawal = LocalDate.now();
        if (lastIncome.isBefore(withdrawal)) {
            super.take(amountToTake);
        }
    }
}