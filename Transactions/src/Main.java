package src;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("1", 100000);
        bank.createAccount("2", 50000);

        Runnable transferTask1 = () -> {
            bank.transfer("1", "2", 60000);
        };

        Runnable transferTask2 = () -> {
            bank.transfer("2", "1", 70000);
        };

        Runnable transferTask3 = () -> {
            bank.transfer("1", "2", 5000);
        };

        Thread thread1 = new Thread(transferTask1);
        Thread thread2 = new Thread(transferTask2);
        Thread thread3 = new Thread(transferTask3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Баланс счета 1: " + bank.getBalance("1"));
        System.out.println("Баланс счета 2: " + bank.getBalance("2"));
    }
}
