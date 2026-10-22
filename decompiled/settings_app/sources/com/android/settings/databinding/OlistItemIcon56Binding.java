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
public final class OlistItemIcon56Binding implements ViewBinding {
    public final FrameLayout iconContainer;
    public final ImageView ivContentImg;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OlistItemIcon56Binding(FrameLayout r1, FrameLayout r2, ImageView r3) {
        this.rootView = r1;
        this.iconContainer = r2;
        this.ivContentImg = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OlistItemIcon56Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OlistItemIcon56Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.olist_item_icon_56, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OlistItemIcon56Binding bind(View r3) {
        int r0 = R.id.icon_container;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r3, R.id.icon_container);
        if (r1 == null) goto L9;
        r0 = R.id.iv_content_img;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.iv_content_img);
        if (r2 == null) goto L9;
        return new OlistItemIcon56Binding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
