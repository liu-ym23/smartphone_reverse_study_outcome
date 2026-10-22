package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSettingLayoutBinding implements ViewBinding {
    public final FrameLayout emptyView;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSettingLayoutBinding(RelativeLayout r1, FrameLayout r2, RecyclerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.emptyView = r2;
        this.recyclerView = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSettingLayoutBinding bind(View r4) {
        int r0 = R.id.empty_view;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.empty_view);
        if (r1 == null) goto L11;
        r0 = R.id.recycler_view;
        RecyclerView r2 = (RecyclerView) ViewBindings.findChildViewById(r4, R.id.recycler_view);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new WifiSettingLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
