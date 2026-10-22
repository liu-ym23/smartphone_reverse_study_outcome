package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.lockpatternview.KeyguardLockPatternView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewLockpatternInputBinding implements ViewBinding {
    public final KeyguardLockPatternView lockPattern;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewLockpatternInputBinding(FrameLayout r1, KeyguardLockPatternView r2) {
        this.rootView = r1;
        this.lockPattern = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewLockpatternInputBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewLockpatternInputBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_lockpattern_input, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewLockpatternInputBinding bind(View r2) {
        KeyguardLockPatternView r1 = (KeyguardLockPatternView) ViewBindings.findChildViewById(r2, R.id.lockPattern);
        if (r1 == null) goto L7;
        return new ViewLockpatternInputBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.lockPattern)));
    }
}
