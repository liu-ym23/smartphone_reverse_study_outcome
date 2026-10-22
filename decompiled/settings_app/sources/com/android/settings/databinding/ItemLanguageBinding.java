package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUILinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemLanguageBinding implements ViewBinding {
    public final View bottomSpacer;
    public final ConstraintLayout clContentContainer;
    public final LinearLayout imageView;
    public final OUILinearLayout llRoot;
    private final LinearLayout rootView;
    public final ImageView trailingImg;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ItemLanguageBinding(LinearLayout r1, View r2, ConstraintLayout r3, LinearLayout r4, OUILinearLayout r5, ImageView r6) {
        this.rootView = r1;
        this.bottomSpacer = r2;
        this.clContentContainer = r3;
        this.imageView = r4;
        this.llRoot = r5;
        this.trailingImg = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemLanguageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemLanguageBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_language, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemLanguageBinding bind(View r8) {
        int r0 = R.id.bottom_spacer;
        View r3 = ViewBindings.findChildViewById(r8, R.id.bottom_spacer);
        if (r3 == null) goto L15;
        r0 = R.id.cl_content_container;
        ConstraintLayout r4 = (ConstraintLayout) ViewBindings.findChildViewById(r8, R.id.cl_content_container);
        if (r4 == null) goto L15;
        r0 = R.id.image_view;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.image_view);
        if (r5 == null) goto L15;
        r0 = R.id.ll_root;
        OUILinearLayout r6 = (OUILinearLayout) ViewBindings.findChildViewById(r8, R.id.ll_root);
        if (r6 == null) goto L15;
        r0 = R.id.trailing_img;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r8, R.id.trailing_img);
        if (r7 == null) goto L15;
        return new ItemLanguageBinding((LinearLayout) r8, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
