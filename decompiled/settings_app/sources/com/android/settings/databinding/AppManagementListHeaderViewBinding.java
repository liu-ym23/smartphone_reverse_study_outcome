package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class AppManagementListHeaderViewBinding implements ViewBinding {
    public final OCardListItem hiddenPackagesView;
    public final TextView lockedPackages;
    public final ImageView lockedPackagesIcon;
    public final RelativeLayout lockedPackagesView;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppManagementListHeaderViewBinding(LinearLayout r1, OCardListItem r2, TextView r3, ImageView r4, RelativeLayout r5) {
        this.rootView = r1;
        this.hiddenPackagesView = r2;
        this.lockedPackages = r3;
        this.lockedPackagesIcon = r4;
        this.lockedPackagesView = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppManagementListHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppManagementListHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_management_list_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppManagementListHeaderViewBinding bind(View r8) {
        int r0 = R.id.hidden_packages_view;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.hidden_packages_view);
        if (r4 == null) goto L13;
        r0 = R.id.locked_packages;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.locked_packages);
        if (r5 == null) goto L13;
        r0 = R.id.locked_packages_icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.locked_packages_icon);
        if (r6 == null) goto L13;
        r0 = R.id.locked_packages_view;
        RelativeLayout r7 = (RelativeLayout) ViewBindings.findChildViewById(r8, R.id.locked_packages_view);
        if (r7 == null) goto L13;
        return new AppManagementListHeaderViewBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
