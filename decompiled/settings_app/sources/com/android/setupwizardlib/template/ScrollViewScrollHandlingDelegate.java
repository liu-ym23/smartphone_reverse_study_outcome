package com.android.setupwizardlib.template;

import android.util.Log;
import android.widget.ScrollView;
import com.android.setupwizardlib.view.BottomScrollView;

/* JADX INFO: loaded from: classes.dex */
public class ScrollViewScrollHandlingDelegate implements RequireScrollMixin.ScrollHandlingDelegate, BottomScrollView.BottomScrollListener {
    private static final String TAG = "ScrollViewDelegate";
    private final RequireScrollMixin requireScrollMixin;
    private final BottomScrollView scrollView;

    public ScrollViewScrollHandlingDelegate(RequireScrollMixin r2, ScrollView r3) {
        this.requireScrollMixin = r2;
        if ((r3 instanceof BottomScrollView) == false) goto L5;
        this.scrollView = (BottomScrollView) r3;
        return;
    L5:
        Log.w(TAG, "Cannot set non-BottomScrollView. Found=" + r3);
        this.scrollView = null;
    }

    @Override // com.android.setupwizardlib.view.BottomScrollView.BottomScrollListener
    public void onScrolledToBottom() {
        this.requireScrollMixin.notifyScrollabilityChange(false);
    }

    @Override // com.android.setupwizardlib.view.BottomScrollView.BottomScrollListener
    public void onRequiresScroll() {
        this.requireScrollMixin.notifyScrollabilityChange(true);
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void startListening() {
        BottomScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.setBottomScrollListener(this);
        return;
    L5:
        Log.w(TAG, "Cannot require scroll. Scroll view is null.");
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void pageScrollDown() {
        BottomScrollView r1 = this.scrollView;
        if (r1 == null) goto L6;
        r1.pageScroll(130);
        return;
    }
}
