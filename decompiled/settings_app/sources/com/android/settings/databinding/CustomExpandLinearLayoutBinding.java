package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.InnerExpandableLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomExpandLinearLayoutBinding implements ViewBinding {
    public final LinearLayout llDefaultItemContainer;
    public final InnerExpandableLayout llExpandLayoutContainer;
    private final View rootView;
    public final TextView tvNavbarModeSettingTitle;
    public final TextView tvPhoneCaseCategoryExpandable;

    private CustomExpandLinearLayoutBinding(View r1, LinearLayout r2, InnerExpandableLayout r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.llDefaultItemContainer = r2;
        this.llExpandLayoutContainer = r3;
        this.tvNavbarModeSettingTitle = r4;
        this.tvPhoneCaseCategoryExpandable = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static CustomExpandLinearLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.custom_expand_linear_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static CustomExpandLinearLayoutBinding bind(View r8) {
        int r0 = R.id.ll_default_item_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.ll_default_item_container);
        if (r4 == null) goto L13;
        r0 = R.id.ll_expand_layout_container;
        InnerExpandableLayout r5 = (InnerExpandableLayout) ViewBindings.findChildViewById(r8, R.id.ll_expand_layout_container);
        if (r5 == null) goto L13;
        r0 = R.id.tv_navbar_mode_setting_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.tv_navbar_mode_setting_title);
        if (r6 == null) goto L13;
        r0 = R.id.tv_phone_case_category_expandable;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.tv_phone_case_category_expandable);
        if (r7 == null) goto L13;
        return new CustomExpandLinearLayoutBinding(r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
