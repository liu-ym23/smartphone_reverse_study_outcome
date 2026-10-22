package xg;

import com.bytedance.apm.d;
import d6.c;
import d6.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f23139h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f23140i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f23141j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f23142k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f23143l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f23145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f23146c;
    public final long[] d;
    public volatile long e;
    public a f;
    public boolean g;

    public b(boolean r5) {
        this.f23144a = false;
        this.d = new long[3];
        this.e = 0;
        this.f = null;
        this.g = false;
        if (r5 == true) goto L16;
        if (f23143l == true) goto L16;
        ArrayList r10 = com.bytedance.apm.block.a.f3851a;
        monitor-enter(com.bytedance.apm.block.a.class);
        com.bytedance.apm.block.a.f3851a.add(this);     // Catch: Throwable -> L12
        monitor-exit(com.bytedance.apm.block.a.class);
        f23143l = true;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (f23139h != null) goto L21;
        f23139h = this;
        return;
    }

    public static void a(String r5) {
        z6.b.f23409a.d(new d(r5, 10));
    }

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.g == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (f23142k == true) goto L10;
    L14:
        this.g = true;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        if (f23141j == false) goto L14;
        c.f16598k.a(this);     // Catch: Throwable -> L12
        goto L14
    }
}
