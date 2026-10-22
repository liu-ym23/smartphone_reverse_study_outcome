package d.g.d.b.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class j implements f {
    private int A;
    private int B;
    private int C;
    private int D;
    private Paint E;
    private float F;
    private Paint G;
    private PorterDuffXfermode H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float[] f16784J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private RectF P;
    private int Q;
    private int R;
    private int S;
    private WeakReference<View> T;
    private boolean U;
    private Path V;
    private boolean W;
    private int X;
    private float Y;
    private int Z;
    private int a0;
    private int b0;
    private int c0;
    private int d0;
    private int e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f16785f;
    private int f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16786g;
    private AttributeSet g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16787h;
    private int h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16788i;
    private int i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16789j;
    private o j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16790k;
    private o k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f16791l;
    private float l0;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f16792a;

        a(j r1) {
            this.f16792a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View r10, Outline r11) {
            int r0 = r10.getWidth();
            int r1 = r10.getHeight();
            if (r0 == 0) goto L30;
            if (r1 == 0) goto L33;
            float r2 = j.b(this.f16792a);
            float r5 = r2 * 2.0f;
            float r3 = Math.min(r0, r1);
            if (r5 <= r3) goto L9;
            r2 = r3 / 2.0f;
        L9:
            float r8 = r2;
            if (j.f(this.f16792a) == false) goto L13;
            Path r4 = new Path();
            r4.addRoundRect(new RectF(0.0f, 0.0f, r0, r1), new float[]{j.j(this.f16792a), j.j(this.f16792a), j.k(this.f16792a), j.k(this.f16792a), j.l(this.f16792a), j.l(this.f16792a), j.m(this.f16792a), j.m(this.f16792a)}, Path.Direction.CW);
            r11.setConvexPath(r4);
            r10.setClipToOutline(true);
            return;
        L13:
            int r6 = j.n(this.f16792a);
            int r7 = Math.max(r6 + 1, r1 - j.o(this.f16792a));
            int r9 = j.p(this.f16792a);
            int r12 = r0 - j.q(this.f16792a);
            if (j.g(this.f16792a) == false) goto L16;
            r9 = r9 + r10.getPaddingLeft();
            r6 = r6 + r10.getPaddingTop();
            int r13 = Math.max(r9 + 1, r12 - r10.getPaddingRight());
            int r14 = Math.max(r6 + 1, r7 - r10.getPaddingBottom());
            int r15 = r13;
        L17:
            int r16 = r6;
            float r17 = j.h(this.f16792a);
            if (j.i(this.f16792a) != 0) goto L20;
            r17 = 1.0f;
        L20:
            r11.setAlpha(r17);
            if (r8 > 0.0f) goto L24;
            r11.setRect(r9, r16, r15, r14);
            return;
        L24:
            if (p.f16818d == true) goto L27;
        L25:
            r11.setRoundRect(r9, r16, r15, r14, r8);
            return;
        L27:
            if (Build.VERSION.SDK_INT < 30) goto L25;
            r11.setPath(p.f16819e.c(r9, r16, r15, r14, r8));
            return;
        L16:
            r15 = r12;
            r14 = r7;
            goto L17
        L33:
            return;
        }
    }

    public j(Context r16, AttributeSet r17, int r18, int r19) {
        this.f16786g = 0;
        this.f16787h = 0;
        this.f16788i = 0;
        this.f16789j = 0;
        this.f16790k = 0;
        this.f16791l = 0;
        this.m = 0;
        this.o = 255;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = 255;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.y = 255;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 255;
        this.F = 1.0f;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.Q = 0;
        this.R = 1;
        this.S = 0;
        this.U = false;
        this.V = new Path();
        this.W = true;
        this.X = 0;
        this.Z = ViewCompat.MEASURED_STATE_MASK;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.j0 = new o(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.k0 = new o(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.l0 = 0.0f;
        this.f16785f = r16;
        this.g0 = r17;
        this.h0 = r18;
        this.i0 = r19;
    }

    private int B() {
        View r0 = this.T.get();
        int r2 = this.I;
        if (r0 != null) goto L6;
        return r2;
    L6:
        if (r2 != (-1)) goto L10;
        int r3 = r0.getHeight();
    L12:
        return r3 / 2;
    L10:
        if (r2 != (-2)) goto L13;
        r3 = r0.getWidth();
        goto L12
    L13:
        return r2;
    }

    private static void E(TypedArray r1, o r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.h(r1.getColor(r3, Color.parseColor("#00000000")));
        r2.k(r1.getDimension(r4, 0.0f));
        r2.i(r1.getDimension(r5, 0.0f));
        r2.j(r1.getDimension(r6, 0.0f));
        r2.l(r1.getDimension(r7, 0.0f));
    }

    private void G() {
        View r0 = this.T.get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invalidate();
    }

    private void H() {
        if (O() == false) goto L13;
        View r0 = this.T.get();
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = this.X;
        if (r1 != 0) goto L10;
        float r2 = 0.0f;
    L11:
        r0.setElevation(r2);
        r0.invalidateOutline();
        return;
    L10:
        r2 = r1;
        goto L11
    }

    private void N(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        View r2 = this.T.get();
        if (r2 != null) goto L7;
        return;
    L7:
        r2.setOutlineAmbientShadowColor(r3);
        r2.setOutlineSpotShadowColor(r3);
        return;
    }

    public static boolean O() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ int b(j r0) {
        return r0.B();
    }

    static /* synthetic */ boolean f(j r0) {
        return r0.O;
    }

    static /* synthetic */ boolean g(j r0) {
        return r0.U;
    }

    static /* synthetic */ float h(j r0) {
        return r0.Y;
    }

    static /* synthetic */ int i(j r0) {
        return r0.X;
    }

    static /* synthetic */ int j(j r0) {
        return r0.K;
    }

    static /* synthetic */ int k(j r0) {
        return r0.L;
    }

    static /* synthetic */ int l(j r0) {
        return r0.N;
    }

    static /* synthetic */ int m(j r0) {
        return r0.M;
    }

    static /* synthetic */ int n(j r0) {
        return r0.e0;
    }

    static /* synthetic */ int o(j r0) {
        return r0.f0;
    }

    static /* synthetic */ int p(j r0) {
        return r0.c0;
    }

    static /* synthetic */ int q(j r0) {
        return r0.d0;
    }

    private void r(Context r9, int r10) {
        TypedArray r11 = r9.obtainStyledAttributes(r10, com.obric.common.oui.k.b1);
        E(r11, this.j0, com.obric.common.oui.k.p1, com.obric.common.oui.k.o1, com.obric.common.oui.k.m1, com.obric.common.oui.k.n1, com.obric.common.oui.k.q1);
        E(r11, this.k0, com.obric.common.oui.k.L1, com.obric.common.oui.k.K1, com.obric.common.oui.k.I1, com.obric.common.oui.k.J1, com.obric.common.oui.k.M1);
        r11.recycle();
    }

    private void v(Canvas r2, RectF r3, int r4, Paint r5) {
        p.f16819e.h(r2, r3, r4 * 1.0f, r5);
    }

    private void w(Canvas r3, RectF r4, float[] r5, Paint r6) {
        this.V.reset();
        this.V.addRoundRect(r4, r5, Path.Direction.CW);
        r3.drawPath(this.V, r6);
    }

    @RequiresApi(26)
    private void x(Canvas r5) {
        o r0 = this.j0;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        o r3 = this.k0;
        if (r3 != null) goto L11;
    L13:
        r1 = false;
    L14:
        if (r2 == true) goto L18;
        if (r1 == true) goto L18;
        return;
    L18:
        if (this.I == 0) goto L20;
    L24:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        return;
    L20:
        if (this.O == true) goto L24;
        y(r5, this.j0);
        y(r5, this.k0);
        return;
    L11:
        if (r3.m() == false) goto L13;
    L5:
        if (r0.m() == false) goto L7;
        r2 = true;
        goto L8
    }

    @RequiresApi(26)
    private void y(Canvas r8, o r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.b() <= 0.0f) goto L7;
        float r0 = r9.b();
    L8:
        View r2 = this.T.get();
        Path r3 = new Path();
        RectF r5 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        int r4 = this.a0;
        if (r4 == 0) goto L11;
    L12:
        r5.inset(r4, this.b0);
    L13:
        p r7 = p.f16819e;
        r7.a(r3, r5, r0);
        int r6 = r8.save();
        RectF r10 = new RectF(r5);
        r10.offset(r9.c(), r9.d());
        r10.inset(-r9.g(), -r9.g());
        r8.clipOutPath(r3);
        r9.e().setColor(r9.a());
        if (r9.f() <= 0.0f) goto L16;
        r9.e().setMaskFilter(new BlurMaskFilter(r9.f(), BlurMaskFilter.Blur.NORMAL));
    L16:
        r7.h(r8, r10, r0, r9.e());
        r8.restoreToCount(r6);
        return;
    L11:
        if (this.b0 == 0) goto L13;
    L7:
        r0 = this.l0;
        goto L8
    }

    public int A(int r3) {
        if (this.f16786g > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) <= this.f16786g) goto L12;
        int r4 = View.MeasureSpec.getMode(r3);
        int r2 = this.f16786g;
        if (r4 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L12:
        return r3;
    }

    public int C(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.f16789j;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L8:
        return r3;
    }

    public int D(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.f16788i;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L8:
        return r3;
    }

    public void F(View r15) {
        this.T = new WeakReference(r15);
        Context r16 = this.f16785f;
        int r0 = com.obric.common.oui.c.f8201J;
        int r17 = ContextCompat.getColor(r16, r0);
        this.n = r17;
        this.s = r17;
        int r18 = ContextCompat.getColor(this.f16785f, r0);
        this.C = r18;
        this.x = r18;
        this.H = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r19 = new Paint();
        this.G = r19;
        r19.setAntiAlias(true);
        float r110 = k.b(this.f16785f, com.obric.common.oui.b.f8197f);
        if (r110 <= 0.0f) goto L5;
        this.Y = r110;
    L5:
        this.P = new RectF();
        AttributeSet r111 = this.g0;
        int r1 = 0;
        if (r111 == null) goto L8;
    L13:
        TypedArray r112 = this.f16785f.obtainStyledAttributes(r111, com.obric.common.oui.k.b1, this.h0, this.i0);
        int r2 = r112.getIndexCount();
        int r3 = 0;
        int r4 = 0;
        boolean r5 = false;
        int r13 = 0;
    L14:
        if (r3 >= r2) goto L130;
        int r6 = r112.getIndex(r3);
        if (r6 != com.obric.common.oui.k.c1) goto L19;
        this.f16786g = r112.getDimensionPixelSize(r6, this.f16786g);
    L121:
        if (r6 != com.obric.common.oui.k.k1) goto L124;
        this.M = r112.getDimensionPixelSize(r6, 0);
    L124:
        if (r6 != com.obric.common.oui.k.l1) goto L127;
        this.N = r112.getDimensionPixelSize(r6, 0);
    L127:
        if (r6 != com.obric.common.oui.k.Y1) goto L129;
        this.L = r112.getDimensionPixelSize(r6, 0);
    L129:
        r3 = r3 + 1;
        goto L14
    L19:
        if (r6 != com.obric.common.oui.k.d1) goto L22;
        this.f16787h = r112.getDimensionPixelSize(r6, this.f16787h);
        goto L121
    L22:
        if (r6 != com.obric.common.oui.k.e1) goto L25;
        this.f16788i = r112.getDimensionPixelSize(r6, this.f16788i);
        goto L121
    L25:
        if (r6 != com.obric.common.oui.k.f1) goto L28;
        this.f16789j = r112.getDimensionPixelSize(r6, this.f16789j);
        goto L121
    L28:
        if (r6 != com.obric.common.oui.k.T1) goto L31;
        this.n = r112.getColor(r6, this.n);
        goto L121
    L31:
        if (r6 != com.obric.common.oui.k.U1) goto L34;
        this.f16790k = r112.getDimensionPixelSize(r6, this.f16790k);
        goto L121
    L34:
        if (r6 != com.obric.common.oui.k.V1) goto L37;
        this.f16791l = r112.getDimensionPixelSize(r6, this.f16791l);
        goto L121
    L37:
        if (r6 != com.obric.common.oui.k.W1) goto L40;
        this.m = r112.getDimensionPixelSize(r6, this.m);
        goto L121
    L40:
        if (r6 != com.obric.common.oui.k.g1) goto L43;
        this.s = r112.getColor(r6, this.s);
        goto L121
    L43:
        if (r6 != com.obric.common.oui.k.h1) goto L46;
        this.p = r112.getDimensionPixelSize(r6, this.p);
        goto L121
    L46:
        if (r6 != com.obric.common.oui.k.i1) goto L49;
        this.q = r112.getDimensionPixelSize(r6, this.q);
        goto L121
    L49:
        if (r6 != com.obric.common.oui.k.j1) goto L52;
        this.r = r112.getDimensionPixelSize(r6, this.r);
        goto L121
    L52:
        if (r6 != com.obric.common.oui.k.t1) goto L55;
        this.x = r112.getColor(r6, this.x);
        goto L121
    L55:
        if (r6 != com.obric.common.oui.k.w1) goto L58;
        this.u = r112.getDimensionPixelSize(r6, this.u);
        goto L121
    L58:
        if (r6 != com.obric.common.oui.k.v1) goto L61;
        this.v = r112.getDimensionPixelSize(r6, this.v);
        goto L121
    L61:
        if (r6 != com.obric.common.oui.k.u1) goto L64;
        this.w = r112.getDimensionPixelSize(r6, this.w);
        goto L121
    L64:
        if (r6 != com.obric.common.oui.k.E1) goto L67;
        this.C = r112.getColor(r6, this.C);
        goto L121
    L67:
        if (r6 != com.obric.common.oui.k.H1) goto L70;
        this.z = r112.getDimensionPixelSize(r6, this.z);
        goto L121
    L70:
        if (r6 != com.obric.common.oui.k.G1) goto L73;
        this.A = r112.getDimensionPixelSize(r6, this.A);
        goto L121
    L73:
        if (r6 != com.obric.common.oui.k.F1) goto L76;
        this.B = r112.getDimensionPixelSize(r6, this.B);
        goto L121
    L76:
        if (r6 != com.obric.common.oui.k.r1) goto L79;
        this.Q = r112.getColor(r6, this.Q);
        goto L121
    L79:
        if (r6 != com.obric.common.oui.k.s1) goto L82;
        this.R = r112.getDimensionPixelSize(r6, this.R);
        goto L121
    L82:
        if (r6 != com.obric.common.oui.k.D1) goto L85;
        r13 = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L85:
        if (r6 != com.obric.common.oui.k.x1) goto L88;
        this.S = r112.getColor(r6, this.S);
        goto L121
    L88:
        if (r6 != com.obric.common.oui.k.R1) goto L91;
        this.W = r112.getBoolean(r6, this.W);
        goto L121
    L91:
        if (r6 != com.obric.common.oui.k.P1) goto L94;
        r4 = r112.getDimensionPixelSize(r6, r4);
        goto L121
    L94:
        if (r6 != com.obric.common.oui.k.N1) goto L97;
        this.Y = r112.getFloat(r6, this.Y);
        goto L121
    L97:
        if (r6 != com.obric.common.oui.k.Z1) goto L100;
        r5 = r112.getBoolean(r6, false);
        goto L121
    L100:
        if (r6 != com.obric.common.oui.k.A1) goto L103;
        this.c0 = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L103:
        if (r6 != com.obric.common.oui.k.B1) goto L106;
        this.d0 = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L106:
        if (r6 != com.obric.common.oui.k.C1) goto L109;
        this.e0 = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L109:
        if (r6 != com.obric.common.oui.k.z1) goto L112;
        this.f0 = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L112:
        if (r6 != com.obric.common.oui.k.y1) goto L115;
        this.U = r112.getBoolean(r6, false);
        goto L121
    L115:
        if (r6 != com.obric.common.oui.k.S1) goto L118;
        r112.getBoolean(r6, false);
        goto L121
    L118:
        if (r6 != com.obric.common.oui.k.X1) goto L121;
        this.K = r112.getDimensionPixelSize(r6, 0);
        goto L121
    L130:
        int r7 = r112.getResourceId(com.obric.common.oui.k.Q1, 0);
        if (r7 == 0) goto L133;
        r(this.f16785f, r7);
    L134:
        this.l0 = r112.getDimension(com.obric.common.oui.k.O1, 0.0f);
        r112.recycle();
        r1 = r4;
    L135:
        if (r1 != 0) goto L138;
        if (r5 == false) goto L138;
        r1 = k.a(this.f16785f, com.obric.common.oui.b.f8198g);
    L138:
        L(r13, r1, this.Y);
        return;
    L133:
        E(r112, this.j0, com.obric.common.oui.k.p1, com.obric.common.oui.k.o1, com.obric.common.oui.k.m1, com.obric.common.oui.k.n1, com.obric.common.oui.k.q1);
        E(r112, this.k0, com.obric.common.oui.k.L1, com.obric.common.oui.k.K1, com.obric.common.oui.k.I1, com.obric.common.oui.k.J1, com.obric.common.oui.k.M1);
        goto L134
    L8:
        if (this.h0 != 0) goto L13;
        if (this.i0 != 0) goto L13;
        r5 = false;
        r13 = 0;
        goto L135
    }

    public boolean I() {
        if (this.M <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.L > 0) goto L12;
        if (this.K > 0) goto L12;
        if (this.N > 0) goto L12;
        return false;
    }

    public void J() {
        View r0 = this.T.get();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public boolean K(int r1) {
        this.f16789j = r1;
        return true;
    }

    public void L(int r2, int r3, float r4) {
        M(r2, r3, this.Z, r4);
    }

    public void M(int r4, int r5, int r6, float r7) {
        View r0 = this.T.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.I = r4;
        if (this.l0 != 0.0f) goto L8;
        this.l0 = r4;
    L8:
        this.O = I();
        this.X = r5;
        this.Y = r7;
        this.Z = r6;
        if (O() == false) goto L26;
        int r8 = this.X;
        if (r8 != 0) goto L13;
    L16:
        r0.setElevation(0.0f);
    L17:
        N(this.Z);
        r0.setOutlineProvider(new a(this));
        int r3 = this.I;
        if (r3 != (-2)) goto L20;
    L24:
        boolean r9 = true;
    L25:
        r0.setClipToOutline(r9);
        goto L26
    L20:
        if (r3 == (-1)) goto L24;
        if (r3 > 0) goto L24;
        r9 = false;
        goto L25
    L13:
        if (this.O == true) goto L16;
        r0.setElevation(r8);
    L26:
        r0.invalidate();
    }

    @Override // d.g.d.b.b.f
    public boolean a() {
        return false;
    }

    @Override // d.g.d.b.b.f
    public void c(int r1) {
    }

    @Override // d.g.d.b.b.f
    public boolean d() {
        return false;
    }

    @Override // d.g.d.b.b.f
    public void e(float r2) {
        if (this.F == r2) goto L6;
        this.F = r2;
        G();
        return;
    }

    @Override // d.g.d.b.b.f
    public int getRadius() {
        return this.I;
    }

    @Override // d.g.d.b.b.f
    public float getShadowAlpha() {
        return this.Y;
    }

    @Override // d.g.d.b.b.f
    public int getShadowColor() {
        return this.Z;
    }

    @Override // d.g.d.b.b.f
    public int getShadowElevation() {
        return this.X;
    }

    public void s(Canvas r16) {
        View r1 = this.T.get();
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = B();
        if (r9 > 0) goto L8;
    L12:
        boolean r4 = false;
    L14:
        if (this.R > 0) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r4 == true) goto L23;
        if (r10 == true) goto L23;
        return;
    L23:
        if (this.W == true) goto L25;
    L29:
        int r5 = r16.getWidth();
        int r6 = r16.getHeight();
        r16.save();
        r16.translate(r1.getScrollX(), r1.getScrollY());
        float r7 = this.R / 2.0f;
        if (this.U == false) goto L32;
        this.P.set(r1.getPaddingLeft() + r7, r1.getPaddingTop() + r7, (r5 - r1.getPaddingRight()) - r7, (r6 - r1.getPaddingBottom()) - r7);
    L34:
        if (this.O == true) goto L36;
    L39:
        if (r4 == false) goto L45;
        int r2 = r16.saveLayer(0.0f, 0.0f, r5, r6, null, 31);
        r16.drawColor(this.S);
        this.G.setColor(this.S);
        this.G.setStyle(Paint.Style.FILL);
        this.G.setXfermode(this.H);
        if (this.O == true) goto L43;
        v(r16, this.P, r9, this.G);
    L44:
        this.G.setXfermode(null);
        r16.restoreToCount(r2);
        goto L45
    L43:
        w(r16, this.P, this.f16784J, this.G);
    L45:
        if (r10 == false) goto L53;
        this.G.setColor(this.Q);
        this.G.setStrokeWidth(this.R);
        this.G.setStyle(Paint.Style.STROKE);
        if (this.O == false) goto L49;
        w(r16, this.P, this.f16784J, this.G);
        goto L53
    L49:
        RectF r3 = this.P;
        if (r9 > 0) goto L52;
        r16.drawRect(r3, this.G);
        goto L53
    L52:
        v(r16, r3, r9, this.G);
    L53:
        r16.restore();
        return;
    L36:
        if (this.f16784J != null) goto L38;
        this.f16784J = new float[8];
    L38:
        float[] r8 = this.f16784J;
        int r11 = this.K;
        r8[0] = r11;
        r8[1] = r11;
        int r12 = this.L;
        r8[2] = r12;
        r8[3] = r12;
        int r13 = this.M;
        r8[4] = r13;
        r8[5] = r13;
        int r14 = this.N;
        r8[6] = r14;
        r8[7] = r14;
        goto L39
    L32:
        this.P.set(r7, r7, r5 - r7, r6 - r7);
        goto L34
    L25:
        if (O() == false) goto L29;
        if (this.X == 0) goto L29;
        return;
    L16:
        if (this.Q == 0) goto L18;
        r10 = true;
        goto L19
    L8:
        if (O() == true) goto L12;
        if (this.S == 0) goto L12;
        r4 = true;
        goto L14
    }

    @Override // d.g.d.b.b.f
    public void setBorderColor(@ColorInt int r1) {
        this.Q = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setBorderWidth(int r1) {
        this.R = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setBottomDividerAlpha(int r1) {
        this.t = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setLeftDividerAlpha(int r1) {
        this.y = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setOuterNormalColor(int r1) {
        this.S = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setOutlineExcludePadding(boolean r2) {
        if (O() == false) goto L9;
        View r0 = this.T.get();
        if (r0 != null) goto L7;
        return;
    L7:
        this.U = r2;
        r0.invalidateOutline();
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRadius(int r3) {
        if (this.I == r3) goto L6;
        L(r3, this.X, this.Y);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRightDividerAlpha(int r1) {
        this.D = r1;
        J();
    }

    @Override // d.g.d.b.b.f
    public void setShadowAlpha(float r2) {
        if (this.Y != r2) goto L5;
        return;
    L5:
        this.Y = r2;
        H();
    }

    @Override // d.g.d.b.b.f
    public void setShadowColor(int r2) {
        if (this.Z != r2) goto L5;
        return;
    L5:
        this.Z = r2;
        N(r2);
    }

    @Override // d.g.d.b.b.f
    public void setShadowCornerRadius(int r1) {
        this.l0 = r1;
    }

    @Override // d.g.d.b.b.f
    public void setShadowElevation(int r2) {
        if (this.X != r2) goto L5;
        return;
    L5:
        this.X = r2;
        H();
    }

    @Override // d.g.d.b.b.f
    public void setShadowStyle(@StyleRes int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        r(this.f16785f, r2);
    }

    @Override // d.g.d.b.b.f
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.W = r1;
        G();
    }

    @Override // d.g.d.b.b.f
    public void setTopDividerAlpha(int r1) {
        this.o = r1;
        J();
    }

    @RequiresApi(api = 26)
    public void t(Canvas r4) {
        View r0 = this.T.get();
        if (r0 != null) goto L5;
        return;
    L5:
        x(r4);
        if (r0.isHardwareAccelerated() == false) goto L9;
        return;
    L9:
        if (this.O == false) goto L11;
        return;
    L11:
        Drawable r5 = r0.getBackground();
        if (r5 != null) goto L14;
    L16:
        Drawable r6 = r0.getForeground();
        if (r6 != null) goto L19;
        return;
    L19:
        if ((r6 instanceof n) == true) goto L23;
        n r1 = new n(r6, this.f16785f.getResources().getDisplayMetrics());
        r1.a(this.I);
        r0.setForeground(r1);
        return;
    L23:
        return;
    L14:
        if ((r5 instanceof n) == true) goto L16;
        n r2 = new n(r5, this.f16785f.getResources().getDisplayMetrics());
        r2.a(this.I);
        r0.setBackground(r2);
        goto L16
    }

    public void u(Canvas r12, int r13, int r14) {
        View r0 = this.T.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.E == null) goto L8;
    L16:
        r12.save();
        r12.translate(r0.getScrollX(), r0.getScrollY());
        int r1 = this.f16790k;
        if (r1 <= 0) goto L22;
        this.E.setStrokeWidth(r1);
        this.E.setColor(d.g.d.f.e.a(this.n, this.F));
        int r2 = this.o;
        if (r2 >= 255) goto L21;
        this.E.setAlpha(r2);
    L21:
        float r7 = this.f16790k / 2.0f;
        r12.drawLine(this.f16791l, r7, r13 - this.m, r7, this.E);
    L22:
        int r3 = this.p;
        if (r3 <= 0) goto L28;
        this.E.setStrokeWidth(r3);
        this.E.setColor(d.g.d.f.e.a(this.s, this.F));
        int r4 = this.t;
        if (r4 >= 255) goto L27;
        this.E.setAlpha(r4);
    L27:
        float r9 = (float) Math.floor(r14 - (this.p / 2.0f));
        r12.drawLine(this.q, r9, r13 - this.r, r9, this.E);
    L28:
        int r5 = this.u;
        if (r5 <= 0) goto L34;
        this.E.setStrokeWidth(r5);
        this.E.setColor(d.g.d.f.e.a(this.x, this.F));
        int r6 = this.y;
        if (r6 >= 255) goto L33;
        this.E.setAlpha(r6);
    L33:
        float r8 = this.u / 2.0f;
        r12.drawLine(r8, this.v, r8, r14 - this.w, this.E);
    L34:
        int r10 = this.z;
        if (r10 <= 0) goto L40;
        this.E.setStrokeWidth(r10);
        this.E.setColor(d.g.d.f.e.a(this.C, this.F));
        int r11 = this.D;
        if (r11 >= 255) goto L39;
        this.E.setAlpha(r11);
    L39:
        float r15 = (float) Math.floor(r13 - (this.z / 2.0f));
        r12.drawLine(r15, this.A, r15, r14 - this.B, this.E);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f16790k <= 0) goto L10;
    L15:
        this.E = new Paint();
        goto L16
    L10:
        if (this.p > 0) goto L15;
        if (this.u > 0) goto L15;
        if (this.z <= 0) goto L16;
        goto L15
    }

    public int z(int r3) {
        if (this.f16787h > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) <= this.f16787h) goto L12;
        int r4 = View.MeasureSpec.getMode(r3);
        int r2 = this.f16787h;
        if (r4 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L12:
        return r3;
    }
}
