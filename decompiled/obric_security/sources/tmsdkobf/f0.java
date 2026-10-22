package tmsdkobf;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f0 {
    public static synchronized void a(List r6) {
        monitor-enter(f0.class);
        if (r6 != null) goto L40;
    L35:
        monitor-exit(f0.class);
        return;
    L40:
    L32:
        th = move-exception;
        throw th;
    L6:
        if (r6.isEmpty() == true) goto L35;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L32
    L10:
        if (r7.hasNext() == false) goto L30;
        String r1 = (String) r7.next();     // Catch: Throwable -> L32
        if (r1 == null) goto L10;
        if (r1.isEmpty() == true) goto L10;
        String[] r2 = r1.split(";");     // Catch: Throwable -> L37
        if (r2 == null) goto L10;
        if (r2.length < 2) goto L10;
        if (r2[0] == null) goto L10;
        boolean r3 = true;
        String r4 = r2[1];     // Catch: Throwable -> L37
        if (r4 == null) goto L10;
        if (r4.compareToIgnoreCase("1") == 0) goto L28;
        r3 = false;
    L28:
        int r5 = d3.c(r2[0]);     // Catch: Throwable -> L37
        r8.a("bs", "id:" + r5 + "b:" + r3);     // Catch: Throwable -> L37
        lf.a(r5, r3);     // Catch: Throwable -> L37
        goto L10
    L30:
        monitor-exit(f0.class);
    }
}
