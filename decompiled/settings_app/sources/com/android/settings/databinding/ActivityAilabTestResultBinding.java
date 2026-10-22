package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityAilabTestResultBinding implements ViewBinding {
    public final RelativeLayout aboutRootView;
    public final TextView ailabTestResultDesc;
    public final ImageView ailabTestResultIcon;
    public final TextView ailabTestResultTip;
    public final OButton applyAgainBtn;
    public final OButton finishBtn;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityAilabTestResultBinding(RelativeLayout r1, RelativeLayout r2, TextView r3, ImageView r4, TextView r5, OButton r6, OButton r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.ailabTestResultDesc = r3;
        this.ailabTestResultIcon = r4;
        this.ailabTestResultTip = r5;
        this.applyAgainBtn = r6;
        this.finishBtn = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAilabTestResultBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAilabTestResultBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_ailab_test_result, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityAilabTestResultBinding bind(View r9) {
        RelativeLayout r2 = (RelativeLayout) r9;
        int r0 = R.id.ailab_test_result_desc;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r9, R.id.ailab_test_result_desc);
        if (r3 == null) goto L17;
        r0 = R.id.ailab_test_result_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.ailab_test_result_icon);
        if (r4 == null) goto L17;
        r0 = R.id.ailab_test_result_tip;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, R.id.ailab_test_result_tip);
        if (r5 == null) goto L17;
        r0 = R.id.apply_again_btn;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r9, R.id.apply_again_btn);
        if (r6 == null) goto L17;
        r0 = R.id.finish_btn;
        OButton r7 = (OButton) ViewBindings.findChildViewById(r9, R.id.finish_btn);
        if (r7 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L17;
        return new ActivityAilabTestResultBinding(r2, r2, r3, r4, r5, r6, r7, r8);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
