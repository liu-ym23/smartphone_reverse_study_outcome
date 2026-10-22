package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class ApnDeleteLayoutBinding implements ViewBinding {
    public final OButton deleteApn;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ApnDeleteLayoutBinding(LinearLayout r1, OButton r2) {
        this.rootView = r1;
        this.deleteApn = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ApnDeleteLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ApnDeleteLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apn_delete_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ApnDeleteLayoutBinding bind(View r2) {
        OButton r1 = (OButton) ViewBindings.findChildViewById(r2, R.id.delete_apn);
        if (r1 == null) goto L7;
        return new ApnDeleteLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.delete_apn)));
    }
}
