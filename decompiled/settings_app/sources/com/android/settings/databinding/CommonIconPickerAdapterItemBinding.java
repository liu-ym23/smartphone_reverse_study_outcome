package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonIconPickerAdapterItemBinding implements ViewBinding {
    public final LinearLayout bottomDiv;
    public final TextView catName;
    public final ImageView icon1;
    public final ImageView icon1Bg;
    public final FrameLayout icon1Layout;
    public final ImageView icon1Selected;
    public final ImageView icon2;
    public final ImageView icon2Bg;
    public final FrameLayout icon2Layout;
    public final ImageView icon2Selected;
    public final ImageView icon3;
    public final ImageView icon3Bg;
    public final FrameLayout icon3Layout;
    public final ImageView icon3Selected;
    public final LinearLayout iconLayout;
    public final ListContentItemCustom listItem;
    public final LinearLayout primaryPartGap;
    private final LinearLayout rootView;
    public final LinearLayout topDiv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CommonIconPickerAdapterItemBinding(LinearLayout r3, LinearLayout r4, TextView r5, ImageView r6, ImageView r7, FrameLayout r8, ImageView r9, ImageView r10, ImageView r11, FrameLayout r12, ImageView r13, ImageView r14, ImageView r15, FrameLayout r16, ImageView r17, LinearLayout r18, ListContentItemCustom r19, LinearLayout r20, LinearLayout r21) {
        this.rootView = r3;
        this.bottomDiv = r4;
        this.catName = r5;
        this.icon1 = r6;
        this.icon1Bg = r7;
        this.icon1Layout = r8;
        this.icon1Selected = r9;
        this.icon2 = r10;
        this.icon2Bg = r11;
        this.icon2Layout = r12;
        this.icon2Selected = r13;
        this.icon3 = r14;
        this.icon3Bg = r15;
        this.icon3Layout = r16;
        this.icon3Selected = r17;
        this.iconLayout = r18;
        this.listItem = r19;
        this.primaryPartGap = r20;
        this.topDiv = r21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CommonIconPickerAdapterItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CommonIconPickerAdapterItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.common_icon_picker_adapter_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CommonIconPickerAdapterItemBinding bind(View r23) {
        int r1 = R.id.bottom_div;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.bottom_div);
        if (r5 == null) goto L41;
        r1 = R.id.cat_name;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r23, R.id.cat_name);
        if (r6 == null) goto L41;
        r1 = R.id.icon_1;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_1);
        if (r7 == null) goto L41;
        r1 = R.id.icon_1_bg;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_1_bg);
        if (r8 == null) goto L41;
        r1 = R.id.icon_1_layout;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.icon_1_layout);
        if (r9 == null) goto L41;
        r1 = R.id.icon_1_selected;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_1_selected);
        if (r10 == null) goto L41;
        r1 = R.id.icon_2;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_2);
        if (r11 == null) goto L41;
        r1 = R.id.icon_2_bg;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_2_bg);
        if (r12 == null) goto L41;
        r1 = R.id.icon_2_layout;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.icon_2_layout);
        if (r13 == null) goto L41;
        r1 = R.id.icon_2_selected;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_2_selected);
        if (r14 == null) goto L41;
        r1 = R.id.icon_3;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_3);
        if (r15 == null) goto L41;
        r1 = R.id.icon_3_bg;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_3_bg);
        if (r16 == null) goto L41;
        r1 = R.id.icon_3_layout;
        FrameLayout r17 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.icon_3_layout);
        if (r17 == null) goto L41;
        r1 = R.id.icon_3_selected;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r23, R.id.icon_3_selected);
        if (r18 == null) goto L41;
        r1 = R.id.icon_layout;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.icon_layout);
        if (r19 == null) goto L41;
        r1 = R.id.list_item;
        ListContentItemCustom r20 = (ListContentItemCustom) ViewBindings.findChildViewById(r23, R.id.list_item);
        if (r20 == null) goto L41;
        r1 = R.id.primary_part_gap;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.primary_part_gap);
        if (r21 == null) goto L41;
        r1 = R.id.top_div;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.top_div);
        if (r22 == null) goto L41;
        return new CommonIconPickerAdapterItemBinding((LinearLayout) r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r23.getResources().getResourceName(r1)));
    }
}
