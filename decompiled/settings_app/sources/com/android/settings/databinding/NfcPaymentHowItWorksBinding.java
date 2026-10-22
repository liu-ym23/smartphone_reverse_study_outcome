package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcPaymentHowItWorksBinding implements ViewBinding {
    public final Button nfcHowItWorksButton;
    public final TextView nfcHowItWorksContent;
    public final ImageView nfcHowItWorksImage;
    public final LinearLayout nfcHowItWorksImageText;
    public final TextView nfcHowItWorksTitle;
    private final FrameLayout rootView;
    public final FrameLayout trustedDevicesPromptLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NfcPaymentHowItWorksBinding(FrameLayout r1, Button r2, TextView r3, ImageView r4, LinearLayout r5, TextView r6, FrameLayout r7) {
        this.rootView = r1;
        this.nfcHowItWorksButton = r2;
        this.nfcHowItWorksContent = r3;
        this.nfcHowItWorksImage = r4;
        this.nfcHowItWorksImageText = r5;
        this.nfcHowItWorksTitle = r6;
        this.trustedDevicesPromptLayout = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static NfcPaymentHowItWorksBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NfcPaymentHowItWorksBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.nfc_payment_how_it_works, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NfcPaymentHowItWorksBinding bind(View r10) {
        int r0 = R.id.nfc_how_it_works_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r10, R.id.nfc_how_it_works_button);
        if (r4 == null) goto L15;
        r0 = R.id.nfc_how_it_works_content;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, R.id.nfc_how_it_works_content);
        if (r5 == null) goto L15;
        r0 = R.id.nfc_how_it_works_image;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.nfc_how_it_works_image);
        if (r6 == null) goto L15;
        r0 = R.id.nfc_how_it_works_image_text;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.nfc_how_it_works_image_text);
        if (r7 == null) goto L15;
        r0 = R.id.nfc_how_it_works_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.nfc_how_it_works_title);
        if (r8 == null) goto L15;
        FrameLayout r9 = (FrameLayout) r10;
        return new NfcPaymentHowItWorksBinding(r9, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
