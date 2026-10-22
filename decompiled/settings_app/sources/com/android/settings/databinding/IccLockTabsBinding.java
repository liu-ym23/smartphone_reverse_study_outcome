package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class IccLockTabsBinding implements ViewBinding {
    public final FrameLayout prefsContainer;
    private final TabHost rootView;
    public final FrameLayout tabcontent;
    public final TabHost tabhost;
    public final TabWidget tabs;
    public final LinearLayout tabsContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IccLockTabsBinding(TabHost r1, FrameLayout r2, FrameLayout r3, TabHost r4, TabWidget r5, LinearLayout r6) {
        this.rootView = r1;
        this.prefsContainer = r2;
        this.tabcontent = r3;
        this.tabhost = r4;
        this.tabs = r5;
        this.tabsContainer = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TabHost getRoot() {
        return this.rootView;
    }

    public static IccLockTabsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IccLockTabsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.icc_lock_tabs, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IccLockTabsBinding bind(View r9) {
        int r0 = R.id.prefs_container;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r9, R.id.prefs_container);
        if (r4 == null) goto L13;
        r0 = android.R.id.tabcontent;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r9, android.R.id.tabcontent);
        if (r5 == null) goto L13;
        TabHost r6 = (TabHost) r9;
        r0 = android.R.id.tabs;
        TabWidget r7 = (TabWidget) ViewBindings.findChildViewById(r9, android.R.id.tabs);
        if (r7 == null) goto L13;
        r0 = R.id.tabs_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.tabs_container);
        if (r8 == null) goto L13;
        return new IccLockTabsBinding(r6, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
