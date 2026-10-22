package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OIconButton;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutCardListItemDeleteSwipBinding implements ViewBinding {
    public final LinearLayout bottomWrapper;
    public final OIconButton btnDelete;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutCardListItemDeleteSwipBinding(LinearLayout r1, LinearLayout r2, OIconButton r3) {
        this.rootView = r1;
        this.bottomWrapper = r2;
        this.btnDelete = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCardListItemDeleteSwipBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutCardListItemDeleteSwipBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_card_list_item_delete_swip, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutCardListItemDeleteSwipBinding bind(View r3) {
        LinearLayout r0 = (LinearLayout) r3;
        OIconButton r2 = (OIconButton) ViewBindings.findChildViewById(r3, R.id.btn_delete);
        if (r2 == null) goto L7;
        return new LayoutCardListItemDeleteSwipBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.btn_delete)));
    }
}
