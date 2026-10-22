package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageActivityLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageActivityLayoutBinding(RelativeLayout r1, OFloatingTitleBar r2) {
        this.rootView = r1;
        this.viewTitle = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageActivityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageActivityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_activity_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageActivityLayoutBinding bind(View r2) {
        OFloatingTitleBar r1 = (OFloatingTitleBar) ViewBindings.findChildViewById(r2, R.id.view_title);
        if (r1 == null) goto L7;
        return new DataUsageActivityLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.view_title)));
    }
}
