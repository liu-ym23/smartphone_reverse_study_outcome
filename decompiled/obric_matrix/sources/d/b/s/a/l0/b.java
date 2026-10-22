package d.b.s.a.l0;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.ss.android.i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14847a = null;

    static {
        f14847a = new b();
    }

    private b() {
    }

    @Override // com.ss.android.i.c
    public boolean a(int r1) {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 == null) goto L5;
        com.ss.android.i.c r2 = r0.j();
    L6:
        if (r2 != null) goto L8;
        return true;
    L8:
        return r2.a(r1);
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.i.c
    public boolean b(d.b.s.a.t.c r5) {
        kotlin.n0.d.o.g(r5, "dialogParams");
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 == null) goto L5;
        com.ss.android.i.c r1 = r0.j();
    L6:
        StringBuilder r2 = new StringBuilder();
        r2.append("showDialog() start, externalDepend=");
        if (r1 != null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        r2.append(", isMainThread=");
        r2.append(kotlin.n0.d.o.a(Looper.myLooper(), Looper.getMainLooper()));
        d.b.s.a.a0.a.d("AccountExternalDependUtil", r2.toString());
        if (r1 == null) goto L13;
        boolean r4 = r1.b(r5);
    L14:
        d.b.s.a.a0.a.d("AccountExternalDependUtil", "showDialog() result=" + r4);
        return r4;
    L13:
        r4 = super.b(r5);
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
