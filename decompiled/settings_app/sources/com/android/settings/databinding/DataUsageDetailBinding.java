package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageDetailBinding implements ViewBinding {
    public final TextView appBackground;
    public final LinearLayout appDetail;
    public final TextView appForeground;
    public final ImageView appIcon;
    public final Button appSettings;
    public final LinearLayout appSwitches;
    public final TextView appTitle;
    public final LinearLayout appTitles;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageDetailBinding(LinearLayout r1, TextView r2, LinearLayout r3, TextView r4, ImageView r5, Button r6, LinearLayout r7, TextView r8, LinearLayout r9) {
        this.rootView = r1;
        this.appBackground = r2;
        this.appDetail = r3;
        this.appForeground = r4;
        this.appIcon = r5;
        this.appSettings = r6;
        this.appSwitches = r7;
        this.appTitle = r8;
        this.appTitles = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageDetailBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_detail, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageDetailBinding bind(View r12) {
        int r0 = R.id.app_background;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, R.id.app_background);
        if (r4 == null) goto L19;
        LinearLayout r5 = (LinearLayout) r12;
        r0 = R.id.app_foreground;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, R.id.app_foreground);
        if (r6 == null) goto L19;
        r0 = R.id.app_icon;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r12, R.id.app_icon);
        if (r7 == null) goto L19;
        r0 = R.id.app_settings;
        Button r8 = (Button) ViewBindings.findChildViewById(r12, R.id.app_settings);
        if (r8 == null) goto L19;
        r0 = R.id.app_switches;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.app_switches);
        if (r9 == null) goto L19;
        r0 = R.id.app_title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.app_title);
        if (r10 == null) goto L19;
        r0 = R.id.app_titles;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.app_titles);
        if (r11 == null) goto L19;
        return new DataUsageDetailBinding(r5, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
