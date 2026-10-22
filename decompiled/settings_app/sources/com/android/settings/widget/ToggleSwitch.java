package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Switch;

/* JADX INFO: loaded from: classes.dex */
public class ToggleSwitch extends Switch {
    private OnBeforeCheckedChangeListener mOnBeforeListener;

    public interface OnBeforeCheckedChangeListener {
        boolean onBeforeCheckedChanged(ToggleSwitch r1, boolean r2);
    }

    public ToggleSwitch(Context r1) {
        super(r1);
    }

    public ToggleSwitch(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ToggleSwitch(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public ToggleSwitch(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public void setOnBeforeCheckedChangeListener(OnBeforeCheckedChangeListener r1) {
        this.mOnBeforeListener = r1;
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        OnBeforeCheckedChangeListener r0 = this.mOnBeforeListener;
        if (r0 != null) goto L5;
    L7:
        super.setChecked(r2);
        return;
    L5:
        if (r0.onBeforeCheckedChanged(this, r2) == false) goto L7;
    }

    public void setCheckedInternal(boolean r1) {
        super.setChecked(r1);
    }
}
