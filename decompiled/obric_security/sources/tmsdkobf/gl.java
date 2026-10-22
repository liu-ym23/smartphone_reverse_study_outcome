package tmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class gl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f233a = null;

    static {
        f233a = new LinkedHashSet();
    }

    public static int a() {
        Set r0 = f233a;
        if (r0.isEmpty() == false) goto L5;
        r0.add(xk.a(xk.S0));
        r0.add(xk.a(xk.T0));
        r0.add(xk.a(xk.U0));
        r0.add(xk.a(xk.V0));
        r0.add(xk.a(xk.W0));
        r0.add(xk.a(xk.X0));
    L5:
        Iterator r1 = r0.iterator();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r1.hasNext() == false) goto L12;
        Class.forName((String) r1.next());     // Catch: Throwable -> L13
        r2 = r2 | (1 << r3);
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        return r2;
    }
}
