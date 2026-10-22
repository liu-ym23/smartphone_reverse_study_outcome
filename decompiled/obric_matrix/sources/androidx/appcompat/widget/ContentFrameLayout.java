package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public ContentFrameLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ContentFrameLayout(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mDecorPadding = new Rect();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void dispatchFitSystemWindows(Rect r1) {
        fitSystemWindows(r1);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor != null) goto L6;
        this.mFixedHeightMajor = new TypedValue();
    L6:
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor != null) goto L6;
        this.mFixedHeightMinor = new TypedValue();
    L6:
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor != null) goto L6;
        this.mFixedWidthMajor = new TypedValue();
    L6:
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor != null) goto L6;
        this.mFixedWidthMinor = new TypedValue();
    L6:
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor != null) goto L6;
        this.mMinWidthMajor = new TypedValue();
    L6:
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor != null) goto L6;
        this.mMinWidthMinor = new TypedValue();
    L6:
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener r0 = this.mAttachListener;
        if (r0 == null) goto L6;
        r0.onAttachedFromWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener r0 = this.mAttachListener;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r14, int r15) {
        DisplayMetrics r0 = getContext().getResources().getDisplayMetrics();
        boolean r3 = true;
        if (r0.widthPixels >= r0.heightPixels) goto L5;
        boolean r1 = true;
    L6:
        int r2 = View.MeasureSpec.getMode(r14);
        int r5 = View.MeasureSpec.getMode(r15);
        if (r2 != Integer.MIN_VALUE) goto L22;
        if (r1 == false) goto L10;
        TypedValue r10 = this.mFixedWidthMinor;
    L11:
        if (r10 == null) goto L22;
        int r11 = r10.type;
        if (r11 == 0) goto L22;
        if (r11 != 5) goto L17;
        float r12 = r10.getDimension(r0);
    L16:
        int r13 = (int) r12;
    L20:
        if (r13 <= 0) goto L22;
        Rect r16 = this.mDecorPadding;
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r13 - (r16.left + r16.right), View.MeasureSpec.getSize(r14)), BasicMeasure.EXACTLY);
        boolean r17 = true;
    L23:
        if (r5 != Integer.MIN_VALUE) goto L38;
        if (r1 == false) goto L26;
        TypedValue r6 = this.mFixedHeightMajor;
    L27:
        if (r6 == null) goto L38;
        int r18 = r6.type;
        if (r18 == 0) goto L38;
        if (r18 != 5) goto L33;
        float r7 = r6.getDimension(r0);
    L32:
        int r8 = (int) r7;
    L36:
        if (r8 <= 0) goto L38;
        Rect r19 = this.mDecorPadding;
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r8 - (r19.top + r19.bottom), View.MeasureSpec.getSize(r15)), BasicMeasure.EXACTLY);
        goto L38
    L33:
        if (r18 != 6) goto L35;
        int r110 = r0.heightPixels;
        r7 = r6.getFraction(r110, r110);
        goto L32
    L35:
        r8 = 0;
        goto L36
    L26:
        r6 = this.mFixedHeightMinor;
    L38:
        super.onMeasure(r14, r15);
        int r111 = getMeasuredWidth();
        int r9 = View.MeasureSpec.makeMeasureSpec(r111, BasicMeasure.EXACTLY);
        if (r17 == true) goto L57;
        if (r2 != Integer.MIN_VALUE) goto L57;
        if (r1 == false) goto L43;
        TypedValue r4 = this.mMinWidthMinor;
    L44:
        if (r4 == null) goto L57;
        int r20 = r4.type;
        if (r20 == 0) goto L57;
        if (r20 != 5) goto L50;
        float r21 = r4.getDimension(r0);
    L49:
        int r22 = (int) r21;
    L53:
        if (r22 <= 0) goto L55;
        Rect r23 = this.mDecorPadding;
        r22 = r22 - (r23.left + r23.right);
    L55:
        if (r111 >= r22) goto L57;
        r9 = View.MeasureSpec.makeMeasureSpec(r22, BasicMeasure.EXACTLY);
    L58:
        if (r3 == false) goto L61;
        super.onMeasure(r9, r15);
        return;
    L61:
        return;
    L50:
        if (r20 != 6) goto L52;
        int r24 = r0.widthPixels;
        r21 = r4.getFraction(r24, r24);
        goto L49
    L52:
        r22 = 0;
        goto L53
    L43:
        r4 = this.mMinWidthMajor;
    L57:
        r3 = false;
        goto L58
    L17:
        if (r11 != 6) goto L19;
        int r112 = r0.widthPixels;
        r12 = r10.getFraction(r112, r112);
        goto L16
    L19:
        r13 = 0;
        goto L20
    L10:
        r10 = this.mFixedWidthMajor;
    L22:
        r17 = false;
        goto L23
    L5:
        r1 = false;
        goto L6
    }

    public void setAttachListener(OnAttachListener r1) {
        this.mAttachListener = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDecorPadding(int r2, int r3, int r4, int r5) {
        this.mDecorPadding.set(r2, r3, r4, r5);
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        requestLayout();
        return;
    }
}
