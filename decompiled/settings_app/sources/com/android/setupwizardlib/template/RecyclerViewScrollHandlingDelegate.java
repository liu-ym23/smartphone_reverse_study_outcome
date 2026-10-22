package com.android.setupwizardlib.template;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewScrollHandlingDelegate implements RequireScrollMixin.ScrollHandlingDelegate {
    private static final String TAG = "RVRequireScrollMixin";
    private final RecyclerView recyclerView;
    private final RequireScrollMixin requireScrollMixin;

    static /* synthetic */ boolean access$000(RecyclerViewScrollHandlingDelegate r0) {
        return r0.canScrollDown();
    }

    static /* synthetic */ RequireScrollMixin access$100(RecyclerViewScrollHandlingDelegate r0) {
        return r0.requireScrollMixin;
    }

    public RecyclerViewScrollHandlingDelegate(RequireScrollMixin r1, RecyclerView r2) {
        this.requireScrollMixin = r1;
        this.recyclerView = r2;
    }

    private boolean canScrollDown() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L10;
        int r1 = r0.computeVerticalScrollOffset();
        int r2 = this.recyclerView.computeVerticalScrollRange() - this.recyclerView.computeVerticalScrollExtent();
        if (r2 != 0) goto L7;
        return false;
    L7:
        if (r1 < (r2 - 1)) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void startListening() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L7;
        r0.addOnScrollListener(new AnonymousClass1(this));
        if (canScrollDown() == false) goto L9;
        this.requireScrollMixin.notifyScrollabilityChange(true);
        return;
    L9:
        return;
    L7:
        Log.w(TAG, "Cannot require scroll. Recycler view is null.");
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void pageScrollDown() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L6;
        int r1 = r0.getHeight();
        this.recyclerView.smoothScrollBy(0, r1);
        return;
    }
}
