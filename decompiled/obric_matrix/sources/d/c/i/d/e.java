package d.c.i.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import d.c.c.g.h;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class e extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15910d = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f15911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.n.g f15912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15913c;

    static {
    }

    public e(b r1, d.c.i.n.g r2) {
        this.f15911a = r1;
        this.f15912b = r2;
    }

    private static d.c.c.h.a<Bitmap> o(int r0, int r1, Bitmap.Config r2) {
        return d.c.c.h.a.X(Bitmap.createBitmap(r0, r1, r2), g.a());
    }

    @Override // d.c.i.d.f
    @TargetApi(12)
    public d.c.c.h.a<Bitmap> l(int r6, int r7, Bitmap.Config r8) {
        if (this.f15913c == true) goto L5;
        d.c.c.h.a<h> r0 = this.f15911a.a((short) r6, (short) r7);
        d.c.i.l.e r1 = new d.c.i.l.e(r0);     // Catch: Throwable -> L21
        r1.D0(d.c.h.c.f15819a);     // Catch: Throwable -> L21
        d.c.c.h.a<Bitmap> r2 = this.f15912b.c(r1, r8, null, r0.N().size());     // Catch: Throwable -> L18
        if (r2.N().isMutable() == true) goto L14;
        d.c.c.h.a.L(r2);     // Catch: Throwable -> L18
        this.f15913c = true;     // Catch: Throwable -> L18
        d.c.c.e.a.F(f15910d, "Immutable bitmap returned by decoder");     // Catch: Throwable -> L18
        d.c.c.h.a<Bitmap> r5 = o(r6, r7, r8);     // Catch: Throwable -> L18
        d.c.i.l.e.g(r1);     // Catch: Throwable -> L21
        r0.close();
        return r5;
    L14:
        r2.N().setHasAlpha(true);     // Catch: Throwable -> L18
        r2.N().eraseColor(0);     // Catch: Throwable -> L18
        d.c.i.l.e.g(r1);     // Catch: Throwable -> L21
        r0.close();
        return r2;
    L18:
        th = move-exception;
        d.c.i.l.e.g(r1);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r0.close();
        throw th;
    L5:
        return o(r6, r7, r8);
    }
}
