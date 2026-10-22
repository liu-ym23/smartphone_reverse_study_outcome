package d.b.p.a.e.h.b.c;

import d.b.p.a.d.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.p.a.e.h.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f14270a;

    static {
        ArrayList r0 = new ArrayList();
        f14270a = r0;
        r0.add("FILE_PROVIDER_PATHS");
        f14270a.add("NullPointerException");
        f14270a.add("Failed to resolve canonical path");
        f14270a.add("android.os.DeadSystemException");
        f14270a.add("Package manager has died");
    }

    public a() {
    }

    @Override // d.b.p.a.e.h.a.b.a
    public boolean a() {
        return true;
    }

    @Override // d.b.p.a.e.h.a.b.a
    public boolean b(Object r7, Throwable r8) {
        StackTraceElement[] r6 = Thread.currentThread().getStackTrace();
        int r9 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L15;
        if (r6[r1].getMethodName().contains("installProvider") == false) goto L14;
        if (r8 == null) goto L14;
        String r2 = r8.toString();
        Iterator<String> r3 = f14270a.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        String r4 = r3.next();
        if (r2.contains(r4) == false) goto L9;
        h.a("ProviderInstallFailed", "Hint the crash " + r4);
        return true;
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        return false;
    }
}
