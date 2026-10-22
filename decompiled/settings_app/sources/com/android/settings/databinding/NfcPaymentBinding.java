package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcPaymentBinding implements ViewBinding {
    public final OListView list;
    public final TextView nfcPaymentEmptyText;
    public final ImageView nfcPaymentTapImage;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NfcPaymentBinding(LinearLayout r1, OListView r2, TextView r3, ImageView r4) {
        this.rootView = r1;
        this.list = r2;
        this.nfcPaymentEmptyText = r3;
        this.nfcPaymentTapImage = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NfcPaymentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NfcPaymentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.nfc_payment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NfcPaymentBinding bind(View r4) {
        int r0 = android.R.id.list;
        OListView r1 = (OListView) ViewBindings.findChildViewById(r4, android.R.id.list);
        if (r1 == null) goto L11;
        r0 = R.id.nfc_payment_empty_text;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.nfc_payment_empty_text);
        if (r2 == null) goto L11;
        r0 = R.id.nfc_payment_tap_image;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.nfc_payment_tap_image);
        if (r3 == null) goto L11;
        return new NfcPaymentBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
