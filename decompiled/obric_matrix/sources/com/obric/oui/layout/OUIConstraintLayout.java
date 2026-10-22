package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import d.g.d.b.b.e;
import d.g.d.b.b.f;
import d.g.d.b.b.g;
import d.g.d.b.b.i;
import d.g.d.b.b.j;
import d.g.d.b.b.m;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010v\u001a\u00020u¢\u0006\u0004\bw\u0010xJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b$\u0010\u001aJ\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020\u000bH\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000bH\u0014¢\u0006\u0004\b(\u0010'J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\tH\u0014¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010\u001aJ \u00101\u001a\u00020\u000b2\u000e\u00100\u001a\n /*\u0004\u0018\u00010.0.H\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b4\u0010\u001aJ\u0018\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b6\u0010\u001aJ\u0018\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b8\u0010\u001aJ\u0018\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b:\u0010\u001aJ\u0010\u0010;\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?H\u0096\u0001¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bB\u0010>J\u0010\u0010C\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bC\u0010>J\u0018\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bE\u0010+J\u001a\u0010G\u001a\u00020\u000b2\b\b\u0001\u0010F\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bG\u0010+J\u0018\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bI\u0010+J\u0018\u0010K\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bK\u0010+J\u0018\u0010L\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bL\u0010+J\u0018\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bN\u0010+J\u0018\u0010P\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bP\u0010\u001aJ\u0018\u0010R\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bR\u0010+J\u0018\u0010S\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bS\u0010+J\u0018\u0010U\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020?H\u0096\u0001¢\u0006\u0004\bU\u0010VJ\u0018\u0010X\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bX\u0010+J\u0018\u0010Y\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bY\u0010+J\u0018\u0010[\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b[\u0010+J\u001a\u0010]\u001a\u00020\u000b2\b\b\u0001\u0010\\\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b]\u0010+J\u0018\u0010_\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b_\u0010\u001aJ\u0018\u0010`\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b`\u0010+J\u0010\u0010a\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\ba\u0010<J\u0018\u0010c\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020?H\u0096\u0001¢\u0006\u0004\bc\u0010VJ\u0010\u0010d\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\bd\u0010eJ\u0010\u0010g\u001a\u00020fH\u0096\u0001¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bi\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010s¨\u0006y"}, d2 = {"Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ld/g/d/b/b/e;", "Ld/g/d/b/b/f;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "Lkotlin/f0;", "f", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "", "pressed", "setPressed", "(Z)V", "enabled", "setEnabled", "hovered", "onHoverChanged", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchGenericMotionEvent", "(Landroid/view/MotionEvent;)Z", "dispatchTouchEvent", "setVibrateEnabled", "setSoundEffectEnabled", "onAttachedToWindow", "()V", "onDetachedFromWindow", "visibility", "onWindowVisibilityChanged", "(I)V", "selected", "setSelected", "", "kotlin.jvm.PlatformType", "scene", "b", "(Ljava/lang/String;)V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "a", "()Z", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "alpha", "c", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", TypedValues.Custom.S_COLOR, "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "d", "strength", "e", "getAlphaHelper", "()Ld/g/d/b/b/e;", "Ld/g/d/b/b/i;", "getEffectHelper", "()Ld/g/d/b/b/i;", "getLayoutHelper", "()Ld/g/d/b/b/f;", "Ld/g/d/b/b/j;", "Ld/g/d/b/b/j;", "mLayoutHelper", "Ld/g/d/b/b/g;", "g", "Ld/g/d/b/b/g;", "mAlphaHelper", "h", "Ld/g/d/b/b/i;", "mOUIEffectHelper", "Ld/g/d/b/b/m;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILd/g/d/b/b/m;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OUIConstraintLayout extends ConstraintLayout implements e, f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j f11117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f11118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i f11119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ e f11120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ f f11121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ m f11122k;

    public OUIConstraintLayout(Context r8, AttributeSet r9) {
        this(r8, r9, 0, null, 12, null);
    }

    public OUIConstraintLayout(Context r2, AttributeSet r3, int r4, m r5) {
        o.f(r2, "context");
        o.f(r5, "provider");
        super(r2, r3);
        this.f11120i = r5.a();
        this.f11121j = r5.c();
        this.f11122k = r5;
        r5.d(this);
        f r6 = getLayoutHelper();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.f11117f = (j) r6;
        e r7 = getAlphaHelper();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f11118g = (g) r7;
        this.f11119h = getEffectHelper();
        f(r2, r3, r4);
    }

    public /* synthetic */ OUIConstraintLayout(Context r2, AttributeSet r3, int r4, m r5, int r6, kotlin.n0.d.g r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = new m(r2, r3, r4, 0);
    L11:
        this(r2, r3, r4, r5);
    }

    @Override // d.g.d.b.b.f
    public boolean a() {
        return this.f11121j.a();
    }

    @Override // d.g.d.b.b.e
    public void b(String r1) {
        this.f11120i.b(r1);
    }

    @Override // d.g.d.b.b.f
    public void c(int r1) {
        this.f11121j.c(r1);
    }

    @Override // d.g.d.b.b.f
    public boolean d() {
        return this.f11121j.d();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        o.f(r4, "canvas");
        super.dispatchDraw(r4);
        j r0 = this.f11117f;
        if (r0 == null) goto L5;
        r0.u(r4, getWidth(), getHeight());
    L5:
        j r3 = this.f11117f;
        if (r3 == null) goto L9;
        r3.s(r4);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.b(r2);
    L6:
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        i r0 = this.f11119h;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        g r1 = this.f11118g;
        if (r1 == null) goto L9;
        r1.d(r2);
    L9:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r2) {
        o.f(r2, "canvas");
        j r0 = this.f11117f;
        if (r0 == null) goto L5;
        r0.t(r2);
    L5:
        super.draw(r2);
    }

    @Override // d.g.d.b.b.f
    public void e(float r1) {
        this.f11121j.e(r1);
    }

    public final void f(Context r1, AttributeSet r2, int r3) {
        o.f(r1, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    public e getAlphaHelper() {
        return this.f11122k.a();
    }

    public i getEffectHelper() {
        return this.f11122k.b();
    }

    public f getLayoutHelper() {
        return this.f11122k.c();
    }

    @Override // d.g.d.b.b.f
    public int getRadius() {
        return this.f11121j.getRadius();
    }

    @Override // d.g.d.b.b.f
    public float getShadowAlpha() {
        return this.f11121j.getShadowAlpha();
    }

    @Override // d.g.d.b.b.f
    public int getShadowColor() {
        return this.f11121j.getShadowColor();
    }

    @Override // d.g.d.b.b.f
    public int getShadowElevation() {
        return this.f11121j.getShadowElevation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r1) {
        super.onHoverChanged(r1);
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.o(r1);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        j r0 = this.f11117f;
        if (r0 == null) goto L8;
        o.c(r0);
        int r6 = r0.A(r4);
        j r1 = this.f11117f;
        o.c(r1);
        int r7 = r1.z(r5);
        super.onMeasure(r6, r7);
        j r2 = this.f11117f;
        o.c(r2);
        int r3 = r2.D(r6, getMeasuredWidth());
        j r8 = this.f11117f;
        o.c(r8);
        int r9 = r8.C(r7, getMeasuredHeight());
        if (r6 != r3) goto L7;
        if (r7 != r9) goto L7;
        return;
    L7:
        super.onMeasure(r3, r9);
        return;
    L8:
        super.onMeasure(r4, r5);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.s(r1);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setBorderColor(@ColorInt int r1) {
        this.f11121j.setBorderColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBorderWidth(int r1) {
        this.f11121j.setBorderWidth(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBottomDividerAlpha(int r1) {
        this.f11121j.setBottomDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f11120i.setChangeAlphaWhenDisable(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f11120i.setChangeAlphaWhenPress(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f11120i.setChangeAlphaWhenSelected(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        g r0 = this.f11118g;
        if (r0 == null) goto L6;
        r0.l(this, r2);
        return;
    }

    @Override // d.g.d.b.b.e
    public void setKeepPressAlpha(boolean r1) {
        this.f11120i.setKeepPressAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setLeftDividerAlpha(int r1) {
        this.f11121j.setLeftDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOuterNormalColor(int r1) {
        this.f11121j.setOuterNormalColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOutlineExcludePadding(boolean r1) {
        this.f11121j.setOutlineExcludePadding(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        i r0 = this.f11119h;
        if (r0 == null) goto L5;
        r0.u(r2);
    L5:
        super.setPressed(r2);
        g r1 = this.f11118g;
        if (r1 == null) goto L9;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRadius(int r1) {
        this.f11121j.setRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setRightDividerAlpha(int r1) {
        this.f11121j.setRightDividerAlpha(r1);
    }

    @Override // android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        g r0 = this.f11118g;
        if (r0 == null) goto L6;
        r0.n(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setShadowAlpha(float r1) {
        this.f11121j.setShadowAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowColor(int r1) {
        this.f11121j.setShadowColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowCornerRadius(int r1) {
        this.f11121j.setShadowCornerRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowElevation(int r1) {
        this.f11121j.setShadowElevation(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowStyle(@StyleRes int r1) {
        this.f11121j.setShadowStyle(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.f11121j.setShowBorderOnlyBeforeL(r1);
    }

    public final void setSoundEffectEnabled(boolean r1) {
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.v(r1);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setTopDividerAlpha(int r1) {
        this.f11121j.setTopDividerAlpha(r1);
    }

    public final void setVibrateEnabled(boolean r1) {
        i r0 = this.f11119h;
        if (r0 == null) goto L6;
        r0.w(r1);
        return;
    }
}
