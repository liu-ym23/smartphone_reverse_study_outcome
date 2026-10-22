package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DatausageListFooterViewBinding implements ViewBinding {
    public final View emptyView;
    private final LinearLayout rootView;
    public final ListContentItemText systemApp;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DatausageListFooterViewBinding(LinearLayout r1, View r2, ListContentItemText r3) {
        this.rootView = r1;
        this.emptyView = r2;
        this.systemApp = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DatausageListFooterViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DatausageListFooterViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.datausage_list_footer_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DatausageListFooterViewBinding bind(View r3) {
        int r0 = R.id.empty_view;
        View r1 = ViewBindings.findChildViewById(r3, R.id.empty_view);
        if (r1 == null) goto L9;
        r0 = R.id.system_app;
        ListContentItemText r2 = (ListContentItemText) ViewBindings.findChildViewById(r3, R.id.system_app);
        if (r2 == null) goto L9;
        return new DatausageListFooterViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
