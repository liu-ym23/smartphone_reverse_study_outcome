package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiP2pTitleBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final OSectionTitleBar wifiP2pSearchTips;
    public final OCardListItem wifiP2pTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiP2pTitleBinding(RelativeLayout r1, OSectionTitleBar r2, OCardListItem r3) {
        this.rootView = r1;
        this.wifiP2pSearchTips = r2;
        this.wifiP2pTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiP2pTitleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiP2pTitleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_p2p_title, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiP2pTitleBinding bind(View r3) {
        int r0 = R.id.wifi_p2p_search_tips;
        OSectionTitleBar r1 = (OSectionTitleBar) ViewBindings.findChildViewById(r3, R.id.wifi_p2p_search_tips);
        if (r1 == null) goto L9;
        r0 = R.id.wifi_p2p_title;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.wifi_p2p_title);
        if (r2 == null) goto L9;
        return new WifiP2pTitleBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
