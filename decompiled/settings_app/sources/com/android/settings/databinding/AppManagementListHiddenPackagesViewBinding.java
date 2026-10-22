package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppManagementListHiddenPackagesViewBinding implements ViewBinding {
    public final TextView hiddenPackages;
    public final ImageView hiddenPackagesIcon;
    public final FrameLayout iconContainer;
    private final View rootView;

    private AppManagementListHiddenPackagesViewBinding(View r1, TextView r2, ImageView r3, FrameLayout r4) {
        this.rootView = r1;
        this.hiddenPackages = r2;
        this.hiddenPackagesIcon = r3;
        this.iconContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static AppManagementListHiddenPackagesViewBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.app_management_list_hidden_packages_view, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static AppManagementListHiddenPackagesViewBinding bind(View r4) {
        int r0 = R.id.hidden_packages;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.hidden_packages);
        if (r1 == null) goto L11;
        r0 = R.id.hidden_packages_icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.hidden_packages_icon);
        if (r2 == null) goto L11;
        r0 = R.id.icon_container;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.icon_container);
        if (r3 == null) goto L11;
        return new AppManagementListHiddenPackagesViewBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
