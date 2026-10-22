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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.ShadowFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class FaceRecognitionEnrollCompletedFragmentBinding implements ViewBinding {
    public final OButton btnDone;
    public final SettingItemSwitch itemSwitchStayInLockScreen;
    public final ImageView ivFrPreviewSuc;
    public final ShadowFrameLayout nextStepBtnGroup;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TextView tipsFacePreviewSuc;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FaceRecognitionEnrollCompletedFragmentBinding(RelativeLayout r1, OButton r2, SettingItemSwitch r3, ImageView r4, ShadowFrameLayout r5, LinearLayout r6, OScrollView r7, TextView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.btnDone = r2;
        this.itemSwitchStayInLockScreen = r3;
        this.ivFrPreviewSuc = r4;
        this.nextStepBtnGroup = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.tipsFacePreviewSuc = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FaceRecognitionEnrollCompletedFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FaceRecognitionEnrollCompletedFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.face_recognition_enroll_completed_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FaceRecognitionEnrollCompletedFragmentBinding bind(View r12) {
        int r0 = R.id.btn_done;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r12, R.id.btn_done);
        if (r4 == null) goto L21;
        r0 = R.id.item_switch_stay_in_lock_screen;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.item_switch_stay_in_lock_screen);
        if (r5 == null) goto L21;
        r0 = R.id.iv_fr_preview_suc;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_fr_preview_suc);
        if (r6 == null) goto L21;
        r0 = R.id.next_step_btn_group;
        ShadowFrameLayout r7 = (ShadowFrameLayout) ViewBindings.findChildViewById(r12, R.id.next_step_btn_group);
        if (r7 == null) goto L21;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.page_container);
        if (r8 == null) goto L21;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r12, R.id.page_scrollview);
        if (r9 == null) goto L21;
        r0 = R.id.tips_face_preview_suc;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.tips_face_preview_suc);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new FaceRecognitionEnrollCompletedFragmentBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
