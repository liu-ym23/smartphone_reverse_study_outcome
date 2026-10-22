package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FrontFingerprintAnimView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewFingerprintBackgroundBinding implements ViewBinding {
    public final FrontFingerprintAnimView fpAnimView;
    public final LinearLayout fpIllustration;
    public final TextView licenseText;
    private final RelativeLayout rootView;
    public final LinearLayout tipContainer;
    public final OTextView tipsText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewFingerprintBackgroundBinding(RelativeLayout r1, FrontFingerprintAnimView r2, LinearLayout r3, TextView r4, LinearLayout r5, OTextView r6) {
        this.rootView = r1;
        this.fpAnimView = r2;
        this.fpIllustration = r3;
        this.licenseText = r4;
        this.tipContainer = r5;
        this.tipsText = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewFingerprintBackgroundBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewFingerprintBackgroundBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_fingerprint_background, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewFingerprintBackgroundBinding bind(View r9) {
        int r0 = R.id.fp_anim_view;
        FrontFingerprintAnimView r4 = (FrontFingerprintAnimView) ViewBindings.findChildViewById(r9, R.id.fp_anim_view);
        if (r4 == null) goto L15;
        r0 = R.id.fp_illustration;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.fp_illustration);
        if (r5 == null) goto L15;
        r0 = R.id.license_text;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.license_text);
        if (r6 == null) goto L15;
        r0 = R.id.tip_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.tip_container);
        if (r7 == null) goto L15;
        r0 = R.id.tips_text;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r9, R.id.tips_text);
        if (r8 == null) goto L15;
        return new ViewFingerprintBackgroundBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
