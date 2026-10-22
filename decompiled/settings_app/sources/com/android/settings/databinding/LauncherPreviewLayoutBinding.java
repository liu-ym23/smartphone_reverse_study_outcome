package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.PreviewOptionItemView;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherPreviewLayoutBinding implements ViewBinding {
    public final LinearLayout bottomLayout;
    public final ImageView divView;
    public final PreviewOptionItemView idClassic;
    public final ImageView idFrame;
    public final PreviewOptionItemView idGrid12;
    public final PreviewOptionItemView idGrid16;
    public final PreviewOptionItemView idGrid20;
    public final PreviewOptionItemView idGrid9;
    public final ImageView idPreview;
    public final PreviewOptionItemView idTransparentTheme;
    public final LinearLayout middleLayout;
    private final View rootView;

    private LauncherPreviewLayoutBinding(View r1, LinearLayout r2, ImageView r3, PreviewOptionItemView r4, ImageView r5, PreviewOptionItemView r6, PreviewOptionItemView r7, PreviewOptionItemView r8, PreviewOptionItemView r9, ImageView r10, PreviewOptionItemView r11, LinearLayout r12) {
        this.rootView = r1;
        this.bottomLayout = r2;
        this.divView = r3;
        this.idClassic = r4;
        this.idFrame = r5;
        this.idGrid12 = r6;
        this.idGrid16 = r7;
        this.idGrid20 = r8;
        this.idGrid9 = r9;
        this.idPreview = r10;
        this.idTransparentTheme = r11;
        this.middleLayout = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LauncherPreviewLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.launcher_preview_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static LauncherPreviewLayoutBinding bind(View r15) {
        int r0 = R.id.bottom_layout;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.bottom_layout);
        if (r4 == null) goto L27;
        r0 = R.id.div_view;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r15, R.id.div_view);
        if (r5 == null) goto L27;
        r0 = R.id.id_classic;
        PreviewOptionItemView r6 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_classic);
        if (r6 == null) goto L27;
        r0 = R.id.id_frame;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r15, R.id.id_frame);
        if (r7 == null) goto L27;
        r0 = R.id.id_grid_12;
        PreviewOptionItemView r8 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_grid_12);
        if (r8 == null) goto L27;
        r0 = R.id.id_grid_16;
        PreviewOptionItemView r9 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_grid_16);
        if (r9 == null) goto L27;
        r0 = R.id.id_grid_20;
        PreviewOptionItemView r10 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_grid_20);
        if (r10 == null) goto L27;
        r0 = R.id.id_grid_9;
        PreviewOptionItemView r11 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_grid_9);
        if (r11 == null) goto L27;
        r0 = R.id.id_preview;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r15, R.id.id_preview);
        if (r12 == null) goto L27;
        r0 = R.id.id_transparent_theme;
        PreviewOptionItemView r13 = (PreviewOptionItemView) ViewBindings.findChildViewById(r15, R.id.id_transparent_theme);
        if (r13 == null) goto L27;
        r0 = R.id.middle_layout;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.middle_layout);
        if (r14 == null) goto L27;
        return new LauncherPreviewLayoutBinding(r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
