package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.applications.LinearColorBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceLinearcolorBinding implements ViewBinding {
    public final LinearColorBar linearColorBar;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceLinearcolorBinding(FrameLayout r1, LinearColorBar r2) {
        this.rootView = r1;
        this.linearColorBar = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceLinearcolorBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceLinearcolorBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_linearcolor, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceLinearcolorBinding bind(View r2) {
        LinearColorBar r1 = (LinearColorBar) ViewBindings.findChildViewById(r2, R.id.linear_color_bar);
        if (r1 == null) goto L7;
        return new PreferenceLinearcolorBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.linear_color_bar)));
    }
}
