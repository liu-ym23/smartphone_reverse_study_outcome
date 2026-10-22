package com.android.settings.localepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleRecyclerView extends RecyclerView {
    public LocaleRecyclerView(Context r1) {
        super(r1);
    }

    public LocaleRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public LocaleRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 1) goto L8;
        LocaleDragAndDropAdapter r0 = (LocaleDragAndDropAdapter) getAdapter();
        if (r0 == null) goto L8;
        r0.doTheUpdate();
    L8:
        return super.onTouchEvent(r3);
    }
}
