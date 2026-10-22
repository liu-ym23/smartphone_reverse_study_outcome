package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.k;
import d.g.d.b.b.p;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0012¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010!R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006B"}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/f0;", "a", "(Landroid/graphics/Canvas;)V", "b", "", "r", "setRadius", "(F)V", "lt", "rt", "lb", "rb", "c", "(FFFF)V", "", "strokeColor", "strokeWidth", "strokeDash", "strokeGap", "d", "(IIII)V", "dispatchDraw", "draw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "l", "Z", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "(Z)V", "measureHeightUnspecified", "Landroid/graphics/Path;", "k", "Landroid/graphics/Path;", "outPath", "h", "hasStroke", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "strokePaint", "", "i", "[F", "radiusArray", "f", "showStroke", "Landroid/graphics/RectF;", "j", "Landroid/graphics/RectF;", "outRectF", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f10968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f10970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f10971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f10972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10973l;

    public RadiusLayout(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public RadiusLayout(Context r8, AttributeSet r9, int r10) {
        o.f(r8, "context");
        super(r8, r9, r10);
        this.f10967f = true;
        this.f10971j = new RectF();
        this.f10972k = new Path();
        TypedArray r11 = r8.obtainStyledAttributes(r9, k.L0, r10, 0);
        o.e(r11, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r12 = r11.getDimension(k.M0, 0.0f);
        float r13 = r11.getDimension(k.O0, r12);
        float r0 = r11.getDimension(k.Q0, r12);
        float r2 = r11.getDimension(k.N0, r12);
        float r14 = r11.getDimension(k.P0, r12);
        int r3 = r11.getColor(k.R0, ViewCompat.MEASURED_STATE_MASK);
        int r4 = r11.getDimensionPixelOffset(k.U0, 0);
        int r5 = r11.getDimensionPixelOffset(k.T0, 0);
        int r1 = r11.getDimensionPixelOffset(k.S0, 0);
        c(r13, r0, r2, r14);
        d(r3, r4, r5, r1);
        r11.recycle();
    }

    public /* synthetic */ RadiusLayout(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final void a(Canvas r6) {
        this.f10971j.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        this.f10972k.reset();
        p r1 = p.f16819e;
        Path r2 = this.f10972k;
        RectF r3 = this.f10971j;
        float[] r4 = this.f10970i;
        if (r4 == null) goto L10;
        r1.b(r2, r3, r4, Path.Direction.CW);
        r6.clipPath(this.f10972k);
        return;
    L10:
        o.v("radiusArray");
        throw null;
    L12:
        r6.clipRect(this.f10971j);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void b(Canvas r7) {
        Paint r0 = this.f10968g;
        if (r0 == null) goto L16;
        this.f10971j.set(0.0f, 0.0f, getWidth(), getHeight());
        if (Build.VERSION.SDK_INT < 18) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L14;
        this.f10972k.reset();
        p r2 = p.f16819e;
        Path r3 = this.f10972k;
        RectF r4 = this.f10971j;
        float[] r5 = this.f10970i;
        if (r5 == null) goto L12;
        r2.b(r3, r4, r5, Path.Direction.CW);
        r7.drawPath(this.f10972k, r0);
        return;
    L12:
        o.v("radiusArray");
        throw null;
    L14:
        r7.drawRect(this.f10971j, r0);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void c(float r3, float r4, float r5, float r6) {
        this.f10970i = new float[]{r3, r3, r4, r4, r6, r6, r5, r5};
        invalidate();
    }

    public final void d(int r6, int r7, int r8, int r9) {
        Paint r0 = new Paint();
        boolean r1 = true;
        r0.setAntiAlias(true);
        r0.setColor(r6);
        r0.setStyle(Paint.Style.STROKE);
        if (r8 == 0) goto L6;
        if (r9 == 0) goto L6;
        r0.setPathEffect(new DashPathEffect(new float[]{r8, r9}, 0.0f));
    L6:
        r0.setStrokeWidth(r7);
        this.f10968g = r0;
        if ((r6 & ViewCompat.MEASURED_STATE_MASK) == 0) goto L10;
        if (r7 == 0) goto L10;
    L11:
        this.f10969h = r1;
        invalidate();
        return;
    L10:
        r1 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r2) {
        o.f(r2, "canvas");
        super.dispatchDraw(r2);
        if (this.f10969h == true) goto L5;
        return;
    L5:
        if (this.f10967f == false) goto L9;
        b(r2);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        o.f(r2, "canvas");
        a(r2);
        super.draw(r2);
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f10973l;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        if (this.f10973l == false) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L5:
        super.onMeasure(r2, r3);
    }

    public final void setMeasureHeightUnspecified(boolean r1) {
        this.f10973l = r1;
    }

    public final void setRadius(float r3) {
        this.f10970i = new float[]{r3, r3, r3, r3, r3, r3, r3, r3};
        invalidate();
    }
}
