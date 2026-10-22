package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class AppBatteryUseOptimzationItemBinding implements ViewBinding {
    public final RelativeLayout rlItemParent;
    private final RelativeLayout rootView;
    public final ListContentItemSwitch switcher;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppBatteryUseOptimzationItemBinding(RelativeLayout r1, RelativeLayout r2, ListContentItemSwitch r3) {
        this.rootView = r1;
        this.rlItemParent = r2;
        this.switcher = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBatteryUseOptimzationItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppBatteryUseOptimzationItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_battery_use_optimzation_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppBatteryUseOptimzationItemBinding bind(View r3) {
        RelativeLayout r0 = (RelativeLayout) r3;
        ListContentItemSwitch r2 = (ListContentItemSwitch) ViewBindings.findChildViewById(r3, R.id.switcher);
        if (r2 == null) goto L7;
        return new AppBatteryUseOptimzationItemBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.switcher)));
    }
}
