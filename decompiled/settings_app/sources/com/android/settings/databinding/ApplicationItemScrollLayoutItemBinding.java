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
import com.obric.oui.button.OIconButton;
import com.obric.oui.checkbox.OCheckBoxSecurity;

/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationItemScrollLayoutItemBinding implements ViewBinding {
    public final RelativeLayout appLayout;
    public final FrameLayout iconContainer;
    public final ImageView itemCheck;
    public final OCheckBoxSecurity itemCheckbox;
    public final OIconButton itemIcon;
    public final TextView itemSubtitle;
    public final TextView itemSummary;
    public final TextView itemTitle;
    public final ImageView ivDopplegangerIcon;
    private final View rootView;
    public final FrameLayout scrollDelBtn;
    public final ImageView scrollDelImg;
    public final LinearLayout scrollHandleLayout;

    private ApplicationItemScrollLayoutItemBinding(View r1, RelativeLayout r2, FrameLayout r3, ImageView r4, OCheckBoxSecurity r5, OIconButton r6, TextView r7, TextView r8, TextView r9, ImageView r10, FrameLayout r11, ImageView r12, LinearLayout r13) {
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
    public View getRoot() {
        return this.rootView;
    }

    public static ApplicationItemScrollLayoutItemBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.application_item_scroll_layout_item, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static ApplicationItemScrollLayoutItemBinding bind(View r15) {
        int r0 = R.id.app_layout;
        RelativeLayout r2 = (RelativeLayout) ViewBindings.findChildViewById(r15, R.id.app_layout);
        if (r2 == null) goto L29;
        r0 = R.id.icon_container;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r15, R.id.icon_container);
        if (r3 == null) goto L29;
        r0 = R.id.item_check;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r15, R.id.item_check);
        if (r4 == null) goto L29;
        r0 = R.id.item_checkbox;
        OCheckBoxSecurity r5 = (OCheckBoxSecurity) ViewBindings.findChildViewById(r15, R.id.item_checkbox);
        if (r5 == null) goto L29;
        r0 = R.id.item_icon;
        OIconButton r6 = (OIconButton) ViewBindings.findChildViewById(r15, R.id.item_icon);
        if (r6 == null) goto L29;
        r0 = R.id.item_subtitle;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, R.id.item_subtitle);
        if (r7 == null) goto L29;
        r0 = R.id.item_summary;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, R.id.item_summary);
        if (r8 == null) goto L29;
        r0 = R.id.item_title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, R.id.item_title);
        if (r9 == null) goto L29;
        r0 = R.id.iv_doppleganger_icon;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r15, R.id.iv_doppleganger_icon);
        if (r10 == null) goto L29;
        r0 = R.id.scroll_del_btn;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r15, R.id.scroll_del_btn);
        if (r11 == null) goto L29;
        r0 = R.id.scroll_del_img;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r15, R.id.scroll_del_img);
        if (r12 == null) goto L29;
        r0 = R.id.scroll_handle_layout;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.scroll_handle_layout);
        if (r13 == null) goto L29;
        return new ApplicationItemScrollLayoutItemBinding(r15, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
