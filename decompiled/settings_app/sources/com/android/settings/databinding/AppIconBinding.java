package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppIconBinding implements ViewBinding {
    public final ImageView icon;
    public final ImageView iconBg;
    public final ImageView iconSelected;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppIconBinding(RelativeLayout r1, ImageView r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.icon = r2;
        this.iconBg = r3;
        this.iconSelected = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppIconBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppIconBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_icon, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppIconBinding bind(View r4) {
        int r0 = R.id.icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.icon);
        if (r1 == null) goto L11;
        r0 = R.id.icon_bg;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.icon_bg);
        if (r2 == null) goto L11;
        r0 = R.id.icon_selected;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.icon_selected);
        if (r3 == null) goto L11;
        return new AppIconBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
