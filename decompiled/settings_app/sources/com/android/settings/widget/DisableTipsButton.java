package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import com.android.settings.ToastUtils;

/* JADX INFO: loaded from: classes.dex */
public class DisableTipsButton extends Button {
    private CharSequence mTips;

    public DisableTipsButton(Context r1) {
        super(r1);
    }

    public DisableTipsButton(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public DisableTipsButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setDisableTips(int r2) {
        this.mTips = getResources().getString(r2);
    }

    public void setDisableTips(CharSequence r1) {
        this.mTips = r1;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 0) goto L8;
        if (isEnabled() == true) goto L8;
        ToastUtils.showInView(getContext(), this.mTips);
    L8:
        return super.onTouchEvent(r3);
    }
}
