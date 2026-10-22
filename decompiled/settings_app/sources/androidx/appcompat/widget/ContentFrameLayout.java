package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
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

    public ContentFrameLayout(Context r2) {
        this(r2, null);
    }

    public ContentFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ContentFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mDecorPadding = new Rect();
    }

    public void dispatchFitSystemWindows(Rect r1) {
        fitSystemWindows(r1);
    }

    public void setAttachListener(OnAttachListener r1) {
        this.mAttachListener = r1;
    }

    public void setDecorPadding(int r2, int r3, int r4, int r5) {
        this.mDecorPadding.set(r2, r3, r4, r5);
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        requestLayout();
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
        if (r2 != Integer.MIN_VALUE) goto L24;
        if (r1 == false) goto L10;
        TypedValue r10 = this.mFixedWidthMinor;
    L11:
        if (r10 == null) goto L24;
        if (r10.type == 0) goto L24;
        if (r10.type != 5) goto L19;
        float r11 = r10.getDimension(r0);
    L17:
        int r12 = (int) r11;
    L22:
        if (r12 <= 0) goto L24;
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r12 - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize(r14)), 1073741824);
        boolean r13 = true;
    L25:
        if (r5 != Integer.MIN_VALUE) goto L42;
        if (r1 == false) goto L28;
        TypedValue r6 = this.mFixedHeightMajor;
    L29:
        if (r6 == null) goto L42;
        if (r6.type == 0) goto L42;
        if (r6.type != 5) goto L37;
        float r7 = r6.getDimension(r0);
    L35:
        int r8 = (int) r7;
    L40:
        if (r8 <= 0) goto L42;
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r8 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize(r15)), 1073741824);
        goto L42
    L37:
        if (r6.type != 6) goto L39;
        r7 = r6.getFraction(r0.heightPixels, r0.heightPixels);
        goto L35
    L39:
        r8 = 0;
        goto L40
    L28:
        r6 = this.mFixedHeightMinor;
    L42:
        super.onMeasure(r14, r15);
        int r16 = getMeasuredWidth();
        int r9 = View.MeasureSpec.makeMeasureSpec(r16, 1073741824);
        if (r13 == true) goto L63;
        if (r2 != Integer.MIN_VALUE) goto L63;
        if (r1 == false) goto L47;
        TypedValue r4 = this.mMinWidthMinor;
    L48:
        if (r4 == null) goto L63;
        if (r4.type == 0) goto L63;
        if (r4.type != 5) goto L56;
        float r17 = r4.getDimension(r0);
    L54:
        int r18 = (int) r17;
    L59:
        if (r18 <= 0) goto L61;
        r18 = r18 - (this.mDecorPadding.left + this.mDecorPadding.right);
    L61:
        if (r16 >= r18) goto L63;
        r9 = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
    L64:
        if (r3 == false) goto L67;
        super.onMeasure(r9, r15);
        return;
    L67:
        return;
    L56:
        if (r4.type != 6) goto L58;
        r17 = r4.getFraction(r0.widthPixels, r0.widthPixels);
        goto L54
    L58:
        r18 = 0;
        goto L59
    L47:
        r4 = this.mMinWidthMajor;
    L63:
        r3 = false;
        goto L64
    L19:
        if (r10.type != 6) goto L21;
        r11 = r10.getFraction(r0.widthPixels, r0.widthPixels);
        goto L17
    L21:
        r12 = 0;
        goto L22
    L10:
        r10 = this.mFixedWidthMajor;
    L24:
        r13 = false;
        goto L25
    L5:
        r1 = false;
        goto L6
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
}
