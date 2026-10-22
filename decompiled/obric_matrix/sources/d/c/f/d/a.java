package d.c.f.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import d.c.f.d.b.b;
import d.c.f.e.p;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f15605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private p.b f15606l;
    private int m;
    private int n;
    private int o;
    private final Paint p;
    private final Matrix q;
    private final Rect r;
    private final RectF s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private long y;
    private String z;

    public a() {
        this.o = 80;
        this.p = new Paint(1);
        this.q = new Matrix();
        this.r = new Rect();
        this.s = new RectF();
        e();
    }

    private void b(Canvas r3, String r4, Object... r5) {
        if (r5 == null) goto L5;
        r4 = String.format(r4, r5);
    L5:
        r3.drawText(r4, this.w, this.x, this.p);
        this.x += this.v;
    }

    private void d(Rect r3, int r4, int r5) {
        int r6 = Math.min(40, Math.max(10, Math.min(r3.width() / r5, r3.height() / r4)));
        this.p.setTextSize(r6);
        int r7 = r6 + 8;
        this.v = r7;
        int r0 = this.o;
        if (r0 != 80) goto L5;
        this.v = r7 * (-1);
    L5:
        this.t = r3.left + 10;
        if (r0 != 80) goto L8;
        int r8 = r3.bottom - 10;
    L9:
        this.u = r8;
        return;
    L8:
        r8 = (r3.top + 10) + 10;
        goto L9
    }

    @Override // d.c.f.d.b.b
    public void a(long r1) {
        this.y = r1;
        invalidateSelf();
    }

    int c(int r12, int r13, p.b r14) {
        int r0 = getBounds().width();
        int r1 = getBounds().height();
        if (r0 <= 0) goto L22;
        if (r1 <= 0) goto L22;
        if (r12 <= 0) goto L22;
        if (r13 <= 0) goto L22;
        if (r14 == null) goto L10;
        Rect r3 = this.r;
        r3.top = 0;
        r3.left = 0;
        r3.right = r0;
        r3.bottom = r1;
        this.q.reset();
        r14.a(this.q, this.r, r12, r13, 0.0f, 0.0f);
        RectF r15 = this.s;
        r15.top = 0.0f;
        r15.left = 0.0f;
        r15.right = r12;
        r15.bottom = r13;
        this.q.mapRect(r15);
        int r16 = (int) this.s.width();
        int r11 = (int) this.s.height();
        r0 = Math.min(r0, r16);
        r1 = Math.min(r1, r11);
    L10:
        float r17 = r0;
        float r4 = r17 * 0.1f;
        float r18 = r17 * 0.5f;
        float r5 = r1;
        float r19 = 0.1f * r5;
        float r6 = r5 * 0.5f;
        int r110 = Math.abs(r12 - r0);
        int r111 = Math.abs(r13 - r1);
        float r112 = r110;
        if (r112 >= r4) goto L17;
        if (r111 >= r19) goto L17;
        return 1716301648;
    L17:
        if (r112 >= r18) goto L22;
        if (r111 >= r6) goto L22;
        return 1728026624;
    L22:
        return 1727284022;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        Rect r0 = getBounds();
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(2.0f);
        this.p.setColor(-26624);
        r9.drawRect(r0.left, r0.top, r0.right, r0.bottom, this.p);
        this.p.setStyle(Paint.Style.FILL);
        this.p.setColor(c(this.f15602h, this.f15603i, this.f15606l));
        r9.drawRect(r0.left, r0.top, r0.right, r0.bottom, this.p);
        this.p.setStyle(Paint.Style.FILL);
        this.p.setStrokeWidth(0.0f);
        this.p.setColor(-1);
        this.w = this.t;
        this.x = this.u;
        String r1 = this.f15601g;
        if (r1 == null) goto L5;
        b(r9, "IDs: %s, %s", new Object[]{this.f15600f, r1});
    L6:
        b(r9, "D: %dx%d", new Object[]{Integer.valueOf(r0.width()), Integer.valueOf(r0.height())});
        b(r9, "I: %dx%d", new Object[]{Integer.valueOf(this.f15602h), Integer.valueOf(this.f15603i)});
        b(r9, "I: %d KiB", new Object[]{Integer.valueOf(this.f15604j / 1024)});
        String r2 = this.f15605k;
        if (r2 == null) goto L9;
        b(r9, "i format: %s", new Object[]{r2});
    L9:
        int r3 = this.m;
        if (r3 <= 0) goto L12;
        b(r9, "anim: f %d, l %d", new Object[]{Integer.valueOf(r3), Integer.valueOf(this.n)});
    L12:
        p.b r4 = this.f15606l;
        if (r4 == null) goto L15;
        b(r9, "scale: %s", new Object[]{r4});
    L15:
        long r5 = this.y;
        if (r5 < 0) goto L18;
        b(r9, "t: %d ms", new Object[]{Long.valueOf(r5)});
    L18:
        String r6 = this.z;
        if (r6 == null) goto L22;
        b(r9, "origin: %s", new Object[]{r6});
        return;
    L22:
        return;
    L5:
        b(r9, "ID: %s", new Object[]{this.f15600f});
        goto L6
    }

    public void e() {
        this.f15602h = -1;
        this.f15603i = -1;
        this.f15604j = -1;
        this.m = -1;
        this.n = -1;
        this.f15605k = null;
        f(null);
        this.y = -1;
        this.z = null;
        invalidateSelf();
    }

    public void f(String r1) {
        if (r1 != null) goto L5;
        r1 = "none";
    L5:
        this.f15600f = r1;
        invalidateSelf();
    }

    public void g(int r1, int r2) {
        this.f15602h = r1;
        this.f15603i = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int r1) {
        this.f15604j = r1;
    }

    public void i(String r1) {
        this.z = r1;
        invalidateSelf();
    }

    public void j(p.b r1) {
        this.f15606l = r1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r3) {
        super.onBoundsChange(r3);
        d(r3, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
