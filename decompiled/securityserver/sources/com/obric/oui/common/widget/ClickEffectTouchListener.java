package com.obric.oui.common.widget;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ClickEffectTouchListener implements View.OnTouchListener {
    public float b;
    public float c;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        r2.setAlpha(this.b);
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r2.setAlpha(this.c);
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
