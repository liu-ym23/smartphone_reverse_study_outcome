package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class OlistContentItemCheckBinding implements ViewBinding {
    public final OListItemCheck itemCheck;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OlistContentItemCheckBinding(RelativeLayout r1, OListItemCheck r2) {
        this.rootView = r1;
        this.itemCheck = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OlistContentItemCheckBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OlistContentItemCheckBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.olist_content_item_check, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OlistContentItemCheckBinding bind(View r2) {
        OListItemCheck r1 = (OListItemCheck) ViewBindings.findChildViewById(r2, R.id.item_check);
        if (r1 == null) goto L7;
        return new OlistContentItemCheckBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item_check)));
    }
}
