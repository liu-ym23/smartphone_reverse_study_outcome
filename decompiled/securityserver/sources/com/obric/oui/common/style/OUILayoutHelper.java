package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R;
import com.obric.oui.utils.ViewUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class OUILayoutHelper implements IOUILayout {
    public int A;
    public int B;
    public int C;
    public Paint D;
    public float E;
    public Paint F;
    public int G;
    public float[] H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f198J;
    public int K;
    public int L;
    public boolean M;
    public RectF N;
    public int O;
    public int P;
    public int Q;
    public WeakReference R;
    public boolean S;
    public Path T;
    public boolean U;
    public int V;
    public float W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public Context b;
    public int b0;
    public int c;
    public int c0;
    public int d0;
    public int e;
    public AttributeSet e0;
    public int f;
    public int f0;
    public int g0;
    public boolean h0;
    public int i;
    public Shadow i0;
    public int j;
    public Shadow j0;
    public int k;
    public float k0;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static ArrayList j(Context r10, int r11) {
        ArrayList r0 = new ArrayList();
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.u);
        Shadow r13 = new Shadow(Color.parseColor("#00000000"));
        Shadow r9 = new Shadow(Color.parseColor("#00000000"));
        p(r12, r13, 13, 12, 10, 11, 14);
        p(r12, r9, 35, 34, 32, 33, 36);
        r12.recycle();
        r0.add(r13);
        r0.add(r9);
        return r0;
    }

    public static void p(TypedArray r1, Shadow r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.f204a = r1.getColor(r3, Color.parseColor("#00000000"));
        r2.b = r1.getDimension(r4, 0.0f);
        r2.c = r1.getDimension(r5, 0.0f);
        r2.f205d = r1.getDimension(r6, 0.0f);
        r2.e = r1.getDimension(r7, 0.0f);
    }

    public final void A(Shadow r1, Shadow r2) {
        this.i0 = r1;
        this.j0 = r2;
        View r0 = (View) this.R.get();
        if (r0 == null) goto L7;
        r0.invalidate();
        return;
    }

    public final void B(float r2) {
        if (this.W != r2) goto L5;
        return;
    L5:
        this.W = r2;
        View r3 = (View) this.R.get();
        if (r3 == null) goto L14;
        int r1 = this.V;
        if (r1 != 0) goto L11;
        r3.setElevation(0.0f);
    L12:
        r3.invalidateOutline();
        return;
    L11:
        r3.setElevation(r1);
        goto L12
    }

    public final void C(int r2) {
        if (this.X != r2) goto L5;
        return;
    L5:
        this.X = r2;
        View r1 = (View) this.R.get();
        if (r1 == null) goto L10;
        r1.setOutlineAmbientShadowColor(r2);
        r1.setOutlineSpotShadowColor(r2);
        return;
    }

    public final void D(int r2) {
        if (this.V != r2) goto L5;
        return;
    L5:
        this.V = r2;
        View r3 = (View) this.R.get();
        if (r3 == null) goto L14;
        int r1 = this.V;
        if (r1 != 0) goto L11;
        r3.setElevation(0.0f);
    L12:
        r3.invalidateOutline();
        return;
    L11:
        r3.setElevation(r1);
        goto L12
    }

    public final void E(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        b(this.b, r2);
    }

    public final void F(boolean r1) {
        this.U = r1;
        View r0 = (View) this.R.get();
        if (r0 == null) goto L7;
        r0.invalidate();
        return;
    }

    public final void G(int r1) {
        this.n = r1;
        q();
    }

    public final void H(int r1, int r2, int r3) {
        this.p = r1;
        this.q = 0;
        this.r = r3;
        this.o = r2;
        q();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        return false;
    }

    public final void b(Context r9, int r10) {
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.u);
        p(r11, this.i0, 13, 12, 10, 11, 14);
        p(r11, this.j0, 35, 34, 32, 33, 36);
        r11.recycle();
    }

    public final void c(Canvas r13) {
        View r0 = (View) this.R.get();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = m();
        if (this.P > 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        return;
    L14:
        if (this.U == true) goto L16;
    L18:
        int r5 = r13.getWidth();
        int r6 = r13.getHeight();
        r13.save();
        r13.translate(r0.getScrollX(), r0.getScrollY());
        float r7 = this.P / 2.0f;
        if (this.S == false) goto L21;
        this.N.set(r0.getPaddingLeft() + r7, r0.getPaddingTop() + r7, (r5 - r0.getPaddingRight()) - r7, (r6 - r0.getPaddingBottom()) - r7);
    L23:
        if (this.M == true) goto L25;
    L28:
        if (r2 == false) goto L35;
        this.F.setColor(this.O);
        this.F.setStrokeWidth(this.P);
        this.F.setStyle(Paint.Style.STROKE);
        if (this.M == false) goto L32;
        RectF r3 = this.N;
        float[] r4 = this.H;
        Paint r8 = this.F;
        Path r12 = this.T;
        r12.reset();
        r12.addRoundRect(r3, r4, Path.Direction.CW);
        r13.drawPath(r12, r8);
        goto L35
    L32:
        if (r1 > 0) goto L34;
        r13.drawRect(this.N, this.F);
        goto L35
    L34:
        SmoothCornerH.f(r13, this.N, r1 * 1.0f, this.F);
    L35:
        r13.restore();
        return;
    L25:
        if (this.H != null) goto L27;
        this.H = new float[8];
    L27:
        float[] r9 = this.H;
        float r10 = this.I;
        r9[0] = r10;
        r9[1] = r10;
        float r11 = this.f198J;
        r9[2] = r11;
        r9[3] = r11;
        float r14 = this.K;
        r9[4] = r14;
        r9[5] = r14;
        float r15 = this.L;
        r9[6] = r15;
        r9[7] = r15;
        goto L28
    L21:
        this.N.set(r7, r7, r5 - r7, r6 - r7);
        goto L23
    L16:
        if (this.V == 0) goto L18;
        return;
    L8:
        if (this.O == 0) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void d(int r1) {
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r2) {
        if (this.E == r2) goto L9;
        this.E = r2;
        View r1 = (View) this.R.get();
        if (r1 == null) goto L10;
        r1.invalidate();
        return;
    L10:
        return;
    }

    public final void g(Canvas r6) {
        View r0 = (View) this.R.get();
        if (r0 != null) goto L5;
        return;
    L5:
        Shadow r1 = this.i0;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        Shadow r4 = this.j0;
        if (r4 != null) goto L14;
    L16:
        if (r3 == true) goto L20;
        if (r2 == true) goto L20;
    L27:
        if (r0.isHardwareAccelerated() == false) goto L30;
        return;
    L30:
        if (this.M == false) goto L32;
        return;
    L32:
        Drawable r7 = r0.getBackground();
        Context r5 = this.b;
        if (r7 != null) goto L35;
    L37:
        Drawable r8 = r0.getForeground();
        if (r8 != null) goto L40;
        return;
    L40:
        if ((r8 instanceof RoundCornerDrawable) == true) goto L44;
        RoundCornerDrawable r9 = new RoundCornerDrawable(r8, r5.getResources().getDisplayMetrics());
        r9.f = this.G;
        r0.setForeground(r9);
        return;
    L44:
        return;
    L35:
        if ((r7 instanceof RoundCornerDrawable) == true) goto L37;
        RoundCornerDrawable r10 = new RoundCornerDrawable(r7, r5.getResources().getDisplayMetrics());
        r10.f = this.G;
        r0.setBackground(r10);
    L20:
        if (this.G == 0) goto L22;
    L25:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        goto L27
    L22:
        if (this.M == true) goto L25;
        i(r6, this.i0);
        i(r6, this.j0);
        goto L27
    L14:
        if (r4.a() == false) goto L16;
        r2 = true;
        goto L16
    L8:
        if (r1.a() == false) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final int getShadowColor() {
        return this.X;
    }

    public final void h(Canvas r12, int r13, int r14) {
        View r0 = (View) this.R.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.D == null) goto L8;
    L16:
        r12.save();
        r12.translate(r0.getScrollX(), r0.getScrollY());
        int r1 = this.j;
        if (r1 <= 0) goto L22;
        this.D.setStrokeWidth(r1);
        this.D.setColor(ViewUtil.a(this.m, this.E));
        int r2 = this.n;
        if (r2 >= 255) goto L21;
        this.D.setAlpha(r2);
    L21:
        float r7 = this.j / 2.0f;
        r12.drawLine(this.k, r7, r13 - this.l, r7, this.D);
    L22:
        int r3 = this.o;
        if (r3 <= 0) goto L28;
        this.D.setStrokeWidth(r3);
        this.D.setColor(ViewUtil.a(this.r, this.E));
        int r4 = this.s;
        if (r4 >= 255) goto L27;
        this.D.setAlpha(r4);
    L27:
        float r9 = (float) Math.floor(r14 - (this.o / 2.0f));
        r12.drawLine(this.p, r9, r13 - this.q, r9, this.D);
    L28:
        int r5 = this.t;
        if (r5 <= 0) goto L34;
        this.D.setStrokeWidth(r5);
        this.D.setColor(ViewUtil.a(this.w, this.E));
        int r6 = this.x;
        if (r6 >= 255) goto L33;
        this.D.setAlpha(r6);
    L33:
        float r8 = this.t / 2.0f;
        r12.drawLine(r8, this.u, r8, r14 - this.v, this.D);
    L34:
        int r10 = this.y;
        if (r10 <= 0) goto L40;
        this.D.setStrokeWidth(r10);
        this.D.setColor(ViewUtil.a(this.B, this.E));
        int r11 = this.C;
        if (r11 >= 255) goto L39;
        this.D.setAlpha(r11);
    L39:
        float r15 = (float) Math.floor(r13 - (this.y / 2.0f));
        r12.drawLine(r15, this.z, r15, r14 - this.A, this.D);
    L40:
        r12.restore();
        return;
    L8:
        if (this.j <= 0) goto L10;
    L15:
        this.D = new Paint();
        goto L16
    L10:
        if (this.o > 0) goto L15;
        if (this.t > 0) goto L15;
        if (this.y <= 0) goto L16;
        goto L15
    }

    public final void i(Canvas r7, Shadow r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        float r0 = r8.g;
        if (r0 > 0.0f) goto L8;
        r0 = this.k0;
    L8:
        View r2 = (View) this.R.get();
        Path r3 = new Path();
        RectF r5 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        int r4 = this.Y;
        if (r4 == 0) goto L11;
    L12:
        r5.inset(r4, this.Z);
    L13:
        SmoothCornerH.a(r3, r5, r0);
        int r6 = r7.save();
        RectF r9 = new RectF(r5);
        r9.offset(r8.c, r8.f205d);
        float r10 = -r8.e;
        r9.inset(r10, r10);
        r7.clipOutPath(r3);
        int r11 = r8.f204a;
        Paint r12 = r8.f;
        r12.setColor(r11);
        if (r8.b <= 0.0f) goto L16;
        r12.setMaskFilter(new BlurMaskFilter(r8.b, BlurMaskFilter.Blur.NORMAL));
    L16:
        SmoothCornerH.f(r7, r9, r0, r12);
        r7.restoreToCount(r6);
        return;
    L11:
        if (this.Z == 0) goto L13;
        goto L12
    }

    public final int k(int r3) {
        if (this.e > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.e) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.e, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.e, BasicMeasure.EXACTLY);
    }

    public final int l(int r3) {
        if (this.c > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.c) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.c, BasicMeasure.EXACTLY);
    }

    public final int m() {
        View r0 = (View) this.R.get();
        if (r0 == null) goto L5;
        int r2 = this.G;
        if (r2 != (-1)) goto L10;
        return r0.getHeight() / 2;
    L10:
        if (r2 == (-2)) goto L12;
        return r2;
    L12:
        return r0.getWidth() / 2;
    L5:
        return this.G;
    }

    public final int n(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.i;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L8:
        return r3;
    }

    public final int o(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.f;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L8:
        return r3;
    }

    public final void q() {
        View r0 = (View) this.R.get();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final void r(int r1) {
        this.O = r1;
        q();
    }

    public final void s(int r1) {
        this.P = r1;
        q();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void setWidthMin(int r1) {
        this.f = r1;
    }

    public final void t(int r1) {
        this.s = r1;
        q();
    }

    public final void u(int r1) {
        this.x = r1;
        q();
    }

    public final void v(int r1) {
        this.Q = r1;
        q();
    }

    public final void w(boolean r2) {
        View r0 = (View) this.R.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.S = r2;
        r0.invalidateOutline();
    }

    public final void x(int r3) {
        if (this.G == r3) goto L6;
        int r0 = this.V;
        y(this.W, r3, r0);
        return;
    }

    public final void y(float r6, int r7, int r8) {
        int r0 = this.X;
        View r1 = (View) this.R.get();
        if (r1 == null) goto L38;
        this.G = r7;
        if (this.k0 != 0.0f) goto L8;
        this.k0 = r7;
    L8:
        boolean r2 = true;
        if (this.K <= 0) goto L11;
    L18:
        boolean r9 = true;
    L19:
        this.M = r9;
        this.V = r8;
        this.W = r6;
        this.X = r0;
        if (r8 == 0) goto L24;
        if (r9 == true) goto L24;
        r1.setElevation(r8);
    L25:
        int r10 = this.X;
        View r11 = (View) this.R.get();
        if (r11 == null) goto L29;
        r11.setOutlineAmbientShadowColor(r10);
        r11.setOutlineSpotShadowColor(r10);
    L29:
        r1.setOutlineProvider(new AnonymousClass1(this));
        int r5 = this.G;
        if (r5 != (-2)) goto L32;
    L36:
        r1.setClipToOutline(r2);
        r1.invalidate();
        return;
    L32:
        if (r5 == (-1)) goto L36;
        if (r5 > 0) goto L36;
        r2 = false;
    L24:
        r1.setElevation(0.0f);
        goto L25
    L11:
        if (this.f198J > 0) goto L18;
        if (this.I > 0) goto L18;
        if (this.L > 0) goto L18;
        r9 = false;
        goto L19
    }

    public final void z(int r1) {
        this.C = r1;
        q();
    }
}
