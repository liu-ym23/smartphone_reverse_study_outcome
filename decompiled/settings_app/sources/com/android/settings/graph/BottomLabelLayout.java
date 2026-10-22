package com.android.settings.graph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class BottomLabelLayout extends LinearLayout {
    private static final String TAG = "BottomLabelLayout";

    public BottomLabelLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        boolean r1 = isStacked();
        boolean r2 = true;
        if (r1 == false) goto L5;
    L7:
        boolean r3 = false;
        int r4 = r6;
    L8:
        super.onMeasure(r4, r7);
        if (r1 == false) goto L11;
    L13:
        r2 = r3;
    L14:
        if (r2 == false) goto L17;
        super.onMeasure(r6, r7);
        return;
    L17:
        return;
    L11:
        if ((getMeasuredWidthAndState() & (-16777216)) != 16777216) goto L13;
        setStacked(true);
        goto L14
    L5:
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L7;
        r4 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
        r3 = true;
        goto L8
    }

    void setStacked(boolean r2) {
        setOrientation(r2 ? 1 : 0);
        if (r2 == false) goto L5;
        int r0 = GravityCompat.START;
    L6:
        setGravity(r0);
        View r1 = findViewById(R.id.spacer);
        if (r1 == null) goto L13;
        if (r2 == false) goto L10;
        int r3 = 8;
    L11:
        r1.setVisibility(r3);
        return;
    L10:
        r3 = 0;
        goto L11
    L13:
        return;
    L5:
        r0 = 80;
        goto L6
    }

    private boolean isStacked() {
        if (getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
