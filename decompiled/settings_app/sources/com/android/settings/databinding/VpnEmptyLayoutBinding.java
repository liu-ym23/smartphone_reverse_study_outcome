package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.status.OPageStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class VpnEmptyLayoutBinding implements ViewBinding {
    public final OPageStatus emptyPage;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VpnEmptyLayoutBinding(LinearLayout r1, OPageStatus r2) {
        this.rootView = r1;
        this.emptyPage = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VpnEmptyLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VpnEmptyLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vpn_empty_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VpnEmptyLayoutBinding bind(View r2) {
        OPageStatus r1 = (OPageStatus) ViewBindings.findChildViewById(r2, R.id.empty_page);
        if (r1 == null) goto L7;
        return new VpnEmptyLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.empty_page)));
    }
}
