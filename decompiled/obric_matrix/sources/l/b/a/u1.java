package l.b.a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Long f21735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f21736b = null;

    static {
        f21735a = c(0);
        f21736b = new HashMap();
        b();
    }

    static Date a(Date r7) {
        Locale r0 = Locale.getDefault();
        if (r0 != null) goto L5;
        return r7;
    L5:
        Map r1 = f21736b;
        monitor-enter(r1);
        Long r2 = (Long) r1.get(r0);     // Catch: Throwable -> L21
        if (r2 != null) goto L15;
        long r3 = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();     // Catch: Throwable -> L21
        if (r3 != 0) goto L12;
        r2 = f21735a;     // Catch: Throwable -> L21
    L13:
        r1.put(r0, r2);     // Catch: Throwable -> L21
        goto L15
    L12:
        r2 = c(r3);     // Catch: Throwable -> L21
    L15:
        if (r2 == f21735a) goto L19;
        Date r4 = new Date(r7.getTime() - r2.longValue());     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r4;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r7;
    L21:
        th = move-exception;
        throw th;
    }

    private static Locale b() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage()) == true) goto L5;
        Locale[] r0 = Locale.getAvailableLocales();
        int r2 = 0;
    L8:
        if (r2 == r0.length) goto L15;
        if ("en".equalsIgnoreCase(r0[r2].getLanguage()) == true) goto L12;
        r2 = r2 + 1;
        goto L8
    L12:
        return r0[r2];
    L15:
        return Locale.getDefault();
    L5:
        return Locale.getDefault();
    }

    private static Long c(long r0) {
        return Long.valueOf(r0);
    }
}
