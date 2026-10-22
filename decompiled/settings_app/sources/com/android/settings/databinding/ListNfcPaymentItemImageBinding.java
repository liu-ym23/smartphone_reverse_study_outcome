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
public final class ListNfcPaymentItemImageBinding implements ViewBinding {
    public final OCardListItem itemNoPayment;
    public final OCardListItem itemView;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListNfcPaymentItemImageBinding(FrameLayout r1, OCardListItem r2, OCardListItem r3) {
        this.rootView = r1;
        this.itemNoPayment = r2;
        this.itemView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ListNfcPaymentItemImageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListNfcPaymentItemImageBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_nfc_payment_item_image, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListNfcPaymentItemImageBinding bind(View r3) {
        int r0 = R.id.item_no_payment;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.item_no_payment);
        if (r1 == null) goto L9;
        r0 = R.id.item_view;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.item_view);
        if (r2 == null) goto L9;
        return new ListNfcPaymentItemImageBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
