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
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(@NonNull Context r9, @Nullable AttributeSet r10) {
        super(r9, r10);
        this.mLastWidthSize = -1;
        int[] r3 = R.styleable.ButtonBarLayout;
        TypedArray r0 = r9.obtainStyledAttributes(r10, r3);
        ViewCompat.saveAttributeDataForStyleable(this, r9, r3, r10, r0, 0, 0);
        this.mAllowStacking = r0.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        r0.recycle();
        if (getOrientation() != 1) goto L6;
        setStacked(this.mAllowStacking);
        return;
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
        return this.mStacked;
    }

    private void setStacked(boolean r2) {
        if (this.mStacked == r2) goto L20;
        if (r2 == true) goto L6;
    L7:
        this.mStacked = r2;
        setOrientation(r2 ? 1 : 0);
        if (r2 == false) goto L10;
        int r0 = GravityCompat.END;
    L11:
        setGravity(r0);
        View r1 = findViewById(R.id.spacer);
        if (r1 == null) goto L17;
        if (r2 == false) goto L15;
        int r3 = 8;
    L16:
        r1.setVisibility(r3);
        goto L17
    L15:
        r3 = 4;
    L17:
        int r4 = getChildCount() - 2;
    L18:
        if (r4 < 0) goto L23;
        bringChildToFront(getChildAt(r4));
        r4 = r4 - 1;
        goto L18
    L23:
        return;
    L10:
        r0 = 80;
        goto L11
    L6:
        if (this.mAllowStacking == true) goto L7;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getSize(r7);
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
        int r1 = r7;
        boolean r3 = false;
    L16:
        super.onMeasure(r1, r8);
        if (this.mAllowStacking == true) goto L19;
    L26:
        if (r3 == false) goto L28;
        super.onMeasure(r7, r8);
    L28:
        int r4 = getNextVisibleChildIndex(0);
        if (r4 < 0) goto L38;
        View r5 = getChildAt(r4);
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5.getLayoutParams();
        int r9 = (((getPaddingTop() + r5.getMeasuredHeight()) + r6.topMargin) + r6.bottomMargin) + 0;
        if (isStacked() == false) goto L36;
        int r10 = getNextVisibleChildIndex(r4 + 1);
        if (r10 < 0) goto L35;
        r9 = r9 + (getChildAt(r10).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)));
    L35:
        r2 = r9;
        goto L38
    L36:
        r2 = r9 + getPaddingBottom();
    L38:
        if (ViewCompat.getMinimumHeight(this) == r2) goto L43;
        setMinimumHeight(r2);
        if (r8 != 0) goto L44;
        super.onMeasure(r7, r8);
        return;
    L44:
        return;
    L43:
        return;
    L19:
        if (isStacked() == true) goto L26;
        if ((getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) != 16777216) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        setStacked(true);
        r3 = true;
        goto L26
    L23:
        r11 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r7) != 1073741824) goto L15;
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
        if (isStacked() == false) goto L9;
        setStacked(false);
        goto L9
    }
}
