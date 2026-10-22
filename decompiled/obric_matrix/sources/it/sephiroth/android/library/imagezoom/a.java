package it.sephiroth.android.library.imagezoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends ImageView {
    protected RectF A;
    private e B;
    private f C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected g.a.a.a.a.b f17605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Matrix f17606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Matrix f17607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Matrix f17608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Handler f17609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Runnable f17610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f17611l;
    private float m;
    private float n;
    private boolean o;
    private boolean p;
    protected final Matrix q;
    protected final float[] r;
    private int s;
    private int t;
    private PointF u;
    protected d v;
    private boolean w;
    private boolean x;
    protected RectF y;
    protected RectF z;

    /* JADX INFO: renamed from: it.sephiroth.android.library.imagezoom.a$a, reason: collision with other inner class name */
    class RunnableC0465a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Drawable f17612f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Matrix f17613g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f17614h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f17615i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ a f17616j;

        RunnableC0465a(a r1, Drawable r2, Matrix r3, float r4, float r5) {
            this.f17616j = r1;
            this.f17612f = r2;
            this.f17613g = r3;
            this.f17614h = r4;
            this.f17615i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17616j.A(this.f17612f, this.f17613g, this.f17614h, this.f17615i);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        double f17617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double f17618g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ double f17619h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f17620i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ double f17621j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ double f17622k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f17623l;

        b(a r1, double r2, long r4, double r6, double r8) {
            this.f17623l = r1;
            this.f17619h = r2;
            this.f17620i = r4;
            this.f17621j = r6;
            this.f17622k = r8;
            this.f17617f = 0.0d;
            this.f17618g = 0.0d;
        }

        @Override // java.lang.Runnable
        public void run() {
            double r0 = Math.min(this.f17619h, System.currentTimeMillis() - this.f17620i);
            double r2 = this.f17623l.f17605f.b(r0, 0.0d, this.f17621j, this.f17619h);
            double r4 = this.f17623l.f17605f.b(r0, 0.0d, this.f17622k, this.f17619h);
            this.f17623l.t(r2 - this.f17617f, r4 - this.f17618g);
            this.f17617f = r2;
            this.f17618g = r4;
            if (r0 >= this.f17619h) goto L5;
            this.f17623l.f17609j.post(this);
            return;
        L5:
            a r1 = this.f17623l;
            RectF r3 = r1.h(r1.f17607h, true, true);
            float r5 = r3.left;
            if (r5 == 0.0f) goto L8;
        L9:
            this.f17623l.x(r5, r3.top);
            return;
        L8:
            if (r3.top != 0.0f) goto L9;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f17624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f17625g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f17626h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f17627i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f17628j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ float f17629k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f17630l;

        c(a r1, float r2, long r3, float r5, float r6, float r7, float r8) {
            this.f17630l = r1;
            this.f17624f = r2;
            this.f17625g = r3;
            this.f17626h = r5;
            this.f17627i = r6;
            this.f17628j = r7;
            this.f17629k = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            float r0 = Math.min(this.f17624f, System.currentTimeMillis() - this.f17625g);
            this.f17630l.E(this.f17627i + ((float) this.f17630l.f17605f.a(r0, 0.0d, this.f17626h, this.f17624f)), this.f17628j, this.f17629k);
            if (r0 >= this.f17624f) goto L5;
            this.f17630l.f17609j.post(this);
            return;
        L5:
            a r1 = this.f17630l;
            r1.s(r1.getScale());
            this.f17630l.b(true, true);
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f17631f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f17632g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f17633h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ d[] f17634i = null;

        static {
            d r0 = new d("NONE", 0);
            f17631f = r0;
            d r1 = new d("FIT_TO_SCREEN", 1);
            f17632g = r1;
            d r3 = new d("FIT_IF_BIGGER", 2);
            f17633h = r3;
            f17634i = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f17634i.clone();
        }
    }

    public interface e {
        void a(Drawable r1);
    }

    public interface f {
        void a(boolean r1, int r2, int r3, int r4, int r5);
    }

    public a(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public a(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.f17605f = new g.a.a.a.a.a();
        this.f17606g = new Matrix();
        this.f17607h = new Matrix();
        this.f17609j = new Handler();
        this.f17610k = null;
        this.f17611l = false;
        this.m = -1.0f;
        this.n = -1.0f;
        this.q = new Matrix();
        this.r = new float[9];
        this.s = -1;
        this.t = -1;
        this.u = new PointF();
        this.v = d.f17631f;
        this.y = new RectF();
        this.z = new RectF();
        this.A = new RectF();
        n(r2, r3, r4);
    }

    public void A(Drawable r8, Matrix r9, float r10, float r11) {
        if (getWidth() > 0) goto L6;
        this.f17610k = new RunnableC0465a(this, r8, r9, r10, r11);
        return;
    L6:
        a(r8, r9, r10, r11);
    }

    protected void B(RectF r6, RectF r7) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.top < 0.0f) goto L10;
        if (r6.bottom > this.t) goto L10;
        r7.top = 0.0f;
    L10:
        if (r6.left >= 0.0f) goto L12;
    L14:
        float r0 = r6.top;
        if ((r7.top + r0) >= 0.0f) goto L17;
    L19:
        float r1 = r6.bottom;
        float r2 = r7.top + r1;
        int r3 = this.t;
        if (r2 <= (r3 + 0)) goto L22;
    L24:
        float r4 = r6.left;
        if ((r7.left + r4) < 0.0f) goto L27;
        r7.left = (int) (0.0f - r4);
    L27:
        float r8 = r6.right;
        float r5 = r7.left + r8;
        int r9 = this.s;
        if (r5 > (r9 + 0)) goto L31;
        r7.left = (int) ((r9 + 0) - r8);
        return;
    L31:
        return;
    L22:
        if (r6.top >= 0.0f) goto L24;
        r7.top = (int) ((r3 + 0) - r1);
        goto L24
    L17:
        if (r6.bottom <= this.t) goto L19;
        r7.top = (int) (0.0f - r0);
        goto L19
    L12:
        if (r6.right > this.s) goto L14;
        r7.left = 0.0f;
        goto L14
    }

    protected void C(float r3) {
        if (r3 <= getMaxScale()) goto L6;
        r3 = getMaxScale();
    L6:
        if (r3 >= getMinScale()) goto L8;
        r3 = getMinScale();
    L8:
        PointF r0 = getCenter();
        E(r3, r0.x, r0.y);
    }

    public void D(float r3, float r4) {
        PointF r0 = getCenter();
        F(r3, r0.x, r0.y, r4);
    }

    protected void E(float r2, float r3, float r4) {
        if (r2 <= getMaxScale()) goto L5;
        r2 = getMaxScale();
    L5:
        u(r2 / getScale(), r3, r4);
        r(getScale());
        b(true, true);
    }

    protected void F(float r10, float r11, float r12, float r13) {
        if (r10 <= getMaxScale()) goto L5;
        r10 = getMaxScale();
    L5:
        long r3 = System.currentTimeMillis();
        float r6 = getScale();
        float r5 = r10 - r6;
        Matrix r0 = new Matrix(this.f17607h);
        r0.postScale(r10, r10, r11, r12);
        RectF r1 = h(r0, true, true);
        float r7 = r11 + (r1.left * r10);
        float r8 = r12 + (r1.top * r10);
        this.f17609j.post(new c(this, r13, r3, r5, r6, r7, r8));
    }

    protected void a(Drawable r5, Matrix r6, float r7, float r8) {
        if (r5 != null) goto L5;
        this.f17606g.reset();
        r5 = null;
    L5:
        super.setImageDrawable(r5);
        if (r7 != (-1.0f)) goto L8;
    L19:
        this.n = -1.0f;
        this.m = -1.0f;
        this.p = false;
        this.o = false;
    L20:
        if (r6 == null) goto L22;
        this.f17608i = new Matrix(r6);
    L22:
        this.x = true;
        requestLayout();
        return;
    L8:
        if (r8 == (-1.0f)) goto L19;
        float r9 = Math.min(r7, r8);
        float r10 = Math.max(r9, r8);
        this.n = r9;
        this.m = r10;
        this.p = true;
        this.o = true;
        d r0 = this.v;
        if (r0 == d.f17632g) goto L14;
        if (r0 != d.f17633h) goto L20;
    L14:
        if (r9 < 1.0f) goto L17;
        this.p = false;
        this.n = -1.0f;
    L17:
        if (r10 > 1.0f) goto L20;
        this.o = true;
        this.m = -1.0f;
        goto L20
    }

    protected void b(boolean r3, boolean r4) {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        RectF r5 = h(this.f17607h, r3, r4);
        float r6 = r5.left;
        if (r6 == 0.0f) goto L8;
    L9:
        v(r6, r5.top);
        return;
    L8:
        if (r5.top != 0.0f) goto L9;
    }

    protected float c() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return Math.max(r0.getIntrinsicWidth() / this.s, r0.getIntrinsicHeight() / this.t) * 8.0f;
    }

    protected float d() {
        if (getDrawable() != null) goto L6;
        return 1.0f;
    L6:
        return Math.min(1.0f, 1.0f / l(this.f17606g));
    }

    protected void e(Drawable r1) {
        e r0 = this.B;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    protected void f(int r7, int r8, int r9, int r10) {
        f r0 = this.C;
        if (r0 == null) goto L6;
        r0.a(true, r7, r8, r9, r10);
        return;
    }

    protected RectF g(Matrix r5) {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L6;
        return null;
    L6:
        Matrix r6 = j(r5);
        this.y.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        r6.mapRect(this.y);
        return this.y;
    }

    public float getBaseScale() {
        return l(this.f17606g);
    }

    public RectF getBitmapRect() {
        return g(this.f17607h);
    }

    protected PointF getCenter() {
        return this.u;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f17607h);
    }

    public d getDisplayType() {
        return this.v;
    }

    public Matrix getImageViewMatrix() {
        return j(this.f17607h);
    }

    public float getMaxScale() {
        if (this.m != (-1.0f)) goto L6;
        this.m = c();
    L6:
        return this.m;
    }

    public float getMinScale() {
        if (this.n != (-1.0f)) goto L6;
        this.n = d();
    L6:
        return this.n;
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public float getRotation() {
        return 0.0f;
    }

    public float getScale() {
        return l(this.f17607h);
    }

    protected RectF h(Matrix r7, boolean r8, boolean r9) {
        if (getDrawable() == null) goto L5;
        this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF r10 = g(r7);
        float r0 = r10.height();
        float r2 = r10.width();
        if (r9 == false) goto L17;
        int r11 = this.t;
        float r4 = r11;
        if (r0 >= r4) goto L11;
        float r5 = ((r4 - r0) / 2.0f) - r10.top;
    L18:
        if (r8 == false) goto L29;
        float r12 = this.s;
        if (r2 >= r12) goto L23;
        r12 = (r12 - r2) / 2.0f;
        float r13 = r10.left;
    L22:
        float r14 = r12 - r13;
    L30:
        this.z.set(r14, r5, 0.0f, 0.0f);
        return this.z;
    L23:
        float r15 = r10.left;
        if (r15 <= 0.0f) goto L26;
        r14 = -r15;
        goto L30
    L26:
        r13 = r10.right;
        if (r13 < r12) goto L22;
    L29:
        r14 = 0.0f;
        goto L30
    L11:
        float r1 = r10.top;
        if (r1 <= 0.0f) goto L14;
        r5 = -r1;
        goto L18
    L14:
        float r3 = r10.bottom;
        if (r3 >= r4) goto L17;
        r5 = r11 - r3;
    L17:
        r5 = 0.0f;
        goto L18
    L5:
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    protected float i(d r3) {
        if (r3 != d.f17632g) goto L6;
        return 1.0f;
    L6:
        if (r3 != d.f17633h) goto L10;
        return Math.min(1.0f, 1.0f / l(this.f17606g));
    L10:
        return 1.0f / l(this.f17606g);
    }

    public Matrix j(Matrix r3) {
        this.q.set(this.f17606g);
        this.q.postConcat(r3);
        return this.q;
    }

    protected void k(Drawable r6, Matrix r7) {
        float r0 = this.s;
        float r5 = this.t;
        float r1 = r6.getIntrinsicWidth();
        float r8 = r6.getIntrinsicHeight();
        r7.reset();
        if (r1 > r0) goto L5;
        int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
    L5:
        float r3 = Math.min(r0 / r1, r5 / r8);
        r7.postScale(r3, r3);
        r7.postTranslate((r0 - (r1 * r3)) / 2.0f, (r5 - (r8 * r3)) / 2.0f);
    }

    protected float l(Matrix r2) {
        return m(r2, 0);
    }

    protected float m(Matrix r2, int r3) {
        r2.getValues(this.r);
        return this.r[r3];
    }

    protected void n(Context r1, AttributeSet r2, int r3) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected void o(Drawable r1) {
        e(r1);
    }

    @Override // android.view.View
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        super.onLayout(r18, r19, r20, r21, r22);
        if (r18 == false) goto L5;
        int r6 = this.s;
        int r7 = this.t;
        int r8 = r21 - r19;
        this.s = r8;
        int r9 = r22 - r20;
        this.t = r9;
        int r10 = r8 - r6;
        int r11 = r9 - r7;
        PointF r12 = this.u;
        r12.x = r8 / 2.0f;
        r12.y = r9 / 2.0f;
    L6:
        Runnable r13 = this.f17610k;
        if (r13 == null) goto L9;
        this.f17610k = null;
        r13.run();
    L9:
        Drawable r14 = getDrawable();
        if (r14 == null) goto L63;
        if (r18 == false) goto L13;
    L16:
        i(this.v);
        float r15 = l(this.f17606g);
        float r16 = getScale();
        float r17 = 1.0f;
        float r110 = Math.min(1.0f, 1.0f / r15);
        k(r14, this.f17606g);
        float r111 = l(this.f17606g);
        if (this.x == false) goto L19;
    L35:
        Matrix r23 = this.f17608i;
        if (r23 == null) goto L38;
        this.f17607h.set(r23);
        this.f17608i = null;
        float r24 = getScale();
    L39:
        r17 = r24;
        setImageMatrix(getImageViewMatrix());
        if (r17 != getScale()) goto L31;
    L42:
        this.f17611l = false;
        if (r17 <= getMaxScale()) goto L45;
    L46:
        C(r17);
    L47:
        b(true, true);
        if (this.x == false) goto L50;
        o(r14);
    L50:
        if (r18 == false) goto L52;
    L55:
        q(r19, r20, r21, r22);
    L57:
        if (this.w == false) goto L60;
        this.w = false;
    L60:
        if (this.x == false) goto L79;
        this.x = false;
        return;
    L79:
        return;
    L52:
        if (this.x == true) goto L55;
        if (this.w == false) goto L57;
    L45:
        if (r17 >= getMinScale()) goto L47;
    L31:
        C(r17);
        goto L42
    L38:
        this.f17607h.reset();
        r24 = i(this.v);
        goto L39
    L19:
        if (this.w == true) goto L35;
        if (r18 == false) goto L42;
        if (this.p == true) goto L26;
        this.n = -1.0f;
    L26:
        if (this.o == true) goto L28;
        this.m = -1.0f;
    L28:
        setImageMatrix(getImageViewMatrix());
        v(-r10, -r11);
        if (this.f17611l == true) goto L33;
        r17 = i(this.v);
        goto L31
    L33:
        if (Math.abs(r16 - r110) <= 0.001d) goto L31;
        r17 = (r15 / r111) * r16;
        goto L31
    L13:
        if (this.w == true) goto L16;
        if (this.x == true) goto L16;
        return;
    L63:
        if (this.x == false) goto L65;
        o(r14);
    L65:
        if (r18 == false) goto L67;
    L70:
        q(r19, r20, r21, r22);
    L72:
        if (this.x == false) goto L75;
        this.x = false;
    L75:
        if (this.w == false) goto L81;
        this.w = false;
        return;
    L81:
        return;
    L67:
        if (this.x == true) goto L70;
        if (this.w == false) goto L72;
    L5:
        r10 = 0;
        r11 = 0;
        goto L6
    }

    protected void p() {
    }

    protected void q(int r1, int r2, int r3, int r4) {
        f(r1, r2, r3, r4);
    }

    protected void r(float r1) {
    }

    protected void s(float r1) {
    }

    public void setDisplayType(d r2) {
        if (r2 == this.v) goto L6;
        this.f17611l = false;
        this.v = r2;
        this.w = true;
        requestLayout();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r3) {
        z(r3, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        A(r3, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix r3) {
        Matrix r0 = getImageMatrix();
        if (r3 == null) goto L5;
    L6:
        if (r3 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        super.setImageMatrix(r3);
        if (r1 == false) goto L15;
        p();
        return;
    L15:
        return;
    L8:
        if (r0.equals(r3) == true) goto L10;
    L9:
        r1 = true;
        goto L11
    L5:
        if (r0.isIdentity() == false) goto L9;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r2) {
        setImageDrawable(getContext().getResources().getDrawable(r2));
    }

    protected void setMaxScale(float r1) {
        this.m = r1;
    }

    protected void setMinScale(float r1) {
        this.n = r1;
    }

    public void setOnDrawableChangedListener(e r1) {
        this.B = r1;
    }

    public void setOnLayoutChangeListener(f r1) {
        this.C = r1;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r2) {
        if (r2 != ImageView.ScaleType.MATRIX) goto L5;
        super.setScaleType(r2);
        return;
    L5:
        Log.w("ImageViewTouchBase", "Unsupported scaletype. Only MATRIX can be used");
    }

    protected void t(double r3, double r5) {
        RectF r0 = getBitmapRect();
        this.A.set((float) r3, (float) r5, 0.0f, 0.0f);
        B(r0, this.A);
        RectF r4 = this.A;
        v(r4.left, r4.top);
        b(true, true);
    }

    protected void u(float r2, float r3, float r4) {
        this.f17607h.postScale(r2, r2, r3, r4);
        setImageMatrix(getImageViewMatrix());
    }

    protected void v(float r3, float r4) {
        if (r3 == 0.0f) goto L5;
    L6:
        this.f17607h.postTranslate(r3, r4);
        setImageMatrix(getImageViewMatrix());
        return;
    L5:
        if (r4 != 0.0f) goto L6;
    }

    public void w() {
        this.f17607h = new Matrix();
        float r0 = i(this.v);
        setImageMatrix(getImageViewMatrix());
        if (r0 == getScale()) goto L5;
        C(r0);
    L5:
        postInvalidate();
    }

    public void x(float r3, float r4) {
        t(r3, r4);
    }

    protected void y(float r11, float r12, double r13) {
        this.f17609j.post(new b(this, r13, System.currentTimeMillis(), r11, r12));
    }

    public void z(Bitmap r2, Matrix r3, float r4, float r5) {
        if (r2 == null) goto L4;
        A(new it.sephiroth.android.library.imagezoom.b.a(r2), r3, r4, r5);
        return;
    L4:
        A(null, r3, r4, r5);
    }
}
