package array_practice;

public final class SalaryService {
    private SalaryService() {}

    public static double applyIncrement(double salary) {
        return salary < 5000 ? salary * 1.10
             : salary <= 10000 ? salary * 1.08
             : salary * 1.05;
    }
}
