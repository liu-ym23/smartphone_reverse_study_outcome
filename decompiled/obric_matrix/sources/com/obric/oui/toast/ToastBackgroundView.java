package com.obric.oui.toast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.obric.common.oui.c;
import com.obric.common.oui.e;
import d.g.d.b.b.p;
import d.g.d.f.f.b;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.o0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "", "height", "Lkotlin/f0;", "setupBackground", "(I)V", "getCornerRadius", "()I", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "h", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "bgPaint", "", "k", "Z", "drawSelf", "", "g", "F", "borderWidth", "f", "I", "cornerRadius", "j", "borderPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f11605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f11606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f11607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11608k;

    static {
    }

    public ToastBackgroundView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public ToastBackgroundView(Context r3, AttributeSet r4, int r5) {
        o.f(r3, "context");
        super(r3, r4, r5);
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        this.f11603f = a.a(TypedValue.applyDimension(1, 24.0f, r6.getDisplayMetrics()));
        this.f11604g = 1.0f;
        this.f11605h = new RectF();
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.FILL);
        f0 r8 = f0.f18324a;
        this.f11606i = r7;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeWidth(this.f11604g);
        this.f11607j = r9;
        setBackgroundColor(0);
        r7.setColor(getResources().getColor(c.G, null));
        r9.setColor(getResources().getColor(c.n, null));
    }

    public /* synthetic */ ToastBackgroundView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final int getCornerRadius() {
        return this.f11603f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r8) {
        o.f(r8, "canvas");
        if (this.f11608k == false) goto L5;
        float r3 = 2;
        this.f11605h.set(getPaddingLeft() + (this.f11604g / r3), getPaddingTop() + (this.f11604g / r3), (getWidth() - getPaddingRight()) - (this.f11604g / r3), (getHeight() - getPaddingBottom()) - (this.f11604g / r3));
        float r0 = this.f11603f * 1.0f;
        p r1 = p.f16819e;
        r1.h(r8, this.f11605h, r0, this.f11606i);
        r1.h(r8, this.f11605h, r0, this.f11607j);
    L5:
        super.onDraw(r8);
    }

    public final void setupBackground(int r4) {
        if (r4 != (this.f11603f * 2)) goto L5;
        setBackground(ResourcesCompat.getDrawable(getResources(), e.L, null));
        boolean r0 = false;
    L6:
        this.f11608k = r0;
        b.a("ToastBackgroundView", "setupBackground: drawSelf = " + this.f11608k + ", height = " + r4);
        invalidate();
        return;
    L5:
        r0 = true;
        goto L6
    }
}
