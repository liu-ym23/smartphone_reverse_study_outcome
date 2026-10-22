package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ResetNetworkBinding implements ViewBinding {
    public final Button initiateResetNetwork;
    public final Spinner resetNetworkSubscription;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ResetNetworkBinding(LinearLayout r1, Button r2, Spinner r3) {
        this.rootView = r1;
        this.initiateResetNetwork = r2;
        this.resetNetworkSubscription = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ResetNetworkBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ResetNetworkBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.reset_network, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ResetNetworkBinding bind(View r3) {
        int r0 = R.id.initiate_reset_network;
        Button r1 = (Button) ViewBindings.findChildViewById(r3, R.id.initiate_reset_network);
        if (r1 == null) goto L9;
        r0 = R.id.reset_network_subscription;
        Spinner r2 = (Spinner) ViewBindings.findChildViewById(r3, R.id.reset_network_subscription);
        if (r2 == null) goto L9;
        return new ResetNetworkBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
