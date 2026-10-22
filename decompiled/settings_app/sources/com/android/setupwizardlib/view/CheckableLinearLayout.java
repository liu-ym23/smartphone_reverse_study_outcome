package com.android.setupwizardlib.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class CheckableLinearLayout extends LinearLayout implements Checkable {
    private boolean checked;

    public CheckableLinearLayout(Context r1) {
        super(r1);
        this.checked = false;
        setFocusable(true);
    }

    public CheckableLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.checked = false;
        setFocusable(true);
    }

    public CheckableLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.checked = false;
        setFocusable(true);
    }

    public CheckableLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.checked = false;
        setFocusable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r3) {
        if (this.checked == false) goto L7;
        return mergeDrawableStates(super.onCreateDrawableState(r3 + 1), new int[]{R.attr.state_checked});
    L7:
        return super.onCreateDrawableState(r3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.checked = r1;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
