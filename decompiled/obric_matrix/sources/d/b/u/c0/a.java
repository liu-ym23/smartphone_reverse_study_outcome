package d.b.u.c0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.ug.bus.UgCallbackCenter;
import d.b.u.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.u.w.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.b.u.w.a f15011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f15012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<UgCallbackCenter.d<Void>> f15014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<UgCallbackCenter.d<Void>> f15015j;

    /* JADX INFO: renamed from: d.b.u.c0.a$a, reason: collision with other inner class name */
    class C0406a implements UgCallbackCenter.d<com.ss.android.ug.bus.c.b.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f15016a;

        C0406a(a r1) {
            this.f15016a = r1;
        }

        @Override // com.ss.android.ug.bus.UgCallbackCenter.d
        public /* bridge */ /* synthetic */ void a(com.ss.android.ug.bus.c.b.c r1) {
            b(r1);
        }

        public void b(com.ss.android.ug.bus.c.b.c r1) {
            a.F(this.f15016a, true);
        }
    }

    class b implements UgCallbackCenter.d<com.ss.android.ug.bus.c.b.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f15017a;

        b(a r1) {
            this.f15017a = r1;
        }

        @Override // com.ss.android.ug.bus.UgCallbackCenter.d
        public /* bridge */ /* synthetic */ void a(com.ss.android.ug.bus.c.b.a r1) {
            b(r1);
        }

        public void b(com.ss.android.ug.bus.c.b.a r1) {
            a.F(this.f15017a, true);
        }
    }

    class c implements UgCallbackCenter.d<com.ss.android.ug.bus.c.b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f15018a;

        c(a r1) {
            this.f15018a = r1;
        }

        @Override // com.ss.android.ug.bus.UgCallbackCenter.d
        public /* bridge */ /* synthetic */ void a(com.ss.android.ug.bus.c.b.b r1) {
            b(r1);
        }

        public void b(com.ss.android.ug.bus.c.b.b r1) {
            a.F(this.f15018a, false);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15020b;

        public d(String r1, String r2) {
            this.f15019a = r1;
            this.f15020b = r2;
        }

        public String a() {
            return this.f15019a;
        }

        public String b() {
            return this.f15020b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L26:
            return false;
        L8:
            if (d.class != r5.getClass()) goto L26;
            d r6 = (d) r5;
            String r2 = this.f15019a;
            if (r2 == null) goto L16;
            if (r2.equals(r6.f15019a) == false) goto L17;
        L18:
            String r4 = this.f15020b;
            if (r4 == null) goto L22;
            return r4.equals(r6.f15020b);
        L22:
            if (r6.f15020b != null) goto L25;
            return true;
        L25:
            return false;
        L17:
            return false;
        L16:
            if (r6.f15019a == null) goto L18;
            goto L17
        }

        public int hashCode() {
            String r0 = this.f15019a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.f15020b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public a(Context r2, d.b.u.w.a r3) {
        this.f15014i = new ArrayList();
        this.f15015j = new ArrayList();
        this.f15012g = r2;
        this.f15011f = r3;
    }

    static /* synthetic */ void F(a r0, boolean r1) {
        r0.M(r1);
    }

    private void M(boolean r4) {
        monitor-enter(this);
        Iterator<UgCallbackCenter.d<Void>> r0 = this.f15014i.iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L9;
        UgCallbackCenter.d<Void> r1 = r0.next();     // Catch: Throwable -> L12
        if (r1 == null) goto L5;
        r1.a(null);     // Catch: Throwable -> L12
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        k.c().b(r4);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // d.b.u.w.b
    public void D(String r3) {
        this.f15013h = r3;
        d.b.u.b0.b.g(this.f15012g).i(r3);
        monitor-enter(this);
        Iterator<UgCallbackCenter.d<Void>> r4 = this.f15015j.iterator();     // Catch: Throwable -> L12
    L6:
        if (r4.hasNext() == false) goto L10;
        UgCallbackCenter.d<Void> r0 = r4.next();     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.a(null);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // d.b.u.w.b
    public void L(UgCallbackCenter.d<Void> r2) {
        monitor-enter(this);
        this.f15014i.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.b.u.w.b
    public void V() {
        this.f15011f.c(new C0406a(this));
        this.f15011f.d(new b(this));
        this.f15011f.e(new c(this));
    }

    @Override // d.b.u.w.b
    public d e() {
        String r0 = this.f15013h;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = d.b.u.b0.b.g(this.f15012g).e();
    L5:
        String r2 = this.f15011f.b();
        if (TextUtils.isEmpty(r2) == false) goto L9;
        r2 = BDLocationException.ERROR_TIMEOUT;
    L9:
        return new d(r0, r2);
    }

    @Override // d.b.u.w.b
    public void f0(UgCallbackCenter.d<Void> r2) {
        monitor-enter(this);
        this.f15014i.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
