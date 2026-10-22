package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private int mMinimumHeight;

    public ButtonBarLayout(@NonNull Context r9, @Nullable AttributeSet r10) {
        super(r9, r10);
        this.mLastWidthSize = -1;
        this.mMinimumHeight = 0;
        TypedArray r0 = r9.obtainStyledAttributes(r10, R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, r9, R.styleable.ButtonBarLayout, r10, r0, 0, 0);
        this.mAllowStacking = r0.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        r0.recycle();
    }

    private int getNextVisibleChildIndex(int r3) {
        int r0 = getChildCount();
    L3:
        if (r3 >= r0) goto L8;
        if (getChildAt(r3).getVisibility() == 0) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return -1;
    }

    private boolean isStacked() {
        if (getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setStacked(boolean r2) {
        setOrientation(r2 ? 1 : 0);
        if (r2 == false) goto L5;
        int r0 = 5;
    L6:
        setGravity(r0);
        View r1 = findViewById(R.id.spacer);
        if (r1 == null) goto L12;
        if (r2 == false) goto L10;
        int r3 = 8;
    L11:
        r1.setVisibility(r3);
        goto L12
    L10:
        r3 = 4;
    L12:
        int r4 = getChildCount() - 2;
    L13:
        if (r4 < 0) goto L15;
        bringChildToFront(getChildAt(r4));
        r4 = r4 - 1;
        goto L13
    L15:
        return;
    L5:
        r0 = 80;
        goto L6
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.mMinimumHeight, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        int r2 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r0 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r0;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r1 = r6;
        boolean r3 = false;
    L16:
        super.onMeasure(r1, r7);
        if (this.mAllowStacking == true) goto L19;
    L23:
        if (r3 == false) goto L25;
        super.onMeasure(r6, r7);
    L25:
        int r8 = getNextVisibleChildIndex(0);
        if (r8 < 0) goto L35;
        View r9 = getChildAt(r8);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r9.getLayoutParams();
        int r10 = ((r9.getMeasuredHeight() + getPaddingTop()) + r4.topMargin) + r4.bottomMargin;
        if (isStacked() == false) goto L33;
        int r11 = getNextVisibleChildIndex(r8 + 1);
        if (r11 < 0) goto L32;
        r2 = (getChildAt(r11).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f))) + r10;
        goto L35
    L32:
        r2 = r10;
        goto L35
    L33:
        r2 = getPaddingBottom() + r10;
    L35:
        if (ViewCompat.getMinimumHeight(this) == r2) goto L38;
        setMinimumHeight(r2);
        return;
    L38:
        return;
    L19:
        if (isStacked() == true) goto L23;
        if ((getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) != 16777216) goto L23;
        setStacked(true);
        r3 = true;
        goto L23
    L13:
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L15;
        r1 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
        r3 = true;
        goto L16
    }

    public void setAllowStacking(boolean r2) {
        if (this.mAllowStacking == r2) goto L11;
        this.mAllowStacking = r2;
        if (r2 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (getOrientation() != 1) goto L9;
        setStacked(false);
        goto L9
    }
}
