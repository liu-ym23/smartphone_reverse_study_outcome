package com.bytedance.feedbackerlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SupportCustomInterceptLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4675f;

    public interface a {
        boolean a(MotionEvent r1);
    }

    public SupportCustomInterceptLinearLayout(Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        boolean r0 = super.onInterceptTouchEvent(r2);
        a r1 = this.f4675f;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 | r1.a(r2);
    }

    public void setOnInterceptTouchEventListener(a r1) {
        this.f4675f = r1;
    }
}
