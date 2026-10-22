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

/* JADX INFO: loaded from: classes2.dex */
public final class NfcPaymentEmptyBinding implements ViewBinding {
    public final TextView nfcPaymentEmptyText;
    public final ImageView nfcPaymentTapImage;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NfcPaymentEmptyBinding(LinearLayout r1, TextView r2, ImageView r3) {
        this.rootView = r1;
        this.nfcPaymentEmptyText = r2;
        this.nfcPaymentTapImage = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NfcPaymentEmptyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NfcPaymentEmptyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.nfc_payment_empty, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NfcPaymentEmptyBinding bind(View r3) {
        int r0 = R.id.nfc_payment_empty_text;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.nfc_payment_empty_text);
        if (r1 == null) goto L9;
        r0 = R.id.nfc_payment_tap_image;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.nfc_payment_tap_image);
        if (r2 == null) goto L9;
        return new NfcPaymentEmptyBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
