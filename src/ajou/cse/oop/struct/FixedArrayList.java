package ajou.cse.oop.struct;

import java.util.ArrayList;

public class FixedArrayList<T> extends ArrayList<T> {
    private int size;

    public FixedArrayList(int size) {
        super();
        this.size = size;
    }

    @Override
    public boolean add(T o) {
        if (size() < size) {
            return super.add(o);
        } else {
            return false;
        }
    }
}
