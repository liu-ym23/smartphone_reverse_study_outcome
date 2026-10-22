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
public final class SettingItemCheckSimpleTextBinding implements ViewBinding {
    public final ImageView itemArrow;
    public final ImageView itemCheck;
    public final TextView itemSubtitle;
    public final TextView itemSummary;
    public final TextView itemTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingItemCheckSimpleTextBinding(LinearLayout r1, ImageView r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.itemArrow = r2;
        this.itemCheck = r3;
        this.itemSubtitle = r4;
        this.itemSummary = r5;
        this.itemTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingItemCheckSimpleTextBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingItemCheckSimpleTextBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_item_check_simple_text, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingItemCheckSimpleTextBinding bind(View r9) {
        int r0 = R.id.item_arrow;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.item_arrow);
        if (r4 == null) goto L15;
        r0 = R.id.item_check;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.item_check);
        if (r5 == null) goto L15;
        r0 = R.id.item_subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.item_subtitle);
        if (r6 == null) goto L15;
        r0 = R.id.item_summary;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.item_summary);
        if (r7 == null) goto L15;
        r0 = R.id.item_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.item_title);
        if (r8 == null) goto L15;
        return new SettingItemCheckSimpleTextBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
