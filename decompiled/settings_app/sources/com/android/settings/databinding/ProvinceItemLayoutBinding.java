package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ProvinceItemLayoutBinding implements ViewBinding {
    public final RelativeLayout appLayout;
    public final ImageView itemCheck;
    public final TextView itemTitle;
    private final FrameLayout rootView;
    public final LinearLayout scrollHandleLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProvinceItemLayoutBinding(FrameLayout r1, RelativeLayout r2, ImageView r3, TextView r4, LinearLayout r5) {
        this.rootView = r1;
        this.appLayout = r2;
        this.itemCheck = r3;
        this.itemTitle = r4;
        this.scrollHandleLayout = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ProvinceItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProvinceItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.province_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProvinceItemLayoutBinding bind(View r8) {
        int r0 = R.id.app_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r8, R.id.app_layout);
        if (r4 == null) goto L13;
        r0 = R.id.item_check;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.item_check);
        if (r5 == null) goto L13;
        r0 = R.id.item_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.item_title);
        if (r6 == null) goto L13;
        r0 = R.id.scroll_handle_layout;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.scroll_handle_layout);
        if (r7 == null) goto L13;
        return new ProvinceItemLayoutBinding((FrameLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
