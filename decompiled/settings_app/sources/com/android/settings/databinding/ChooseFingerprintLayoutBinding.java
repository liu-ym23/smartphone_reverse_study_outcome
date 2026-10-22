package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseFingerprintLayoutBinding implements ViewBinding {
    public final TextView chooseFpTips;
    public final LinearLayout fingerprintManageContainer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseFingerprintLayoutBinding(RelativeLayout r1, TextView r2, LinearLayout r3, LinearLayout r4, OScrollView r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.chooseFpTips = r2;
        this.fingerprintManageContainer = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseFingerprintLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseFingerprintLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_fingerprint_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseFingerprintLayoutBinding bind(View r9) {
        int r0 = R.id.choose_fp_tips;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.choose_fp_tips);
        if (r4 == null) goto L15;
        r0 = R.id.fingerprint_manage_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.fingerprint_manage_container);
        if (r5 == null) goto L15;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r6 == null) goto L15;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.page_scrollview);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new ChooseFingerprintLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
