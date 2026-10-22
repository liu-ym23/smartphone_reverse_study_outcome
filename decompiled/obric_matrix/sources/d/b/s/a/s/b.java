package d.b.s.a.s;

import java.util.HashMap;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, c> f14900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f14901b = null;

    static {
        f14901b = new b();
        f14900a = new HashMap();
    }

    private b() {
    }

    public final void a(String r1, c r2) {
        o.g(r1, "key");
        o.g(r2, "service");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        f14900a.put(r1, r2);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
