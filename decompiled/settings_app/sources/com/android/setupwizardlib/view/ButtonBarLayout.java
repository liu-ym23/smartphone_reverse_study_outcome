package com.android.setupwizardlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    private int originalPaddingLeft;
    private int originalPaddingRight;
    private boolean stacked;

    public ButtonBarLayout(Context r1) {
        super(r1);
        this.stacked = false;
    }

    public ButtonBarLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.stacked = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        setStacked(false);
        boolean r4 = true;
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L5;
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        boolean r2 = true;
    L6:
        super.onMeasure(r1, r7);
        if (getMeasuredWidth() <= r0) goto L9;
        setStacked(true);
    L10:
        if (r4 == false) goto L13;
        super.onMeasure(r6, r7);
        return;
    L13:
        return;
    L9:
        r4 = r2;
        goto L10
    L5:
        r2 = false;
        r1 = r6;
        goto L6
    }

    private void setStacked(boolean r7) {
        if (this.stacked != r7) goto L5;
        return;
    L5:
        this.stacked = r7;
        int r0 = getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        View r2 = getChildAt(r1);
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2.getLayoutParams();
        if (r7 == false) goto L10;
        r2.setTag(R.id.suw_original_weight, Float.valueOf(r3.weight));
        r3.weight = 0.0f;
    L13:
        r2.setLayoutParams(r3);
        r1 = r1 + 1;
        goto L6
    L10:
        Float r4 = (Float) r2.getTag(R.id.suw_original_weight);
        if (r4 == null) goto L13;
        r3.weight = r4.floatValue();
        goto L13
    L14:
        setOrientation(r7 ? 1 : 0);
        int r5 = r0 - 1;
    L15:
        if (r5 < 0) goto L17;
        bringChildToFront(getChildAt(r5));
        r5 = r5 - 1;
        goto L15
    L17:
        if (r7 == false) goto L19;
        this.originalPaddingLeft = getPaddingLeft();
        int r8 = getPaddingRight();
        this.originalPaddingRight = r8;
        int r9 = Math.max(this.originalPaddingLeft, r8);
        setPadding(r9, getPaddingTop(), r9, getPaddingBottom());
        return;
    L19:
        setPadding(this.originalPaddingLeft, getPaddingTop(), this.originalPaddingRight, getPaddingBottom());
    }
}
