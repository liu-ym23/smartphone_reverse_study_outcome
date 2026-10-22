package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AdminSupportDetailsDialogBinding implements ViewBinding {
    public final ImageView adminSupportIcon;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AdminSupportDetailsDialogBinding(LinearLayout r1, ImageView r2) {
        this.rootView = r1;
        this.adminSupportIcon = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdminSupportDetailsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AdminSupportDetailsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.admin_support_details_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AdminSupportDetailsDialogBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.admin_support_icon);
        if (r1 == null) goto L7;
        return new AdminSupportDetailsDialogBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.admin_support_icon)));
    }
}
