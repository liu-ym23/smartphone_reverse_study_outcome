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
public final class AppPercentageItemBinding implements ViewBinding {
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final TextView summary;
    public final TextView text1;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppPercentageItemBinding(RelativeLayout r1, ImageView r2, TextView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.icon = r2;
        this.summary = r3;
        this.text1 = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppPercentageItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppPercentageItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_percentage_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppPercentageItemBinding bind(View r8) {
        int r0 = android.R.id.icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, android.R.id.icon);
        if (r4 == null) goto L13;
        r0 = android.R.id.summary;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.summary);
        if (r5 == null) goto L13;
        r0 = android.R.id.text1;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.text1);
        if (r6 == null) goto L13;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.title);
        if (r7 == null) goto L13;
        return new AppPercentageItemBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
