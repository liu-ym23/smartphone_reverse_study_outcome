package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceHomeAppBinding implements ViewBinding {
    public final LinearLayout homeAppPref;
    public final ImageView homeAppUninstall;
    public final View homeDivider;
    public final RadioButton homeRadio;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceHomeAppBinding(LinearLayout r1, LinearLayout r2, ImageView r3, View r4, RadioButton r5, ImageView r6, TextView r7, TextView r8) {
        this.rootView = r1;
        this.homeAppPref = r2;
        this.homeAppUninstall = r3;
        this.homeDivider = r4;
        this.homeRadio = r5;
        this.icon = r6;
        this.summary = r7;
        this.title = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceHomeAppBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceHomeAppBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_home_app, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceHomeAppBinding bind(View r11) {
        int r0 = R.id.home_app_pref;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.home_app_pref);
        if (r4 == null) goto L19;
        r0 = R.id.home_app_uninstall;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, R.id.home_app_uninstall);
        if (r5 == null) goto L19;
        r0 = R.id.home_divider;
        View r6 = ViewBindings.findChildViewById(r11, R.id.home_divider);
        if (r6 == null) goto L19;
        r0 = R.id.home_radio;
        RadioButton r7 = (RadioButton) ViewBindings.findChildViewById(r11, R.id.home_radio);
        if (r7 == null) goto L19;
        r0 = android.R.id.icon;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, android.R.id.icon);
        if (r8 == null) goto L19;
        r0 = android.R.id.summary;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, android.R.id.summary);
        if (r9 == null) goto L19;
        r0 = android.R.id.title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r11, android.R.id.title);
        if (r10 == null) goto L19;
        return new PreferenceHomeAppBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
