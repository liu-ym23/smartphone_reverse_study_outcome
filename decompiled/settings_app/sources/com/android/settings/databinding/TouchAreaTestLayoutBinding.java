package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.TouchAreaTestView;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchAreaTestLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TouchAreaTestView touchAreaView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TouchAreaTestLayoutBinding(LinearLayout r1, TouchAreaTestView r2) {
        this.rootView = r1;
        this.touchAreaView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TouchAreaTestLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TouchAreaTestLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.touch_area_test_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TouchAreaTestLayoutBinding bind(View r2) {
        TouchAreaTestView r1 = (TouchAreaTestView) ViewBindings.findChildViewById(r2, R.id.touch_area_view);
        if (r1 == null) goto L7;
        return new TouchAreaTestLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.touch_area_view)));
    }
}
