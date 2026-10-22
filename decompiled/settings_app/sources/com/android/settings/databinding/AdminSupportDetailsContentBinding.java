package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AdminSupportDetailsContentBinding implements ViewBinding {
    public final TextView adminSupportMsg;
    public final TextView adminsPoliciesList;
    private final View rootView;

    private AdminSupportDetailsContentBinding(View r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.adminSupportMsg = r2;
        this.adminsPoliciesList = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static AdminSupportDetailsContentBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.admin_support_details_content, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static AdminSupportDetailsContentBinding bind(View r3) {
        int r0 = R.id.admin_support_msg;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.admin_support_msg);
        if (r1 == null) goto L9;
        r0 = R.id.admins_policies_list;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.admins_policies_list);
        if (r2 == null) goto L9;
        return new AdminSupportDetailsContentBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
