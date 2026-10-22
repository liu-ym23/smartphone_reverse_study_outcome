package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import obric.widget.ExtendListView;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiP2pPersistentGroupsFooterBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ExtendListView wifiP2pPersistentGroupsList;
    public final OSectionTitleBar wifiP2pPersistentGroupsTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiP2pPersistentGroupsFooterBinding(RelativeLayout r1, ExtendListView r2, OSectionTitleBar r3) {
        this.rootView = r1;
        this.wifiP2pPersistentGroupsList = r2;
        this.wifiP2pPersistentGroupsTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiP2pPersistentGroupsFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiP2pPersistentGroupsFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_p2p_persistent_groups_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiP2pPersistentGroupsFooterBinding bind(View r3) {
        int r0 = R.id.wifi_p2p_persistent_groups_list;
        ExtendListView r1 = (ExtendListView) ViewBindings.findChildViewById(r3, R.id.wifi_p2p_persistent_groups_list);
        if (r1 == null) goto L9;
        r0 = R.id.wifi_p2p_persistent_groups_title;
        OSectionTitleBar r2 = (OSectionTitleBar) ViewBindings.findChildViewById(r3, R.id.wifi_p2p_persistent_groups_title);
        if (r2 == null) goto L9;
        return new WifiP2pPersistentGroupsFooterBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
