package mock;

public class Division {
    public int divid(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (a > 100) {
            return 0;
        }
        int c = a / b;
        return c;
    }
}
