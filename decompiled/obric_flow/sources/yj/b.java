package yj;

import android.content.Context;
import android.os.Looper;
import java.util.HashMap;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static b g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f23292c;
    public o d;
    public volatile int e;
    public volatile long f;

    public b() {
        this.f23290a = 0;
        this.f23291b = false;
        this.e = 0;
        this.f = 0;
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        new bb.b(this, Looper.getMainLooper(), 7);
    }

    public static synchronized b a() {
        monitor-enter(b.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (g != null) goto L9;
        g = new b();     // Catch: Throwable -> L7
    L9:
        b r5 = g;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r5;
    }
}
