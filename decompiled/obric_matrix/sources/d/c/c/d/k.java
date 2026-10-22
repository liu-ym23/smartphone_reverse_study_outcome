package d.c.c.d;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static <E> CopyOnWriteArraySet<E> a() {
        return new CopyOnWriteArraySet();
    }

    public static <E> Set<E> b() {
        return c(new IdentityHashMap());
    }

    public static <E> Set<E> c(Map<E, Boolean> r0) {
        return Collections.newSetFromMap(r0);
    }
}
