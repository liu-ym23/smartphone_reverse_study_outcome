package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.PreviewOptionItemView;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationbarPreviewLayoutBinding implements ViewBinding {
    public final ListContentItemCustom bottomLayout;
    public final ImageView divView;
    public final ImageView idFrame;
    public final ImageView idFrameDisable;
    public final PreviewOptionItemView idNavbarBlackTheme;
    public final PreviewOptionItemView idNavbarClassic;
    public final PreviewOptionItemView idNavbarGrayTheme;
    public final TextView idNavbarModeSettingTitle;
    public final PreviewOptionItemView idNavbarNarrow;
    public final PreviewOptionItemView idNavbarRedWineTheme;
    public final ImageView idPreview;
    public final ImageView ivLineLeftOfWineRed;
    public final ListContentItemCustom middleLayout;
    private final View rootView;

    private NavigationbarPreviewLayoutBinding(View r1, ListContentItemCustom r2, ImageView r3, ImageView r4, ImageView r5, PreviewOptionItemView r6, PreviewOptionItemView r7, PreviewOptionItemView r8, TextView r9, PreviewOptionItemView r10, PreviewOptionItemView r11, ImageView r12, ImageView r13, ListContentItemCustom r14) {
        this.rootView = r1;
        this.bottomLayout = r2;
        this.divView = r3;
        this.idFrame = r4;
        this.idFrameDisable = r5;
        this.idNavbarBlackTheme = r6;
        this.idNavbarClassic = r7;
        this.idNavbarGrayTheme = r8;
        this.idNavbarModeSettingTitle = r9;
        this.idNavbarNarrow = r10;
        this.idNavbarRedWineTheme = r11;
        this.idPreview = r12;
        this.ivLineLeftOfWineRed = r13;
        this.middleLayout = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static NavigationbarPreviewLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.navigationbar_preview_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static NavigationbarPreviewLayoutBinding bind(View r16) {
        int r0 = R.id.bottom_layout;
        ListContentItemCustom r2 = (ListContentItemCustom) ViewBindings.findChildViewById(r16, R.id.bottom_layout);
        if (r2 == null) goto L31;
        r0 = R.id.div_view;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r16, R.id.div_view);
        if (r3 == null) goto L31;
        r0 = R.id.id_frame;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r16, R.id.id_frame);
        if (r4 == null) goto L31;
        r0 = R.id.id_frame_disable;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r16, R.id.id_frame_disable);
        if (r5 == null) goto L31;
        r0 = R.id.id_navbar_black_theme;
        PreviewOptionItemView r6 = (PreviewOptionItemView) ViewBindings.findChildViewById(r16, R.id.id_navbar_black_theme);
        if (r6 == null) goto L31;
        r0 = R.id.id_navbar_classic;
        PreviewOptionItemView r7 = (PreviewOptionItemView) ViewBindings.findChildViewById(r16, R.id.id_navbar_classic);
        if (r7 == null) goto L31;
        r0 = R.id.id_navbar_gray_theme;
        PreviewOptionItemView r8 = (PreviewOptionItemView) ViewBindings.findChildViewById(r16, R.id.id_navbar_gray_theme);
        if (r8 == null) goto L31;
        r0 = R.id.id_navbar_mode_setting_title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r16, R.id.id_navbar_mode_setting_title);
        if (r9 == null) goto L31;
        r0 = R.id.id_navbar_narrow;
        PreviewOptionItemView r10 = (PreviewOptionItemView) ViewBindings.findChildViewById(r16, R.id.id_navbar_narrow);
        if (r10 == null) goto L31;
        r0 = R.id.id_navbar_red_wine_theme;
        PreviewOptionItemView r11 = (PreviewOptionItemView) ViewBindings.findChildViewById(r16, R.id.id_navbar_red_wine_theme);
        if (r11 == null) goto L31;
        r0 = R.id.id_preview;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r16, R.id.id_preview);
        if (r12 == null) goto L31;
        r0 = R.id.iv_line_left_of_wine_red;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r16, R.id.iv_line_left_of_wine_red);
        if (r13 == null) goto L31;
        r0 = R.id.middle_layout;
        ListContentItemCustom r14 = (ListContentItemCustom) ViewBindings.findChildViewById(r16, R.id.middle_layout);
        if (r14 == null) goto L31;
        return new NavigationbarPreviewLayoutBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }
}
