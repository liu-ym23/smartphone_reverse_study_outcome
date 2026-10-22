package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewOptionItemLayoutBinding implements ViewBinding {
    public final FrameLayout iconAreaLayout;
    public final ImageView itemImg;
    private final View rootView;
    public final ImageView selectedImg;
    public final TextView title;

    private PreviewOptionItemLayoutBinding(View r1, FrameLayout r2, ImageView r3, ImageView r4, TextView r5) {
        this.rootView = r1;
        this.iconAreaLayout = r2;
        this.itemImg = r3;
        this.selectedImg = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static PreviewOptionItemLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.preview_option_item_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static PreviewOptionItemLayoutBinding bind(View r8) {
        int r0 = R.id.icon_area_layout;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.icon_area_layout);
        if (r4 == null) goto L13;
        r0 = R.id.item_img;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.item_img);
        if (r5 == null) goto L13;
        r0 = R.id.selected_img;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.selected_img);
        if (r6 == null) goto L13;
        r0 = R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.title);
        if (r7 == null) goto L13;
        return new PreviewOptionItemLayoutBinding(r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
