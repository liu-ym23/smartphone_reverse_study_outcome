package kotlin.n0.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f18443a;

    public h0(int r2) {
        this.f18443a = new ArrayList(r2);
    }

    public void a(Object r1) {
        this.f18443a.add(r1);
    }

    public void b(Object r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof Object[]) == false) goto L10;
        Object[] r5 = (Object[]) r4;
        if (r5.length <= 0) goto L24;
        ArrayList<Object> r0 = this.f18443a;
        r0.ensureCapacity(r0.size() + r5.length);
        Collections.addAll(this.f18443a, r5);
        return;
    L24:
        return;
    L10:
        if ((r4 instanceof Collection) == false) goto L13;
        this.f18443a.addAll((Collection) r4);
        return;
    L13:
        if ((r4 instanceof Iterable) == false) goto L19;
        Iterator r6 = ((Iterable) r4).iterator();
    L16:
        if (r6.hasNext() == false) goto L31;
        this.f18443a.add(r6.next());
        goto L16
    L31:
        return;
    L19:
        if ((r4 instanceof Iterator) == false) goto L26;
        Iterator r7 = (Iterator) r4;
    L22:
        if (r7.hasNext() == false) goto L32;
        this.f18443a.add(r7.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r4.getClass());
    }

    public int c() {
        return this.f18443a.size();
    }

    public Object[] d(Object[] r1) {
        return this.f18443a.toArray(r1);
    }
}
