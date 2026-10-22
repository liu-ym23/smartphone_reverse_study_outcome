package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiP2pSettingLayoutBinding implements ViewBinding {
    public final FragmentContainerView fragmentWifiP2p;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiP2pSettingLayoutBinding(RelativeLayout r1, FragmentContainerView r2, OFloatingTitleBar r3) {
        this.rootView = r1;
        this.fragmentWifiP2p = r2;
        this.viewTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiP2pSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiP2pSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_p2p_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiP2pSettingLayoutBinding bind(View r3) {
        int r0 = R.id.fragment_wifi_p2p;
        FragmentContainerView r1 = (FragmentContainerView) ViewBindings.findChildViewById(r3, R.id.fragment_wifi_p2p);
        if (r1 == null) goto L9;
        r0 = R.id.view_title;
        OFloatingTitleBar r2 = (OFloatingTitleBar) ViewBindings.findChildViewById(r3, R.id.view_title);
        if (r2 == null) goto L9;
        return new WifiP2pSettingLayoutBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
