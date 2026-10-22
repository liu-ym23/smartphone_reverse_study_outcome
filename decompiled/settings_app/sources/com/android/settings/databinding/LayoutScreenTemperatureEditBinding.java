package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutScreenTemperatureEditBinding implements ViewBinding {
    public final ImageView circleView;
    public final ImageView pointView;
    private final View rootView;

    private LayoutScreenTemperatureEditBinding(View r1, ImageView r2, ImageView r3) {
        this.rootView = r1;
        this.circleView = r2;
        this.pointView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutScreenTemperatureEditBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.layout_screen_temperature_edit, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static LayoutScreenTemperatureEditBinding bind(View r3) {
        int r0 = R.id.circle_view;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.circle_view);
        if (r1 == null) goto L9;
        r0 = R.id.point_view;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.point_view);
        if (r2 == null) goto L9;
        return new LayoutScreenTemperatureEditBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
