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
import com.android.settings.R;
import com.android.settings.widget.BackFingerprintAnimView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollingLayoutBackBinding implements ViewBinding {
    public final TextView addAnotherFingerTv;
    public final RelativeLayout enrollingLayout;
    public final LinearLayout findSensorLayout;
    public final OButton fingerAddCompleted;
    public final ImageView fpAnimFinishView;
    public final BackFingerprintAnimView fpAnimView;
    public final FrameLayout fpIllustration;
    public final ImageView fpResultImage;
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

    private FingerprintEnrollingLayoutBackBinding(RelativeLayout r1, TextView r2, RelativeLayout r3, LinearLayout r4, OButton r5, ImageView r6, BackFingerprintAnimView r7, FrameLayout r8, ImageView r9, TextView r10, TextView r11, TextView r12, RelativeLayout r13, TextView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.addAnotherFingerTv = r2;
        this.enrollingLayout = r3;
        this.findSensorLayout = r4;
        this.fingerAddCompleted = r5;
        this.fpAnimFinishView = r6;
        this.fpAnimView = r7;
        this.fpIllustration = r8;
        this.fpResultImage = r9;
        this.progressText = r10;
        this.setupForPayment = r11;
        this.tipsText = r12;
        this.tipsView = r13;
        this.tvFindSensorTips = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollingLayoutBackBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollingLayoutBackBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enrolling_layout_back, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollingLayoutBackBinding bind(View r19) {
        int r1 = R.id.add_another_finger_tv;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r19, R.id.add_another_finger_tv);
        if (r5 == null) goto L33;
        r1 = R.id.enrolling_layout;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r19, R.id.enrolling_layout);
        if (r6 == null) goto L33;
        r1 = R.id.find_sensor_layout;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.find_sensor_layout);
        if (r7 == null) goto L33;
        r1 = R.id.finger_add_completed;
        OButton r8 = (OButton) ViewBindings.findChildViewById(r19, R.id.finger_add_completed);
        if (r8 == null) goto L33;
        r1 = R.id.fp_anim_finish_view;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r19, R.id.fp_anim_finish_view);
        if (r9 == null) goto L33;
        r1 = R.id.fp_anim_view;
        BackFingerprintAnimView r10 = (BackFingerprintAnimView) ViewBindings.findChildViewById(r19, R.id.fp_anim_view);
        if (r10 == null) goto L33;
        r1 = R.id.fp_illustration;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r19, R.id.fp_illustration);
        if (r11 == null) goto L33;
        r1 = R.id.fp_result_image;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r19, R.id.fp_result_image);
        if (r12 == null) goto L33;
        r1 = R.id.progress_text;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r19, R.id.progress_text);
        if (r13 == null) goto L33;
        r1 = R.id.setup_for_payment;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r19, R.id.setup_for_payment);
        if (r14 == null) goto L33;
        r1 = R.id.tips_text;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r19, R.id.tips_text);
        if (r15 == null) goto L33;
        r1 = R.id.tips_view;
        RelativeLayout r16 = (RelativeLayout) ViewBindings.findChildViewById(r19, R.id.tips_view);
        if (r16 == null) goto L33;
        r1 = R.id.tv_find_sensor_tips;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r19, R.id.tv_find_sensor_tips);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new FingerprintEnrollingLayoutBackBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
