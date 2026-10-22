package d.c.c.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f<K, V> extends HashMap<K, V> {
    private f(Map<? extends K, ? extends V> r1) {
        super(r1);
    }

    public static <K, V> f<K, V> a(Map<? extends K, ? extends V> r1) {
        return new f(r1);
    }

    public static <K, V> Map<K, V> of(K r2, V r3) {
        HashMap r0 = new HashMap(1);
        r0.put(r2, r3);
        return Collections.unmodifiableMap(r0);
    }

    public static <K, V> Map<K, V> of(K r2, V r3, K r4, V r5) {
        HashMap r0 = new HashMap(2);
        r0.put(r2, r3);
        r0.put(r4, r5);
        return Collections.unmodifiableMap(r0);
    }
}
