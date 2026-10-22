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
public final class ScreenZoomPreviewAppIconBinding implements ViewBinding {
    public final ImageView icon1;
    private final FrameLayout rootView;
    public final TextView text1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenZoomPreviewAppIconBinding(FrameLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.icon1 = r2;
        this.text1 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ScreenZoomPreviewAppIconBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenZoomPreviewAppIconBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_zoom_preview_app_icon, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenZoomPreviewAppIconBinding bind(View r3) {
        int r0 = android.R.id.icon1;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, android.R.id.icon1);
        if (r1 == null) goto L9;
        r0 = android.R.id.text1;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.text1);
        if (r2 == null) goto L9;
        return new ScreenZoomPreviewAppIconBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
