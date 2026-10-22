package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SetupWifiAddNetworkBinding implements ViewBinding {
    public final LinearLayout otherNetwork;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetupWifiAddNetworkBinding(LinearLayout r1, LinearLayout r2) {
        this.rootView = r1;
        this.otherNetwork = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SetupWifiAddNetworkBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetupWifiAddNetworkBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setup_wifi_add_network, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetupWifiAddNetworkBinding bind(View r1) {
        if (r1 == null) goto L6;
        LinearLayout r2 = (LinearLayout) r1;
        return new SetupWifiAddNetworkBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
