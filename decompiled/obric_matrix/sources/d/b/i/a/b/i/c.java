package d.b.i.a.b.i;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public interface a<A, B> {
        boolean a(A r1, B r2);
    }

    public static boolean a(List<?> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static <L, O> boolean b(Collection<L> r2, O r3, a<? super L, O> r4) {
        Iterator<L> r5 = r2.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r4.a(r5.next(), r3) == false) goto L4;
        r5.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }
}
