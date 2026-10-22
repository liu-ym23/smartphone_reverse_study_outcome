package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcPaymentOptionBinding implements ViewBinding {
    public final ImageView banner;
    public final RadioButton button;
    public final LinearLayout nfcPaymentPref;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NfcPaymentOptionBinding(LinearLayout r1, ImageView r2, RadioButton r3, LinearLayout r4) {
        this.rootView = r1;
        this.banner = r2;
        this.button = r3;
        this.nfcPaymentPref = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NfcPaymentOptionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NfcPaymentOptionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.nfc_payment_option, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NfcPaymentOptionBinding bind(View r3) {
        int r0 = R.id.banner;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.banner);
        if (r1 == null) goto L9;
        r0 = R.id.button;
        RadioButton r2 = (RadioButton) ViewBindings.findChildViewById(r3, R.id.button);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new NfcPaymentOptionBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
