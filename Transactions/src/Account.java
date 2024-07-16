package src;

import java.util.Objects;

public class Account implements Comparable<Account> {

    private long money;
    private String accNumber;
    private boolean isBlocked;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public int compareTo(Account otherAccount) {
        // Сравниваем номера счетов
        return this.accNumber.compareTo(otherAccount.accNumber);
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        // Вычисляем хэш-код на основе номера счета
        return Objects.hash(accNumber);
    }

    public void transferMoney(Account otherAccount, long amount) {
        // Определяем порядок блокировки
        Account firstAccount;
        Account secondAccount;
        if (this.compareTo(otherAccount) < 0) {
            firstAccount = this;
            secondAccount = otherAccount;
        } else {
            firstAccount = otherAccount;
            secondAccount = this;
        }

        // Блокируем мониторы в определенном порядке
        synchronized (firstAccount) {
            synchronized (secondAccount) {
                // Ваш код транзакции
                if (!this.isBlocked() && !otherAccount.isBlocked()) {
                    if (this.getMoney() >= amount) {
                        this.setMoney(this.getMoney() - amount);
                        otherAccount.setMoney(otherAccount.getMoney() + amount);
                    }
                }
            }
        }
    }
}
