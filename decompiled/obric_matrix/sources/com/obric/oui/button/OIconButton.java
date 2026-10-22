package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.common.oui.k;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B;\b\u0007\u0012\u0006\u0010i\u001a\u00020h\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010j\u0012\b\b\u0002\u0010l\u001a\u00020\u001a\u0012\b\b\u0002\u0010m\u001a\u00020\u001a\u0012\b\b\u0002\u0010o\u001a\u00020n¢\u0006\u0004\bp\u0010qJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010!\u001a\u00020\u00072\u000e\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b$\u0010\tJ\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b&\u0010\tJ\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b(\u0010\tJ\u0018\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b*\u0010\tJ\u0010\u0010+\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b1\u0010.J\u0010\u00102\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b2\u0010.J\u001a\u00104\u001a\u00020\u00072\b\b\u0001\u00103\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b4\u0010\u001dJ\u0018\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b6\u0010\u001dJ\u0018\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b8\u0010\u001dJ\u0018\u00109\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b9\u0010\u001dJ\u0018\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b;\u0010\u001dJ\u0018\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b=\u0010\tJ\u0018\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b?\u0010\u001dJ\u0018\u0010@\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b@\u0010\u001dJ\u0018\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\bB\u0010\rJ\u0018\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\bD\u0010\u001dJ\u0018\u0010E\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\bE\u0010\u001dJ\u0018\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\bG\u0010\u001dJ\u001a\u0010I\u001a\u00020\u00072\b\b\u0001\u0010H\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\bI\u0010\u001dJ\u0018\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\bK\u0010\tJ\u0018\u0010L\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\bL\u0010\u001dJ\u0010\u0010M\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\bM\u0010,J\u0018\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\bO\u0010\rJ\u0010\u0010P\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\bP\u0010QJ\u0010\u0010S\u001a\u00020RH\u0096\u0001¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010f¨\u0006r"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Ld/g/d/b/b/e;", "Ld/g/d/b/b/f;", "", "", "pressed", "Lkotlin/f0;", "setPressState", "(Z)V", "", "fraction", "g", "(F)V", "f", "(F)F", "setPressed", "enabled", "setEnabled", "selected", "setSelected", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "", "alpha", "c", "(I)V", "", "kotlin.jvm.PlatformType", "scene", "b", "(Ljava/lang/String;)V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "a", "()Z", "getRadius", "()I", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", TypedValues.Custom.S_COLOR, "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "d", "strength", "e", "getAlphaHelper", "()Ld/g/d/b/b/e;", "Ld/g/d/b/b/i;", "getEffectHelper", "()Ld/g/d/b/b/i;", "getLayoutHelper", "()Ld/g/d/b/b/f;", "Ld/g/d/b/b/g;", "Ld/g/d/b/b/g;", "mAlphaHelper", "h", "Ld/g/d/b/b/i;", "mOUIEffectHelper", "i", "Z", "internalPressState", "j", "changeAlphaWhenPressed", "k", "I", "originIconAlpha", "Ld/g/d/b/b/j;", "Ld/g/d/b/b/j;", "mLayoutHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "Ld/g/d/b/b/m;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILd/g/d/b/b/m;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OIconButton extends AppCompatImageView implements e, f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j f10818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f10819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i f10820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final /* synthetic */ e f10824l;
    private final /* synthetic */ f m;
    private final /* synthetic */ m n;

    static {
    }

    public OIconButton(Context r9, AttributeSet r10) {
        this(r9, r10, 0, 0, null, 28, null);
    }

    public OIconButton(Context r1, AttributeSet r2, int r3, int r4, m r5) {
        o.f(r1, "context");
        o.f(r5, "provider");
        super(r1, r2, r3);
        this.f10824l = r5.a();
        this.m = r5.c();
        this.n = r5;
        r5.d(this);
        f r6 = getLayoutHelper();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.f10818f = (j) r6;
        e r7 = getAlphaHelper();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f10819g = (g) r7;
        this.f10820h = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r8 = r1.obtainStyledAttributes(r2, k.p);
        o.e(r8, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f10822j = r8.getBoolean(k.s, false);
        r8.recycle();
    }

    public /* synthetic */ OIconButton(Context r7, AttributeSet r8, int r9, int r10, m r11, int r12, kotlin.n0.d.g r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r12 & 8) == 0) goto L12;
        int r4 = 0;
    L14:
        if ((r12 & 16) == 0) goto L16;
        r11 = new m(r7, r2, r3, r4);
    L16:
        this(r7, r2, r3, r4, r11);
        return;
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    private final float f(float r2) {
        return 1 - (r2 * 0.7f);
    }

    private final void g(float r3) {
        if (this.f10823k != 0) goto L5;
        this.f10823k = getImageAlpha();
    L5:
        int r0 = this.f10823k;
        if (r0 != 0) goto L8;
        return;
    L8:
        setImageAlpha(kotlin.r0.e.i((int) (r0 * f(r3)), 0, 255));
    }

    private final void setPressState(boolean r2) {
        if (this.f10821i != r2) goto L5;
        return;
    L5:
        this.f10821i = r2;
        i r0 = this.f10820h;
        if (r0 == null) goto L8;
        r0.u(r2);
    L8:
        g r1 = this.f10819g;
        if (r1 == null) goto L12;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public boolean a() {
        return this.m.a();
    }

    @Override // d.g.d.b.b.e
    public void b(String r1) {
        this.f10824l.b(r1);
    }

    @Override // d.g.d.b.b.f
    @RequiresApi(26)
    public void c(int r3) {
        if (this.f10822j == true) goto L5;
        return;
    L5:
        g(kotlin.r0.e.h(r3 / 255.0f, 0.0f, 1.0f));
    }

    @Override // d.g.d.b.b.f
    public boolean d() {
        return this.m.d();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r4) {
        o.f(r4, "canvas");
        super.dispatchDraw(r4);
        j r0 = this.f10818f;
        if (r0 == null) goto L5;
        r0.u(r4, getWidth(), getHeight());
    L5:
        j r3 = this.f10818f;
        if (r3 == null) goto L9;
        r3.s(r4);
        return;
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r2) {
        o.f(r2, "canvas");
        j r0 = this.f10818f;
        if (r0 == null) goto L5;
        r0.t(r2);
    L5:
        super.draw(r2);
    }

    @Override // d.g.d.b.b.f
    public void e(float r1) {
        this.m.e(r1);
    }

    public e getAlphaHelper() {
        return this.n.a();
    }

    public i getEffectHelper() {
        return this.n.b();
    }

    public f getLayoutHelper() {
        return this.n.c();
    }

    @Override // d.g.d.b.b.f
    public int getRadius() {
        return this.m.getRadius();
    }

    @Override // d.g.d.b.b.f
    public float getShadowAlpha() {
        return this.m.getShadowAlpha();
    }

    @Override // d.g.d.b.b.f
    public int getShadowColor() {
        return this.m.getShadowColor();
    }

    @Override // d.g.d.b.b.f
    public int getShadowElevation() {
        return this.m.getShadowElevation();
    }

    @Override // d.g.d.b.b.f
    public void setBorderColor(@ColorInt int r1) {
        this.m.setBorderColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBorderWidth(int r1) {
        this.m.setBorderWidth(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBottomDividerAlpha(int r1) {
        this.m.setBottomDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f10824l.setChangeAlphaWhenDisable(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f10824l.setChangeAlphaWhenPress(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f10824l.setChangeAlphaWhenSelected(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        g r0 = this.f10819g;
        if (r0 == null) goto L6;
        r0.l(this, r2);
        return;
    }

    @Override // d.g.d.b.b.e
    public void setKeepPressAlpha(boolean r1) {
        this.f10824l.setKeepPressAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setLeftDividerAlpha(int r1) {
        this.m.setLeftDividerAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOuterNormalColor(int r1) {
        this.m.setOuterNormalColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOutlineExcludePadding(boolean r1) {
        this.m.setOutlineExcludePadding(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        i r0 = this.f10820h;
        if (r0 == null) goto L5;
        r0.u(r2);
    L5:
        g r1 = this.f10819g;
        if (r1 == null) goto L9;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRadius(int r1) {
        this.m.setRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setRightDividerAlpha(int r1) {
        this.m.setRightDividerAlpha(r1);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        g r0 = this.f10819g;
        if (r0 == null) goto L6;
        r0.n(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setShadowAlpha(float r1) {
        this.m.setShadowAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowColor(int r1) {
        this.m.setShadowColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowCornerRadius(int r1) {
        this.m.setShadowCornerRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowElevation(int r1) {
        this.m.setShadowElevation(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowStyle(@StyleRes int r1) {
        this.m.setShadowStyle(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.m.setShowBorderOnlyBeforeL(r1);
    }

    @Override // d.g.d.b.b.f
    public void setTopDividerAlpha(int r1) {
        this.m.setTopDividerAlpha(r1);
    }
}
