package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.TouchAreaAnimView;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchAreaTestViewLayoutBinding implements ViewBinding {
    public final TouchAreaAnimView animArea;
    private final ListContentItemCustom rootView;
    public final TextView testText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TouchAreaTestViewLayoutBinding(ListContentItemCustom r1, TouchAreaAnimView r2, TextView r3) {
        this.rootView = r1;
        this.animArea = r2;
        this.testText = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ListContentItemCustom getRoot() {
        return this.rootView;
    }

    public static TouchAreaTestViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TouchAreaTestViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.touch_area_test_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TouchAreaTestViewLayoutBinding bind(View r3) {
        int r0 = R.id.anim_area;
        TouchAreaAnimView r1 = (TouchAreaAnimView) ViewBindings.findChildViewById(r3, R.id.anim_area);
        if (r1 == null) goto L9;
        r0 = R.id.test_text;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.test_text);
        if (r2 == null) goto L9;
        return new TouchAreaTestViewLayoutBinding((ListContentItemCustom) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
