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
public final class ColorThemeItemLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView selectedIcon;
    public final ImageView themeIcon;
    public final TextView themeName;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ColorThemeItemLayoutBinding(LinearLayout r1, ImageView r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.selectedIcon = r2;
        this.themeIcon = r3;
        this.themeName = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorThemeItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ColorThemeItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.color_theme_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ColorThemeItemLayoutBinding bind(View r4) {
        int r0 = R.id.selected_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.selected_icon);
        if (r1 == null) goto L11;
        r0 = R.id.theme_icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.theme_icon);
        if (r2 == null) goto L11;
        r0 = R.id.theme_name;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.theme_name);
        if (r3 == null) goto L11;
        return new ColorThemeItemLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
