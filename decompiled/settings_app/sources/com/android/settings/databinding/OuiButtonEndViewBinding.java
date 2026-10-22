package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class OuiButtonEndViewBinding implements ViewBinding {
    private final OButton rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OuiButtonEndViewBinding(OButton r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OButton getRoot() {
        return this.rootView;
    }

    public static OuiButtonEndViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OuiButtonEndViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.oui_button_end_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OuiButtonEndViewBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new OuiButtonEndViewBinding((OButton) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
