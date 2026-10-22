package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BaseActivityXBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BaseActivityXBinding(FrameLayout r1, FrameLayout r2) {
        this.rootView = r1;
        this.fragmentContainer = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BaseActivityXBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BaseActivityXBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.base_activity_x, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BaseActivityXBinding bind(View r1) {
        if (r1 == null) goto L6;
        FrameLayout r2 = (FrameLayout) r1;
        return new BaseActivityXBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
