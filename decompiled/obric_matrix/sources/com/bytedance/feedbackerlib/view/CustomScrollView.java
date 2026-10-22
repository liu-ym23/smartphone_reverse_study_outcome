package com.bytedance.feedbackerlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class CustomScrollView extends ScrollView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4666f;

    public interface a {
        boolean a(MotionEvent r1);
    }

    public CustomScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        boolean r0 = super.onInterceptTouchEvent(r2);
        a r1 = this.f4666f;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 | r1.a(r2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public void setOnInterceptTouchEventListener(a r1) {
        this.f4666f = r1;
    }
}
