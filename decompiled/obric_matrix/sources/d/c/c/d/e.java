package d.c.c.d;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class e<E> extends ArrayList<E> {
    private e(int r1) {
        super(r1);
    }

    public static <E> e<E> a(E... r2) {
        e<E> r0 = new e(r2.length);
        Collections.addAll(r0, r2);
        return r0;
    }
}
