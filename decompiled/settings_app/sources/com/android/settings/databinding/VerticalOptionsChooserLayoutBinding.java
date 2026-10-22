package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class VerticalOptionsChooserLayoutBinding implements ViewBinding {
    public final ImageView bottomCheckIcon;
    public final ListContentItemCustom bottomOption;
    public final ImageView bottomPreview;
    public final LinearLayout dockFlipView;
    public final ImageView middleCheckIcon;
    public final ListContentItemCustom middleOption;
    public final ImageView middlePreview;
    private final LinearLayout rootView;
    public final TextView title;
    public final ImageView topCheckIcon;
    public final ListContentItemCustom topOption;
    public final ImageView topPreview;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VerticalOptionsChooserLayoutBinding(LinearLayout r1, ImageView r2, ListContentItemCustom r3, ImageView r4, LinearLayout r5, ImageView r6, ListContentItemCustom r7, ImageView r8, TextView r9, ImageView r10, ListContentItemCustom r11, ImageView r12) {
        this.rootView = r1;
        this.bottomCheckIcon = r2;
        this.bottomOption = r3;
        this.bottomPreview = r4;
        this.dockFlipView = r5;
        this.middleCheckIcon = r6;
        this.middleOption = r7;
        this.middlePreview = r8;
        this.title = r9;
        this.topCheckIcon = r10;
        this.topOption = r11;
        this.topPreview = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VerticalOptionsChooserLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VerticalOptionsChooserLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vertical_options_chooser_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VerticalOptionsChooserLayoutBinding bind(View r15) {
        int r0 = R.id.bottom_check_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r15, R.id.bottom_check_icon);
        if (r4 == null) goto L25;
        r0 = R.id.bottom_option;
        ListContentItemCustom r5 = (ListContentItemCustom) ViewBindings.findChildViewById(r15, R.id.bottom_option);
        if (r5 == null) goto L25;
        r0 = R.id.bottom_preview;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r15, R.id.bottom_preview);
        if (r6 == null) goto L25;
        LinearLayout r7 = (LinearLayout) r15;
        r0 = R.id.middle_check_icon;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r15, R.id.middle_check_icon);
        if (r8 == null) goto L25;
        r0 = R.id.middle_option;
        ListContentItemCustom r9 = (ListContentItemCustom) ViewBindings.findChildViewById(r15, R.id.middle_option);
        if (r9 == null) goto L25;
        r0 = R.id.middle_preview;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r15, R.id.middle_preview);
        if (r10 == null) goto L25;
        r0 = R.id.title;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r15, R.id.title);
        if (r11 == null) goto L25;
        r0 = R.id.top_check_icon;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r15, R.id.top_check_icon);
        if (r12 == null) goto L25;
        r0 = R.id.top_option;
        ListContentItemCustom r13 = (ListContentItemCustom) ViewBindings.findChildViewById(r15, R.id.top_option);
        if (r13 == null) goto L25;
        r0 = R.id.top_preview;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r15, R.id.top_preview);
        if (r14 == null) goto L25;
        return new VerticalOptionsChooserLayoutBinding(r7, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
