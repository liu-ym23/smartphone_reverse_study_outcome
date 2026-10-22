package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FaceEnrollProgressView;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FaceEnrollLayoutBinding implements ViewBinding {
    public final OButton enrollFinish;
    public final OTextView faceEnrollFeedback;
    public final ImageView faceEnrollFinish;
    public final OTextView faceEnrollProgress;
    public final FaceEnrollProgressView faceEnrollProgressView;
    public final OTextView faceEnrollTip;
    private final RelativeLayout rootView;
    public final SurfaceView surfaceCamera;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FaceEnrollLayoutBinding(RelativeLayout r1, OButton r2, OTextView r3, ImageView r4, OTextView r5, FaceEnrollProgressView r6, OTextView r7, SurfaceView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.enrollFinish = r2;
        this.faceEnrollFeedback = r3;
        this.faceEnrollFinish = r4;
        this.faceEnrollProgress = r5;
        this.faceEnrollProgressView = r6;
        this.faceEnrollTip = r7;
        this.surfaceCamera = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FaceEnrollLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FaceEnrollLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.face_enroll_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FaceEnrollLayoutBinding bind(View r12) {
        int r0 = R.id.enroll_finish;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r12, R.id.enroll_finish);
        if (r4 == null) goto L21;
        r0 = R.id.face_enroll_feedback;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r12, R.id.face_enroll_feedback);
        if (r5 == null) goto L21;
        r0 = R.id.face_enroll_finish;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.face_enroll_finish);
        if (r6 == null) goto L21;
        r0 = R.id.face_enroll_progress;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r12, R.id.face_enroll_progress);
        if (r7 == null) goto L21;
        r0 = R.id.face_enroll_progress_view;
        FaceEnrollProgressView r8 = (FaceEnrollProgressView) ViewBindings.findChildViewById(r12, R.id.face_enroll_progress_view);
        if (r8 == null) goto L21;
        r0 = R.id.face_enroll_tip;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r12, R.id.face_enroll_tip);
        if (r9 == null) goto L21;
        r0 = R.id.surface_camera;
        SurfaceView r10 = (SurfaceView) ViewBindings.findChildViewById(r12, R.id.surface_camera);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new FaceEnrollLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
