package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class l extends f implements i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    b f15643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f15644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RectF f15645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Matrix f15646l;
    private final float[] m;
    final float[] n;
    final Paint o;
    private boolean p;
    private float q;
    private int r;
    private int s;
    private float t;
    private boolean u;
    private final Path v;
    private final Path w;
    private final RectF x;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15647a = null;

        static {
            int[] r0 = new int[b.values().length];
            f15647a = r0;
            r0[b.f15649g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f15647a[b.f15648f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f15648f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f15649g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ b[] f15650h = null;

        static {
            b r0 = new b("OVERLAY_COLOR", 0);
            f15648f = r0;
            b r1 = new b("CLIPPING", 1);
            f15649g = r1;
            f15650h = new b[]{r0, r1};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f15650h.clone();
        }
    }

    public l(Drawable r2) {
        d.c.c.d.i.g(r2);
        super(r2);
        this.f15643i = b.f15648f;
        this.f15644j = new RectF();
        this.m = new float[8];
        this.n = new float[8];
        this.o = new Paint(1);
        this.p = false;
        this.q = 0.0f;
        this.r = 0;
        this.s = 0;
        this.t = 0.0f;
        this.u = false;
        this.v = new Path();
        this.w = new Path();
        this.x = new RectF();
    }

    private void q() {
        this.v.reset();
        this.w.reset();
        this.x.set(getBounds());
        RectF r0 = this.x;
        float r1 = this.t;
        r0.inset(r1, r1);
        this.v.addRect(this.x, Path.Direction.CW);
        if (this.p == false) goto L5;
        this.v.addCircle(this.x.centerX(), this.x.centerY(), Math.min(this.x.width(), this.x.height()) / 2.0f, Path.Direction.CW);
    L6:
        RectF r2 = this.x;
        float r3 = this.t;
        r2.inset(-r3, -r3);
        RectF r4 = this.x;
        float r5 = this.q;
        r4.inset(r5 / 2.0f, r5 / 2.0f);
        if (this.p == false) goto L9;
        float r6 = Math.min(this.x.width(), this.x.height()) / 2.0f;
        this.w.addCircle(this.x.centerX(), this.x.centerY(), r6, Path.Direction.CW);
    L14:
        RectF r7 = this.x;
        float r8 = this.q;
        r7.inset((-r8) / 2.0f, (-r8) / 2.0f);
        return;
    L9:
        int r9 = 0;
    L10:
        float[] r10 = this.n;
        if (r9 >= r10.length) goto L13;
        r10[r9] = (this.m[r9] + this.t) - (this.q / 2.0f);
        r9 = r9 + 1;
        goto L10
    L13:
        this.w.addRoundRect(this.x, r10, Path.Direction.CW);
        goto L14
    L5:
        this.v.addRoundRect(this.x, this.m, Path.Direction.CW);
        goto L6
    }

    @Override // d.c.f.e.i
    public void a(int r1, float r2) {
        this.r = r1;
        this.q = r2;
        q();
        invalidateSelf();
    }

    @Override // d.c.f.e.i
    public void c(boolean r1) {
        this.p = r1;
        q();
        invalidateSelf();
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        this.f15644j.set(getBounds());
        int r0 = a.f15647a[this.f15643i.ordinal()];
        if (r0 != 1) goto L5;
        int r1 = r11.save();
        this.v.setFillType(Path.FillType.EVEN_ODD);
        r11.clipPath(this.v);
        super.draw(r11);
        r11.restoreToCount(r1);
    L25:
        if (this.r == 0) goto L28;
        this.o.setStyle(Paint.Style.STROKE);
        this.o.setColor(this.r);
        this.o.setStrokeWidth(this.q);
        this.v.setFillType(Path.FillType.EVEN_ODD);
        r11.drawPath(this.w, this.o);
        return;
    L28:
        return;
    L5:
        if (r0 != 2) goto L25;
        if (this.u == false) goto L14;
        RectF r2 = this.f15645k;
        if (r2 != null) goto L12;
        this.f15645k = new RectF(this.f15644j);
        this.f15646l = new Matrix();
    L13:
        RectF r3 = this.f15645k;
        float r4 = this.q;
        r3.inset(r4, r4);
        this.f15646l.setRectToRect(this.f15644j, this.f15645k, Matrix.ScaleToFit.FILL);
        int r5 = r11.save();
        r11.clipRect(this.f15644j);
        r11.concat(this.f15646l);
        super.draw(r11);
        r11.restoreToCount(r5);
    L15:
        this.o.setStyle(Paint.Style.FILL);
        this.o.setColor(this.s);
        this.o.setStrokeWidth(0.0f);
        this.v.setFillType(Path.FillType.EVEN_ODD);
        r11.drawPath(this.v, this.o);
        if (this.p == false) goto L25;
        float r6 = ((this.f15644j.width() - this.f15644j.height()) + this.q) / 2.0f;
        float r7 = ((this.f15644j.height() - this.f15644j.width()) + this.q) / 2.0f;
        if (r6 <= 0.0f) goto L21;
        RectF r8 = this.f15644j;
        float r9 = r8.left;
        r11.drawRect(r9, r8.top, r9 + r6, r8.bottom, this.o);
        RectF r10 = this.f15644j;
        float r12 = r10.right;
        r11.drawRect(r12 - r6, r10.top, r12, r10.bottom, this.o);
    L21:
        if (r7 <= 0.0f) goto L25;
        RectF r13 = this.f15644j;
        float r14 = r13.left;
        float r15 = r13.top;
        r11.drawRect(r14, r15, r13.right, r15 + r7, this.o);
        RectF r16 = this.f15644j;
        float r17 = r16.left;
        float r18 = r16.bottom;
        r11.drawRect(r17, r18 - r7, r16.right, r18, this.o);
        goto L25
    L12:
        r2.set(this.f15644j);
        goto L13
    L14:
        super.draw(r11);
        goto L15
    }

    @Override // d.c.f.e.i
    public void e(boolean r1) {
        this.u = r1;
        q();
        invalidateSelf();
    }

    @Override // d.c.f.e.i
    public void h(float r1) {
        this.t = r1;
        q();
        invalidateSelf();
    }

    @Override // d.c.f.e.i
    public void i(float r2) {
        Arrays.fill(this.m, r2);
        q();
        invalidateSelf();
    }

    @Override // d.c.f.e.i
    public void l(float[] r5) {
        if (r5 != null) goto L5;
        Arrays.fill(this.m, 0.0f);
    L9:
        q();
        invalidateSelf();
        return;
    L5:
        if (r5.length != 8) goto L7;
        boolean r0 = true;
    L8:
        d.c.c.d.i.c(r0, "radii should have exactly 8 values");
        System.arraycopy(r5, 0, this.m, 0, 8);
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        q();
    }

    public void p(int r1) {
        this.s = r1;
        invalidateSelf();
    }
}
