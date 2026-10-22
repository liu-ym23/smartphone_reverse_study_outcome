package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkRequestDialogBinding implements ViewBinding {
    public final OListView requestNetwork;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NetworkRequestDialogBinding(LinearLayout r1, OListView r2) {
        this.rootView = r1;
        this.requestNetwork = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NetworkRequestDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NetworkRequestDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.network_request_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NetworkRequestDialogBinding bind(View r2) {
        OListView r1 = (OListView) ViewBindings.findChildViewById(r2, R.id.request_network);
        if (r1 == null) goto L7;
        return new NetworkRequestDialogBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.request_network)));
    }
}
