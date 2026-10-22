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
public final class OlistContentItemTextOptimizeBinding implements ViewBinding {
    public final FrameLayout iconContainer;
    public final ImageView ivContentImg;
    public final ImageView ivDopplegangerIcon;
    public final ImageView ivTrailing;
    private final RelativeLayout rootView;
    public final LinearLayout trailingContainer;
    public final TextView tvContentSubtitle;
    public final TextView tvContentTitle;
    public final TextView tvTrailing;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OlistContentItemTextOptimizeBinding(RelativeLayout r1, FrameLayout r2, ImageView r3, ImageView r4, ImageView r5, LinearLayout r6, TextView r7, TextView r8, TextView r9) {
        this.rootView = r1;
        this.iconContainer = r2;
        this.ivContentImg = r3;
        this.ivDopplegangerIcon = r4;
        this.ivTrailing = r5;
        this.trailingContainer = r6;
        this.tvContentSubtitle = r7;
        this.tvContentTitle = r8;
        this.tvTrailing = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OlistContentItemTextOptimizeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OlistContentItemTextOptimizeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.olist_content_item_text_optimize, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OlistContentItemTextOptimizeBinding bind(View r12) {
        int r0 = R.id.icon_container;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r12, R.id.icon_container);
        if (r4 == null) goto L21;
        r0 = R.id.iv_content_img;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_content_img);
        if (r5 == null) goto L21;
        r0 = R.id.iv_doppleganger_icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_doppleganger_icon);
        if (r6 == null) goto L21;
        r0 = R.id.iv_trailing;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_trailing);
        if (r7 == null) goto L21;
        r0 = R.id.trailing_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.trailing_container);
        if (r8 == null) goto L21;
        r0 = R.id.tv_content_subtitle;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, R.id.tv_content_subtitle);
        if (r9 == null) goto L21;
        r0 = R.id.tv_content_title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.tv_content_title);
        if (r10 == null) goto L21;
        r0 = R.id.tv_trailing;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r12, R.id.tv_trailing);
        if (r11 == null) goto L21;
        return new OlistContentItemTextOptimizeBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
