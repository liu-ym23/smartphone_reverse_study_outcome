package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchAreaAnimViewLayoutBinding implements ViewBinding {
    public final ImageView innerCircle;
    public final ImageView outerCircle;
    public final ImageView radiationCircle;
    private final RelativeLayout rootView;
    public final ImageView touchView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TouchAreaAnimViewLayoutBinding(RelativeLayout r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5) {
        this.rootView = r1;
        this.innerCircle = r2;
        this.outerCircle = r3;
        this.radiationCircle = r4;
        this.touchView = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TouchAreaAnimViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TouchAreaAnimViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.touch_area_anim_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TouchAreaAnimViewLayoutBinding bind(View r8) {
        int r0 = R.id.inner_circle;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.inner_circle);
        if (r4 == null) goto L13;
        r0 = R.id.outer_circle;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.outer_circle);
        if (r5 == null) goto L13;
        r0 = R.id.radiation_circle;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.radiation_circle);
        if (r6 == null) goto L13;
        r0 = R.id.touch_view;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r8, R.id.touch_view);
        if (r7 == null) goto L13;
        return new TouchAreaAnimViewLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
