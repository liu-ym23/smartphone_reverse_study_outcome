package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissionItemOldBinding implements ViewBinding {
    public final ImageView permIcon;
    public final OTextView permissionGroup;
    public final OTextView permissionList;
    public final View permissionListDivider;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppPermissionItemOldBinding(RelativeLayout r1, ImageView r2, OTextView r3, OTextView r4, View r5) {
        this.rootView = r1;
        this.permIcon = r2;
        this.permissionGroup = r3;
        this.permissionList = r4;
        this.permissionListDivider = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppPermissionItemOldBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppPermissionItemOldBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_permission_item_old, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppPermissionItemOldBinding bind(View r8) {
        int r0 = R.id.perm_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.perm_icon);
        if (r4 == null) goto L13;
        r0 = R.id.permission_group;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r8, R.id.permission_group);
        if (r5 == null) goto L13;
        r0 = R.id.permission_list;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r8, R.id.permission_list);
        if (r6 == null) goto L13;
        r0 = R.id.permission_list_divider;
        View r7 = ViewBindings.findChildViewById(r8, R.id.permission_list_divider);
        if (r7 == null) goto L13;
        return new AppPermissionItemOldBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
