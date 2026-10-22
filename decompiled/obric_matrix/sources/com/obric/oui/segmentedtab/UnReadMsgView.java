package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.k;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010A\u001a\u00020\t¢\u0006\u0004\bB\u0010CJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014¢\u0006\u0004\b!\u0010\"J7\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\fJ\u0015\u0010,\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b,\u0010\fJ\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000f¢\u0006\u0004\b1\u0010/J\r\u00102\u001a\u00020\t¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\t¢\u0006\u0004\b4\u00103J\r\u00105\u001a\u00020\t¢\u0006\u0004\b5\u00103J\r\u00106\u001a\u00020\t¢\u0006\u0004\b6\u00103R\u0016\u00108\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u00107R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010:R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010:R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010<¨\u0006D"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/f0;", "d", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "cornerRadius", "setCornerRadius", "(I)V", "strokeWidth", "setStrokeWidth", "", "b", "()Z", "c", "", "dp", "a", "(F)I", "Landroid/graphics/drawable/GradientDrawable;", "gd", TypedValues.Custom.S_COLOR, "strokeColor", "f", "(Landroid/graphics/drawable/GradientDrawable;II)V", "e", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "backgroundColor", "setBackgroundColor", "setStrokeColor", "isRadiusHalfHeight", "setIsRadiusHalfHeight", "(Z)V", "isWidthHeightEqual", "setIsWidthHeightEqual", "getBackgroundColor", "()I", "getCornerRadius", "getStrokeWidth", "getStrokeColor", "Landroid/graphics/drawable/GradientDrawable;", "gdBackground", "h", "I", "k", "Z", "j", "g", "i", "l", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class UnReadMsgView extends AppCompatTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GradientDrawable f11353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11359l;

    public UnReadMsgView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public UnReadMsgView(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        this.f11353f = new GradientDrawable();
        d(r2, r3);
    }

    public /* synthetic */ UnReadMsgView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final int a(float r2) {
        Context r1 = getContext();
        o.e(r1, "context");
        Resources r3 = r1.getResources();
        o.e(r3, "context.resources");
        return (int) ((r2 * r3.getDisplayMetrics().density) + 0.5f);
    }

    private final boolean b() {
        return this.f11358k;
    }

    private final boolean c() {
        return this.f11359l;
    }

    private final void d(Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, k.f8288a);
        o.e(r4, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.f11354g = r4.getColor(k.f8289b, 0);
        this.f11355h = r4.getDimensionPixelSize(k.f8290c, 0);
        this.f11356i = r4.getDimensionPixelSize(k.f8294g, 0);
        this.f11357j = r4.getColor(k.f8293f, 0);
        this.f11358k = r4.getBoolean(k.f8291d, false);
        this.f11359l = r4.getBoolean(k.f8292e, false);
        r4.recycle();
    }

    private final void e() {
        StateListDrawable r0 = new StateListDrawable();
        f(this.f11353f, this.f11354g, this.f11357j);
        r0.addState(new int[]{-16842919}, this.f11353f);
        setBackground(r0);
    }

    private final void f(GradientDrawable r1, int r2, int r3) {
        r1.setColor(r2);
        r1.setCornerRadius(this.f11355h);
        r1.setStroke(this.f11356i, r3);
    }

    private final void setCornerRadius(int r1) {
        this.f11355h = a(r1);
        e();
    }

    private final void setStrokeWidth(int r1) {
        this.f11356i = a(r1);
        e();
    }

    public final int getBackgroundColor() {
        return this.f11354g;
    }

    public final int getCornerRadius() {
        return this.f11355h;
    }

    public final int getStrokeColor() {
        return this.f11357j;
    }

    public final int getStrokeWidth() {
        return this.f11356i;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (b() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r2, int r3) {
        if (c() == true) goto L5;
    L10:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r4 = View.MeasureSpec.makeMeasureSpec(e.c(getWidth(), getHeight()), BasicMeasure.EXACTLY);
        super.onMeasure(r4, r4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.f11354g = r1;
        e();
    }

    public final void setIsRadiusHalfHeight(boolean r1) {
        this.f11358k = r1;
        e();
    }

    public final void setIsWidthHeightEqual(boolean r1) {
        this.f11359l = r1;
        e();
    }

    public final void setStrokeColor(int r1) {
        this.f11357j = r1;
        e();
    }
}
