package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceAdminItemBinding implements ViewBinding {
    public final CheckBox checkbox;
    public final TextView description;
    public final ImageView icon;
    public final TextView name;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceAdminItemBinding(RelativeLayout r1, CheckBox r2, TextView r3, ImageView r4, TextView r5) {
        this.rootView = r1;
        this.checkbox = r2;
        this.description = r3;
        this.icon = r4;
        this.name = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceAdminItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceAdminItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_admin_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceAdminItemBinding bind(View r8) {
        int r0 = R.id.checkbox;
        CheckBox r4 = (CheckBox) ViewBindings.findChildViewById(r8, R.id.checkbox);
        if (r4 == null) goto L13;
        r0 = R.id.description;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.description);
        if (r5 == null) goto L13;
        r0 = R.id.icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.icon);
        if (r6 == null) goto L13;
        r0 = R.id.name;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.name);
        if (r7 == null) goto L13;
        return new DeviceAdminItemBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
