public class TopManager implements Employee {

    private static final int SALARY = 150000;

    @Override
    public double getMonthSalary() {
        return SALARY + (Company.getIncome() > 10_000_000 ? (SALARY * 1.5) : 0);
    }

    @Override
    public String toString() {
        return "Топ Менеджер - " + getMonthSalary();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
