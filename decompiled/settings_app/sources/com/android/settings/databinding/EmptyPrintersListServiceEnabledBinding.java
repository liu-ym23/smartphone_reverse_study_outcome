package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyPrintersListServiceEnabledBinding implements ViewBinding {
    public final FrameLayout emptyPrintersListServiceEnabled;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EmptyPrintersListServiceEnabledBinding(FrameLayout r1, FrameLayout r2) {
        this.rootView = r1;
        this.emptyPrintersListServiceEnabled = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EmptyPrintersListServiceEnabledBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EmptyPrintersListServiceEnabledBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.empty_printers_list_service_enabled, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EmptyPrintersListServiceEnabledBinding bind(View r1) {
        if (r1 == null) goto L6;
        FrameLayout r2 = (FrameLayout) r1;
        return new EmptyPrintersListServiceEnabledBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
