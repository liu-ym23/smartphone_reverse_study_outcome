package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AboutSettingsNewBinding implements ViewBinding {
    public final RelativeLayout aboutRootView;
    public final ConstraintLayout constraintRootView;
    public final OUIFrameLayout headerBg;
    public final LinearLayout itemContainer;
    public final OTextView osModelTv;
    public final OTextView osVersionTv;
    private final RelativeLayout rootView;
    public final OTextView tvProductName;
    public final OTextView tvProductNameSub;
    public final OButton updateBtn;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AboutSettingsNewBinding(RelativeLayout r1, RelativeLayout r2, ConstraintLayout r3, OUIFrameLayout r4, LinearLayout r5, OTextView r6, OTextView r7, OTextView r8, OTextView r9, OButton r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.constraintRootView = r3;
        this.headerBg = r4;
        this.itemContainer = r5;
        this.osModelTv = r6;
        this.osVersionTv = r7;
        this.tvProductName = r8;
        this.tvProductNameSub = r9;
        this.updateBtn = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AboutSettingsNewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AboutSettingsNewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.about_settings_new, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AboutSettingsNewBinding bind(View r12) {
        RelativeLayout r2 = (RelativeLayout) r12;
        int r0 = R.id.constraint_root_view;
        ConstraintLayout r3 = (ConstraintLayout) ViewBindings.findChildViewById(r12, R.id.constraint_root_view);
        if (r3 == null) goto L23;
        r0 = R.id.header_bg;
        OUIFrameLayout r4 = (OUIFrameLayout) ViewBindings.findChildViewById(r12, R.id.header_bg);
        if (r4 == null) goto L23;
        r0 = R.id.item_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.item_container);
        if (r5 == null) goto L23;
        r0 = R.id.os_model_tv;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r12, R.id.os_model_tv);
        if (r6 == null) goto L23;
        r0 = R.id.os_version_tv;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r12, R.id.os_version_tv);
        if (r7 == null) goto L23;
        r0 = R.id.tv_product_name;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r12, R.id.tv_product_name);
        if (r8 == null) goto L23;
        r0 = R.id.tv_product_name_sub;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r12, R.id.tv_product_name_sub);
        if (r9 == null) goto L23;
        r0 = R.id.update_btn;
        OButton r10 = (OButton) ViewBindings.findChildViewById(r12, R.id.update_btn);
        if (r10 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L23;
        return new AboutSettingsNewBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
