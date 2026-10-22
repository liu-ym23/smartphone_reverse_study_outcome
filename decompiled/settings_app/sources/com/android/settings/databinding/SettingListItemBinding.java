package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingListItemBinding implements ViewBinding {
    public final LinearLayout contentView;
    public final FrameLayout flContentElement;
    public final OSwitch itemSwitch;
    public final LinearLayout itemSwitchContain;
    public final ImageView ivContentImg;
    public final CardView ivContentImgBackground;
    public final ImageView ivContentInfoImg;
    public final ImageView ivTitleInfoImg;
    private final LinearLayout rootView;
    public final LinearLayout settingItem;
    public final LinearLayout tailContail;
    public final ImageView trailingTips;
    public final OTextView tvContentSubtitle;
    public final OTextView tvContentTailtitle;
    public final OTextView tvContentTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingListItemBinding(LinearLayout r1, LinearLayout r2, FrameLayout r3, OSwitch r4, LinearLayout r5, ImageView r6, CardView r7, ImageView r8, ImageView r9, LinearLayout r10, LinearLayout r11, ImageView r12, OTextView r13, OTextView r14, OTextView r15) {
        this.rootView = r1;
        this.contentView = r2;
        this.flContentElement = r3;
        this.itemSwitch = r4;
        this.itemSwitchContain = r5;
        this.ivContentImg = r6;
        this.ivContentImgBackground = r7;
        this.ivContentInfoImg = r8;
        this.ivTitleInfoImg = r9;
        this.settingItem = r10;
        this.tailContail = r11;
        this.trailingTips = r12;
        this.tvContentSubtitle = r13;
        this.tvContentTailtitle = r14;
        this.tvContentTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingListItemBinding bind(View r19) {
        int r1 = R.id.content_view;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.content_view);
        if (r5 == null) goto L31;
        r1 = R.id.fl_content_element;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r19, R.id.fl_content_element);
        if (r6 == null) goto L31;
        r1 = R.id.item_switch;
        OSwitch r7 = (OSwitch) ViewBindings.findChildViewById(r19, R.id.item_switch);
        if (r7 == null) goto L31;
        r1 = R.id.item_switch_contain;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.item_switch_contain);
        if (r8 == null) goto L31;
        r1 = R.id.iv_content_img;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r19, R.id.iv_content_img);
        if (r9 == null) goto L31;
        r1 = R.id.iv_content_img_background;
        CardView r10 = (CardView) ViewBindings.findChildViewById(r19, R.id.iv_content_img_background);
        if (r10 == null) goto L31;
        r1 = R.id.iv_content_info_img;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r19, R.id.iv_content_info_img);
        if (r11 == null) goto L31;
        r1 = R.id.iv_title_info_img;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r19, R.id.iv_title_info_img);
        if (r12 == null) goto L31;
        LinearLayout r13 = (LinearLayout) r19;
        r1 = R.id.tail_contail;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.tail_contail);
        if (r14 == null) goto L31;
        r1 = R.id.trailingTips;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r19, R.id.trailingTips);
        if (r15 == null) goto L31;
        r1 = R.id.tv_content_subtitle;
        OTextView r16 = (OTextView) ViewBindings.findChildViewById(r19, R.id.tv_content_subtitle);
        if (r16 == null) goto L31;
        r1 = R.id.tv_content_tailtitle;
        OTextView r17 = (OTextView) ViewBindings.findChildViewById(r19, R.id.tv_content_tailtitle);
        if (r17 == null) goto L31;
        r1 = R.id.tv_content_title;
        OTextView r18 = (OTextView) ViewBindings.findChildViewById(r19, R.id.tv_content_title);
        if (r18 == null) goto L31;
        return new SettingListItemBinding(r13, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
