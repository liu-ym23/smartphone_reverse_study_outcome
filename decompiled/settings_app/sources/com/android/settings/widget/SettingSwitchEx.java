package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.android.settings.ToastUtils;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes.dex */
public class SettingSwitchEx extends SwitchEx {
    private int mDisableReasonStringId;

    public SettingSwitchEx(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SettingSwitchEx(Context r1) {
        super(r1);
    }

    public SettingSwitchEx(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setSwitchDisabledTips(int r1) {
        this.mDisableReasonStringId = r1;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (isEnabled() == true) goto L8;
        if (this.mDisableReasonStringId <= 0) goto L8;
        ToastUtils.showInView(getContext(), this.mDisableReasonStringId);
    L8:
        return super.dispatchTouchEvent(r3);
    }
}
