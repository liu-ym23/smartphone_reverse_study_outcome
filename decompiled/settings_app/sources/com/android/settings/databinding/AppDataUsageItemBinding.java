package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDataUsageItemBinding implements ViewBinding {
    public final ListContentItemSwitch appInfo;
    public final View emptyView;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppDataUsageItemBinding(RelativeLayout r1, ListContentItemSwitch r2, View r3) {
        this.rootView = r1;
        this.appInfo = r2;
        this.emptyView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppDataUsageItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppDataUsageItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_data_usage_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppDataUsageItemBinding bind(View r3) {
        int r0 = R.id.app_info;
        ListContentItemSwitch r1 = (ListContentItemSwitch) ViewBindings.findChildViewById(r3, R.id.app_info);
        if (r1 == null) goto L9;
        r0 = R.id.empty_view;
        View r2 = ViewBindings.findChildViewById(r3, R.id.empty_view);
        if (r2 == null) goto L9;
        return new AppDataUsageItemBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
