package com.bytedanceos.cleaner.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
public class OperateButton extends Button {
    public OperateButton(Context context) {
        super(context);
    }

    public OperateButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OperateButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Drawable r0 = getBackground();
        if (enabled == false) goto L5;
        int r1 = 255;
    L6:
        r0.setAlpha(r1);
        return;
    L5:
        r1 = 127;
        goto L6
    }
}
