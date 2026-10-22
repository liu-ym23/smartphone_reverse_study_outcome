package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class GuaranteeLayoutBinding implements ViewBinding {
    public final LinearLayout cardContainer;
    public final LinearLayout contentLl;
    public final OCardListItem doubaoCommunity;
    public final OCardListItem doubaoForum;
    public final FrameLayout frameLayout;
    public final OUIConstraintLayout loadingCl;
    public final ODownloadProgressView loadingProgressLarge;
    public final OTextView loadingText;
    public final OTextView networkErrorText;
    public final OCardListItem officialEmail;
    public final OCardListItem officialPhone;
    public final OCardListItem officialWebsite;
    private final RelativeLayout rootView;
    public final OSectionSupportiveText tvExplanation;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem wechat;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GuaranteeLayoutBinding(RelativeLayout r3, LinearLayout r4, LinearLayout r5, OCardListItem r6, OCardListItem r7, FrameLayout r8, OUIConstraintLayout r9, ODownloadProgressView r10, OTextView r11, OTextView r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OSectionSupportiveText r16, OFloatingTitleBar r17, OCardListItem r18) {
        this.rootView = r3;
        this.cardContainer = r4;
        this.contentLl = r5;
        this.doubaoCommunity = r6;
        this.doubaoForum = r7;
        this.frameLayout = r8;
        this.loadingCl = r9;
        this.loadingProgressLarge = r10;
        this.loadingText = r11;
        this.networkErrorText = r12;
        this.officialEmail = r13;
        this.officialPhone = r14;
        this.officialWebsite = r15;
        this.tvExplanation = r16;
        this.viewTitle = r17;
        this.wechat = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GuaranteeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GuaranteeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.guarantee_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GuaranteeLayoutBinding bind(View r20) {
        int r1 = R.id.card_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.card_container);
        if (r5 == null) goto L35;
        r1 = R.id.content_ll;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.content_ll);
        if (r6 == null) goto L35;
        r1 = R.id.doubao_community;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.doubao_community);
        if (r7 == null) goto L35;
        r1 = R.id.doubao_forum;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.doubao_forum);
        if (r8 == null) goto L35;
        r1 = R.id.frameLayout;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r20, R.id.frameLayout);
        if (r9 == null) goto L35;
        r1 = R.id.loading_cl;
        OUIConstraintLayout r10 = (OUIConstraintLayout) ViewBindings.findChildViewById(r20, R.id.loading_cl);
        if (r10 == null) goto L35;
        r1 = R.id.loading_progress_large;
        ODownloadProgressView r11 = (ODownloadProgressView) ViewBindings.findChildViewById(r20, R.id.loading_progress_large);
        if (r11 == null) goto L35;
        r1 = R.id.loading_text;
        OTextView r12 = (OTextView) ViewBindings.findChildViewById(r20, R.id.loading_text);
        if (r12 == null) goto L35;
        r1 = R.id.network_error_text;
        OTextView r13 = (OTextView) ViewBindings.findChildViewById(r20, R.id.network_error_text);
        if (r13 == null) goto L35;
        r1 = R.id.official_email;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.official_email);
        if (r14 == null) goto L35;
        r1 = R.id.official_phone;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.official_phone);
        if (r15 == null) goto L35;
        r1 = R.id.official_website;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.official_website);
        if (r16 == null) goto L35;
        r1 = R.id.tv_explanation;
        OSectionSupportiveText r17 = (OSectionSupportiveText) ViewBindings.findChildViewById(r20, R.id.tv_explanation);
        if (r17 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r18 == null) goto L35;
        r1 = R.id.wechat;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.wechat);
        if (r19 == null) goto L35;
        return new GuaranteeLayoutBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
