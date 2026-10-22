package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FaceEnrollEnrollingBinding implements ViewBinding {
    public final LinearLayout buttonsLayout;
    public final OButton enrollFinish;
    public final OTextView errorText;
    public final LottieAnimationView faceDoneLottieView;
    public final ImageView faceEnrollDonePreviewImg;
    public final OTextView faceEnrollProgress;
    public final LottieAnimationView faceEnrollingLottieView;
    public final OButton gotoNext;
    public final OUIFrameLayout previewContainer;
    private final ConstraintLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FaceEnrollEnrollingBinding(ConstraintLayout r1, LinearLayout r2, OButton r3, OTextView r4, LottieAnimationView r5, ImageView r6, OTextView r7, LottieAnimationView r8, OButton r9, OUIFrameLayout r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.buttonsLayout = r2;
        this.enrollFinish = r3;
        this.errorText = r4;
        this.faceDoneLottieView = r5;
        this.faceEnrollDonePreviewImg = r6;
        this.faceEnrollProgress = r7;
        this.faceEnrollingLottieView = r8;
        this.gotoNext = r9;
        this.previewContainer = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FaceEnrollEnrollingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FaceEnrollEnrollingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.face_enroll_enrolling, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FaceEnrollEnrollingBinding bind(View r14) {
        int r0 = R.id.buttons_layout;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.buttons_layout);
        if (r4 == null) goto L25;
        r0 = R.id.enroll_finish;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r14, R.id.enroll_finish);
        if (r5 == null) goto L25;
        r0 = R.id.error_text;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r14, R.id.error_text);
        if (r6 == null) goto L25;
        r0 = R.id.face_done_lottie_view;
        LottieAnimationView r7 = (LottieAnimationView) ViewBindings.findChildViewById(r14, R.id.face_done_lottie_view);
        if (r7 == null) goto L25;
        r0 = R.id.face_enroll_done_preview_img;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r14, R.id.face_enroll_done_preview_img);
        if (r8 == null) goto L25;
        r0 = R.id.face_enroll_progress;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r14, R.id.face_enroll_progress);
        if (r9 == null) goto L25;
        r0 = R.id.face_enrolling_lottie_view;
        LottieAnimationView r10 = (LottieAnimationView) ViewBindings.findChildViewById(r14, R.id.face_enrolling_lottie_view);
        if (r10 == null) goto L25;
        r0 = R.id.goto_next;
        OButton r11 = (OButton) ViewBindings.findChildViewById(r14, R.id.goto_next);
        if (r11 == null) goto L25;
        r0 = R.id.preview_container;
        OUIFrameLayout r12 = (OUIFrameLayout) ViewBindings.findChildViewById(r14, R.id.preview_container);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new FaceEnrollEnrollingBinding((ConstraintLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
