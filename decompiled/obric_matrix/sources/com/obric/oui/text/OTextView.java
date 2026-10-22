package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.common.oui.c;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010o\u001a\u00020n\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p\u0012\b\b\u0002\u0010r\u001a\u00020\u0011\u0012\b\b\u0002\u0010t\u001a\u00020s¢\u0006\u0004\bu\u0010vJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010 \u001a\u00020\u00052\u000e\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b#\u0010\u000bJ\u0018\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b%\u0010\u000bJ\u0018\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b'\u0010\u000bJ\u0018\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b)\u0010\u000bJ\u0010\u0010*\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.H\u0096\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b1\u0010-J\u0010\u00102\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b2\u0010-J\u0018\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u00052\b\b\u0001\u00106\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b7\u00105J\u0018\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b9\u00105J\u0018\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b;\u00105J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b<\u00105J\u0018\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b>\u00105J\u0018\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b@\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bB\u00105J\u0018\u0010C\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bC\u00105J\u0018\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020.H\u0096\u0001¢\u0006\u0004\bE\u0010FJ\u0018\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bH\u00105J\u0018\u0010I\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bI\u00105J\u0018\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bK\u00105J\u001a\u0010M\u001a\u00020\u00052\b\b\u0001\u0010L\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bM\u00105J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\bO\u0010\u000bJ\u0018\u0010P\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bP\u00105J\u0010\u0010Q\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\bQ\u0010+J\u0018\u0010S\u001a\u00020\u00052\u0006\u0010R\u001a\u00020.H\u0096\u0001¢\u0006\u0004\bS\u0010FJ\u0010\u0010T\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\bT\u0010UJ\u0010\u0010W\u001a\u00020VH\u0096\u0001¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bY\u0010ZR*\u0010`\u001a\u00020\b2\u0006\u0010[\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010+\"\u0004\b_\u0010\u000bR\u0018\u0010c\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006w"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Ld/g/d/b/b/e;", "Ld/g/d/b/b/f;", "", "Lkotlin/f0;", "f", "()V", "", "pressed", "setPressed", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "", "kotlin.jvm.PlatformType", "scene", "b", "(Ljava/lang/String;)V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "a", "()Z", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "alpha", "c", "(I)V", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", TypedValues.Custom.S_COLOR, "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "d", "strength", "e", "getAlphaHelper", "()Ld/g/d/b/b/e;", "Ld/g/d/b/b/i;", "getEffectHelper", "()Ld/g/d/b/b/i;", "getLayoutHelper", "()Ld/g/d/b/b/f;", "value", "j", "Z", "getEnableAutoAlignLeft", "setEnableAutoAlignLeft", "enableAutoAlignLeft", "h", "Ld/g/d/b/b/i;", "mOUIEffectHelper", "i", "I", "originalGravity", "Ld/g/d/b/b/j;", "Ld/g/d/b/b/j;", "mLayoutHelper", "Ld/g/d/b/b/g;", "g", "Ld/g/d/b/b/g;", "mAlphaHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "Ld/g/d/b/b/m;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILd/g/d/b/b/m;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements e, f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j f11514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f11515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i f11516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ e f11519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final /* synthetic */ f f11520l;
    private final /* synthetic */ m m;

    public OTextView(Context r8, AttributeSet r9) {
        this(r8, r9, 0, null, 12, null);
    }

    public OTextView(Context r2, AttributeSet r3, int r4, m r5) {
        o.f(r2, "context");
        o.f(r5, "provider");
        super(r2, r3, r4);
        this.f11519k = r5.a();
        this.f11520l = r5.c();
        this.m = r5;
        this.f11517i = getGravity();
        r5.d(this);
        f r6 = getLayoutHelper();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.f11514f = (j) r6;
        e r7 = getAlphaHelper();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f11515g = (g) r7;
        this.f11516h = getEffectHelper();
        g r8 = this.f11515g;
        if (r8 == null) goto L5;
        r8.setChangeAlphaWhenPress(false);
    L5:
        g r9 = this.f11515g;
        if (r9 == null) goto L8;
        r9.setChangeAlphaWhenDisable(false);
    L8:
        setHighlightColor(r2.getColor(c.S));
    }

    public /* synthetic */ OTextView(Context r2, AttributeSet r3, int r4, m r5, int r6, kotlin.n0.d.g r7) {
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

    private final void f() {
        int r1 = 1;
        if (getLineCount() > 1) goto L5;
        boolean r0 = true;
    L6:
        int r2 = this.f11517i & 112;
        if (r0 == true) goto L10;
        r1 = 3;
    L10:
        int r3 = r2 | r1;
        if (getGravity() == r3) goto L14;
        setGravity(r3);
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // d.g.d.b.b.f
    public boolean a() {
        return this.f11520l.a();
    }

    @Override // d.g.d.b.b.e
    public void b(String r1) {
        this.f11519k.b(r1);
    }

    @Override // d.g.d.b.b.f
    public void c(int r1) {
        this.f11520l.c(r1);
    }

    @Override // d.g.d.b.b.f
    public boolean d() {
        return this.f11520l.d();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r4) {
        o.f(r4, "canvas");
        super.dispatchDraw(r4);
        j r0 = this.f11514f;
        if (r0 == null) goto L5;
        r0.u(r4, getWidth(), getHeight());
    L5:
        j r3 = this.f11514f;
        if (r3 == null) goto L9;
        r3.s(r4);
        return;
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r2) {
        o.f(r2, "canvas");
        j r0 = this.f11514f;
        if (r0 == null) goto L5;
        r0.t(r2);
    L5:
        super.draw(r2);
    }

    @Override // d.g.d.b.b.f
    public void e(float r1) {
        this.f11520l.e(r1);
    }

    public e getAlphaHelper() {
        return this.m.a();
    }

    public i getEffectHelper() {
        return this.m.b();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f11518j;
    }

    public f getLayoutHelper() {
        return this.m.c();
    }

    @Override // d.g.d.b.b.f
    public int getRadius() {
        return this.f11520l.getRadius();
    }

    @Override // d.g.d.b.b.f
    public float getShadowAlpha() {
        return this.f11520l.getShadowAlpha();
    }

    @Override // android.widget.TextView, d.g.d.b.b.f
    public int getShadowColor() {
        return this.f11520l.getShadowColor();
    }

    @Override // d.g.d.b.b.f
    public int getShadowElevation() {
        return this.f11520l.getShadowElevation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.f11518j == false) goto L6;
        f();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // d.g.d.b.b.f
    public void setBorderColor(@ColorInt int r1) {
        this.f11520l.setBorderColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBorderWidth(int r1) {
        this.f11520l.setBorderWidth(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBottomDividerAlpha(int r1) {
        this.f11520l.setBottomDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f11519k.setChangeAlphaWhenDisable(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f11519k.setChangeAlphaWhenPress(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f11519k.setChangeAlphaWhenSelected(r1);
    }

    public final void setEnableAutoAlignLeft(boolean r2) {
        if (this.f11518j == r2) goto L6;
        this.f11518j = r2;
        requestLayout();
        return;
    }

    @Override // d.g.d.b.b.e
    public void setKeepPressAlpha(boolean r1) {
        this.f11519k.setKeepPressAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setLeftDividerAlpha(int r1) {
        this.f11520l.setLeftDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOuterNormalColor(int r1) {
        this.f11520l.setOuterNormalColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOutlineExcludePadding(boolean r1) {
        this.f11520l.setOutlineExcludePadding(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        i r0 = this.f11516h;
        if (r0 == null) goto L5;
        r0.u(r2);
    L5:
        super.setPressed(r2);
        g r1 = this.f11515g;
        if (r1 == null) goto L9;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRadius(int r1) {
        this.f11520l.setRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setRightDividerAlpha(int r1) {
        this.f11520l.setRightDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowAlpha(float r1) {
        this.f11520l.setShadowAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowColor(int r1) {
        this.f11520l.setShadowColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowCornerRadius(int r1) {
        this.f11520l.setShadowCornerRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowElevation(int r1) {
        this.f11520l.setShadowElevation(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowStyle(@StyleRes int r1) {
        this.f11520l.setShadowStyle(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.f11520l.setShowBorderOnlyBeforeL(r1);
    }

    @Override // d.g.d.b.b.f
    public void setTopDividerAlpha(int r1) {
        this.f11520l.setTopDividerAlpha(r1);
    }
}
