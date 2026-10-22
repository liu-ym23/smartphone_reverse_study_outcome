package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneBigbangGifAnimLayoutBinding implements ViewBinding {
    public final ImageView ivCircleIcon;
    public final ImageView ivCircleText;
    public final ImageView ivMagnifier;
    public final ImageView ivMask;
    public final ImageView ivSmallWindow;
    private final View rootView;

    private RevoneBigbangGifAnimLayoutBinding(View r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6) {
        this.rootView = r1;
        this.ivCircleIcon = r2;
        this.ivCircleText = r3;
        this.ivMagnifier = r4;
        this.ivMask = r5;
        this.ivSmallWindow = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static RevoneBigbangGifAnimLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.revone_bigbang_gif_anim_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static RevoneBigbangGifAnimLayoutBinding bind(View r9) {
        int r0 = R.id.iv_circle_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_circle_icon);
        if (r4 == null) goto L15;
        r0 = R.id.iv_circle_text;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_circle_text);
        if (r5 == null) goto L15;
        r0 = R.id.iv_magnifier;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_magnifier);
        if (r6 == null) goto L15;
        r0 = R.id.iv_mask;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_mask);
        if (r7 == null) goto L15;
        r0 = R.id.iv_small_window;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_small_window);
        if (r8 == null) goto L15;
        return new RevoneBigbangGifAnimLayoutBinding(r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
