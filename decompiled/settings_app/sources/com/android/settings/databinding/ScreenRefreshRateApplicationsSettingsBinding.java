package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenRefreshRateApplicationsSettingsBinding implements ViewBinding {
    public final RecyclerView listView;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenRefreshRateApplicationsSettingsBinding(RelativeLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.rootView = r1;
        this.listView = r2;
        this.viewTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScreenRefreshRateApplicationsSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenRefreshRateApplicationsSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_refresh_rate_applications_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenRefreshRateApplicationsSettingsBinding bind(View r3) {
        int r0 = R.id.list_view;
        RecyclerView r1 = (RecyclerView) ViewBindings.findChildViewById(r3, R.id.list_view);
        if (r1 == null) goto L9;
        r0 = R.id.view_title;
        OFloatingTitleBar r2 = (OFloatingTitleBar) ViewBindings.findChildViewById(r3, R.id.view_title);
        if (r2 == null) goto L9;
        return new ScreenRefreshRateApplicationsSettingsBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
