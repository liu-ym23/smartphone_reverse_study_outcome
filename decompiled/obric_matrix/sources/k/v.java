package k;

import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f18310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f18311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f18312c = null;

    static {
        f18312c = new v();
    }

    private v() {
    }

    public final void a(u r11) {
        kotlin.n0.d.o.g(r11, "segment");
        if (r11.f18308f == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L26;
        if (r11.f18306d == false) goto L12;
        return;
    L12:
        monitor-enter(this);
        long r2 = f18311b;     // Catch: Throwable -> L22
        long r4 = 8192;
        if ((r2 + r4) <= 65536) goto L19;
        monitor-exit(this);
        return;
    L19:
        f18311b = r2 + r4;     // Catch: Throwable -> L22
        r11.f18308f = f18310a;     // Catch: Throwable -> L22
        r11.f18305c = 0;     // Catch: Throwable -> L22
        r11.f18304b = 0;     // Catch: Throwable -> L22
        f18310a = r11;     // Catch: Throwable -> L22
        f0 r12 = f0.f18324a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r11.f18309g != null) goto L7;
        r0 = true;
        goto L8
    }

    public final u b() {
        monitor-enter(this);
        u r0 = f18310a;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        f18310a = r0.f18308f;     // Catch: Throwable -> L11
        r0.f18308f = null;     // Catch: Throwable -> L11
        f18311b -= (long) 8192;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        monitor-exit(this);
        return new u();
    L11:
        th = move-exception;
        throw th;
    }
}
