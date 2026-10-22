package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class CustomListView extends ListView {
    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public CustomListView(Context r1) {
        super(r1);
    }

    public CustomListView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CustomListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
