package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.settings.widget.VerticalOptionsCheckView;

/* JADX INFO: loaded from: classes2.dex */
public final class NavbarOneHandModeStubBinding implements ViewBinding {
    public final VerticalOptionsCheckView idNavigationLayoutOneHandMode;
    private final VerticalOptionsCheckView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NavbarOneHandModeStubBinding(VerticalOptionsCheckView r1, VerticalOptionsCheckView r2) {
        this.rootView = r1;
        this.idNavigationLayoutOneHandMode = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public VerticalOptionsCheckView getRoot() {
        return this.rootView;
    }

    public static NavbarOneHandModeStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NavbarOneHandModeStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.navbar_one_hand_mode_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NavbarOneHandModeStubBinding bind(View r1) {
        if (r1 == null) goto L6;
        VerticalOptionsCheckView r2 = (VerticalOptionsCheckView) r1;
        return new NavbarOneHandModeStubBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
