package com.android.setupwizardlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class BottomScrollView extends ScrollView {
    private final Runnable checkScrollRunnable;
    private BottomScrollListener listener;
    private boolean requiringScroll;
    private int scrollThreshold;

    public interface BottomScrollListener {
        void onRequiresScroll();

        void onScrolledToBottom();
    }

    static /* synthetic */ void access$000(BottomScrollView r0) {
        r0.checkScroll();
    }

    public BottomScrollView(Context r1) {
        super(r1);
        this.requiringScroll = false;
        this.checkScrollRunnable = new AnonymousClass1(this);
    }

    public BottomScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.requiringScroll = false;
        this.checkScrollRunnable = new AnonymousClass1(this);
    }

    public BottomScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.requiringScroll = false;
        this.checkScrollRunnable = new AnonymousClass1(this);
    }

    public void setBottomScrollListener(BottomScrollListener r1) {
        this.listener = r1;
    }

    public BottomScrollListener getBottomScrollListener() {
        return this.listener;
    }

    public int getScrollThreshold() {
        return this.scrollThreshold;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        View r6 = getChildAt(0);
        if (r6 == null) goto L6;
        this.scrollThreshold = Math.max(0, ((r6.getMeasuredHeight() - r5) + r3) - getPaddingBottom());
    L6:
        if ((r5 - r3) <= 0) goto L9;
        post(this.checkScrollRunnable);
        return;
    }

    @Override // android.view.View
    protected void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        if (r4 == r2) goto L6;
        checkScroll();
        return;
    }

    private void checkScroll() {
        if (this.listener != null) goto L5;
        return;
    L5:
        if (getScrollY() < this.scrollThreshold) goto L8;
        this.listener.onScrolledToBottom();
        return;
    L8:
        if (this.requiringScroll == true) goto L13;
        this.requiringScroll = true;
        this.listener.onRequiresScroll();
        return;
    }
}
