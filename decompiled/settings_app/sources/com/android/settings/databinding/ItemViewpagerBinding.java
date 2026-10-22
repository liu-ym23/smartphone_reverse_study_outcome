package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemViewpagerBinding implements ViewBinding {
    public final LinearLayout bottomIconContainer;
    private final LinearLayout rootView;
    public final LinearLayout topIconContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ItemViewpagerBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3) {
        this.rootView = r1;
        this.bottomIconContainer = r2;
        this.topIconContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemViewpagerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemViewpagerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_viewpager, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemViewpagerBinding bind(View r3) {
        int r0 = R.id.bottom_icon_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.bottom_icon_container);
        if (r1 == null) goto L9;
        r0 = R.id.top_icon_container;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.top_icon_container);
        if (r2 == null) goto L9;
        return new ItemViewpagerBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
