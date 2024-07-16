public class Manager implements Employee {
    private static final int SALARY = 50_000;
    private final int earningsForCompany;

    public Manager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }

    @Override
    public double getMonthSalary() {
        return SALARY + earningsForCompany * 0.05;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(getMonthSalary(), ((Employee) o).getMonthSalary());
    }

    @Override
    public String toString() {
        return "Менеджер - " + getMonthSalary();
    }
}