package d.b.p.a.f.a;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import d.b.p.a.d.h;
import d.b.p.a.g.e;
import d.b.p.a.h.g;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f14276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f14277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Application f14278c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f14279f;

        a(c r1) {
            this.f14279f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14279f.f();
        }
    }

    public interface b {
        List<d> a();

        int b();

        void c(d r1, String r2, int r3);

        long d();

        void e(String r1, int r2);
    }

    public c(b r3) {
        this.f14276a = new Handler(Looper.getMainLooper());
        Objects.requireNonNull(r3, "LaunchSafeConfig is null");
        this.f14277b = r3;
    }

    private boolean h(Thread r7, Throwable r8) {
        if (g.c(this.f14278c) == false) goto L16;
        if (r7 == null) goto L16;
        if (r8 == null) goto L16;
        d.b.p.a.f.a.a.f(this.f14278c).c(r7, r8);
        if (d.b.p.a.f.a.a.f(this.f14278c).g() >= this.f14277b.b()) goto L10;
        h.c("LaunchSafePlugin", "Current user crash less than " + this.f14277b.b());
        return false;
    L10:
        int r0 = d.b.p.a.f.a.a.f(this.f14278c).e(r7, r8);
        this.f14277b.e(d.b.p.a.f.a.a.d(r7, r8), r0);
        Iterator<d> r2 = this.f14277b.a().iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        d r3 = r2.next();
        if (r3.b(r8, r7, r0) == false) goto L12;
        this.f14277b.c(r3, d.b.p.a.f.a.a.d(r7, r8), r0);
    L16:
        return false;
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r2, Throwable r3) {
        if (g.c(this.f14278c) == true) goto L5;
        return false;
    L5:
        return h(r2, r3);
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "LaunchSafePlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r2) {
        if (g.c(r2) == false) goto L6;
        super.c(r2);
        this.f14278c = r2;
        return;
    }

    @Override // d.b.p.a.g.e, d.b.p.a.g.a
    public void d() {
        if (g.c(this.f14278c) == false) goto L6;
        super.d();
        this.f14276a.postDelayed(new a(this), this.f14277b.d());
        return;
    }

    @Override // d.b.p.a.g.e, d.b.p.a.g.a
    public void f() {
        if (g.c(this.f14278c) == false) goto L6;
        super.f();
        d.b.p.a.f.a.a.f(this.f14278c).b();
        return;
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        return true;
    }
}
