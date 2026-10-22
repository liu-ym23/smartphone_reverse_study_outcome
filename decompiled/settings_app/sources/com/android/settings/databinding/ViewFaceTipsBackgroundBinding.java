package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewFaceTipsBackgroundBinding implements ViewBinding {
    public final TextView faceDataLicense;
    public final OTextView faceDataTipsTitle;
    public final LinearLayout faceEnrollContainer;
    public final OTextView faceTips2;
    public final ImageView ivFaceDataSimple;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewFaceTipsBackgroundBinding(RelativeLayout r1, TextView r2, OTextView r3, LinearLayout r4, OTextView r5, ImageView r6) {
        this.rootView = r1;
        this.faceDataLicense = r2;
        this.faceDataTipsTitle = r3;
        this.faceEnrollContainer = r4;
        this.faceTips2 = r5;
        this.ivFaceDataSimple = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewFaceTipsBackgroundBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewFaceTipsBackgroundBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_face_tips_background, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewFaceTipsBackgroundBinding bind(View r9) {
        int r0 = R.id.face_data_license;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.face_data_license);
        if (r4 == null) goto L15;
        r0 = R.id.face_data_tips_title;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r9, R.id.face_data_tips_title);
        if (r5 == null) goto L15;
        r0 = R.id.face_enroll_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.face_enroll_container);
        if (r6 == null) goto L15;
        r0 = R.id.face_tips_2;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r9, R.id.face_tips_2);
        if (r7 == null) goto L15;
        r0 = R.id.iv_face_data_simple;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_face_data_simple);
        if (r8 == null) goto L15;
        return new ViewFaceTipsBackgroundBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
