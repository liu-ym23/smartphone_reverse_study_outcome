package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDomainsDialogBinding implements ViewBinding {
    public final OListView list;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppDomainsDialogBinding(FrameLayout r1, OListView r2) {
        this.rootView = r1;
        this.list = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AppDomainsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppDomainsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_domains_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppDomainsDialogBinding bind(View r2) {
        OListView r1 = (OListView) ViewBindings.findChildViewById(r2, android.R.id.list);
        if (r1 == null) goto L7;
        return new AppDomainsDialogBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(android.R.id.list)));
    }
}
