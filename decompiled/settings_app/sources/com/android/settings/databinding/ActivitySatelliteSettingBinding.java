package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivitySatelliteSettingBinding implements ViewBinding {
    public final FrameLayout emptyContainer;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootViewContainer;
    public final OPageStatus satelliteStatusLoading;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivitySatelliteSettingBinding(ConstraintLayout r1, FrameLayout r2, ConstraintLayout r3, OPageStatus r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.emptyContainer = r2;
        this.rootViewContainer = r3;
        this.satelliteStatusLoading = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySatelliteSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySatelliteSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_satellite_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivitySatelliteSettingBinding bind(View r8) {
        int r0 = R.id.empty_container;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.empty_container);
        if (r4 == null) goto L11;
        ConstraintLayout r5 = (ConstraintLayout) r8;
        r0 = R.id.satellite_status_loading;
        OPageStatus r6 = (OPageStatus) ViewBindings.findChildViewById(r8, R.id.satellite_status_loading);
        if (r6 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L11;
        return new ActivitySatelliteSettingBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
