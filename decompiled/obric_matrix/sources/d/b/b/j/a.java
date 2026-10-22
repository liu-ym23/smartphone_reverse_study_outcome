package d.b.b.j;

import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f12971d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.j.b f12972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.b.b.j.b f12973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12974c;

    /* JADX INFO: renamed from: d.b.b.j.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0341a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12975a = null;

        static {
            f12975a = new a(null);
        }

        static /* synthetic */ a a() {
            return f12975a;
        }
    }

    static {
    }

    private a() {
    }

    /* synthetic */ a(C0341a r1) {
        this();
    }

    public static a b() {
        return b.a();
    }

    private boolean d() {
        d.b.b.j.b r2 = a();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.f12976a == true) goto L8;
        return false;
    L8:
        if ((-1) != f12971d) goto L13;
        if (k.t() == false) goto L13;
        f12971d = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (f12971d == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public d.b.b.j.b a() {
        d.b.b.j.b r0 = this.f12973b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.f12972a;
    }

    public void c() {
        if (this.f12974c == true) goto L9;
        c r0 = (c) d.b.b.n.c.a(c.class);
        if (r0 == null) goto L7;
        e(r0.getConfig());
    L7:
        d();
        this.f12974c = true;
        return;
    }

    public void e(d.b.b.j.b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f12972a = r1;
    }
}
