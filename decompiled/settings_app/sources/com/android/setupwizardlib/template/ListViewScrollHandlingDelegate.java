package com.android.setupwizardlib.template;

import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class ListViewScrollHandlingDelegate implements RequireScrollMixin.ScrollHandlingDelegate, AbsListView.OnScrollListener {
    private static final int SCROLL_DURATION = 500;
    private static final String TAG = "ListViewDelegate";
    private final ListView listView;
    private final RequireScrollMixin requireScrollMixin;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
    }

    public ListViewScrollHandlingDelegate(RequireScrollMixin r1, ListView r2) {
        this.requireScrollMixin = r1;
        this.listView = r2;
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void startListening() {
        ListView r0 = this.listView;
        if (r0 == null) goto L7;
        r0.setOnScrollListener(this);
        ListAdapter r1 = this.listView.getAdapter();
        if (this.listView.getLastVisiblePosition() >= r1.getCount()) goto L9;
        this.requireScrollMixin.notifyScrollabilityChange(true);
        return;
    L9:
        return;
    L7:
        Log.w(TAG, "Cannot require scroll. List view is null");
    }

    @Override // com.android.setupwizardlib.template.RequireScrollMixin.ScrollHandlingDelegate
    public void pageScrollDown() {
        ListView r0 = this.listView;
        if (r0 == null) goto L6;
        int r1 = r0.getHeight();
        this.listView.smoothScrollBy(r1, 500);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        if ((r2 + r3) < r4) goto L5;
        this.requireScrollMixin.notifyScrollabilityChange(false);
        return;
    L5:
        this.requireScrollMixin.notifyScrollabilityChange(true);
    }
}
