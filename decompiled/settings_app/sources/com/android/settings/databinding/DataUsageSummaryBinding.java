package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageSummaryBinding implements ViewBinding {
    public final OListView list;
    public final FrameLayout pinnedHeader;
    private final TabHost rootView;
    public final FrameLayout tabcontent;
    public final TabHost tabhost;
    public final LinearLayout tabsContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageSummaryBinding(TabHost r1, OListView r2, FrameLayout r3, FrameLayout r4, TabHost r5, LinearLayout r6) {
        this.rootView = r1;
        this.list = r2;
        this.pinnedHeader = r3;
        this.tabcontent = r4;
        this.tabhost = r5;
        this.tabsContainer = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TabHost getRoot() {
        return this.rootView;
    }

    public static DataUsageSummaryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageSummaryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_summary, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageSummaryBinding bind(View r9) {
        int r0 = android.R.id.list;
        OListView r4 = (OListView) ViewBindings.findChildViewById(r9, android.R.id.list);
        if (r4 == null) goto L13;
        r0 = R.id.pinned_header;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r9, R.id.pinned_header);
        if (r5 == null) goto L13;
        r0 = android.R.id.tabcontent;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r9, android.R.id.tabcontent);
        if (r6 == null) goto L13;
        TabHost r7 = (TabHost) r9;
        r0 = R.id.tabs_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.tabs_container);
        if (r8 == null) goto L13;
        return new DataUsageSummaryBinding(r7, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
