package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultPaymentTipsLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final OTextView tipsDefaultPayment;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DefaultPaymentTipsLayoutBinding(LinearLayout r1, OTextView r2) {
        this.rootView = r1;
        this.tipsDefaultPayment = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DefaultPaymentTipsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DefaultPaymentTipsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.default_payment_tips_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DefaultPaymentTipsLayoutBinding bind(View r2) {
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r2, R.id.tips_default_payment);
        if (r1 == null) goto L7;
        return new DefaultPaymentTipsLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.tips_default_payment)));
    }
}
