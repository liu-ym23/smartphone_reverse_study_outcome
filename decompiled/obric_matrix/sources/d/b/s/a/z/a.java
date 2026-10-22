package d.b.s.a.z;

import com.ss.android.i.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f14976a;

    private a() {
        j.k().e();
    }

    public static b a() {
        if (f14976a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14976a != null) goto L9;
        f14976a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f14976a;
    }
}
