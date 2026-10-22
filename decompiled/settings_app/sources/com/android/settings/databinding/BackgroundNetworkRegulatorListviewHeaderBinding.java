package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BackgroundNetworkRegulatorListviewHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BackgroundNetworkRegulatorListviewHeaderBinding(LinearLayout r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BackgroundNetworkRegulatorListviewHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BackgroundNetworkRegulatorListviewHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.background_network_regulator_listview_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BackgroundNetworkRegulatorListviewHeaderBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new BackgroundNetworkRegulatorListviewHeaderBinding((LinearLayout) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
