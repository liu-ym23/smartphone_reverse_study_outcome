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

/* JADX INFO: loaded from: classes2.dex */
public final class RequestManageCredentialsHeaderBinding implements ViewBinding {
    public final TextView credentialManagementAppDescription;
    public final ImageView credentialManagementAppIcon;
    public final TextView credentialManagementAppTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RequestManageCredentialsHeaderBinding(LinearLayout r1, TextView r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.credentialManagementAppDescription = r2;
        this.credentialManagementAppIcon = r3;
        this.credentialManagementAppTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RequestManageCredentialsHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RequestManageCredentialsHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.request_manage_credentials_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RequestManageCredentialsHeaderBinding bind(View r4) {
        int r0 = R.id.credential_management_app_description;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.credential_management_app_description);
        if (r1 == null) goto L11;
        r0 = R.id.credential_management_app_icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.credential_management_app_icon);
        if (r2 == null) goto L11;
        r0 = R.id.credential_management_app_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.credential_management_app_title);
        if (r3 == null) goto L11;
        return new RequestManageCredentialsHeaderBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
