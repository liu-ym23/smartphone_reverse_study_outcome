package d.b.s.a.l0;

import java.util.Map;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final <K, V> void a(Map<K, V> r4, u<? extends K, ? extends V>... r5) {
        kotlin.n0.d.o.g(r4, "$this$putAll");
        kotlin.n0.d.o.g(r5, "pairs");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        u<? extends K, ? extends V> r2 = r5[r1];
        r4.put(r2.a(), r2.b());
        r1 = r1 + 1;
        goto L3
    }
}
