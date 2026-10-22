package d.c.g.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import d.c.g.a.a.d;
import d.c.i.d.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.g.a.a.a, d.c.g.a.a.c.b {
    private static final Class<?> m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f15752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f15753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f15754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f15755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.g.a.b.e.a f15756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.g.a.b.e.b f15757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f15758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f15759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bitmap.Config f15762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private InterfaceC0424a f15763l;

    /* JADX INFO: renamed from: d.c.g.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0424a {
        void a(a r1, int r2, int r3);

        void b(a r1, int r2);

        void c(a r1, int r2);
    }

    static {
        m = a.class;
    }

    public a(f r2, b r3, d r4, c r5, d.c.g.a.b.e.a r6, d.c.g.a.b.e.b r7) {
        this.f15762k = Bitmap.Config.ARGB_8888;
        this.f15752a = r2;
        this.f15753b = r3;
        this.f15754c = r4;
        this.f15755d = r5;
        this.f15756e = r6;
        this.f15757f = r7;
        this.f15758g = new Paint(6);
        r();
    }

    private boolean l(int r5, d.c.c.h.a<Bitmap> r6, Canvas r7, int r8) {
        if (d.c.c.h.a.S(r6) == true) goto L22;
        return false;
    L22:
    L11:
        e = move-exception;
        d.c.c.e.a.g(m, "canvas draw error: ", e);
    L14:
        if (r8 == 3) goto L16;
        this.f15753b.e(r5, r6, r8);
    L16:
        InterfaceC0424a r9 = this.f15763l;
        if (r9 == null) goto L24;
        r9.a(this, r5, r8);
        return true;
    L24:
        return true;
    L7:
        if (this.f15759h != null) goto L9;
        r7.drawBitmap(r6.N(), 0.0f, 0.0f, this.f15758g);     // Catch: Exception -> L11
    L21:
        goto L14
    L9:
        r7.drawBitmap(r6.N(), null, this.f15759h, this.f15758g);     // Catch: Exception -> L11
        goto L21
    }

    private boolean m(Canvas r10, int r11, int r12) {
        int r1 = 3;
        boolean r3 = false;
        if (r12 == 0) goto L28;
        if (r12 == 1) goto L21;
        if (r12 == 2) goto L40;
        if (r12 == 3) goto L9;
        d.c.c.h.a.L(null);
        return false;
    L9:
        d.c.c.h.a<Bitmap> r5 = this.f15753b.f(r11);     // Catch: Throwable -> L37
        boolean r13 = l(r11, r5, r10, 3);     // Catch: Throwable -> L37
        r1 = -1;
    L30:
        d.c.c.h.a.L(r5);
        if (r13 == true) goto L36;
        if (r1 == (-1)) goto L36;
        return m(r10, r11, r1);
    L36:
        return r13;
    L40:
        r5 = this.f15752a.d(this.f15760i, this.f15761j, this.f15762k);     // Catch: RuntimeException -> L17 Throwable -> L37
    L13:
        if (o(r11, r5) == true) goto L15;
    L27:
        r13 = r3;
        goto L30
    L15:
        if (l(r11, r5, r10, 2) == false) goto L27;
        r3 = true;
    L17:
        e = move-exception;
        d.c.c.e.a.z(m, "Failed to create frame bitmap", e);     // Catch: Throwable -> L37
        d.c.c.h.a.L(null);
        return false;
    L21:
        r5 = this.f15753b.a(r11, this.f15760i, this.f15761j);     // Catch: Throwable -> L37
        if (o(r11, r5) == true) goto L24;
    L26:
        r1 = 2;
        goto L27
    L24:
        if (l(r11, r5, r10, 1) == false) goto L26;
        r3 = true;
        goto L26
    L28:
        r5 = this.f15753b.d(r11);     // Catch: Throwable -> L37
        r13 = l(r11, r5, r10, 0);     // Catch: Throwable -> L37
        r1 = 1;
    L37:
        th = move-exception;
        d.c.c.h.a.L(null);
        throw th;
    }

    private boolean o(int r2, d.c.c.h.a<Bitmap> r3) {
        if (d.c.c.h.a.S(r3) == true) goto L6;
        return false;
    L6:
        boolean r1 = this.f15755d.a(r2, r3.N());
        if (r1 == true) goto L9;
        d.c.c.h.a.L(r3);
    L9:
        return r1;
    }

    private void r() {
        int r0 = this.f15755d.e();
        this.f15760i = r0;
        int r1 = -1;
        if (r0 != (-1)) goto L9;
        Rect r2 = this.f15759h;
        if (r2 != null) goto L7;
        int r3 = -1;
    L8:
        this.f15760i = r3;
        goto L9
    L7:
        r3 = r2.width();
    L9:
        int r4 = this.f15755d.c();
        this.f15761j = r4;
        if (r4 != (-1)) goto L17;
        Rect r5 = this.f15759h;
        if (r5 == null) goto L15;
        r1 = r5.height();
    L15:
        this.f15761j = r1;
        return;
    }

    @Override // d.c.g.a.a.d
    public int a() {
        return this.f15754c.a();
    }

    @Override // d.c.g.a.a.d
    public int b() {
        return this.f15754c.b();
    }

    @Override // d.c.g.a.a.a
    public int c() {
        return this.f15761j;
    }

    @Override // d.c.g.a.a.a
    public void clear() {
        this.f15753b.clear();
    }

    @Override // d.c.g.a.a.a
    public void d(Rect r2) {
        this.f15759h = r2;
        this.f15755d.d(r2);
        r();
    }

    @Override // d.c.g.a.a.a
    public int e() {
        return this.f15760i;
    }

    @Override // d.c.g.a.a.a
    public boolean f(int r1) {
        return this.f15753b.c(r1);
    }

    @Override // d.c.g.a.a.c.b
    public void g() {
        clear();
    }

    @Override // d.c.g.a.a.a
    public void h(ColorFilter r1) {
        this.f15758g.setColorFilter(r1);
    }

    @Override // d.c.g.a.a.d
    public int i(int r1) {
        return this.f15754c.i(r1);
    }

    @Override // d.c.g.a.a.a
    public void j(@IntRange(from = 0, to = 255) int r1) {
        this.f15758g.setAlpha(r1);
    }

    @Override // d.c.g.a.a.a
    public boolean k(Drawable r3, Canvas r4, int r5) {
        InterfaceC0424a r6 = this.f15763l;
        if (r6 == null) goto L5;
        r6.c(this, r5);
    L5:
        boolean r7 = m(r4, r5, 0);
        if (r7 == true) goto L10;
        InterfaceC0424a r8 = this.f15763l;
        if (r8 == null) goto L10;
        r8.b(this, r5);
    L10:
        d.c.g.a.b.e.a r9 = this.f15756e;
        if (r9 == null) goto L15;
        d.c.g.a.b.e.b r0 = this.f15757f;
        if (r0 == null) goto L15;
        r9.a(r0, this.f15753b, this, r5);
    L15:
        return r7;
    }

    public d n() {
        return this.f15754c;
    }

    public void p(Bitmap.Config r1) {
        this.f15762k = r1;
    }

    public void q(d.c.g.a.b.e.a r1) {
        this.f15756e = r1;
    }
}
