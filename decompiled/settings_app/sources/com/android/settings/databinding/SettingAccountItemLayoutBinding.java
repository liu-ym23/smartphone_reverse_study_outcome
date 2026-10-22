package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingAccountItemLayoutBinding implements ViewBinding {
    public final ImageView itemArrow;
    public final ImageView itemIcon;
    public final TextView itemSubtitle;
    public final TextView itemTitle;
    private final View rootView;

    private SettingAccountItemLayoutBinding(View r1, ImageView r2, ImageView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.itemArrow = r2;
        this.itemIcon = r3;
        this.itemSubtitle = r4;
        this.itemTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static SettingAccountItemLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.setting_account_item_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static SettingAccountItemLayoutBinding bind(View r8) {
        int r0 = R.id.item_arrow;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.item_arrow);
        if (r4 == null) goto L13;
        r0 = R.id.item_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.item_icon);
        if (r5 == null) goto L13;
        r0 = R.id.item_subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.item_subtitle);
        if (r6 == null) goto L13;
        r0 = R.id.item_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.item_title);
        if (r7 == null) goto L13;
        return new SettingAccountItemLayoutBinding(r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
