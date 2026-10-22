package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiDisplayDetailFragmentBinding implements ViewBinding {
    public final OButton forgetBtn;
    private final LinearLayout rootView;
    public final OListItemSettings wifiDisplayRename;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiDisplayDetailFragmentBinding(LinearLayout r1, OButton r2, OListItemSettings r3) {
        this.rootView = r1;
        this.forgetBtn = r2;
        this.wifiDisplayRename = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiDisplayDetailFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiDisplayDetailFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_display_detail_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiDisplayDetailFragmentBinding bind(View r3) {
        int r0 = R.id.forget_btn;
        OButton r1 = (OButton) ViewBindings.findChildViewById(r3, R.id.forget_btn);
        if (r1 == null) goto L9;
        r0 = R.id.wifi_display_rename;
        OListItemSettings r2 = (OListItemSettings) ViewBindings.findChildViewById(r3, R.id.wifi_display_rename);
        if (r2 == null) goto L9;
        return new WifiDisplayDetailFragmentBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
