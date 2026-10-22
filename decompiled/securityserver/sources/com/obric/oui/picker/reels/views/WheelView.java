package com.obric.oui.picker.reels.views;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OUISoundEffectHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WheelView extends View {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean b;
    public int c;
    public int e;
    public int f;
    public int i;
    public int j;
    public Rect k;
    public Rect l;
    public Rect m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final ArrayList t;
    public CharSequence u;
    public Integer v;
    public float w;
    public int x;
    public boolean y;
    public boolean z;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public WheelView(@NotNull final Context r24, @Nullable AttributeSet r25) {
        Intrinsics.f(r24, "context");
        super(r24, r25);
        this.e = 5;
        float r3 = 343;
        this.f = a.d("Resources.getSystem()", 1, r3);
        float r6 = 40;
        this.i = a.d("Resources.getSystem()", 1, r6);
        this.j = a.d("Resources.getSystem()", 1, 48);
        this.n = LazyKt.b(WheelView$mTextPaint$2.b);
        this.o = LazyKt.b(WheelView$mTagTextPaint$2.b);
        this.p = LazyKt.b(WheelView$mSelectedTextPaint$2.b);
        this.q = LazyKt.b(WheelView$mDividerPaint$2.b);
        this.r = LazyKt.b(WheelView$mHighlightPaint$2.b);
        this.s = LazyKt.b(new WheelView$mScroller$2(r24, this));
        this.t = new ArrayList();
        float r8 = 8;
        this.x = a.d("Resources.getSystem()", 1, r8);
        TypedArray r9 = r24.obtainStyledAttributes(r25, R.styleable.v);
        Intrinsics.e(r9, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r11 = r9.getBoolean(0, false);
        int r12 = r9.getInt(10, 0);
        boolean r13 = r9.getBoolean(9, false);
        int r14 = r9.getInt(4, 5);
        Resources r15 = Resources.getSystem();
        Intrinsics.e(r15, "Resources.getSystem()");
        int r4 = r9.getDimensionPixelOffset(6, MathKt.a(TypedValue.applyDimension(1, r3, r15.getDisplayMetrics())));
        Resources r16 = Resources.getSystem();
        Intrinsics.e(r16, "Resources.getSystem()");
        int r2 = r9.getDimensionPixelOffset(5, MathKt.a(TypedValue.applyDimension(1, r6, r16.getDisplayMetrics())));
        Resources r10 = Resources.getSystem();
        Intrinsics.e(r10, "Resources.getSystem()");
        int r17 = r9.getDimensionPixelSize(12, MathKt.a(TypedValue.applyDimension(2, 18, r10.getDisplayMetrics())));
        Resources r18 = Resources.getSystem();
        Intrinsics.e(r18, "Resources.getSystem()");
        int r7 = r9.getDimensionPixelSize(12, MathKt.a(TypedValue.applyDimension(2, 14, r18.getDisplayMetrics())));
        int r5 = r9.getColor(11, ContextCompat.getColor(r24, com.bytedance.securityserver.R.color.oui_basic_text_1));
        int r19 = r9.getColor(7, ContextCompat.getColor(r24, com.bytedance.securityserver.R.color.oui_accent_6_bg));
        Resources r20 = Resources.getSystem();
        Intrinsics.e(r20, "Resources.getSystem()");
        int r21 = r9.getDimensionPixelSize(8, MathKt.a(TypedValue.applyDimension(2, 22, r20.getDisplayMetrics())));
        int r22 = r9.getColor(2, ContextCompat.getColor(r24, com.bytedance.securityserver.R.color.oui_fill_element_2));
        Resources r110 = Resources.getSystem();
        Intrinsics.e(r110, "Resources.getSystem()");
        int r23 = r9.getDimensionPixelOffset(3, MathKt.a(TypedValue.applyDimension(1, r8, r110.getDisplayMetrics())));
        CharSequence[] r111 = r9.getTextArray(1);
        if (r111 == null) goto L7;
        ArrayList r26 = new ArrayList(r111.length);
        int r1 = r111.length;
        int r27 = 0;
    L5:
        if (r27 >= r1) goto L8;
        CharSequence r28 = r111[r27];
        r27 = r27 + 1;
        r26.add(r28.toString());
        r1 = r1;
    L8:
        r9.recycle();
        setCyclic(r11);
        setShowDivider(r13);
        setStartIndex(r12);
        setItemCount(r14);
        setItemWidthPx(r4);
        setItemHeightPx(r2);
        setHighlightConorRadiusPx(r23);
        TextPaint r29 = getMTextPaint();
        Paint.Align r30 = Paint.Align.CENTER;
        r29.setTextAlign(r30);
        r29.setTextSize(r17);
        r29.setColor(r5);
        r29.setTypeface(Typeface.create(null, 400, false));
        TextPaint r31 = getMTagTextPaint();
        r31.setTextAlign(Paint.Align.LEFT);
        r31.setTextSize(r7);
        r31.setColor(r5);
        r31.setTypeface(Typeface.create(null, 480, false));
        TextPaint r32 = getMSelectedTextPaint();
        r32.setTextAlign(r30);
        r32.setTextSize(r21);
        r32.setColor(r19);
        r32.setTypeface(Typeface.create(null, 500, false));
        Paint r33 = getMDividerPaint();
        Resources r34 = Resources.getSystem();
        Intrinsics.e(r34, "Resources.getSystem()");
        r33.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, r34.getDisplayMetrics()));
        r33.setColor(ContextCompat.getColor(r24, com.bytedance.securityserver.R.color.LinePrimary));
        Paint r35 = getMHighlightPaint();
        r35.setStyle(Paint.Style.FILL);
        r35.setColor(r22);
        if (r26 != null) goto L11;
    L14:
        setVerticalFadingEdgeEnabled(true);
        Resources r36 = Resources.getSystem();
        Intrinsics.e(r36, "Resources.getSystem()");
        setFadingEdgeLength(MathKt.a(TypedValue.applyDimension(1, r6, r36.getDisplayMetrics())));
        return;
    L11:
        if (r26.isEmpty() == true) goto L14;
        setEntries(r26);
        goto L14
    L7:
        r26 = null;
        goto L8
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.q.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.r.getValue();
    }

    private final WheelScroller getMScroller() {
        return (WheelScroller) this.s.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.p.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.o.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.n.getValue();
    }

    private final int getWheelHeight() {
        return (((this.e - 1) * this.i) + (getPaddingBottom() + getPaddingTop())) + this.j;
    }

    private final int getWheelWidth() {
        int r0 = getPaddingLeft();
        return (getPaddingRight() + r0) + this.f;
    }

    @Override // android.view.View
    public final void computeScroll() {
        WheelScroller r2 = getMScroller();
        if (r2.c == false) goto L9;
        r2.c = r2.computeScrollOffset();
        r2.a(r2.getCurrY() - r2.f260a, "computeScroll");
        if (r2.c == false) goto L7;
        r2.h.postInvalidate();
        return;
    L7:
        WheelScroller.c(r2);
        return;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    public final int getClipMiddleRectBottom() {
        Rect r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.top;
    }

    public final int getCurrentIndex() {
        return getMScroller().b();
    }

    @Nullable
    public final String getCurrentItem() {
        int r0 = getCurrentIndex();
        ArrayList r2 = this.t;
        if (r0 >= 0) goto L8;
        if (r0 < r2.size()) goto L8;
        return null;
    L8:
        return (String) r2.get(r0);
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final int getHighlightConorRadiusPx() {
        return this.x;
    }

    public final int getItemCount() {
        return this.e;
    }

    public final int getItemHeightPx() {
        return this.i;
    }

    public final int getItemSize() {
        return this.t.size();
    }

    public final int getItemWidthPx() {
        return this.f;
    }

    @Nullable
    public final OnWheelChangedListener getOnWheelChangedListener() {
        return getMScroller().f;
    }

    public final int getSelectedItemHeightPx() {
        return this.j;
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final boolean getShowBottomLeftCorner() {
        return this.B;
    }

    public final boolean getShowBottomRightCorner() {
        return this.C;
    }

    public final boolean getShowDivider() {
        return this.b;
    }

    public final boolean getShowTopLeftCorner() {
        return this.z;
    }

    public final boolean getShowTopRightCorner() {
        return this.A;
    }

    public final int getStartIndex() {
        return this.c;
    }

    @Nullable
    public final Integer getTagGap() {
        return this.v;
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WheelScroller r0 = getMScroller();
        Context r2 = getContext();
        Intrinsics.e(r2, "context");
        r0.getClass();
        OUISoundEffectHelper.b(r2, new int[]{com.bytedance.securityserver.R.raw.reel_picker});
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.f(r20, "canvas");
        WheelScroller r1 = getMScroller();
        WheelView r2 = r1.h;
        int r9 = 0;
        if (r2.getItemHeightPx() != 0) goto L5;
        int r3 = 0;
    L6:
        WheelScroller r4 = getMScroller();
        WheelView r5 = r4.h;
        if (r5.getItemHeightPx() != 0) goto L9;
        int r10 = 0;
    L10:
        int r12 = 2;
        int r6 = (this.e + 1) / 2;
        if (r10 >= 0) goto L15;
        int r7 = (r3 - r6) - 1;
    L13:
        int r8 = r3 + r6;
    L14:
        int r13 = r8;
        int r14 = r7;
    L19:
        if (r14 >= r13) goto L62;
        ArrayList r11 = this.t;
        int r15 = r11.size();
        String r16 = null;
        if (r15 != 0) goto L24;
    L22:
        String r17 = r16;
        if (r17 == null) goto L60;
        Rect r18 = this.l;
        Intrinsics.c(r18);
        int r19 = r18.centerX();
        Rect r21 = this.l;
        Intrinsics.c(r21);
        int r22 = r21.centerY();
        Paint.FontMetrics r23 = getMTextPaint().getFontMetrics();
        float r24 = r23.top + r23.bottom;
        float r25 = r12;
        int r26 = (int) (r24 / r25);
        Paint.FontMetrics r27 = getMSelectedTextPaint().getFontMetrics();
        int r28 = (int) ((r27.top + r27.bottom) / r25);
        WheelScroller r29 = getMScroller();
        WheelView r30 = r29.h;
        if (r30.getItemHeightPx() != 0) goto L37;
        int r31 = r9;
    L38:
        int r32 = this.i;
        int r33 = ((r14 - r31) * r32) - r10;
        float r34 = (this.j - r32) / 2.0f;
        if (r34 > r9) goto L41;
        float r35 = r33;
    L45:
        int r36 = this.i;
        if (1 > r33) goto L50;
        if (r36 <= r33) goto L50;
        r20.save();
        Rect r37 = this.l;
        Intrinsics.c(r37);
        r20.clipRect(r37);
        float r110 = r19;
        float r111 = r22 + r35;
        r20.drawText(r17, 0, r17.length(), r110, r111 - r28, getMSelectedTextPaint());
        r20.restore();
        r20.save();
        Rect r38 = this.m;
        Intrinsics.c(r38);
        r20.clipRect(r38);
        r20.drawText(r17, 0, r17.length(), r110, r111 - r26, getMTextPaint());
        r20.restore();
    L50:
        if (r33 < r36) goto L52;
        r20.save();
        Rect r39 = this.m;
        Intrinsics.c(r39);
        r20.clipRect(r39);
        r20.drawText(r17, 0, r17.length(), r19, (r22 + r35) - r26, getMTextPaint());
        r20.restore();
        goto L60
    L52:
        if (r33 >= 0) goto L57;
        if (r33 <= (-r36)) goto L57;
        r20.save();
        Rect r40 = this.l;
        Intrinsics.c(r40);
        r20.clipRect(r40);
        float r112 = r19;
        float r113 = r22 + r35;
        r20.drawText(r17, 0, r17.length(), r112, r113 - r28, getMSelectedTextPaint());
        r20.restore();
        r20.save();
        Rect r41 = this.k;
        Intrinsics.c(r41);
        r20.clipRect(r41);
        r20.drawText(r17, 0, r17.length(), r112, r113 - r26, getMTextPaint());
        r20.restore();
    L57:
        if (r33 > (-r36)) goto L59;
        r20.save();
        Rect r42 = this.k;
        Intrinsics.c(r42);
        r20.clipRect(r42);
        r20.drawText(r17, 0, r17.length(), r19, (r22 + r35) - r26, getMTextPaint());
        r20.restore();
        goto L60
    L59:
        r20.save();
        Rect r43 = this.l;
        Intrinsics.c(r43);
        r20.clipRect(r43);
        r20.drawText(r17, 0, r17.length(), r19, (r22 + r35) - r28, getMSelectedTextPaint());
        r20.restore();
        goto L60
    L41:
        float r44 = r32;
        if (Math.abs(r33) > r44) goto L44;
        r35 = ((r34 / r44) + 1.0f) * r33;
        goto L45
    L44:
        float r45 = r33;
        r35 = (Math.signum(r45) * r34) + r45;
        goto L45
    L37:
        r31 = r29.f260a / r30.getItemHeightPx();
    L60:
        r14 = r14 + 1;
        r9 = 0;
        r12 = 2;
        goto L19
    L24:
        if (this.y == false) goto L29;
        int r46 = r14 % r15;
        if (r46 >= 0) goto L28;
        r46 = r46 + r15;
    L28:
        r16 = (String) r11.get(r46);
        goto L22
    L29:
        if (r14 < 0) goto L22;
        if (r15 <= r14) goto L22;
        r16 = (String) r11.get(r14);
        goto L22
    L62:
        if (this.b == false) goto L67;
        Rect r47 = this.l;
        if (r47 == null) goto L67;
        float r48 = r47.left;
        float r49 = r47.top;
        r20.drawLine(r48, r49, r47.right, r49, getMDividerPaint());
        float r50 = r47.left;
        float r51 = r47.bottom;
        r20.drawLine(r50, r51, r47.right, r51, getMDividerPaint());
    L67:
        CharSequence r52 = this.u;
        if (r52 == null) goto L82;
        Rect r53 = this.l;
        Intrinsics.c(r53);
        int r54 = r53.centerY();
        Rect r55 = this.l;
        Intrinsics.c(r55);
        int r56 = r55.centerX();
        Paint.FontMetrics r57 = getMTagTextPaint().getFontMetrics();
        float r58 = r57.top + r57.bottom;
        float r59 = 2;
        int r60 = (int) (r58 / r59);
        Integer r61 = this.v;
        if (r61 == null) goto L72;
        int r62 = r61.intValue();
    L73:
        r20.drawText(r52, 0, r52.length(), ((this.w / r59) + r56) + r62, r54 - r60, getMTagTextPaint());
        return;
    L72:
        r62 = a.d("Resources.getSystem()", 1, r59);
        goto L73
    L82:
        return;
    L15:
        if (r10 <= 0) goto L17;
        r7 = r3 - r6;
        r8 = (r3 + r6) + 1;
        goto L14
    L17:
        r7 = r3 - r6;
        goto L13
    L9:
        r10 = r4.f260a % r5.getItemHeightPx();
        goto L10
    L5:
        r3 = r1.f260a / r2.getItemHeightPx();
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        int r1 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        float r2 = this.w;
        if (this.u == null) goto L9;
        float r3 = getMTagTextPaint().measureText(String.valueOf(this.u));
        Integer r7 = this.v;
        if (r7 == null) goto L7;
        int r8 = r7.intValue();
    L8:
        float r4 = (2 * ((r8 + r3) + a.d("Resources.getSystem()", 1, 16))) + r2;
    L10:
        int r5 = Math.max((int) r4, getMinimumWidth());
        if (r0 == Integer.MIN_VALUE) goto L14;
        if (r0 == 1073741824) goto L15;
        r11 = r5;
    L15:
        if (r1 == 1073741824) goto L18;
        r12 = getWheelHeight();
    L18:
        setMeasuredDimension(r11, r12);
        int r13 = getPaddingLeft();
        int r14 = getMeasuredWidth() - getPaddingRight();
        int r6 = getPaddingTop();
        int r15 = getMeasuredHeight() - getPaddingBottom();
        int r16 = (r6 + r15) / 2;
        Rect r17 = new Rect();
        r17.left = r13;
        r17.right = r14;
        int r18 = this.j / 2;
        r17.top = r16 - r18;
        r17.bottom = r18 + r16;
        this.l = r17;
        Rect r19 = new Rect();
        r19.left = r13;
        r19.right = r14;
        r19.top = r6;
        r19.bottom = r16 - (this.j / 2);
        this.k = r19;
        Rect r20 = new Rect();
        r20.left = r13;
        r20.right = r14;
        r20.top = (this.j / 2) + r16;
        r20.bottom = r15;
        this.m = r20;
        return;
    L14:
        r11 = Math.min(r5, r11);
        goto L15
    L7:
        r8 = a.d("Resources.getSystem()", 1, 2);
        goto L8
    L9:
        r4 = a.d("Resources.getSystem()", 1, 28) + r2;
        goto L10
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r12) {
        Intrinsics.f(r12, "event");
        WheelScroller r11 = getMScroller();
        r11.getClass();
        if (r11.f261d != null) goto L5;
        r11.f261d = VelocityTracker.obtain();
    L5:
        VelocityTracker r0 = r11.f261d;
        if (r0 == null) goto L8;
        r0.addMovement(r12);
    L8:
        int r1 = r12.getAction();
        WheelView r9 = r11.h;
        if (r1 != 0) goto L11;
        ViewParent r2 = r9.getParent();
        if (r2 == null) goto L58;
        r2.requestDisallowInterceptTouchEvent(true);
    L58:
        r11.b = r12.getY();
        r11.forceFinished(true);
        r11.e = false;
        r11.c = false;
    L59:
        return true;
    L11:
        if (r1 == 1) goto L29;
        if (r1 != 2) goto L14;
        float r13 = r12.getY();
        int r3 = (int) (r13 - r11.b);
        if (r3 == 0) goto L28;
        r11.e = true;
        r11.a(-r3, "touchEvent");
        r9.invalidate();
    L28:
        r11.b = r13;
        goto L59
    L14:
        if (r1 != 3) goto L59;
        if (r11.e == false) goto L19;
        WheelScroller.c(r11);
    L19:
        VelocityTracker r14 = r11.f261d;
        if (r14 == null) goto L22;
        r14.recycle();
    L22:
        r11.f261d = null;
        r11.e = false;
        ViewParent r15 = r9.getParent();
        if (r15 == null) goto L59;
        r15.requestDisallowInterceptTouchEvent(false);
        goto L59
    L29:
        VelocityTracker r4 = r11.f261d;
        if (r4 == null) goto L32;
        r4.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r5 = r11.f261d;
        if (r5 == null) goto L35;
        float r6 = r5.getYVelocity();
    L37:
        if (Math.abs(r6) <= 0) goto L44;
        int r7 = r9.getItemHeightPx() * (r9.getItemSize() - 1);
        r9.getItemHeightPx();
        r11.c = true;
        if (r9.y == false) goto L41;
        ScrollerExt.b(r11, r9.getItemHeightPx(), r11.f260a, ((int) (-r6)) / 2, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    L42:
        r9.invalidate();
    L49:
        VelocityTracker r16 = r11.f261d;
        if (r16 == null) goto L52;
        r16.recycle();
    L52:
        r11.f261d = null;
        ViewParent r17 = r9.getParent();
        if (r17 == null) goto L59;
        r17.requestDisallowInterceptTouchEvent(false);
        goto L59
    L41:
        ScrollerExt.b(r11, r9.getItemHeightPx(), r11.f260a, ((int) (-r6)) / 2, 0, r7);
        goto L42
    L44:
        if (r11.e == true) goto L48;
        float r18 = r12.getY() - (r9.getHeight() / 2.0f);
        if (Math.abs(r18) <= 1) goto L49;
        r11.c = true;
        r11.f(r11.f260a, (int) r18, 200, "ACTION_UP");
        r9.invalidate();
        goto L49
    L48:
        WheelScroller.c(r11);
        goto L49
    L35:
        r6 = 0.0f;
        goto L37
    }

    public final void setCurrentIndex(int r2) {
        getMScroller().e(r2, false);
    }

    public final void setCyclic(boolean r2) {
        this.y = r2;
        WheelScroller r3 = getMScroller();
        r3.c = false;
        r3.f260a = 0;
        r3.g = -1;
        r3.d("reset");
        r3.forceFinished(true);
        invalidate();
    }

    public final void setEntries(@NotNull String... r2) {
        Intrinsics.f(r2, "entries");
        setEntries(ArraysKt.u(r2));
    }

    public final void setHighlightColor(int r2) {
        getMHighlightPaint().setColor(r2);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.x = r1;
        invalidate();
    }

    public final void setItemCount(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setItemHeightPx(int r1) {
        this.i = r1;
        invalidate();
    }

    public final void setItemWidthPx(int r1) {
        this.f = r1;
        invalidate();
    }

    public final void setOnWheelChangedListener(@Nullable OnWheelChangedListener r1) {
        getMScroller().f = r1;
    }

    public final void setSelectedItemHeightPx(int r1) {
        this.j = r1;
        invalidate();
    }

    public final void setSelectedTextColor(int r2) {
        getMSelectedTextPaint().setColor(r2);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r2) {
        getMSelectedTextPaint().setTextSize(r2);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r1) {
        this.B = r1;
    }

    public final void setShowBottomRightCorner(boolean r1) {
        this.C = r1;
    }

    public final void setShowDivider(boolean r1) {
        this.b = r1;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r1) {
        this.z = r1;
    }

    public final void setShowTopRightCorner(boolean r1) {
        this.A = r1;
    }

    public final void setStartIndex(int r2) {
        this.c = r2;
        getMScroller().e(r2, false);
    }

    public final void setTagGap(@Nullable Integer r1) {
        this.v = r1;
        invalidate();
    }

    public final void setTagText(@NotNull CharSequence r2) {
        Intrinsics.f(r2, "tag");
        if ((!StringsKt.t(r2)) == false) goto L6;
        this.u = r2;
        invalidate();
        return;
    }

    public final void setTextColor(int r2) {
        getMTextPaint().setColor(r2);
        invalidate();
    }

    public final void setTextSizePx(float r2) {
        getMTextPaint().setTextSize(r2);
        invalidate();
    }

    public final void setEntries(@Nullable List<String> r3) {
        ArrayList r0 = this.t;
        r0.clear();
        this.w = 0.0f;
        if (r3 != null) goto L5;
    L11:
        WheelScroller r4 = getMScroller();
        r4.c = false;
        r4.f260a = 0;
        r4.g = -1;
        r4.d("reset");
        r4.forceFinished(true);
        int r5 = this.c;
        getMScroller().e(r5, false);
        requestLayout();
        return;
    L5:
        if (r3.isEmpty() == true) goto L11;
        r0.addAll(r3);
        Iterator r6 = r0.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        String r1 = (String) r6.next();
        float r2 = getMSelectedTextPaint().measureText(r1);
        this.w = Math.max(this.w, r2);
        goto L9
    }
}
