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
public final class AppPreferenceItemBinding implements ViewBinding {
    public final TextView defaultLabel;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView systemDefaultLabel;
    public final TextView systemLabel;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppPreferenceItemBinding(LinearLayout r1, TextView r2, ImageView r3, TextView r4, TextView r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.defaultLabel = r2;
        this.icon = r3;
        this.summary = r4;
        this.systemDefaultLabel = r5;
        this.systemLabel = r6;
        this.title = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppPreferenceItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppPreferenceItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_preference_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppPreferenceItemBinding bind(View r10) {
        int r0 = R.id.default_label;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.default_label);
        if (r4 == null) goto L17;
        r0 = android.R.id.icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, android.R.id.icon);
        if (r5 == null) goto L17;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, android.R.id.summary);
        if (r6 == null) goto L17;
        r0 = R.id.system_default_label;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.system_default_label);
        if (r7 == null) goto L17;
        r0 = R.id.system_label;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.system_label);
        if (r8 == null) goto L17;
        r0 = android.R.id.title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, android.R.id.title);
        if (r9 == null) goto L17;
        return new AppPreferenceItemBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
