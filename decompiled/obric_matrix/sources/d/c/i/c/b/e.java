package d.c.i.c.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import d.c.c.d.i;
import d.c.c.g.h;
import d.c.i.l.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static d.c.i.c.b.c f15868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static d.c.i.c.b.c f15869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static d.c.i.c.b.c f15870e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.c.c.b f15871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.d.f f15872b;

    class a implements d.c.i.c.c.d.b {
        a(e r1) {
        }

        @Override // d.c.i.c.c.d.b
        public void a(int r1, Bitmap r2) {
        }

        @Override // d.c.i.c.c.d.b
        public d.c.c.h.a<Bitmap> b(int r1) {
            return null;
        }
    }

    class b implements d.c.i.c.c.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f15873a;

        b(e r1, List r2) {
            this.f15873a = r2;
        }

        @Override // d.c.i.c.c.d.b
        public void a(int r1, Bitmap r2) {
        }

        @Override // d.c.i.c.c.d.b
        public d.c.c.h.a<Bitmap> b(int r1) {
            return d.c.c.h.a.E((d.c.c.h.a) this.f15873a.get(r1));
        }
    }

    class c implements d.c.i.c.c.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f15874a;

        c(e r1, List r2) {
            this.f15874a = r2;
        }

        @Override // d.c.i.c.c.d.b
        public void a(int r1, Bitmap r2) {
        }

        @Override // d.c.i.c.c.d.b
        public d.c.c.h.a<Bitmap> b(int r1) {
            return d.c.c.h.a.E((d.c.c.h.a) this.f15874a.get(r1));
        }
    }

    static {
        f15868c = i("com.facebook.animated.gif.GifImage");
        f15869d = i("com.facebook.animated.webp.WebPImage");
        f15870e = i("com.bytedance.fresco.animatedheif.HeifImage");
    }

    public e(d.c.i.c.c.b r1, d.c.i.d.f r2) {
        this.f15871a = r1;
        this.f15872b = r2;
    }

    @SuppressLint({"NewApi"})
    private d.c.c.h.a<Bitmap> d(int r1, int r2, Bitmap.Config r3) {
        d.c.c.h.a<Bitmap> r0 = this.f15872b.l(r1, r2, r3);
        r0.N().eraseColor(0);
        if (Build.VERSION.SDK_INT < 12) goto L5;
        r0.N().setHasAlpha(true);
    L5:
        return r0;
    }

    private d.c.c.h.a<Bitmap> e(d.c.i.c.a.c r3, Bitmap.Config r4, int r5) {
        d.c.c.h.a<Bitmap> r6 = d(r3.getWidth(), r3.getHeight(), r4);
        d.c.i.c.a.e r7 = d.c.i.c.a.e.b(r3);
        new d.c.i.c.c.d(this.f15871a.a(r7, null), new a(this)).f(r5, r6.N());
        return r6;
    }

    private List<d.c.c.h.a<Bitmap>> f(d.c.i.c.a.c r6, Bitmap.Config r7) {
        d.c.i.c.a.e r8 = d.c.i.c.a.e.b(r6);
        d.c.i.c.a.a r9 = this.f15871a.a(r8, null);
        ArrayList r0 = new ArrayList(r9.a());
        d.c.i.c.c.d r1 = new d.c.i.c.c.d(r9, new b(this, r0));
        int r2 = 0;
    L4:
        if (r2 >= r9.a()) goto L6;
        d.c.c.h.a<Bitmap> r3 = d(r9.getWidth(), r9.getHeight(), r7);
        r1.f(r2, r3.N());
        r0.add(r3);
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    private List<d.c.c.h.a<Bitmap>> g(d.c.i.c.a.c r9, Bitmap.Config r10, int r11) {
        d.c.i.c.a.a r12 = this.f15871a.a(d.c.i.c.a.e.b(r9), null);
        int r0 = r12.a();
        if (r11 <= r0) goto L6;
        r11 = r0;
    L6:
        if ((r12 instanceof d.c.i.c.c.a) == false) goto L8;
        ((d.c.i.c.c.a) r12).p(1);
    L8:
        ArrayList r1 = new ArrayList(r11);
        d.c.i.c.c.d r2 = new d.c.i.c.c.d(r12, new c(this, r1));
        int r3 = 0;
    L9:
        if (r3 >= r11) goto L16;
        d.c.c.h.a<Bitmap> r4 = d(r12.getWidth(), r12.getHeight(), r10);
        r2.f(r3, r4.N());     // Catch: IllegalStateException -> L13
        r1.add(r4);     // Catch: IllegalStateException -> L13
    L15:
        r3 = r3 + 1;
    L13:
        e = move-exception;
        d.c.c.e.a.D("AnimatedImageFactoryImp", e, "preview decode failed", new Object[0]);
        goto L15
    L16:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [d.c.i.c.a.f] */
    private d.c.i.l.c h(d.c.i.f.c r4, d.c.i.c.a.c r5, Bitmap.Config r6, d.c.h.d r7) {
        d.c.c.h.a<Bitmap> r8 = null;
    L39:
        th = th;
        ?? r1 = 0;
    L41:
        d.c.c.h.a.L(r8);
        d.c.c.h.a.M(r1);
        throw th;
    L4:
        if (r4.f15994d == false) goto L6;
        int r0 = r5.a() - 1;     // Catch: Throwable -> L39
    L8:
        if (r4.f15996f == false) goto L12;
        d.c.i.l.d r9 = new d.c.i.l.d(e(r5, r4.f15998h, r0), g.f16188d, 0);     // Catch: Throwable -> L39
        d.c.c.h.a.L(null);
        d.c.c.h.a.M(null);
        return r9;
    L12:
        r1 = d.c.h.c.e(r7);     // Catch: Throwable -> L39
        if (r1 == 0) goto L15;
        r1 = 0;
    L34:
        ?? r3 = d.c.i.c.a.e.h(r5);     // Catch: Throwable -> L37
        r3.h(r8);     // Catch: Throwable -> L37
        r3.g(r0);     // Catch: Throwable -> L37
        r3.f(r1);     // Catch: Throwable -> L37
        d.c.i.l.a r10 = new d.c.i.l.a(r3.a(), r4, r7);     // Catch: Throwable -> L37
        d.c.c.h.a.L(r8);
        d.c.c.h.a.M(r1);
        return r10;
    L15:
        if (r4.f15995e == false) goto L22;
        List<d.c.c.h.a<Bitmap>> r2 = f(r5, r4.f15998h);     // Catch: Throwable -> L39
        int r11 = r2.size();     // Catch: Throwable -> L37
        List<d.c.c.h.a<Bitmap>> r12 = r2;
        if (r11 <= r0) goto L29;
        d.c.c.h.a<Bitmap> r13 = r2.get(r0);     // Catch: Throwable -> L37
        List<d.c.c.h.a<Bitmap>> r14 = r2;
    L20:
        r8 = d.c.c.h.a.E(r13);     // Catch: Throwable -> L37
        r12 = r14;
    L29:
        r1 = r12;
        r1 = r12;
        if (r4.f15992b == false) goto L34;
        if (r8 != null) goto L34;
        r8 = e(r5, r4.f15998h, r0);     // Catch: Throwable -> L37
        r1 = r12;
        goto L34
    L22:
        int r15 = r4.f15993c;     // Catch: Throwable -> L39
        if (r15 <= 0) goto L28;
        List<d.c.c.h.a<Bitmap>> r16 = g(r5, r4.f15998h, r15);     // Catch: Throwable -> L39
        int r17 = r16.size();     // Catch: Throwable -> L37
        r12 = r16;
        if (r17 <= r0) goto L29;
        r13 = r16.get(r0);     // Catch: Throwable -> L37
        r14 = r16;
        goto L20
    L28:
        r12 = null;
    L37:
        th = th;
        goto L41
    L6:
        r0 = 0;
        goto L8
    }

    private static d.c.i.c.b.c i(String r0) {
        return (d.c.i.c.b.c) Class.forName(r0).newInstance();
    L4:
        return null;
    }

    @Override // d.c.i.c.b.d
    public d.c.i.l.c a(d.c.i.l.e r6, d.c.i.f.c r7, Bitmap.Config r8) {
        if (f15868c == null) goto L16;
        d.c.c.h.a<h> r0 = r6.s();
        i.g(r0);
        h r1 = r0.N();     // Catch: Throwable -> L12
        if (r1.i() == null) goto L8;
        d.c.i.c.a.c r2 = f15868c.i(r1.i());     // Catch: Throwable -> L12
    L9:
        d.c.i.l.c r5 = h(r7, r2, r8, r6.N());     // Catch: Throwable -> L12
        d.c.c.h.a.L(r0);
        return r5;
    L8:
        r2 = f15868c.f(r1.j(), r1.size());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.c.c.h.a.L(r0);
        throw th;
    L16:
        throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
    }

    @Override // d.c.i.c.b.d
    public d.c.i.l.c b(d.c.i.l.e r6, d.c.i.f.c r7, Bitmap.Config r8) {
        if (f15869d == null) goto L19;
        d.c.c.h.a<h> r0 = r6.s();
        i.g(r0);
        h r1 = r0.N();     // Catch: Throwable -> L15
        if (r1.i() == null) goto L8;
        d.c.i.c.a.c r2 = f15869d.i(r1.i());     // Catch: Throwable -> L15
    L10:
        if ((r2 instanceof d.c.i.c.a.g) == false) goto L12;
        ((d.c.i.c.a.g) r2).l(r6.C());     // Catch: Throwable -> L15
    L12:
        d.c.i.l.c r5 = h(r7, r2, r8, r6.N());     // Catch: Throwable -> L15
        d.c.c.h.a.L(r0);
        return r5;
    L8:
        r2 = f15869d.f(r1.j(), r1.size());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.c.c.h.a.L(r0);
        throw th;
    L19:
        throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
    }

    @Override // d.c.i.c.b.d
    public d.c.i.l.c c(d.c.i.l.e r6, d.c.i.f.c r7, Bitmap.Config r8) {
        if (f15869d == null) goto L19;
        d.c.c.h.a<h> r0 = r6.s();
        i.g(r0);
        h r1 = r0.N();     // Catch: Throwable -> L15
        if (r1.i() == null) goto L8;
        d.c.i.c.a.c r2 = f15870e.i(r1.i());     // Catch: Throwable -> L15
    L10:
        if ((r2 instanceof d.c.i.c.a.g) == false) goto L12;
        ((d.c.i.c.a.g) r2).l(r6.C());     // Catch: Throwable -> L15
    L12:
        d.c.i.l.c r5 = h(r7, r2, r8, r6.N());     // Catch: Throwable -> L15
        d.c.c.h.a.L(r0);
        return r5;
    L8:
        r2 = f15870e.f(r1.j(), r1.size());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.c.c.h.a.L(r0);
        throw th;
    L19:
        throw new UnsupportedOperationException("To encode animated heif please add the dependency to the animated-heif module");
    }
}
