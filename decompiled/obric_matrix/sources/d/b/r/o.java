package d.b.r;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f14480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<?> f14481b;

    o(Method r1, List<?> r2) {
        this.f14480a = r1;
        this.f14481b = Collections.unmodifiableList(r2);
    }

    public Method a() {
        return this.f14480a;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f14480a.getDeclaringClass().getName(), this.f14480a.getName(), this.f14481b});
    }
}
