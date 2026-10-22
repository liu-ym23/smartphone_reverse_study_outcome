package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.simplified.ORoundedListItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class PickItemBinding implements ViewBinding {
    public final ORoundedListItemText item;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PickItemBinding(FrameLayout r1, ORoundedListItemText r2) {
        this.rootView = r1;
        this.item = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PickItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PickItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.pick_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PickItemBinding bind(View r2) {
        ORoundedListItemText r1 = (ORoundedListItemText) ViewBindings.findChildViewById(r2, R.id.item);
        if (r1 == null) goto L7;
        return new PickItemBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item)));
    }
}
