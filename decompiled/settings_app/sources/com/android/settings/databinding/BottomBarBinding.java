package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BottomBarBinding implements ViewBinding {
    public final LinearLayout bottombar;
    public final TextView idExternal;
    public final TextView idInternal;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BottomBarBinding(LinearLayout r1, LinearLayout r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.bottombar = r2;
        this.idExternal = r3;
        this.idInternal = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomBarBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BottomBarBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bottom_bar, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BottomBarBinding bind(View r4) {
        LinearLayout r0 = (LinearLayout) r4;
        int r1 = R.id.id_external;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.id_external);
        if (r2 == null) goto L9;
        r1 = R.id.id_internal;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.id_internal);
        if (r3 == null) goto L9;
        return new BottomBarBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r1)));
    }
}
