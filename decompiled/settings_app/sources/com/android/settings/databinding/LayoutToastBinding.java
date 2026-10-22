package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutToastBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvMsg;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutToastBinding(FrameLayout r1, TextView r2) {
        this.rootView = r1;
        this.tvMsg = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutToastBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutToastBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_toast, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutToastBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, R.id.tv_msg);
        if (r1 == null) goto L7;
        return new LayoutToastBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.tv_msg)));
    }
}
