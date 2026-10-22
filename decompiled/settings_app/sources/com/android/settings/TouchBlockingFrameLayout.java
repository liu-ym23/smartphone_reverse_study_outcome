package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TouchBlockingFrameLayout extends FrameLayout {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    public TouchBlockingFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
