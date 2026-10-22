package d.c.g.a.b.f;

import android.graphics.Bitmap;
import android.graphics.Rect;
import d.c.g.a.b.c;
import d.c.i.c.c.d;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class<?> f15787e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g.a.b.b f15788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.i.c.a.a f15789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f15790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b f15791d;

    class a implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f15792a;

        a(b r1) {
            this.f15792a = r1;
        }

        @Override // d.c.i.c.c.d.b
        public void a(int r1, Bitmap r2) {
        }

        @Override // d.c.i.c.c.d.b
        public d.c.c.h.a<Bitmap> b(int r1) {
            return b.b(this.f15792a).d(r1);
        }
    }

    static {
        f15787e = b.class;
    }

    public b(d.c.g.a.b.b r2, d.c.i.c.a.a r3) {
        a r0 = new a(this);
        this.f15791d = r0;
        this.f15788a = r2;
        this.f15789b = r3;
        this.f15790c = new d(r3, r0);
    }

    static /* synthetic */ d.c.g.a.b.b b(b r0) {
        return r0.f15788a;
    }

    @Override // d.c.g.a.b.c
    public boolean a(int r3, Bitmap r4) {
        this.f15790c.f(r3, r4);     // Catch: IllegalStateException -> L5
        return true;
    L5:
        e = move-exception;
        d.c.c.e.a.i(f15787e, e, "Rendering of frame unsuccessful. Frame number: %d", new Object[]{Integer.valueOf(r3)});
        return false;
    }

    @Override // d.c.g.a.b.c
    public int c() {
        return this.f15789b.getHeight();
    }

    @Override // d.c.g.a.b.c
    public void d(Rect r3) {
        d.c.i.c.a.a r4 = this.f15789b.f(r3);
        if (r4 == this.f15789b) goto L6;
        this.f15789b = r4;
        this.f15790c = new d(r4, this.f15791d);
        return;
    }

    @Override // d.c.g.a.b.c
    public int e() {
        return this.f15789b.getWidth();
    }
}
