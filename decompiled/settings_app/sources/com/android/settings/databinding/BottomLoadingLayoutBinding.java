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
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class BottomLoadingLayoutBinding implements ViewBinding {
    public final OButton actionBtn;
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

    private BottomLoadingLayoutBinding(ConstraintLayout r1, OButton r2, View r3, Space r4, ODownloadProgressView r5, ImageView r6, OTextView r7, OTextView r8) {
        this.rootView = r1;
        this.actionBtn = r2;
        this.bg = r3;
        this.bottomSpace = r4;
        this.loadingView = r5;
        this.mainIcon = r6;
        this.mainTitle = r7;
        this.message = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomLoadingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BottomLoadingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bottom_loading_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BottomLoadingLayoutBinding bind(View r11) {
        int r0 = R.id.action_btn;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r11, R.id.action_btn);
        if (r4 == null) goto L19;
        r0 = R.id.bg;
        View r5 = ViewBindings.findChildViewById(r11, R.id.bg);
        if (r5 == null) goto L19;
        r0 = R.id.bottom_space;
        Space r6 = (Space) ViewBindings.findChildViewById(r11, R.id.bottom_space);
        if (r6 == null) goto L19;
        r0 = R.id.loading_view;
        ODownloadProgressView r7 = (ODownloadProgressView) ViewBindings.findChildViewById(r11, R.id.loading_view);
        if (r7 == null) goto L19;
        r0 = R.id.main_icon;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, R.id.main_icon);
        if (r8 == null) goto L19;
        r0 = R.id.main_title;
        OTextView r9 = (OTextView) ViewBindings.findChildViewById(r11, R.id.main_title);
        if (r9 == null) goto L19;
        r0 = R.id.message;
        OTextView r10 = (OTextView) ViewBindings.findChildViewById(r11, R.id.message);
        if (r10 == null) goto L19;
        return new BottomLoadingLayoutBinding((ConstraintLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
