package com.obric.oui.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.k;
import d.g.d.b.b.e;
import d.g.d.b.b.f;
import d.g.d.b.b.g;
import d.g.d.b.b.i;
import d.g.d.b.b.j;
import d.g.d.b.b.m;
import d.g.d.f.f.b;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B?\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u0017\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0088\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\"\u0010#J7\u0010)\u001a\u00020\t2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017H\u0014¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010\u000fJ\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010\u000fJ\u0017\u0010/\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b/\u0010\u000fJ\u0017\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0017H\u0017¢\u0006\u0004\b1\u0010\u001aJ \u00105\u001a\u00020\t2\u000e\u00104\u001a\n 3*\u0004\u0018\u00010202H\u0096\u0001¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b:\u0010\u000fJ\u0018\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b<\u0010\u000fJ\u0018\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b>\u0010\u000fJ\u0010\u0010?\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bE\u0010BJ\u0010\u0010F\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bF\u0010BJ\u001a\u0010H\u001a\u00020\t2\b\b\u0001\u0010G\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bH\u0010\u001aJ\u0018\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bJ\u0010\u001aJ\u0018\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bL\u0010\u001aJ\u0018\u0010M\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bM\u0010\u001aJ\u0018\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bO\u0010\u001aJ\u0018\u0010Q\u001a\u00020\t2\u0006\u0010P\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\bQ\u0010\u000fJ\u0018\u0010S\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bS\u0010\u001aJ\u0018\u0010T\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bT\u0010\u001aJ\u0018\u0010V\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bV\u0010\u0013J\u0018\u0010X\u001a\u00020\t2\u0006\u0010W\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bX\u0010\u001aJ\u0018\u0010Y\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\bY\u0010\u001aJ\u0018\u0010[\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b[\u0010\u001aJ\u001a\u0010]\u001a\u00020\t2\b\b\u0001\u0010\\\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b]\u0010\u001aJ\u0018\u0010_\u001a\u00020\t2\u0006\u0010^\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b_\u0010\u000fJ\u0018\u0010`\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b`\u0010\u001aJ\u0010\u0010a\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\ba\u0010@J\u0018\u0010c\u001a\u00020\t2\u0006\u0010b\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bc\u0010\u0013J\u0010\u0010d\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\bd\u0010eJ\u0010\u0010g\u001a\u00020fH\u0096\u0001¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010oR\u0016\u0010t\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010lR*\u0010x\u001a\u00020\u00172\u0006\u0010u\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010o\u001a\u0004\bv\u0010B\"\u0004\bw\u0010\u001aR\u0018\u0010{\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010zR1\u0010\u0082\u0001\u001a\u0004\u0018\u00010|2\b\u0010u\u001a\u0004\u0018\u00010|8\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b\n\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010\u0083\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010o¨\u0006\u008c\u0001"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Ld/g/d/b/b/e;", "Ld/g/d/b/b/f;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/f0;", "h", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "pressed", "setPressState", "(Z)V", "", "fraction", "j", "(F)V", "i", "g", "(F)F", "", "resId", "setButtonSourceBitmap", "(I)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "f", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "selected", "setSelected", "enabled", "setEnabled", "setPressed", "alpha", "c", "", "kotlin.jvm.PlatformType", "scene", "b", "(Ljava/lang/String;)V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "a", "()Z", "getRadius", "()I", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", TypedValues.Custom.S_COLOR, "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "d", "strength", "e", "getAlphaHelper", "()Ld/g/d/b/b/e;", "Ld/g/d/b/b/i;", "getEffectHelper", "()Ld/g/d/b/b/i;", "getLayoutHelper", "()Ld/g/d/b/b/f;", "k", "Z", "internalPressState", "m", "I", "originIconAlpha", "l", "originTextColor", "n", "changeAlphaWhenPressed", "value", "getMImageTintColorId", "setMImageTintColorId", "mImageTintColorId", "Ld/g/d/b/b/g;", "Ld/g/d/b/b/g;", "mAlphaHelper", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "Ld/g/d/b/b/i;", "mOUIEffectHelper", "mImageSourceId", "defStyleAttr", "defStyleRes", "Ld/g/d/b/b/m;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILd/g/d/b/b/m;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements e, f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f10811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f10812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f10813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10817l;
    private int m;
    private boolean n;
    private final /* synthetic */ e o;
    private final /* synthetic */ f p;
    private final /* synthetic */ m q;

    static {
    }

    public OButton(Context r9, AttributeSet r10) {
        this(r9, r10, 0, 0, null, 28, null);
    }

    public OButton(Context r1, AttributeSet r2, int r3, int r4, m r5) {
        o.f(r1, "context");
        o.f(r5, "provider");
        super(r1, r2, r3);
        this.o = r5.a();
        this.p = r5.c();
        this.q = r5;
        r5.d(this);
        f r6 = getLayoutHelper();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        j r7 = (j) r6;
        e r8 = getAlphaHelper();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f10811f = (g) r8;
        this.f10812g = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        h(r1, r2);
    }

    public /* synthetic */ OButton(Context r8, AttributeSet r9, int r10, int r11, m r12, int r13, kotlin.n0.d.g r14) {
        if ((r13 & 4) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r12 = new m(r8, r9, r4, r5);
    L13:
        this(r8, r9, r4, r5, r12);
        return;
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    private final float g(float r2) {
        return 1 - (r2 * 0.7f);
    }

    private final void h(Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, k.p);
        o.e(r4, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f10814i = r4.getResourceId(k.q, -1);
        setMImageTintColorId(r4.getResourceId(k.r, -1));
        int r5 = this.f10814i;
        if (r5 < 0) goto L5;
        setButtonSourceBitmap(r5);
    L5:
        setTextAppearance(r4.getResourceId(k.t, com.obric.common.oui.j.f8286k));
        this.n = r4.getBoolean(k.s, false);
        int r6 = getCurrentTextColor();
        this.f10817l = r6;
        ColorStateList r7 = ColorStateList.valueOf(r6);
        o.e(r7, "ColorStateList.valueOf(textColor)");
        setCompoundDrawableTintList(r7);
        r4.recycle();
    }

    private final void i(float r4) {
        int r0 = this.m;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = kotlin.r0.e.i((int) (r0 * g(r4)), 0, 255);
        Drawable r2 = this.f10813h;
        if (r2 == null) goto L8;
        r2.setAlpha(r1);
    L8:
        b.a("OButton", "updateIconAlphaOnPress, fraction: " + r4 + ", alpha: " + r1 + ", originIconAlpha: " + this.m);
    }

    private final void j(float r8) {
        int r0 = this.f10817l;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (r0 >> 24) & 255;
        int r2 = kotlin.r0.e.i((int) (r1 * g(r8)), 0, 255);
        int r3 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r3 | (r2 << 24)) | (((r0 >> 8) & 255) << 8)));
        b.a("OButton", "updateTextColorOnPress, fraction: " + r8 + ", newTextAlpha: " + r2 + ", originTextAlpha: " + r1);
    }

    private final void setPressState(boolean r2) {
        if (this.f10816k != r2) goto L6;
        b.j("OButton", "setPressState, already set, skip! pressed: " + r2);
        return;
    L6:
        this.f10816k = r2;
        i r0 = this.f10812g;
        if (r0 == null) goto L9;
        r0.u(r2);
    L9:
        g r1 = this.f10811f;
        if (r1 == null) goto L13;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public boolean a() {
        return this.p.a();
    }

    @Override // d.g.d.b.b.e
    public void b(String r1) {
        this.o.b(r1);
    }

    @Override // d.g.d.b.b.f
    @RequiresApi(26)
    public void c(int r3) {
        if (this.n == true) goto L5;
        return;
    L5:
        float r4 = kotlin.r0.e.h(r3 / 255.0f, 0.0f, 1.0f);
        j(r4);
        i(r4);
    }

    @Override // d.g.d.b.b.f
    public boolean d() {
        return this.p.d();
    }

    @Override // d.g.d.b.b.f
    public void e(float r1) {
        this.p.e(r1);
    }

    public final void f(Canvas r6) {
        if (r6 == null) goto L10;
        Drawable r0 = this.f10813h;
        if (r0 == null) goto L11;
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.f10815j <= 0) goto L8;
        r0.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f10815j), PorterDuff.Mode.SRC_IN));
    L8:
        r0.draw(r6);
        return;
    L11:
        return;
    }

    public e getAlphaHelper() {
        return this.q.a();
    }

    public i getEffectHelper() {
        return this.q.b();
    }

    public f getLayoutHelper() {
        return this.q.c();
    }

    public final Drawable getMIcon() {
        return this.f10813h;
    }

    public final int getMImageTintColorId() {
        return this.f10815j;
    }

    @Override // d.g.d.b.b.f
    public int getRadius() {
        return this.p.getRadius();
    }

    @Override // d.g.d.b.b.f
    public float getShadowAlpha() {
        return this.p.getShadowAlpha();
    }

    @Override // android.widget.TextView, d.g.d.b.b.f
    public int getShadowColor() {
        return this.p.getShadowColor();
    }

    @Override // d.g.d.b.b.f
    public int getShadowElevation() {
        return this.p.getShadowElevation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r2) {
        o.f(r2, "canvas");
        super.onDraw(r2);
        f(r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.f10813h;
        if (r0 == null) goto L5;
        r6 = Math.max(r6, (r0.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r7 = Math.max(r7, (r0.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L5:
        setMeasuredDimension(r6, r7);
    }

    @Override // d.g.d.b.b.f
    public void setBorderColor(@ColorInt int r1) {
        this.p.setBorderColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBorderWidth(int r1) {
        this.p.setBorderWidth(r1);
    }

    @Override // d.g.d.b.b.f
    public void setBottomDividerAlpha(int r1) {
        this.p.setBottomDividerAlpha(r1);
    }

    public final void setButtonSourceBitmap(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r2));
        Drawable r3 = this.f10813h;
        if (r3 == null) goto L7;
        int r4 = r3.getAlpha();
    L8:
        this.m = r4;
        invalidate();
        return;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.o.setChangeAlphaWhenDisable(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenPress(boolean r1) {
        this.o.setChangeAlphaWhenPress(r1);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.o.setChangeAlphaWhenSelected(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        g r0 = this.f10811f;
        if (r0 == null) goto L6;
        r0.l(this, r2);
        return;
    }

    @Override // d.g.d.b.b.e
    public void setKeepPressAlpha(boolean r1) {
        this.o.setKeepPressAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setLeftDividerAlpha(int r1) {
        this.p.setLeftDividerAlpha(r1);
    }

    public final void setMIcon(Drawable r1) {
        this.f10813h = r1;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r1) {
        this.f10815j = r1;
        invalidate();
    }

    @Override // d.g.d.b.b.f
    public void setOuterNormalColor(int r1) {
        this.p.setOuterNormalColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setOutlineExcludePadding(boolean r1) {
        this.p.setOutlineExcludePadding(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        i r0 = this.f10812g;
        if (r0 == null) goto L5;
        r0.u(r2);
    L5:
        g r1 = this.f10811f;
        if (r1 == null) goto L9;
        r1.m(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setRadius(int r1) {
        this.p.setRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setRightDividerAlpha(int r1) {
        this.p.setRightDividerAlpha(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        g r0 = this.f10811f;
        if (r0 == null) goto L6;
        r0.n(this, r2);
        return;
    }

    @Override // d.g.d.b.b.f
    public void setShadowAlpha(float r1) {
        this.p.setShadowAlpha(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowColor(int r1) {
        this.p.setShadowColor(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowCornerRadius(int r1) {
        this.p.setShadowCornerRadius(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowElevation(int r1) {
        this.p.setShadowElevation(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShadowStyle(@StyleRes int r1) {
        this.p.setShadowStyle(r1);
    }

    @Override // d.g.d.b.b.f
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.p.setShowBorderOnlyBeforeL(r1);
    }

    @Override // d.g.d.b.b.f
    public void setTopDividerAlpha(int r1) {
        this.p.setTopDividerAlpha(r1);
    }
}
