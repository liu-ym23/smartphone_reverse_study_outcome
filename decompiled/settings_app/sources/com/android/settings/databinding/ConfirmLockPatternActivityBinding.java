package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmLockPatternActivityBinding implements ViewBinding {
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConfirmLockPatternActivityBinding(RelativeLayout r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ConfirmLockPatternActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConfirmLockPatternActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.confirm_lock_pattern_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConfirmLockPatternActivityBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new ConfirmLockPatternActivityBinding((RelativeLayout) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
