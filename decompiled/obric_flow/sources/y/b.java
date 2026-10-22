package y;

import d0.c;
import d0.d;
import d0.r;
import d0.s;
import d0.z;
import okhttp3.OkHttpClient;
import ym.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile OkHttpClient f23225c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23227b;

    public b(int r5) {
        this.f23226a = r5;
        switch(r5) {
            case 1: goto L21;
            case 2: goto L19;
            default: goto L5;
        };
    L19:
        this.f23227b = new j(6);
        return;
    L21:
        this.f23227b = new c(3);
        return;
    L5:
        if (f23225c == null) goto L7;
    L17:
        this.f23227b = f23225c;
        return;
    L7:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (f23225c != null) goto L13;
        f23225c = new OkHttpClient();     // Catch: Throwable -> L11
    L13:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L17
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f23226a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new e0.a((j) this.f23227b);
    L7:
        return new d((c) this.f23227b, 1);
    L9:
        return new d((OkHttpClient) this.f23227b, 3);
    }
}
