package d.c.i.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import d.c.i.c.a.e;
import d.c.i.c.b.f;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d.c.i.c.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.c.d.a f15875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f15876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.i.c.a.c f15877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f15878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f15879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.i.c.a.b[] f15880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f15881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f15882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bitmap f15884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15885k;

    public a(d.c.i.c.d.a r2, e r3, Rect r4) {
        this.f15881g = new Rect();
        this.f15882h = new Rect();
        this.f15883i = 2;
        this.f15875a = r2;
        this.f15876b = r3;
        d.c.i.c.a.c r5 = r3.e();
        this.f15877c = r5;
        int[] r0 = r5.j();
        this.f15879e = r0;
        r2.a(r0);
        r2.c(r0);
        r2.b(r0);
        this.f15878d = k(r5, r4);
        this.f15880f = new d.c.i.c.a.b[r5.a()];
        int r6 = 0;
    L4:
        if (r6 >= this.f15877c.a()) goto L6;
        this.f15880f[r6] = this.f15877c.c(r6);
        r6 = r6 + 1;
        goto L4
    }

    private synchronized void j() {
        monitor-enter(this);
        Bitmap r0 = this.f15884j;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L9:
        monitor-exit(this);
        return;
    L6:
        if (this.f15885k == true) goto L8;
        r0.recycle();     // Catch: Throwable -> L11
    L8:
        this.f15884j = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static Rect k(d.c.i.c.a.c r4, Rect r5) {
        if (r5 != null) goto L7;
        return new Rect(0, 0, r4.getWidth(), r4.getHeight());
    L7:
        return new Rect(0, 0, Math.min(r5.width(), r4.getWidth()), Math.min(r5.height(), r4.getHeight()));
    }

    private String l(Bitmap r2, int r3, int r4, Rect r5, int r6) {
        StringBuilder r1 = new StringBuilder();
        r1.append(", mTempBitmap:");
        r1.append(r2.getWidth());
        r1.append("x");
        r1.append(r2.getHeight());
        r1.append(", frame:");
        r1.append(r3);
        r1.append("x");
        r1.append(r4);
        if (r5 == null) goto L5;
        r1.append(", renderedBounds:");
        r1.append(r5.width());
        r1.append("x");
        r1.append(r5.height());
    L5:
        r1.append(", decodeType:");
        r1.append(r6);
        return r1.toString();
    }

    private synchronized void m(int r4, int r5) {
        monitor-enter(this);
        Bitmap r0 = this.f15884j;     // Catch: Throwable -> L20
        if (r0 == null) goto L11;
        if (r0.getWidth() >= r4) goto L8;
    L9:
        j();     // Catch: Throwable -> L20
        goto L11
    L8:
        if (this.f15884j.getHeight() < r5) goto L9;
    L11:
        if (this.f15884j != null) goto L18;
        f r1 = d.c.i.c.b.b.b();     // Catch: Throwable -> L20
        Bitmap r2 = null;
        if (r1 == null) goto L15;
        r2 = r1.a(r4, r5, Bitmap.Config.ARGB_8888, this.f15883i);     // Catch: Throwable -> L20
    L15:
        if (r2 == null) goto L17;
        this.f15884j = r2;     // Catch: Throwable -> L20
        this.f15885k = true;     // Catch: Throwable -> L20
        goto L18
    L17:
        this.f15884j = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L20
        this.f15885k = false;     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void n(Canvas r9, d.c.i.c.a.d r10) {
        int r2 = r10.getWidth();
        int r3 = r10.getHeight();
        int r0 = r10.b();
        int r1 = r10.c();
        monitor-enter(this);
        m(r2, r3);     // Catch: Throwable -> L18
        Bitmap r6 = this.f15884j;     // Catch: Throwable -> L18
        monitor-enter(r6);     // Catch: Throwable -> L18
        this.f15884j.eraseColor(0);     // Catch: Throwable -> L15
        r10.a(r2, r3, this.f15884j);     // Catch: IllegalStateException -> L12 Throwable -> L15
        this.f15881g.set(0, 0, r2, r3);     // Catch: Throwable -> L15
        this.f15882h.set(0, 0, r2, r3);     // Catch: Throwable -> L15
        r9.save();     // Catch: Throwable -> L15
        r9.translate(r0, r1);     // Catch: Throwable -> L15
        r9.drawBitmap(this.f15884j, this.f15881g, this.f15882h, null);     // Catch: Throwable -> L15
        r9.restore();     // Catch: Throwable -> L15
        monitor-exit(r6);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e.getMessage() + l(this.f15884j, r2, r3, null, this.f15883i));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void o(Canvas r13, d.c.i.c.a.d r14) {
        double r0 = ((double) this.f15878d.width()) / ((double) this.f15877c.getWidth());
        double r2 = ((double) this.f15878d.height()) / ((double) this.f15877c.getHeight());
        int r8 = (int) Math.round(((double) r14.getWidth()) * r0);
        int r9 = (int) Math.round(((double) r14.getHeight()) * r2);
        int r1 = (int) (((double) r14.b()) * r0);
        int r3 = (int) (((double) r14.c()) * r2);
        monitor-enter(this);
        int r4 = this.f15878d.width();     // Catch: Throwable -> L18
        int r5 = this.f15878d.height();     // Catch: Throwable -> L18
        m(r4, r5);     // Catch: Throwable -> L18
        Bitmap r6 = this.f15884j;     // Catch: Throwable -> L18
        monitor-enter(r6);     // Catch: Throwable -> L18
        this.f15884j.eraseColor(0);     // Catch: Throwable -> L15
        r14.a(r8, r9, this.f15884j);     // Catch: IllegalStateException -> L12 Throwable -> L15
        this.f15881g.set(0, 0, r4, r5);     // Catch: Throwable -> L15
        this.f15882h.set(r1, r3, r4 + r1, r5 + r3);     // Catch: Throwable -> L15
        r13.drawBitmap(this.f15884j, this.f15881g, this.f15882h, null);     // Catch: Throwable -> L15
        monitor-exit(r6);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e.getMessage() + l(this.f15884j, r8, r9, this.f15878d, this.f15883i));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.c.a.a
    public int a() {
        return this.f15877c.a();
    }

    @Override // d.c.i.c.a.a
    public int b() {
        return this.f15877c.b();
    }

    @Override // d.c.i.c.a.a
    public d.c.i.c.a.b c(int r1) {
        return this.f15880f[r1];
    }

    @Override // d.c.i.c.a.a
    public void d(int r2, Canvas r3) {
        d.c.i.c.a.d r4 = this.f15877c.e(r2);
    L9:
        th = move-exception;
        r4.dispose();
        throw th;
    L4:
        if (this.f15877c.g() == false) goto L6;
        o(r3, r4);     // Catch: Throwable -> L9
    L7:
        r4.dispose();
        return;
    L6:
        n(r3, r4);     // Catch: Throwable -> L9
        goto L7
    }

    @Override // d.c.i.c.a.a
    public int e(int r1) {
        return this.f15879e[r1];
    }

    @Override // d.c.i.c.a.a
    public d.c.i.c.a.a f(Rect r3) {
        if (k(this.f15877c, r3).equals(this.f15878d) == false) goto L6;
        return this;
    L6:
        return new a(this.f15875a, this.f15876b, r3);
    }

    @Override // d.c.i.c.a.a
    public int g() {
        return this.f15878d.height();
    }

    @Override // d.c.i.c.a.a
    public int getHeight() {
        return this.f15877c.getHeight();
    }

    @Override // d.c.i.c.a.a
    public int getWidth() {
        return this.f15877c.getWidth();
    }

    @Override // d.c.i.c.a.a
    public int h() {
        return this.f15878d.width();
    }

    @Override // d.c.i.c.a.a
    public e i() {
        return this.f15876b;
    }

    public void p(int r1) {
        this.f15883i = r1;
    }
}
