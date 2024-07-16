package practice;

public class BankAccount {
    double amountOfMany = 0;

    public double getAmount() {
        //TODO: реализуйте метод и удалите todo
        // верните значение количества денег не счету
        return amountOfMany;
    }

    public void put(double amountToPut) {
        if (amountToPut <= 0) {
            System.out.println("Попытка вызвать метод с отрицательной суммой");
        } else {
            amountOfMany += amountToPut;
        }
        //TODO: реализуйте метод и удалите todo
        // метод зачисляет деньги на счет
    }

    public void take(double amountToTake) {
        if (amountToTake >= amountOfMany) {
            System.out.println("Попытка снять со счета денег больше, чем на счете имеется");
        } else {
            amountOfMany -= amountToTake;
        }
        //TODO: реализуйте метод и удалите todo
        // метод списывает деньги со счета
    }
}
