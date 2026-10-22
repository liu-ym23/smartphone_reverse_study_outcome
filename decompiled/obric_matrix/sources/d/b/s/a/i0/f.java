package d.b.s.a.i0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f14820a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f14821b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f14822c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f14823d = null;

    static {
        f14823d = new f();
    }

    private f() {
    }

    public final int a(Context r3) {
        o.g(r3, "context");
        if (f14822c < 0) goto L16;
        return f14822c;
    L16:
    L13:
        th = move-exception;
        d.b.s.a.a0.a.c("SystemInfoManager", "getSystemBootTimes throws exception", th);
        return -1;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        int r4 = Settings.Global.getInt(r3.getContentResolver(), "boot_count");     // Catch: Throwable -> L13
    L11:
        f14822c = r4;     // Catch: Throwable -> L13
        return r4;
    L10:
        r4 = -1;
        goto L11
    }

    public final boolean b(Context r5, long r6) {
        o.g(r5, "context");
        if (f14820a > 0) goto L5;
    L10:
        boolean r4 = false;
    L16:
        th = move-exception;
        d.b.s.a.a0.a.c("SystemInfoManager", "isSystemTimeSyncWithNetwork throws exception", th);
    L18:
        f14820a = r6;
        f14821b = r4;
        return r4;
    L12:
        if (Build.VERSION.SDK_INT < 17) goto L18;
        if (Settings.Global.getInt(r5.getContentResolver(), "auto_time") != 1) goto L18;
        r4 = true;
        goto L18
    L5:
        if (r6 <= f14820a) goto L10;
        if ((r6 - f14820a) > 1800000) goto L10;
        return f14821b;
    }
}
