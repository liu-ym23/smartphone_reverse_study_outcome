package com.obric.oui.common.widget;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class ClickEffectTouchListener implements View.OnTouchListener {
    private float clickAlpha;
    private float normalAlpha;

    public ClickEffectTouchListener(float r1, float r2) {
        this.clickAlpha = r1;
        this.normalAlpha = r2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        r2.setAlpha(this.clickAlpha);
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r2.setAlpha(this.normalAlpha);
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
