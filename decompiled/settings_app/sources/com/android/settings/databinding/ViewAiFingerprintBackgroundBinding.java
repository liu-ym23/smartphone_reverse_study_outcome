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
import com.android.settings.widget.AIPoweredFingerprintGuideAnimView;
import com.android.settings.widget.FrontFingerprintAnimView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewAiFingerprintBackgroundBinding implements ViewBinding {
    public final AIPoweredFingerprintGuideAnimView aiKeyGuideAnimView;
    public final FrontFingerprintAnimView fpAnimView;
    public final LinearLayout fpIllustration;
    public final OTextView introductionSubTip;
    public final TextView licenseText;
    private final RelativeLayout rootView;
    public final LinearLayout tipContainer;
    public final OTextView tipsText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewAiFingerprintBackgroundBinding(RelativeLayout r1, AIPoweredFingerprintGuideAnimView r2, FrontFingerprintAnimView r3, LinearLayout r4, OTextView r5, TextView r6, LinearLayout r7, OTextView r8) {
        this.rootView = r1;
        this.aiKeyGuideAnimView = r2;
        this.fpAnimView = r3;
        this.fpIllustration = r4;
        this.introductionSubTip = r5;
        this.licenseText = r6;
        this.tipContainer = r7;
        this.tipsText = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewAiFingerprintBackgroundBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewAiFingerprintBackgroundBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_ai_fingerprint_background, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewAiFingerprintBackgroundBinding bind(View r11) {
        int r0 = R.id.ai_key_guide_anim_view;
        AIPoweredFingerprintGuideAnimView r4 = (AIPoweredFingerprintGuideAnimView) ViewBindings.findChildViewById(r11, R.id.ai_key_guide_anim_view);
        if (r4 == null) goto L19;
        r0 = R.id.fp_anim_view;
        FrontFingerprintAnimView r5 = (FrontFingerprintAnimView) ViewBindings.findChildViewById(r11, R.id.fp_anim_view);
        if (r5 == null) goto L19;
        r0 = R.id.fp_illustration;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.fp_illustration);
        if (r6 == null) goto L19;
        r0 = R.id.introduction_sub_tip;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r11, R.id.introduction_sub_tip);
        if (r7 == null) goto L19;
        r0 = R.id.license_text;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.license_text);
        if (r8 == null) goto L19;
        r0 = R.id.tip_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.tip_container);
        if (r9 == null) goto L19;
        r0 = R.id.tips_text;
        OTextView r10 = (OTextView) ViewBindings.findChildViewById(r11, R.id.tips_text);
        if (r10 == null) goto L19;
        return new ViewAiFingerprintBackgroundBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
