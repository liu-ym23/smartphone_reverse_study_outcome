package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.localepicker.LocaleRecyclerView;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class LocaleOrderListBinding implements ViewBinding {
    public final Button addLanguage;
    public final LocaleRecyclerView dragList;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LocaleOrderListBinding(OScrollView r1, Button r2, LocaleRecyclerView r3) {
        this.rootView = r1;
        this.addLanguage = r2;
        this.dragList = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static LocaleOrderListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LocaleOrderListBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.locale_order_list, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LocaleOrderListBinding bind(View r3) {
        int r0 = R.id.add_language;
        Button r1 = (Button) ViewBindings.findChildViewById(r3, R.id.add_language);
        if (r1 == null) goto L9;
        r0 = R.id.dragList;
        LocaleRecyclerView r2 = (LocaleRecyclerView) ViewBindings.findChildViewById(r3, R.id.dragList);
        if (r2 == null) goto L9;
        return new LocaleOrderListBinding((OScrollView) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
