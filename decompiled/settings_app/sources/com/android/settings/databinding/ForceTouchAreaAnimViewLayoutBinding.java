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
public final class ForceTouchAreaAnimViewLayoutBinding implements ViewBinding {
    public final FrameLayout idAnimRootContainer;
    public final ImageView innerCircle;
    public final ImageView outerCircle;
    public final ImageView radiationCircle;
    private final FrameLayout rootView;
    public final ImageView touchView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ForceTouchAreaAnimViewLayoutBinding(FrameLayout r1, FrameLayout r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6) {
        this.rootView = r1;
        this.idAnimRootContainer = r2;
        this.innerCircle = r3;
        this.outerCircle = r4;
        this.radiationCircle = r5;
        this.touchView = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ForceTouchAreaAnimViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ForceTouchAreaAnimViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.force_touch_area_anim_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ForceTouchAreaAnimViewLayoutBinding bind(View r7) {
        FrameLayout r2 = (FrameLayout) r7;
        int r0 = R.id.inner_circle;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r7, R.id.inner_circle);
        if (r3 == null) goto L13;
        r0 = R.id.outer_circle;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r7, R.id.outer_circle);
        if (r4 == null) goto L13;
        r0 = R.id.radiation_circle;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r7, R.id.radiation_circle);
        if (r5 == null) goto L13;
        r0 = R.id.touch_view;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r7, R.id.touch_view);
        if (r6 == null) goto L13;
        return new ForceTouchAreaAnimViewLayoutBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
