package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewBannerGuaranteeBinding implements ViewBinding {
    public final OTextView card;
    public final OTextView deviceName;
    public final OTextView errorText;
    public final OTextView expiredDate;
    public final OTextView expiredDateTitle;
    public final OTextView imeiTitle;
    public final OTextView imeiTv;
    public final ODownloadProgressView loadingProgress;
    public final OUIFrameLayout mainBg;
    private final ConstraintLayout rootView;
    public final OTextView stateTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewBannerGuaranteeBinding(ConstraintLayout r1, OTextView r2, OTextView r3, OTextView r4, OTextView r5, OTextView r6, OTextView r7, OTextView r8, ODownloadProgressView r9, OUIFrameLayout r10, OTextView r11) {
        this.rootView = r1;
        this.card = r2;
        this.deviceName = r3;
        this.errorText = r4;
        this.expiredDate = r5;
        this.expiredDateTitle = r6;
        this.imeiTitle = r7;
        this.imeiTv = r8;
        this.loadingProgress = r9;
        this.mainBg = r10;
        this.stateTv = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewBannerGuaranteeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewBannerGuaranteeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_banner_guarantee, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewBannerGuaranteeBinding bind(View r14) {
        int r0 = R.id.card;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r14, R.id.card);
        if (r4 == null) goto L25;
        r0 = R.id.device_name;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r14, R.id.device_name);
        if (r5 == null) goto L25;
        r0 = R.id.error_text;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r14, R.id.error_text);
        if (r6 == null) goto L25;
        r0 = R.id.expired_date;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r14, R.id.expired_date);
        if (r7 == null) goto L25;
        r0 = R.id.expired_date_title;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r14, R.id.expired_date_title);
        if (r8 == null) goto L25;
        r0 = R.id.imei_title;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r14, R.id.imei_title);
        if (r9 == null) goto L25;
        r0 = R.id.imei_tv;
        OTextView r10 = (OTextView) ViewBindings.findChildViewById(r14, R.id.imei_tv);
        if (r10 == null) goto L25;
        r0 = R.id.loading_progress;
        ODownloadProgressView r11 = (ODownloadProgressView) ViewBindings.findChildViewById(r14, R.id.loading_progress);
        if (r11 == null) goto L25;
        r0 = R.id.main_bg;
        OUIFrameLayout r12 = (OUIFrameLayout) ViewBindings.findChildViewById(r14, R.id.main_bg);
        if (r12 == null) goto L25;
        r0 = R.id.state_tv;
        OTextView r13 = (OTextView) ViewBindings.findChildViewById(r14, R.id.state_tv);
        if (r13 == null) goto L25;
        return new ViewBannerGuaranteeBinding((ConstraintLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
