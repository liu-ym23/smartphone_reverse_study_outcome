package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BaseActivityLayoutBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainerView;
    private final FragmentContainerView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BaseActivityLayoutBinding(FragmentContainerView r1, FragmentContainerView r2) {
        this.rootView = r1;
        this.fragmentContainerView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FragmentContainerView getRoot() {
        return this.rootView;
    }

    public static BaseActivityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BaseActivityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.base_activity_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BaseActivityLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        FragmentContainerView r2 = (FragmentContainerView) r1;
        return new BaseActivityLayoutBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
