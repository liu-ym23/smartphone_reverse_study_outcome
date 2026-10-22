package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.button.OIconButton;

/* JADX INFO: loaded from: classes2.dex */
public final class FOicButtonBinding implements ViewBinding {
    private final OIconButton rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FOicButtonBinding(OIconButton r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OIconButton getRoot() {
        return this.rootView;
    }

    public static FOicButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FOicButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.f_oic_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FOicButtonBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new FOicButtonBinding((OIconButton) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
