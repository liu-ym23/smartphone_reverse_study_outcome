package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.PreferenceImageView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceMaterialSettingsBinding implements ViewBinding {
    public final PreferenceImageView icon;
    public final LinearLayout iconFrame;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceMaterialSettingsBinding(LinearLayout r1, PreferenceImageView r2, LinearLayout r3, TextView r4, TextView r5, LinearLayout r6) {
        this.rootView = r1;
        this.icon = r2;
        this.iconFrame = r3;
        this.summary = r4;
        this.title = r5;
        this.widgetFrame = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceMaterialSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceMaterialSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_material_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceMaterialSettingsBinding bind(View r9) {
        int r0 = android.R.id.icon;
        PreferenceImageView r4 = ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r4 == null) goto L15;
        r0 = R.id.icon_frame;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.icon_frame);
        if (r5 == null) goto L15;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.summary);
        if (r6 == null) goto L15;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r7 == null) goto L15;
        r0 = android.R.id.widget_frame;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, android.R.id.widget_frame);
        if (r8 == null) goto L15;
        return new PreferenceMaterialSettingsBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
