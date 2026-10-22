package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class ListContentItemButtonBinding implements ViewBinding {
    public final FrameLayout btnLayout;
    public final OButton itemButton;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemButtonBinding(FrameLayout r1, FrameLayout r2, OButton r3) {
        this.rootView = r1;
        this.btnLayout = r2;
        this.itemButton = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemButtonBinding bind(View r3) {
        int r0 = R.id.btnLayout;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r3, R.id.btnLayout);
        if (r1 == null) goto L9;
        r0 = R.id.item_button;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r3, R.id.item_button);
        if (r2 == null) goto L9;
        return new ListContentItemButtonBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
