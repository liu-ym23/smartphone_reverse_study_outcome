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
public final class RestrictedPopupMenuItemBinding implements ViewBinding {
    public final ImageView restrictedIcon;
    private final RelativeLayout rootView;
    public final TextView text;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RestrictedPopupMenuItemBinding(RelativeLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.restrictedIcon = r2;
        this.text = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RestrictedPopupMenuItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RestrictedPopupMenuItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.restricted_popup_menu_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RestrictedPopupMenuItemBinding bind(View r3) {
        int r0 = R.id.restricted_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.restricted_icon);
        if (r1 == null) goto L9;
        r0 = R.id.text;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.text);
        if (r2 == null) goto L9;
        return new RestrictedPopupMenuItemBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
