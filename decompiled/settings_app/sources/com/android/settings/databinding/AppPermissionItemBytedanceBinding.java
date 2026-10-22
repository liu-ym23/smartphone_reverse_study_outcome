package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissionItemBytedanceBinding implements ViewBinding {
    public final TextView permissionGroup;
    public final TextView permissionList;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppPermissionItemBytedanceBinding(LinearLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.permissionGroup = r2;
        this.permissionList = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppPermissionItemBytedanceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppPermissionItemBytedanceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_permission_item_bytedance, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppPermissionItemBytedanceBinding bind(View r3) {
        int r0 = R.id.permission_group;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.permission_group);
        if (r1 == null) goto L9;
        r0 = R.id.permission_list;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.permission_list);
        if (r2 == null) goto L9;
        return new AppPermissionItemBytedanceBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
