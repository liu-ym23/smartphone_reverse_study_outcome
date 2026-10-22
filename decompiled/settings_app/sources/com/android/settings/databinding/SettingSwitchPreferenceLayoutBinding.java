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
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingSwitchPreferenceLayoutBinding implements ViewBinding {
    public final ImageView icon;
    public final SwitchEx itemSwitcher;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView text1;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingSwitchPreferenceLayoutBinding(LinearLayout r1, ImageView r2, SwitchEx r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.icon = r2;
        this.itemSwitcher = r3;
        this.summary = r4;
        this.text1 = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingSwitchPreferenceLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingSwitchPreferenceLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_switch_preference_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingSwitchPreferenceLayoutBinding bind(View r9) {
        int r0 = android.R.id.icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r4 == null) goto L15;
        r0 = R.id.item_switcher;
        SwitchEx r5 = (SwitchEx) ViewBindings.findChildViewById(r9, R.id.item_switcher);
        if (r5 == null) goto L15;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.summary);
        if (r6 == null) goto L15;
        r0 = android.R.id.text1;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.text1);
        if (r7 == null) goto L15;
        r0 = android.R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r8 == null) goto L15;
        return new SettingSwitchPreferenceLayoutBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
