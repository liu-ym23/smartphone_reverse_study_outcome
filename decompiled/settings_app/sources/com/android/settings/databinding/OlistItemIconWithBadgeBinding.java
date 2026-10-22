package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OlistItemIconWithBadgeBinding implements ViewBinding {
    public final FrameLayout iconContainer;
    public final ImageView ivContentImg;
    public final ImageView ivDopplegangerIcon;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OlistItemIconWithBadgeBinding(FrameLayout r1, FrameLayout r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.iconContainer = r2;
        this.ivContentImg = r3;
        this.ivDopplegangerIcon = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OlistItemIconWithBadgeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OlistItemIconWithBadgeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.olist_item_icon_with_badge, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OlistItemIconWithBadgeBinding bind(View r4) {
        int r0 = R.id.icon_container;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.icon_container);
        if (r1 == null) goto L11;
        r0 = R.id.iv_content_img;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.iv_content_img);
        if (r2 == null) goto L11;
        r0 = R.id.iv_doppleganger_icon;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.iv_doppleganger_icon);
        if (r3 == null) goto L11;
        return new OlistItemIconWithBadgeBinding((FrameLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
