package ajou.cse.oop.utils;

public class MathUtil {
    public static long ceil(long value, int unit) {
        long res = value / unit;
        long res_ = res * unit;
        long extra = value % unit;

        return res_ + (extra > 0 ? unit : 0);
    }
}
