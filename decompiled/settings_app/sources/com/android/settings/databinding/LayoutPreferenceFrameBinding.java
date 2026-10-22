package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutPreferenceFrameBinding implements ViewBinding {
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutPreferenceFrameBinding(FrameLayout r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPreferenceFrameBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutPreferenceFrameBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_preference_frame, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutPreferenceFrameBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new LayoutPreferenceFrameBinding((FrameLayout) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
