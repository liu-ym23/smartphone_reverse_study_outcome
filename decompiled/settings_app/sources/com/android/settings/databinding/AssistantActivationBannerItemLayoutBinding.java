package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class AssistantActivationBannerItemLayoutBinding implements ViewBinding {
    public final OUIConstraintLayout customBannerItemRootView;
    private final OUIConstraintLayout rootView;
    public final ImageView viewPagerIv;
    public final OTextView viewPagerSubTitle;
    public final OTextView viewPagerTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AssistantActivationBannerItemLayoutBinding(OUIConstraintLayout r1, OUIConstraintLayout r2, ImageView r3, OTextView r4, OTextView r5) {
        this.rootView = r1;
        this.customBannerItemRootView = r2;
        this.viewPagerIv = r3;
        this.viewPagerSubTitle = r4;
        this.viewPagerTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AssistantActivationBannerItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AssistantActivationBannerItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.assistant_activation_banner_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AssistantActivationBannerItemLayoutBinding bind(View r6) {
        OUIConstraintLayout r2 = (OUIConstraintLayout) r6;
        int r0 = R.id.view_pager_iv;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r6, R.id.view_pager_iv);
        if (r3 == null) goto L11;
        r0 = R.id.view_pager_sub_title;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r6, R.id.view_pager_sub_title);
        if (r4 == null) goto L11;
        r0 = R.id.view_pager_title;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r6, R.id.view_pager_title);
        if (r5 == null) goto L11;
        return new AssistantActivationBannerItemLayoutBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
