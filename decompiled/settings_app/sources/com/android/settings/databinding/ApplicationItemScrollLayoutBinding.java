package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckBoxSecurity;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationItemScrollLayoutBinding implements ViewBinding {
    public final RelativeLayout appLayout;
    public final FrameLayout iconContainer;
    public final ImageView itemCheck;
    public final OCheckBoxSecurity itemCheckbox;
    public final ImageView itemIcon;
    public final TextView itemSubtitle;
    public final TextView itemSummary;
    public final TextView itemTitle;
    public final ImageView ivDopplegangerIcon;
    private final OUIFrameLayout rootView;
    public final FrameLayout scrollDelBtn;
    public final ImageView scrollDelImg;
    public final LinearLayout scrollHandleLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ApplicationItemScrollLayoutBinding(OUIFrameLayout r1, RelativeLayout r2, FrameLayout r3, ImageView r4, OCheckBoxSecurity r5, ImageView r6, TextView r7, TextView r8, TextView r9, ImageView r10, FrameLayout r11, ImageView r12, LinearLayout r13) {
        this.rootView = r1;
        this.appLayout = r2;
        this.iconContainer = r3;
        this.itemCheck = r4;
        this.itemCheckbox = r5;
        this.itemIcon = r6;
        this.itemSubtitle = r7;
        this.itemSummary = r8;
        this.itemTitle = r9;
        this.ivDopplegangerIcon = r10;
        this.scrollDelBtn = r11;
        this.scrollDelImg = r12;
        this.scrollHandleLayout = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OUIFrameLayout getRoot() {
        return this.rootView;
    }

    public static ApplicationItemScrollLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ApplicationItemScrollLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.application_item_scroll_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ApplicationItemScrollLayoutBinding bind(View r17) {
        int r1 = R.id.app_layout;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.app_layout);
        if (r5 == null) goto L29;
        r1 = R.id.icon_container;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.icon_container);
        if (r6 == null) goto L29;
        r1 = R.id.item_check;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r17, R.id.item_check);
        if (r7 == null) goto L29;
        r1 = R.id.item_checkbox;
        OCheckBoxSecurity r8 = (OCheckBoxSecurity) ViewBindings.findChildViewById(r17, R.id.item_checkbox);
        if (r8 == null) goto L29;
        r1 = R.id.item_icon;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r17, R.id.item_icon);
        if (r9 == null) goto L29;
        r1 = R.id.item_subtitle;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r17, R.id.item_subtitle);
        if (r10 == null) goto L29;
        r1 = R.id.item_summary;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r17, R.id.item_summary);
        if (r11 == null) goto L29;
        r1 = R.id.item_title;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r17, R.id.item_title);
        if (r12 == null) goto L29;
        r1 = R.id.iv_doppleganger_icon;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r17, R.id.iv_doppleganger_icon);
        if (r13 == null) goto L29;
        r1 = R.id.scroll_del_btn;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.scroll_del_btn);
        if (r14 == null) goto L29;
        r1 = R.id.scroll_del_img;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r17, R.id.scroll_del_img);
        if (r15 == null) goto L29;
        r1 = R.id.scroll_handle_layout;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.scroll_handle_layout);
        if (r16 == null) goto L29;
        return new ApplicationItemScrollLayoutBinding((OUIFrameLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
