package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyPrintStateBinding implements ViewBinding {
    public final Button addNewService;
    public final FrameLayout emptyPrintState;
    public final ImageView icon;
    public final TextView message;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EmptyPrintStateBinding(FrameLayout r1, Button r2, FrameLayout r3, ImageView r4, TextView r5) {
        this.rootView = r1;
        this.addNewService = r2;
        this.emptyPrintState = r3;
        this.icon = r4;
        this.message = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EmptyPrintStateBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EmptyPrintStateBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.empty_print_state, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EmptyPrintStateBinding bind(View r8) {
        int r0 = R.id.add_new_service;
        Button r4 = (Button) ViewBindings.findChildViewById(r8, R.id.add_new_service);
        if (r4 == null) goto L11;
        FrameLayout r5 = (FrameLayout) r8;
        r0 = R.id.icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.icon);
        if (r6 == null) goto L11;
        r0 = R.id.message;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.message);
        if (r7 == null) goto L11;
        return new EmptyPrintStateBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
