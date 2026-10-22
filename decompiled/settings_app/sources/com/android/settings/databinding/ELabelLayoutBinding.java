package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ELabelLayoutBinding implements ViewBinding {
    public final OTextView brand;
    public final OTextView certificationCountry;
    public final OTextView cmiitId;
    public final OTextView cmmiitId2;
    public final OTextView desc;
    public final OTextView descBand;
    public final ImageView icon;
    public final ImageView mainContent;
    public final OTextView manufacturer;
    private final ConstraintLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ELabelLayoutBinding(ConstraintLayout r1, OTextView r2, OTextView r3, OTextView r4, OTextView r5, OTextView r6, OTextView r7, ImageView r8, ImageView r9, OTextView r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.brand = r2;
        this.certificationCountry = r3;
        this.cmiitId = r4;
        this.cmmiitId2 = r5;
        this.desc = r6;
        this.descBand = r7;
        this.icon = r8;
        this.mainContent = r9;
        this.manufacturer = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ELabelLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ELabelLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.e_label_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ELabelLayoutBinding bind(View r14) {
        int r0 = R.id.brand;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r14, R.id.brand);
        if (r4 == null) goto L25;
        r0 = R.id.certification_country;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r14, R.id.certification_country);
        if (r5 == null) goto L25;
        r0 = R.id.cmiit_id;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r14, R.id.cmiit_id);
        if (r6 == null) goto L25;
        r0 = R.id.cmmiit_id_2;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r14, R.id.cmmiit_id_2);
        if (r7 == null) goto L25;
        r0 = R.id.desc;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r14, R.id.desc);
        if (r8 == null) goto L25;
        r0 = R.id.desc_band;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r14, R.id.desc_band);
        if (r9 == null) goto L25;
        r0 = R.id.icon;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r14, R.id.icon);
        if (r10 == null) goto L25;
        r0 = R.id.main_content;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r14, R.id.main_content);
        if (r11 == null) goto L25;
        r0 = R.id.manufacturer;
        OTextView r12 = (OTextView) ViewBindings.findChildViewById(r14, R.id.manufacturer);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new ELabelLayoutBinding((ConstraintLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
