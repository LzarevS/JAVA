package practice;

public class CardAccount extends BankAccount {
    private double percent = 0.01;


    @Override
    public void take(double amountToTake) {
        double discount = amountToTake * percent;
        amountToTake += discount;
        super.take(amountToTake);

    }
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);
}
