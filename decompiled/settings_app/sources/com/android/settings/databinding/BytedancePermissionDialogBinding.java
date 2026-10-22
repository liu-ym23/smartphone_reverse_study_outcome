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
public final class BytedancePermissionDialogBinding implements ViewBinding {
    public final TextView appopsWarningHint;
    public final TextView detail;
    public final ImageView icon;
    public final TextView name;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BytedancePermissionDialogBinding(LinearLayout r1, TextView r2, TextView r3, ImageView r4, TextView r5) {
        this.rootView = r1;
        this.appopsWarningHint = r2;
        this.detail = r3;
        this.icon = r4;
        this.name = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BytedancePermissionDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BytedancePermissionDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bytedance_permission_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BytedancePermissionDialogBinding bind(View r8) {
        int r0 = R.id.appops_warning_hint;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.appops_warning_hint);
        if (r4 == null) goto L13;
        r0 = R.id.detail;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.detail);
        if (r5 == null) goto L13;
        r0 = R.id.icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.icon);
        if (r6 == null) goto L13;
        r0 = R.id.name;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.name);
        if (r7 == null) goto L13;
        return new BytedancePermissionDialogBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
