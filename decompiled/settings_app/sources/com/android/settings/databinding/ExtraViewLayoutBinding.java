package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.settings.widget.SettingsBottomExtraView;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtraViewLayoutBinding implements ViewBinding {
    private final SettingsBottomExtraView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ExtraViewLayoutBinding(SettingsBottomExtraView r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SettingsBottomExtraView getRoot() {
        return this.rootView;
    }

    public static ExtraViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ExtraViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.extra_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ExtraViewLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new ExtraViewLayoutBinding((SettingsBottomExtraView) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
