package d.b.m.e;

import android.app.Application;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f14154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<d> f14155b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f14156c = null;

    static {
        f14156c = new c();
        f14154a = new LinkedHashMap();
        f14155b = new ArrayList();
    }

    private c() {
    }

    private final String a(String r4, String r5) {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        r0.addAll(f14155b);     // Catch: Throwable -> L30
        monitor-exit(this);
        int r3 = 0;
        int r1 = r0.size();
    L7:
        if (r3 >= r1) goto L12;
        String r2 = ((d) r0.get(r3)).a(r4);
        if (r2 != null) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return r2;
    L12:
        Map<String, String> r6 = f14154a;
        if (r6.containsKey(r4) == true) goto L15;
    L22:
        String r7 = b.a("_mp_" + r4, r5);
        if (r7 != null) goto L29;
        Application r8 = com.bytedance.mpaas.app.a.f5245g;
        o.b(r8, "LaunchApplication.sApplication");
        if (a.b(r8) == true) goto L28;
        return "empty";
    L28:
        throw new RuntimeException("MPConfig should not be null, key:" + r4);
    L29:
        return r7;
    L15:
        if (r6.get(r4) == null) goto L22;
        String r9 = r6.get(r4);
        if (r9 != null) goto L19;
        o.p();
        throw null;
    L19:
        return r9;
    L30:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String d(c r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.c(r1, r2);
    }

    public final String b(String r3) {
        return d(this, r3, null, 2, null);
    }

    public final String c(String r2, String r3) {
        o.g(r2, "key");
        return a(r2, r3);
    }
}
