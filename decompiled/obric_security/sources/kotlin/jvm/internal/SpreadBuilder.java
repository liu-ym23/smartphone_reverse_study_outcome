package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class SpreadBuilder {
    private final ArrayList<Object> list;

    public SpreadBuilder(int r2) {
        this.list = new ArrayList(r2);
    }

    public void addSpread(Object r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof Object[]) == false) goto L10;
        Object[] r5 = (Object[]) r4;
        if (r5.length <= 0) goto L24;
        ArrayList<Object> r0 = this.list;
        r0.ensureCapacity(r0.size() + r5.length);
        Collections.addAll(this.list, r5);
        return;
    L24:
        return;
    L10:
        if ((r4 instanceof Collection) == false) goto L13;
        this.list.addAll((Collection) r4);
        return;
    L13:
        if ((r4 instanceof Iterable) == false) goto L19;
        Iterator r6 = ((Iterable) r4).iterator();
    L16:
        if (r6.hasNext() == false) goto L31;
        this.list.add(r6.next());
        goto L16
    L31:
        return;
    L19:
        if ((r4 instanceof Iterator) == false) goto L26;
        Iterator r7 = (Iterator) r4;
    L22:
        if (r7.hasNext() == false) goto L32;
        this.list.add(r7.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r4.getClass());
    }

    public int size() {
        return this.list.size();
    }

    public void add(Object r1) {
        this.list.add(r1);
    }

    public Object[] toArray(Object[] r1) {
        return this.list.toArray(r1);
    }
}
