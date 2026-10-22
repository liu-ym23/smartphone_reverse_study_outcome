package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.oui.haptic.VibratorSmt;
import com.ss.android.common.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"RestrictedApi"})
public class SwitchCompat extends CompoundButton {
    public static final SwitchCompat$Companion$THUMB_POS$1 R = null;
    public static final int[] S = null;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextPaint f239J;
    public ObjectAnimator K;
    public final Rect L;
    public int M;
    public int N;
    public boolean O;
    public final PathInterpolator P;
    public float Q;
    public Drawable b;
    public ColorStateList c;
    public PorterDuff.Mode e;
    public boolean f;
    public boolean i;
    public Drawable j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public CharSequence s;
    public CharSequence t;
    public int u;
    public final int v;
    public float w;
    public float x;
    public final VelocityTracker y;
    public final int z;

    @Metadata
    public static final class Companion {
    }

    static {
        R = new SwitchCompat$Companion$THUMB_POS$1(Float.TYPE, "thumbPos");
        S = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(Context r9, AttributeSet r10, int r11) {
        super(r9, r10, r11);
        this.y = VelocityTracker.obtain();
        this.L = new Rect();
        boolean r0 = true;
        this.O = true;
        this.P = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        TextPaint r1 = new TextPaint(1);
        this.f239J = r1;
        Resources r2 = getResources();
        Intrinsics.e(r2, "res");
        r1.density = r2.getDisplayMetrics().density;
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r9, r10, androidx.appcompat.R.styleable.SwitchCompat, r11, 0);
        Drawable r13 = r12.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.b = r13;
        if (r13 == null) goto L5;
        r13.setCallback(this);
    L5:
        Drawable r14 = r12.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.j = r14;
        if (r14 == null) goto L8;
        r14.setCallback(this);
    L8:
        this.s = r12.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.t = r12.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.o = r12.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.p = r12.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.q = r12.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.r = r12.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r15 = r12.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r15 == null) goto L11;
        this.c = r15;
        this.f = true;
    L11:
        Typeface r4 = null;
        PorterDuff.Mode r16 = DrawableUtils.parseTintMode(r12.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.e == r16) goto L15;
        this.e = r16;
        this.i = true;
    L15:
        if (this.f == false) goto L17;
    L18:
        a();
    L19:
        ColorStateList r17 = r12.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r17 == null) goto L22;
        this.k = r17;
        this.m = true;
    L22:
        PorterDuff.Mode r18 = DrawableUtils.parseTintMode(r12.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.l == r18) goto L26;
        this.l = r18;
        this.n = true;
    L26:
        if (this.m == false) goto L28;
    L29:
        b();
    L30:
        int r19 = r12.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r19 == 0) goto L72;
        TintTypedArray r110 = TintTypedArray.obtainStyledAttributes(r9, r19, androidx.appcompat.R.styleable.TextAppearance);
        if (r110.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor) != null) goto L36;
        getTextColors();
    L36:
        int r5 = r110.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r5 == 0) goto L41;
        float r6 = r5;
        if (r6 == r1.getTextSize()) goto L41;
        r1.setTextSize(r6);
        requestLayout();
    L41:
        int r7 = r110.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1);
        int r3 = r110.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1);
        if (r7 == 1) goto L49;
        if (r7 != 2) goto L45;
        r4 = Typeface.SERIF;
    L50:
        float r8 = 0.0f;
        if (r3 <= 0) goto L67;
        if (r4 != null) goto L54;
        Typeface r20 = Typeface.defaultFromStyle(r3);
    L55:
        setSwitchTypeface(r20);
        if (r20 == null) goto L58;
        int r21 = r20.getStyle();
    L59:
        int r22 = r3 & (~r21);
        if ((r22 & 1) != 0) goto L63;
        r0 = false;
    L63:
        r1.setFakeBoldText(r0);
        if ((r22 & 2) == 0) goto L66;
        r8 = -0.25f;
    L66:
        r1.setTextSkewX(r8);
    L69:
        if (r110.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L71;
        new AllCapsTransformationMethod(getContext());
    L71:
        r110.recycle();
        goto L72
    L58:
        r21 = 0;
        goto L59
    L54:
        r20 = Typeface.create(r4, r3);
        goto L55
    L67:
        r1.setFakeBoldText(false);
        r1.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
        goto L69
    L45:
        if (r7 != 3) goto L50;
        r4 = Typeface.MONOSPACE;
        goto L50
    L49:
        r4 = Typeface.SANS_SERIF;
    L72:
        r12.recycle();
        if (r9 == null) goto L75;
        ViewConfiguration r23 = ViewConfiguration.get(r9);
        Intrinsics.e(r23, "config");
        this.v = r23.getScaledTouchSlop();
        this.z = r23.getScaledMinimumFlingVelocity();
    L76:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L75:
        this.v = 0;
        this.z = 0;
        goto L76
    L28:
        if (this.n == false) goto L30;
    L17:
        if (this.i == false) goto L19;
        goto L18
    }

    private final boolean getTargetCheckedState() {
        if (this.Q <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r0 = 1 - this.A;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.A;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.j;
        if (r0 == null) goto L9;
        Intrinsics.c(r0);
        Rect r1 = this.L;
        r0.getPadding(r1);
        Drawable r2 = this.b;
        if (r2 == null) goto L7;
        Rect r3 = DrawableUtils.getOpticalBounds(r2);
        Intrinsics.e(r3, "DrawableUtils.getOpticalBounds(mThumbDrawable)");
    L11:
        return ((((((this.B - this.D) - r1.left) - r1.right) - r3.left) - r3.right) - this.N) - this.M;
    L7:
        r3 = DrawableUtils.INSETS_NONE;
        Intrinsics.e(r3, "DrawableUtils.INSETS_NONE");
        goto L11
    L9:
        return 0;
    }

    public final void a() {
        Drawable r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == false) goto L7;
    L8:
        Intrinsics.c(r0);
        Drawable r1 = r0.mutate();
        this.b = r1;
        if (this.f == false) goto L12;
        Intrinsics.c(r1);
        DrawableCompat.setTintList(r1, this.c);
    L12:
        if (this.i == false) goto L14;
        Drawable r2 = this.b;
        Intrinsics.c(r2);
        PorterDuff.Mode r3 = this.e;
        Intrinsics.c(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.b;
        Intrinsics.c(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.b;
        Intrinsics.c(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.i == true) goto L8;
    }

    public final void b() {
        Drawable r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.m == false) goto L7;
    L8:
        Intrinsics.c(r0);
        Drawable r1 = r0.mutate();
        this.j = r1;
        if (this.m == false) goto L12;
        Intrinsics.c(r1);
        DrawableCompat.setTintList(r1, this.k);
    L12:
        if (this.n == false) goto L14;
        Drawable r2 = this.j;
        Intrinsics.c(r2);
        PorterDuff.Mode r3 = this.l;
        Intrinsics.c(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.j;
        Intrinsics.c(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.j;
        Intrinsics.c(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.n == true) goto L8;
    }

    @Override // android.view.View
    public final void draw(Canvas r11) {
        Intrinsics.f(r11, "c");
        int r0 = this.F;
        int r1 = this.G;
        int r2 = this.H;
        int r3 = this.I;
        int r4 = getThumbOffset() + r0;
        Drawable r5 = this.b;
        if (r5 == null) goto L5;
        Rect r6 = DrawableUtils.getOpticalBounds(r5);
    L6:
        Drawable r7 = this.j;
        Rect r8 = this.L;
        if (r7 == null) goto L26;
        Intrinsics.c(r7);
        r7.getPadding(r8);
        int r9 = r8.left;
        r4 = r4 + r9;
        if (r6 == null) goto L24;
        int r10 = r6.left;
        if (r10 <= r9) goto L13;
        r0 = r0 + (r10 - r9);
    L13:
        int r12 = r6.top;
        int r13 = r8.top;
        if (r12 <= r13) goto L16;
        int r14 = (r12 - r13) + r1;
    L17:
        int r15 = r6.right;
        int r16 = r8.right;
        if (r15 <= r16) goto L20;
        r2 = r2 - (r15 - r16);
    L20:
        int r17 = r6.bottom;
        int r18 = r8.bottom;
        if (r17 <= r18) goto L23;
        int r19 = r3 - (r17 - r18);
    L25:
        Drawable r20 = this.j;
        Intrinsics.c(r20);
        r20.setBounds(r0, r14, r2, r19);
    L23:
        r19 = r3;
        goto L25
    L16:
        r14 = r1;
        goto L17
    L24:
        r14 = r1;
    L26:
        Drawable r21 = this.b;
        if (r21 == null) goto L31;
        Intrinsics.c(r21);
        r21.getPadding(r8);
        int r22 = r4 - r8.left;
        int r23 = this.M;
        int r24 = r22 + r23;
        int r25 = ((r4 + this.D) + r8.right) + r23;
        int r26 = ((r3 - r1) - this.E) / 2;
        Drawable r27 = this.b;
        Intrinsics.c(r27);
        r27.setBounds(r24, r26, r25, this.E + r26);
        Drawable r28 = getBackground();
        if (r28 == null) goto L31;
        DrawableCompat.setHotspotBounds(r28, r24, r1, r25, r3);
    L31:
        super.draw(r11);
        return;
    L5:
        r6 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r2, float r3) {
        super.drawableHotspotChanged(r2, r3);
        Drawable r0 = this.b;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        DrawableCompat.setHotspot(r0, r2, r3);
    L5:
        Drawable r1 = this.j;
        if (r1 == null) goto L9;
        Intrinsics.c(r1);
        DrawableCompat.setHotspot(r1, r2, r3);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Drawable r3 = this.j;
        if (r3 != null) goto L11;
    L13:
        if (r2 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r3.isStateful() == false) goto L13;
        r2 = r2 | r3.setState(r0);
        goto L13
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = r1.setState(r0);
        goto L8
    }

    public final boolean getAutoCheck() {
        return this.O;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.B;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.q;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.B;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.q;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Nullable
    public final ObjectAnimator getMPositionAnimator() {
        return this.K;
    }

    public final float getMThumbPosition() {
        return this.A;
    }

    public final boolean getShowText() {
        return false;
    }

    public final boolean getSplitTrack() {
        return this.r;
    }

    public final int getSwitchMinWidth() {
        return this.p;
    }

    public final int getSwitchPadding() {
        return this.q;
    }

    @Nullable
    public final CharSequence getTextOff() {
        return this.t;
    }

    @Nullable
    public final CharSequence getTextOn() {
        return this.s;
    }

    public final int getThumbConstraintLeft() {
        return this.M;
    }

    public final int getThumbConstraintRight() {
        return this.N;
    }

    @Nullable
    public final Drawable getThumbDrawable() {
        return this.b;
    }

    public final int getThumbTextPadding() {
        return this.o;
    }

    @Nullable
    public final ColorStateList getThumbTintList() {
        return this.c;
    }

    @Nullable
    public final PorterDuff.Mode getThumbTintMode() {
        return this.e;
    }

    @Nullable
    public final Drawable getTrackDrawable() {
        return this.j;
    }

    @Nullable
    public final ColorStateList getTrackTintList() {
        return this.k;
    }

    @Nullable
    public final PorterDuff.Mode getTrackTintMode() {
        return this.l;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.b;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.j;
        if (r1 == null) goto L8;
        Intrinsics.c(r1);
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.K;
        if (r2 == null) goto L14;
        Intrinsics.c(r2);
        if (r2.isStarted() == false) goto L15;
        ObjectAnimator r3 = this.K;
        Intrinsics.c(r3);
        r3.end();
        this.K = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r2, S);
    L5:
        Intrinsics.e(r2, "drawableState");
        return r2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.f(r7, "canvas");
        super.onDraw(r7);
        Drawable r0 = this.j;
        Rect r1 = this.L;
        if (r0 == null) goto L5;
        r0.getPadding(r1);
    L6:
        int r2 = r1.top;
        Drawable r3 = this.b;
        if (r0 != null) goto L9;
    L13:
        int r4 = r7.save();
        if (r3 == null) goto L16;
        r3.draw(r7);
    L16:
        getTargetCheckedState();
        r7.restoreToCount(r4);
        return;
    L9:
        if (this.r == false) goto L12;
        if (r3 == null) goto L12;
        Rect r5 = DrawableUtils.getOpticalBounds(r3);
        r3.copyBounds(r1);
        r1.left += r5.left;
        r1.right -= r5.right;
        int r6 = r7.save();
        r7.clipRect(r1, Region.Op.DIFFERENCE);
        r0.draw(r7);
        r7.restoreToCount(r6);
    L12:
        r0.draw(r7);
        goto L13
    L5:
        r1.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        Intrinsics.f(r2, "event");
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        Intrinsics.f(r3, AlogMonitor.ALOG_RESULT_INFO);
        super.onInitializeAccessibilityNodeInfo(r3);
        r3.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r2 = this.s;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        CharSequence r0 = r3.getText();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r3.setText(r2);
        return;
    L11:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append(' ');
        r1.append(r2);
        r3.setText(r1);
        return;
    L13:
        return;
    L5:
        r2 = this.t;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = 0;
        if (this.b == null) goto L9;
        Drawable r8 = this.j;
        Rect r9 = this.L;
        if (r8 == null) goto L7;
        Intrinsics.c(r8);
        r8.getPadding(r9);
    L8:
        Rect r10 = DrawableUtils.getOpticalBounds(this.b);
        int r11 = Math.max(0, r10.left - r9.left);
        r7 = Math.max(0, r10.right - r9.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r12 = getPaddingLeft() + r11;
        int r13 = ((this.B + r12) - r11) - r7;
    L14:
        int r14 = getGravity() & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r14 != 16) goto L17;
        int r15 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
        int r16 = this.C;
        int r17 = r15 - (r16 / 2);
        int r18 = r16 + r17;
        int r19 = r17;
    L25:
        this.F = r12;
        this.G = r19;
        this.I = r18;
        this.H = r13;
        return;
    L17:
        if (r14 != 48) goto L19;
        r19 = getPaddingTop();
        int r20 = this.C;
    L21:
        r18 = r20 + r19;
        goto L25
    L19:
        if (r14 == 80) goto L22;
        r19 = getPaddingTop();
        r20 = this.C;
        goto L21
    L22:
        r18 = getHeight() - getPaddingBottom();
        r19 = r18 - this.C;
        goto L25
    L13:
        r13 = (getWidth() - getPaddingRight()) - r7;
        r12 = ((r13 - this.B) + r11) + r7;
        goto L14
    L7:
        r9.setEmpty();
        goto L8
    L9:
        r11 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        Drawable r0 = this.b;
        int r1 = 0;
        Rect r2 = this.L;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        r0.getPadding(r2);
        Drawable r3 = this.b;
        Intrinsics.c(r3);
        int r4 = (r3.getIntrinsicWidth() - r2.left) - r2.right;
        Drawable r5 = this.b;
        Intrinsics.c(r5);
        int r6 = r5.getIntrinsicHeight();
    L6:
        this.D = Math.max(0, r4);
        this.E = r6;
        Drawable r9 = this.j;
        if (r9 == null) goto L9;
        Intrinsics.c(r9);
        r9.getPadding(r2);
        Drawable r10 = this.j;
        Intrinsics.c(r10);
        r1 = r10.getIntrinsicHeight();
    L10:
        int r11 = r2.left;
        int r12 = r2.right;
        Drawable r13 = this.b;
        if (r13 == null) goto L13;
        Rect r14 = DrawableUtils.getOpticalBounds(r13);
        r11 = Math.max(r11, r14.left);
        r12 = Math.max(r12, r14.right);
    L13:
        int r15 = Math.max(this.p, ((this.D * 2) + r11) + r12);
        int r16 = Math.max(r1, r6);
        Resources r17 = Resources.getSystem();
        Intrinsics.e(r17, "Resources.getSystem()");
        this.B = r15 - MathKt.a(TypedValue.applyDimension(1, 4, r17.getDisplayMetrics()));
        this.C = r16;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r16) goto L17;
        setMeasuredDimension(getMeasuredWidthAndState(), r16);
        return;
    L17:
        return;
    L9:
        r2.setEmpty();
        goto L10
    L5:
        r4 = 0;
        r6 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        Intrinsics.f(r2, "event");
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r1 = this.s;
    L6:
        if (r1 == null) goto L9;
        r2.getText().add(r1);
        return;
    L9:
        return;
    L5:
        r1 = this.t;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.f(r10, "ev");
        VelocityTracker r0 = this.y;
        r0.addMovement(r10);
        int r1 = r10.getActionMasked();
        int r2 = this.v;
        if (r1 != 0) goto L5;
        float r3 = r10.getX();
        float r4 = r10.getY();
        if (isEnabled() == true) goto L71;
    L83:
        return super.onTouchEvent(r10);
    L71:
        if (this.b == null) goto L83;
        int r5 = getThumbOffset();
        Drawable r6 = this.b;
        Intrinsics.c(r6);
        Rect r7 = this.L;
        r6.getPadding(r7);
        int r8 = this.G - r2;
        int r9 = (this.F + r5) - r2;
        int r11 = (((this.D + r9) + r7.left) + r7.right) + r2;
        int r12 = this.I + r2;
        if (r3 <= r9) goto L83;
        if (r3 >= r11) goto L83;
        if (r4 <= r8) goto L83;
        if (r4 >= r12) goto L83;
        this.u = 1;
        this.w = r3;
        this.x = r4;
        goto L83
    L5:
        if (r1 == 1) goto L41;
        if (r1 == 2) goto L9;
        if (r1 == 3) goto L41;
    L9:
        int r13 = this.u;
        if (r13 == 1) goto L34;
        if (r13 != 2) goto L83;
        float r14 = r10.getX();
        int r15 = getThumbScrollRange();
        float r16 = r14 - this.w;
        float r17 = 1.0f;
        if (r15 == 0) goto L17;
        float r18 = r16 / r15;
    L21:
        if (ViewUtils.isLayoutRtl(this) == false) goto L23;
        r18 = -r18;
    L23:
        float r19 = this.Q;
        float r20 = r18 + r19;
        if (r20 >= 0.0f) goto L27;
        r17 = 0.0f;
    L31:
        if (r17 == r19) goto L33;
        this.w = r14;
        this.Q = r17;
    L33:
        return true;
    L27:
        if (r20 > 1.0f) goto L31;
        r17 = r20;
        goto L31
    L17:
        if (r16 <= 0) goto L19;
        r18 = 1.0f;
        goto L21
    L19:
        r18 = -1.0f;
        goto L21
    L34:
        float r21 = r10.getX();
        float r22 = r10.getY();
        if (Math.abs(r21 - this.w) <= r2) goto L37;
    L38:
        this.u = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.w = r21;
        this.x = r22;
        return true;
    L37:
        if (Math.abs(r22 - this.x) <= r2) goto L83;
    L41:
        if (this.u != 2) goto L67;
        this.u = 0;
        if (r10.getAction() == 1) goto L45;
    L47:
        boolean r23 = false;
    L48:
        boolean r24 = isChecked();
        if (r23 == false) goto L62;
        r0.computeCurrentVelocity(1000);
        float r25 = r0.getXVelocity();
        if (Math.abs(r25) > this.z) goto L53;
        boolean r26 = getTargetCheckedState();
    L63:
        if (r26 == r24) goto L65;
        playSoundEffect(0);
    L65:
        setChecked(r26);
        MotionEvent r27 = MotionEvent.obtain(r10);
        Intrinsics.e(r27, "cancel");
        r27.setAction(3);
        super.onTouchEvent(r27);
        r27.recycle();
        super.onTouchEvent(r10);
        return true;
    L53:
        if (ViewUtils.isLayoutRtl(this) == false) goto L59;
        if (r25 >= 0) goto L57;
    L56:
        r26 = true;
    L57:
        r26 = false;
        goto L63
    L59:
        if (r25 <= 0) goto L57;
    L62:
        r26 = r24;
        goto L63
    L45:
        if (isEnabled() == false) goto L47;
        r23 = true;
        goto L48
    L67:
        this.u = 0;
        r0.clear();
        goto L83
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        boolean r0 = super.performClick();
        if (isHapticFeedbackEnabled() == true) goto L5;
    L8:
        return r0;
    L5:
        if (isChecked() == false) goto L7;
        VibratorSmt.a(getContext(), 4);
        goto L8
    L7:
        VibratorSmt.a(getContext(), 5);
        goto L8
    }

    public final void setAutoCheck(boolean r1) {
        this.O = r1;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        super.setChecked(r5);
        boolean r6 = isChecked();
        float r3 = 1.0f;
        if (getWindowToken() != null) goto L5;
    L21:
        ObjectAnimator r0 = this.K;
        if (r0 == null) goto L24;
        r0.cancel();
    L24:
        if (r6 == true) goto L27;
        r3 = 0;
    L27:
        setThumbPosition(r3);
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L21;
        if (r6 == true) goto L9;
        r3 = 0;
    L9:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, R, new float[]{r3});
        this.K = r7;
        if (r7 == null) goto L12;
        r7.setDuration(443);
    L12:
        ObjectAnimator r8 = this.K;
        if (r8 == null) goto L15;
        r8.setAutoCancel(true);
    L15:
        ObjectAnimator r9 = this.K;
        if (r9 == null) goto L18;
        r9.setInterpolator(this.P);
    L18:
        ObjectAnimator r4 = this.K;
        if (r4 == null) goto L29;
        r4.start();
        return;
    }

    @CallSuper
    public void setCheckedNoAnim(boolean r1) {
        super.setChecked(r1);
        ObjectAnimator r2 = this.K;
        if (r2 == null) goto L6;
        r2.cancel();
    L6:
        if (isChecked() == false) goto L8;
        float r3 = 1.0f;
    L9:
        setThumbPosition(r3);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@NotNull ActionMode.Callback r2) {
        Intrinsics.f(r2, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r2));
    }

    public final void setMPositionAnimator(@Nullable ObjectAnimator r1) {
        this.K = r1;
    }

    public final void setMThumbPosition(float r1) {
        this.A = r1;
    }

    public final void setShowText(boolean r1) {
    }

    public final void setSplitTrack(boolean r1) {
        this.r = r1;
        invalidate();
    }

    public final void setSwitchMinWidth(int r1) {
        this.p = r1;
        requestLayout();
    }

    public final void setSwitchPadding(int r1) {
        this.q = r1;
        requestLayout();
    }

    public final void setSwitchTypeface(@Nullable Typeface r3) {
        TextPaint r0 = this.f239J;
        if (r0.getTypeface() == null) goto L7;
        if ((!Intrinsics.a(r0.getTypeface(), r3)) == false) goto L7;
    L9:
        r0.setTypeface(r3);
        requestLayout();
        invalidate();
        return;
    L7:
        if (r0.getTypeface() != null) goto L11;
        if (r3 != null) goto L9;
        return;
    }

    public final void setTextOff(@Nullable CharSequence r1) {
        this.t = r1;
        requestLayout();
    }

    public final void setTextOn(@Nullable CharSequence r1) {
        this.s = r1;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r1) {
        this.M = r1;
    }

    public final void setThumbConstraintRight(int r1) {
        this.N = r1;
    }

    public final void setThumbDrawable(@Nullable Drawable r3) {
        Drawable r0 = this.b;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        r0.setCallback(null);
    L5:
        this.b = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r1) {
        this.A = r1;
        invalidate();
    }

    public final void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setThumbTextPadding(int r1) {
        this.o = r1;
        requestLayout();
    }

    public final void setThumbTintList(@Nullable ColorStateList r1) {
        this.c = r1;
        this.f = true;
        a();
    }

    public final void setThumbTintMode(@Nullable PorterDuff.Mode r1) {
        this.e = r1;
        this.i = true;
        a();
    }

    public final void setTrackDrawable(@Nullable Drawable r3) {
        Drawable r0 = this.j;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        r0.setCallback(null);
    L5:
        this.j = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setTrackTintList(@Nullable ColorStateList r1) {
        this.k = r1;
        this.m = true;
        b();
    }

    public final void setTrackTintMode(@Nullable PorterDuff.Mode r1) {
        this.l = r1;
        this.n = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        if (this.O == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        Intrinsics.f(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.b) goto L10;
        if (r2 == this.j) goto L10;
        return false;
    }
}
