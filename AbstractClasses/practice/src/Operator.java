
public class Operator implements Employee {
    private static final int SALARY = 60_000;

    @Override
    public String toString() {
        return "Оператор - " + SALARY;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        return SALARY;
    }
}
