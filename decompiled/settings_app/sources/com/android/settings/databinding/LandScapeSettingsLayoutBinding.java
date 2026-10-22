package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import obric.tablet.TabletLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class LandScapeSettingsLayoutBinding implements ViewBinding {
    private final TabletLayout rootView;
    public final TabletLayout settingsRootViewContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LandScapeSettingsLayoutBinding(TabletLayout r1, TabletLayout r2) {
        this.rootView = r1;
        this.settingsRootViewContainer = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TabletLayout getRoot() {
        return this.rootView;
    }

    public static LandScapeSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LandScapeSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.land_scape_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LandScapeSettingsLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        TabletLayout r2 = (TabletLayout) r1;
        return new LandScapeSettingsLayoutBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
