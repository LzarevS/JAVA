package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();
    private final Object lock = new Object();

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNum, long money) {
        synchronized (lock) {
            if (accounts.containsKey(accountNum)) {
                throw new IllegalArgumentException("Счет с номером " + accountNum + " уже существует");
            }
            Account account = new Account();
            account.setAccNumber(accountNum);
            account.setMoney(money);
            accounts.put(accountNum, account);
        }
    }

    public boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount;
        Account toAccount;

        synchronized (lock) {
            fromAccount = accounts.get(fromAccountNum);
            toAccount = accounts.get(toAccountNum);

            if (fromAccount == null || toAccount == null) {
                throw new IllegalArgumentException("Один или оба счета не существуют");
            }
        }

        // Определяем порядок блокировки
        Account firstAccount;
        Account secondAccount;

        if (fromAccountNum.compareTo(toAccountNum) < 0) {
            firstAccount = fromAccount;
            secondAccount = toAccount;
        } else {
            firstAccount = toAccount;
            secondAccount = fromAccount;
        }

        // Блокируем мониторы в определенном порядке
        synchronized (firstAccount) {
            synchronized (secondAccount) {
                if (amount > 50000) {
                    fromAccount.setBlocked(true);
                    toAccount.setBlocked(true);
                    System.out.println("Транзакция заблокирована из-за превышения суммы перевода: с " + fromAccountNum + " на " + toAccountNum);
                    return;
                }

                if (fromAccount.getMoney() >= amount && amount > 0 && !fromAccountNum.equals(toAccountNum)) {
                    fromAccount.setMoney(fromAccount.getMoney() - amount);
                    toAccount.setMoney(toAccount.getMoney() + amount);

                    System.out.println("перевод средств " + amount + " с " + fromAccountNum + " на " + toAccountNum + " завершено успешно.");
                } else {
                    throw new IllegalArgumentException("Недопустимые данные для проведения транзакции");
                }
            }
        }

        // Разблокируем счета после выполнения транзакции
        synchronized (firstAccount) {
            firstAccount.setBlocked(false);
        }
        synchronized (secondAccount) {
            secondAccount.setBlocked(false);
        }
    }


    public long getBalance(String accountNum) {
        Account account;
        synchronized (lock) {
            account = accounts.get(accountNum);
            if (account == null) {
                throw new IllegalArgumentException("Счет с номером " + accountNum + " не существует");
            }
        }

        synchronized (account) {
            if (!account.isBlocked()) {
                return account.getMoney();
            } else {
                System.out.println("Счет " + accountNum + " заблокирован.");
                return 0;
            }
        }
    }

    public long getSumAllAccounts() {
        long sum = 0;
        synchronized (lock) {
            for (Account account : accounts.values()) {
                sum += account.getMoney();
            }
        }
        return sum;
    }
}
