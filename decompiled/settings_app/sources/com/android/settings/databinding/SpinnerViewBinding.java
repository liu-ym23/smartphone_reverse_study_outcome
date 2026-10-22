package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SpinnerViewBinding implements ViewBinding {
    public final Spinner profileSpinner;
    private final Spinner rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SpinnerViewBinding(Spinner r1, Spinner r2) {
        this.rootView = r1;
        this.profileSpinner = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Spinner getRoot() {
        return this.rootView;
    }

    public static SpinnerViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SpinnerViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.spinner_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SpinnerViewBinding bind(View r1) {
        if (r1 == null) goto L6;
        Spinner r2 = (Spinner) r1;
        return new SpinnerViewBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
