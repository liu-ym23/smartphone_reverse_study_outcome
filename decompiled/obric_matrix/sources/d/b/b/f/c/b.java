package d.b.b.f.c;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f12744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f12745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.f.c.c f12746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f12747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.n.g.a f12748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.b.f.a.InterfaceC0333a f12749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.b.w.a.a.c f12750g;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ b f12751i;

        a(b r1, long r2, long r4) {
            this.f12751i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f12751i);
        }
    }

    /* JADX INFO: renamed from: d.b.b.f.c.b$b, reason: collision with other inner class name */
    class C0335b implements d.b.b.n.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f12752a;

        C0335b(b r1) {
            this.f12752a = r1;
        }

        @Override // d.b.b.n.g.c
        public void c(Activity r1) {
        }

        @Override // d.b.b.n.g.c
        public void onActivityPause(Activity r1) {
        }

        @Override // d.b.b.n.g.c
        public void onActivityResume(Activity r1) {
        }

        @Override // d.b.b.n.g.c
        public void onActivityStarted(Activity r1) {
        }

        @Override // d.b.b.n.g.c
        public void onBackground(Activity r3) {
            b.b(this.f12752a).edit().putString(d.b.b.i.c.a.m(), Process.myPid() + ",false").apply();
        }

        @Override // d.b.b.n.g.c
        public void onFront(Activity r3) {
            b.b(this.f12752a).edit().putString(d.b.b.i.c.a.m(), Process.myPid() + ",true").apply();
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12753a = null;

        static {
            f12753a = new b(null);
        }

        static /* synthetic */ b a() {
            return f12753a;
        }
    }

    private b() {
        this.f12744a = new AtomicBoolean(false);
        this.f12750g = d.b.w.a.a.b.a(com.bytedance.apm.d.h());     // Catch: Throwable -> L6
    L4:
        d.b.b.f.c.c r0 = new d.b.b.f.c.c(this.f12750g);
        this.f12746c = r0;
        this.f12745b = new d(r0, this.f12750g);
    }

    /* synthetic */ b(a r1) {
        this();
    }

    static /* synthetic */ void a(b r0) {
        r0.c();
    }

    static /* synthetic */ SharedPreferences b(b r0) {
        return r0.f12747d;
    }

    private void c() {
        Map<String, ?> r0 = this.f12747d.getAll();
        if (r0 == null) goto L23;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L38;
        Map.Entry<String, ?> r2 = r1.next();
        String r3 = r2.getKey();     // Catch: Throwable -> L24
        File r4 = new File("/proc/" + ((String) r2.getValue()).split(",")[0] + "/stat");     // Catch: Throwable -> L24
        BufferedReader r5 = null;
        String r6 = "";
        BufferedReader r7 = new BufferedReader(new FileReader(r4.getPath()), 100);     // Catch: Throwable -> L25
        r6 = r7.readLine();     // Catch: Throwable -> L12
        r7.close();     // Catch: Throwable -> L24
    L16:
        if (r6.isEmpty() == true) goto L17;
        String r8 = r6.split(" ")[1];     // Catch: Throwable -> L24
        if (r3.endsWith(r8.substring(1, r8.length() - 1)) == true) goto L6;
        SharedPreferences.Editor r9 = this.f12747d.edit();     // Catch: Throwable -> L24
    L18:
        r9.remove(r3).apply();     // Catch: Throwable -> L24
        goto L6
    L17:
        r9 = this.f12747d.edit();     // Catch: Throwable -> L24
    L12:
        r5 = r7;
    L13:
        if (r5 == null) goto L16;
        r5.close();     // Catch: Throwable -> L24
        goto L16
    L38:
        return;
    }

    public static b e() {
        return c.a();
    }

    public d.b.b.f.a.InterfaceC0333a d() {
        return this.f12749f;
    }

    public void f() {
        if (this.f12744a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f12748e = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        this.f12747d = com.bytedance.apm.core.e.h(d.b.b.o.a.b(), "apm_cpu_front");
        if (d.b.b.i.c.a.A() == false) goto L8;
        c();
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).c(new a(this, 300000, 300000));
    L8:
        this.f12747d.edit().putString(d.b.b.i.c.a.m(), Process.myPid() + "," + this.f12748e.isForeground()).apply();
        this.f12748e.b(new C0335b(this));
        d.b.b.n.c.a(d.b.b.f.d.b.class);
    }

    public boolean g() {
        if (this.f12748e.isForeground() == false) goto L6;
        this.f12747d.edit().putString(d.b.b.i.c.a.m(), Process.myPid() + "," + this.f12748e.isForeground()).apply();
        return true;
    L6:
        Map<String, ?> r0 = this.f12747d.getAll();
        if (r0 == null) goto L15;
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        if (((String) r1.next().getValue()).split(",")[1].equals("true") == false) goto L10;
        boolean r2 = true;
    L16:
        d.b.b.f.b.a r3 = d.b.b.f.b.a();
        if (r2 == false) goto L19;
        return true;
    L19:
        if (this.f12748e.isForeground() == false) goto L21;
        return true;
    L21:
        if (r3 != d.b.b.f.b.a.f12728g) goto L23;
        return true;
    L23:
        if (r3 != d.b.b.f.b.a.f12729h) goto L26;
        return true;
    L26:
        return false;
    L15:
        r2 = false;
        goto L16
    }

    public void h(d.b.b.f.d.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f.a();
        Log.i("APM-CPU", "config: " + r3);
        if (com.bytedance.apm.d.G() == true) goto L10;
        if (r3.f() == true) goto L10;
        return;
    L10:
        if (r3.g() == false) goto L13;
        this.f12745b.o(r3);
        this.f12746c.k(r3);
        return;
    }
}
