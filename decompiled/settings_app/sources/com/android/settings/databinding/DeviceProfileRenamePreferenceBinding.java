package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceProfileRenamePreferenceBinding implements ViewBinding {
    public final ImageView arrow;
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final TextView subtitle;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceProfileRenamePreferenceBinding(RelativeLayout r1, ImageView r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.arrow = r2;
        this.icon = r3;
        this.subtitle = r4;
        this.summary = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceProfileRenamePreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceProfileRenamePreferenceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_profile_rename_preference, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceProfileRenamePreferenceBinding bind(View r9) {
        int r0 = R.id.arrow;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.arrow);
        if (r4 == null) goto L15;
        r0 = android.R.id.icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r5 == null) goto L15;
        r0 = R.id.subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.subtitle);
        if (r6 == null) goto L15;
        r0 = android.R.id.summary;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.summary);
        if (r7 == null) goto L15;
        r0 = android.R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r8 == null) goto L15;
        return new DeviceProfileRenamePreferenceBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
