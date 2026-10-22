package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ListScreenRefreshRateItemBinding implements ViewBinding {
    public final OCardListItem item;
    public final FrameLayout listItemContainer;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListScreenRefreshRateItemBinding(FrameLayout r1, OCardListItem r2, FrameLayout r3) {
        this.rootView = r1;
        this.item = r2;
        this.listItemContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ListScreenRefreshRateItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListScreenRefreshRateItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_screen_refresh_rate_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListScreenRefreshRateItemBinding bind(View r2) {
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r2, R.id.item);
        if (r1 == null) goto L7;
        FrameLayout r3 = (FrameLayout) r2;
        return new ListScreenRefreshRateItemBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item)));
    }
}
