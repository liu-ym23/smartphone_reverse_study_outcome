package tmsdkobf;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public abstract class xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f622a = null;
    public static volatile Pattern[] b;

    static {
        int[] r1 = xk.o;
        int[] r2 = xk.p;
        int[] r3 = xk.q;
        int[] r4 = xk.r;
        int[] r5 = xk.s;
        int[] r6 = xk.t;
        int[] r7 = xk.u;
        int[] r8 = xk.v;
        int[] r9 = xk.x;
        int[] r10 = xk.E;
        int[] r11 = xk.F;
        int[] r12 = xk.G;
        int[] r13 = xk.H;
        int[] r14 = xk.I;
        f622a = new String[]{xk.a(r1), xk.a(r2), xk.a(r3), xk.a(r4), xk.a(r5), xk.a(r6), xk.a(r7), xk.a(r8), xk.a(xk.w), xk.a(r9), xk.a(xk.y), xk.a(xk.z), xk.a(xk.A), xk.a(xk.B), xk.a(xk.C), xk.a(xk.D), xk.a(r10), xk.a(r11), xk.a(r12), xk.a(r13), xk.a(r14)};
        xk.a(r1);
        xk.a(r2);
        xk.a(r3);
        xk.a(r4);
        xk.a(r5);
        xk.a(r6);
        xk.a(r7);
        xk.a(r8);
        xk.a(r9);
        xk.a(r10);
        xk.a(r11);
        xk.a(r12);
        xk.a(r13);
        xk.a(r14);
        b = null;
    }

    public static synchronized Pattern[] a() {
        monitor-enter(xf.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (b == null) goto L9;
        Pattern[] r1 = b;     // Catch: Throwable -> L17
        monitor-exit(xf.class);
        return r1;
    L9:
        String[] r2 = f622a;     // Catch: Throwable -> L17
        b = new Pattern[r2.length];     // Catch: Throwable -> L17
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L17
        int r4 = 0;
    L11:
        if (r4 >= b.length) goto L14;
        r3.add(Pattern.compile(r2[r4]));     // Catch: Throwable -> L20
    L13:
        r4 = r4 + 1;
        goto L11
    L14:
        b = (Pattern[]) r3.toArray(new Pattern[0]);     // Catch: Throwable -> L17
        Pattern[] r5 = b;     // Catch: Throwable -> L17
        monitor-exit(xf.class);
        return r5;
    }
}
