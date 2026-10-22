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
public final class PreferenceAppRestrictionsBinding implements ViewBinding {
    public final LinearLayout appRestrictionsPref;
    public final ImageView appRestrictionsSettings;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final View settingsDivider;
    public final TextView summary;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceAppRestrictionsBinding(LinearLayout r1, LinearLayout r2, ImageView r3, ImageView r4, View r5, TextView r6, TextView r7, LinearLayout r8) {
        this.rootView = r1;
        this.appRestrictionsPref = r2;
        this.appRestrictionsSettings = r3;
        this.icon = r4;
        this.settingsDivider = r5;
        this.summary = r6;
        this.title = r7;
        this.widgetFrame = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceAppRestrictionsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceAppRestrictionsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_app_restrictions, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceAppRestrictionsBinding bind(View r11) {
        int r0 = R.id.app_restrictions_pref;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.app_restrictions_pref);
        if (r4 == null) goto L19;
        r0 = R.id.app_restrictions_settings;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, R.id.app_restrictions_settings);
        if (r5 == null) goto L19;
        r0 = android.R.id.icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, android.R.id.icon);
        if (r6 == null) goto L19;
        r0 = R.id.settings_divider;
        View r7 = ViewBindings.findChildViewById(r11, R.id.settings_divider);
        if (r7 == null) goto L19;
        r0 = android.R.id.summary;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, android.R.id.summary);
        if (r8 == null) goto L19;
        r0 = android.R.id.title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, android.R.id.title);
        if (r9 == null) goto L19;
        r0 = android.R.id.widget_frame;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r11, android.R.id.widget_frame);
        if (r10 == null) goto L19;
        return new PreferenceAppRestrictionsBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
