package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.android.settings.R;
import com.android.settings.widget.FrontFingerprintAnimView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollingLayoutRightSideBinding implements ViewBinding {
    public final RelativeLayout buttonsLayout;
    public final OButton enrollNextFinger;
    public final RelativeLayout enrollingLayout;
    public final LinearLayout findSensorLayout;
    public final ImageView fpAnimFinishView;
    public final FrontFingerprintAnimView fpAnimView;
    public final FrameLayout fpIllustration;
    public final LottieAnimationView fpPulse;
    public final FrameLayout fpPulseContainer;
    public final ImageView fpResultImage;
    public final OButton gotoFaceEnroll;
    public final LottieAnimationView illustrationLottie;
    public final TextView progressText;
    private final RelativeLayout rootView;
    public final TextView setupForPayment;
    public final TextView tipsText;
    public final RelativeLayout tipsView;
    public final TextView tvFindSensorTips;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollingLayoutRightSideBinding(RelativeLayout r3, RelativeLayout r4, OButton r5, RelativeLayout r6, LinearLayout r7, ImageView r8, FrontFingerprintAnimView r9, FrameLayout r10, LottieAnimationView r11, FrameLayout r12, ImageView r13, OButton r14, LottieAnimationView r15, TextView r16, TextView r17, TextView r18, RelativeLayout r19, TextView r20, OFloatingTitleBar r21) {
        this.rootView = r3;
        this.buttonsLayout = r4;
        this.enrollNextFinger = r5;
        this.enrollingLayout = r6;
        this.findSensorLayout = r7;
        this.fpAnimFinishView = r8;
        this.fpAnimView = r9;
        this.fpIllustration = r10;
        this.fpPulse = r11;
        this.fpPulseContainer = r12;
        this.fpResultImage = r13;
        this.gotoFaceEnroll = r14;
        this.illustrationLottie = r15;
        this.progressText = r16;
        this.setupForPayment = r17;
        this.tipsText = r18;
        this.tipsView = r19;
        this.tvFindSensorTips = r20;
        this.viewTitle = r21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollingLayoutRightSideBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollingLayoutRightSideBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enrolling_layout_right_side, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollingLayoutRightSideBinding bind(View r23) {
        int r1 = R.id.buttons_layout;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r23, R.id.buttons_layout);
        if (r5 == null) goto L41;
        r1 = R.id.enroll_next_finger;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r23, R.id.enroll_next_finger);
        if (r6 == null) goto L41;
        r1 = R.id.enrolling_layout;
        RelativeLayout r7 = (RelativeLayout) ViewBindings.findChildViewById(r23, R.id.enrolling_layout);
        if (r7 == null) goto L41;
        r1 = R.id.find_sensor_layout;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.find_sensor_layout);
        if (r8 == null) goto L41;
        r1 = R.id.fp_anim_finish_view;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r23, R.id.fp_anim_finish_view);
        if (r9 == null) goto L41;
        r1 = R.id.fp_anim_view;
        FrontFingerprintAnimView r10 = (FrontFingerprintAnimView) ViewBindings.findChildViewById(r23, R.id.fp_anim_view);
        if (r10 == null) goto L41;
        r1 = R.id.fp_illustration;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.fp_illustration);
        if (r11 == null) goto L41;
        r1 = R.id.fp_pulse;
        LottieAnimationView r12 = (LottieAnimationView) ViewBindings.findChildViewById(r23, R.id.fp_pulse);
        if (r12 == null) goto L41;
        r1 = R.id.fp_pulse_container;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.fp_pulse_container);
        if (r13 == null) goto L41;
        r1 = R.id.fp_result_image;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r23, R.id.fp_result_image);
        if (r14 == null) goto L41;
        r1 = R.id.goto_face_enroll;
        OButton r15 = (OButton) ViewBindings.findChildViewById(r23, R.id.goto_face_enroll);
        if (r15 == null) goto L41;
        r1 = R.id.illustration_lottie;
        LottieAnimationView r16 = (LottieAnimationView) ViewBindings.findChildViewById(r23, R.id.illustration_lottie);
        if (r16 == null) goto L41;
        r1 = R.id.progress_text;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r23, R.id.progress_text);
        if (r17 == null) goto L41;
        r1 = R.id.setup_for_payment;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r23, R.id.setup_for_payment);
        if (r18 == null) goto L41;
        r1 = R.id.tips_text;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r23, R.id.tips_text);
        if (r19 == null) goto L41;
        r1 = R.id.tips_view;
        RelativeLayout r20 = (RelativeLayout) ViewBindings.findChildViewById(r23, R.id.tips_view);
        if (r20 == null) goto L41;
        r1 = R.id.tv_find_sensor_tips;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r23, R.id.tv_find_sensor_tips);
        if (r21 == null) goto L41;
        r1 = R.id.view_title;
        OFloatingTitleBar r22 = (OFloatingTitleBar) ViewBindings.findChildViewById(r23, R.id.view_title);
        if (r22 == null) goto L41;
        return new FingerprintEnrollingLayoutRightSideBinding((RelativeLayout) r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r23.getResources().getResourceName(r1)));
    }
}
