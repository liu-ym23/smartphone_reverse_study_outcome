package vf;

import com.bytedance.ies.bullet.service.base.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static we.a f22571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.ies.bullet.web.scc.a f22572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f22573c;
    public static final b d = null;

    static {
        d = new b();
    }

    public static we.a a() {
        monitor-enter(a.class);
        we.a r5 = f22571a;     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
