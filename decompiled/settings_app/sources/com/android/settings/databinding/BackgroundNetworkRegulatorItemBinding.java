package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class BackgroundNetworkRegulatorItemBinding implements ViewBinding {
    public final ImageView appItemIcon;
    public final TextView appItemName;
    public final SwitchEx appSwitcher;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BackgroundNetworkRegulatorItemBinding(RelativeLayout r1, ImageView r2, TextView r3, SwitchEx r4) {
        this.rootView = r1;
        this.appItemIcon = r2;
        this.appItemName = r3;
        this.appSwitcher = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BackgroundNetworkRegulatorItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BackgroundNetworkRegulatorItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.background_network_regulator_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BackgroundNetworkRegulatorItemBinding bind(View r4) {
        int r0 = R.id.app_item_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.app_item_icon);
        if (r1 == null) goto L11;
        r0 = R.id.app_item_name;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.app_item_name);
        if (r2 == null) goto L11;
        r0 = R.id.app_switcher;
        SwitchEx r3 = (SwitchEx) ViewBindings.findChildViewById(r4, R.id.app_switcher);
        if (r3 == null) goto L11;
        return new BackgroundNetworkRegulatorItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
