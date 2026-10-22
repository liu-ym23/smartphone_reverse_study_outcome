package d.b.p.a;

import android.app.Application;
import d.b.p.a.d.f;
import d.b.p.a.d.h;
import d.b.p.a.d.i;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f14211g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ b[] f14212h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.p.a.d.b f14213f;

    static {
        b r0 = new b("INSTANCE", 0);
        f14211g = r0;
        f14212h = new b[]{r0};
        new HashMap();
    }

    private b(String r1, int r2) {
        super(r1, r2);
        this.f14213f = null;
    }

    private void c() {
        if (this.f14213f != null) goto L5;
        d.b.p.a.d.b r0 = new d.b.p.a.d.b();
        this.f14213f = r0;
        r0.e();
    L5:
        h.d("UncaughtExceptionPlugin", "init mConsumeExceptionHandler:" + this.f14213f);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f14212h.clone();
    }

    public void a(i r3) {
        c();
        h.d("UncaughtExceptionPlugin", "add consumer:" + r3);
        this.f14213f.a(r3);
    }

    public void b(Application r1, f r2, h.c r3) {
        if (r2 == null) goto L4;
        h.f(r2);
    L4:
        if (r3 == null) goto L7;
        h.g(r3);
        return;
    }

    public void g(i r3) {
        h.d("UncaughtExceptionPlugin", "remove consumer:" + r3);
        this.f14213f.f(r3);
    }
}
