package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkResetDisallowedScreenBinding implements ViewBinding {
    public final TextView empty;
    public final OListView list;
    public final FrameLayout listContainer;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NetworkResetDisallowedScreenBinding(FrameLayout r1, TextView r2, OListView r3, FrameLayout r4) {
        this.rootView = r1;
        this.empty = r2;
        this.list = r3;
        this.listContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static NetworkResetDisallowedScreenBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NetworkResetDisallowedScreenBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.network_reset_disallowed_screen, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NetworkResetDisallowedScreenBinding bind(View r3) {
        int r0 = android.R.id.empty;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.empty);
        if (r1 == null) goto L9;
        r0 = android.R.id.list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r3, android.R.id.list);
        if (r2 == null) goto L9;
        FrameLayout r4 = (FrameLayout) r3;
        return new NetworkResetDisallowedScreenBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
