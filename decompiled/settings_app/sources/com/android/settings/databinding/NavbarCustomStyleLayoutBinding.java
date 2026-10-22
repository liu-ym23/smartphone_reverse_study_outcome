package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public final class NavbarCustomStyleLayoutBinding implements ViewBinding {
    public final ImageView customBackIcon;
    public final ImageView customHomeIcon;
    public final ImageView customMenuIcon;
    public final OCheckBox customStyleCheckbox;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NavbarCustomStyleLayoutBinding(LinearLayout r1, ImageView r2, ImageView r3, ImageView r4, OCheckBox r5) {
        this.rootView = r1;
        this.customBackIcon = r2;
        this.customHomeIcon = r3;
        this.customMenuIcon = r4;
        this.customStyleCheckbox = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavbarCustomStyleLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NavbarCustomStyleLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.navbar_custom_style_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NavbarCustomStyleLayoutBinding bind(View r8) {
        int r0 = R.id.custom_back_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.custom_back_icon);
        if (r4 == null) goto L13;
        r0 = R.id.custom_home_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.custom_home_icon);
        if (r5 == null) goto L13;
        r0 = R.id.custom_menu_icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.custom_menu_icon);
        if (r6 == null) goto L13;
        r0 = R.id.custom_style_checkbox;
        OCheckBox r7 = (OCheckBox) ViewBindings.findChildViewById(r8, R.id.custom_style_checkbox);
        if (r7 == null) goto L13;
        return new NavbarCustomStyleLayoutBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
