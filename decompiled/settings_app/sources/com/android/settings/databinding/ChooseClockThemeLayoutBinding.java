package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseClockThemeLayoutBinding implements ViewBinding {
    public final ImageView firstCheckIcon;
    public final ListContentItemCustom firstOption;
    public final ImageView firstPreview;
    public final ImageView fourthCheckIcon;
    public final ListContentItemCustom fourthOption;
    public final ImageView fourthPreview;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final ImageView secondCheckIcon;
    public final ListContentItemCustom secondOption;
    public final ImageView secondPreview;
    public final ImageView thirdCheckIcon;
    public final ListContentItemCustom thirdOption;
    public final ImageView thirdPreview;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseClockThemeLayoutBinding(RelativeLayout r3, ImageView r4, ListContentItemCustom r5, ImageView r6, ImageView r7, ListContentItemCustom r8, ImageView r9, LinearLayout r10, OScrollView r11, ImageView r12, ListContentItemCustom r13, ImageView r14, ImageView r15, ListContentItemCustom r16, ImageView r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.firstCheckIcon = r4;
        this.firstOption = r5;
        this.firstPreview = r6;
        this.fourthCheckIcon = r7;
        this.fourthOption = r8;
        this.fourthPreview = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.secondCheckIcon = r12;
        this.secondOption = r13;
        this.secondPreview = r14;
        this.thirdCheckIcon = r15;
        this.thirdOption = r16;
        this.thirdPreview = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseClockThemeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseClockThemeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_clock_theme_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseClockThemeLayoutBinding bind(View r20) {
        int r1 = R.id.first_check_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r20, R.id.first_check_icon);
        if (r5 == null) goto L35;
        r1 = R.id.first_option;
        ListContentItemCustom r6 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.first_option);
        if (r6 == null) goto L35;
        r1 = R.id.first_preview;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r20, R.id.first_preview);
        if (r7 == null) goto L35;
        r1 = R.id.fourth_check_icon;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r20, R.id.fourth_check_icon);
        if (r8 == null) goto L35;
        r1 = R.id.fourth_option;
        ListContentItemCustom r9 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.fourth_option);
        if (r9 == null) goto L35;
        r1 = R.id.fourth_preview;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r20, R.id.fourth_preview);
        if (r10 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r11 == null) goto L35;
        r1 = R.id.page_scrollview;
        OScrollView r12 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r12 == null) goto L35;
        r1 = R.id.second_check_icon;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r20, R.id.second_check_icon);
        if (r13 == null) goto L35;
        r1 = R.id.second_option;
        ListContentItemCustom r14 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.second_option);
        if (r14 == null) goto L35;
        r1 = R.id.second_preview;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r20, R.id.second_preview);
        if (r15 == null) goto L35;
        r1 = R.id.third_check_icon;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r20, R.id.third_check_icon);
        if (r16 == null) goto L35;
        r1 = R.id.third_option;
        ListContentItemCustom r17 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.third_option);
        if (r17 == null) goto L35;
        r1 = R.id.third_preview;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r20, R.id.third_preview);
        if (r18 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L35;
        return new ChooseClockThemeLayoutBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
