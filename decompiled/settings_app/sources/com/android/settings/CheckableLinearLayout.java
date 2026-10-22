package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableLinearLayout extends LinearLayout implements Checkable {
    private boolean mChecked;
    private float mDisabledAlpha;

    public CheckableLinearLayout(Context r3, AttributeSet r4) {
        super(r3, r4);
        TypedValue r5 = new TypedValue();
        r3.getTheme().resolveAttribute(android.R.attr.disabledAlpha, r5, true);
        this.mDisabledAlpha = r5.getFloat();
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        if (r5 == false) goto L7;
        float r3 = 1.0f;
    L8:
        r2.setAlpha(r3);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = this.mDisabledAlpha;
        goto L8
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.mChecked = r1;
        updateChecked();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    private void updateChecked() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        KeyEvent.Callback r2 = getChildAt(r1);
        if ((r2 instanceof Checkable) == false) goto L7;
        ((Checkable) r2).setChecked(this.mChecked);
    L7:
        r1 = r1 + 1;
        goto L3
    }
}
