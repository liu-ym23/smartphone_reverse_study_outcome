package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonIconAppInfoBinding implements ViewBinding {
    public final ImageView appIcon;
    public final TextView appName;
    public final TextView appVersion;
    public final ListContentItemCustom emptyView;
    private final LinearLayout rootView;
    public final TextView tips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CommonIconAppInfoBinding(LinearLayout r1, ImageView r2, TextView r3, TextView r4, ListContentItemCustom r5, TextView r6) {
        this.rootView = r1;
        this.appIcon = r2;
        this.appName = r3;
        this.appVersion = r4;
        this.emptyView = r5;
        this.tips = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CommonIconAppInfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CommonIconAppInfoBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.common_icon_app_info, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CommonIconAppInfoBinding bind(View r9) {
        int r0 = R.id.app_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.app_icon);
        if (r4 == null) goto L15;
        r0 = R.id.app_name;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, R.id.app_name);
        if (r5 == null) goto L15;
        r0 = R.id.app_version;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.app_version);
        if (r6 == null) goto L15;
        r0 = R.id.empty_view;
        ListContentItemCustom r7 = (ListContentItemCustom) ViewBindings.findChildViewById(r9, R.id.empty_view);
        if (r7 == null) goto L15;
        r0 = R.id.tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.tips);
        if (r8 == null) goto L15;
        return new CommonIconAppInfoBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
