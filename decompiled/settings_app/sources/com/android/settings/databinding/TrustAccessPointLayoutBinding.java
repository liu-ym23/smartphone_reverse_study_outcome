package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustAccessPointLayoutBinding implements ViewBinding {
    public final OListItemSettings listItemContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustAccessPointLayoutBinding(LinearLayout r1, OListItemSettings r2) {
        this.rootView = r1;
        this.listItemContainer = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TrustAccessPointLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustAccessPointLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trust_access_point_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustAccessPointLayoutBinding bind(View r2) {
        OListItemSettings r1 = (OListItemSettings) ViewBindings.findChildViewById(r2, R.id.list_item_container);
        if (r1 == null) goto L7;
        return new TrustAccessPointLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.list_item_container)));
    }
}
