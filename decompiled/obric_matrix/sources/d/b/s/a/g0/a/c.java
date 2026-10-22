package d.b.s.a.g0.a;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c extends RuntimeException {
    public c(Class<?> r3) {
        o.g(r3, "serviceClass");
        super("Cannot find implementation for service " + r3.getName());
    }
}
