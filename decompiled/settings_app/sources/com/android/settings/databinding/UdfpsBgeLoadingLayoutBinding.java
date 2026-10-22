package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class UdfpsBgeLoadingLayoutBinding implements ViewBinding {
    public final View bg;
    public final Space bottomSpace;
    public final ODownloadProgressView loadingView;
    public final ImageView mainIcon;
    public final OTextView mainTitle;
    public final OTextView message;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UdfpsBgeLoadingLayoutBinding(ConstraintLayout r1, View r2, Space r3, ODownloadProgressView r4, ImageView r5, OTextView r6, OTextView r7) {
        this.rootView = r1;
        this.bg = r2;
        this.bottomSpace = r3;
        this.loadingView = r4;
        this.mainIcon = r5;
        this.mainTitle = r6;
        this.message = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UdfpsBgeLoadingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UdfpsBgeLoadingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.udfps_bge_loading_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UdfpsBgeLoadingLayoutBinding bind(View r9) {
        int r0 = R.id.bg;
        View r3 = ViewBindings.findChildViewById(r9, R.id.bg);
        if (r3 == null) goto L17;
        r0 = R.id.bottom_space;
        Space r4 = (Space) ViewBindings.findChildViewById(r9, R.id.bottom_space);
        if (r4 == null) goto L17;
        r0 = R.id.loading_view;
        ODownloadProgressView r5 = (ODownloadProgressView) ViewBindings.findChildViewById(r9, R.id.loading_view);
        if (r5 == null) goto L17;
        r0 = R.id.main_icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, R.id.main_icon);
        if (r6 == null) goto L17;
        r0 = R.id.main_title;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r9, R.id.main_title);
        if (r7 == null) goto L17;
        r0 = R.id.message;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r9, R.id.message);
        if (r8 == null) goto L17;
        return new UdfpsBgeLoadingLayoutBinding((ConstraintLayout) r9, r3, r4, r5, r6, r7, r8);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
