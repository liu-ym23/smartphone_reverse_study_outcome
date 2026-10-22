package p000j.l0;

import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import p000j.d0;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f18159b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f18160a;

    public d() {
        this.f18160a = new CopyOnWriteArrayList();
    }

    public static d a() {
        if (f18159b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f18159b != null) goto L9;
        f18159b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f18159b;
    }

    public void b(d0 r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.k() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2.k().m()) == true) goto L16;
        String r4 = r2.k().m();
        CopyOnWriteArrayList<String> r1 = this.f18160a;
        if (r3 == false) goto L11;
        r1.add(r4);
        return;
    L11:
        r1.remove(r4);
        return;
    }
}
