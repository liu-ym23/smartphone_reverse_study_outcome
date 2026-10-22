package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class AppBatteryUseOptimzationHeaderBinding implements ViewBinding {
    public final OSectionTitleBar dynamicResolutionGameListTitle;
    public final ListContentItemSwitch optimzationHeaderSwitch;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppBatteryUseOptimzationHeaderBinding(LinearLayout r1, OSectionTitleBar r2, ListContentItemSwitch r3) {
        this.rootView = r1;
        this.dynamicResolutionGameListTitle = r2;
        this.optimzationHeaderSwitch = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppBatteryUseOptimzationHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppBatteryUseOptimzationHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_battery_use_optimzation_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppBatteryUseOptimzationHeaderBinding bind(View r3) {
        int r0 = R.id.dynamic_resolution_game_list_title;
        OSectionTitleBar r1 = (OSectionTitleBar) ViewBindings.findChildViewById(r3, R.id.dynamic_resolution_game_list_title);
        if (r1 == null) goto L9;
        r0 = R.id.optimzation_header_switch;
        ListContentItemSwitch r2 = (ListContentItemSwitch) ViewBindings.findChildViewById(r3, R.id.optimzation_header_switch);
        if (r2 == null) goto L9;
        return new AppBatteryUseOptimzationHeaderBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
