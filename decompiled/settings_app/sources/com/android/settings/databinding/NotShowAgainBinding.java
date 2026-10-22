package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NotShowAgainBinding implements ViewBinding {
    public final CheckBox check;
    private final CheckBox rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotShowAgainBinding(CheckBox r1, CheckBox r2) {
        this.rootView = r1;
        this.check = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CheckBox getRoot() {
        return this.rootView;
    }

    public static NotShowAgainBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotShowAgainBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.not_show_again, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotShowAgainBinding bind(View r1) {
        if (r1 == null) goto L6;
        CheckBox r2 = (CheckBox) r1;
        return new NotShowAgainBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
