package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class ManagedServiceSettingsBinding implements ViewBinding {
    public final TextView empty;
    public final OListView list;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManagedServiceSettingsBinding(LinearLayout r1, TextView r2, OListView r3) {
        this.rootView = r1;
        this.empty = r2;
        this.list = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManagedServiceSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManagedServiceSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.managed_service_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManagedServiceSettingsBinding bind(View r3) {
        int r0 = android.R.id.empty;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.empty);
        if (r1 == null) goto L9;
        r0 = android.R.id.list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r3, android.R.id.list);
        if (r2 == null) goto L9;
        return new ManagedServiceSettingsBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
